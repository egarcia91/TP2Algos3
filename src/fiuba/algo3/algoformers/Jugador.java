package fiuba.algo3.algoformers;

import java.util.ArrayList;
import java.util.List;

import fiuba.algo3.algoformers.AlgoFormer;

public class Jugador {

	private String nombre;
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
		return this.escuadron.isEmpty();
	}

	public int cantidadAlgoFormer(){
		return escuadron.size();
	}

}
