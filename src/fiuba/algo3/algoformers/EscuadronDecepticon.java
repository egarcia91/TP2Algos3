package fiuba.algo3.algoformers;

import fiuba.algo3.algoformers.personajes.Bonecrusher;
import fiuba.algo3.algoformers.personajes.Frenzy;
import fiuba.algo3.algoformers.personajes.Megatron;

public class EscuadronDecepticon extends Escuadron {

	public EscuadronDecepticon(){
		this.agregarAlgoFormer(new Megatron());
		this.agregarAlgoFormer(new Bonecrusher());
		this.agregarAlgoFormer(new Frenzy());
	}

}
