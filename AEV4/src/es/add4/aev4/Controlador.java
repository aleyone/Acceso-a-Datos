package es.add4.aev4;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Controlador {

	private Modelo modelo;
	private Vista2 vista;
	private ActionListener alCargarCsv;
	private ActionListener alExportarCsv;
	private ActionListener alInsertar;
	private ActionListener alConsultaLibros;
	private ActionListener alConsultaEditorial;
	private ActionListener alConsultaPersonal;
	private ActionListener alEliminar;
	private String ficheroOrigen, ficheroDestino;

	public Controlador(Modelo modelo, Vista2 vista) {
		this.modelo = modelo;
		this.vista = vista;
		control();
	}

	public void control() {
		ficheroOrigen = "AE04_T1_4_JDBC_Datos.csv";
		ficheroDestino = "export.csv";

		alCargarCsv = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				modelo.leerFichero(ficheroOrigen);
				vista.getTextArea().setText("Se ha cargado el CSV. Revisa phpMyAdmin");
			}
		};
		vista.getCargarCsv().addActionListener(alCargarCsv);

		alInsertar = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				String[] datos = { (vista.getTextTitulo().getText()), (vista.getTextAutor().getText()),
						(vista.getTextAnyoNac().getText()), (vista.getTextAnyoPub().getText()),
						(vista.getTextEditorial().getText()), (vista.getTextNPag().getText()) };
				modelo.a�adirBBDD(datos);
				vista.getTextArea().setText("Registro a�adido a tu BBDD");
				vista.getTextTitulo().setText(null);
				vista.getTextAutor().setText(null);
				vista.getTextAnyoNac().setText(null);
				vista.getTextAnyoPub().setText(null);
				vista.getTextEditorial().setText(null);
				vista.getTextNPag().setText(null);
			}
		};
		vista.getInsertar().addActionListener(alInsertar);

		alConsultaPersonal = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				vista.getTextArea().setText(null);
				String consulta = vista.getTextConsulta().getText();
				String resultadoQuery = modelo.consultaPersonalizada(consulta);
				vista.getTextArea().append((resultadoQuery));
				vista.getTextConsulta().setText(null);

			}
		};

		vista.getConsultaPersonal().addActionListener(alConsultaPersonal);

		alEliminar = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				modelo.vaciarTabla();
				vista.getTextArea().setText("Has vaciado la tabla");
			}
		};
		vista.getEliminar().addActionListener(alEliminar);

		alExportarCsv = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				modelo.exportarCSV(ficheroDestino);
				vista.getTextArea().setText("Bien, has exportado tu tabla a CSV.");
			}
		};
		vista.getExportarCsv().addActionListener(alExportarCsv);

		alConsultaLibros = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				vista.getTextArea().setText(null);
				String consulta = vista.getTextConsulta().getText();
				String resultadoQuery = modelo.consultaPersonalizada(
						"SELECT titulo, autor, a�o_pub FROM libros WHERE a�o_nac < '" + 1950 + "'");
				vista.getTextArea().setText((resultadoQuery));
				vista.getTextConsulta().setText(null);
			}
		};
		vista.getConsultaLibros().addActionListener(alConsultaLibros);

		alConsultaEditorial = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				vista.getTextArea().setText(null);
				String consulta = vista.getTextConsulta().getText();
				String resultadoQuery = modelo
						.consultaPersonalizada("SELECT editorial FROM libros WHERE a�o_pub >= '" + 2000 + "'");
				vista.getTextArea().setText((resultadoQuery));
				vista.getTextConsulta().setText(null);

			}

		};
		vista.getConsultaEditorial().addActionListener(alConsultaEditorial);
	}

}
