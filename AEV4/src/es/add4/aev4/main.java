package es.add4.aev4;

public class main {

	public static void main(String[] args) {
		Modelo modelo = new Modelo();
		Vista2 vista = new Vista2();
		Controlador controlador = new Controlador(modelo, vista);
	}

}
