package fiuba.algo3.tablero;

public abstract class Item {
	
	public String getNombre(){
		return this.getClass().getName();
	}
	public boolean esSpark(){
		return false;
	}
}
