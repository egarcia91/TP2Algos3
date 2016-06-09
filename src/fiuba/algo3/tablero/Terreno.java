package fiuba.algo3.tablero;

public class Terreno {
	private String nombre;
	private int velocidad = 1;
	private int penalizacionVida = 0;
	private int penalizacionTurnos = 0;
	private int penalizacionAtaque = 0;

	public int getVelocidad(){
		return this.velocidad;
	}

	public int getPenalizacionVida(){
		return this.penalizacionVida;
	}

	public int getPenalizacionAtaque(){
		return this.penalizacionAtaque;
	}

	public int getPenalizacionTurnos(){
		return this.penalizacionTurnos;
	}

	public String getNombre(){
		return this.nombre;
	}

	public void setVelocidad(int unaVelocidad){
		this.velocidad = unaVelocidad;
	}

	public void setPenalizacionVida(int unaPenalizacionVida){
		this.penalizacionVida = unaPenalizacionVida;
	}

	public void setPenalizacionAtaque(int unaPenalizacionAtaque){
		this.penalizacionAtaque = unaPenalizacionAtaque;
	}

	public void setPenalizacionTurnos(int unaPenalizacionTurnos){
		this.penalizacionTurnos = unaPenalizacionTurnos;
	}

	public void setNombre(String unNombre){
		this.nombre = unNombre;
	}

	public boolean tienePenalizacion(){
		return ((this.penalizacionTurnos != 0) || (this.penalizacionAtaque != 0) || (this.penalizacionVida != 0));
	}
}
