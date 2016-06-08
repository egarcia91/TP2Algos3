package fiuba.algo3.tablero;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import fiuba.algo3.algoformers.EscuadronAutobot;
import fiuba.algo3.algoformers.EscuadronDecepticon;

public class Juego {
	private static final int tableroAncho = 200;
	private static final int tableroAlto = 200;

	private Tablero tablero;
	private List<Jugador> jugadores;
	private int turnoJugador;
	public EscuadronAutobot escuadronAutobot; 
	public EscuadronDecepticon escuadronDecepticon;

	public Juego(){
		tablero = new Tablero(Juego.tableroAncho,Juego.tableroAlto);
		jugadores = new ArrayList<Jugador>();
		escuadronAutobot = new EscuadronAutobot();
		escuadronDecepticon = new EscuadronDecepticon();
		this.ubicarSpark(tablero);
	}

	public void ubicarSpark(Tablero tablero){
		Random rand = new Random();
		int randX = Math.round((Juego.tableroAncho/2) + rand.nextInt(2));
		int randY = Math.round((Juego.tableroAlto/2) + rand.nextInt(2));
		tablero.setItem(Spark.getInstance(),randX,randY);
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
		if(turnoJugador == jugadores.size()){
			turnoJugador = 0;
		} else {
			turnoJugador++;
		}
	}

	public int getTableroAncho(){
		return Juego.tableroAncho;
	}

	public int getTableroAlto(){
		return Juego.tableroAlto;
	}

}
