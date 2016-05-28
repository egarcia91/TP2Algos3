package fiuba.algo3.algoformer;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.algoformer.Ratchet;

public class RatchetTests {
	private int vidaHumanoide = 150;
	private int fuerzaAtaqueHumanoide = 5;
	private int distanciaAtaqueHumanoide = 5;
	private int velocidadHumanoide = 1;
	private int unidadHumanoide = "terrestre";

	private int vidaAlterno = 150;
	private int fuerzaAtaqueAlterno = 35;
	private int distanciaAtaqueAlterno = 2;
	private int velocidadAlterno = 8;
	private int unidadAlterno = "aerea";

	@Test
	public void test01CrearRatchet() {
		Ratchet ratchet = new Ratchet();

		Assert.assertTrue(ratchet.getNombre() == "Ratchet");
	}

	@Test
	public void test02RatchetHumanoide() {
		Ratchet ratchet = new Ratchet();
		Assert.assertTrue(ratchet.vida() == vidaHumanoide);
		Assert.assertTrue(ratchet.fuerzaAtaque() == fuerzaAtaqueHumanoide);
		Assert.assertTrue(ratchet.distanciaAtaque() == distanciaAtaqueHumanoide);
		Assert.assertTrue(ratchet.velocidad() == velocidadHumanoide);
		Assert.assertTrue(ratchet.tipoUnidad() == unidadHumanoide);
	}

	@Test
	public void test03RatchetAlterno() {
		Ratchet ratchet = new Ratchet("Alterno");
		Assert.assertTrue(ratchet.vida() == vidaAlterno);
		Assert.assertTrue(ratchet.fuerzaAtaque() == fuerzaAtaqueAlterno);
		Assert.assertTrue(ratchet.distanciaAtaque() == distanciaAtaqueAlterno);
		Assert.assertTrue(ratchet.velocidad() == velocidadAlterno);
		Assert.assertTrue(ratchet.tipoUnidad() == unidadAlterno);
	}

	@Test
	public void test04RatchetTransformHumanoideAlterno() {
		Ratchet ratchet = new Ratchet();
		ratchet.transformarAlterno();
		Assert.assertTrue(ratchet.vida() == vidaAlterno);
		Assert.assertTrue(ratchet.fuerzaAtaque() == fuerzaAtaqueAlterno);
		Assert.assertTrue(ratchet.distanciaAtaque() == distanciaAtaqueAlterno);
		Assert.assertTrue(ratchet.velocidad() == velocidadAlterno);
		Assert.assertTrue(ratchet.tipoUnidad() == unidadAlterno);
	}

	@Test
	public void test05RatchetTransformAlternoHumanoide() {
		Ratchet ratchet = new Ratchet("Alterno");
		ratchet.transformarHumaniode();
		Assert.assertTrue(ratchet.vida() == vidaHumanoide);
		Assert.assertTrue(ratchet.fuerzaAtaque() == fuerzaAtaqueHumanoide);
		Assert.assertTrue(ratchet.distanciaAtaque() == distanciaAtaqueHumanoide);
		Assert.assertTrue(ratchet.velocidad() == velocidadHumanoide);
		Assert.assertTrue(ratchet.tipoUnidad() == unidadHumanoide);
	}
}
