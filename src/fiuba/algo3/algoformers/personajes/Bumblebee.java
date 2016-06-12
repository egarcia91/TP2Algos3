package fiuba.algo3.algoformers.personajes;

import fiuba.algo3.algoformers.AlgoFormer;
import fiuba.algo3.algoformers.Alterno;
import fiuba.algo3.algoformers.Humanoide;

public class Bumblebee extends AlgoFormer {

	public Bumblebee(){
		super();
		this.nombre = "Bumblebee";
	}

	@Override
	public void transformarAlterno(){
		this.estado = new Alterno();
		this.estado.setVida(350);
		this.estado.setFuerzaAtaque(20);
		this.estado.setDistanciaAtaque(3);
		this.estado.setVelocidad(5);
		this.estado.setTerrestre(true);
	}

	@Override
	public void transformarHumanoide(){
		this.estado = new Humanoide();
		this.estado.setVida(350);
		this.estado.setFuerzaAtaque(40);
		this.estado.setDistanciaAtaque(1);
		this.estado.setVelocidad(2);
		this.estado.setTerrestre(true);
	}

}
