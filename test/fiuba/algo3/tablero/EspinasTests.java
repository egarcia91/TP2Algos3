package fiuba.algo3.tablero;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.tablero.Espinas;

public class EspinasTests {
	@Test
	public void test01CrearEspinas() {
		Espinas espinas = new Espinas();

		Assert.assertTrue(espinas.getNombre() == "Espinas");
	}

	@Test
	public void test02VelocidadEspinas() {
		Espinas espinas = new Espinas();

		Assert.assertTrue(espinas.getVelocidad() == 1);
	}

	@Test
	public void test03EspinasTienePenalizacion() {
		Espinas espinas = new Espinas();

		Assert.assertTrue(espinas.tienePenalizacion());

		Assert.assertTrue(espinas.getPenalizacionVida() == 5);
	}

}
