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

		/*OptimusPrime optimusPrime = new OptimusPrime();
		Escuadron escuadronUno = new Escuadron();
		escuadronUno.agregarAlgoFormer(algoFormer);*/
		EscuadronAutobot escuadronUno = new EscuadronAutobot();
		Assert.assertTrue(escuadronUno.cantidadMiembrosEscuadron() == 3);
		tab.agregarEscuadron(escuadronUno);
		EscuadronDecepticon escuadronDos = new EscuadronDecepticon();
		Assert.assertTrue(escuadronDos.cantidadMiembrosEscuadron() == 3);
		//tab.agregarEscuadron(escuadronDos);

		Assert.assertTrue(tab.existeAlgoFormer(escuadronUno.getAlgoFormer(0), 1, 1));
		Assert.assertTrue(tab.existeAlgoFormer(escuadronUno.getAlgoFormer(1), 2, 1));
		Assert.assertTrue(tab.existeAlgoFormer(escuadronUno.getAlgoFormer(2), 1, 2));

		Posicion posicionRelativa = new Posicion(3, 3);

		for (AlgoFormer eachAlgoFormer :
				escuadronUno.algoFormers) {
			eachAlgoFormer.transformarAlterno();
			eachAlgoFormer.mover(posicionRelativa);
		}

		Assert.assertTrue(tab.existeAlgoFormer(escuadronUno.getAlgoFormer(0), 4, 4));
		Assert.assertTrue(tab.existeAlgoFormer(escuadronUno.getAlgoFormer(1), 5, 4));
		Assert.assertTrue(tab.existeAlgoFormer(escuadronUno.getAlgoFormer(2), 4, 5));

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
			unAlgoFormer.mover(posicionRelativa);
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
			unAlgoFormer.mover(posicionRelativa);
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
			unAlgoFormer.mover(posicionRelativa);
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
			unAlgoFormer.mover(posicionRelativa);
			Assert.assertTrue(tab.existeAlgoFormer(unAlgoFormer, 2+i, 1));
			int cantidadTurnosPenalizacion = nebulosaAndromeda.getPenalizacionTurnos();
			for(int j = 0; j < cantidadTurnosPenalizacion; j++){
				unAlgoFormer.mover(posicionRelativa);
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
			unAlgoFormer.mover(posicionRelativa);
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
			unAlgoFormer.mover(posicionRelativa); //Pasa dos veces por una TormentaPsionica
			unAlgoFormer.mover(posicionRelativa);
			int finalFuerzaAtaque = unAlgoFormer.getFuerzaAtaque();
			Assert.assertTrue((inicialFuerzaAtaque - finalFuerzaAtaque) == tormentaPsionica.getPenalizacionAtaque());
		}
	}

}
