package fiuba.algo3.algoformers;

public class EscuadronAutobot extends Escuadron {

	public EscuadronAutobot(){
		this.agregarAlgoFormer(new OptimusPrime());
		this.agregarAlgoFormer(new Ratchet());
		this.agregarAlgoFormer(new Bumblebee());
	}

}
