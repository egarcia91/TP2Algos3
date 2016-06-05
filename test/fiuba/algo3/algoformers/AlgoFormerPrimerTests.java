package fiuba.algo3.algoformers;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.algoformers.AlgoFormer;
import fiuba.algo3.algoformers.Jugador;
import fiuba.algo3.algoformers.Tablero;
import fiuba.algo3.algoformers.Juego;

public class AlgoFormerPrimerTests {

	@Test
	public void test01verificarMovimiento() {
		Tablero tab = new Tablero(20,20);

		AlgoFormer algoFormer = new AlgoFormer();
		List<AlgoFormer> escuadronUno = new ArrayList<AlgoFormer>();
		escuadronUno.add(algoFormer);

		tab.agregarEscuadron(escuadronUno);

		Assert.assertTrue(tab.existeAlgoFormer(algoFormer,1,1));

		algoFormer.moverDerecha();
		Assert.assertFalse(tab.existeAlgoFormer(algoFormer,3,1));
	}
	
	@Test
	public void test02verificarTransformacion() {
		Tablero tab = new Tablero(20,20);

		AlgoFormer algoFormer = new AlgoFormer();
		List<AlgoFormer> escuadronUno = new ArrayList<AlgoFormer>();
		escuadronUno.add(algoFormer);

		tab.agregarEscuadron(escuadronUno);

		Assert.assertTrue(algoFormer.estadoTransformacion() == "Humanoide");

		algoFormer.transformarAlterno();

		Assert.assertFalse(algoFormer.estadoTransformacion() == "Humanoide");
		Assert.assertTrue(algoFormer.estadoTransformacion() == "Alterno");

		algoFormer.transformarHumanoide();

		Assert.assertTrue(algoFormer.estadoTransformacion() == "Humanoide");
		Assert.assertFalse(algoFormer.estadoTransformacion() == "Alterno");
	}

	@Test
	public void test03verificarMovimientoAlterno() {
		Tablero tab = new Tablero(20,20);

		AlgoFormer algoFormer = new AlgoFormer();
		algoFormer.transformarAlterno();
		List<AlgoFormer> escuadronUno = new ArrayList<AlgoFormer>();
		escuadronUno.add(algoFormer);

		tab.agregarEscuadron(escuadronUno);

		Assert.assertTrue(tab.existeAlgoFormer(algoFormer,1,1));

		algoFormer.moverDerecha();
		Assert.assertTrue(tab.existeAlgoFormer(algoFormer,6,1));
	}

	@Test
	public void test04crearJuegoDosJugadores() {

		Juego juego = new Juego();
		
		Jugador jugadorUno = new Jugador();
		jugadorUno.setNombre("Sam");

		Jugador jugadorDos = new Jugador();
		jugadorDos.setNombre("Max");

		juego.agregarJugador(jugadorUno);
		Assert.assertTrue(juego.existeJugador(jugadorUno));
		juego.agregarJugador(jugadorDos);
		Assert.assertTrue(juego.existeJugador(jugadorDos));

		juego.iniciar();

		Assert.assertTrue(jugadorUno.existeEscuadron());
		Assert.assertTrue(jugadorUno.tieneAlgoFormerEnPosicion(1,1));
		Assert.assertTrue(jugadorUno.tieneAlgoFormerEnPosicion(1,2));
		Assert.assertTrue(jugadorUno.tieneAlgoFormerEnPosicion(2,1));


		Assert.assertTrue(jugadorDos.existeEscuadron());
		//TODO Posiciones.
		int ancho=juego.tableroAncho();
		int alto=juego.tableroAlto();
		Assert.assertTrue(jugadorDos.tieneAlgoFormerEnPosicion(alto,ancho));
		Assert.assertTrue(jugadorDos.tieneAlgoFormerEnPosicion(alto,ancho-1));
		Assert.assertTrue(jugadorDos.tieneAlgoFormerEnPosicion(alto-1,ancho));

		//FIXME esto nose como va a ser pero hay que corroborar los turnos
		jugadorUno.moverAlgoFormer();

		jugadorDos.moverAlgoFormer();

		//Exception!!!
		jugadorDos.moverAlgoFormer();
	}
  
	@Test
	public void test05modosAtaques() {
		Tablero tab = new Tablero(20,20);

		List<AlgoFormer> escuadronUno = new ArrayList<AlgoFormer>();
		List<AlgoFormer> escuadronDos = new ArrayList<AlgoFormer>();

		OptimusPrime optimusPrime = new OptimusPrime("Alterno");
		escuadronUno.add(optimusPrime);

		Megatron megatron = new Megatron("Humanoide");
		escuadronDos.add(megatron);

		tab.agregarEscuadron(escuadronUno);
		tab.agregarEscuadron(escuadronDos);

		Assert.assertTrue(megatron.vida() == 550);

		optimusPrime.moverDerecha();
		optimusPrime.moverDerecha();
		optimusPrime.moverDerecha();

		optimusPrime.moverArriba();
		optimusPrime.moverArriba();
		optimusPrime.moverArriba();

		optimusPrime.atacar();
		Assert.assertTrue(megatron.vida() == 535);

		Assert.assertTrue(optimusPrime.vida() == 500);

		megatron.moverIzquierda();
		megatron.moverIzquierda();
		megatron.moverIzquierda();

		megatron.moverAbajo();
		megatron.moverAbajo();
		megatron.moverAbajo();

		megatron.atacar();
		Assert.assertTrue(optimusPrime.vida() == 490);

		optimusPrime.moverIzquierda();
		optimusPrime.moverIzquierda();
		optimusPrime.moverIzquierda();

		//Ahora esta lejos!
		Assert.assertTrue(optimusPrime.vida() == 490);
		megatron.atacar();
		Assert.assertTrue(optimusPrime.vida() == 490);
	}
}
