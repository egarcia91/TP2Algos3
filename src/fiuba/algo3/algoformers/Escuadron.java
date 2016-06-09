package fiuba.algo3.algoformers;

import java.util.ArrayList;
import java.util.List;

public class Escuadron {

	//private List<AlgoFormer> algoFormers;
	protected List<AlgoFormer> algoFormers;
	
	public Escuadron(){
		algoFormers = new ArrayList<AlgoFormer>(); 
	}

	//TODO Esta clase debe ser iterable
	public AlgoFormer getAlgoFormer(int number){
		return this.algoFormers.get(number);
	}

	public void agregarAlgoFormer(AlgoFormer unAlgoFormer){
		this.algoFormers.add(unAlgoFormer);
	}

	public boolean existeEscuadron(){
		return (this.algoFormers.size() != 0);
	}

	public int cantidadMiembrosEscuadron(){
		return this.algoFormers.size();
	}
	
	//FIXME Este metodo no tiene sentido, La posicion absoluta solo la puede conoecer tablero
	/*
	public boolean estaAlgoformerEnPosicion(int x, int y){
		for (AlgoFormer unAlgoFormer:
				this.algoFormers){
			if (unAlgoFormer.estaEnPosicion(x,y)) {
				return true;
			}
		}
		return false;
	}
	*/
	public boolean perteneceAlgoformer(AlgoFormer unAlgoFormer) {
		for (AlgoFormer eachAlgoFormer :
				algoFormers) {
			if (eachAlgoFormer == unAlgoFormer) {
				return true;
			}
		}
		return false;
	}


}
