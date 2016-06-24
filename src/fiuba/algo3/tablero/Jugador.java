package fiuba.algo3.tablero;

import fiuba.algo3.algoformers.Escuadron;
import fiuba.algo3.juegomvc.SoundPlayer;
import fiuba.algo3.juegomvc.SoundPlayer.enumSound;
import fiuba.algo3.algoformers.AlgoFormer;
import java.util.ArrayList;
import java.util.Iterator;

public class Jugador {

	private String nombre;
	protected Juego juego;
	private Escuadron escuadron;
	private Escuadron escuadronRivalAtacable = new Escuadron();
	public ArrayList<Casillero> casillerosEnRango = new ArrayList<Casillero>();
	public Posicion posicionPosibleMovimiento = new Posicion(-1,-1);
	private int indiceAlgoFormer = 0;
	private int indiceAlgoFormerRival = 0;
	private int indiceAccion = 0;
	private boolean selectAlgoFormer = false;
	private boolean selectAlgoFormerRival = false;
	private boolean selectMovimiento = false;
	private boolean selectAccion = false;

	public Jugador(String nombre) {
		this.nombre = nombre;
	}

	public void setNombre(String unNombre){
		this.nombre = unNombre;
	}

	public void resetSelection(){
		this.selectAlgoFormer = false;
		this.selectAccion = false;
		this.selectAlgoFormerRival = false;
		this.casillerosEnRango = new ArrayList<Casillero>();
		this.posicionPosibleMovimiento = new Posicion(-1,-1); //RARO
	}

	public void selectMovimiento(){
		this.selectMovimiento = true;
		AlgoFormer algoFormerActual = this.getSelectAlgoFormer();
		algoFormerActual.mover(this.posicionPosibleMovimiento);
		this.juego.cambiarTurnoJugador();
	}

	public void selectAlgoFormer(){
		this.selectAlgoFormer = true;
	}

	public void deselectAlgoFormer(){
		this.selectAlgoFormer = false;
	}

	public void selectAlgoFormerRival(){
		this.selectAlgoFormerRival = true;

		AlgoFormer unAlgoFormerRival = this.getSelectAlgoFormerRival();
		AlgoFormer algoFormerActual = this.getSelectAlgoFormer();
		algoFormerActual.atacar(unAlgoFormerRival);
		this.juego.cambiarTurnoJugador();
	}

	public void deselectAccion(){
		this.selectAccion = false;
		this.casillerosEnRango = new ArrayList<Casillero>();
		this.escuadronRivalAtacable = new Escuadron();
	}

	public void selectAccion(){
		this.selectAccion = true;
		switch(this.indiceAccion){
			case 0:
				this.atacarAlgoFormer();
				break;
			case 1:
				this.moverAlgoFormer();
				break;
			case 2:
				this.transformarAlgoFormer();
				break;
			default:
				break;
		}
	}

	public int getAccionSeleccionada(){
		return this.indiceAccion;
	}
	
	public boolean estaSeleccionadoAlgoFormer(){
		return this.selectAlgoFormer;
	}

	public boolean estaSeleccionadoAlgoFormerRival(){
		return this.selectAlgoFormerRival;
	}

	public boolean estaSeleccionadoAccion(){
		return this.selectAccion;
	}

	public String getNombre(){
		return this.nombre;
	}

	public AlgoFormer getSelectAlgoFormer(){
		return this.escuadron.getAlgoFormer(this.indiceAlgoFormer);
	}

	public AlgoFormer getSelectAlgoFormerRival(){
		return this.escuadronRivalAtacable.getAlgoFormer(this.indiceAlgoFormerRival);
	}

	public void cambiarPosicion(int x, int y){
		Posicion posiblePosicion = new Posicion(this.posicionPosibleMovimiento);
		posiblePosicion.sumar(new Posicion(x,y));
		Casillero casillero = new CasilleroNoExiste();
		try{
			casillero = this.juego.getTablero().getCasillero(posiblePosicion);
		}catch (CasilleroNoExisteException excepcion){}

		if(!casillero.noExiste()){
			if(this.casillerosEnRango.contains(casillero)){
				this.posicionPosibleMovimiento = posiblePosicion;
			}
		}
	}

	public void upPosicion(){
		this.cambiarPosicion(0,-1);
	}

	public void downPosicion(){
		this.cambiarPosicion(0,1);
	}

	public void leftPosicion(){
		this.cambiarPosicion(-1,0);
	}

	public void rightPosicion(){
		this.cambiarPosicion(1,0);
	}
	//TODO Deshardcodear indice accion
	public void nextAccion(){
		if(this.indiceAccion == 2){
			this.indiceAccion = 0;
		} else {
			this.indiceAccion++;
		}
	}

	//TODO Deshardcodear indice accion
	public void prevAccion(){
		if(this.indiceAccion == 0){
			this.indiceAccion = 2;
		} else {
			this.indiceAccion--;
		}
	}

	public int getSelectAccion(){
		return this.indiceAccion;
	}

	public void nextAlgoFormerRival(){
		int cantidadAlgoFormers = this.escuadronRivalAtacable.cantidadMiembrosEscuadron();
		if(this.indiceAlgoFormerRival == (cantidadAlgoFormers-1)){
			this.indiceAlgoFormerRival = 0;
		} else {
			this.indiceAlgoFormerRival++;
		}
	}

	public void prevAlgoFormerRival(){
		int cantidadAlgoFormers = this.escuadronRivalAtacable.cantidadMiembrosEscuadron();
		if(this.indiceAlgoFormerRival == 0){
			this.indiceAlgoFormerRival = (cantidadAlgoFormers-1);
		} else {
			this.indiceAlgoFormerRival--;
		}
	}

	public void nextAlgoFormer(){
		int cantidadAlgoFormers = this.escuadron.cantidadMiembrosEscuadron();
		if(this.indiceAlgoFormer == (cantidadAlgoFormers-1)){
			this.indiceAlgoFormer = 0;
		} else {
			this.indiceAlgoFormer++;
		}
	}

	public void prevAlgoFormer(){
		int cantidadAlgoFormers = this.escuadron.cantidadMiembrosEscuadron();
		if(this.indiceAlgoFormer == 0){
			this.indiceAlgoFormer = (cantidadAlgoFormers-1);
		} else {
			this.indiceAlgoFormer--;
		}
	}

	public void asignarEscuadron(Escuadron unEscuadron){
		this.escuadron = unEscuadron;
	}

	public boolean existeEscuadron(){
		return (this.escuadron.existeEscuadron());
	}

	public int cantidadAlgoFormer(){
		return this.escuadron.cantidadMiembrosEscuadron();
	}

	public boolean tieneAlgoFormerEnPosicion(int x, int y){
		return (this.escuadron.estaAlgoformerEnPosicion( x, y));
	}

	public void moverAlgoFormer(){
		AlgoFormer unAlgoFormer = this.escuadron.getAlgoFormer(this.indiceAlgoFormer);
		Movimiento movimiento = unAlgoFormer.getMovimiento();
		this.casillerosEnRango = movimiento.posiblesMovimientos(unAlgoFormer, unAlgoFormer.getVelocidad());
		this.posicionPosibleMovimiento = this.juego.getTablero().buscarAlgoFormer(unAlgoFormer);
	}

	public void transformarAlgoFormer(){
		AlgoFormer unAlgoFormer = this.escuadron.getAlgoFormer(this.indiceAlgoFormer);
		if(unAlgoFormer.esHumanoide()){
			unAlgoFormer.transformarAlterno();
			SoundPlayer sound = new SoundPlayer();
			sound.play(enumSound.TRANSFORMATION_SOUND);
		} else {
			unAlgoFormer.transformarHumanoide();
			SoundPlayer sound = new SoundPlayer();
			sound.play(enumSound.ANTITRANSFORMATION_SOUND);
		}
		this.juego.cambiarTurnoJugador();
	}

	public void atacarAlgoFormer(){
		
		AlgoFormer unAlgoFormer = this.escuadron.getAlgoFormer(this.indiceAlgoFormer);
		Movimiento movimiento = unAlgoFormer.getMovimiento();
		this.casillerosEnRango = movimiento.posiblesMovimientos(unAlgoFormer, unAlgoFormer.getDistanciaAtaque());
		
		for(Iterator<Casillero> i = casillerosEnRango.iterator(); i.hasNext();){
			Casillero casillero = i.next();
			if(casillero.tieneContenido() == true){
				Contenido contenido = casillero.getContenido();
				if(contenido.esAlgoFormer() == true){
					AlgoFormer algoFormer = (AlgoFormer) contenido;
					if(this.getSelectAlgoFormer().getEscuadron().getNombre() != algoFormer.getEscuadron().getNombre()){
						algoFormer.setVida(algoFormer.getVida() - unAlgoFormer.getFuerzaAtaque());
					}
				}
			}
		}
		SoundPlayer sound = new SoundPlayer();
		sound.play(enumSound.ATAQUE_SOUND);
	}

	public void setJuego(Juego juego) {
		this.juego = juego;
	}

}
