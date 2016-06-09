package fiuba.algo3.tablero;

public class Spark extends Item{
	private static Spark instance = new Spark();
	
	private Spark(){};
	
	public static Spark getInstance(){
		return instance;
	}
}
