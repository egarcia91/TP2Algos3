package fiuba.algo3.algoformers;

import java.util.ArrayList;
import java.util.List;

import fiuba.algo3.algoformers.Jugador;
import fiuba.algo3.algoformers.AlgoFormer;
import fiuba.algo3.algoformers.OptimusPrime;
import fiuba.algo3.algoformers.Ratchet;
import fiuba.algo3.algoformers.Bumblebee;
import fiuba.algo3.algoformers.Megatron;
import fiuba.algo3.algoformers.Bonecrusher;
import fiuba.algo3.algoformers.Frenzy;

public class Juego {
	private Tablero tablero;
	private List<Jugador> jugadores;
	private Jugador turnoJugador;
	
	Juego(){
		tablero = new Tablero(20,20);
		jugadores = new ArrayList<Jugador>();
	}

	private List<AlgoFormer> escuadronAutoBot = new ArrayList<AlgoFormer>(){{
		add(new OptimusPrime("Humanoide"));
		add(new Ratchet("Humanoide"));
		add(new Bumblebee("Humanoide"));
	}};

	private List<AlgoFormer> escuadronDecepticon = new ArrayList<AlgoFormer>(){{
		add(new Megatron("Humanoide"));
		add(new Bonecrusher("Humanoide"));
		add(new Frenzy("Humanoide"));
	}};

	public void agregarJugador(Jugador unJugador){
		if (this.jugadores.size()==0) {
			this.jugadores.add(unJugador);
			unJugador.juego = this;
			unJugador.asignarEscuadron(escuadronAutoBot);
			this.tablero.agregarEscuadron(escuadronAutoBot);
		}
		else {
			this.jugadores.add(unJugador);
			unJugador.asignarEscuadron(escuadronDecepticon);
			this.tablero.agregarEscuadron(escuadronDecepticon);
		}
	}

	public boolean existeJugador(Jugador unJugador){
		for (Jugador jugador: this.jugadores) {
			if(jugador.getNombre() == unJugador.getNombre()){
				return true;
			}
		}
		return false;
	}

	public void iniciar(){
		turnoJugador = jugadores.get(0);
	}

	public boolean esTurnoJugador(Jugador unJugador){
		return turnoJugador.getNombre() == unJugador.getNombre();
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
