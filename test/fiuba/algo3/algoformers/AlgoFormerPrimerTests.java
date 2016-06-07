package fiuba.algo3.algoformers;

import java.util.ArrayList;
import java.util.List;

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
		//List<AlgoFormer> escuadronUno = new ArrayList<AlgoFormer>();
		Escuadron escuadronUno = new Escuadron();
		escuadronUno.algoFormers.add(algoFormer);

		tab.agregarEscuadron(escuadronUno);

		Assert.assertTrue(tab.existeAlgoFormer(algoFormer,1,1));

		algoFormer.moverDerecha();
		Assert.assertFalse(tab.existeAlgoFormer(algoFormer,3,1));
	}
	
	@Test
	public void test02verificarTransformacion() {
		Tablero tab = new Tablero(20,20);

		AlgoFormer algoFormer = new AlgoFormer();
		//List<AlgoFormer> escuadronUno = new ArrayList<AlgoFormer>();
		Escuadron escuadronUno = new Escuadron();
		escuadronUno.algoFormers.add(algoFormer);

		tab.agregarEscuadron(escuadronUno);

		Assert.assertTrue(algoFormer.getEstado().getClass() == Humanoide.class);

		algoFormer.transformarAlterno();

		Assert.assertFalse(algoFormer.getEstado().getClass() == Humanoide.class);
		Assert.assertTrue(algoFormer.getEstado().getClass() == Alterno.class);

		algoFormer.transformarHumanoide();

		Assert.assertTrue(algoFormer.getEstado().getClass() == Humanoide.class);
		Assert.assertFalse(algoFormer.getEstado().getClass() == Alterno.class);
	}

	@Test
	public void test03verificarMovimientoAlterno() {
		Tablero tab = new Tablero(20,20);

		AlgoFormer algoFormer = new AlgoFormer();
		algoFormer.transformarAlterno();
		//List<AlgoFormer> escuadronUno = new ArrayList<AlgoFormer>();
		Escuadron escuadronUno = new Escuadron();
		escuadronUno.algoFormers.add(algoFormer);

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

		juego.agregarJugadorUno(jugadorUno);
		Assert.assertTrue(juego.existeJugador(jugadorUno));
		juego.agregarJugadorDos(jugadorDos);
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

		//List<AlgoFormer> escuadronUno = new ArrayList<AlgoFormer>();
		//List<AlgoFormer> escuadronDos = new ArrayList<AlgoFormer>();

		Escuadron escuadronUno = new Escuadron();
		Escuadron escuadronDos = new Escuadron();


		OptimusPrime optimusPrime = new OptimusPrime();
		optimusPrime.transformarAlterno();
		//escuadronUno.add(optimusPrime);
		escuadronUno.algoFormers.add(optimusPrime);


		Megatron megatron = new Megatron();
		//escuadronDos.add(megatron);
		escuadronDos.algoFormers.add(megatron);

		tab.agregarEscuadron(escuadronUno);
		tab.agregarEscuadron(escuadronDos);

		Assert.assertTrue(megatron.getVida() == 550);

		optimusPrime.moverDerecha();
		optimusPrime.moverDerecha();
		optimusPrime.moverDerecha();

		optimusPrime.moverArriba();
		optimusPrime.moverArriba();
		optimusPrime.moverArriba();

		optimusPrime.atacar();
		Assert.assertTrue(megatron.getVida() == 535);

		Assert.assertTrue(optimusPrime.getVida() == 500);

		megatron.moverIzquierda();
		megatron.moverIzquierda();
		megatron.moverIzquierda();

		megatron.moverAbajo();
		megatron.moverAbajo();
		megatron.moverAbajo();

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
