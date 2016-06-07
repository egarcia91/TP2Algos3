package fiuba.algo3.tablero;

import java.util.LinkedHashMap;
import java.util.Map;
import fiuba.algo3.algoformers.Escuadron;
import fiuba.algo3.algoformers.Spark;
import fiuba.algo3.algoformers.personajes.Megatron;
import fiuba.algo3.algoformers.AlgoFormer;

public class Tablero {
	
	private int ancho;
	private int alto;
	private Casillero[][] tablero;
	private Map<String,Posicion> posicionesElementos;

	private Escuadron escuadronUno;
	private Escuadron escuadronDos;

	public Tablero(int ancho, int alto){
		if(ancho <= 0 || alto <= 0){
			return;
		}
		tablero = new Casillero[ancho][alto];
		for(int i = 0; i < ancho; i++){
			for(int j = 0; j < alto; j++){
				tablero[i][j] = new Casillero();
			}
		}
		this.ancho = ancho;
		this.alto = alto;
		posicionesElementos = new LinkedHashMap<String,Posicion>();

		escuadronUno = new Escuadron();
		escuadronDos = new Escuadron();

	}
	
	public int getAncho(){
		return this.ancho;
	}

	public int getAlto(){
		return this.alto;
	}	
	
	public boolean estaDesierto(){
		return posicionesElementos.isEmpty();
	}

	public Casillero getCasillero(int posX, int posY){
		try{
			return tablero[posX][posY];
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
		posicionesElementos.put(unAlgoFormer.getNombre(),pos);
	}
	
	public void agregarAlgoFormer(AlgoFormer unAlgoFormer,int x, int y){
		agregarAlgoFormer(unAlgoFormer,new Posicion(x,y));
	}
	
	public void quitarAlgoFormer(AlgoFormer unAlgoFormer){
		String key = unAlgoFormer.getNombre();
		Casillero casillero = this.getCasillero(posicionesElementos.get(key));
		if(casillero == null) return;
		else{
			casillero.quitarAlgoFormer();
			posicionesElementos.remove(key);
		}	
	}
	
	public boolean tieneAlgoFormer(int posX,int posY){
		return(this.tablero[posX][posY].contieneAlgoFormer());
	}

	public void setItem(Spark item,int posX, int posY){
		tablero[posX][posY].setItem(item);		
	}
		
	private Posicion buscarAlgoFormer(AlgoFormer unAlgoFormer){
		if(posicionesElementos.containsKey(unAlgoFormer.getNombre())== true){
			return posicionesElementos.get(unAlgoFormer.getNombre());

		}
		else
			throw new AlgoFormerNoExisteException();
	}

	public boolean existeAlgoFormer(AlgoFormer unAlgoFormer, int posX, int posY){
		AlgoFormer algoFormer;
		try{
			algoFormer = this.getCasillero(posX, posY).getAlgoFormer();
		}
		catch(AlgoFormerNoExisteException e){
			return false;
		}
		return (algoFormer.getNombre() == unAlgoFormer.getNombre());
	}
	
	public void ataqueZona(AlgoFormer unAlgoFormer,int unaDistanciaAtaque, int unaFuerzaAtaque){
		Posicion posicion = this.buscarAlgoFormer(unAlgoFormer);
		int anchoFinal = posicion.getX()+unaDistanciaAtaque;
		int anchoInicial = posicion.getX()-unaDistanciaAtaque;
		int altoFinal = posicion.getY()+unaDistanciaAtaque;
		int altoInicial = posicion.getY()-unaDistanciaAtaque;
		if (this.perteneceEscuadronUno(unAlgoFormer)) {
			for (AlgoFormer eachAlgoFormer :
					this.escuadronDos.algoFormers) {
				Posicion posicionEnemigo = this.buscarAlgoFormer(eachAlgoFormer);
				if (posicionEnemigo.getX() >= anchoInicial && posicionEnemigo.getX() <= anchoFinal && posicionEnemigo.getY() >= altoInicial && posicionEnemigo.getY() <= altoFinal) {
					eachAlgoFormer.recibirAtaque(unaFuerzaAtaque);
				}
			}
		}else{
				for (AlgoFormer eachAlgoFormer:
						this.escuadronUno.algoFormers){
					Posicion posicionEnemigo = this.buscarAlgoFormer(eachAlgoFormer);
					if (posicionEnemigo.getX() >= anchoInicial && posicionEnemigo.getX() <= anchoFinal && posicionEnemigo.getY() >= altoInicial && posicionEnemigo.getY() <= altoFinal) {
						eachAlgoFormer.recibirAtaque(unaFuerzaAtaque);
					}
				}
		}

	}

	private boolean perteneceEscuadronUno(AlgoFormer unAlgoFormer){
		return this.escuadronUno.perteneceAlgoformer(unAlgoFormer);
	}

	private boolean perteneceEscuadronDos(AlgoFormer unAlgoFormer){
		return this.escuadronDos.perteneceAlgoformer(unAlgoFormer);
	}


	private void ubicarEscuadronUno(){ //FIX: NO TIENE SENTIDO, INITX ES SIEMPRE 1
		int initY = 1;
		int initX = 1;
		for (AlgoFormer algoFormer: this.escuadronUno.algoFormers) {
			//algoFormer.tablero = this;
			this.getCasillero(initX,initY).agregarAlgoFormer(algoFormer);
			if(initX == 1){
				initX = 2;
				initY = 1;
			} else {
				initX = 1;
				initY = 2;
			}
		}
	}

	private void ubicarEscuadronDos(){
		int initY = this.alto;
		int initX = this.ancho;
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
	}

	public void agregarEscuadron(Escuadron unEscuadron) {
		if (!escuadronUno.existeEscuadron()) {
			this.escuadronUno.algoFormers.addAll(unEscuadron.algoFormers);
			this.ubicarEscuadronUno();
		} else if (!escuadronDos.existeEscuadron()) {
			this.escuadronDos.algoFormers.addAll(unEscuadron.algoFormers);
			this.ubicarEscuadronDos();
		}
	}
	

	public void moverAlgoFormer(AlgoFormer algoFormer, int x, int y) {
		moverAlgoFormer(algoFormer,new Posicion(x,y));
	}

	public void moverAlgoFormer(AlgoFormer unAlgoFormer,Posicion posRelativa){
		Posicion posicionInicial;
		
		try{
			posicionInicial = posicionesElementos.get(unAlgoFormer.getNombre());
		}
		catch(Exception e){
			throw new AlgoFormerNoExisteException();
		}
		Posicion posicionFinal = posicionInicial.getSuma(posRelativa);

		if(this.getCasillero(posicionFinal).contieneAlgoFormer() == true){
			throw new CasilleroOcupadoException();
		}
		else {
				this.quitarAlgoFormer(unAlgoFormer);
				this.agregarAlgoFormer(unAlgoFormer,posicionFinal);
		}
	}

	public Posicion getPosicion(AlgoFormer algoFormer) {
		Posicion posicion = posicionesElementos.get(algoFormer.getNombre());
		if(posicion == null) throw new AlgoFormerNoExisteException();
		return posicion;
	}

}

