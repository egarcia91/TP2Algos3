package fiuba.algo3.algoformers.personajes;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.algoformers.personajes.Bonecrusher;

public class BonecrusherTests {
	private int vidaHumanoide = 200;
	private int fuerzaAtaqueHumanoide = 30;
	private int distanciaAtaqueHumanoide = 3;
	private int velocidadHumanoide = 1;
	private String unidadHumanoide = "terrestre";

	private int vidaAlterno = 200;
	private int fuerzaAtaqueAlterno = 30;
	private int distanciaAtaqueAlterno = 3;
	private int velocidadAlterno = 8;
	private String unidadAlterno = "terrestre";

	@Test
	public void test01CrearBonecrusher() {
		Bonecrusher bonecrusher = new Bonecrusher();

		Assert.assertTrue(bonecrusher.getNombre() == "Bonecrusher");
	}

	@Test
	public void test02BonecrusherHumanoide() {
		Bonecrusher bonecrusher = new Bonecrusher();
		Assert.assertTrue(bonecrusher.getVida() == vidaHumanoide);
		Assert.assertTrue(bonecrusher.getFuerzaAtaque() == fuerzaAtaqueHumanoide);
		Assert.assertTrue(bonecrusher.getDistanciaAtaque() == distanciaAtaqueHumanoide);
		Assert.assertTrue(bonecrusher.getVelocidad() == velocidadHumanoide);
		Assert.assertTrue(bonecrusher.getTipoUnidad() == unidadHumanoide);
	}

	@Test
	public void test03BonecrusherAlterno() {
		Bonecrusher bonecrusher = new Bonecrusher();
		bonecrusher.transformarAlterno();
		Assert.assertTrue(bonecrusher.getVida() == vidaAlterno);
		Assert.assertTrue(bonecrusher.getFuerzaAtaque() == fuerzaAtaqueAlterno);
		Assert.assertTrue(bonecrusher.getDistanciaAtaque() == distanciaAtaqueAlterno);
		Assert.assertTrue(bonecrusher.getVelocidad() == velocidadAlterno);
		Assert.assertTrue(bonecrusher.getTipoUnidad() == unidadAlterno);
	}

	@Test
	public void test04BonecrusherTransformHumanoideAlterno() {
		Bonecrusher bonecrusher = new Bonecrusher();
		bonecrusher.transformarAlterno();
		Assert.assertTrue(bonecrusher.getVida() == vidaAlterno);
		Assert.assertTrue(bonecrusher.getFuerzaAtaque() == fuerzaAtaqueAlterno);
		Assert.assertTrue(bonecrusher.getDistanciaAtaque() == distanciaAtaqueAlterno);
		Assert.assertTrue(bonecrusher.getVelocidad() == velocidadAlterno);
		Assert.assertTrue(bonecrusher.getTipoUnidad() == unidadAlterno);
	}

	@Test
	public void test05BonecrusherTransformAlternoHumanoide() {
		Bonecrusher bonecrusher = new Bonecrusher();
		bonecrusher.transformarAlterno();
		bonecrusher.transformarHumanoide();
		Assert.assertTrue(bonecrusher.getVida() == vidaHumanoide);
		Assert.assertTrue(bonecrusher.getFuerzaAtaque() == fuerzaAtaqueHumanoide);
		Assert.assertTrue(bonecrusher.getDistanciaAtaque() == distanciaAtaqueHumanoide);
		Assert.assertTrue(bonecrusher.getVelocidad() == velocidadHumanoide);
		Assert.assertTrue(bonecrusher.getTipoUnidad() == unidadHumanoide);
	}
}
