package es.add4.aev4;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.Color;

public class Vista2 extends JFrame {

	private JPanel contentPane;
	private JButton btnCargarCsv;
	private JTextArea textArea;
	private JButton btnExportCsv;
	private JButton btnInsertar;
	private JTextField textFieldTitulo;
	private JTextField textFieldAutor;
	private JTextField textFieldNac;
	private JTextField textFieldPub;
	private JTextField textFieldEditorial;
	private JTextField textFieldNPag;
	private JButton btnConsultar;
	private JTextField textFieldConsulta;
	private JButton btnConsultarLibro;
	private JButton btnConsultarEditorial;
	private JButton btnEliminar;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Vista2 frame = new Vista2();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public Vista2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 430);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane_Original = new JScrollPane();
		scrollPane_Original.setBounds(138, 11, 492, 138);
		getContentPane().add(scrollPane_Original);
		
				textArea = new JTextArea();
				scrollPane_Original.setViewportView(textArea);

		btnCargarCsv = new JButton("Cargar CSV");
		btnCargarCsv.setBounds(10, 22, 118, 44);
		contentPane.add(btnCargarCsv);

		btnExportCsv = new JButton("Exportar CSV");
		btnExportCsv.setHorizontalAlignment(SwingConstants.RIGHT);
		btnExportCsv.setBounds(10, 77, 118, 44);
		contentPane.add(btnExportCsv);

		btnInsertar = new JButton("Insertar Registro");
		btnInsertar.setBounds(660, 320, 118, 44);
		contentPane.add(btnInsertar);

		btnConsultarLibro = new JButton("Ej. Libros");
		btnConsultarLibro.setBounds(660, 22, 118, 44);
		contentPane.add(btnConsultarLibro);

		btnConsultarEditorial = new JButton("Ej. Editorial");
		btnConsultarEditorial.setBounds(660, 77, 118, 44);
		contentPane.add(btnConsultarEditorial);

		btnEliminar = new JButton("Vaciar Tabla");
		btnEliminar.setBackground(Color.CYAN);
		btnEliminar.setForeground(Color.BLACK);
		btnEliminar.setBounds(10, 231, 118, 44);
		contentPane.add(btnEliminar);

		textFieldTitulo = new JTextField();
		textFieldTitulo.setBounds(20, 332, 96, 20);
		contentPane.add(textFieldTitulo);
		textFieldTitulo.setColumns(10);

		textFieldAutor = new JTextField();
		textFieldAutor.setColumns(10);
		textFieldAutor.setBounds(126, 332, 96, 20);
		contentPane.add(textFieldAutor);

		textFieldNac = new JTextField();
		textFieldNac.setColumns(10);
		textFieldNac.setBounds(236, 332, 96, 20);
		contentPane.add(textFieldNac);

		textFieldPub = new JTextField();
		textFieldPub.setColumns(10);
		textFieldPub.setBounds(342, 332, 96, 20);
		contentPane.add(textFieldPub);

		textFieldEditorial = new JTextField();
		textFieldEditorial.setColumns(10);
		textFieldEditorial.setBounds(448, 332, 96, 20);
		contentPane.add(textFieldEditorial);

		textFieldNPag = new JTextField();
		textFieldNPag.setColumns(10);
		textFieldNPag.setBounds(554, 332, 96, 20);
		contentPane.add(textFieldNPag);

		JLabel lblNewLabel = new JLabel("T\u00EDtulo");
		lblNewLabel.setBounds(20, 319, 49, 14);
		contentPane.add(lblNewLabel);

		JLabel lblAutor = new JLabel("Autor");
		lblAutor.setBounds(126, 319, 49, 14);
		contentPane.add(lblAutor);

		JLabel lblAoNac = new JLabel("A\u00F1o Nac.");
		lblAoNac.setBounds(236, 319, 49, 14);
		contentPane.add(lblAoNac);

		JLabel lblAoPub = new JLabel("A\u00F1o Pub");
		lblAoPub.setBounds(342, 319, 49, 14);
		contentPane.add(lblAoPub);

		JLabel lblEditorial = new JLabel("Editorial");
		lblEditorial.setBounds(448, 319, 49, 14);
		contentPane.add(lblEditorial);

		JLabel lblNPg = new JLabel("N\u00BA p\u00E1g.");
		lblNPg.setBounds(554, 319, 49, 14);
		contentPane.add(lblNPg);

		btnConsultar = new JButton("Consultar");
		btnConsultar.setBounds(660, 157, 118, 44);
		contentPane.add(btnConsultar);

		textFieldConsulta = new JTextField();
		textFieldConsulta.setColumns(10);
		textFieldConsulta.setBounds(138, 160, 492, 38);
		contentPane.add(textFieldConsulta);

		setVisible(true);
	}

	public JButton getCargarCsv() {
		return btnCargarCsv;
	}

	public JButton getExportarCsv() {
		return btnExportCsv;
	}

	public JButton getInsertar() {
		return btnInsertar;
	}

	public JButton getConsultaLibros() {
		return btnConsultarLibro;
	}

	public JButton getConsultaEditorial() {
		return btnConsultarEditorial;
	}

	public JButton getConsultaPersonal() {
		return btnConsultar;
	}

	public JButton getEliminar() {
		return btnEliminar;
	}

	public JTextField getTextTitulo() {
		return textFieldTitulo;
	}

	public JTextField getTextAutor() {
		return textFieldAutor;
	}

	public JTextField getTextAnyoNac() {
		return textFieldNac;
	}

	public JTextField getTextAnyoPub() {
		return textFieldPub;
	}

	public JTextField getTextEditorial() {
		return textFieldEditorial;
	}

	public JTextField getTextNPag() {
		return textFieldNPag;
	}

	public JTextField getTextConsulta() {
		return textFieldConsulta;
	}

	public JTextArea getTextArea() {
		return textArea;
	}
}
