package fiuba.algo3.tablero;

import fiuba.algo3.algoformers.AlgoFormer;

public class Casillero {
	private Item item;
	private AlgoFormer algoFormer;
	private Terreno terrenoTierra;
	private Terreno terrenoAire;

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
		return (this.item != null);
	}

	public void setItem(Item item){
		this.item = item;
	}

	public Item getItem(){
		if(item == null){
			throw new ItemNoExisteException();
		} else {
			return item;
		}
	}

	public void quitarItem(){
		this.item = null;
	}

	public boolean estaVacio(){
		if(!this.contieneItem() && !this.contieneAlgoFormer()){
			return true;
		}
		return false;
	}

	public Terreno getTerrenoTerrestre() {
		return terrenoTierra;
	} 
	
	public Terreno getTerrenoAereo(){
		return terrenoAire;
	}
}
