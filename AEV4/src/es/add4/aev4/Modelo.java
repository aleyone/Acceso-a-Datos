package es.add4.aev4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Modelo {

	/**
	 * leemos el fichero csv y lo vamos introduciendo en la tabla con el m�todo
	 * a�adirBBDD
	 * 
	 * @param fichero le pasamos el nombre del fichero
	 */
	public void leerFichero(String ficheroOrigen) {
		vaciarTabla(); // Garantizamos que al leer un CSV tenemos la tabla vac�a
		File file = new File(ficheroOrigen);
		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String linea = br.readLine();
			linea = br.readLine();
			while (linea != null) {
				String[] datos = linea.split(";");
				a�adirBBDD(datos);
				linea = br.readLine();
			}
			br.close();
			fr.close();
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Se introduce la tabla en la BBDD.
	 * 
	 * @param datos se le pasan los argumentos del csv
	 */
	public void a�adirBBDD(String[] datos) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/aev4_libreria", "root", "");
			PreparedStatement psInsertar = con.prepareStatement(
					"INSERT INTO libros (titulo, autor, a�o_nac, a�o_pub, editorial, num_pag) VALUES (?,?,?,?,?,?)");
			for (int i = 0; i < datos.length; i++) { // Si encuentra alg�n dato vac�o a�ade N.C.
				if (datos[i].equals("")) {
					datos[i] = "N.C.";
				}
			}
			psInsertar.setString(1, datos[0]);
			psInsertar.setString(2, datos[1]);
			psInsertar.setString(3, datos[2]);
			psInsertar.setString(4, datos[3]);
			psInsertar.setString(5, datos[4]);
			psInsertar.setString(6, datos[5]);
			int resultadoInsertar = psInsertar.executeUpdate();

			psInsertar.close();
			con.close();
		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
		}

	}

	public void vaciarTabla() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/aev4_libreria", "root", "");
			PreparedStatement psBorrar = con.prepareStatement("DELETE FROM libros");
			PreparedStatement psActualizarId = con.prepareStatement("ALTER TABLE libros AUTO_INCREMENT = 1");
			psBorrar.executeUpdate();
			psActualizarId.executeUpdate();
			psActualizarId.close();
			psBorrar.close();
			con.close();
		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * se recoge la SQL desde la vista, se utiliza para pasar las consultas
	 * gen�ricas "Libros" y "Editorial"
	 */
	public String consultaPersonalizada(String consulta) {
		String linea = "";
		String resultado = "";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/aev4_libreria", "root", "");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(consulta); // se ejecuta la Query
			int numColumnas = rs.getMetaData().getColumnCount();
			//String cabecera = rs.getMetaData().getColumnName();
			while (rs.next()) {
				for (int i = 1; i <= numColumnas; i++) {

					linea += ((rs.getMetaData().getColumnName(i)+": "+rs.getString(i) + "\t"));
				}
				linea += "\n";

			}
			rs.close();
			stmt.close();
			con.close();
		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
		}
		return linea;
	}

	/**
	 * Se crea un m�todo para exportar la tabla existente en PhpMyAdmin a CSV
	 * 
	 * @param ficheroDestino
	 */
	public void exportarCSV(String ficheroDestino) {
		File file = new File(ficheroDestino);
		if (file.exists()) {
			file.delete();
		}
		String[] cabecera = { "Id", "titulo", "autor", "a�o nacimiento", "a�o publicaci�n", "editorial",
				"n�mero de p�ginas" };
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/aev4_libreria", "root", "");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM libros");
			int numColumnas = rs.getMetaData().getColumnCount();
			try {
				FileWriter fw = new FileWriter(file);
				BufferedWriter bw = new BufferedWriter(fw);
				for (int z = 0; z < cabecera.length; z++) {
					bw.write(cabecera[z] + ";");

				}
				bw.newLine();
				while (rs.next()) {
					for (int i = 1; i <= numColumnas; i++) {
						bw.write(rs.getString(i) + ";");
					}
					bw.newLine();

				}
				bw.close();
				fw.close();

			} catch (IOException e) {
				JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
			}
		} catch (ClassNotFoundException e1) {
			JOptionPane.showMessageDialog(new JFrame(), e1.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
		} catch (SQLException e2) {
			JOptionPane.showMessageDialog(new JFrame(), e2.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
		}

	}
}
