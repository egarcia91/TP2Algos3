package fiuba.algo3.algoformers;

import fiuba.algo3.tablero.Juego;
import fiuba.algo3.tablero.MovimientoFueraDeRangoException;

public class AlgoFormer {

	protected Juego juego;
	protected EstadoAlgoformer estado;
	protected String nombre = "Algoformer";
	
	boolean efectoTormentaPsionica = false;
	int turnosDePenalizacion = 0;

	public AlgoFormer(){
		this.transformarHumanoide();
	}

	public void setVida(int vida) {
		estado.setVida(vida);
	}
	
	public String getNombre(){
		return this.nombre;
	}

	public void afectarPorTormentaPsionica(){
		if(efectoTormentaPsionica == false && this.getTipoUnidad()== "Aereo"){
			estado.setFuerzaAtaque((int)(0.4*estado.getFuerzaAtaque()));
			efectoTormentaPsionica = true;
		}
	}
	
	public void penalizarTurnos(int turnos){
		if(turnos > 0) turnosDePenalizacion = turnos;
	}
	
	public int getVida(){
		return this.estado.getVida();
	}

	public int getFuerzaAtaque(){
		return this.estado.getFuerzaAtaque();
	}

	public int getDistanciaAtaque(){
		return this.estado.getDistanciaAtaque();
	}

	public int getVelocidad(){
		return this.estado.getVelocidad();
	}
	
	public String getTipoUnidad(){
		return this.estado.getTerreno();
	}

	public EstadoAlgoformer getEstado(){
		return this.estado;
	}

	public void transformarAlterno(){
		this.estado = new Alterno();
		this.estado.setVida(500);
		this.estado.setFuerzaAtaque(15);
		this.estado.setDistanciaAtaque(4);
		this.estado.setVelocidad(5);
		this.estado.setTerreno("terrestre");
	}

	public void transformarHumanoide(){
		this.estado = new Humanoide();
		this.estado.setVida(500);
		this.estado.setFuerzaAtaque(50);
		this.estado.setDistanciaAtaque(2);
		this.estado.setVelocidad(2);
		this.estado.setTerreno("terrestre");
	}


	public void mover(int deltaX,int deltaY){
		if(turnosDePenalizacion > 0){
			turnosDePenalizacion--;
			return;
		}
		if(this.movimientoPosible(deltaX,deltaY)){
			this.juego.moverAlgoFormer(this,deltaX,deltaY);
		} else {
			throw new MovimientoFueraDeRangoException();
		}
	}

	private boolean movimientoPosible(int x,int y){
		int velocidad = this.getVelocidad();
		
		velocidad = velocidad*velocidad;
		return (x*x + y*y <= velocidad*velocidad); //Circunferencia de alcance
	}

	public void moverDerecha(){
		this.mover(1,0);
	}

	public void moverIzquierda(){
		this.mover(-1,0);
	}

	public void moverArriba(){
		this.mover(0,-1);
	}

	public void moverAbajo(){
		this.mover(0,1);
	}

	public void atacar(){
		//this.tablero.ataqueZona(this,this.estado.getDistanciaAtaque(),this.estado.getFuerzaAtaque());
	}

	public void recibirAtaque(int fuerzaAtaque){
		this.estado.setVida(this.estado.getVida()-fuerzaAtaque);
	}

	public void setJuego(Juego juego){
		this.juego = juego;
	}

}
