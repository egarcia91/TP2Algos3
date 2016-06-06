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
		OptimusPrime optimusPrime = new OptimusPrime();

		Assert.assertTrue(optimusPrime.getNombre() == "Optimus Prime");
	}

	@Test
	public void test02OptimusHumanoide() {
		OptimusPrime optimusPrime = new OptimusPrime();
		Assert.assertTrue(optimusPrime.getVida() == vidaHumanoide);
		Assert.assertTrue(optimusPrime.getFuerzaAtaque() == fuerzaAtaqueHumanoide);
		Assert.assertTrue(optimusPrime.getDistanciaAtaque() == distanciaAtaqueHumanoide);
		Assert.assertTrue(optimusPrime.getVelocidad() == velocidadHumanoide);
		Assert.assertTrue(optimusPrime.getTipoUnidad() == unidadHumanoide);
	}

	@Test
	public void test03OptimusAlterno() {
		OptimusPrime optimusPrime = new OptimusPrime();
		optimusPrime.transformarAlterno();
		Assert.assertTrue(optimusPrime.getVida() == vidaAlterno);
		Assert.assertTrue(optimusPrime.getFuerzaAtaque() == fuerzaAtaqueAlterno);
		Assert.assertTrue(optimusPrime.getDistanciaAtaque() == distanciaAtaqueAlterno);
		Assert.assertTrue(optimusPrime.getVelocidad() == velocidadAlterno);
		Assert.assertTrue(optimusPrime.getTipoUnidad() == unidadAlterno);
	}

	@Test
	public void test04OptimusTransformHumanoideAlterno() {
		OptimusPrime optimusPrime = new OptimusPrime();
		optimusPrime.transformarAlterno();
		Assert.assertTrue(optimusPrime.getVida() == vidaAlterno);
		Assert.assertTrue(optimusPrime.getFuerzaAtaque() == fuerzaAtaqueAlterno);
		Assert.assertTrue(optimusPrime.getDistanciaAtaque() == distanciaAtaqueAlterno);
		Assert.assertTrue(optimusPrime.getVelocidad() == velocidadAlterno);
		Assert.assertTrue(optimusPrime.getTipoUnidad() == unidadAlterno);
	}

	@Test
	public void test05OptimusTransformAlternoHumanoide() {
		OptimusPrime optimusPrime = new OptimusPrime();
		optimusPrime.transformarAlterno();
		optimusPrime.transformarHumanoide();
		Assert.assertTrue(optimusPrime.getVida() == vidaHumanoide);
		Assert.assertTrue(optimusPrime.getFuerzaAtaque() == fuerzaAtaqueHumanoide);
		Assert.assertTrue(optimusPrime.getDistanciaAtaque() == distanciaAtaqueHumanoide);
		Assert.assertTrue(optimusPrime.getVelocidad() == velocidadHumanoide);
		Assert.assertTrue(optimusPrime.getTipoUnidad() == unidadHumanoide);
	}
}
