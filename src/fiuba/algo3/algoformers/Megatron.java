package fiuba.algo3.algoformers;

public class Megatron extends AlgoFormer {

	public Megatron(String modo){
		this.nombre = "Megatron";
		this.vidaHumanoide = 550;
		this.fuerzaAtaqueHumanoide = 10;
		this.distanciaAtaqueHumanoide = 3;
		this.velocidadHumanoide = 1;
		this.unidadHumanoide = "terrestre";
		this.vidaAlterno = 550;
		this.fuerzaAtaqueAlterno = 55;
		this.distanciaAtaqueAlterno = 2;
		this.velocidadAlterno = 8;
		this.unidadAlterno = "aerea";
		super.AlgoFormer(modo);
	}
}
