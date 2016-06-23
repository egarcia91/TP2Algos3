package fiuba.algo3.tablero;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import fiuba.algo3.algoformers.EscuadronAutobot;
import fiuba.algo3.algoformers.EscuadronDecepticon;

public class Juego {
	private static final int TABLERO_ANCHO = 26;
	private static final int TABLERO_ALTO = 15;

	private Tablero tablero;
	private List<Jugador> jugadores;
	private int turnoJugador;
	public EscuadronAutobot escuadronAutobot; 
	public EscuadronDecepticon escuadronDecepticon;

	public Juego(){
		new Juego(Juego.TABLERO_ANCHO,Juego.TABLERO_ALTO);
	}
	
	public Juego(int anchoTablero, int altoTablero){
		tablero = new Tablero(anchoTablero,altoTablero);
		jugadores = new ArrayList<Jugador>();
		escuadronAutobot = new EscuadronAutobot();
		escuadronDecepticon = new EscuadronDecepticon();
		this.ubicarSpark(tablero);
	}

	public Tablero getTablero(){
		return this.tablero;
	}
	
	public Jugador getJugadorTurno(){
		return this.jugadores.get(this.turnoJugador);
	}
	public void ubicarSpark(Tablero tablero){
		Random rand = new Random();
		int randX = Math.round((Juego.TABLERO_ANCHO/2) + rand.nextInt(2));
		int randY = Math.round((Juego.TABLERO_ALTO/2) + rand.nextInt(2));
		tablero.setItem(new Spark(),randX,randY);
	}

	public void agregarJugador(Jugador unJugador){
		int cantidadJugadores = jugadores.size();
		if(cantidadJugadores == 0){
			this.agregarJugadorUno(unJugador);
		} else if(cantidadJugadores == 1){
			this.agregarJugadorDos(unJugador);
		} else {
			throw new NoSePuedenAgregarMasJugadoresException();
		}
	}

	public void agregarJugadorUno(Jugador unJugador){
		this.jugadores.add(unJugador);
		unJugador.setJuego(this);
		unJugador.asignarEscuadron(escuadronAutobot);
		this.tablero.agregarEscuadron(escuadronAutobot);
	}

	public void agregarJugadorDos(Jugador unJugador){
		this.jugadores.add(unJugador);
		unJugador.setJuego(this);
		unJugador.asignarEscuadron(escuadronDecepticon);
		this.tablero.agregarEscuadron(escuadronDecepticon);
	}

	public boolean existeJugador(Jugador unJugador){
		return jugadores.contains(unJugador);
	}

	public void iniciar(){
		turnoJugador = 0;
	}

	public boolean esTurnoJugador(Jugador unJugador){
		return (jugadores.get(turnoJugador) == unJugador);
	}

	public void cambiarTurnoJugador(){
		this.jugadores.get(this.turnoJugador).resetSelection();
		if(this.turnoJugador == (jugadores.size()-1)){
			this.turnoJugador = 0;
		} else {
			this.turnoJugador++;
		}
	}

	public int getTableroAncho(){
		return Juego.TABLERO_ANCHO;
	}

	public int getTableroAlto(){
		return Juego.TABLERO_ALTO;
	}

}
