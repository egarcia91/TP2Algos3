package fiuba.algo3.algoformers.personajes;

import fiuba.algo3.algoformers.AlgoFormer;
import fiuba.algo3.algoformers.Alterno;
import fiuba.algo3.algoformers.Humanoide;

public class Megatron extends AlgoFormer {

	public Megatron(){
		super();
		this.nombre = "Megatron";
	}

	@Override
	public void transformarAlterno(){
		this.estado = new Alterno();
		estado.setVida(550);
		estado.setFuerzaAtaque(55);
		estado.setDistanciaAtaque(2);
		estado.setVelocidad(8);
		estado.setTerreno("aerea");
	}

	@Override
	public void transformarHumanoide(){
		this.estado = new Humanoide();
		estado.setVida(550);
		estado.setFuerzaAtaque(10);
		estado.setDistanciaAtaque(3);
		estado.setVelocidad(1);
		estado.setTerreno("terrestre");
	}

}
