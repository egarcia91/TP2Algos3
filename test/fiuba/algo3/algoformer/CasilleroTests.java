package fiuba.algo3.algoformer;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.algoformer.Casillero;
import fiuba.algo3.algoformer.AlgoFormer;
import fiuba.algo3.algoformer.Spark;
import fiuba.algo3.algoformer.CasilleroOcupadoException;

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
		AlgoFormer algoFormer = new AlgoFormer();

		AlgoFormer otroAlgoFormer = new AlgoFormer();

		Casillero casillero = new Casillero();
		casillero.agregarAlgoFormer(algoFormer);

		Assert.assertFalse(casillero.estaVacio());
		Assert.assertTrue(casillero.existeAlgoFormer(algoFormer));

		casillero.agregarAlgoFormer(otroAlgoFormer);
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
