package fiuba.algo3.algoformers;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.algoformers.OptimusPrime;

public class OptimusPrimeTests {
	private int vidaHumanoide = 500;
	private int fuerzaAtaqueHumanoide = 50;
	private int distanciaAtaqueHumanoide = 2;
	private int velocidadHumanoide = 2;
	private String unidadHumanoide = "terrestre";

	private int vidaAlterno = 500;
	private int fuerzaAtaqueAlterno = 15;
	private int distanciaAtaqueAlterno = 4;
	private int velocidadAlterno = 5;
	private String unidadAlterno = "terrestre";

	@Test
	public void test01CrearOptimus() {
		OptimusPrime optimusPrime = new OptimusPrime("Humanoide");

		Assert.assertTrue(optimusPrime.getNombre() == "Optimus Prime");
	}

	@Test
	public void test02OptimusHumanoide() {
		OptimusPrime optimusPrime = new OptimusPrime("Humanoide");
		Assert.assertTrue(optimusPrime.vida() == vidaHumanoide);
		Assert.assertTrue(optimusPrime.fuerzaAtaque() == fuerzaAtaqueHumanoide);
		Assert.assertTrue(optimusPrime.distanciaAtaque() == distanciaAtaqueHumanoide);
		Assert.assertTrue(optimusPrime.velocidad() == velocidadHumanoide);
		Assert.assertTrue(optimusPrime.tipoUnidad() == unidadHumanoide);
	}

	@Test
	public void test03OptimusAlterno() {
		OptimusPrime optimusPrime = new OptimusPrime("Alterno");
		Assert.assertTrue(optimusPrime.vida() == vidaAlterno);
		Assert.assertTrue(optimusPrime.fuerzaAtaque() == fuerzaAtaqueAlterno);
		Assert.assertTrue(optimusPrime.distanciaAtaque() == distanciaAtaqueAlterno);
		Assert.assertTrue(optimusPrime.velocidad() == velocidadAlterno);
		Assert.assertTrue(optimusPrime.tipoUnidad() == unidadAlterno);
	}

	@Test
	public void test04OptimusTransformHumanoideAlterno() {
		OptimusPrime optimusPrime = new OptimusPrime("Humanoide");
		optimusPrime.transformarAlterno();
		Assert.assertTrue(optimusPrime.vida() == vidaAlterno);
		Assert.assertTrue(optimusPrime.fuerzaAtaque() == fuerzaAtaqueAlterno);
		Assert.assertTrue(optimusPrime.distanciaAtaque() == distanciaAtaqueAlterno);
		Assert.assertTrue(optimusPrime.velocidad() == velocidadAlterno);
		Assert.assertTrue(optimusPrime.tipoUnidad() == unidadAlterno);
	}

	@Test
	public void test05OptimusTransformAlternoHumanoide() {
		OptimusPrime optimusPrime = new OptimusPrime("Alterno");
		optimusPrime.transformarHumanoide();
		Assert.assertTrue(optimusPrime.vida() == vidaHumanoide);
		Assert.assertTrue(optimusPrime.fuerzaAtaque() == fuerzaAtaqueHumanoide);
		Assert.assertTrue(optimusPrime.distanciaAtaque() == distanciaAtaqueHumanoide);
		Assert.assertTrue(optimusPrime.velocidad() == velocidadHumanoide);
		Assert.assertTrue(optimusPrime.tipoUnidad() == unidadHumanoide);
	}
}
