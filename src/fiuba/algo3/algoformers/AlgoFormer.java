package fiuba.algo3.algoformers;

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


	public void mover(Posicion posRelativa){
		//if(!this.estado.estaEnRango(deltaX,deltaY))
		//	throw new MovimientoFueraDeRangoException();
		this.tablero.moverAlgoFormer(this,posRelativa);
	}

	public void moverDerecha(){
		tablero.moverAlgoFormer(this,1,0);
	}

	public void moverIzquierda(){
		tablero.moverAlgoFormer(this,-1,0);
	}

	public void moverArriba(){
		tablero.moverAlgoFormer(this,0,1);
	}

	public void moverAbajo(){
		tablero.moverAlgoFormer(this,0,-1);
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
