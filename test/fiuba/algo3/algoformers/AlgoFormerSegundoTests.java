package fiuba.algo3.algoformers;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.algoformers.AlgoFormer;
import fiuba.algo3.tablero.Juego;
import fiuba.algo3.tablero.Jugador;
import fiuba.algo3.tablero.Tablero;
import fiuba.algo3.algoformers.Escuadron;
import fiuba.algo3.algoformers.personajes.Megatron;
import fiuba.algo3.algoformers.personajes.OptimusPrime;
import fiuba.algo3.tablero.*;

public class AlgoFormerSegundoTests {

	@Test
	public void test01verificarMovimientoZonaRocosa() {
		Tablero tab = new Tablero(20, 20);

		EscuadronAutobot escuadronUno = new EscuadronAutobot();
		tab.agregarEscuadron(escuadronUno);

		Assert.assertTrue(tab.existeAlgoFormer(escuadronUno.getAlgoFormer(0), 1, 1));
		Assert.assertTrue(tab.existeAlgoFormer(escuadronUno.getAlgoFormer(1), 2, 1));
		Assert.assertTrue(tab.existeAlgoFormer(escuadronUno.getAlgoFormer(2), 1, 2));


		EscuadronDecepticon escuadronDos = new EscuadronDecepticon();
		tab.agregarEscuadron(escuadronDos);

		Assert.assertTrue(tab.existeAlgoFormer(escuadronDos.getAlgoFormer(0), 19, 19));
		Assert.assertTrue(tab.existeAlgoFormer(escuadronDos.getAlgoFormer(1), 18, 19));
		Assert.assertTrue(tab.existeAlgoFormer(escuadronDos.getAlgoFormer(2), 19, 18));


		Posicion posicionRelativa = new Posicion(4, 4);

		for (int i=0; i< escuadronUno.cantidadMiembrosEscuadron(); i++) {
			escuadronUno.getAlgoFormer(i).transformarAlterno();
			escuadronUno.getAlgoFormer(i).mover(posicionRelativa);
		}

		Assert.assertTrue(tab.existeAlgoFormer(escuadronUno.getAlgoFormer(0), 5, 5));
		Assert.assertTrue(tab.existeAlgoFormer(escuadronUno.getAlgoFormer(1), 6, 5));
		Assert.assertTrue(tab.existeAlgoFormer(escuadronUno.getAlgoFormer(2), 5, 6));

		Posicion posicionRelativa2 = new Posicion(-4, -4);

		for (int j=0; j< escuadronDos.cantidadMiembrosEscuadron(); j++){
			escuadronDos.getAlgoFormer(j).transformarAlterno();
			escuadronDos.getAlgoFormer(j).mover(posicionRelativa2);
		}

		Assert.assertTrue(tab.existeAlgoFormer(escuadronDos.getAlgoFormer(0), 15, 15));
		Assert.assertTrue(tab.existeAlgoFormer(escuadronDos.getAlgoFormer(1), 14, 15));
		Assert.assertTrue(tab.existeAlgoFormer(escuadronDos.getAlgoFormer(2), 15, 14));
	}

	@Test
	public void test02verificarMovimientoZonaPantanosaModoHumanoide() {

		Tablero tab = new Tablero(20, 20);
		Pantano pantano = new Pantano();

		tab.setTodoTerreno(Pantano)

		OptimusPrime optimusPrime = new OptimusPrime();
		Posicion posicion = new Posicion(1, 1);

		tab.agregarAlgoFormer(OptimusPrime, posicion);

		Posicion posicionRelativa = new Posicion(2, 2);

		optimusPrime.mover(posicionRelativa);

		Assert.assertFalse(tab.existeAlgoFormer(optimusPrime, 2, 2));
		Assert.assertTrue(tab.existeAlgoFormer(optimusPrime, 1, 1));

	}

	@Test
	public void test03verificarMovimientoZonaPantanosaModoAlterno() {

		Tablero tab = new Tablero(20, 20);
		Pantano pantano = new Pantano();

		tab.setTodoTerreno(Pantano)

		OptimusPrime optimusPrime = new OptimusPrime();
		Posicion posicion = new Posicion(1, 1);

		tab.agregarAlgoFormer(OptimusPrime, posicion);

		Posicion posicionRelativa = new Posicion(3, 3);

		optimusPrime.transformarAlterno();
		optimusPrime.mover(posicionRelativa);

		Assert.assertFalse(tab.existeAlgoFormer(optimusPrime, 1, 1));
		Assert.assertTrue(tab.existeAlgoFormer(optimusPrime, 2, 2));


		//Faltaria acomodar este test bien segun el mover para que tarde el doble por zona pantanosa


	}













}
