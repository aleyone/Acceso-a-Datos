package es.add.aemongodb;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.json.JSONObject;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

public class Modelo {
	
	public MongoCollection createConnection() {
		MongoClient client = new MongoClient ("localhost", 27017);
		MongoDatabase db = client.getDatabase("Discos");
		MongoCollection<Document> collection = db.getCollection("Discos");

		return collection;
	}

	public String showAll (MongoCollection collection) {
		String unido="";
		List<String> resultado = new ArrayList<String>();
		MongoCursor<Document> cursor= collection.find().iterator();
		while(cursor.hasNext()) {
		String fragmento = cursor.next().toJson();
		resultado.add(fragmento);
		}
		for (int i=0;i<resultado.size();i++) {
			unido += resultado.get(i)+"\n";
		}
		return unido;
	}

	public String readCriteria(MongoCollection collection, String criterio, String busqueda) {
		String unido="";
		List<String> resultado = new ArrayList<String>();
		MongoCursor<Document> cursor= collection.find(Filters.eq(criterio,busqueda)).iterator();
		while(cursor.hasNext()) {
			JSONObject obj= new JSONObject(cursor.next().toJson());
			resultado.add("Grupo: "+obj.getString("Grupo")+" - "+"Titulo: "+obj.getString("Titulo")+" - "+"Formato: "+obj.getString("Formato")+" - "+"A�o: "+obj.getInt("Anyo"));
		}
		for (int i=0;i<resultado.size();i++) {
			unido += resultado.get(i)+"\n";
		}
		return unido;
	}
	
	public String readCriteria(MongoCollection collection, String criterio, int busqueda) {
		String unido="";
		List<String> resultado = new ArrayList<String>();
		MongoCursor<Document> cursor= collection.find(Filters.eq(criterio,busqueda)).iterator();
		while(cursor.hasNext()) {
			JSONObject obj= new JSONObject(cursor.next().toJson());
			resultado.add("Grupo: "+obj.getString("Grupo")+" - "+"Titulo: "+obj.getString("Titulo")+" - "+"Formato: "+obj.getString("Formato")+" - "+"A�o: "+obj.getInt("Anyo"));		}
		for (int i=0;i<resultado.size();i++) {
			unido += resultado.get(i)+"\n";
		}
		return unido;
	}
	
	public void createRegistry (MongoCollection collection, String grupo, String titulo, int publicacion, String formato) {
		Document doc = new Document();
		doc.append("Grupo", grupo);
		doc.append("Titulo", titulo);
		doc.append("Anyo", publicacion);
		doc.append("Formato", formato);
		collection.insertOne(doc);
		
	}

	public void updateRegistry(MongoCollection collection, String criterio, String busqueda, String arg) {
		
			collection.updateMany(Filters.eq(criterio,busqueda), new Document("$set", new Document(criterio, arg)));
		
	}
	
	public void updateRegistry(MongoCollection collection, String criterio, int busqueda, int arg) {
		
		collection.updateMany(Filters.eq(criterio,busqueda), new Document("$set", new Document(criterio, arg)));
	
}

	public void deleteMany(MongoCollection collection, String criterio, String busqueda) {
		collection.deleteMany(Filters.eq(criterio, busqueda));
		
	}
	
	public void deleteMany(MongoCollection collection, String criterio, int busqueda) {
		collection.deleteMany(Filters.eq(criterio, busqueda));
		
	}
	
	public void loadCSV (File fichero) {
		MongoCollection collection = createConnection();
		try {
			FileReader fr = new FileReader(fichero);
			BufferedReader br = new BufferedReader(fr);
			String linea = br.readLine();
			linea = br.readLine();
			while (linea != null) {
				String[] datos = linea.split(",");
				int anyo = (int) Integer.parseInt(datos[0]);
				String formato = datos[1];
				String grupo = datos[2];
				String titulo = datos[3];
				createRegistry(collection, grupo, titulo, anyo, formato);
				linea = br.readLine();
			}
			br.close();
			fr.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}

