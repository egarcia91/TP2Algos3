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
		estado.setVida(500);
		estado.setFuerzaAtaque(15);
		estado.setDistanciaAtaque(4);
		estado.setVelocidad(5);
		estado.setTerreno("terrestre");
	}

	@Override
	public void transformarHumanoide(){
		this.estado = new Humanoide();
		estado.setVida(500);
		estado.setFuerzaAtaque(50);
		estado.setDistanciaAtaque(2);
		estado.setVelocidad(2);
		estado.setTerreno("terrestre");
	}

}
