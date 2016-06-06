package fiuba.algo3.algoformers;

public class Ratchet extends AlgoFormer {

	public Ratchet(){
		super();
		this.nombre = "Ratchet";
	}

	@Override
	public void transformarAlterno(){
		this.estado = new Alterno();
		estado.setVida(150);
		estado.setFuerzaAtaque(35);
		estado.setDistanciaAtaque(2);
		estado.setVelocidad(8);
		estado.setTerreno("aerea");
	}

	@Override
	public void transformarHumanoide(){
		this.estado = new Humanoide();
		estado.setVida(150);
		estado.setFuerzaAtaque(5);
		estado.setDistanciaAtaque(5);
		estado.setVelocidad(1);
		estado.setTerreno("terrestre");
	}

}
