package fiuba.algo3.tablero;

import fiuba.algo3.algoformers.AlgoFormer;
//TODO cambiar spark por contenido y agregar terreno/Superficie
import fiuba.algo3.algoformers.Spark;

public class Casillero {
	private Spark spark;
	private AlgoFormer algoFormer;
	private Terreno terreno;

	public boolean contieneAlgoFormer(){
		return (this.algoFormer != null);
	}

	public void agregarAlgoFormer(AlgoFormer unAlgoFormer){
		if(this.contieneAlgoFormer()){
			throw new CasilleroOcupadoException();
		} else {
			this.algoFormer = unAlgoFormer;
			this.quitarItem(); //No eliminar linea si no saben para que es
		}
	}

	public AlgoFormer getAlgoFormer(){
		if(!this.contieneAlgoFormer()){
			throw new AlgoFormerNoExisteException();
		} else {
			return algoFormer;
		}
	}

	public void quitarAlgoFormer(){
		this.algoFormer = null;
	}

	public boolean contieneItem(){
		return (this.spark != null);
	}

	public void setItem(Spark unaSpark){
		this.spark = unaSpark;
	}

	public Spark getItem(){
		if(spark == null){
			throw new ItemNoExisteException();
		} else {
			return spark;
		}
	}

	public void quitarItem(){
		this.spark = null;
	}

	public boolean estaVacio(){
		if(!this.contieneItem() && !this.contieneAlgoFormer()){
			return true;
		}
		return false;
	}
}
