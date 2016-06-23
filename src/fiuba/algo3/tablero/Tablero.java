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

		this.setTerreno(new Pantano(), new Posicion(3,3), 2);
//		tablero[6][7].setTerreno(new Pantano(), new Nube());
//		tablero[7][7].setTerreno(new Pantano(), new Nube());
//		tablero[8][7].setTerreno(new Pantano(), new Nube());
//		tablero[9][7].setTerreno(new Pantano(), new Nube());
//		tablero[10][7].setTerreno(new Pantano(), new Nube());
//		tablero[6][8].setTerreno(new Pantano(), new Nube());
//		tablero[7][8].setTerreno(new Pantano(), new Nube());
//		tablero[8][8].setTerreno(new Pantano(), new Nube());
//		tablero[9][8].setTerreno(new Pantano(), new Nube());
//		tablero[10][8].setTerreno(new Pantano(), new Nube());
//		tablero[3][9].setTerreno(new Pantano(), new Nube());
//		tablero[4][9].setTerreno(new Pantano(), new Nube());
//		tablero[5][9].setTerreno(new Pantano(), new Nube());
//		tablero[6][9].setTerreno(new Pantano(), new Nube());
//		tablero[7][9].setTerreno(new Pantano(), new Nube());
//		tablero[8][9].setTerreno(new Pantano(), new Nube());
//		tablero[9][9].setTerreno(new Pantano(), new Nube());
//		tablero[10][9].setTerreno(new Pantano(), new Nube());
//		tablero[3][10].setTerreno(new Pantano(), new Nube());
//		tablero[4][10].setTerreno(new Pantano(), new Nube());
//		tablero[5][10].setTerreno(new Pantano(), new Nube());
//		tablero[6][10].setTerreno(new Pantano(), new Nube());
//		tablero[7][10].setTerreno(new Pantano(), new Nube());
//		tablero[8][10].setTerreno(new Pantano(), new Nube());
//		tablero[9][10].setTerreno(new Pantano(), new Nube());
//		tablero[3][11].setTerreno(new Pantano(), new Nube());
//		tablero[4][11].setTerreno(new Pantano(), new Nube());
//		tablero[5][11].setTerreno(new Pantano(), new Nube());
//		tablero[6][11].setTerreno(new Pantano(), new Nube());
//		tablero[7][11].setTerreno(new Pantano(), new Nube());
//		tablero[8][11].setTerreno(new Pantano(), new Nube());
//		tablero[9][11].setTerreno(new Pantano(), new Nube());
//
//		tablero[16][0].setTerreno(new Pantano(), new Nube());
//		tablero[16][1].setTerreno(new Pantano(), new Nube());
//		tablero[16][2].setTerreno(new Pantano(), new Nube());
//		tablero[16][3].setTerreno(new Pantano(), new Nube());
//		tablero[17][0].setTerreno(new Pantano(), new Nube());
//		tablero[17][1].setTerreno(new Pantano(), new Nube());
//		tablero[17][2].setTerreno(new Pantano(), new Nube());
//		tablero[17][3].setTerreno(new Pantano(), new Nube());
//		tablero[18][0].setTerreno(new Pantano(), new Nube());
//		tablero[18][1].setTerreno(new Pantano(), new Nube());
//		tablero[18][2].setTerreno(new Pantano(), new Nube());
//		tablero[18][3].setTerreno(new Pantano(), new Nube());
//		tablero[19][0].setTerreno(new Pantano(), new Nube());
//		tablero[19][1].setTerreno(new Pantano(), new Nube());
//		tablero[19][2].setTerreno(new Pantano(), new Nube());
//		tablero[19][3].setTerreno(new Pantano(), new Nube());
//
//		tablero[5][0].setTerreno(new Espinas(), new Nube());
//		tablero[5][1].setTerreno(new Espinas(), new Nube());
//		tablero[5][2].setTerreno(new Espinas(), new Nube());
//		tablero[5][3].setTerreno(new Espinas(), new Nube());
//		tablero[6][0].setTerreno(new Espinas(), new Nube());
//		tablero[6][1].setTerreno(new Espinas(), new Nube());
//		tablero[6][2].setTerreno(new Espinas(), new Nube());
//		tablero[6][3].setTerreno(new Espinas(), new Nube());
//		tablero[7][0].setTerreno(new Espinas(), new Nube());
//		tablero[7][1].setTerreno(new Espinas(), new Nube());
//		tablero[7][2].setTerreno(new Espinas(), new Nube());
//		tablero[7][3].setTerreno(new Espinas(), new Nube());
//		tablero[8][0].setTerreno(new Espinas(), new Nube());
//		tablero[8][1].setTerreno(new Espinas(), new Nube());
//		tablero[8][2].setTerreno(new Espinas(), new Nube());
//		tablero[8][3].setTerreno(new Espinas(), new Nube());
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
		}catch(CasilleroNoExisteException e){
			throw new CasilleroNoExisteException();
		}
	}

	public Escuadron getEscuadronRival(AlgoFormer unAlgoFormer){
		if(this.escuadronUno.perteneceAlgoformer(unAlgoFormer)){
			return this.escuadronDos;
		}
		return this.escuadronUno;
	}

	public Casillero getCasillero(Posicion posicion){
		return this.getCasillero(posicion.getX(),posicion.getY());
	}

	public int cantidadAlgoFormer(){
		return this.escuadronUno.cantidadMiembrosEscuadron()+ this.escuadronDos.cantidadMiembrosEscuadron();
	}

	public void agregarAlgoFormer(AlgoFormer unAlgoFormer,Posicion pos){
		this.getCasillero(pos).agregarContenido(unAlgoFormer);
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
		if(casillero.noExiste()){
			return;
		} else{
			casillero.quitarContenido();
			this.posicionesElementos.remove(key);
		}
	}

	public boolean tieneAlgoFormer(int posX,int posY){
		return this.getCasillero(posX,posY).tieneContenido();
	}

	public void setItem(Item item,int posX, int posY){
		this.getCasillero(posX,posY).agregarContenido(item);
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

	public void setTerreno(Terreno unTerrestreTerreno, Posicion posicion, int radio){
		int limiteSupX = posicion.getX()+(radio/2);
		int limiteSupY = posicion.getY()+(radio/2);
		int limiteInfX = posicion.getX()-(radio/2);
		int limiteInfY = posicion.getY()-(radio/2);

		if(limiteSupX > this.ancho){
			limiteSupX = this.ancho;
		}

		if(limiteInfX < 0){
			limiteInfX = 0;
		}

		if(limiteSupY > this.alto){
			limiteSupY = this.alto;
		}

		if(limiteInfY < 0){
			limiteInfY = 0;
		}

		for(int i = limiteInfX; i < limiteSupX; i++){
			for(int j = limiteInfY; j < limiteSupY; j++){
				this.getCasillero(i,j).setTerrenoTerrestre(unTerrestreTerreno);
			}
		}
	}
}
