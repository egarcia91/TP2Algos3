package fiuba.algo3.tablero;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.tablero.Nube;

public class NubeTests {
	@Test
	public void test01CrearNube() {
		Nube nube = new Nube();

		Assert.assertTrue(nube.getNombre() == "Nube");
	}

	@Test
	public void test02VelocidadNube() {
		Nube nube = new Nube();

		Assert.assertTrue(nube.getVelocidad() == 1);
	}

	@Test
	public void test03NubeTienePenalizacion() {
		Nube nube = new Nube();

		Assert.assertFalse(nube.tienePenalizacion());
	}

}
