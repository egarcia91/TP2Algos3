package fiuba.algo3.algoformers;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.algoformers.Bonecrusher;

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
		Bonecrusher bonecrusher = new Bonecrusher("Humanoide");

		Assert.assertTrue(bonecrusher.getNombre() == "Bonecrusher");
	}

	@Test
	public void test02BonecrusherHumanoide() {
		Bonecrusher bonecrusher = new Bonecrusher("Humanoide");
		Assert.assertTrue(bonecrusher.vida() == vidaHumanoide);
		Assert.assertTrue(bonecrusher.fuerzaAtaque() == fuerzaAtaqueHumanoide);
		Assert.assertTrue(bonecrusher.distanciaAtaque() == distanciaAtaqueHumanoide);
		Assert.assertTrue(bonecrusher.velocidad() == velocidadHumanoide);
		Assert.assertTrue(bonecrusher.tipoUnidad() == unidadHumanoide);
	}

	@Test
	public void test03BonecrusherAlterno() {
		Bonecrusher bonecrusher = new Bonecrusher("Alterno");
		Assert.assertTrue(bonecrusher.vida() == vidaAlterno);
		Assert.assertTrue(bonecrusher.fuerzaAtaque() == fuerzaAtaqueAlterno);
		Assert.assertTrue(bonecrusher.distanciaAtaque() == distanciaAtaqueAlterno);
		Assert.assertTrue(bonecrusher.velocidad() == velocidadAlterno);
		Assert.assertTrue(bonecrusher.tipoUnidad() == unidadAlterno);
	}

	@Test
	public void test04BonecrusherTransformHumanoideAlterno() {
		Bonecrusher bonecrusher = new Bonecrusher("Humanoide");
		bonecrusher.transformarAlterno();
		Assert.assertTrue(bonecrusher.vida() == vidaAlterno);
		Assert.assertTrue(bonecrusher.fuerzaAtaque() == fuerzaAtaqueAlterno);
		Assert.assertTrue(bonecrusher.distanciaAtaque() == distanciaAtaqueAlterno);
		Assert.assertTrue(bonecrusher.velocidad() == velocidadAlterno);
		Assert.assertTrue(bonecrusher.tipoUnidad() == unidadAlterno);
	}

	@Test
	public void test05BonecrusherTransformAlternoHumanoide() {
		Bonecrusher bonecrusher = new Bonecrusher("Alterno");
		bonecrusher.transformarHumanoide();
		Assert.assertTrue(bonecrusher.vida() == vidaHumanoide);
		Assert.assertTrue(bonecrusher.fuerzaAtaque() == fuerzaAtaqueHumanoide);
		Assert.assertTrue(bonecrusher.distanciaAtaque() == distanciaAtaqueHumanoide);
		Assert.assertTrue(bonecrusher.velocidad() == velocidadHumanoide);
		Assert.assertTrue(bonecrusher.tipoUnidad() == unidadHumanoide);
	}
}
