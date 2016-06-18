package fiuba.algo3.tablero;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.algoformers.AlgoFormer;
import fiuba.algo3.algoformers.personajes.Megatron;
import fiuba.algo3.algoformers.personajes.OptimusPrime;
import fiuba.algo3.tablero.Casillero;
import fiuba.algo3.tablero.CasilleroOcupadoException;

public class CasilleroTests {

	@Test
	public void test01CasilleroVacio() {
		Casillero casillero = new Casillero();

		Assert.assertTrue(casillero.estaVacio());
	}

	@Test
	public void test02CasilleroAgregarContenido() {
		Spark spark = new Spark();

		Casillero casillero = new Casillero();
		casillero.agregarContenido(spark);

		Assert.assertFalse(casillero.estaVacio());
		Assert.assertTrue(casillero.getContenido() == spark);
	}

	@Test
	public void test03CasilleroAgregarAlgoFormer() {
		AlgoFormer algoFormer = new AlgoFormer();

		Casillero casillero = new Casillero();
		casillero.agregarContenido(algoFormer);

		Assert.assertFalse(casillero.estaVacio());
		Assert.assertTrue(casillero.getContenido() == algoFormer);
	}

	@Test
	public void test04CasilleroSuperponerSpark() {
		AlgoFormer algoFormer = new AlgoFormer();

		Spark spark = new Spark();

		Casillero casillero = new Casillero();
		casillero.agregarContenido(spark);

		Assert.assertFalse(casillero.estaVacio());
		Assert.assertTrue(casillero.getContenido() == spark);

		casillero.agregarContenido(algoFormer);
		Assert.assertFalse(casillero.estaVacio());
		Assert.assertTrue(casillero.getContenido() == algoFormer);
	}

	@Test(expected=CasilleroOcupadoException.class)
	public void test05CasilleroNoSuperponerAlgoFormers() {
		OptimusPrime optimusPrime = new OptimusPrime();

		Megatron megatron = new Megatron();

		Casillero casillero = new Casillero();
		casillero.agregarContenido(optimusPrime);

		Assert.assertFalse(casillero.estaVacio());
		Assert.assertTrue(casillero.getContenido() == optimusPrime);

		casillero.agregarContenido(megatron);
	}

	@Test
	public void test06CasilleroQuitarAlgoFormer() {

		AlgoFormer algoFormer = new AlgoFormer();
		Casillero casillero = new Casillero();

		casillero.agregarContenido(algoFormer);
		Assert.assertFalse(casillero.estaVacio());
		Assert.assertTrue(casillero.getContenido() == algoFormer);

		casillero.quitarContenido();
		Assert.assertTrue(casillero.estaVacio());
	}

}
