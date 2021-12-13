package es.maven.actividadEvaluable5;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import org.hibernate.Session;

public class Controlador {
	private Modelo modelo;
	private Vista vista;
	private ActionListener alCreateConnection, alCloseConnection, alShowAll, alShowOne, alDeleteOne, alUpdate,
			alCreateBook, alLoadID, alRemoveID;
	private List listBook;

	public Controlador(Modelo modelo, Vista vista) {
		this.modelo = modelo;
		this.vista = vista;
		control();
	}

	public void control() {
		alCreateConnection = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				Session session = modelo.createConnection();
				listBook=(modelo.listBooks(session));
				vista.getTextArea().setText("Se ha creado correctamente la conexión a la base de datos.\nPara modificar un registro, introduce el ID y pulsa el '+'");
				}
		};
		vista.getBtnCreateConnection().addActionListener(alCreateConnection);

		alCloseConnection = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				vista.getTextArea().setText(null);
				Session session = modelo.createConnection();
				modelo.closeSession(session, listBook);
				vista.getTextArea().setText("Se ha desconectado de la base de datos.");
			}
		};
		vista.getBtnCloseConnection().addActionListener(alCloseConnection);
		
		alShowAll = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				vista.getTextArea().setText(null);
				Session session = modelo.createConnection();
				vista.getTextArea().setText(modelo.showBooks(session, listBook));
				
			}
		};
		vista.getBtnShowBooks().addActionListener(alShowAll);
		
		alRemoveID = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				vista.getTextArea().setText(null);
				vista.getTextField_Titulo().setText(null);
				vista.getTextField_Autor().setText(null);
				vista.getTextField_AñoN().setText(null);
				vista.getTextField_AñoP().setText(null);
				vista.getTextField_Editorial().setText(null);
				vista.getTextField_Pag().setText(null);
				
			}
		};
		vista.getBtnRemoveId().addActionListener(alRemoveID);
		
		alLoadID = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				vista.getTextArea().setText(null);
				Session session = modelo.createConnection();
				int id = Integer.parseInt(vista.getTextField_ID().getText());
				String[] detailsBook = modelo.detailsBook(session, id);
				vista.getTextField_Titulo().setText(detailsBook[0]);
				vista.getTextField_Autor().setText(detailsBook[1]);
				vista.getTextField_AñoN().setText(detailsBook[2]);
				vista.getTextField_AñoP().setText(detailsBook[3]);
				vista.getTextField_Editorial().setText(detailsBook[4]);
				vista.getTextField_Pag().setText(detailsBook[5]);
				vista.getTextArea().setText("Se han cargado correctamente los detalles del libro");

			}
		};
		vista.getBtnLoadID().addActionListener(alLoadID);

		alShowOne = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				vista.getTextArea().setText(null);
				Session session = modelo.createConnection();
				int id = Integer.parseInt(vista.getTextField_ID().getText());
				vista.getTextArea().setText(modelo.showOneBook(session, id));
				
			}
		};
		vista.getBtnShowOneBook().addActionListener(alShowOne);
		
		alDeleteOne = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				vista.getTextArea().setText(null);
				Session session = modelo.createConnection();
				int id = Integer.parseInt(vista.getTextField_ID().getText());
				modelo.deleteBook(session, id);
				vista.getTextArea().setText("Ha sido eliminado el registro de la base de datos.");
				
			}
		};
		vista.getBtnDeleteBook().addActionListener(alDeleteOne);
		
		alUpdate = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				vista.getTextArea().setText(null);
				Session session = modelo.createConnection();
				int id = Integer.parseInt(vista.getTextField_ID().getText());
				String titulo = vista.getTextField_Titulo().getText();
				String autor = vista.getTextField_Autor().getText();
				String año_n = vista.getTextField_AñoN().getText();
				String año_p = vista.getTextField_AñoP().getText();
				String editorial = vista.getTextField_Editorial().getText();
				String num_p = vista.getTextField_Pag().getText();
				modelo.updateBook(session, id, titulo, autor, año_n, año_p, editorial, (int)Integer.parseInt(num_p));
				vista.getTextArea().setText("Ha sido modificado el registro de la base de datos.");
				
			}
		};
		vista.getBtnUpdateBook().addActionListener(alUpdate);
		
		alCreateBook = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				vista.getTextArea().setText(null);
				Session session = modelo.createConnection();
				String titulo = vista.getTextField_Titulo().getText();
				String autor = vista.getTextField_Autor().getText();
				String año_n = vista.getTextField_AñoN().getText();
				String año_p = vista.getTextField_AñoP().getText();
				String editorial = vista.getTextField_Editorial().getText();
				String num_p = vista.getTextField_Pag().getText();
				int id = modelo.createBook(session, titulo, autor, año_n, año_p, editorial, (int)Integer.parseInt(num_p));
				vista.getTextArea().setText("Ha sido añadido el registro a la base de datos. ID: "+id);
				
			}
		};
		vista.getBtnCreateBook().addActionListener(alCreateBook);
		
	}
}
