package es.add4.aev4;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JLabel;

public class Vista extends JFrame {

	private JPanel contentPane;
	private JTextField textTitulo;
	private JTextField textAutor;
	private JTextField textAnyoNac;
	private JTextField textAnyoPub;
	private JTextField textEditorial;
	private JTextField textNPag;
	private JTextField textConsulta;
	private JButton btnCargarCsv;
	private JButton btnConsultaPersonal;
	private JButton btnConsultaLibros;
	private JButton btnConsultaEditorial;
	private JButton btnInsertar;
	private JButton btnExportarCsv;
	private JTextArea textArea;

	

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Vista frame = new Vista();
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
	public Vista() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 807, 447);
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnCargarCsv = new JButton("Cargar desde CSV");
		btnCargarCsv.setBounds(29, 23, 121, 40);
		btnCargarCsv.setFont(new Font("Verdana", Font.BOLD, 8));
		btnCargarCsv.setBackground(new Color(173, 216, 230));
//		btnCargarCsv.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//			}
//		});
		contentPane.setLayout(null);
		contentPane.add(btnCargarCsv);
		
		JButton btnConsultaPersonal = new JButton("Consulta Personalizada");
		btnConsultaPersonal.setBounds(29, 354, 131, 25);
//		btnConsultaPersonal.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//			}
//		});
		btnConsultaPersonal.setFont(new Font("Verdana", Font.BOLD, 8));
		btnConsultaPersonal.setBackground(new Color(173, 216, 230));
		contentPane.add(btnConsultaPersonal);
		
		JButton btnConsultaLibros = new JButton("Ej. Consulta 2");
		btnConsultaLibros.setBounds(690, 354, 93, 25);
//		btnConsultaLibros.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//			}
//		});
		btnConsultaLibros.setFont(new Font("Verdana", Font.BOLD, 8));
		btnConsultaLibros.setBackground(new Color(173, 216, 230));
		contentPane.add(btnConsultaLibros);
		
		JButton btnConsultaEditorial = new JButton("Ej. Consulta 1");
		btnConsultaEditorial.setBounds(587, 354, 93, 25);
//		btnConsultaEditorial.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//			}
//		});
		btnConsultaEditorial.setFont(new Font("Verdana", Font.BOLD, 8));
		btnConsultaEditorial.setBackground(new Color(173, 216, 230));
		contentPane.add(btnConsultaEditorial);
		
		JButton btnInsertar = new JButton("Insertar datos");
		btnInsertar.setBounds(32, 303, 105, 25);
//		btnInsertar.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//			}
//		});
		btnInsertar.setFont(new Font("Verdana", Font.BOLD, 8));
		btnInsertar.setBackground(new Color(173, 216, 230));
		contentPane.add(btnInsertar);
		
		textTitulo = new JTextField();
		textTitulo.setBounds(147, 304, 96, 20);
		contentPane.add(textTitulo);
		textTitulo.setColumns(10);
		
		textAutor = new JTextField();
		textAutor.setBounds(253, 304, 96, 20);
		textAutor.setColumns(10);
		contentPane.add(textAutor);
		
		textAnyoNac = new JTextField();
		textAnyoNac.setBounds(360, 304, 96, 20);
		textAnyoNac.setColumns(10);
		contentPane.add(textAnyoNac);
		
		textAnyoPub = new JTextField();
		textAnyoPub.setBounds(466, 304, 96, 20);
		textAnyoPub.setColumns(10);
		contentPane.add(textAnyoPub);
		
		textEditorial = new JTextField();
		textEditorial.setBounds(572, 304, 96, 20);
		textEditorial.setColumns(10);
		contentPane.add(textEditorial);
		
		textNPag = new JTextField();
		textNPag.setBounds(678, 304, 96, 20);
		textNPag.setColumns(10);
		contentPane.add(textNPag);
		
		textConsulta = new JTextField();
		textConsulta.setBounds(170, 359, 403, 20);
		textConsulta.setColumns(10);
		contentPane.add(textConsulta);
		
		JLabel lblTitulo = new JLabel("T\u00EDtulo");
		lblTitulo.setBounds(147, 291, 49, 14);
		contentPane.add(lblTitulo);
		
		JLabel lblAutor = new JLabel("Autor");
		lblAutor.setBounds(253, 291, 49, 14);
		contentPane.add(lblAutor);
		
		JLabel lblAnyoNac = new JLabel("A\u00F1o Nacimiento");
		lblAnyoNac.setBounds(359, 291, 93, 14);
		contentPane.add(lblAnyoNac);
		
		JLabel lblAnyoPub = new JLabel("A\u00F1o public.");
		lblAnyoPub.setBounds(466, 291, 65, 14);
		contentPane.add(lblAnyoPub);
		
		JLabel lblEditorial = new JLabel("Editorial");
		lblEditorial.setBounds(577, 291, 49, 14);
		contentPane.add(lblEditorial);
		
		JLabel lblNPag = new JLabel("N\u00BA p\u00E1ginas");
		lblNPag.setBounds(678, 291, 54, 14);
		contentPane.add(lblNPag);
		
		JButton btnExportarCsv = new JButton("Exportar a CSV");
		btnExportarCsv.setBounds(662, 23, 121, 40);
		btnExportarCsv.setFont(new Font("Verdana", Font.BOLD, 8));
		btnExportarCsv.setBackground(new Color(173, 216, 230));
		contentPane.add(btnExportarCsv);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(170, 23, 470, 257);
		contentPane.add(textArea);
		
		setVisible(true); // Se inicializa
	}
	
	public JButton getCargarCsv() {
		return btnCargarCsv;
	}
	
	public JButton getExportarCsv() {
		return btnExportarCsv;
	}
	
	public JButton getInsertar() {
		return btnInsertar;
	}
	
	public JButton getConsultaLibros() {
		return btnConsultaLibros;
	}
	
	public JButton getConsultaEditorial() {
		return btnConsultaEditorial;
	}
	
	public JButton getConsultaPersonal() {
		return btnConsultaPersonal;
	}
	
	public JTextField getTextTitulo() {
		return textTitulo;
	}
	
	public JTextField getTextAutor() {
		return textAutor;
	}
	
	public JTextField getTextAnyoNac() {
		return textAnyoNac;
	}
	
	public JTextField getTextAnyoPub() {
		return textAnyoPub;
	}
	
	public JTextField getTextEditorial() {
		return textEditorial;
	}
	
	public JTextField getTextNPag() {
		return textNPag;
	}
	
	public JTextField getTextConsulta() {
		return textConsulta;
	}
	
	public JTextArea getTextArea() {
		return textArea;
	}

	
}
