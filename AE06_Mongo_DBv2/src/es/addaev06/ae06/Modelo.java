package es.addaev06.ae06;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bson.Document;
import org.json.JSONObject;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

public class Modelo {
	private MongoClient client;
	private MongoCollection<Document> collection;
	private MongoCursor<Document> cursor;
	private List<String> id=new ArrayList<String>();
	private String nextId;
	
	/**
	 * createConnection: creamos una conexi�n
	 */
	public void createConection() {
		Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
		mongoLogger.setLevel(Level.SEVERE);
		client = new MongoClient("localhost", 27017);
		MongoDatabase db = client.getDatabase("Biblioteca");
		collection = db.getCollection("Libros");
	}
	
	/**
	 * closeConnection: se cerra la conexi�n
	 */
	public void closeConnection(){
		client.close();
	}

	/**
	 * este m�todo llama a otro, loopList, que se utiliza para obtener la informaci�n m�s actualizada de libros
	 * @return retorna como texto el listado de libros de la colecci�n
	 */
	public String showAll() {
		String resultado="";
		resultado = loopList();
		return resultado;
	}
	
	/**
	 * loopList recorre el listado de libros que hay en la colecci�n. Aprovechamos para a�adir los id,s a una lista para, posteriormente calcular el size de la lista y saber cu�l ser�a el siguiente id
	 * @return se retorna el ID y el t�tulo para que se recupere desde el m�todo showAll
	 */

	public String loopList() {
		
		cursor = collection.find().iterator();
		String resultado="";
		while (cursor.hasNext()) {
			JSONObject obj = new JSONObject(cursor.next().toJson());
			resultado += ("ID: " + obj.getString("Id") + " - TITULO: " + obj.getString("Titol")+"\n");
			id.add(obj.getString("Id"));			
		}
		
		nextId = String.valueOf(id.size()+1);
		id.clear();
		return resultado;
	}
	
	/**
	 * Next_Id recuperamos el siguiente �ndice que se llamar� desde controlador a la hora de crear un nuevo registro
	 * @return se retorna el nuevo id
	 */
	public String Next_Id() {
		return nextId;
	}

	/**
	 * showOne recorre la lista para obtener el detalle del libro
	 * @param id se recoge el id del libro
	 * @return devolvemos el detalle del libro
	 */
	public String showOne(String id) {
		String unido = "";
		cursor = collection.find(Filters.eq("Id", id)).iterator();
		while (cursor.hasNext()) {
			JSONObject obj = new JSONObject(cursor.next().toJson());
			unido = ("_id Mongo: " + obj.get("_id") + "\n" + "Titulo: " + obj.getString("Titol") + "\n" + "Autor: "
					+ obj.getString("Autor") + "\n" + "A�o nacimiento: " + obj.getString("Any_naixement") + "\n"
					+ "A�o publicaci�n: " + obj.getString("Any_publicacio") + "\n" + "Editorial: "
					+ obj.getString("Editorial") + "\n" + "N� p�ginas: " + obj.getString("Nombre_pagines"));
		}
		return unido;
	}
	
	/**
	 * loadId se obtiene el detalle de un libro y se mete en un array de string para poder usar el bot�n cargarID en controlador
	 * @param id se recupera id
	 * @return se retorna el array de string
	 */
	public String[] loadId(String id) {
		String[] unido= new String[6];
		cursor = collection.find(Filters.eq("Id", id)).iterator();
		while (cursor.hasNext()) {
			JSONObject obj = new JSONObject(cursor.next().toJson());
			unido = new String[] {obj.getString("Titol"), obj.getString("Autor"), obj.getString("Any_naixement"),obj.getString("Any_publicacio"), obj.getString("Editorial"), obj.getString("Nombre_pagines")};
		}
		
		return unido;
	}

	/**
	 * createRegistry se llama primero a loopList para tener los valores actualizados
	 * @param id se recupera id
	 * @param titulo se recupera titulo
	 * @param autor se recupera autor
	 * @param anyo_nac se recupera anyo_nac
	 * @param anyo_pub se recupera anyo publicaci�n
	 * @param editorial se recupera editorial
	 * @param num_pag se recupera num_pag
	 * @return se devuelve el id generado
	 */
	public String createRegistry(String id, String titulo, String autor, String anyo_nac, String anyo_pub, String editorial,
			String num_pag) {
		loopList();
		Document doc = new Document();
		doc.append("Id", id);
		doc.append("Titol", titulo);
		doc.append("Autor", autor);
		doc.append("Any_naixement", anyo_nac);
		doc.append("Any_publicacio", anyo_pub);
		doc.append("Editorial", editorial);
		doc.append("Nombre_pagines", num_pag);
		collection.insertOne(doc);
		
		return nextId;
	}
	
	/**
	 * updateRegistry actualizar registro
	 * @param id se recupera id
	 * @param titulo se recupera titulo
	 * @param autor se recupera autor
	 * @param anyo_nac se recupera anyo_nac
	 * @param anyo_pub se recupera anyo publicaci�n
	 * @param editorial se recupera editorial
	 * @param num_pag se recupera num_pag
	 */
	public void updateRegistry (String id, String titulo, String autor, String anyo_nac, String anyo_pub, String editorial, String num_pag) {
		collection.updateMany(Filters.eq("Id",id), new Document("$set", new Document("Titol", titulo)));
		collection.updateMany(Filters.eq("Id",id), new Document("$set", new Document("Autor", autor)));
		collection.updateMany(Filters.eq("Id",id), new Document("$set", new Document("Any_naixement", anyo_nac)));
		collection.updateMany(Filters.eq("Id",id), new Document("$set", new Document("Any_publicacio", anyo_pub)));
		collection.updateMany(Filters.eq("Id",id), new Document("$set", new Document("Editorial", editorial)));
		collection.updateMany(Filters.eq("Id",id), new Document("$set", new Document("Nombre_pagines", num_pag)));
	}
	
	/**
	 * deleteOne eliminar un registro por id
	 * @param id se recupera id
	 */
	public void deleteOne (String id) {
		
		collection.deleteOne(Filters.eq("Id", id));
		
	}
	
	
}
