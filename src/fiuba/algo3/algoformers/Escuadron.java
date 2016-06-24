package fiuba.algo3.algoformers;

import java.util.ArrayList;
import java.util.List;

public class Escuadron {

	//private List<AlgoFormer> algoFormers;
	protected ArrayList<AlgoFormer> algoFormers;
	protected String nombre;

	public Escuadron(){
		algoFormers = new ArrayList<AlgoFormer>();
	}

	//TODO Esta clase debe ser iterable
	public AlgoFormer getAlgoFormer(int number){
		if(number >= algoFormers.size() || number < 0) number = 0;
		return this.algoFormers.get(number);

	}

	public ArrayList<AlgoFormer> getAlgoFormers(){
		return algoFormers;
	}
	
	public void agregarAlgoFormer(AlgoFormer unAlgoFormer){
		this.algoFormers.add(unAlgoFormer);
		unAlgoFormer.setEscuadron(this);
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
			if (eachAlgoFormer == unAlgoFormer) {
				return true;
			}
		}
		return false;
	}

	public String getNombre() {
		return nombre;
	}

}
