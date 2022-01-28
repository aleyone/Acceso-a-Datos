package es.addaev06.ae06;

import javax.swing.JFrame;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Font;
import javax.swing.JTextField;

public class Vista extends JFrame {
	private JPanel contentPane;
	private JTextField textField, txtTtulo, textAnyoN, textAnyoP, textEditorial, textNumP, textAutor;
	private JTextArea textArea;
	private JButton btnConnect, btnShowAll, btnShowOne, btnDelete, btnDisconnect, btnUpdate, btnCreate, btnLoadId, btnClear;
	private JLabel lblWelcome, lblSelectTo, lblTitulo, lblAutor, lblAnyoNac, lblAnyoPub, lblEditorial, lblNumPag,
			lblInfo, lblReloaded;

	/**
	 * Create the panel.
	 */
	public Vista() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 890, 622);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(250, 240, 230));
		contentPane.setBorder(new TitledBorder(null, "MongoDB Reloaded", TitledBorder.LEADING, TitledBorder.BOTTOM, null,
				new Color(139, 0, 0)));
		getContentPane().setLayout(null);

		// TextArea
		textArea = new JTextArea();
		textArea.setBounds(24, 33, 409, 374);
		getContentPane().add(textArea);

		// Buttons

		btnConnect = new JButton("CONNECT");
		btnConnect.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnConnect.setForeground(new Color(255, 255, 255));
		btnConnect.setBounds(24, 418, 129, 46);
		btnConnect.setBackground(new Color(0, 128, 0));
		getContentPane().add(btnConnect);

		btnShowAll = new JButton("SHOW ALL");
		btnShowAll.setBounds(304, 418, 129, 46);
		getContentPane().add(btnShowAll);

		btnShowOne = new JButton("SHOW DETAILS");
		btnShowOne.setBounds(655, 107, 129, 46);
		getContentPane().add(btnShowOne);

		btnDelete = new JButton("DELETE BOOK");
		btnDelete.setBounds(655, 165, 129, 46);
		getContentPane().add(btnDelete);

		btnDisconnect = new JButton("DISCONNECT");
		btnDisconnect.setForeground(new Color(255, 255, 255));
		btnDisconnect.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnDisconnect.setBounds(163, 418, 129, 46);
		btnDisconnect.setBackground(new Color(220, 20, 60));
		getContentPane().add(btnDisconnect);

		btnUpdate = new JButton("UPDATE BOOK");
		btnUpdate.setBounds(655, 222, 129, 46);
		getContentPane().add(btnUpdate);

		btnCreate = new JButton("CREATE BOOK");
		btnCreate.setBounds(606, 418, 129, 46);
		getContentPane().add(btnCreate);
		
		btnLoadId = new JButton("Load2Update");
		btnLoadId.setForeground(new Color(255, 255, 255));
		btnLoadId.setBackground(new Color(70, 130, 180));
		btnLoadId.setFont(new Font("Tahoma", Font.BOLD, 9));
		btnLoadId.setBounds(507, 219, 114, 27);
		getContentPane().add(btnLoadId);
		
		btnClear = new JButton("X");
		btnClear.setForeground(Color.WHITE);
		btnClear.setBackground(Color.RED);
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnClear.setBounds(451, 341, 54, 55);
		getContentPane().add(btnClear);

		// Labels

		lblWelcome = new JLabel("Welcome to Library");
		lblWelcome.setBounds(474, 11, 361, 74);
		lblWelcome.setFont(new Font("Book Antiqua", Font.BOLD, 31));
		getContentPane().add(lblWelcome);

		lblSelectTo = new JLabel("Select ID             to");
		lblSelectTo.setBounds(467, 163, 168, 46);
		lblSelectTo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		getContentPane().add(lblSelectTo);

		lblTitulo = new JLabel("T\u00EDtulo");
		lblTitulo.setBounds(451, 279, 49, 14);
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		getContentPane().add(lblTitulo);

		lblAutor = new JLabel("Autor");
		lblAutor.setBounds(615, 279, 49, 14);
		lblAutor.setFont(new Font("Tahoma", Font.PLAIN, 13));
		getContentPane().add(lblAutor);

		lblAnyoNac = new JLabel("A\u00F1o N.");
		lblAnyoNac.setBounds(774, 279, 49, 14);
		lblAnyoNac.setFont(new Font("Tahoma", Font.PLAIN, 13));
		getContentPane().add(lblAnyoNac);

		lblAnyoPub = new JLabel("A\u00F1o P.");
		lblAnyoPub.setBounds(521, 347, 49, 14);
		lblAnyoPub.setFont(new Font("Tahoma", Font.PLAIN, 13));
		getContentPane().add(lblAnyoPub);

		lblEditorial = new JLabel("Editorial");
		lblEditorial.setBounds(615, 347, 49, 14);
		lblEditorial.setFont(new Font("Tahoma", Font.PLAIN, 13));
		getContentPane().add(lblEditorial);

		lblNumPag = new JLabel("Num. P.");
		lblNumPag.setBounds(774, 347, 49, 14);
		lblNumPag.setFont(new Font("Tahoma", Font.PLAIN, 13));
		getContentPane().add(lblNumPag);

		lblInfo = new JLabel("");
		lblInfo.setBounds(474, 75, 379, 21);
		lblInfo.setForeground(new Color(255, 0, 0));
		lblInfo.setFont(new Font("Tahoma", Font.BOLD, 18));
		getContentPane().add(lblInfo);
		
		lblReloaded = new JLabel("The MongoDB Reloaded");
		lblReloaded.setForeground(new Color(205, 92, 92));
		lblReloaded.setFont(new Font("Tahoma", Font.ITALIC, 20));
		lblReloaded.setBounds(24, 8, 252, 14);
		getContentPane().add(lblReloaded);

		// TextFields

		textField = new JTextField();
		textField.setBounds(542, 171, 44, 34);
		getContentPane().add(textField);
		textField.setColumns(10);

		txtTtulo = new JTextField();
		txtTtulo.setBounds(451, 296, 149, 34);
		getContentPane().add(txtTtulo);
		txtTtulo.setColumns(10);

		textAnyoN = new JTextField();
		textAnyoN.setBounds(774, 296, 79, 34);
		textAnyoN.setColumns(10);
		getContentPane().add(textAnyoN);

		textAnyoP = new JTextField();
		textAnyoP.setBounds(521, 362, 79, 34);
		textAnyoP.setColumns(10);
		getContentPane().add(textAnyoP);

		textEditorial = new JTextField();
		textEditorial.setBounds(615, 362, 149, 34);
		textEditorial.setColumns(10);
		getContentPane().add(textEditorial);

		textNumP = new JTextField();
		textNumP.setBounds(774, 362, 79, 34);
		textNumP.setColumns(10);
		getContentPane().add(textNumP);

		textAutor = new JTextField();
		textAutor.setBounds(615, 296, 149, 34);
		textAutor.setColumns(10);
		getContentPane().add(textAutor);
				
		setVisible(true);

	}

	// Getters / Setters
	public JButton getBtnConnect() {
		return btnConnect;
	}

	public JButton getBtnShowAll() {
		return btnShowAll;
	}

	public JButton getBtnShowOne() {
		return btnShowOne;
	}

	public JButton getBtnDelete() {
		return btnDelete;
	}

	public JButton getBtnDisconnect() {
		return btnDisconnect;
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

	public JLabel getLblInfo() {
		return lblInfo;
	}

	public JTextField getTextField() {
		return textField;
	}

	public JTextField getTxtTtulo() {
		return txtTtulo;
	}

	public JTextField getTextAnyoN() {
		return textAnyoN;
	}

	public JTextField getTextAnyoP() {
		return textAnyoP;
	}

	public JTextField getTextEditorial() {
		return textEditorial;
	}

	public JTextField getTextNumP() {
		return textNumP;
	}

	public JTextField getTextAutor() {
		return textAutor;
	}

	public void setTextArea(JTextArea textArea) {
		this.textArea = textArea;
	}

	public JButton getBtnLoadId() {
		return btnLoadId;
	}

	public JButton getBtnClear() {
		return btnClear;
	}
}
