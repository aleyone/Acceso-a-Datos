package es.add.aemongodb;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;

public class Vista extends JFrame{

	private JPanel contentPane;
	private JTextField textField_Grupo, textField_Titulo, textField_Formato, textField_Anyo, textField;
	private JButton btnShowAll, btnShowOne, btnDelete, btnCreateConnection, btnUpdate, btnCreate, btnHelp, btnNewCargarCSV; 
	private JLabel lblNewLabel, lblAutor, lblAoN, lblEditorial;
	private JTextArea textArea;
	private JRadioButton rdbtnAnyoP, radioFormato, radioGrupo, radioTitulo;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JLabel lblDatos;
	private JLabel lblSeleccion;
	
	/**
	 * Create the application.
	 */
	public Vista() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 835, 622);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Definimos �reas de texto		
		textArea = new JTextArea();
		textArea.setBounds(10, 47, 801, 268);
		contentPane.add(textArea);	
		
		
		// Se definen botones
		btnCreateConnection = new JButton("Conectar a la BBDD");
		btnCreateConnection.setForeground(Color.WHITE);
		btnCreateConnection.setBackground(Color.BLACK);
		btnCreateConnection.setBounds(10, 11, 216, 23);
		contentPane.add(btnCreateConnection);
		
		btnUpdate = new JButton("Modifica el registro");
		btnUpdate.setForeground(Color.WHITE);
		btnUpdate.setBackground(Color.BLACK);
		btnUpdate.setBounds(390, 490, 216, 23);
		contentPane.add(btnUpdate);
		
		btnCreate = new JButton("Crear nuevo");
		btnCreate.setForeground(Color.WHITE);
		btnCreate.setBackground(Color.BLACK);
		btnCreate.setBounds(678, 524, 133, 23);
		contentPane.add(btnCreate);
		
		btnShowAll = new JButton("Mostrar todos los registros");
		btnShowAll.setForeground(Color.WHITE);
		btnShowAll.setBackground(Color.BLACK);
		btnShowAll.setBounds(595, 326, 216, 23);
		contentPane.add(btnShowAll);
		
		btnShowOne = new JButton("Mostrar registro");
		btnShowOne.setForeground(Color.WHITE);
		btnShowOne.setBackground(Color.BLACK);
		btnShowOne.setBounds(175, 490, 216, 23);
		contentPane.add(btnShowOne);
		
		btnDelete = new JButton("Elimina el registro");
		btnDelete.setForeground(Color.WHITE);
		btnDelete.setBackground(Color.BLACK);
		btnDelete.setBounds(595, 490, 216, 23);
		contentPane.add(btnDelete);
		
		//Definimos �reas de texto		
		textField_Grupo = new JTextField();
		textField_Grupo.setBounds(10, 525, 204, 20);
		contentPane.add(textField_Grupo);
		textField_Grupo.setColumns(10);
		
		textField_Titulo = new JTextField();
		textField_Titulo.setColumns(10);
		textField_Titulo.setBounds(224, 525, 172, 20);
		contentPane.add(textField_Titulo);
		
		textField_Formato = new JTextField();
		textField_Formato.setColumns(10);
		textField_Formato.setBounds(478, 525, 194, 20);
		contentPane.add(textField_Formato);
		
		textField_Anyo = new JTextField();
		textField_Anyo.setColumns(10);
		textField_Anyo.setBounds(406, 525, 62, 20);
		contentPane.add(textField_Anyo);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(10, 476, 155, 37);
		contentPane.add(textField);
		
		//Definimos etiquetas de texto		
		lblNewLabel = new JLabel("Grupo");
		lblNewLabel.setBounds(10, 545, 49, 14);
		contentPane.add(lblNewLabel);
		
		lblAutor = new JLabel("T\u00EDtulo");
		lblAutor.setBounds(224, 545, 49, 14);
		contentPane.add(lblAutor);
		
		lblAoN = new JLabel("A\u00F1o P.");
		lblAoN.setBounds(406, 545, 49, 14);
		contentPane.add(lblAoN);
		
		lblEditorial = new JLabel("Formato");
		lblEditorial.setBounds(488, 545, 49, 14);
		contentPane.add(lblEditorial);
		
		radioTitulo = new JRadioButton("T\u00EDtulo");
		buttonGroup.add(radioTitulo);
		radioTitulo.setBounds(10, 386, 111, 23);
		contentPane.add(radioTitulo);
		
		rdbtnAnyoP = new JRadioButton("A\u00F1o P.");
		buttonGroup.add(rdbtnAnyoP);
		rdbtnAnyoP.setBounds(10, 412, 111, 23);
		contentPane.add(rdbtnAnyoP);
		
		radioFormato = new JRadioButton("Formato");
		buttonGroup.add(radioFormato);
		radioFormato.setBounds(10, 438, 111, 23);
		contentPane.add(radioFormato);
		
		radioGrupo = new JRadioButton("Grupo");
		buttonGroup.add(radioGrupo);
		radioGrupo.setBounds(10, 360, 111, 23);
		contentPane.add(radioGrupo);
		
		btnHelp = new JButton("?");
		btnHelp.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnHelp.setForeground(Color.WHITE);
		btnHelp.setBackground(Color.BLUE);
		btnHelp.setBounds(749, 5, 62, 37);
		contentPane.add(btnHelp);
		
		JLabel lblIcon = new JLabel("");
		lblIcon.setIcon(new ImageIcon("./arrow.png"));
		lblIcon.setBounds(127, 434, 49, 48);
		contentPane.add(lblIcon);
		
		lblDatos = new JLabel("Datos");
		lblDatos.setBounds(135, 427, 49, 14);
		contentPane.add(lblDatos);
		
		lblSeleccion = new JLabel("Selecciona");
		lblSeleccion.setBounds(10, 339, 49, 14);
		contentPane.add(lblSeleccion);
		
		btnNewCargarCSV = new JButton("Cargar CSV");
		btnNewCargarCSV.setBounds(263, 11, 155, 23);
		contentPane.add(btnNewCargarCSV);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(678, 133, 88, 48);
		contentPane.add(scrollBar);
				
		setVisible(true);
		
	}

	public JTextField getTextField_Grupo() {
		return textField_Grupo;
	}

	public JTextField getTextField_Titulo() {
		return textField_Titulo;
	}

	public JTextField getTextField_Formato() {
		return textField_Formato;
	}

	public JTextField getTextField_Anyo() {
		return textField_Anyo;
	}

	public JTextField getTextField() {
		return textField;
	}

	public JButton getBtnShowAll() {
		return btnShowAll;
	}
	
	public JButton getCargarCSV() {
		return btnNewCargarCSV;
	}
	
	public JButton getBtnHelp() {
		return btnHelp;
	}

	public JButton getBtnShowOne() {
		return btnShowOne;
	}

	public JButton getBtnDelete() {
		return btnDelete;
	}

	public JButton getBtnCreateConnection() {
		return btnCreateConnection;
	}

	public JButton getBtnUpdate() {
		return btnUpdate;
	}

	public JButton getBtnCreate() {
		return btnCreate;
	}

	public JTextArea getTextArea() {
		return textArea;
	}

	public JRadioButton getRdbtnAnyoP() {
		return rdbtnAnyoP;
	}

	public JRadioButton getRadioFormato() {
		return radioFormato;
	}

	public JRadioButton getRadioGrupo() {
		return radioGrupo;
	}

	public JRadioButton getRadioTitulo() {
		return radioTitulo;
	}
}
