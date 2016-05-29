package fiuba.algo3.algoformers;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.algoformers.Casillero;
import fiuba.algo3.algoformers.AlgoFormer;
import fiuba.algo3.algoformers.OptimusPrime;
import fiuba.algo3.algoformers.Megatron;
import fiuba.algo3.algoformers.Spark;
import fiuba.algo3.algoformers.CasilleroOcupadoException;

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
		Assert.assertTrue(casillero.existeContenido(spark));
	}

	@Test
	public void test03CasilleroAgregarAlgoFormer() {
		AlgoFormer algoFormer = new AlgoFormer();

		Casillero casillero = new Casillero();
		casillero.agregarAlgoFormer(algoFormer);

		Assert.assertFalse(casillero.estaVacio());
		Assert.assertTrue(casillero.existeAlgoFormer(algoFormer));
	}


	@Test
	public void test04CasilleroSuperponerSpark() {
		AlgoFormer algoFormer = new AlgoFormer();

		Spark spark = new Spark();

		Casillero casillero = new Casillero();
		casillero.agregarContenido(spark);

		Assert.assertFalse(casillero.estaVacio());
		Assert.assertFalse(casillero.existeAlgoFormer(algoFormer));
		Assert.assertTrue(casillero.existeContenido(spark));

		casillero.agregarAlgoFormer(algoFormer);
		Assert.assertFalse(casillero.estaVacio());
		Assert.assertTrue(casillero.existeAlgoFormer(algoFormer));
		Assert.assertFalse(casillero.existeContenido(spark));
	}

	@Test(expected=CasilleroOcupadoException.class)
	public void test05CasilleroNoSuperponerAlgoFormers() {
		OptimusPrime optimusPrime = new OptimusPrime("Humanoide");

		Megatron megatron = new Megatron("Humanoide");

		Casillero casillero = new Casillero();
		casillero.agregarAlgoFormer(optimusPrime);

		Assert.assertFalse(casillero.estaVacio());
		Assert.assertTrue(casillero.existeAlgoFormer(optimusPrime));

		casillero.agregarAlgoFormer(megatron);
	}

	@Test
	public void test06CasilleroQuitarAlgoFormer() {

		AlgoFormer algoFormer = new AlgoFormer();
		Casillero casillero = new Casillero();

		casillero.agregarAlgoFormer(algoFormer);
		Assert.assertFalse(casillero.estaVacio());
		Assert.assertTrue(casillero.existeAlgoFormer(algoFormer));

		casillero.quitarAlgoFormer();
		Assert.assertTrue(casillero.estaVacio());
		Assert.assertFalse(casillero.existeAlgoFormer(algoFormer));
	}

}
