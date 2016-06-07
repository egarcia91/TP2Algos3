package fiuba.algo3.tablero;

import fiuba.algo3.algoformers.Escuadron;

public class Jugador {

	private String nombre;
	protected Juego juego;
	private Escuadron escuadron;

	public void setNombre(String unNombre){
		this.nombre = unNombre;
	}

	public String getNombre(){
		return this.nombre;
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
