package es.add.aev2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Modelo {
	private String fichero_lectura;
	private String fichero_escritura;

	public Modelo() {
		fichero_lectura = "AE02_T1_2_Streams_Groucho.txt";
		fichero_escritura = "AE01_T1_2_Groucho_reemplazado.txt";
	}

	/**
	 * función para meter en un arraylist el contenido de un fichero
	 * 
	 * @param fichero nombre del fichero que llegará desde controlador, puede ser el
	 *                de lectura o escritura
	 * @return retorna el array que luego usará la función paraReemplazar
	 */
	public ArrayList<String> contenidoFichero(String fichero) {
		ArrayList<String> contenidoFichero = new ArrayList<String>();
		try {
			File file = new File(fichero);
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String linea = br.readLine();
			while (linea != null) {
				contenidoFichero.add(linea);
				linea = br.readLine();
			}
			br.close();
			fr.close();

		} catch (FileNotFoundException e) {

			JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
		}

		return contenidoFichero;
	}

	/**
	 * este método creará el fichero modificado, mientras escriba la línea
	 * reemplazará la palabra seleccionada
	 * 
	 * @param palabraOriginal    la palabra que indiquemos que hay que buscar
	 * @param palabraReemplazada la palabra que usaremos para reemplazar la original
	 * @param ficheroEscritura   nos indica el nombre del fichero de escritura
	 */
	public void escribimosFichero(String palabraOriginal, String palabraReemplazada, String ficheroEscritura) {

		ArrayList<String> paraReemplazar = contenidoFichero(fichero_lectura);

		try {

			File file2 = new File(ficheroEscritura);
			FileWriter fw = new FileWriter(file2);
			BufferedWriter bw = new BufferedWriter(fw);
			String linea;
			String Copialinea;
			for (int i = 0; i < paraReemplazar.size(); i++) {
				linea = paraReemplazar.get(i);

				Copialinea = linea.replaceAll(palabraOriginal, palabraReemplazada);
				bw.write(Copialinea);
				bw.newLine();

			}

			bw.close();
			fw.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
		}

	}

	/**
	 * cuenta el número de coincidencias de la palabra buscada y ese número por
	 * pantalla
	 * 
	 * @param palabra se recibe la palabra
	 * @return retornamos la palabra para si fuera necesario utilizarla más tarde
	 */
	public String buscarPalabra(String palabra) {
		int contador = 0;
		ArrayList<String> paraBuscar = contenidoFichero(fichero_lectura);
		for (int i = 0; i < paraBuscar.size() - 1; i++) {
			if (paraBuscar.get(i).contains(palabra)) {
				contador++;
			}

		}
		JOptionPane.showMessageDialog(null, "La palabra " + palabra + " se repite " + contador + " veces.");
		return palabra;
	}

	/**
	 * getter para el ficheroLectura
	 * 
	 * @return devuelve el nombre del fichero definido para la clase
	 */
	public String ficheroLectura() {
		return fichero_lectura;
	}

	/**
	 * getter para el ficheroEscritura
	 * 
	 * @return devuelve el nombre del fichero definido para la clase
	 */
	public String ficheroEscritura() {
		return fichero_escritura;
	}

}
