package fiuba.algo3.algoformers;

import fiuba.algo3.tablero.Posicion;
import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.algoformers.AlgoFormer;
import fiuba.algo3.tablero.Juego;
import fiuba.algo3.tablero.Jugador;
import fiuba.algo3.tablero.Tablero;
import fiuba.algo3.algoformers.Escuadron;
import fiuba.algo3.algoformers.personajes.Megatron;
import fiuba.algo3.algoformers.personajes.OptimusPrime;

public class AlgoFormerPrimerTests {

	@Test
	public void test01verificarMovimiento() {
		Tablero tab = new Tablero(20,20);

		AlgoFormer algoFormer = new AlgoFormer();
		//Escuadron escuadronUno = new Escuadron();
		//escuadronUno.agregarAlgoFormer(algoFormer);

		//tab.agregarEscuadron(escuadronUno);
		Posicion unaPosicion = new Posicion(1,1);
		tab.agregarAlgoFormer(algoFormer,unaPosicion);
		Assert.assertTrue(tab.existeAlgoFormer(algoFormer,1,1));

		algoFormer.moverDerecha();

		Assert.assertFalse(tab.existeAlgoFormer(algoFormer,2,1));
	}

	@Test
	public void test02verificarTransformacion() {
		Tablero tab = new Tablero(20,20);

		AlgoFormer algoFormer = new AlgoFormer();
		Escuadron escuadronUno = new Escuadron();
		escuadronUno.agregarAlgoFormer(algoFormer);

		tab.agregarEscuadron(escuadronUno);

		Assert.assertTrue(algoFormer.esHumanoide());

		algoFormer.transformarAlterno();

		Assert.assertFalse(algoFormer.esHumanoide());
		Assert.assertTrue(algoFormer.esAlterno());

		algoFormer.transformarHumanoide();

		Assert.assertTrue(algoFormer.esHumanoide());
		Assert.assertFalse(algoFormer.esAlterno());
	}

	@Test
	public void test03verificarMovimientoAlterno() {
		Tablero tab = new Tablero(20,20);

		AlgoFormer algoFormer = new AlgoFormer();
		algoFormer.transformarAlterno();
		Escuadron escuadronUno = new Escuadron();
		escuadronUno.agregarAlgoFormer(algoFormer);

		tab.agregarEscuadron(escuadronUno);

		Assert.assertTrue(tab.existeAlgoFormer(algoFormer,0,0));

		//System.out.println("primero esta en: " + tab.getPosicion(algoFormer).getX() + "," + tab.getPosicion(algoFormer).getY());
		algoFormer.moverDerecha();
		//System.out.println("y luego: " + tab.getPosicion(algoFormer).getX() + "," + tab.getPosicion(algoFormer).getY());

		Assert.assertTrue(tab.existeAlgoFormer(algoFormer,4,0));
	}

	@Test
	public void test04crearJuegoDosJugadores() {

		Juego juego = new Juego();

		Jugador jugadorUno = new Jugador("Sam");

		Jugador jugadorDos = new Jugador("Max");

		juego.agregarJugador(jugadorUno);
		Assert.assertTrue(juego.existeJugador(jugadorUno));
		juego.agregarJugador(jugadorDos);
		Assert.assertTrue(juego.existeJugador(jugadorDos));

		juego.iniciar();

		Assert.assertTrue(jugadorUno.existeEscuadron());
		Assert.assertTrue(jugadorUno.tieneAlgoFormerEnPosicion(0,0));
		Assert.assertTrue(jugadorUno.tieneAlgoFormerEnPosicion(0,1));
		Assert.assertTrue(jugadorUno.tieneAlgoFormerEnPosicion(1,0));


		Assert.assertTrue(jugadorDos.existeEscuadron());

		int ancho = juego.getTableroAncho();
		int alto = juego.getTableroAlto();
		Assert.assertTrue(jugadorDos.tieneAlgoFormerEnPosicion(ancho-1,alto-1));
		Assert.assertTrue(jugadorDos.tieneAlgoFormerEnPosicion(ancho-2,alto-1));
		Assert.assertTrue(jugadorDos.tieneAlgoFormerEnPosicion(ancho-1,alto-2));


//		//FIXME esto nose como va a ser pero hay que corroborar los turnos
//		jugadorUno.moverAlgoFormer();
//
//		jugadorDos.moverAlgoFormer();
//
//		//Exception!!!
//		jugadorDos.moverAlgoFormer();
	}

	@Test
	public void test05modosAtaques() {

		OptimusPrime optimusPrime = new OptimusPrime();
		optimusPrime.transformarAlterno();

		Escuadron escuadronUno = new Escuadron();
		escuadronUno.agregarAlgoFormer(optimusPrime);

		Megatron megatron = new Megatron();

		Escuadron escuadronDos = new Escuadron();
		escuadronDos.agregarAlgoFormer(megatron);

		Tablero tab = new Tablero(20,20);
		tab.agregarEscuadron(escuadronUno);
		tab.agregarEscuadron(escuadronDos);

		Assert.assertTrue(megatron.getVida() == 550);
		//System.out.println("primero esta en: " + tab.getPosicion(optimusPrime).getX() + "," + tab.getPosicion(optimusPrime).getY());
		optimusPrime.moverDerecha();
		optimusPrime.moverDerecha();
		optimusPrime.moverDerecha();
		optimusPrime.moverDerecha();

		optimusPrime.moverArriba();
		optimusPrime.moverArriba();
		optimusPrime.moverArriba();
		optimusPrime.moverArriba();
		
		optimusPrime.atacar();
		Assert.assertTrue(megatron.getVida() == 535);

		Assert.assertTrue(optimusPrime.getVida() == 500);

		//System.out.println("primero esta en: " + tab.getPosicion(optimusPrime).getX() + "," + tab.getPosicion(optimusPrime).getY());
		megatron.moverIzquierda();
		megatron.moverIzquierda();
		megatron.moverIzquierda();

		megatron.moverAbajo();
		megatron.moverAbajo();
		megatron.moverAbajo();
		//System.out.println("luego de mover arriba x 3: " + tab.getPosicion(optimusPrime).getX() + "," + tab.getPosicion(optimusPrime).getY());
	
		megatron.atacar();
		Assert.assertTrue(optimusPrime.getVida() == 490);

		optimusPrime.moverIzquierda();
		optimusPrime.moverIzquierda();
		optimusPrime.moverIzquierda();

		//Ahora esta lejos!
		Assert.assertTrue(optimusPrime.getVida() == 490);
		megatron.atacar();
		Assert.assertTrue(optimusPrime.getVida() == 490);
	}

}
