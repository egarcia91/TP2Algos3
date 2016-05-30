package fiuba.algo3.algoformers;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.algoformers.AlgoFormer;
import fiuba.algo3.algoformers.Jugador;
import fiuba.algo3.algoformers.Tablero;
import fiuba.algo3.algoformers.Juego;

import fiuba.algo3.algoformers.CasilleroOcupadoException;

public class AlgoFormerPrimerTests {

	@Test
	public void test01verificarMovimiento() {
		Tablero tab = new Tablero();

		Assert.assertTrue(tab.cantidadCasilleros() > 8);

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
		Tablero tab = new Tablero();

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
		Tablero tab = new Tablero();

		Assert.assertTrue(tab.cantidadCasilleros() > 9);

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
		Assert.assertTrue(jugadorUno.tieneAlgoFormerEnPosicion(1,3));


		Assert.assertTrue(jugadorDos.existeEscuadron());
		//TODO Posiciones.
		Assert.assertTrue(jugadorDos.tieneAlgoFormerEnPosicion(1,1));
		Assert.assertTrue(jugadorDos.tieneAlgoFormerEnPosicion(1,2));
		Assert.assertTrue(jugadorDos.tieneAlgoFormerEnPosicion(1,3));

		//FIXME esto nose como va a ser pero hay que corroborar los turnos
		jugadorUno.moverAlgoFormer();

		jugadorDos.moverAlgoFormer();

		//Exception!!!
		jugadorDos.moverAlgoFormer();
	}
  
	@Test
	public void test05modosAtaques() {
		Tablero tab = new Tablero();

		Assert.assertTrue(tab.cantidadCasilleros() == 80);

		OptimusPrime optimusPrime = new OptimusPrime("Humanoide");
		tab.addAlgoFormer(optimusPrime,1,1);

		Megatron megatron = new Megatron("Humanoide");
		tab.addAlgoFormer(megatron,2,2);

		Assert.assertTrue(megatron.vida() == 550);
		optimusPrime.atacar();
		Assert.assertTrue(megatron.vida() == 450);

		Assert.assertTrue(optimusPrime.vida() == 550);
		megatron.atacar();
		Assert.assertTrue(optimusPrime.vida() == 450);

		optimusPrime.moverDerecha();

		//Ahora esta lejos!
		Assert.assertTrue(optimusPrime.vida() == 450);
		megatron.atacar();
		Assert.assertTrue(optimusPrime.vida() == 450);
	}
}
