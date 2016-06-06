package fiuba.algo3.algoformers;

import fiuba.algo3.algoformers.AlgoFormer;
//TODO cambiar spark por contenido y agregar terreno/Superficie
import fiuba.algo3.algoformers.Spark;
import fiuba.algo3.algoformers.CasilleroOcupadoException;

public class Casillero {
	private Spark spark;
	private AlgoFormer algoFormer;

	public boolean tieneAlgoFormer(){
		return this.algoFormer != null;
	}

	public boolean tieneContenido(){
		return this.spark != null;
	}

	public boolean estaVacio(){
		if(this.tieneContenido() || this.tieneAlgoFormer()){
			return false;
		}
		return true;
	}

	public void agregarContenido(Spark unaSpark){
		this.spark = unaSpark;
	}

	public boolean existeContenido(Spark unaSpark){
		if(this.tieneContenido()){
			return this.spark.getNombre() == unaSpark.getNombre();
		}
		return false;
	}

	public Spark quitarContenido(){
		Spark copiaSpark = this.spark;
		this.spark = null;
		return copiaSpark;
	}

	public void agregarAlgoFormer(AlgoFormer unAlgoFormer){
		if(this.tieneAlgoFormer()){
			if(!this.existeAlgoFormer(unAlgoFormer)){
				throw new CasilleroOcupadoException();
			}
		} else {
			Spark spark = this.quitarContenido();
			//TODO Que hacemo si no es la Chispa Suprema? Punto Bonusss
//			if(spark != null){
//				unAlgoFormer.agregarContenido??
//			}
			this.algoFormer = unAlgoFormer;
		}
	}

	public boolean existeAlgoFormer(AlgoFormer unAlgoFormer){
		if(this.tieneAlgoFormer()){
			return this.algoFormer.getNombre() == unAlgoFormer.getNombre();
		}
		return false;
	}

	public void quitarAlgoFormer(){
		this.algoFormer = null;
	}
}
