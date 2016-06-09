package fiuba.algo3.algoformers;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.algoformers.AlgoFormer;
import fiuba.algo3.algoformers.Escuadron;
import fiuba.algo3.algoformers.personajes.Megatron;
import fiuba.algo3.algoformers.personajes.Ratchet;
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

		for (int i=0; i< escuadronUno.cantidadMiembrosEscuadron(); i++) {
			escuadronUno.getAlgoFormer(i).transformarAlterno();
			escuadronUno.getAlgoFormer(i).moverDerecha();
		}

		Assert.assertTrue(tab.existeAlgoFormer(escuadronUno.getAlgoFormer(0), 5, 5));
		Assert.assertTrue(tab.existeAlgoFormer(escuadronUno.getAlgoFormer(1), 6, 5));
		Assert.assertTrue(tab.existeAlgoFormer(escuadronUno.getAlgoFormer(2), 5, 6));

		for (AlgoFormer eachAlgoFormer :
				escuadronUno.algoFormers) {
			eachAlgoFormer.moverDerecha();
		}

		Assert.assertTrue(tab.existeAlgoFormer(escuadronDos.getAlgoFormer(0), 15, 15));
		Assert.assertTrue(tab.existeAlgoFormer(escuadronDos.getAlgoFormer(1), 14, 15));
		Assert.assertTrue(tab.existeAlgoFormer(escuadronDos.getAlgoFormer(2), 15, 14));
	}

	@Test
	public void test02verificarMovimientoZonaPantanosaModoHumanoide() {

		Tablero tab = new Tablero(20, 20);
		Pantano pantano = new Pantano();

		tab.setTodoTerrenoTerrestre(pantano);

		OptimusPrime optimusPrime = new OptimusPrime();
		Posicion posicion = new Posicion(1, 1);

		tab.agregarAlgoFormer(optimusPrime, posicion);

		Posicion posicionRelativa = new Posicion(2, 2);

		Assert.assertFalse(tab.existeAlgoFormer(optimusPrime, 2, 2));
		Assert.assertTrue(tab.existeAlgoFormer(optimusPrime, 1, 1));

	}

	@Test
	public void test03verificarMovimientoZonaPantanosaModoAlterno() {

		Tablero tab = new Tablero(20, 20);
		Pantano pantano = new Pantano();

		tab.setTodoTerrenoTerrestre(pantano);

		OptimusPrime optimusPrime = new OptimusPrime();
		Posicion posicion = new Posicion(1, 1);

		tab.agregarAlgoFormer(optimusPrime, posicion);

		Posicion posicionRelativa = new Posicion(3, 3);

		optimusPrime.transformarAlterno();
		optimusPrime.moverDerecha();

		Assert.assertFalse(tab.existeAlgoFormer(optimusPrime, 1, 1));
		Assert.assertTrue(tab.existeAlgoFormer(optimusPrime, 2, 2));


		//Faltaria acomodar este test bien segun el mover para que tarde el doble por zona pantanosa

	}


	@Test
	public void test05verificarTerrestreZonaEspinas() {
		Espinas espinas = new Espinas();

		EscuadronAutobot escuadronUno = new EscuadronAutobot();

		Posicion posicionRelativa = new Posicion(1, 0);

		Tablero tab = new Tablero(10, 10);
		tab.setTodoTerrenoTerrestre(espinas);
		tab.agregarEscuadron(escuadronUno);

		int cantidadAlgoFormers = escuadronUno.cantidadMiembrosEscuadron();

		for(int i = 0; i < cantidadAlgoFormers; i++){
			AlgoFormer unAlgoFormer = escuadronUno.getAlgoFormer(i);
			int inicialVida = unAlgoFormer.getVida();
			unAlgoFormer.moverDerecha(posicionRelativa);
			int finalVida = unAlgoFormer.getVida();
			int porcentaje = (inicialVida - finalVida)*100/inicialVida; //El orden de los Factores no altera el producto
			Assert.assertTrue(porcentaje == espinas.getPenalizacionVida());
		}
	}

	@Test
	public void test06verificarAereoZonaEspinas() {
		Espinas espinas = new Espinas();

		Posicion posicionRelativa = new Posicion(1, 0);

		Ratchet ratchet = new Ratchet();
		ratchet.transformarAlterno();

		Megatron megatron = new Megatron();
		megatron.transformarAlterno();

		Escuadron escuadronUno = new Escuadron();
		escuadronUno.agregarAlgoFormer(ratchet);
		escuadronUno.agregarAlgoFormer(megatron);

		Tablero tab = new Tablero(10, 10);
		tab.setTodoTerrenoTerrestre(espinas);
		tab.agregarEscuadron(escuadronUno);

		int cantidadAlgoFormers = escuadronUno.cantidadMiembrosEscuadron();

		for(int i = 0; i < cantidadAlgoFormers; i++){
			AlgoFormer unAlgoFormer = escuadronUno.getAlgoFormer(i);
			int inicialVida = unAlgoFormer.getVida();
			unAlgoFormer.moverDerecha(posicionRelativa);
			int finalVida = unAlgoFormer.getVida();
			Assert.assertTrue(inicialVida == finalVida);
		}
	}

	@Test
	public void test07verificarAereoZonaNubes() {
		Nube nube = new Nube();

		Posicion posicionRelativa = new Posicion(1, 0);

		Ratchet ratchet = new Ratchet();
		ratchet.transformarAlterno();

		Megatron megatron = new Megatron();
		megatron.transformarAlterno();

		Escuadron escuadronUno = new Escuadron();
		escuadronUno.agregarAlgoFormer(ratchet);
		escuadronUno.agregarAlgoFormer(megatron);

		Tablero tab = new Tablero(10, 10);
		tab.setTodoTerrenoAereo(nube);
		tab.agregarEscuadron(escuadronUno);

		int cantidadAlgoFormers = escuadronUno.cantidadMiembrosEscuadron();

		for(int i = 0; i < cantidadAlgoFormers; i++){
			AlgoFormer unAlgoFormer = escuadronUno.getAlgoFormer(i);
			int inicialVida = unAlgoFormer.getVida();
			unAlgoFormer.moverDerecha();
			int finalVida = unAlgoFormer.getVida();
			Assert.assertTrue(inicialVida == finalVida);
			Assert.assertTrue(tab.existeAlgoFormer(unAlgoFormer, 2+i, 1));
		}
	}

	@Test
	public void test08verificarAereoZonaNebulosaAndromeda() {
		NebulosaAndromeda nebulosaAndromeda = new NebulosaAndromeda();

		Posicion posicionRelativa = new Posicion(1, 0);

		Ratchet ratchet = new Ratchet();
		ratchet.transformarAlterno();

		Megatron megatron = new Megatron();
		megatron.transformarAlterno();

		Escuadron escuadronUno = new Escuadron();
		escuadronUno.agregarAlgoFormer(ratchet);
		escuadronUno.agregarAlgoFormer(megatron);

		Tablero tab = new Tablero(10, 10);
		tab.setTodoTerrenoAereo(nebulosaAndromeda);
		tab.agregarEscuadron(escuadronUno);

		int cantidadAlgoFormers = escuadronUno.cantidadMiembrosEscuadron();

		for(int i = 0; i < cantidadAlgoFormers; i++){
			AlgoFormer unAlgoFormer = escuadronUno.getAlgoFormer(i);
			unAlgoFormer.moverDerecha();
			Assert.assertTrue(tab.existeAlgoFormer(unAlgoFormer, 2+i, 1));
			int cantidadTurnosPenalizacion = nebulosaAndromeda.getPenalizacionTurnos();
			for(int j = 0; j < cantidadTurnosPenalizacion; j++){
				unAlgoFormer.moverDerecha();
				Assert.assertTrue(tab.existeAlgoFormer(unAlgoFormer, 2+i, 1)); //No se movio
			}
		}
	}

	@Test
	public void test09verificarAereoZonaTormentaPsionica() {
		TormentaPsionica tormentaPsionica = new TormentaPsionica();

		Posicion posicionRelativa = new Posicion(1, 0);

		Ratchet ratchet = new Ratchet();
		ratchet.transformarAlterno();

		Megatron megatron = new Megatron();
		megatron.transformarAlterno();

		Escuadron escuadronUno = new Escuadron();
		escuadronUno.agregarAlgoFormer(ratchet);
		escuadronUno.agregarAlgoFormer(megatron);

		Tablero tab = new Tablero(10, 10);
		tab.setTodoTerrenoAereo(tormentaPsionica);
		tab.agregarEscuadron(escuadronUno);

		int cantidadAlgoFormers = escuadronUno.cantidadMiembrosEscuadron();

		for(int i = 0; i < cantidadAlgoFormers; i++){
			AlgoFormer unAlgoFormer = escuadronUno.getAlgoFormer(i);
			int inicialFuerzaAtaque = unAlgoFormer.getFuerzaAtaque();
			unAlgoFormer.moverDerecha();
			int finalFuerzaAtaque = unAlgoFormer.getFuerzaAtaque();
			Assert.assertTrue((inicialFuerzaAtaque - finalFuerzaAtaque) == tormentaPsionica.getPenalizacionAtaque());
		}
	}

	@Test
	public void test10verificarAereoSegundaVezZonaTormentaPsionica() {
		TormentaPsionica tormentaPsionica = new TormentaPsionica();

		Posicion posicionRelativa = new Posicion(1, 0);

		Ratchet ratchet = new Ratchet();
		ratchet.transformarAlterno();

		Megatron megatron = new Megatron();
		megatron.transformarAlterno();

		Escuadron escuadronUno = new Escuadron();
		escuadronUno.agregarAlgoFormer(ratchet);
		escuadronUno.agregarAlgoFormer(megatron);

		Tablero tab = new Tablero(10, 10);
		tab.setTodoTerrenoAereo(tormentaPsionica);
		tab.agregarEscuadron(escuadronUno);

		int cantidadAlgoFormers = escuadronUno.cantidadMiembrosEscuadron();

		for(int i = 0; i < cantidadAlgoFormers; i++){
			AlgoFormer unAlgoFormer = escuadronUno.getAlgoFormer(i);
			int inicialFuerzaAtaque = unAlgoFormer.getFuerzaAtaque();
			unAlgoFormer.moverDerecha(); //Pasa dos veces por una TormentaPsionica
			unAlgoFormer.moverDerecha();
			int finalFuerzaAtaque = unAlgoFormer.getFuerzaAtaque();
			Assert.assertTrue((inicialFuerzaAtaque - finalFuerzaAtaque) == tormentaPsionica.getPenalizacionAtaque());
		}
	}
}
