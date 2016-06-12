package fiuba.algo3.tablero;

public abstract class Item {
	private String nombre = "Item";

	public String getNombre(){
		return this.nombre;
	}

	public boolean esSpark(){
		return false;
	}

	public boolean estaVacio(){
		return false;
	}
}
