package es.maven.actividadEvaluable5;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import java.awt.Font;

public class Vista extends JFrame{

	private JPanel contentPane;
	private JTextField textField_Titulo, textField_Autor, textField_AñoP, textField_Editorial, textField_Pag, textField_AñoN, textField_ID;
	private JButton btnShowBooks, btnShowOneBook, btnDeleteBook, btnCloseConnection, btnCreateConnection, btnUpdateBook, btnCreateBook, btnLoadID, btnRemoveId; 
	private JLabel lblNewLabel, lblAutor, lblAoN, lblAoP, lblEditorial, lblPginas, lblId;
	private JTextArea textArea;
	private JScrollBar scrollBar;
	private JScrollBar scrollBar_1;
	
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
		
		//Definimos áreas de texto		
		textArea = new JTextArea();
		textArea.setBounds(10, 47, 801, 268);
		contentPane.add(textArea);	
		
		// Se definen botones
		btnCreateConnection = new JButton("Conectar a la BBDD");
		btnCreateConnection.setForeground(Color.WHITE);
		btnCreateConnection.setBackground(Color.BLACK);
		btnCreateConnection.setBounds(10, 11, 216, 23);
		contentPane.add(btnCreateConnection);
		
		btnUpdateBook = new JButton("Modifica el registro");
		btnUpdateBook.setForeground(Color.WHITE);
		btnUpdateBook.setBackground(Color.BLACK);
		btnUpdateBook.setBounds(131, 491, 216, 23);
		contentPane.add(btnUpdateBook);
		
		btnCreateBook = new JButton("Crear nuevo registro");
		btnCreateBook.setForeground(Color.WHITE);
		btnCreateBook.setBackground(Color.BLACK);
		btnCreateBook.setBounds(595, 491, 216, 23);
		contentPane.add(btnCreateBook);
		
		btnShowBooks = new JButton("Mostrar todos los libros");
		btnShowBooks.setForeground(Color.WHITE);
		btnShowBooks.setBackground(Color.BLACK);
		btnShowBooks.setBounds(595, 326, 216, 23);
		contentPane.add(btnShowBooks);
		
		btnShowOneBook = new JButton("Mostrar registro");
		btnShowOneBook.setForeground(Color.WHITE);
		btnShowOneBook.setBackground(Color.BLACK);
		btnShowOneBook.setBounds(131, 457, 216, 23);
		contentPane.add(btnShowOneBook);
		
		btnDeleteBook = new JButton("Elimina el registro");
		btnDeleteBook.setForeground(Color.WHITE);
		btnDeleteBook.setBackground(Color.BLACK);
		btnDeleteBook.setBounds(131, 424, 216, 23);
		contentPane.add(btnDeleteBook);
		
		btnLoadID = new JButton("+");
		btnLoadID.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnLoadID.setBackground(Color.GREEN);
		btnLoadID.setForeground(Color.BLACK);
		btnLoadID.setBounds(25, 488, 39, 26);
		contentPane.add(btnLoadID);
		
		btnRemoveId = new JButton("-");
		btnRemoveId.setForeground(Color.BLACK);
		btnRemoveId.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnRemoveId.setBackground(Color.RED);
		btnRemoveId.setBounds(70, 488, 39, 26);
		contentPane.add(btnRemoveId);
		
		btnCloseConnection = new JButton("Desconectar");
		btnCloseConnection.setForeground(Color.WHITE);
		btnCloseConnection.setBackground(Color.BLACK);
		btnCloseConnection.setBounds(595, 11, 216, 23);
		contentPane.add(btnCloseConnection);
		
		//Definimos áreas de texto		
		textField_Titulo = new JTextField();
		textField_Titulo.setBounds(10, 525, 204, 20);
		contentPane.add(textField_Titulo);
		textField_Titulo.setColumns(10);
		
		textField_Autor = new JTextField();
		textField_Autor.setColumns(10);
		textField_Autor.setBounds(224, 525, 172, 20);
		contentPane.add(textField_Autor);
		
		textField_AñoP = new JTextField();
		textField_AñoP.setColumns(10);
		textField_AñoP.setBounds(478, 525, 62, 20);
		contentPane.add(textField_AñoP);
		
		textField_Editorial = new JTextField();
		textField_Editorial.setColumns(10);
		textField_Editorial.setBounds(550, 525, 194, 20);
		contentPane.add(textField_Editorial);
		
		textField_Pag = new JTextField();
		textField_Pag.setColumns(10);
		textField_Pag.setBounds(754, 525, 57, 20);
		contentPane.add(textField_Pag);	
		
		textField_AñoN = new JTextField();
		textField_AñoN.setColumns(10);
		textField_AñoN.setBounds(406, 525, 62, 20);
		contentPane.add(textField_AñoN);
		
		textField_ID = new JTextField();
		textField_ID.setColumns(10);
		textField_ID.setBounds(36, 457, 62, 20);
		contentPane.add(textField_ID);
		
		//Definimos etiquetas de texto		
		lblNewLabel = new JLabel("Título");
		lblNewLabel.setBounds(10, 545, 49, 14);
		contentPane.add(lblNewLabel);
		
		lblAutor = new JLabel("Autor");
		lblAutor.setBounds(224, 545, 49, 14);
		contentPane.add(lblAutor);
		
		lblAoN = new JLabel("Año N.");
		lblAoN.setBounds(406, 545, 49, 14);
		contentPane.add(lblAoN);
		
		lblAoP = new JLabel("Año P.");
		lblAoP.setBounds(478, 545, 49, 14);
		contentPane.add(lblAoP);
		
		lblEditorial = new JLabel("Editorial");
		lblEditorial.setBounds(550, 545, 49, 14);
		contentPane.add(lblEditorial);
		
		lblPginas = new JLabel("Páginas");
		lblPginas.setBounds(754, 545, 49, 14);
		contentPane.add(lblPginas);	
		
		lblId = new JLabel("ID");
		lblId.setBounds(15, 460, 49, 14);
		contentPane.add(lblId);
		
		setVisible(true);
		
	}

	public JTextField getTextField_Titulo() {
		return textField_Titulo;
	}

	public JTextField getTextField_Autor() {
		return textField_Autor;
	}

	public JTextField getTextField_AñoP() {
		return textField_AñoP;
	}

	public JTextField getTextField_Editorial() {
		return textField_Editorial;
	}

	public JTextField getTextField_Pag() {
		return textField_Pag;
	}

	public JTextField getTextField_AñoN() {
		return textField_AñoN;
	}

	public JTextField getTextField_ID() {
		return textField_ID;
	}

	public JButton getBtnShowBooks() {
		return btnShowBooks;
	}

	public JButton getBtnShowOneBook() {
		return btnShowOneBook;
	}

	public JButton getBtnDeleteBook() {
		return btnDeleteBook;
	}

	public JButton getBtnCloseConnection() {
		return btnCloseConnection;
	}

	public JButton getBtnCreateConnection() {
		return btnCreateConnection;
	}

	public JButton getBtnUpdateBook() {
		return btnUpdateBook;
	}

	public JButton getBtnCreateBook() {
		return btnCreateBook;
	}

	public JTextArea getTextArea() {
		return textArea;
	}

	public JButton getBtnLoadID() {
		return btnLoadID;
	}

	public JButton getBtnRemoveId() {
		return btnRemoveId;
	}
}
