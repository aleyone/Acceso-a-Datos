package es.addbl3.AE3;

import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		Libro milibro = new Libro(1, "titulo1", "autor1", "a�o1", "editorial1", "muchas paginas");
		milibro.recuperarTodos();
		Scanner teclado = new Scanner(System.in);
		String respuesta = "";
		while (!respuesta.equals("6")) {
			System.out.println(
					"1. Mostrar todos los t�tulos de la biblioteca\n" + "2. Mostrar informaci�n detallada de un libro\n"
							+ "3. Crear un nuevo libro\n" + "4. Actualizar libro\n" + "5. Borrar libro\n"
							+ "6. Cerrar la biblioteca\n\n" + "Elige una opci�n: ");
			respuesta = teclado.nextLine();

			switch (respuesta) {
			case "1":
				milibro.recuperarTodos();
				break;
			case "2":
				System.out.print("Dime el id del libro: ");
				int dimeID1 = Integer.valueOf(teclado.nextLine());
				milibro.mostrarLibro(milibro.recuperarLibro(dimeID1));
				break;
			case "3":
				System.out.println("Crear libro");
				System.out.print("Introduce el ID: ");
				int dimeID = Integer.valueOf(teclado.nextLine());
				System.out.print("Introduce el t�tulo: ");
				String dimeNombre = teclado.nextLine();
				System.out.print("Introduce el autor: ");
				String dimeAutor = teclado.nextLine();
				System.out.print("Introduce el a�o: ");
				String dimeA�o = teclado.nextLine();
				System.out.print("Introduce el editorial: ");
				String dimeEditorial = teclado.nextLine();
				System.out.print("Introduce el n�mero de p�ginas: ");
				String dimePaginas = teclado.nextLine();
				Libro newLibro = new Libro(dimeID, dimeNombre, dimeAutor, dimeA�o, dimeEditorial, dimePaginas);
				newLibro.crearLibro(newLibro);
				break;
			case "4":
				System.out.print("Dime el id del libro: ");
				int dimeID3 = Integer.valueOf(teclado.nextLine());
				milibro.actualizarLibro(dimeID3);
				break;
			case "5":
				System.out.print("Dime el id del libro: ");
				int dimeID2 = Integer.valueOf(teclado.nextLine());
				milibro.borrarLibro(dimeID2);
				break;
			case "6":
				System.out.println("Hasta pronto!");
				break;
			default:
				System.out.println("Opci�n no v�lida");

			}

		}
	}
}
