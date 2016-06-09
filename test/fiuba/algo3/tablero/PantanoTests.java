package fiuba.algo3.tablero;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.tablero.Pantano;

public class PantanoTests {
	@Test
	public void test01CrearPantano() {
		Pantano pantano = new Pantano();

		Assert.assertTrue(pantano.getNombre() == "Pantano");
	}

	@Test
	public void test02VelocidadPantano() {
		Pantano pantano = new Pantano();

		Assert.assertTrue(pantano.getVelocidad() == 2);
	}

	@Test
	public void test03PantanoTienePenalizacion() {
		Pantano pantano = new Pantano();

		Assert.assertFalse(pantano.tienePenalizacion());
	}

}
