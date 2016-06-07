package fiuba.algo3.tablero;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import fiuba.algo3.algoformers.EscuadronAutobot;
import fiuba.algo3.algoformers.EscuadronDecepticon;
import fiuba.algo3.algoformers.Spark;

public class Juego {
	private static final int TABLERO_ANCHO = 200;
	private static final int TABLERO_ALTO = 200;
	
	private Tablero tablero;
	private List<Jugador> jugadores;
	private int turnoJugador;
	public EscuadronAutobot escuadronAutobot; 
	public EscuadronDecepticon escuadronDecepticon;
	
	public Juego(){
		tablero = new Tablero(TABLERO_ANCHO,TABLERO_ALTO);
		jugadores = new ArrayList<Jugador>();
		escuadronAutobot = new EscuadronAutobot();
		escuadronDecepticon = new EscuadronDecepticon();
		this.ubicarSpark(tablero);
	}

	public void ubicarSpark(Tablero tablero){
		Random rand = new Random();
		int randX = Math.round((TABLERO_ANCHO/2) + rand.nextInt(2));
		int randY = Math.round((TABLERO_ALTO/2) + rand.nextInt(2));
		tablero.setItem(new Spark(),randX,randY);
	}
	
	
	public void agregarJugador(Jugador unJugador){
		this.jugadores.add(unJugador);
		unJugador.setJuego(this);
		int cantidadJugadores = jugadores.size();
		if(cantidadJugadores == 0){
			unJugador.asignarEscuadron(escuadronAutobot);
			this.tablero.agregarEscuadron(escuadronAutobot);	
		}	
		else if(cantidadJugadores == 1){
			unJugador.asignarEscuadron(escuadronDecepticon);
			this.tablero.agregarEscuadron(escuadronDecepticon);	
		}
		else
			throw new NoSePuedenAgregarMasJugadoresException();
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
		if(turnoJugador == jugadores.size()) turnoJugador = 0;
		else turnoJugador++;
	}

	public int tableroAncho(){
		return TABLERO_ANCHO;
	}

	public int tableroAlto(){
		return TABLERO_ALTO;
	}

}
