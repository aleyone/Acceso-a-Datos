package es.maven.actividadEvaluable5;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class Modelo {
	//Session connection = createConnection();
	//List listado = listBooks(connection);
//	showBooks(connection, listado);

	public Session createConnection() {
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
		configuration.addClass(Libreria.class);
		ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties())
				.build();
		SessionFactory sessionFactory = configuration.buildSessionFactory(registry);
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		return session;
	}

	public List listBooks(Session session) {
		List listaLibros = new ArrayList();
		listaLibros = session.createQuery("FROM Libreria").list();
		return listaLibros;
	}

	public String showBooks(Session session, List listado) {

		String result = "";
		try {
			for (Object n : listado) {
				Libreria libros = (Libreria) n;
				result += libros.AllToText();
			}
		} catch (NullPointerException e) {
			result = "No estás conectado a la BBDD. Conéctate antes: " + e;
		}
		return result;

	}

	public String showOneBook(Session session, int id) {
		String result="";
		Libreria libro= new Libreria();
		try {
		libro = (Libreria) session.get(Libreria.class, id);
		} catch (NullPointerException e) {
			result="No estás conectado a la BBDD. Conéctate antes: "+e;
		}
		result = libro.OneToText();
		return result;
	}

	public String[] detailsBook (Session session, int id) {
		String[] result=new String[6];
		Libreria libro = (Libreria) session.get(Libreria.class, id);
		result[0]=libro.getTitulo();
		result[1]=libro.getAutor();
		result[2]=libro.getAño_nac();
		result[3]=libro.getAño_pub();
		result[4]=libro.getEditorial();
		result[5]=String.valueOf(libro.getNum_pag());
		return result;
	}
	
	public int createBook(Session session, String titulo, String autor, String año_nac, String año_pub,
			String editorial, int num_pag) {
		Libreria newBook = new Libreria(titulo, autor, año_nac, año_pub, editorial, num_pag);
		int id = (int) session.save(newBook);
		session.getTransaction().commit();
		return id;
	}

	public void updateBook(Session session, int id, String titulo, String autor, String año_n, String año_p,
			String editorial, int num_p) {
		Libreria libroUpdate = (Libreria) session.load(Libreria.class, id);
		libroUpdate.setTitulo(titulo);
		libroUpdate.setAutor(autor);
		libroUpdate.setAño_nac(año_n);
		libroUpdate.setAño_pub(año_p);
		libroUpdate.setEditorial(editorial);
		libroUpdate.setNum_pag(num_p);
		session.update(libroUpdate);
		session.getTransaction().commit();
	}

	public void deleteBook(Session session, int id) {
		Libreria del = new Libreria();
		del.setId(id);
		session.delete(del);
		session.getTransaction().commit();
	}

	public void closeSession(Session session, List listado) {
		listado.clear();
		session.close();
	}
}
