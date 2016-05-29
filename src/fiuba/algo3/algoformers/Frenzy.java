package fiuba.algo3.algoformers;

public class Frenzy extends AlgoFormer {

	public Frenzy(String modo){
		this.nombre = "Frenzy";
		this.vidaHumanoide = 400;
		this.fuerzaAtaqueHumanoide = 10;
		this.distanciaAtaqueHumanoide = 5;
		this.velocidadHumanoide = 2;
		this.unidadHumanoide = "terrestre";
		this.vidaAlterno = 400;
		this.fuerzaAtaqueAlterno = 25;
		this.distanciaAtaqueAlterno = 2;
		this.velocidadAlterno = 6;
		this.unidadAlterno = "terrestre";
		super.AlgoFormer(modo);
	}
}
