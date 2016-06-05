package fiuba.algo3.algoformers;

public class EscuadronAutobot extends Escuadron {

	public EscuadronAutobot(){
		this.algoFormers.add(new OptimusPrime());
		this.algoFormers.add(new Ratchet());
		this.algoFormers.add(new Bumblebee());
	}
}
