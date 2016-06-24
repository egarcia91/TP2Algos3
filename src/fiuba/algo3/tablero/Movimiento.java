package fiuba.algo3.tablero;

import fiuba.algo3.algoformers.AlgoFormer;
import fiuba.algo3.juegomvc.SoundPlayer;
import fiuba.algo3.juegomvc.SoundPlayer.enumSound;
import fiuba.algo3.tablero.Tablero;
import fiuba.algo3.tablero.Terreno;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import fiuba.algo3.tablero.Casillero;
import fiuba.algo3.tablero.CasilleroNoExiste;
import fiuba.algo3.tablero.CasilleroOcupadoException;
import fiuba.algo3.tablero.CasilleroNoExisteException;
import fiuba.algo3.tablero.Posicion;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Movimiento {
	private Tablero tablero;
	//lo agregue ahora
	private Posicion posicionFinal;

	public void setTablero(Tablero unTablero){
		this.tablero = unTablero;
	}
	
	public void moverAlgoFormerDerecha(AlgoFormer unAlgoFormer,int velocidad){
		this.moverAlgoFormer(unAlgoFormer,velocidad,1,0);
	}

	public void moverAlgoFormerIzquierda(AlgoFormer unAlgoFormer,int velocidad){
		this.moverAlgoFormer(unAlgoFormer,velocidad,-1,0);
	}

	public void moverAlgoFormerAbajo(AlgoFormer unAlgoFormer,int velocidad){
		this.moverAlgoFormer(unAlgoFormer,velocidad,0,-1);
	}

	public void moverAlgoFormerArriba(AlgoFormer unAlgoFormer,int velocidad){
		this.moverAlgoFormer(unAlgoFormer,velocidad,0,1);
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
		if(unAlgoFormer.getVelocidad() != 1 && unAlgoFormer.esHumanoide()){
			return unAlgoFormer.getVelocidad();
		}
		return unTerreno.getVelocidad();
	}


	public void moverAlgoFormer(AlgoFormer unAlgoFormer,int velocidad,int x, int y){

		//Casillero casillero = posibleCasilleroFinal(unAlgoFormer, velocidad, x, y);
		Casillero casillero = new Casillero();
		try{
			casillero = posibleCasilleroFinal(unAlgoFormer, velocidad+2, x, y);
		}
		catch (CasilleroNoExisteException excepcion){}

		try{
			casillero.agregarContenido(unAlgoFormer);

			this.tablero.quitarAlgoFormer(unAlgoFormer);
			this.tablero.agregarAlgoFormer(unAlgoFormer,posicionFinal);
		}catch (CasilleroOcupadoException exception){}

		//this.tablero.setPosicion(unAlgoFormer, posicionFinal);
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


	// Todo esto seria lo mas nuevo, saque cosas de moverAlgoFormer para hacer las posibles posiciones
	// para que por otro lado si uno quiere mover el algoformer, llama al metodo de posible posicion final
	// y luego lo corre segun corresponta, cosa que no se quiere hacer justamente cuando solo se quiere ver
	// las posibles posiciones, por eso lo separe

	public Casillero posibleCasilleroFinal(AlgoFormer unAlgoFormer, int velocidad, int x, int y){
		Posicion posicionInicial = this.tablero.getPosicion(unAlgoFormer);
		int cantVelocidad = velocidad;
		Casillero casillero = new CasilleroNoExiste();
		int i = 1;

		if (x>this.tablero.getAncho() || (posicionInicial.getX()+x)<0
				|| y>this.tablero.getAlto() || (posicionInicial.getY()+y)<0 ){
			throw new CasilleroNoExisteException();
		}

		for(; i <= cantVelocidad; i++){
			casillero = this.tablero.getCasillero(posicionInicial.getX()+(i*x), posicionInicial.getY()+(i*y));
			if(casillero.noExiste()){
				return casillero;
			}
			if(unAlgoFormer.esTerrestre()){
				cantVelocidad -= recorrerCasillero(unAlgoFormer,casillero.getTerrenoTerrestre());
			} else {
				cantVelocidad -= recorrerCasillero(unAlgoFormer,casillero.getTerrenoAereo());
			}
		}
		this.posicionFinal = new Posicion(posicionInicial.getX()+(i*x),posicionInicial.getY()+(i*y));
		return casillero;
	}

	public Casillero posiblePosicionDerecha(AlgoFormer unAlgoFormer,int velocidad){
		return this.posibleCasilleroFinal(unAlgoFormer,velocidad,1,0);
	}

	public Casillero  posiblePosicionIzquierda(AlgoFormer unAlgoFormer,int velocidad){
		return this.posibleCasilleroFinal(unAlgoFormer,velocidad,-1,0);
	}

	public Casillero  posiblePosicionAbajo(AlgoFormer unAlgoFormer,int velocidad){
		return this.posibleCasilleroFinal(unAlgoFormer,velocidad,0,-1);
	}

	public Casillero  posiblePosicionArriba(AlgoFormer unAlgoFormer,int velocidad){
		return this.posibleCasilleroFinal(unAlgoFormer, velocidad, 0,1);
	}


	public ArrayList<Casillero> posiblesMovimientos (AlgoFormer unAlgoFormer, int velocidad){
		ArrayList<Casillero> posiblesMovimientos = new ArrayList<Casillero>();
		int cantvelocidad=unAlgoFormer.getVelocidad();
		System.out.println(""+cantvelocidad);
		for (int i=1 ; i<=cantvelocidad ; i++){
			try {
				posiblesMovimientos.add(posibleCasilleroFinal(unAlgoFormer,cantvelocidad,i,0));
			}catch (CasilleroNoExisteException excepcion){}
			try {
				posiblesMovimientos.add(posibleCasilleroFinal(unAlgoFormer,cantvelocidad,-i,0));
			}catch (CasilleroNoExisteException excepcion){}
			try {
				posiblesMovimientos.add(posibleCasilleroFinal(unAlgoFormer,cantvelocidad,0,i));
			}catch (CasilleroNoExisteException excepcion){}
			try {
				posiblesMovimientos.add(posibleCasilleroFinal(unAlgoFormer,cantvelocidad,0,-i));
			}catch (CasilleroNoExisteException excepcion){}

			for (int j=1 ; j<=velocidad ; j++ ){
				try {
					posiblesMovimientos.add(posibleCasilleroFinal(unAlgoFormer,velocidad,i,i-j));
					posiblesMovimientos.add(posibleCasilleroFinal(unAlgoFormer,velocidad,i-j,i));
					posiblesMovimientos.add(posibleCasilleroFinal(unAlgoFormer,velocidad,i,i));
				}catch (CasilleroNoExisteException excepcion){}
				try {
					posiblesMovimientos.add(posibleCasilleroFinal(unAlgoFormer,velocidad,-i,-i+j));
					posiblesMovimientos.add(posibleCasilleroFinal(unAlgoFormer,velocidad,-i+j,-i));
					posiblesMovimientos.add(posibleCasilleroFinal(unAlgoFormer,velocidad,-i,-i));
				}catch (CasilleroNoExisteException excepcion){}
				try {
					posiblesMovimientos.add(posibleCasilleroFinal(unAlgoFormer,velocidad,i,-i+j));
					posiblesMovimientos.add(posibleCasilleroFinal(unAlgoFormer,velocidad,i-j,-i));
					posiblesMovimientos.add(posibleCasilleroFinal(unAlgoFormer,velocidad,i,-i));
				}catch (CasilleroNoExisteException excepcion){}
				try {
					posiblesMovimientos.add(posibleCasilleroFinal(unAlgoFormer,velocidad,-i+j,i));
					posiblesMovimientos.add(posibleCasilleroFinal(unAlgoFormer,velocidad,-i,i-j));
					posiblesMovimientos.add(posibleCasilleroFinal(unAlgoFormer,velocidad,-i,i));
				}catch (CasilleroNoExisteException excepcion){}
			}

		}
		return posiblesMovimientos;
	}

	/*
	public ArrayList<Casillero> posiblesMovimientos(AlgoFormer unAlgoFormer, int velocidad){
		//Aca lo que se me ocurre asi planteado
		//seria que ejecute los cuatro metodos de posiblePosicion
		//guardados en un Array, que de alguna forma se podrian visualizar en la Interfaz
		ArrayList<Casillero> posiblesPosicionesFinales = new ArrayList<Casillero>();
		try {
			posiblesPosicionesFinales.add(posiblePosicionDerecha(unAlgoFormer, velocidad));
		}catch (CasilleroNoExisteException excepcion){}
		try {
		posiblesPosicionesFinales.add(posiblePosicionIzquierda(unAlgoFormer, velocidad));
		}catch (CasilleroNoExisteException excepcion){}
		try {
		posiblesPosicionesFinales.add(posiblePosicionAbajo(unAlgoFormer, velocidad));
		}catch (CasilleroNoExisteException excepcion){}
		try {
		posiblesPosicionesFinales.add(posiblePosicionArriba(unAlgoFormer, velocidad));
		}catch (CasilleroNoExisteException excepcion){}
		return posiblesPosicionesFinales;
	}
	*/

	public void mover(Posicion posicionFinal, AlgoFormer unAlgoFormer){
		
		Casillero casillero = this.tablero.getCasillero(posicionFinal);
		if(casillero.tieneContenido() == true){
			Contenido contenido = casillero.getContenido();
			
			if(contenido.esBonus() == true){
					Item bonus = (Item) contenido;
				unAlgoFormer.setFuerzaAtaque(unAlgoFormer.getFuerzaAtaque() * bonus.getFactorBonificacionPoderAtaque());
				unAlgoFormer.setVelocidad(unAlgoFormer.getVelocidad() * bonus.getFactorBonificacionVelocidad());
				unAlgoFormer.agregarItem(bonus);
				SoundPlayer sound = new SoundPlayer();
				sound.play(enumSound.BONUS_SOUND);
			}
		}
		this.tablero.quitarAlgoFormer(unAlgoFormer);
		this.tablero.agregarAlgoFormer(unAlgoFormer,posicionFinal);

	}
	
}

