package fiuba.algo3.algoformers;

import fiuba.algo3.algoformers.Tablero;
import fiuba.algo3.algoformers.Posicion;
import fiuba.algo3.algoformers.CasilleroOcupadoException;
import fiuba.algo3.algoformers.MovimientoFueraDeRangoException;
import java.lang.Math;


public class AlgoFormer {

	protected Tablero tablero;
	private EstadoAlgoformer estado;

	protected String nombre = "Algoformer";
	protected int vidaHumanoide = 500;
	protected int fuerzaAtaqueHumanoide = 50;
	protected int distanciaAtaqueHumanoide = 2;
	protected int velocidadHumanoide = 2;
	protected String unidadHumanoide = "terrestre";
	protected int vidaAlterno = 500;
	protected int fuerzaAtaqueAlterno = 15;
	protected int distanciaAtaqueAlterno = 4;
	protected int velocidadAlterno = 5;
	protected String unidadAlterno = "terrestre";
	protected String tipoUnidad;
	protected Posicion posicion;

	public AlgoFormer(){
		estado = new Humanoide();
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
	
	public String tipoUnidad(){
		return this.tipoUnidad;
	}

	public EstadoAlgoformer getEstado(){
		return this.estado;
	}

	public void transformarAlterno(){
		this.estado = new Alterno();
		estado.setVida(this.vidaAlterno);
		estado.setFuerzaAtaque(this.fuerzaAtaqueAlterno);
		estado.setDistanciaAtaque(this.distanciaAtaqueAlterno);
		estado.setVelocidad(this.velocidadAlterno);
		this.tipoUnidad = this.unidadAlterno;
	}

	public void transformarHumanoide(){
		this.estado = new Humanoide();
		estado.setVida(this.vidaHumanoide);
		estado.setFuerzaAtaque(this.fuerzaAtaqueHumanoide);
		estado.setDistanciaAtaque(this.distanciaAtaqueHumanoide);
		estado.setVelocidad(this.velocidadHumanoide);
		this.tipoUnidad = this.unidadHumanoide;
	}

	//mueve al algoFormer a una posicion absoluta del tablero. Podria haerse tambien un movimiento relativo.
	void mover(int posX, int posY){
		//primero me fijo si esa posicion esta dentro del rango de movimiento del algoformer.
		if(!(Math.abs(this.posicion.getX() - posX) <= estado.getVelocidad() && Math.abs(this.posicion.getY() - posY )<= estado.getVelocidad()))
			throw new MovimientoFueraDeRangoException();
		else if(this.tablero.tieneAlgoFormer(posX,posY))
			throw new CasilleroOcupadoException();
		else{
			this.tablero.quitarAlgoFormer(posX,posY);
			this.tablero.agregarAlgoFormer(this,posX,posY);
			this.posicion.setPosicion(posX,posY);
		}
	}

	public void moverDerecha(){
		tablero.moverDerecha(this,estado.getVelocidad());
	}

	public void moverIzquierda(){
		tablero.moverIzquierda(this,estado.getVelocidad());
	}

	public void moverArriba(){
		tablero.moverArriba(this,estado.getVelocidad());
	}

	public void moverAbajo(){
		tablero.moverAbajo(this,estado.getVelocidad());
	}

	public void atacar(){
		this.tablero.ataqueZona(this,estado.getDistanciaAtaque(),estado.getFuerzaAtaque());
	}

	public boolean estaEnPosicion(int x, int y){
		return this.tablero.existeAlgoFormer(this, x, y);
	}

	public void recibirAtaque(int fuerzaAtaque){
		estado.setVida(estado.getVida()-fuerzaAtaque);
	}
}
