package fiuba.algo3.tablero;

public abstract class Item implements Contenido {
	protected String nombre = "Item";
	private int cantidadTurnosDuracion = 0;
	private int factorBonificacionPoderAtaque = 1;
	private int factorBonificacionVelocidad = 1;
	private boolean proteccionDeAtaque = false;

	public String getNombre(){
		return this.nombre;
	}

	public void setCantidadTurnosDuracion(int duracion){
		cantidadTurnosDuracion = duracion;
	}
	
	public void setFactorBonificacionPoderAtaque(int factor){
		factorBonificacionPoderAtaque = factor;
	}
	
	public void setFactorBonificacionVelocidad(int factor){
		factorBonificacionVelocidad = factor;
	}
	
	public int getCantidadTurnosDuracion(){
		return cantidadTurnosDuracion;
	}
	
	public int getFactorBonificacionPoderAtaque(){
		return factorBonificacionPoderAtaque;
	}
	
	public int getFactorBonificacionVelocidad(){
		return factorBonificacionVelocidad;
	}
	
	public void setProteccionDeAtaque(boolean protect){
		proteccionDeAtaque = protect;
	}
	
	public boolean getProteccionDeAtaque(){
		return proteccionDeAtaque;
	}
	
	//Metodos de interfaz contenido
	
	@Override
	public boolean estaVacio(){
		return false;
	}

	@Override
	public boolean esAlgoFormer(){
		return false;
	}

	@Override
	public boolean esSpark(){
		return false;
	}
	
	@Override
	public boolean esBonus(){
		return true;
	}	
	
	public void disminuirTurnosDuracion(){
		cantidadTurnosDuracion--;
	}

}
