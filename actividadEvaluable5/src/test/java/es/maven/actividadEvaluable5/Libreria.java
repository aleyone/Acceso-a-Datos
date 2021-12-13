package es.maven.actividadEvaluable5;

public class Libreria {
	private int id, num_pag;
	private String titulo, autor, año_nac, año_pub, editorial;
	
	public Libreria() {
		
	}
	
	public Libreria(String titulo, String autor, String año_nac, String año_pub, String editorial, int num_pag) {
		this.titulo=titulo;
		this.autor=autor;
		this.año_nac=año_nac;
		this.año_pub=año_pub;
		this.editorial=editorial;
		this.num_pag=num_pag;
	}
	
	public Libreria(int id, String titulo, String autor, String año_nac, String año_pub, String editorial, int num_pag) {
		this.id=id;
		this.titulo=titulo;
		this.autor=autor;
		this.año_nac=año_nac;
		this.año_pub=año_pub;
		this.editorial=editorial;
		this.num_pag=num_pag;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNum_pag() {
		return num_pag;
	}

	public void setNum_pag(int num_pag) {
		this.num_pag = num_pag;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getAño_nac() {
		return año_nac;
	}

	public void setAño_nac(String año_nac) {
		this.año_nac = año_nac;
	}

	public String getAño_pub() {
		return año_pub;
	}

	public void setAño_pub(String año_pub) {
		this.año_pub = año_pub;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}
	
	public String OneToText() {
		return "\nRegistro --> Id: "+getId()+"\nTitulo: "+getTitulo()+"\nAutor: "+getAutor()+"\nAño Nacimiento: "+getAño_nac()+"\nAño Publicación: "+getAño_pub()+"\nEditorial: "+getEditorial()+"\nNum. Páginas: "+getNum_pag();
	}
	
	public String AllToText() {
		return "Registro --> Id: "+getId()+"\nTitulo: "+getTitulo()+"\n";
	}
}
