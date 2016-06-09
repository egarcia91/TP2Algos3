package fiuba.algo3.tablero;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import fiuba.algo3.algoformers.AlgoFormer;
import fiuba.algo3.algoformers.EscuadronAutobot;
import fiuba.algo3.algoformers.EscuadronDecepticon;
import fiuba.algo3.algoformers.Humanoide;

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

	public Tablero getTablero(){
		return this.tablero;
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
	
	public void agregarAlgoFormer(AlgoFormer algoFormer){
		Random rand = new Random();
		boolean ubicacionExitosa = false;
		while(!ubicacionExitosa){
			try{
				this.tablero.agregarAlgoFormer(algoFormer,Math.round(rand.nextInt(tableroAncho)), Math.round(rand.nextInt(tableroAlto)));
				ubicacionExitosa = true;
				algoFormer.setJuego(this);
			}catch(CasilleroOcupadoException e){};
		}
	}
	
	public void moverAlgoFormer(AlgoFormer algoFormer, int x, int y){
		moverAlgoFormer(algoFormer, new Posicion(x,y));
	}

	public void moverAlgoFormer(AlgoFormer algoFormer, Posicion posRelativa){
		Posicion posicionActual = tablero.getPosicion(algoFormer);
		Posicion posicionFinal = posicionActual.getSuma(posRelativa);
		
		while(!posicionActual.equals(posicionFinal)){
			Posicion posicionTentativa = posicionActual.getSuma(posRelativa.normalizar());
			Casillero casillero = tablero.getCasillero(posicionTentativa);
			if(algoFormer.getTipoUnidad() == "Terrestre"){
				String nombreTerreno = casillero.getTerrenoTerrestre().getClass().getName();
				
				switch(nombreTerreno){
					case "Espinas":
						algoFormer.setVida((int)Math.floor(algoFormer.getVida() * 0.95));
						break;
					case "Pantano":
						if(algoFormer.getEstado().getClass() == Humanoide.class){
							return;
						}
						break;
					case "Rocosa":
						break;
				}
			}	
			else{
				String nombreTerreno = casillero.getTerrenoAereo().getClass().getName();
				switch(nombreTerreno){
					case "Nube":
						break;
					case "TormentaPsionica":
						algoFormer.afectarPorTormentaPsionica();
						break;
					case "NebulosaDeAndromeda":
						algoFormer.penalizarTurnos(3);
						return;
				}

			}
			tablero.moverAlgoFormer(algoFormer, posicionTentativa);
			posicionActual = posicionTentativa;
			posRelativa = posicionFinal.getResta(posicionActual);
		}
	}
}
