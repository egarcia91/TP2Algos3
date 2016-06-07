package fiuba.algo3.algoformers;

import fiuba.algo3.tablero.Tablero;

//import java.lang.Math;

public class AlgoFormer {

	protected Tablero tablero;
	protected EstadoAlgoformer estado;

	protected String nombre = "Algoformer";

//	protected Posicion posicion;

	public AlgoFormer(){
		this.transformarHumanoide();
	}

	public String getNombre(){
		return this.nombre;
	}

	public int getVida(){
		return estado.getVida();
	}

	public int getFuerzaAtaque(){
		return estado.getFuerzaAtaque();
	}

	public int getDistanciaAtaque(){
		return estado.getDistanciaAtaque();
	}

	public int getVelocidad(){
		return estado.getVelocidad();
	}
	
	public String getTipoUnidad(){
		return estado.getTerreno();
	}

	public EstadoAlgoformer getEstado(){
		return this.estado;
	}

	public void transformarAlterno(){
		this.estado = new Alterno();
		estado.setVida(500);
		estado.setFuerzaAtaque(15);
		estado.setDistanciaAtaque(4);
		estado.setVelocidad(5);
		estado.setTerreno("terrestre");
	}

	public void transformarHumanoide(){
		this.estado = new Humanoide();
		estado.setVida(500);
		estado.setFuerzaAtaque(50);
		estado.setDistanciaAtaque(2);
		estado.setVelocidad(2);
		estado.setTerreno("terrestre");
	}

//	//mueve al algoFormer a una posicion absoluta del tablero. Podria haerse tambien un movimiento relativo.
//	void mover(int posX, int posY){
//		//primero me fijo si esa posicion esta dentro del rango de movimiento del algoformer.
//		if(!(Math.abs(this.posicion.getX() - posX) <= estado.getVelocidad() && Math.abs(this.posicion.getY() - posY )<= estado.getVelocidad()))
//			throw new MovimientoFueraDeRangoException();
//		else if(this.tablero.tieneAlgoFormer(posX,posY))
//			throw new CasilleroOcupadoException();
//		else{
//			this.tablero.quitarAlgoFormer(posX,posY);
//			this.tablero.agregarAlgoFormer(this,posX,posY);
//			this.posicion.setPosicion(posX,posY);
//		}
//	}

	public void moverDerecha(){
		tablero.moverDerecha(this,this.estado.getVelocidad());
	}

	public void moverIzquierda(){
		tablero.moverIzquierda(this,this.estado.getVelocidad());
	}

	public void moverArriba(){
		tablero.moverArriba(this,this.estado.getVelocidad());
	}

	public void moverAbajo(){
		tablero.moverAbajo(this,this.estado.getVelocidad());
	}

	public void atacar(){
		this.tablero.ataqueZona(this,this.estado.getDistanciaAtaque(),this.estado.getFuerzaAtaque());
	}

	public boolean estaEnPosicion(int x, int y){
		return this.tablero.existeAlgoFormer(this, x, y);
	}

	public void recibirAtaque(int fuerzaAtaque){
		estado.setVida(estado.getVida()-fuerzaAtaque);
	}
}
