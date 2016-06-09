package fiuba.algo3.tablero;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.tablero.Rocosa;

public class RocosaTests {
	@Test
	public void test01CrearRocosa() {
		Rocosa rocosa = new Rocosa();

		Assert.assertTrue(rocosa.getNombre() == "Rocosa");
	}

	@Test
	public void test02VelocidadRocosa() {
		Rocosa rocosa = new Rocosa();

		Assert.assertTrue(rocosa.getVelocidad() == 1);
	}

	@Test
	public void test03RocosaTienePenalizacion() {
		Rocosa rocosa = new Rocosa();

		Assert.assertFalse(rocosa.tienePenalizacion());
	}

}
