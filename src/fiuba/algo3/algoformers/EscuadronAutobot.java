package fiuba.algo3.algoformers;

import fiuba.algo3.algoformers.personajes.Bumblebee;
import fiuba.algo3.algoformers.personajes.OptimusPrime;
import fiuba.algo3.algoformers.personajes.Ratchet;

public class EscuadronAutobot extends Escuadron {
	
	public EscuadronAutobot(){
		this.nombre = "Autobot";
		this.agregarAlgoFormer(new OptimusPrime());
		this.agregarAlgoFormer(new Ratchet());
		this.agregarAlgoFormer(new Bumblebee());
	}

}
