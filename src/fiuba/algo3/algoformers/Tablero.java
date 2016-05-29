package fiuba.algo3.algoformers;

import java.util.ArrayList;
import java.util.List;

import fiuba.algo3.algoformers.Casillero;
import fiuba.algo3.algoformers.AlgoFormer;

public class Tablero {
	private List<AlgoFormer> escuadronUno = new ArrayList<AlgoFormer>();
	private List<AlgoFormer> escuadronDos = new ArrayList<AlgoFormer>();
	private int ancho = 3;
	private int alto = 3;
	private int espacio = 9;
	private List<Casillero> casilleros = new ArrayList<Casillero>();

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
		if(escuadronUno.isEmpty()){
			this.escuadronUno.addAll(escuadron);
			this.ubicarEscuadronUno();
		} else if(escuadronDos.isEmpty()){
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
}
