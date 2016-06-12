package fiuba.algo3.algoformers.personajes;

import fiuba.algo3.algoformers.AlgoFormer;
import fiuba.algo3.algoformers.Alterno;
import fiuba.algo3.algoformers.Humanoide;

public class Bonecrusher extends AlgoFormer {

	public Bonecrusher(){
		super();
		this.nombre = "Bonecrusher";
	}

	@Override
	public void transformarAlterno(){
		this.estado = new Alterno();
		this.estado.setVida(200);
		this.estado.setFuerzaAtaque(30);
		this.estado.setDistanciaAtaque(3);
		this.estado.setVelocidad(8);
		this.estado.setTerrestre(true);
	}

	@Override
	public void transformarHumanoide(){
		this.estado = new Humanoide();
		this.estado.setVida(200);
		this.estado.setFuerzaAtaque(30);
		this.estado.setDistanciaAtaque(3);
		this.estado.setVelocidad(1);
		this.estado.setTerrestre(true);
	}

}
