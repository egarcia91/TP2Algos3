package fiuba.algo3.algoformers.personajes;

import fiuba.algo3.algoformers.AlgoFormer;
import fiuba.algo3.algoformers.Alterno;
import fiuba.algo3.algoformers.Humanoide;

public class Frenzy extends AlgoFormer {

	public Frenzy(){
		super();
		this.nombre = "Frenzy";
	}

	@Override
	public void transformarAlterno(){
		this.estado = new Alterno();
		this.estado.setVida(400);
		this.estado.setFuerzaAtaque(25);
		this.estado.setDistanciaAtaque(2);
		this.estado.setVelocidad(6);
		this.estado.setTerrestre(true);
	}

	@Override
	public void transformarHumanoide(){
		this.estado = new Humanoide();
		this.estado.setVida(400);
		this.estado.setFuerzaAtaque(10);
		this.estado.setDistanciaAtaque(5);
		this.estado.setVelocidad(2);
		this.estado.setTerrestre(true);
	}

}
