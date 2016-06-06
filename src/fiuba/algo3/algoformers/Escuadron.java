package fiuba.algo3.algoformers;

import java.util.ArrayList;
import java.util.List;

public class Escuadron {

	protected List<AlgoFormer> algoFormers = new ArrayList<AlgoFormer>();

	public void agregarAlgoFormer(AlgoFormer unAlgoFormer){
		this.algoFormers.add(unAlgoFormer);
	}

	public boolean existeEscuadron(){
		return (this.algoFormers.size() != 0);
	}

	public int cantidadMiembrosEscuadron(){
		return this.algoFormers.size();
	}

	public boolean estaAlgoformerEnPosicion(int x, int y){
		for (AlgoFormer unAlgoFormer:
				this.algoFormers){
			if (unAlgoFormer.estaEnPosicion(x,y)) {
				return true;
			}
		}
		return false;
	}

	public boolean perteneceAlgoformer(AlgoFormer unAlgoFormer) {
		for (AlgoFormer eachAlgoFormer :
				algoFormers) {
//			if (eachAlgoFormer.getNombre() == unAlgoFormer.getNombre()) {
//				return true;
//			}
		}
		return false;
	}


}
