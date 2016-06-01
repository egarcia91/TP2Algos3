package fiuba.algo3.algoformers;

import java.util.ArrayList;
import java.util.List;

import fiuba.algo3.algoformers.Casillero;
import fiuba.algo3.algoformers.AlgoFormer;

public class Tablero {
	private List<AlgoFormer> escuadronUno = new ArrayList<AlgoFormer>();
	private List<AlgoFormer> escuadronDos = new ArrayList<AlgoFormer>();
	private int ancho = 20;
	private int alto = 20;
	private int espacio = 400;
	private List<Casillero> casilleros = new ArrayList<Casillero>();

	private boolean perteneceEscuadronUno(AlgoFormer unAlgoFormer){
		for (AlgoFormer eachAlgoFormer:
				this.escuadronUno){
			if (eachAlgoFormer.getNombre()==unAlgoFormer.getNombre()){
				return true;
			}
		}
		return false;

	}

	public Tablero(){
		for(int i = 0; i < this.espacio; i++){
			Casillero unCasillero = new Casillero();
			this.casilleros.add(unCasillero);
		}
	}

	private void ubicarEscuadronUno(){
		int initY = 1;
		int initX = 1;
		for (AlgoFormer algoFormer: this.escuadronUno) {
			algoFormer.tablero = this;
			this.matrizPosition(initX,initY).agregarAlgoFormer(algoFormer);
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
		for (AlgoFormer algoFormer: this.escuadronDos) {
			algoFormer.tablero = this;
			this.matrizPosition(initX,initY).agregarAlgoFormer(algoFormer);
			if(initX == this.ancho){
				initX--;
			} else {
				initX = this.ancho;
				initY--;
			}
		}
	}

	public void agregarEscuadron(List<AlgoFormer> escuadron){
		if(escuadronUno.size()==0){
			this.escuadronUno.addAll(escuadron);
			this.ubicarEscuadronUno();
		} else if(escuadronDos.size()==0){
			this.escuadronDos.addAll(escuadron);
			this.ubicarEscuadronDos();
		}
	}

	public int cantidadAlgoFormer(){
		return this.escuadronUno.size()+this.escuadronDos.size();
	}

	public int cantidadCasilleros(){
		return this.casilleros.size();
	}

	public boolean estaDesierto(){
		if(this.cantidadAlgoFormer() == 0){
			return true;
		}
		return false;
	}

	private int searchAlgoFormer(AlgoFormer unAlgoFormer){
		for(int i = 1; i <= this.alto; i++){
			for(int h = 1; h <= this.ancho; h++){
				if(this.existeAlgoFormer(unAlgoFormer, i, h))
					return (this.alto*(h-1))+i-1;
			}
		}
		return -1;
	}

	public boolean existeAlgoFormer(AlgoFormer unAlgoFormer, int unAncho, int unAlto){
		Casillero unCasillero = this.matrizPosition(unAncho,unAlto);
		return unCasillero.existeAlgoFormer(unAlgoFormer);
	}

	private Casillero matrizPosition(int unAncho, int unAlto){
		return this.casilleros.get((this.alto*(unAlto-1))+unAncho-1);
	}

	public int ancho(){
		return this.ancho;
	}

	public int alto(){
		return this.alto;
	}

	public int espacio(){
		return this.espacio;
	}

	public void addAlgoFormer (AlgoFormer unAlgoformer, int x, int y){}

	public void moverDerecha(AlgoFormer unAlgoFormer, int velocidad){
		int position = this.searchAlgoFormer(unAlgoFormer);
		if(position > -1){
			int unAncho = position%this.alto + 1;
			int unAlto = (position-(position%this.alto))/this.alto + 1;

			int anchoFinal = unAncho + velocidad;
			if(anchoFinal <= this.ancho  && anchoFinal > 0){
				Casillero casilleroFinal = this.matrizPosition(anchoFinal,unAlto);
				Casillero casilleroInicial = this.matrizPosition(unAncho,unAlto);
				if(!casilleroFinal.tieneAlgoFormer()){
					casilleroInicial.quitarAlgoFormer();
					casilleroFinal.agregarAlgoFormer(unAlgoFormer);
				}
			}
		}
	}

	public void moverIzquierda(AlgoFormer unAlgoFormer, int velocidad){
		int position = this.searchAlgoFormer(unAlgoFormer);
		if(position > -1){
			int unAncho = position%this.alto + 1;
			int unAlto = (position-(position%this.alto))/this.alto + 1;

			int anchoFinal = unAncho - velocidad; //Lo que cambia para moverse a la izquierda
			if(anchoFinal <= this.ancho && anchoFinal > 0 ){
				Casillero casilleroFinal = this.matrizPosition(anchoFinal,unAlto);
				Casillero casilleroInicial = this.matrizPosition(unAncho,unAlto);
				if(!casilleroFinal.tieneAlgoFormer()){
					casilleroInicial.quitarAlgoFormer();
					casilleroFinal.agregarAlgoFormer(unAlgoFormer);
				}
			}
		}
	}

	public void moverArriba(AlgoFormer unAlgoFormer, int velocidad){
		int position = this.searchAlgoFormer(unAlgoFormer);
		if(position > -1){
			int unAncho = position%this.alto + 1;
			int unAlto = (position-(position%this.alto))/this.alto + 1;

			int altoFinal = unAlto + velocidad;
			if(altoFinal <= this.alto && altoFinal > 0){
				Casillero casilleroFinal = this.matrizPosition(unAncho,altoFinal);
				Casillero casilleroInicial = this.matrizPosition(unAncho,unAlto);
				if(!casilleroFinal.tieneAlgoFormer()){
					casilleroInicial.quitarAlgoFormer();
					casilleroFinal.agregarAlgoFormer(unAlgoFormer);
				}
			}
		}
	}

	public void moverAbajo(AlgoFormer unAlgoFormer, int velocidad){
		int position = this.searchAlgoFormer(unAlgoFormer);
		if(position > -1){
			int unAncho = position%this.alto + 1;
			int unAlto = (position-(position%this.alto))/this.alto + 1;

			int altoFinal = unAlto - velocidad;
			if(altoFinal <= this.alto && altoFinal > 0){
				Casillero casilleroFinal = this.matrizPosition(unAncho,altoFinal);
				Casillero casilleroInicial = this.matrizPosition(unAncho,unAlto);
				if(!casilleroFinal.tieneAlgoFormer()){
					casilleroInicial.quitarAlgoFormer();
					casilleroFinal.agregarAlgoFormer(unAlgoFormer);
				}
			}
		}
	}


	public void ataqueZona(AlgoFormer unAlgoFormer,int unaDistanciaAtaque, int unaFuerzaAtaque){
		int position = this.searchAlgoFormer(unAlgoFormer);
		int unAncho = position%this.alto + 1;
		int unAlto = (position-(position%this.alto))/this.alto + 1;
		int anchoFinal = unAncho+unaDistanciaAtaque;
		int anchoInicial = unAncho-unaDistanciaAtaque;
		int altoFinal = unAlto+unaDistanciaAtaque;
		int altoInicial = unAlto-unaDistanciaAtaque;
		if (this.perteneceEscuadronUno(unAlgoFormer)) {
			for (AlgoFormer eachAlgoFormer :
					this.escuadronDos) {
				int positionEnemigo = this.searchAlgoFormer(eachAlgoFormer);
				int unAnchoEnemigo = positionEnemigo % this.alto + 1;
				int unAltoEnemigo = (positionEnemigo - (positionEnemigo % this.alto)) / this.alto + 1;
				if (unAnchoEnemigo >= anchoInicial && unAnchoEnemigo <= anchoFinal && unAltoEnemigo >= altoInicial && unAltoEnemigo <= altoFinal) {
					eachAlgoFormer.recibirAtaque(unaFuerzaAtaque);
				}
			}
		}else{
				for (AlgoFormer eachAlgoFormer:
						this.escuadronUno){
					int positionEnemigo = this.searchAlgoFormer(eachAlgoFormer);
					int unAnchoEnemigo = positionEnemigo%this.alto + 1;
					int unAltoEnemigo = (positionEnemigo-(positionEnemigo%this.alto))/this.alto + 1;
					if ( unAnchoEnemigo >= anchoInicial && unAnchoEnemigo <= anchoFinal && unAltoEnemigo >= altoInicial && unAltoEnemigo <= altoFinal){
						eachAlgoFormer.recibirAtaque(unaFuerzaAtaque);
					}
				}
		}

	}
}
