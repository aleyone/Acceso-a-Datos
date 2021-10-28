package es.addbl3.AE3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

class Libro {
	private int identificador;
	private String titulo, autor, a�o, editorial, numpag;

	Libro(int identificador, String titulo, String autor, String a�o, String editorial, String numpag) {
		this.identificador = identificador;
		this.titulo = titulo;
		this.autor = autor;
		this.a�o = a�o;
		this.editorial = editorial;
		this.numpag = numpag;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public void setA�o(String a�o) {
		this.a�o = a�o;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public void setNumPag(String numpag) {
		this.numpag = numpag;
	}

	/**
	 * recuperamos y almacenamos el XML, se crea el nuevo libro y se almacena en la
	 * lista para posteriormente guardarlo en el XML
	 * 
	 * @param libro se le pasa los datos de libro nuevo para crear el objeto
	 * @return se retorna el identificador
	 */
	public int crearLibro(Libro libro) {
		ArrayList<Libro> listado = recuperarTodos();
		Libro newLibro = new Libro(libro.identificador, libro.titulo, libro.autor, libro.a�o, libro.editorial,
				libro.numpag);
		listado.add(newLibro);
		guardarXML(listado);
		return libro.identificador;
	}

	/**
	 * desde un identificador recuperamos un objeto de tipo libro. Con el puntero
	 * identificamos la posici�n en la lista para retornarlo
	 * 
	 * @param identificador se pasa el identificador
	 * @return retornamos el libro
	 */
	public Libro recuperarLibro(int identificador) {
		ArrayList<Libro> miListado = recuperarTodos();
		int puntero = 0;
		Libro resultado;
		for (int i = 0; i < miListado.size(); i++) {
			if (miListado.get(i).identificador == identificador) {
				puntero = i;
			}
		}
		resultado = miListado.get(puntero);

		return resultado;
	}

	/**
	 * este m�todo est� relacionado con el anterior, ya que recoge el libro que
	 * devuelve recuperarLibro y muestra el detalle
	 * 
	 * @param libro le pasamos el libro desde la clase main dentro de recuperarLibro
	 */
	public void mostrarLibro(Libro libro) {
		System.out.println("Id: " + String.valueOf(libro.identificador) + "\nT�tulo: " + libro.titulo + "\nAutor: "
				+ libro.autor + "\nA�o: " + libro.a�o + "\nEditorial: " + libro.editorial + "\nN� p�ginas: "
				+ libro.numpag + "\n");
	}

	/**
	 * desde el identificador, recuperamos el listado de libros, lo recorremos y
	 * eliminamos la posici�n deseada. Posteriormente se guarda el nuevo XML sin el
	 * libro eliminado
	 * 
	 * @param identificador le pasamos el identificador
	 */
	public void borrarLibro(int identificador) {
		ArrayList<Libro> miListado = recuperarTodos();
		for (int i = 0; i < miListado.size(); i++) {
			if (miListado.get(i).identificador == identificador) {
				miListado.remove(miListado.get(i));
			}
		}
		guardarXML(miListado);
	}

	/**
	 * desde el identificador, ofrecemos al usuario saber qu� datos del libro desea
	 * editar. Puede realizar varios cambios y �stos se guardar�n cuando se finalice
	 * la edici�n.
	 * 
	 * @param identificador recoge el identificador
	 */
	public void actualizarLibro(int identificador) {
		ArrayList<Libro> miListado = recuperarTodos();
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String eleccion = "";
		int puntero = 0;
		for (int i = 0; i < miListado.size(); i++) {
			if (miListado.get(i).identificador == identificador) {
				puntero = i;
			}
		}
		while (!eleccion.equals("F")) {
			System.out.println("�Qu� quieres modificar?");
			System.out.print(
					"T - T�tulo\nA - Autor\nY - A�o\nE - Editorial\nN - N�mero de p�ginas\nF - Fin de la edici�n\n");

			try {
				eleccion = br.readLine();

				switch (eleccion) {
				case "T":
					System.out.println("Introduce nuevo t�tulo: ");
					miListado.get(puntero).setTitulo(br.readLine());
					break;
				case "A":
					System.out.println("Introduce nuevo autor: ");
					miListado.get(puntero).setAutor(br.readLine());
					break;
				case "Y":
					System.out.println("Introduce nuevo a�o: ");
					miListado.get(puntero).setA�o(br.readLine());
					break;
				case "E":
					System.out.println("Introduce nueva editorial: ");
					miListado.get(puntero).setEditorial(br.readLine());
					break;
				case "N":
					System.out.println("Introduce nuevo n�mero de p�ginas: ");
					miListado.get(puntero).setNumPag(br.readLine());
					break;
				case "F":
					guardarXML(miListado);
					break;
				default:
					System.out.println("Opci�n no v�lida.\n");
					break;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * se recupera el XML y se introduce en un listado de objetos de tipo Libro
	 * 
	 * @return retorna el listado de objetos para luego ser llamado desde otros
	 *         m�todos
	 */
	public ArrayList<Libro> recuperarTodos() {
		ArrayList<Libro> listado = new ArrayList<Libro>();
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(new File("biblioteca.xml"));
			Element raiz = doc.getDocumentElement();
			NodeList nodeList = doc.getElementsByTagName("libro");
			for (int i = 0; i < nodeList.getLength(); i++) {
				Node node = nodeList.item(i);
				Element element = (Element) node;
				int id = Integer.parseInt(element.getElementsByTagName("identificador").item(0).getTextContent());
				String tit = element.getElementsByTagName("titulo").item(0).getTextContent();
				String aut = element.getElementsByTagName("autor").item(0).getTextContent();
				String any = element.getElementsByTagName("a�o").item(0).getTextContent();
				String edit = element.getElementsByTagName("editorial").item(0).getTextContent();
				String nump = element.getElementsByTagName("numpag").item(0).getTextContent();
				Libro librosXML = new Libro(id, tit, aut, any, edit, nump);
				listado.add(librosXML);
			}

		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
//		for (Libro libros : listado) {
//			this.mostrarLibro(libros);
//		}

		return listado;
	}

	/**
	 * el m�todo guarda en un fichero XML el contenido de la lista de objetos que se
	 * le pase. Es invocado desde varios m�todos. Al crear un libro, actualizar o
	 * borrar, se le pasa el listado resultante para que lo guarde
	 * 
	 * @param arrayLibros
	 */
	public void guardarXML(ArrayList<Libro> arrayLibros) {
		try {
			DocumentBuilderFactory dFact = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuild = dFact.newDocumentBuilder();
			Document doc = dBuild.newDocument();
			Element raiz = doc.createElement("biblioteca");
			doc.appendChild(raiz);
			for (int i = 0; i < arrayLibros.size(); i++) {
				Element libro1 = doc.createElement("libro");
				raiz.appendChild(libro1);
				Element id = doc.createElement("identificador");
				id.appendChild(doc.createTextNode(String.valueOf(arrayLibros.get(i).identificador)));
				libro1.appendChild(id);
				Element titulo = doc.createElement("titulo");
				titulo.appendChild(doc.createTextNode(String.valueOf(arrayLibros.get(i).titulo)));
				libro1.appendChild(titulo);
				Element autor = doc.createElement("autor");
				autor.appendChild(doc.createTextNode(String.valueOf(arrayLibros.get(i).autor)));
				libro1.appendChild(autor);
				Element a�o = doc.createElement("a�o");
				a�o.appendChild(doc.createTextNode(String.valueOf(arrayLibros.get(i).a�o)));
				libro1.appendChild(a�o);
				Element editorial = doc.createElement("editorial");
				editorial.appendChild(doc.createTextNode(String.valueOf(arrayLibros.get(i).editorial)));
				libro1.appendChild(editorial);
				Element numpag = doc.createElement("numpag");
				numpag.appendChild(doc.createTextNode(String.valueOf(arrayLibros.get(i).numpag)));
				libro1.appendChild(numpag);
			}

			TransformerFactory tranFactory = TransformerFactory.newInstance();
			Transformer aTrans = tranFactory.newTransformer();
			aTrans.setOutputProperty(OutputKeys.ENCODING, "ISO-8859-1");
			aTrans.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
			aTrans.setOutputProperty(OutputKeys.INDENT, "yes");
			DOMSource source = new DOMSource(doc);
			try {
				FileWriter fw = new FileWriter("biblioteca.xml");
				StreamResult result = new StreamResult(fw);
				aTrans.transform(source, result);

			} catch (IOException e) {
				e.printStackTrace();
			} catch (TransformerException e) {
				e.printStackTrace();
			}

		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		}
	}

}
