package fiuba.algo3.tablero;

import fiuba.algo3.algoformers.AlgoFormer;
import fiuba.algo3.tablero.Tablero;
import fiuba.algo3.tablero.Terreno;
import fiuba.algo3.tablero.Casillero;
import fiuba.algo3.tablero.CasilleroOcupadoException;
import fiuba.algo3.tablero.CasilleroNoExisteException;
import fiuba.algo3.tablero.Posicion;

public class Movimiento {
	private Tablero tablero;

	public void setTablero(Tablero unTablero){
		this.tablero = unTablero;
	}

	private int recorrerCasillero(AlgoFormer unAlgoFormer, Terreno unTerreno){
		if(unTerreno.tienePenalizacion()){
			int vida = unAlgoFormer.getVida();
			unAlgoFormer.setVida(vida - (vida*unTerreno.getPenalizacionVida())/100);
			int penalizacionAtaque = unTerreno.getPenalizacionAtaque();
			if(penalizacionAtaque != 0 && unAlgoFormer.getPenalizacionAtaque() == 0){
				unAlgoFormer.setFuerzaAtaque(unAlgoFormer.getFuerzaAtaque() - unTerreno.getPenalizacionAtaque());
				unAlgoFormer.setPenalizacionAtaque(1);
			}
			int penalizacionTurnos = unTerreno.getPenalizacionTurnos();
			if(penalizacionTurnos != 0){
				unAlgoFormer.setTurno(penalizacionTurnos);
				return unAlgoFormer.getVelocidad();
			}
		}
		return unTerreno.getVelocidad();
	}

	public void moverAlgoFormerDerecha(AlgoFormer unAlgoFormer,int velocidad){
		this.moverAlgoFormer(unAlgoFormer,velocidad,1,0);
	}

	public void moverAlgoFormerIzquierda(AlgoFormer unAlgoFormer,int velocidad){
		this.moverAlgoFormer(unAlgoFormer,velocidad,-1,0);
	}

	public void moverAlgoFormerAbajo(AlgoFormer unAlgoFormer,int velocidad){
		this.moverAlgoFormer(unAlgoFormer,velocidad,0,1);
	}

	public void moverAlgoFormerArriba(AlgoFormer unAlgoFormer,int velocidad){
		this.moverAlgoFormer(unAlgoFormer,velocidad,0,-1);
	}

	public void moverAlgoFormer(AlgoFormer unAlgoFormer,int velocidad,int x, int y){
		Posicion posicionInicial = this.tablero.getPosicion(unAlgoFormer);
		int cantVelocidad = velocidad;
		Casillero casillero = null;
		int i = 1;
		for(; i <= cantVelocidad; i++){
			casillero = this.tablero.getCasillero(posicionInicial.getX()+(i*x), posicionInicial.getY()+(i*y));
			if(unAlgoFormer.getTipoUnidad() == "Terrestre"){
				cantVelocidad -= recorrerCasillero(unAlgoFormer,casillero.getTerrenoTerrestre());
			} else {
				cantVelocidad -= recorrerCasillero(unAlgoFormer,casillero.getTerrenoAereo());
			}
		}
		Posicion posicionFinal = new Posicion(posicionInicial.getX()+(i*x),posicionInicial.getY()+(i*y));

		if(casillero == null){
			throw new CasilleroNoExisteException();
		} else if(casillero.contieneAlgoFormer()){
			throw new CasilleroOcupadoException();
		} else {
			this.tablero.quitarAlgoFormer(unAlgoFormer);
			this.tablero.agregarAlgoFormer(unAlgoFormer,posicionFinal);
			this.tablero.setPosicion(unAlgoFormer, posicionFinal);
		}
	}


	public boolean existeAlgoFormer(AlgoFormer unAlgoFormer, int x,int y){
		Posicion posicionAlgoFormer = this.tablero.getPosicion(unAlgoFormer);
		Posicion posicionConsulta = new Posicion(x,y);

		if (posicionAlgoFormer.getX() == posicionConsulta.getX()
				&& posicionAlgoFormer.getY() == posicionConsulta.getY()){
			return true;}
		else{
		return false;
		}
	}

}

