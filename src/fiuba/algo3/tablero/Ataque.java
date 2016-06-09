package fiuba.algo3.tablero;

import java.util.LinkedHashMap;
import java.util.Map;
import fiuba.algo3.algoformers.Escuadron;
import fiuba.algo3.algoformers.AlgoFormer;

public class Ataque {

	protected Tablero tablero;

	public void setTablero(Tablero tablero) {
		this.tablero = tablero;
	}


	public void ataqueZona(AlgoFormer unAlgoFormer,int unaDistanciaAtaque, int unaFuerzaAtaque){
		Posicion posicionActual = this.tablero.buscarAlgoFormer(unAlgoFormer);

		Posicion posicionMenor = new Posicion(posicionActual.getX()-unaDistanciaAtaque,posicionActual.getY()-unaDistanciaAtaque);
		Posicion posicionMayor = new Posicion(posicionActual.getX()+unaDistanciaAtaque,posicionActual.getY()+unaDistanciaAtaque);

		if (this.tablero.perteneceEscuadronUno(unAlgoFormer)) {
			for (int i=0; i <this.tablero.escuadronDos.cantidadMiembrosEscuadron();i++){
				Posicion posicionEnemigo = this.tablero.buscarAlgoFormer(this.tablero.escuadronDos.getAlgoFormer(i));
				if (posicionEnemigo.getX() >= posicionMenor.getX() && posicionEnemigo.getX() <= posicionMayor.getX()
						&& posicionEnemigo.getY() >= posicionMenor.getY() && posicionEnemigo.getY() <= posicionMayor.getY()) {
					this.tablero.escuadronDos.getAlgoFormer(i).recibirAtaque(unaFuerzaAtaque);
				}
			}
		}else{
			for (int j=0; j <this.tablero.escuadronUno.cantidadMiembrosEscuadron();j++){
				Posicion posicionEnemigo = this.tablero.buscarAlgoFormer(this.tablero.escuadronUno.getAlgoFormer(j));
				if (posicionEnemigo.getX() >= posicionMenor.getX() && posicionEnemigo.getX() <= posicionMayor.getX()
						&& posicionEnemigo.getY() >= posicionMenor.getY() && posicionEnemigo.getY() <= posicionMayor.getY()) {
					this.tablero.escuadronUno.getAlgoFormer(j).recibirAtaque(unaFuerzaAtaque);
				}
			}
		}
	}


}
