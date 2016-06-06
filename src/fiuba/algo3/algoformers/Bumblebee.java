package fiuba.algo3.algoformers;

public class Bumblebee extends AlgoFormer {

	public Bumblebee(){
		super();
		this.nombre = "Bumblebee";
	}

	@Override
	public void transformarAlterno(){
		this.estado = new Alterno();
		estado.setVida(350);
		estado.setFuerzaAtaque(20);
		estado.setDistanciaAtaque(3);
		estado.setVelocidad(5);
		estado.setTerreno("terrestre");
	}

	@Override
	public void transformarHumanoide(){
		this.estado = new Humanoide();
		estado.setVida(350);
		estado.setFuerzaAtaque(40);
		estado.setDistanciaAtaque(1);
		estado.setVelocidad(2);
		estado.setTerreno("terrestre");
	}

}
