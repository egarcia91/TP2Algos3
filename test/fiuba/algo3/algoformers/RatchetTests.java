package fiuba.algo3.algoformers;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.algoformers.Ratchet;

public class RatchetTests {
	private int vidaHumanoide = 150;
	private int fuerzaAtaqueHumanoide = 5;
	private int distanciaAtaqueHumanoide = 5;
	private int velocidadHumanoide = 1;
	private String unidadHumanoide = "terrestre";

	private int vidaAlterno = 150;
	private int fuerzaAtaqueAlterno = 35;
	private int distanciaAtaqueAlterno = 2;
	private int velocidadAlterno = 8;
	private String unidadAlterno = "aerea";

	@Test
	public void test01CrearRatchet() {
		Ratchet ratchet = new Ratchet("Humanoide");

		Assert.assertTrue(ratchet.getNombre() == "Ratchet");
	}

	@Test
	public void test02RatchetHumanoide() {
		Ratchet ratchet = new Ratchet("Humanoide");
		Assert.assertTrue(ratchet.getVida() == vidaHumanoide);
		Assert.assertTrue(ratchet.getFuerzaAtaque() == fuerzaAtaqueHumanoide);
		Assert.assertTrue(ratchet.getDistanciaAtaque() == distanciaAtaqueHumanoide);
		Assert.assertTrue(ratchet.getVelocidad() == velocidadHumanoide);
		Assert.assertTrue(ratchet.tipoUnidad() == unidadHumanoide);
	}

	@Test
	public void test03RatchetAlterno() {
		Ratchet ratchet = new Ratchet("Alterno");
		Assert.assertTrue(ratchet.getVida() == vidaAlterno);
		Assert.assertTrue(ratchet.getFuerzaAtaque() == fuerzaAtaqueAlterno);
		Assert.assertTrue(ratchet.getDistanciaAtaque() == distanciaAtaqueAlterno);
		Assert.assertTrue(ratchet.getVelocidad() == velocidadAlterno);
		Assert.assertTrue(ratchet.tipoUnidad() == unidadAlterno);
	}

	@Test
	public void test04RatchetTransformHumanoideAlterno() {
		Ratchet ratchet = new Ratchet("Humanoide");
		ratchet.transformarAlterno();
		Assert.assertTrue(ratchet.getVida() == vidaAlterno);
		Assert.assertTrue(ratchet.getFuerzaAtaque() == fuerzaAtaqueAlterno);
		Assert.assertTrue(ratchet.getDistanciaAtaque() == distanciaAtaqueAlterno);
		Assert.assertTrue(ratchet.getVelocidad() == velocidadAlterno);
		Assert.assertTrue(ratchet.tipoUnidad() == unidadAlterno);
	}

	@Test
	public void test05RatchetTransformAlternoHumanoide() {
		Ratchet ratchet = new Ratchet("Alterno");
		ratchet.transformarHumanoide();
		Assert.assertTrue(ratchet.getVida() == vidaHumanoide);
		Assert.assertTrue(ratchet.getFuerzaAtaque() == fuerzaAtaqueHumanoide);
		Assert.assertTrue(ratchet.getDistanciaAtaque() == distanciaAtaqueHumanoide);
		Assert.assertTrue(ratchet.getVelocidad() == velocidadHumanoide);
		Assert.assertTrue(ratchet.tipoUnidad() == unidadHumanoide);
	}
}
