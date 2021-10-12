package es.add.aev2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Controlador {
	private Vista vista;
	private Modelo modelo;
	private ActionListener actionListenerBuscar;
	private ActionListener actionListenerReemplazar;
	private String ficheroLectura;
	private String ficheroEscritura;

	public Controlador(Vista vista, Modelo modelo) {
		this.vista = vista;
		this.modelo = modelo;
		initEventHandlers();
	}

	/**
	 * función de control - igualamos ficheroLectura y ficheroEscritura al valor
	 * devuelto por los getters de modelo - mostramos por pantalla el ficheroLectura
	 * en el textArea 1 - definimos el botón buscar y le asignamos la funcionalidad
	 * de buscar palabra, pasándole como palabra la que se encuentre en el
	 * textfieldbuscar - definimos el botón reemplazar que escribe el fichero nuevo
	 * pasándole la palabra original, la palabra reemplazada y el nombre de fichero
	 * de escritura - por último en ese botón también asignamos la funcionalidad de
	 * mostrar ese fichero en el textArea 2
	 * 
	 */
	public void initEventHandlers() {
		ficheroLectura = modelo.ficheroLectura();
		ficheroEscritura = modelo.ficheroEscritura();
		mostrarFicheroLectura(ficheroLectura, 1);

		ActionListener actionListenerBuscar = new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				modelo.buscarPalabra(vista.getTextFieldBuscar().getText());
			}
		};
		vista.getBtnBuscar().addActionListener(actionListenerBuscar);

		ActionListener actionListenerReemplazar = new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				modelo.escribimosFichero(vista.getTextFieldBuscar().getText(), vista.getTextFieldReemplazar().getText(),
						ficheroEscritura);
				mostrarFicheroLectura(ficheroEscritura, 2);
			}
		};
		vista.getBtnReemplazar().addActionListener(actionListenerReemplazar);

	}

	/**
	 * función para mostrar el array original o el array modificado en el text area
	 * correspondiente
	 * 
	 * @param fichero se le pasa fichero original o fichero modificado
	 * @param numArea se le pasa el área donde debe mostrar el texto
	 */
	public void mostrarFicheroLectura(String fichero, int numArea) {
		ArrayList<String> arrayLineas = modelo.contenidoFichero(fichero);
		for (String lineas : arrayLineas) {
			if (numArea == 1) {
				vista.getTextAreaOriginal().append(lineas + "\n");
			} else
				vista.getTextAreaModificado().append(lineas + "\n");
		}

	}

}
