package fiuba.algo3.algoformers;

public class Bonecrusher extends AlgoFormer {

	public Bonecrusher(){
		super();
		this.nombre = "Bonecrusher";
	}

	@Override
	public void transformarAlterno(){
		this.estado = new Alterno();
		estado.setVida(200);
		estado.setFuerzaAtaque(30);
		estado.setDistanciaAtaque(3);
		estado.setVelocidad(8);
		estado.setTerreno("terrestre");
	}

	@Override
	public void transformarHumanoide(){
		this.estado = new Humanoide();
		estado.setVida(200);
		estado.setFuerzaAtaque(30);
		estado.setDistanciaAtaque(3);
		estado.setVelocidad(1);
		estado.setTerreno("terrestre");
	}

}
