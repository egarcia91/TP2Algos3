package fiuba.algo3.algoformers.personajes;

import fiuba.algo3.algoformers.AlgoFormer;
import fiuba.algo3.algoformers.Alterno;
import fiuba.algo3.algoformers.Humanoide;

public class OptimusPrime extends AlgoFormer {

	public OptimusPrime(){
		super();
		this.nombre = "Optimus Prime";
	}

	@Override
	public void transformarAlterno(){
		this.estado = new Alterno();
		this.estado.setVida(500);
		this.estado.setFuerzaAtaque(15);
		this.estado.setDistanciaAtaque(4);
		this.estado.setVelocidad(5);
		this.estado.setTerreno("terrestre");
	}

	@Override
	public void transformarHumanoide(){
		this.estado = new Humanoide();
		this.estado.setVida(500);
		this.estado.setFuerzaAtaque(50);
		this.estado.setDistanciaAtaque(2);
		this.estado.setVelocidad(2);
		this.estado.setTerreno("terrestre");
	}

}
