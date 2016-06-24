package fiuba.algo3.tablero;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import fiuba.algo3.algoformers.Escuadron;
import fiuba.algo3.algoformers.AlgoFormer;

public class Ataque {

	protected Tablero tablero;

	public void setTablero(Tablero tablero) {
		this.tablero = tablero;
	}

	private boolean estaEnRangoDeAtaque(AlgoFormer algoFormer, Posicion posicion, int rango){
		Posicion posicionAlgoformer = this.tablero.getPosicion(algoFormer);
		posicionAlgoformer.restar(posicion);
		if(Math.abs(posicionAlgoformer.getX()) <= rango || Math.abs(posicionAlgoformer.getY()) <= rango){
			return true;
		} else {
			return false;
		}
	}
/*
	public Escuadron getAlgoformersEnRango(AlgoFormer unAlgoFormer){
		Escuadron algoformersEnRango = new Escuadron();
		Posicion posicion = this.tablero.getPosicion(unAlgoFormer);
		int rango = unAlgoFormer.getDistanciaAtaque();

		Escuadron escuadronRival = this.tablero.getEscuadronRival(unAlgoFormer);
		int cantidadAlgoFormers = escuadronRival.cantidadMiembrosEscuadron();
		for(int i = 0; i < cantidadAlgoFormers; i++){
			AlgoFormer rivalAlgoFormer = escuadronRival.getAlgoFormer(i);
			if(this.estaEnRangoDeAtaque(rivalAlgoFormer,posicion,rango)){
				algoformersEnRango.agregarAlgoFormer(rivalAlgoFormer);
			}
		}

		return algoformersEnRango;
	}*/
/*
	public void ataqueZona(AlgoFormer unAlgoFormer,int unaDistanciaAtaque, int unaFuerzaAtaque){
		Posicion posicionActual = this.tablero.buscarAlgoFormer(unAlgoFormer);

		Posicion posicionMenor = new Posicion(posicionActual.getX()-unaDistanciaAtaque,posicionActual.getY()-unaDistanciaAtaque);
		Posicion posicionMayor = new Posicion(posicionActual.getX()+unaDistanciaAtaque,posicionActual.getY()+unaDistanciaAtaque);

		if (this.tablero.perteneceEscuadronUno(unAlgoFormer)) {
			for (int i=0; i <this.tablero.escuadronDos.cantidadMiembrosEscuadron(); i++){
				Posicion posicionEnemigo = this.tablero.buscarAlgoFormer(this.tablero.escuadronDos.getAlgoFormer(i));
				if (posicionEnemigo.getX() >= posicionMenor.getX() && posicionEnemigo.getX() <= posicionMayor.getX()
						&& posicionEnemigo.getY() >= posicionMenor.getY() && posicionEnemigo.getY() <= posicionMayor.getY()) {
					this.tablero.escuadronDos.getAlgoFormer(i).recibirAtaque(unaFuerzaAtaque);
				}
			}
		} else {
			for (int j=0; j < this.tablero.escuadronUno.cantidadMiembrosEscuadron(); j++){
				Posicion posicionEnemigo = this.tablero.buscarAlgoFormer(this.tablero.escuadronUno.getAlgoFormer(j));
				if (posicionEnemigo.getX() >= posicionMenor.getX() && posicionEnemigo.getX() <= posicionMayor.getX()
						&& posicionEnemigo.getY() >= posicionMenor.getY() && posicionEnemigo.getY() <= posicionMayor.getY()) {
					this.tablero.escuadronUno.getAlgoFormer(j).recibirAtaque(unaFuerzaAtaque);
				}
			}
		}
	}
*/
	public void atacar(AlgoFormer unAlgoFormer, int unaFuerzaAtaque){
		if(!unAlgoFormer.estaVacio()){
			unAlgoFormer.recibirAtaque(unaFuerzaAtaque);
		}
	}

}
