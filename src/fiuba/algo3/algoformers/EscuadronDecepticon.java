package fiuba.algo3.algoformers;

import fiuba.algo3.algoformers.Tablero;

public class EscuadronDecepticon extends Escuadron {

	public EscuadronDecepticon(){
		this.algoFormers.add(new Megatron("Humanoide"));
		this.algoFormers.add(new Bonecrusher("Humanoide"));
		this.algoFormers.add(new Frenzy("Humanoide"));
	}

}
