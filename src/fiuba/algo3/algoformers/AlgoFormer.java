package fiuba.algo3.algoformers;

public class AlgoFormer {
	protected String nombre = "AlgoFormer";
	private int vida;
	private int fuerzaAtaque;
	private int distanciaAtaque;
	private int velocidad;
	private String tipoUnidad;
	private String estado = "Humanoide";

	protected int vidaHumanoide = 500;
	protected int fuerzaAtaqueHumanoide = 50;
	protected int distanciaAtaqueHumanoide = 2;
	protected int velocidadHumanoide = 2;
	protected String unidadHumanoide = "terrestre";

	protected int vidaAlterno = 500;
	protected int fuerzaAtaqueAlterno = 15;
	protected int distanciaAtaqueAlterno = 4;
	protected int velocidadAlterno = 5;
	protected String unidadAlterno = "terrestre";

	public void AlgoFormer(String modo){
		if(modo == "Alterno"){
			this.estado = "Alterno";
			this.transformarAlterno();
		} else {
			this.estado = "Humanoide";
			this.transformarHumanoide();
		}
	}

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

	public String estadoTransformacion(){
		return this.estado;
	}

	public void transformarAlterno(){
		this.estado = "Alterno";
		this.vida = this.vidaAlterno;
		this.fuerzaAtaque = this.fuerzaAtaqueAlterno;
		this.distanciaAtaque = this.distanciaAtaqueAlterno;
		this.velocidad = this.velocidadAlterno;
		this.tipoUnidad = this.unidadAlterno;
	}

	public void transformarHumanoide(){
		this.estado = "Humanoide";
		this.vida = this.vidaHumanoide;
		this.fuerzaAtaque = this.fuerzaAtaqueHumanoide;
		this.distanciaAtaque = this.distanciaAtaqueHumanoide;
		this.velocidad = this.velocidadHumanoide;
		this.tipoUnidad = this.unidadHumanoide;
	}

	public void moverDerecha(){}

	public void atacar(){}

}
