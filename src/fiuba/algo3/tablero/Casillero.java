package fiuba.algo3.tablero;

import fiuba.algo3.algoformers.AlgoFormer;
//TODO cambiar spark por contenido y agregar terreno/Superficie
import fiuba.algo3.algoformers.Spark;

public class Casillero {
	private Spark spark;
	private AlgoFormer algoFormer;
	private Terreno terreno;

	public boolean contieneAlgoFormer(){
		return (algoFormer != null); 
	}
	
	public void agregarAlgoFormer(AlgoFormer unAlgoFormer){
		if(this.contieneAlgoFormer() == true){
				throw new CasilleroOcupadoException();
		}
		else
			this.algoFormer = unAlgoFormer;
	}
	
	public AlgoFormer getAlgoFormer(){
		if(algoFormer == null)
			throw new AlgoFormerNoExisteException();
		else
			return algoFormer;
	}
	
	public void quitarAlgoFormer(){
		this.algoFormer = null;
	}
	
	public boolean contieneItem(){
		return (spark != null);
	}
	
	public void setItem(Spark unaSpark){
		this.spark = unaSpark;
	}	
	
	public Spark getItem(){
		if(spark == null)
			throw new ItemNoExisteException();
		else
			return spark;
	}
	
	public void quitarItem(){
		this.spark = null;
	}
	
	public boolean estaVacio(){
		if(this.contieneItem() == false && this.contieneAlgoFormer() == false){
			return true;
		}
		return false;
	}







}
