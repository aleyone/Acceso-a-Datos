package es.add.aemongodb;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.mongodb.client.MongoCollection;

public class Controlador {
	private Modelo modelo;
	private Vista vista;
	private ActionListener alCreateConnection, alShowAll, alShowOne, alDeleteOne, alUpdate,
			alCreate, alHelp, alCargarCSV;

	public Controlador(Modelo modelo, Vista vista) {
		this.modelo = modelo;
		this.vista = vista;
		control();
	}

	public void control() {
		alCreateConnection = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				MongoCollection cliente = modelo.createConnection();
				vista.getTextArea().setText("Se ha creado correctamente la conexi�n a la base de datos.\n\n"
						+ "Pulsa '?' para obtener ayuda del funcionamiento de la aplicaci�n");
				}
		};
		vista.getBtnCreateConnection().addActionListener(alCreateConnection);
		
		alCargarCSV = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				JFileChooser chooser = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter("Ficheros v�lidos", "csv", "json");
				JButton jButton1 = null;
				chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
				chooser.setFileFilter(filter);
				//chooser.setCurrentDirectory(File.listRoots()[0]);
				if ((chooser.showOpenDialog(jButton1))!=JFileChooser.APPROVE_OPTION) return;
				File file = chooser.getSelectedFile();
				modelo.loadCSV(file);
				vista.getTextArea().setText("Se han introducido los datos en Mongo DB. Pulsa en 'Mostrar todos los registros' para comprobarlo.");
			}
		};
		vista.getCargarCSV().addActionListener(alCargarCSV);
		
		alHelp = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				vista.getTextArea().setText("- MOSTRAR REGISTROS: Para ver todos los registros, pulsa 'Mostrar todos los registros'.\n\n"
						+ "- MOSTRAR REGISTROS POR CRITERIOS: Selecciona un criterio con el radiobutton, introduce el dato deseado en el campo de texto,\n"
						+ "y pulsa 'Mostrar registros'.\n\n"
						+ "- MODIFICAR REGISTRO: Selecciona un criterio con el radiobutton, introduce el dato deseado en el campo de texto,\n"
						+ "modifica en la l�nea inferior EL MISMO criterio y pulsa 'Modifica el registro'.\n\n"
						+ "- CREAR REGISTRO: Introduce datos en la l�nea inferior y pulsa 'Crear nuevo'.\n\n"
						+ "- ELIMINAR REGISTROS: Selecciona un criterio con el radiobutton, introduce el dato deseado en el campo de texto,\n"
						+ "pulsa 'Eliminar'.\n\n");
				}
		};
		vista.getBtnHelp().addActionListener(alHelp);
		
		alShowAll = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				vista.getTextArea().setText(null);
				MongoCollection collection = modelo.createConnection();
				vista.getTextArea().setText(modelo.showAll(collection));
				
			}
		};
		vista.getBtnShowAll().addActionListener(alShowAll);
		
		
		alShowOne = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				String criterio = "";
				String busqueda ="";
				String resultado ="";
				vista.getTextArea().setText(null);
				MongoCollection collection = modelo.createConnection();
				busqueda = vista.getTextField().getText();
				if (vista.getRadioGrupo().isSelected()){
					criterio = "Grupo";
					resultado = modelo.readCriteria(collection, criterio, busqueda);
				} else if (vista.getRadioTitulo().isSelected()) {
					criterio ="Titulo";
					resultado = modelo.readCriteria(collection, criterio, busqueda);
				} else if (vista.getRadioFormato().isSelected()) {
					criterio = "Formato";
					resultado = modelo.readCriteria(collection, criterio, busqueda);
				} else if (vista.getRdbtnAnyoP().isSelected()) {
					criterio = "Anyo";
					resultado = modelo.readCriteria(collection, criterio, (int) Integer.parseInt(busqueda));
				}				
				vista.getTextArea().setText(resultado);
				
			}
		};
		vista.getBtnShowOne().addActionListener(alShowOne);
		
		alDeleteOne = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				String criterio = "";
				String busqueda ="";
				vista.getTextArea().setText(null);
				MongoCollection collection = modelo.createConnection();
				busqueda = vista.getTextField().getText();
				if (vista.getRadioGrupo().isSelected()){
					criterio = "Grupo";
					modelo.deleteMany(collection, criterio, busqueda);
				} else if (vista.getRadioTitulo().isSelected()) {
					criterio ="Titulo";
					modelo.deleteMany(collection, criterio, busqueda);
				} else if (vista.getRadioFormato().isSelected()) {
					criterio = "Formato";
					modelo.deleteMany(collection, criterio, busqueda);
				} else if (vista.getRdbtnAnyoP().isSelected()) {
					criterio = "Anyo";
					modelo.deleteMany(collection, criterio, (int) Integer.parseInt(busqueda));
				}				
				
				vista.getTextArea().setText("Ha(n) sido eliminado(s) el(los) registro(s) de la base de datos.");
				
			}
		};
		vista.getBtnDelete().addActionListener(alDeleteOne);
		
		alUpdate = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				String criterio = "";
				String busqueda ="";
				vista.getTextArea().setText(null);
				MongoCollection collection = modelo.createConnection();
				busqueda = vista.getTextField().getText();
				if (vista.getRadioGrupo().isSelected()){
					criterio = "Grupo";
					String grupo = vista.getTextField_Grupo().getText();
					modelo.updateRegistry(collection, criterio, busqueda, grupo);
				} else if (vista.getRadioTitulo().isSelected()) {
					criterio ="Titulo";
					String titulo = vista.getTextField_Titulo().getText();
					modelo.updateRegistry(collection, criterio, busqueda, titulo);
				} else if (vista.getRadioFormato().isSelected()) {
					criterio = "Formato";
					String formato = vista.getTextField_Formato().getText();
					modelo.updateRegistry(collection, criterio, busqueda, formato);
				} else if (vista.getRdbtnAnyoP().isSelected()) {
					criterio = "Anyo";
					String a�o = vista.getTextField_Anyo().getText();
					modelo.updateRegistry(collection, criterio, (int) Integer.parseInt(busqueda), (int) Integer.parseInt(a�o));
				}				
				
				vista.getTextArea().setText("Ha(n) sido modificado(s) el(los) registro(s) de la base de datos.");
				
			}
		};
		vista.getBtnUpdate().addActionListener(alUpdate);
		
		alCreate = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				vista.getTextArea().setText(null);
				MongoCollection collection = modelo.createConnection();
				String grupo = vista.getTextField_Grupo().getText();
				String titulo = vista.getTextField_Titulo().getText();
				String a�o_p = vista.getTextField_Anyo().getText();
				String formato = vista.getTextField_Formato().getText();
				modelo.createRegistry(collection, grupo, titulo, (int)Integer.parseInt(a�o_p), formato);
				vista.getTextArea().setText("Ha sido a�adido el registro a MongoDB.");
				
			}
		};
		vista.getBtnCreate().addActionListener(alCreate);
		
	}
}

