package fiuba.algo3.tablero;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.tablero.TormentaPsionica;

public class TormentaPsionicaTests {
	@Test
	public void test01CrearTormentaPsionica() {
		TormentaPsionica tormentaPsionica = new TormentaPsionica();

		Assert.assertTrue(tormentaPsionica.getNombre() == "TormentaPsionica");
	}

	@Test
	public void test02VelocidadTormentaPsionica() {
		TormentaPsionica tormentaPsionica = new TormentaPsionica();

		Assert.assertTrue(tormentaPsionica.getVelocidad() == 1);
	}

	@Test
	public void test03TormentaPsionicaTienePenalizacion() {
		TormentaPsionica tormentaPsionica = new TormentaPsionica();

		Assert.assertTrue(tormentaPsionica.tienePenalizacion());

		Assert.assertTrue(tormentaPsionica.getPenalizacionAtaque() == 40);
	}

}
