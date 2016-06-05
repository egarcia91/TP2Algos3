package fiuba.algo3.algoformers;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.algoformers.Frenzy;

public class FrenzyTests {
	private int vidaHumanoide = 400;
	private int fuerzaAtaqueHumanoide = 10;
	private int distanciaAtaqueHumanoide = 5;
	private int velocidadHumanoide = 2;
	private String unidadHumanoide = "terrestre";

	private int vidaAlterno = 400;
	private int fuerzaAtaqueAlterno = 25;
	private int distanciaAtaqueAlterno = 2;
	private int velocidadAlterno = 6;
	private String unidadAlterno = "terrestre";

	@Test
	public void test01CrearFrenzy() {
		Frenzy frenzy = new Frenzy();

		Assert.assertTrue(frenzy.getNombre() == "Frenzy");
	}

	@Test
	public void test02FrenzyHumanoide() {
		Frenzy frenzy = new Frenzy();
		Assert.assertTrue(frenzy.getVida() == vidaHumanoide);
		Assert.assertTrue(frenzy.getFuerzaAtaque() == fuerzaAtaqueHumanoide);
		Assert.assertTrue(frenzy.getDistanciaAtaque() == distanciaAtaqueHumanoide);
		Assert.assertTrue(frenzy.getVelocidad() == velocidadHumanoide);
		Assert.assertTrue(frenzy.tipoUnidad() == unidadHumanoide);
	}

	@Test
	public void test03FrenzyAlterno() {
		Frenzy frenzy = new Frenzy();
		frenzy.transformarAlterno();
		Assert.assertTrue(frenzy.getVida() == vidaAlterno);
		Assert.assertTrue(frenzy.getFuerzaAtaque() == fuerzaAtaqueAlterno);
		Assert.assertTrue(frenzy.getDistanciaAtaque() == distanciaAtaqueAlterno);
		Assert.assertTrue(frenzy.getVelocidad() == velocidadAlterno);
		Assert.assertTrue(frenzy.tipoUnidad() == unidadAlterno);
	}

	@Test
	public void test04FrenzyTransformHumanoideAlterno() {
		Frenzy frenzy = new Frenzy();
		frenzy.transformarAlterno();
		Assert.assertTrue(frenzy.getVida() == vidaAlterno);
		Assert.assertTrue(frenzy.getFuerzaAtaque() == fuerzaAtaqueAlterno);
		Assert.assertTrue(frenzy.getDistanciaAtaque() == distanciaAtaqueAlterno);
		Assert.assertTrue(frenzy.getVelocidad() == velocidadAlterno);
		Assert.assertTrue(frenzy.tipoUnidad() == unidadAlterno);
	}

	@Test
	public void test05FrenzyTransformAlternoHumanoide() {
		Frenzy frenzy = new Frenzy();
		frenzy.transformarAlterno();
		frenzy.transformarHumanoide();
		Assert.assertTrue(frenzy.getVida() == vidaHumanoide);
		Assert.assertTrue(frenzy.getFuerzaAtaque() == fuerzaAtaqueHumanoide);
		Assert.assertTrue(frenzy.getDistanciaAtaque() == distanciaAtaqueHumanoide);
		Assert.assertTrue(frenzy.getVelocidad() == velocidadHumanoide);
		Assert.assertTrue(frenzy.tipoUnidad() == unidadHumanoide);
	}
}
