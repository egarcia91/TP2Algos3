package fiuba.algo3.algoformers;

import fiuba.algo3.tablero.CasilleroOcupadoException;
import fiuba.algo3.tablero.MovimientoFueraDeRangoException;
import fiuba.algo3.tablero.Posicion;
import fiuba.algo3.tablero.Movimiento;
import fiuba.algo3.tablero.Ataque;
import fiuba.algo3.tablero.Contenido;

public class AlgoFormer implements Contenido {

	protected Movimiento movimiento;
	protected EstadoAlgoformer estado;
	protected int turnosCastigo = 0;
	protected int penalizacionAtaque = 0;
	protected Escuadron escuadron;
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

	public void setVelocidad(int unaVelocidad) {
		this.estado.setVelocidad(unaVelocidad);
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

	public boolean esTerrestre(){
		return this.estado.getTerrestre();
	}

	public boolean esAereo(){
		return this.estado.getAereo();
	}

	public boolean esHumanoide(){
		return this.estado.estadoHumanoide();
	}

	public boolean esAlterno(){
		return this.estado.estadoAlterno();
	}

	public void transformarAlterno(){
		this.estado = new Alterno();
		this.estado.setVida(500);
		this.estado.setFuerzaAtaque(15);
		this.estado.setDistanciaAtaque(4);
		this.estado.setVelocidad(5);
		this.estado.setTerrestre(true);
	}

	public void transformarHumanoide(){
		this.estado = new Humanoide();
		this.estado.setVida(500);
		this.estado.setFuerzaAtaque(50);
		this.estado.setDistanciaAtaque(2);
		this.estado.setVelocidad(2);
		this.estado.setTerrestre(true);
	}

	public void mover(Posicion posicion){
		this.movimiento.mover(posicion, this);
	}

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

	public void atacar(AlgoFormer unAlgoFormer) {
		this.ataque.atacar(unAlgoFormer,this.getFuerzaAtaque());
	}

	public boolean estaEnPosicion(int x, int y){
		return this.movimiento.existeAlgoFormer(this, x, y);
	}

	public void recibirAtaque(int fuerzaAtaque){
		this.estado.setVida(this.estado.getVida()-fuerzaAtaque);
	}

	public void setMovimiento(Movimiento unMovimiento) {
		this.movimiento = unMovimiento;
	}

	public Movimiento getMovimiento() {
		return this.movimiento;
	}

	public void setAtaque(Ataque unAtaque) {
		this.ataque = unAtaque;
	}

	public Escuadron getAlgoformersEnRango(){
		return this.ataque.getAlgoformersEnRango(this);
	}
	
	//Metodos de interfaz contenido
	
	@Override
	public boolean estaVacio(){
		return false;
	}

	@Override
	public boolean esAlgoFormer(){
		return true;
	}

	@Override
	public boolean esSpark(){
		return false;
	}
	
	@Override
	public boolean esBonus(){
		return false;
	}

	public void setEscuadron(Escuadron escuadron) {
		this.escuadron = escuadron;
	}
	
	public Escuadron getEscuadron(){
		return this.escuadron;
	}

}
