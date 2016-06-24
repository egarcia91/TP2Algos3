package fiuba.algo3.tablero;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import fiuba.algo3.algoformers.EscuadronAutobot;
import fiuba.algo3.algoformers.EscuadronDecepticon;

public class Juego {

	private static final int MAX_BONUS_TABLERO = 12;
	private static final int NUMERO_BONUS_POSIBLES = 3;
	private int tableroAncho = 12;
	private int tableroAlto = 12;

	private Tablero tablero;
	private List<Jugador> jugadores;
	private int turnoJugador;
	public EscuadronAutobot escuadronAutobot; 
	public EscuadronDecepticon escuadronDecepticon;

	public Juego(){
		new Juego(this.tableroAncho,this.tableroAlto);
	}
	
	public Juego(int anchoTablero, int altoTablero){
		tablero = new Tablero(anchoTablero,altoTablero);
		this.tableroAncho = anchoTablero;
		this.tableroAlto = altoTablero;
		jugadores = new ArrayList<Jugador>();
		escuadronAutobot = new EscuadronAutobot();
		escuadronDecepticon = new EscuadronDecepticon();
		this.ubicarSpark(tablero);
		this.ubicarBonus(tablero);
	}

	public Tablero getTablero(){
		return this.tablero;
	}
	
	public Jugador getJugadorTurno(){
		return this.jugadores.get(this.turnoJugador);
	}
	public void ubicarSpark(Tablero tablero){
		Random rand = new Random();
		int randX = Math.round((this.tableroAncho/2) + rand.nextInt(2));
		int randY = Math.round((this.tableroAlto/2) + rand.nextInt(2));
		tablero.setItem(new Spark(),randX,randY);
	}

	public void ubicarBonus(Tablero tablero){
		Random rand = new Random();
		int randomNumberItems = rand.nextInt(MAX_BONUS_TABLERO);
		
		for(int i = 0; i < randomNumberItems ; i++){
			boolean bonusPudoSerUbicado = false;
			while(!bonusPudoSerUbicado){
				int randX = rand.nextInt(this.tableroAncho);
				int randY = rand.nextInt(this.tableroAlto);
				if(tablero.getCasillero(randX, randY).estaVacio() == true){
					int randItem = rand.nextInt(NUMERO_BONUS_POSIBLES);
					Item unItem;
					switch(randItem){
						case 0:
							unItem = new CanionDoble();
							break;
						case 1:
							unItem = new Flash();
							break;
						default:
							unItem = new BurbujaInmaculada();
							break;
					}
					tablero.setItem(unItem, randX, randY);
					bonusPudoSerUbicado = true;
				}
			}
		}
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
		return this.tableroAncho;
	}

	public int getTableroAlto(){
		return this.tableroAlto;
	}

}
