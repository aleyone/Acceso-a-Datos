//package es.maven.actividadEvaluable5;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
//import org.hibernate.cfg.Configuration;
//import org.hibernate.service.ServiceRegistry;
//
//public class main_backup {
//
//	public static void main(String[] args) {
//		Session connection = createConnection();
//		List listado = listBooks(connection);		
//		showBooks(connection, listado);		
//		
//
//			
//	}
//	
//	static Session createConnection() {
//		Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
//		configuration.addClass(Libreria.class);
//		ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
//		SessionFactory sessionFactory = configuration.buildSessionFactory(registry);
//		Session session = sessionFactory.openSession();
//		session.beginTransaction();
//		
//		return session;
//	}
//	
//	static List listBooks (Session session) {
//		List listaLibros = new ArrayList();
//		listaLibros = session.createQuery("FROM Libreria").list();
//		return listaLibros;
//	}
//	
//	static void showBooks (Session session, List listaLibros) {
//		listBooks(session);
//		for (Object n : listaLibros) {
//			Libreria libros = (Libreria) n;
//			libros.toText();
//		}
//	}
//	
//	static void showOneBook (Session session, int id) {
//		Libreria libro = (Libreria) session.get(Libreria.class, id);
//		libro.toText();
//	}
//
//	static void addBook(Session session, String titulo, String autor, String año_nac, String año_pub, String editorial, int num_pag) {
//		Libreria newBook = new Libreria(titulo, autor, año_nac, año_pub, editorial, num_pag);
//		session.save(newBook);
//	}	
//	
//	static void updateBook(Session session, int id) {
//		Libreria libroUpdate = (Libreria) session.load(Libreria.class, id);
//		libroUpdate.setTitulo("Titulo modificado 1");
//		libroUpdate.setAutor("Autor modificado");
//		session.update(libroUpdate);
//	}
//	
//	static void deleteBook(Session session, int id) {
//		Libreria del = new Libreria();
//		del.setId(id);
//		session.delete(del);
//	}
//	
//	static void closeSession(Session session) {
//		session.getTransaction().commit();
//		session.close();
//	}
//}
