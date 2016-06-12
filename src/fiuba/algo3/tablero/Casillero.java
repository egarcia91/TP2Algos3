package fiuba.algo3.tablero;

import fiuba.algo3.algoformers.AlgoFormer;

public class Casillero {
	private Item item = new ItemVacio();
	private AlgoFormer algoFormer;

	private Terreno terrenoTerrestre = new Rocosa(); //Por defecto lleno de nada
	private Terreno terrenoAereo = new Nube(); //Por defecto lleno de nada

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
		return (!this.item.estaVacio());
	}

	public void setItem(Item item){
		this.item = item;
	}

	public Item getItem(){
		if(!this.contieneItem()){
			throw new ItemNoExisteException();
		} else {
			return this.item;
		}
	}

	public Terreno getTerrenoTerrestre(){
		return this.terrenoTerrestre;
	}

	public void setTerrenoTerrestre(Terreno unTerreno){
		this.terrenoTerrestre = unTerreno;
	}

	public Terreno getTerrenoAereo(){
		return this.terrenoAereo;
	}

	public void setTerrenoAereo(Terreno unTerreno){
		this.terrenoAereo = unTerreno;
	}

	public void quitarItem(){
		this.item = new ItemVacio();
	}

	public boolean estaVacio(){
		if(!this.contieneItem() && !this.contieneAlgoFormer()){
			return true;
		}
		return false;
	}

}
