package fiuba.algo3.algoformers;

public class AlgoFormer {
	private String nombre = "AlgoFormer";
	private int vida;
	private int fuerzaAtaque;
	private int distanciaAtaque;
	private int velocidad;
	private String tipoUnidad;

	private int vidaHumanoide = 500;
	private int fuerzaAtaqueHumanoide = 50;
	private int distanciaAtaqueHumanoide = 2;
	private int velocidadHumanoide = 2;
	private String unidadHumanoide = "terrestre";

	private int vidaAlterno = 500;
	private int fuerzaAtaqueAlterno = 15;
	private int distanciaAtaqueAlterno = 4;
	private int velocidadAlterno = 5;
	private String unidadAlterno = "terrestre";

	public String getNombre(){
		return this.nombre;
	}

	public int vida(){
		return this.vida;
	}

	public int fuerzaAtaque(){
		return this.fuerzaAtaque;
	}

	public int distanciaAtaque(){
		return this.distanciaAtaque;
	}

	public int velocidad(){
		return this.velocidad;
	}

	public String tipoUnidad(){
		return this.tipoUnidad;
	}

}
