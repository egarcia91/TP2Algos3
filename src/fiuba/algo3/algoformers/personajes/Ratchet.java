package fiuba.algo3.algoformers.personajes;

import fiuba.algo3.algoformers.AlgoFormer;
import fiuba.algo3.algoformers.Alterno;
import fiuba.algo3.algoformers.Humanoide;

public class Ratchet extends AlgoFormer {

	public Ratchet(){
		super();
		this.nombre = "Ratchet";
	}

	@Override
	public void transformarAlterno(){
		this.estado = new Alterno();
		this.estado.setVida(150);
		this.estado.setFuerzaAtaque(35);
		this.estado.setDistanciaAtaque(2);
		this.estado.setVelocidad(8);
		this.estado.setTerreno("aerea");
	}

	@Override
	public void transformarHumanoide(){
		this.estado = new Humanoide();
		this.estado.setVida(150);
		this.estado.setFuerzaAtaque(5);
		this.estado.setDistanciaAtaque(5);
		this.estado.setVelocidad(1);
		this.estado.setTerreno("terrestre");
	}

}
