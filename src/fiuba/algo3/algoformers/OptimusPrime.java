package fiuba.algo3.algoformers;

public class OptimusPrime extends AlgoFormer {

	public OptimusPrime(String modo){
		this.nombre = "Optimus Prime";
		this.vidaHumanoide = 500;
		this.fuerzaAtaqueHumanoide = 50;
		this.distanciaAtaqueHumanoide = 2;
		this.velocidadHumanoide = 2;
		this.unidadHumanoide = "terrestre";
		this.vidaAlterno = 500;
		this.fuerzaAtaqueAlterno = 15;
		this.distanciaAtaqueAlterno = 4;
		this.velocidadAlterno = 5;
		this.unidadAlterno = "terrestre";
		super.AlgoFormer(modo);
	}
}
