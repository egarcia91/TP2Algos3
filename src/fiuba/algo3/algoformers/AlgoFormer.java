package fiuba.algo3.algoformers;

import fiuba.algo3.algoformers.Tablero;

public class AlgoFormer {

	protected Tablero tablero;
	private EstadoAlgoformer estado;

	protected String nombre = "Algoformer";
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
	private String tipoUnidad;

	public void AlgoFormer(){
		estado = new Humanoide();
		this.transformarHumanoide();
	}

	public String getNombre(){
		return this.nombre;
	}

	public int getVida(){
		return estado.getVida();
	}

	public int getFuerzaAtaque(){
		return estado.getFuerzaAtaque();
	}

	public int getDistanciaAtaque(){
		return estado.getDistanciaAtaque();
	}

	public int getVelocidad(){
		return estado.getVelocidad();
	}

	public String tipoUnidad(){
		return this.tipoUnidad;
	}

	public EstadoAlgoformer estadoTransformacion(){
		return this.estado;
	}

	public void transformarAlterno(){
		this.estado = new Alterno();
		estado.setVida(this.vidaAlterno);
		estado.setFuerzaAtaque(this.fuerzaAtaqueAlterno);
		estado.setDistanciaAtaque(this.distanciaAtaqueAlterno);
		estado.setVelocidad(this.velocidadAlterno);
		this.tipoUnidad = this.unidadAlterno;
	}

	public void transformarHumanoide(){
		this.estado = new Humanoide();
		estado.setVida(this.vidaHumanoide);
		estado.setFuerzaAtaque(this.fuerzaAtaqueHumanoide);
		estado.setDistanciaAtaque(this.distanciaAtaqueHumanoide);
		estado.setVelocidad(this.velocidadHumanoide);
		this.tipoUnidad = this.unidadHumanoide;
	}

	public void moverDerecha(){
		tablero.moverDerecha(this,estado.getVelocidad());
	}

	public void moverIzquierda(){
		tablero.moverIzquierda(this,estado.getVelocidad());
	}

	public void moverArriba(){
		tablero.moverArriba(this,estado.getVelocidad());
	}

	public void moverAbajo(){
		tablero.moverAbajo(this,estado.getVelocidad());
	}

	public void atacar(){
		this.tablero.ataqueZona(this,estado.getDistanciaAtaque(),estado.getFuerzaAtaque());
	}

	public boolean estaEnPosicion(int x, int y){
		return this.tablero.existeAlgoFormer(this, x, y);
	}

	public void recibirAtaque(int fuerzaAtaque){
		estado.setVida(estado.getVida()-fuerzaAtaque);
	}
}
