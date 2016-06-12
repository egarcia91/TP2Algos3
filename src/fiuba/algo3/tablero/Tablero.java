package fiuba.algo3.tablero;

import java.util.LinkedHashMap;
import java.util.Map;
import fiuba.algo3.algoformers.Escuadron;
import fiuba.algo3.algoformers.AlgoFormer;

public class Tablero {

	private int ancho;
	private int alto;
	private Casillero[][] tablero;
	private Map<String,Posicion> posicionesElementos;

	//private Escuadron escuadronUno;
	//private Escuadron escuadronDos;
	protected Escuadron escuadronUno;
	protected Escuadron escuadronDos;

	public Tablero(int ancho, int alto){
		tablero = new Casillero[ancho][alto];
		for(int i = 0; i < ancho; i++){
			for(int j = 0; j < alto; j++){
				tablero[i][j] = new Casillero();
			}
		}
		this.ancho = ancho;
		this.alto = alto;
		this.posicionesElementos = new LinkedHashMap<String,Posicion>();

		this.escuadronUno = new Escuadron();
		this.escuadronDos = new Escuadron();
	}

	public int getAncho(){
		return this.ancho;
	}

	public int getAlto(){
		return this.alto;
	}

	public boolean estaDesierto(){
		return this.posicionesElementos.isEmpty();
	}

	public Casillero getCasillero(int posX, int posY){
		try{
			return this.tablero[posX][posY];
		}catch(Exception e){
			throw new CasilleroNoExisteException();
		}
	}

	public Casillero getCasillero(Posicion posicion){
		return this.getCasillero(posicion.getX(),posicion.getY());
	}

	public int cantidadAlgoFormer(){
		return this.escuadronUno.cantidadMiembrosEscuadron()+ this.escuadronDos.cantidadMiembrosEscuadron();
	}

	public void agregarAlgoFormer(AlgoFormer unAlgoFormer,Posicion pos){
		this.getCasillero(pos).agregarAlgoFormer(unAlgoFormer);
		this.posicionesElementos.put(unAlgoFormer.getNombre(),new Posicion(pos));
		Ataque ataque = new Ataque();
		ataque.setTablero(this);
		Movimiento movimiento = new Movimiento();
		movimiento.setTablero(this);
		unAlgoFormer.setAtaque(ataque);
		unAlgoFormer.setMovimiento(movimiento);
	}

	public void agregarAlgoFormer(AlgoFormer unAlgoFormer,int x, int y){
		this.agregarAlgoFormer(unAlgoFormer,new Posicion(x,y));
	}

	public void quitarAlgoFormer(AlgoFormer unAlgoFormer){
		String key = unAlgoFormer.getNombre();
		Casillero casillero = this.getCasillero(this.posicionesElementos.get(key));
		if(casillero == null){
			return;
		} else{
			casillero.quitarAlgoFormer();
			this.posicionesElementos.remove(key);
		}
	}

	public boolean tieneAlgoFormer(int posX,int posY){
		return this.getCasillero(posX,posY).contieneAlgoFormer();
	}

	public void setItem(Item item,int posX, int posY){
		this.getCasillero(posX,posY).setItem(item);
	}

	public Posicion buscarAlgoFormer(AlgoFormer unAlgoFormer){
		if(posicionesElementos.containsKey(unAlgoFormer.getNombre())){
			return posicionesElementos.get(unAlgoFormer.getNombre());
		} else {
			throw new AlgoFormerNoExisteException();
		}
	}

	public boolean existeAlgoFormer(AlgoFormer unAlgoFormer, int posX, int posY){
		return this.buscarAlgoFormer(unAlgoFormer).equals(new Posicion(posX,posY));
	}

	public boolean perteneceEscuadronUno(AlgoFormer unAlgoFormer){
		return this.escuadronUno.perteneceAlgoformer(unAlgoFormer);
	}

	public boolean perteneceEscuadronDos(AlgoFormer unAlgoFormer){
		return this.escuadronDos.perteneceAlgoformer(unAlgoFormer);
	}

	private void ubicarEscuadronUno(){ //FIX: NO TIENE SENTIDO, INITX ES SIEMPRE 1 //TODO hace metodo. Si tiene sentido, lee bien el codigo
		int y = 0;
		int x = 0;
		int cantidadAlgoFormers = this.escuadronUno.cantidadMiembrosEscuadron();
		for(int i = 0; i < cantidadAlgoFormers; i++){
			this.agregarAlgoFormer(this.escuadronUno.getAlgoFormer(i),new Posicion(x,y));
			if(x == 0){
				x = 1;
				y = 0;
			} else {
				x = 0;
				y = 1;
			}
		}
	}

	private void ubicarEscuadronDos(){
		int initY = this.alto-1;
		int initX = this.ancho-1;

		int cantidadAlgoFormers = this.escuadronDos.cantidadMiembrosEscuadron();
		for(int i = 0; i < cantidadAlgoFormers; i++){
			this.agregarAlgoFormer(this.escuadronDos.getAlgoFormer(i),new Posicion(initX,initY));
			if(initX == this.ancho-1){
				initX--;
			} else {
				initX = this.ancho-1;
				initY--;
			}
		}
	}

	public void agregarEscuadron(Escuadron unEscuadron) {
		if (!escuadronUno.existeEscuadron()) {
			this.escuadronUno = unEscuadron;
			this.ubicarEscuadronUno();
		} else if (!escuadronDos.existeEscuadron()) {
			this.escuadronDos = unEscuadron;
			this.ubicarEscuadronDos();
		}
	}

	public void setPosicion(AlgoFormer unAlgoFormer, Posicion pos) {
		this.posicionesElementos.replace(unAlgoFormer.getNombre(), pos);
	}

	public Posicion getPosicion(AlgoFormer algoFormer) {
		Posicion posicion = posicionesElementos.get(algoFormer.getNombre());
		if(!posicionesElementos.containsKey(algoFormer.getNombre())){
			throw new AlgoFormerNoExisteException();
		}
		return posicion;
	}

	public void setTodoTerrenoAereo(Terreno unTerreno){
		for(int i = 0; i < this.ancho; i++){
			for(int j = 0; j < this.alto; j++){
				this.getCasillero(i,j).setTerrenoAereo(unTerreno);
			}
		}
	}

	public void setTodoTerrenoTerrestre(Terreno unTerreno){
		for(int i = 0; i < this.ancho; i++){
			for(int j = 0; j < this.alto; j++){
				this.getCasillero(i,j).setTerrenoTerrestre(unTerreno);
			}
		}
	}

}
