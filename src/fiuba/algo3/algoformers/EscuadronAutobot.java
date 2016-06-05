package fiuba.algo3.algoformers;

import fiuba.algo3.algoformers.Tablero;

public class EscuadronAutobot extends Escuadron {

	public EscuadronAutobot(){
		this.algoFormers.add(new OptimusPrime("Humanoide"));
		this.algoFormers.add(new Ratchet("Humanoide"));
		this.algoFormers.add(new Bumblebee("Humanoide"));
	}
}
