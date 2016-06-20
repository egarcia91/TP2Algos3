package fiuba.algo3.tablero;

import fiuba.algo3.algoformers.Escuadron;
import fiuba.algo3.algoformers.AlgoFormer;

public class Jugador {

	private String nombre;
	protected Juego juego;
	private Escuadron escuadron;
	private int indiceAlgoFormer = 0;
	private int indiceAccion = 0;
	private boolean selectAlgoFormer = false;
	private boolean selectAccion = false;

	public Jugador(String nombre) {
		this.nombre = nombre;
	}

	public void setNombre(String unNombre){
		this.nombre = unNombre;
	}

	public void selectAlgoFormer(){
		this.selectAlgoFormer = true;
	}

	public void selectAccion(){
		this.selectAccion = true;
	}

	public boolean estaSeleccionadoAlgoFormer(){
		return this.selectAlgoFormer;
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
		if(this.juego.esTurnoJugador(this)){
			this.juego.cambiarTurnoJugador();
			//BLA BLA;
		} else {
		}
	}

	public void setJuego(Juego juego) {
		this.juego = juego;
	}

}
