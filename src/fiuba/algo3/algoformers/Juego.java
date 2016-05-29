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
	private List<Jugador> jugadores = new ArrayList<Jugador>();

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
		this.jugadores.add(unJugador);
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
		//No hacemos nada
	}
}
