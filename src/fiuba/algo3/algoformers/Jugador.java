package fiuba.algo3.algoformers;

import java.util.ArrayList;
import java.util.List;

import fiuba.algo3.algoformers.AlgoFormer;
import fiuba.algo3.algoformers.Juego;

public class Jugador {

	private String nombre;
	protected Juego juego;
	private List<AlgoFormer> escuadron = new ArrayList<AlgoFormer>();

	public void setNombre(String unNombre){
		this.nombre = unNombre;
	}

	public String getNombre(){
		return this.nombre;
	}

	public void asignarEscuadron(List<AlgoFormer> unEscuadron){
		this.escuadron.addAll(unEscuadron);
	}

	public boolean existeEscuadron(){
		return (this.escuadron.size() != 0);
	}

	public int cantidadAlgoFormer(){
		return this.escuadron.size();
	}

	public boolean tieneAlgoFormerEnPosicion(int x, int y){
		for (AlgoFormer unAlgoFormer:
				this.escuadron){
			if (unAlgoFormer.estaEnPosicion(x,y)) {
				return true;
			}
		}
		return false;
	}

	public void moverAlgoFormer(){
		if(this.juego.esTurnoJugador(this)){
			this.juego.cambiarTurnoJugador();
			//BLA BLA;
		} else {
		}
	}



}
