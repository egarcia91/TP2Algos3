package fiuba.algo3.algoformers;

import java.util.ArrayList;
import java.util.List;

public class Juego {
	private Tablero tablero;
	private List<Jugador> jugadores;
	private Jugador turnoJugador;
	public EscuadronAutobot escuadronAutobot = new EscuadronAutobot();
	public EscuadronDecepticon escuadronDecepticon = new EscuadronDecepticon();

	public Juego(){
		tablero = new Tablero(20,20);
		jugadores = new ArrayList<Jugador>();
	}

	public void agregarJugadorUno(Jugador unJugador){
		this.jugadores.add(unJugador);
		unJugador.juego = this;
		unJugador.asignarEscuadron(escuadronAutobot);
		this.tablero.agregarEscuadron(escuadronAutobot);
	}

	public void agregarJugadorDos(Jugador unJugador){
		this.jugadores.add(unJugador);
		unJugador.juego = this;
		unJugador.asignarEscuadron(escuadronDecepticon);
		this.tablero.agregarEscuadron(escuadronDecepticon);
	}

	public boolean existeJugador(Jugador unJugador){
		for (Jugador jugador: this.jugadores) {
//			if(jugador.getNombre() == unJugador.getNombre()){
//				return true;
//			}
		}
		return false;
	}

	public void iniciar(){
		turnoJugador = jugadores.get(0);
	}

	public boolean esTurnoJugador(Jugador unJugador){
//		return turnoJugador.getNombre() == unJugador.getNombre();
		return false;
	}

	public void cambiarTurnoJugador(){
		for(Jugador unJugador: this.jugadores){
			if(!esTurnoJugador(unJugador)){
				turnoJugador = unJugador;
			}
		}
	}

	public int tableroAncho(){
		return this.tablero.getAncho();
	}

	public int tableroAlto(){
		return this.tablero.getAlto();
	}

}
