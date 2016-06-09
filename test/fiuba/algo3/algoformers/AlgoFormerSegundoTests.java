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
}