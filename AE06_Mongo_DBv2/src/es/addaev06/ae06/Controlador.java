package es.addaev06.ae06;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.mongodb.MongoClient;

public class Controlador {

	private Modelo modelo;
	private Vista vista;
	private MongoClient client;
	private ActionListener alCreateConnection, alCloseConnection, alShowAll, alShowOne, alDeleteOne, alUpdate, alCreate, alLoadId, alClear;

	public Controlador(Modelo modelo, Vista vista) {
		this.modelo = modelo;
		this.vista = vista;
		control();
	}

	public void control() {
		alCreateConnection = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				modelo.createConection();
				vista.getLblInfo().setText("LOADED COLLECTION");
			}
		};
		vista.getBtnConnect().addActionListener(alCreateConnection);

		alCloseConnection = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				modelo.closeConnection();
				vista.getLblInfo().setText("CLOSED CONNECTION");
			}
		};
		vista.getBtnDisconnect().addActionListener(alCloseConnection);

		alShowAll = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				vista.getTextArea().setText(null);
				vista.getTextArea().setText(modelo.showAll());
				vista.getLblInfo().setText("COLLECTION LOADED");
			}
		};
		vista.getBtnShowAll().addActionListener(alShowAll);

		alLoadId = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				vista.getTextArea().setText(null);
				String id = vista.getTextField().getText();
				String[] result = modelo.loadId(id);
				vista.getTxtTtulo().setText(result[0]);
				vista.getTextAutor().setText(result[1]);
				vista.getTextAnyoN().setText(result[2]);
				vista.getTextAnyoP().setText(result[3]);
				vista.getTextEditorial().setText(result[4]);
				vista.getTextNumP().setText(result[5]);
				vista.getLblInfo().setText("MAKE CHANGES & UPDATE");
			}
		};
		vista.getBtnLoadId().addActionListener(alLoadId);
		
		alUpdate = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				String id = vista.getTextField().getText();
				String titulo = vista.getTxtTtulo().getText();
				String autor = vista.getTextAutor().getText();
				String anyo_nac = vista.getTextAnyoN().getText();
				String anyo_pub = vista.getTextAnyoP().getText();
				String editorial = vista.getTextEditorial().getText();
				String num_pag = vista.getTextNumP().getText();
				modelo.updateRegistry(id, titulo, autor, anyo_nac, anyo_pub, editorial, num_pag);
				vista.getLblInfo().setText("<--- MODIFIED");
				vista.getTextArea().setText(modelo.showOne(id));
			}
		};
		vista.getBtnUpdate().addActionListener(alUpdate);
		
		alCreate = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				vista.getTextArea().setText(null);
				modelo.loopList();
				String id = modelo.Next_Id();
				String titulo = vista.getTxtTtulo().getText();
				String autor = vista.getTextAutor().getText();
				String anyo_nac = vista.getTextAnyoN().getText();
				String anyo_pub = vista.getTextAnyoP().getText();
				String editorial = vista.getTextEditorial().getText();
				String num_pag = vista.getTextNumP().getText();
				modelo.createRegistry(id, titulo, autor, anyo_nac, anyo_pub, editorial, num_pag);
				vista.getLblInfo().setText("<--- CREATED NEW REGISTRY ID: "+id);
				vista.getTextArea().setText(modelo.showOne(id));
			}
		};
		vista.getBtnCreate().addActionListener(alCreate);
		
		alShowOne = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				vista.getTextArea().setText(null);
				String id = vista.getTextField().getText();
				vista.getLblInfo().setText("<--- BOOK's DETAILS");
				vista.getTextArea().setText(modelo.showOne(id));
				
			}
		};
		vista.getBtnShowOne().addActionListener(alShowOne);
		
		alDeleteOne = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				vista.getTextArea().setText(null);
				String id = vista.getTextField().getText();
				vista.getLblInfo().setText("DELETED ID: "+id);
				modelo.deleteOne(id);
			}
		};
		vista.getBtnDelete().addActionListener(alDeleteOne);
		
		alClear = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				vista.getTextField().setText(null);
				vista.getTxtTtulo().setText(null);
				vista.getTextAutor().setText(null);
				vista.getTextAnyoN().setText(null);
				vista.getTextAnyoP().setText(null);
				vista.getTextEditorial().setText(null);
				vista.getTextNumP().setText(null);
				vista.getLblInfo().setText("CLEANED DISPLAY ;)");
			}
		};
		vista.getBtnClear().addActionListener(alClear);
		
	}
}
