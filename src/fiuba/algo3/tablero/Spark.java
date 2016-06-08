package fiuba.algo3.tablero;

public class Spark {
	private static Spark instance = new Spark();
	
	private String nombre = "Spark";

	private Spark(){};
	
	public static Spark getInstance(){
		return instance;
	}
	
	public String getNombre(){
		return this.nombre;
	}
}
