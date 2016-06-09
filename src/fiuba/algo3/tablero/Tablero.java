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

	private Escuadron escuadronUno;
	private Escuadron escuadronDos;

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
		//System.out.println(">>>>(" + posX + "," + posY + ")<<<<<<" );
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
		unAlgoFormer.setTablero(this);
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

	private Posicion buscarAlgoFormer(AlgoFormer unAlgoFormer){
		if(posicionesElementos.containsKey(unAlgoFormer.getNombre())){
			return posicionesElementos.get(unAlgoFormer.getNombre());
		} else {
			throw new AlgoFormerNoExisteException();
		}
	}

	public boolean existeAlgoFormer(AlgoFormer unAlgoFormer, int posX, int posY){
		return this.buscarAlgoFormer(unAlgoFormer).equals(new Posicion(posX,posY));
	}

	public void ataqueZona(AlgoFormer unAlgoFormer,int unaDistanciaAtaque, int unaFuerzaAtaque){
//		Posicion posicion = this.buscarAlgoFormer(unAlgoFormer);
//		int anchoFinal = posicion.getX()+unaDistanciaAtaque;
//		int anchoInicial = posicion.getX()-unaDistanciaAtaque;
//		int altoFinal = posicion.getY()+unaDistanciaAtaque;
//		int altoInicial = posicion.getY()-unaDistanciaAtaque;
//		if (this.perteneceEscuadronUno(unAlgoFormer)) {
//			for (AlgoFormer eachAlgoFormer :
//					this.escuadronDos.algoFormers) {
//				Posicion posicionEnemigo = this.buscarAlgoFormer(eachAlgoFormer);
//				if (posicionEnemigo.getX() >= anchoInicial && posicionEnemigo.getX() <= anchoFinal && posicionEnemigo.getY() >= altoInicial && posicionEnemigo.getY() <= altoFinal) {
//					eachAlgoFormer.recibirAtaque(unaFuerzaAtaque);
//				}
//			}
//		}else{
//				for (AlgoFormer eachAlgoFormer:
//						this.escuadronUno.algoFormers){
//					Posicion posicionEnemigo = this.buscarAlgoFormer(eachAlgoFormer);
//					if (posicionEnemigo.getX() >= anchoInicial && posicionEnemigo.getX() <= anchoFinal && posicionEnemigo.getY() >= altoInicial && posicionEnemigo.getY() <= altoFinal) {
//						eachAlgoFormer.recibirAtaque(unaFuerzaAtaque);
//					}
//				}
//		}
	}

	private boolean perteneceEscuadronUno(AlgoFormer unAlgoFormer){
		return this.escuadronUno.perteneceAlgoformer(unAlgoFormer);
	}

	private boolean perteneceEscuadronDos(AlgoFormer unAlgoFormer){
		return this.escuadronDos.perteneceAlgoformer(unAlgoFormer);
	}

	private void ubicarEscuadronUno(){ //FIX: NO TIENE SENTIDO, INITX ES SIEMPRE 1
		int y = 1;
		int x = 1;
		int cantidadAlgoFormers = this.escuadronUno.cantidadMiembrosEscuadron();
		for(int i = 0; i < cantidadAlgoFormers; i++){
			this.agregarAlgoFormer(this.escuadronUno.getAlgoFormer(i),new Posicion(x,y));
			if(x == 1){
				x = 2;
				y = 1;
			} else {
				x = 1;
				y = 2;
			}
		}
	}

	private void ubicarEscuadronDos(){
		int initY = this.alto-1;
		int initX = this.ancho-1;

		int cantidadAlgoFormers = this.escuadronDos.cantidadMiembrosEscuadron();
		for(int i = 0; i < cantidadAlgoFormers; i++){
			System.out.println(initX + " <> " + initY);
			this.agregarAlgoFormer(this.escuadronDos.getAlgoFormer(i),new Posicion(initX,initY));
			if(initX == this.ancho-1){
				initX--;
			} else {
				initX = this.ancho-1;
				initY--;
			}
		}
		/*
		for (AlgoFormer algoFormer: this.escuadronDos.algoFormers){
			//algoFormer.tablero = this;
			this.getCasillero(initX,initY).agregarAlgoFormer(algoFormer);
			if(initX == this.ancho){
				initX--;
			} else {
				initX = this.ancho;
				initY--;
			}
		}
		*/
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

	public void moverAlgoFormer(AlgoFormer algoFormer, int x, int y) {
		Posicion posicion = new Posicion(x,y);
		this.moverAlgoFormer(algoFormer,posicion);
	}

	public void moverAlgoFormer(AlgoFormer unAlgoFormer,Posicion posRelativa){
		Posicion posicionInicial;

		posicionInicial = posicionesElementos.get(unAlgoFormer.getNombre());

		if(!posicionesElementos.containsKey(unAlgoFormer.getNombre())){
			throw new AlgoFormerNoExisteException();
		}

		Posicion posicionFinal = posicionInicial.getSuma(posRelativa);
		if(this.getCasillero(posicionFinal).contieneAlgoFormer()){
			throw new CasilleroOcupadoException();
		} else {
			this.quitarAlgoFormer(unAlgoFormer);
			this.agregarAlgoFormer(unAlgoFormer,posicionFinal);
			this.posicionesElementos.replace(unAlgoFormer.getNombre(), posicionFinal);
		}
	}

	public Posicion getPosicion(AlgoFormer algoFormer) {
		Posicion posicion = posicionesElementos.get(algoFormer.getNombre());
		if(!posicionesElementos.containsKey(algoFormer.getNombre())){
			throw new AlgoFormerNoExisteException();
		}
		return posicion;
	}

	public void setTodoTerrenoTerrestre(Terreno unTerreno){
		//Hacer algo
	}

	public void setTodoTerrenoAereo(Terreno unTerreno){
		//Hacer algo
	}
}
