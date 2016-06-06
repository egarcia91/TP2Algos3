package fiuba.algo3.algoformers;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

import fiuba.algo3.algoformers.Casillero;
import fiuba.algo3.algoformers.AlgoFormer;

public class Tablero {
	
	private int ancho;
	private int alto;
	private Casillero[][] tablero;
	private Map<String,Posicion> posicionesElementosMoviles;

	//private List<AlgoFormer> escuadronUno;
	//private List<AlgoFormer> escuadronDos;

	//private EscuadronAutobot escuadronUno;
	//private EscuadronDecepticon escuadronDos;
	private Escuadron escuadronUno;
	private Escuadron escuadronDos;

	private Spark spark;

	public Tablero(int ancho, int alto){
		if(ancho <= 0 || alto <= 0){
			return;
		}
		tablero = new Casillero[ancho][alto];
		this.ancho = ancho;
		this.alto = alto;

		//escuadronUno = new ArrayList<AlgoFormer>();
		//escuadronDos = new ArrayList<AlgoFormer>();


		//escuadronUno = new EscuadronAutobot();
		//escuadronDos = new EscuadronDecepticon();

		escuadronUno = new Escuadron();
		escuadronDos = new Escuadron();

	}
	
	public int getAncho(){
		return this.ancho;
	}

	public int getAlto(){
		return this.alto;
	}	

	private Casillero getCasillero(int posX, int posY){
		return tablero[posX][posY];
	}	
	
	private Casillero getCasillero(Posicion posicion){
		int x = posicion.getX();
		int y = posicion.getY();
		if(x < ancho && y < alto){
			return tablero[posicion.getX()][posicion.getY()];
		}
		throw new CasilleroNoExisteException();
	}

	public void quitarAlgoFormer(int posX, int posY){
		this.tablero[posX][posY].quitarAlgoFormer();
	}
	
	public void ubicarSpark(){
		Random rand = new Random();
		int randX = Math.round((ancho/2) + rand.nextInt(2));
		int randY = Math.round((alto/2) + rand.nextInt(2));
		this.getCasillero(randX,randY).agregarContenido(this.spark);
		posicionesElementosMoviles.put("Spark",new Posicion(randX,randY));
	}



	/*public int cantidadAlgoFormer(){
		return this.escuadronUno.size() + this.escuadronDos.size();
	}*/

	public int cantidadAlgoFormer(){
		return this.escuadronUno.cantidadMiembrosEscuadron()+ this.escuadronDos.cantidadMiembrosEscuadron();
	}

	public int cantidadCasilleros(){
		return ancho*alto;
	}

	public boolean estaDesierto(){
		if(this.cantidadAlgoFormer() == 0)return true;
		else return false;
	}

	//Estaria bueno extender este metodo hacia cualquier cosa (item, algoformer,spark, etc)
	//Se propone unir todos los elementos posibles en una superclase Elemento
	private Posicion buscarAlgoFormer(AlgoFormer unAlgoFormer){
		if(posicionesElementosMoviles.containsKey(unAlgoFormer.nombre)== true){
			return posicionesElementosMoviles.get(unAlgoFormer.nombre);

		}
		else
			throw new AlgoFormerNoExisteException();
	}

	public boolean existeAlgoFormer(AlgoFormer unAlgoFormer, int posX, int posY){
		return this.getCasillero(posX, posY).existeAlgoFormer(unAlgoFormer);
	}
	
	public void moverIzquierda(AlgoFormer unAlgoFormer, int valor){
		try{
			Posicion posicion = buscarAlgoFormer(unAlgoFormer);
			this.getCasillero(posicion).quitarAlgoFormer();
	
			//Ubicar nueva posicion dentro de los limites del tablero:
			if(posicion.getX() > valor){
				posicion.setX(posicion.getX() - valor);
			}
			else{
				posicion.setX(0);
			}
			this.getCasillero(posicion).agregarAlgoFormer(unAlgoFormer);
		}
		catch(AlgoFormerNoExisteException e){
			return;
		}	
	}

	public void agregarAlgoFormer(AlgoFormer unAlgoFormer,int posX,int posY){
		this.tablero[posX][posY].agregarAlgoFormer(unAlgoFormer);
	}

	public void moverDerecha(AlgoFormer unAlgoFormer, int valor){
		try{
			Posicion posicion = buscarAlgoFormer(unAlgoFormer);
			this.getCasillero(posicion).quitarAlgoFormer();
	
			//Ubicar nueva posicion dentro de los limites del tablero:
			if(posicion.getX() < (ancho - valor)){
				posicion.setX(posicion.getX() + valor);
			}
			else{
				posicion.setX(ancho - 1);
			}
			this.getCasillero(posicion).agregarAlgoFormer(unAlgoFormer);
		}
		catch(AlgoFormerNoExisteException e){
			return;
		}	
	}	
		
		
	public void moverArriba(AlgoFormer unAlgoFormer, int valor){
		try{
			Posicion posicion = buscarAlgoFormer(unAlgoFormer);
			this.getCasillero(posicion).quitarAlgoFormer();
	
			//Ubicar nueva posicion dentro de los limites del tablero:
			if(posicion.getY() > valor){
				posicion.setY(posicion.getY() - valor);
			}
			else{
				posicion.setY(0);
			}
			this.getCasillero(posicion).agregarAlgoFormer(unAlgoFormer);
		}
		catch(AlgoFormerNoExisteException e){
			return;
		}	
	}	
	
	public void moverAbajo(AlgoFormer unAlgoFormer, int valor){
		try{
			Posicion posicion = buscarAlgoFormer(unAlgoFormer);
			this.getCasillero(posicion).quitarAlgoFormer();
	
			//Ubicar nueva posicion dentro de los limites del tablero:
			if(posicion.getY() < (alto - valor)){
				posicion.setY(posicion.getY() + valor);
			}
			else{
				posicion.setY(alto - 1);
			}
			this.getCasillero(posicion).agregarAlgoFormer(unAlgoFormer);
		}
		catch(AlgoFormerNoExisteException e){
			return;
		}	
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

	/*
	@SuppressWarnings("unused")
	private boolean perteneceEscuadronUno(AlgoFormer unAlgoFormer){
		for (AlgoFormer eachAlgoFormer:
				this.escuadronUno){
			if (eachAlgoFormer.getNombre()==unAlgoFormer.getNombre()){
				return true;
			}
		}
		return false;
	}*/


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
			algoFormer.tablero = this;
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
			algoFormer.tablero = this;
			this.getCasillero(initX,initY).agregarAlgoFormer(algoFormer);
			if(initX == this.ancho){
				initX--;
			} else {
				initX = this.ancho;
				initY--;
			}
		}
	}


	/*
	public void agregarEscuadron(List<AlgoFormer> escuadron){
		if(escuadronUno.size()==0){
			this.escuadronUno.addAll(escuadron);
			this.ubicarEscuadronUno();
		} else if(escuadronDos.size()==0){
			this.escuadronDos.addAll(escuadron);
			this.ubicarEscuadronDos();
		}
	}*/

	/*
	public void agregarEscuadron(Escuadron unEscuadron) {
		if (!escuadronUno.existeEscuadron()) {
			this.escuadronUno = new EscuadronAutobot();
			this.ubicarEscuadronUno();
		} else if (!escuadronUno.existeEscuadron()) {
			this.escuadronDos = new EscuadronDecepticon();
			this.ubicarEscuadronDos();
		}
	}
	*/


	public void agregarEscuadron(Escuadron unEscuadron) {
		if (!escuadronUno.existeEscuadron()) {
			this.escuadronUno.algoFormers.addAll(unEscuadron.algoFormers);
			this.ubicarEscuadronUno();
		} else if (!escuadronDos.existeEscuadron()) {
			this.escuadronDos.algoFormers.addAll(unEscuadron.algoFormers);
			this.ubicarEscuadronDos();
		}
	}


	public boolean tieneAlgoFormer(int posX,int posY){
		return(this.tablero[posX][posY].tieneAlgoFormer());
	}

}
