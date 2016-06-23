package fiuba.algo3.tablero;

import fiuba.algo3.algoformers.Escuadron;
import fiuba.algo3.algoformers.AlgoFormer;
import fiuba.algo3.algoformers.AlgoFormerVacio;
import java.util.ArrayList;
import java.util.List;

public class Jugador {

	private String nombre;
	protected Juego juego;
	private Escuadron escuadron;
	private Escuadron escuadronRivalAtacable = new Escuadron();
	public ArrayList<Casillero> posiblesMovimientos = new ArrayList<Casillero>();
	private int indiceAlgoFormer = 0;
	private int indiceAlgoFormerRival = 0;
	private int indiceAccion = 0;
	private boolean selectAlgoFormer = false;
	private boolean selectAlgoFormerRival = false;
	private boolean selectMovimiento = false;
	private boolean selectAccion = false;

	public Jugador(String nombre) {
		this.nombre = nombre;
	}

	public void setNombre(String unNombre){
		this.nombre = unNombre;
	}

	public void resetSelection(){
		this.selectAlgoFormer = false;
		this.selectAccion = false;
		this.selectAlgoFormerRival = false;
		this.posiblesMovimientos = new ArrayList<Casillero>();
	}

	public void selectMovimiento(){
		this.selectMovimiento = true;
		this.juego.cambiarTurnoJugador();
	}

	public void selectAlgoFormer(){
		this.selectAlgoFormer = true;
	}

	public void deselectAlgoFormer(){
		this.selectAlgoFormer = false;
	}

	public void selectAlgoFormerRival(){
		this.selectAlgoFormerRival = true;

		AlgoFormer unAlgoFormerRival = this.getSelectAlgoFormerRival();
		AlgoFormer algoFormerActual = this.getSelectAlgoFormer();
		algoFormerActual.atacar(unAlgoFormerRival);
		this.juego.cambiarTurnoJugador();
	}

	public void deselectAccion(){
		this.selectAccion = false;
		this.posiblesMovimientos = new ArrayList<Casillero>();
		this.escuadronRivalAtacable = new Escuadron();
	}

	public void selectAccion(){
		this.selectAccion = true;
		switch(this.indiceAccion){
			case 0:
				this.atacarAlgoFormer();
				break;
			case 1:
				this.moverAlgoFormer();
				break;
			case 2:
				this.transformarAlgoFormer();
				break;
			default:
				break;
		}
	}

	public boolean estaSeleccionadoAlgoFormer(){
		return this.selectAlgoFormer;
	}

	public boolean estaSeleccionadoAlgoFormerRival(){
		return this.selectAlgoFormerRival;
	}

	public boolean estaSeleccionadoAccion(){
		return this.selectAccion;
	}

	public String getNombre(){
		return this.nombre;
	}

	public AlgoFormer getSelectAlgoFormer(){
		return this.escuadron.getAlgoFormer(this.indiceAlgoFormer);
	}

	public AlgoFormer getSelectAlgoFormerRival(){
		return this.escuadronRivalAtacable.getAlgoFormer(this.indiceAlgoFormerRival);
	}

	//TODO Deshardcodear indice accion
	public void nextAccion(){
		if(this.indiceAccion == 2){
			this.indiceAccion = 0;
		} else {
			this.indiceAccion++;
		}
	}

	//TODO Deshardcodear indice accion
	public void prevAccion(){
		if(this.indiceAccion == 0){
			this.indiceAccion = 2;
		} else {
			this.indiceAccion--;
		}
	}

	public int getSelectAccion(){
		return this.indiceAccion;
	}

	public void nextAlgoFormerRival(){
		int cantidadAlgoFormers = this.escuadronRivalAtacable.cantidadMiembrosEscuadron();
		if(this.indiceAlgoFormerRival == (cantidadAlgoFormers-1)){
			this.indiceAlgoFormerRival = 0;
		} else {
			this.indiceAlgoFormerRival++;
		}
	}

	public void prevAlgoFormerRival(){
		int cantidadAlgoFormers = this.escuadronRivalAtacable.cantidadMiembrosEscuadron();
		if(this.indiceAlgoFormerRival == 0){
			this.indiceAlgoFormerRival = (cantidadAlgoFormers-1);
		} else {
			this.indiceAlgoFormerRival--;
		}
	}

	public void nextAlgoFormer(){
		int cantidadAlgoFormers = this.escuadron.cantidadMiembrosEscuadron();
		if(this.indiceAlgoFormer == (cantidadAlgoFormers-1)){
			this.indiceAlgoFormer = 0;
		} else {
			this.indiceAlgoFormer++;
		}
	}

	public void prevAlgoFormer(){
		int cantidadAlgoFormers = this.escuadron.cantidadMiembrosEscuadron();
		if(this.indiceAlgoFormer == 0){
			this.indiceAlgoFormer = (cantidadAlgoFormers-1);
		} else {
			this.indiceAlgoFormer--;
		}
	}

	public void asignarEscuadron(Escuadron unEscuadron){
		this.escuadron = unEscuadron;
	}

	public boolean existeEscuadron(){
		return (this.escuadron.existeEscuadron());
	}

	public int cantidadAlgoFormer(){
		return this.escuadron.cantidadMiembrosEscuadron();
	}

	public boolean tieneAlgoFormerEnPosicion(int x, int y){
		return (this.escuadron.estaAlgoformerEnPosicion( x, y));
	}

	public void moverAlgoFormer(){
		AlgoFormer unAlgoFormer = this.escuadron.getAlgoFormer(this.indiceAlgoFormer);

		Movimiento movimiento = unAlgoFormer.getMovimiento();
		this.posiblesMovimientos = movimiento.posiblesMovimientos(unAlgoFormer, unAlgoFormer.getVelocidad());
	}

	public void transformarAlgoFormer(){
		AlgoFormer unAlgoFormer = this.escuadron.getAlgoFormer(this.indiceAlgoFormer);
		if(unAlgoFormer.esHumanoide()){
			unAlgoFormer.transformarAlterno();
		} else {
			unAlgoFormer.transformarHumanoide();
		}
		this.juego.cambiarTurnoJugador();
	}

	public void atacarAlgoFormer(){
		AlgoFormer unAlgoFormer = this.escuadron.getAlgoFormer(this.indiceAlgoFormer);
		this.escuadronRivalAtacable = unAlgoFormer.getAlgoformersEnRango();
	}

	public void setJuego(Juego juego) {
		this.juego = juego;
	}

}
