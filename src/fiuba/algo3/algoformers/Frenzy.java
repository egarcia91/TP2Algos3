package fiuba.algo3.algoformers;

public class Frenzy extends AlgoFormer {

	public Frenzy(){
		super();
		this.nombre = "Frenzy";
	}

	@Override
	public void transformarAlterno(){
		this.estado = new Alterno();
		estado.setVida(400);
		estado.setFuerzaAtaque(25);
		estado.setDistanciaAtaque(2);
		estado.setVelocidad(6);
		estado.setTerreno("terrestre");
	}

	@Override
	public void transformarHumanoide(){
		this.estado = new Humanoide();
		estado.setVida(400);
		estado.setFuerzaAtaque(10);
		estado.setDistanciaAtaque(5);
		estado.setVelocidad(2);
		estado.setTerreno("terrestre");
	}

}
