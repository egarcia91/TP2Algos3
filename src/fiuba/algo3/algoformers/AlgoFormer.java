package fiuba.algo3.algoformers;

import fiuba.algo3.tablero.CasilleroOcupadoException;
import fiuba.algo3.tablero.MovimientoFueraDeRangoException;
import fiuba.algo3.tablero.Posicion;
import fiuba.algo3.tablero.Movimiento;
import fiuba.algo3.tablero.Tablero;
import fiuba.algo3.tablero.Ataque;

public class AlgoFormer {

	protected Movimiento movimiento;
	protected EstadoAlgoformer estado;
	protected int turnosCastigo = 0;
	protected int penalizacionAtaque = 0;
	public Ataque ataque;

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

	public void setPenalizacionAtaque(int unPenalizacion){
		this.penalizacionAtaque = unPenalizacion;
	}

	public int getPenalizacionAtaque(){
		return this.penalizacionAtaque;
	}

	public void setTurno(int unTurno){
		this.turnosCastigo = unTurno;
	}

	public void setVida(int unaVida){
		this.estado.setVida(unaVida);
	}

	public int getFuerzaAtaque(){
		return this.estado.getFuerzaAtaque();
	}

	public void setFuerzaAtaque(int unAtaque){
		this.estado.setFuerzaAtaque(unAtaque);
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


//	public void mover(Posicion posRelativa){
//		if(this.movimientoPosible(posRelativa)){
//			this.tablero.moverAlgoFormer(this,posRelativa);
//		} else {
//			throw new MovimientoFueraDeRangoException();
//		}
//	}

//	private boolean movimientoPosible(Posicion posicion){
//		int velocidad = this.getVelocidad();
//		velocidad = velocidad*velocidad;
//		int x = posicion.getX();
//		x = x*x;
//		int y = posicion.getY();
//		y = y*y;
//		return (x <= velocidad && y <= velocidad); //Circunferencia de alcance
//	}

	public void moverDerecha(){
		if(this.turnosCastigo == 0){
			this.movimiento.moverAlgoFormerDerecha(this,this.getVelocidad());
		} else {
			this.turnosCastigo--;
		}
	}

	public void moverIzquierda(){
		if(this.turnosCastigo == 0){
			this.movimiento.moverAlgoFormerIzquierda(this,this.getVelocidad());
		} else {
			this.turnosCastigo--;
		}
	}

	public void moverArriba(){
		if(this.turnosCastigo == 0){
			this.movimiento.moverAlgoFormerArriba(this,this.getVelocidad());
		} else {
			this.turnosCastigo--;
		}
	}

	public void moverAbajo(){
		if(this.turnosCastigo == 0){
			this.movimiento.moverAlgoFormerAbajo(this,this.getVelocidad());
		} else {
			this.turnosCastigo--;
		}
	}

	/*public void atacar(){
		this.tablero.ataqueZona(this,this.estado.getDistanciaAtaque(),this.estado.getFuerzaAtaque());
	}*/

	public void atacar() { this.ataque.ataqueZona(this, this.estado.getDistanciaAtaque(),this.estado.getFuerzaAtaque());}

	public boolean estaEnPosicion(int x, int y){
//		return this.tablero.existeAlgoFormer(this, x, y);
		return false;
	}

	public void recibirAtaque(int fuerzaAtaque){
		this.estado.setVida(this.estado.getVida()-fuerzaAtaque);
	}

	public void setMovimiento(Movimiento unMovimiento) {
		this.movimiento = unMovimiento;
	}
}
