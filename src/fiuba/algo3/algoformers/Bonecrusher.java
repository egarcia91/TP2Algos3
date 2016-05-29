package fiuba.algo3.algoformers;

public class Bonecrusher extends AlgoFormer {

	public Bonecrusher(String modo){
		this.nombre = "Bonecrusher";
		this.vidaHumanoide = 200;
		this.fuerzaAtaqueHumanoide = 30;
		this.distanciaAtaqueHumanoide = 3;
		this.velocidadHumanoide = 1;
		this.unidadHumanoide = "terrestre";
		this.vidaAlterno = 200;
		this.fuerzaAtaqueAlterno = 30;
		this.distanciaAtaqueAlterno = 3;
		this.velocidadAlterno = 8;
		this.unidadAlterno = "terrestre";
		super.AlgoFormer(modo);
	}
}
