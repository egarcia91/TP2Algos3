package fiuba.algo3.algoformers;

public class EstadoAlgoformer{
	private int vida;
	private int velocidad;
	private int fuerzaAtaque;
	private int distanciaAtaque;
	private String terreno;

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

	public String getTerreno(){
		return this.terreno;
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

	public void setTerreno(String unTerreno){
		this.terreno = unTerreno;
	}

	public boolean estaEnRango(int deltaX,int deltaY){
		return(this.velocidad <= deltaX && this.velocidad <= deltaY);
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
