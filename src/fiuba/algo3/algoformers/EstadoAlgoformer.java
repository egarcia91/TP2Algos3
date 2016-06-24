package fiuba.algo3.algoformers;

import fiuba.algo3.tablero.Posicion;

public class EstadoAlgoformer{
	private int vida;
	private int velocidad;
	private int fuerzaAtaque;
	private int distanciaAtaque;
	private boolean terrestre = false;
	private boolean aereo = false;
	protected String nombreEstado;

	public int getVida(){
		return this.vida;
	}

	public int getVelocidad(){
		return this.velocidad;
	}

	public int getFuerzaAtaque(){
		return this.fuerzaAtaque;
	}

	public int getDistanciaAtaque(){
		return this.distanciaAtaque;
	}

	public boolean getTerrestre(){
		return this.terrestre;
	}

	public boolean getAereo(){
		return this.aereo;
	}
	
	public String getNombreEstado(){
		return this.nombreEstado;
	}

	public void setTerrestre(boolean esTerrestre){
		this.terrestre = esTerrestre;
		this.aereo = !esTerrestre;
	}

	public void setAereo(boolean esAereo){
		this.terrestre = !esAereo;
		this.aereo = esAereo;
	}

	public void setVida(int unaVida){
		this.vida = unaVida;
	}

	public void setVelocidad(int unaVelocidad){
		this.velocidad = unaVelocidad;
	}

	public void setFuerzaAtaque(int unaFuerzaAtaque){
		this.fuerzaAtaque = unaFuerzaAtaque;
	}

	public void setDistanciaAtaque(int unaDistanciaAtaque){
		this.distanciaAtaque = unaDistanciaAtaque;
	}

	public boolean estaEnRango(int deltaX,int deltaY){
		int velocidad = this.velocidad*this.velocidad;
		int x=deltaX*deltaX;
		int y=deltaY*deltaY;
		return(velocidad <= deltaX && velocidad <= deltaY);
	}

	public boolean estaEnRango(Posicion posicionRelativa){
		int velocidad = this.velocidad*this.velocidad;
		int x = posicionRelativa.getX();
		int y = posicionRelativa.getY();
		x=x*x;
		y=y*y;
		return(x <= velocidad && y <= velocidad);
	}

	//Horrible solucion para plantear polimorfismo
	public boolean estadoHumanoide(){
		return false;
	}

	//Horrible solucion para plantear polimorfismo
	public boolean estadoAlterno(){
		return false;
	}

	//TODO Ven porque es horrible
	//	public boolean estadoOtroPosible(){
	//	return false;
	//}
}
