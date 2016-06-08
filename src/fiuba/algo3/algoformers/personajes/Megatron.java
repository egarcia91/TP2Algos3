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
		this.estado.setVida(550);
		this.estado.setFuerzaAtaque(55);
		this.estado.setDistanciaAtaque(2);
		this.estado.setVelocidad(8);
		this.estado.setTerreno("aerea");
	}

	@Override
	public void transformarHumanoide(){
		this.estado = new Humanoide();
		this.estado.setVida(550);
		this.estado.setFuerzaAtaque(10);
		this.estado.setDistanciaAtaque(3);
		this.estado.setVelocidad(1);
		this.estado.setTerreno("terrestre");
	}

}
