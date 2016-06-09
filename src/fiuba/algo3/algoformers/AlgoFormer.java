package fiuba.algo3.algoformers;

import fiuba.algo3.tablero.CasilleroOcupadoException;
import fiuba.algo3.tablero.MovimientoFueraDeRangoException;
import fiuba.algo3.tablero.Posicion;
import fiuba.algo3.tablero.Tablero;

public class AlgoFormer {

	protected Tablero tablero;
	protected EstadoAlgoformer estado;

	protected String nombre = "Algoformer";

	public AlgoFormer(){
		this.transformarHumanoide();
	}

	public String getNombre(){
		return this.nombre;
	}

	public int getVida(){
		return this.estado.getVida();
	}

	public int getFuerzaAtaque(){
		return this.estado.getFuerzaAtaque();
	}

	public int getDistanciaAtaque(){
		return this.estado.getDistanciaAtaque();
	}

	public int getVelocidad(){
		return this.estado.getVelocidad();
	}
	
	public String getTipoUnidad(){
		return this.estado.getTerreno();
	}

	public EstadoAlgoformer getEstado(){
		return this.estado;
	}

	public void transformarAlterno(){
		this.estado = new Alterno();
		this.estado.setVida(500);
		this.estado.setFuerzaAtaque(15);
		this.estado.setDistanciaAtaque(4);
		this.estado.setVelocidad(5);
		this.estado.setTerreno("terrestre");
	}

	public void transformarHumanoide(){
		this.estado = new Humanoide();
		this.estado.setVida(500);
		this.estado.setFuerzaAtaque(50);
		this.estado.setDistanciaAtaque(2);
		this.estado.setVelocidad(2);
		this.estado.setTerreno("terrestre");
	}


	public void mover(Posicion posRelativa){
		if(this.movimientoPosible(posRelativa)){
			this.tablero.moverAlgoFormer(this,posRelativa);
		} else {
			throw new MovimientoFueraDeRangoException();
		}
	}

	private boolean movimientoPosible(Posicion posicion){
		int velocidad = this.getVelocidad();
		velocidad = velocidad*velocidad;
		int x = posicion.getX();
		x = x*x;
		int y = posicion.getY();
		y = y*y;
		return (x <= velocidad && y <= velocidad); //Circunferencia de alcance
	}

	public void moverDerecha(){
		this.tablero.moverAlgoFormer(this,1,0);
	}

	public void moverIzquierda(){
		this.tablero.moverAlgoFormer(this,-1,0);
	}

	public void moverArriba(){
		this.tablero.moverAlgoFormer(this,0,-1);
	}

	public void moverAbajo(){
		this.tablero.moverAlgoFormer(this,0,1);
	}

	public void atacar(){
		this.tablero.ataqueZona(this,this.estado.getDistanciaAtaque(),this.estado.getFuerzaAtaque());
	}

	public boolean estaEnPosicion(int x, int y){
		return this.tablero.existeAlgoFormer(this, x, y);
	}

	public void recibirAtaque(int fuerzaAtaque){
		this.estado.setVida(this.estado.getVida()-fuerzaAtaque);
	}

	public void setTablero(Tablero tablero) {
		this.tablero = tablero;
	}
}
