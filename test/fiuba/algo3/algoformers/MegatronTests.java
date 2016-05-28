package fiuba.algo3.algoformers;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.algoformers.Megatron;

public class MegatronTests {
	private int vidaHumanoide = 550;
	private int fuerzaAtaqueHumanoide = 10;
	private int distanciaAtaqueHumanoide = 3;
	private int velocidadHumanoide = 1;
	private int unidadHumanoide = "terrestre";

	private int vidaAlterno = 550;
	private int fuerzaAtaqueAlterno = 55;
	private int distanciaAtaqueAlterno = 2;
	private int velocidadAlterno = 8;
	private int unidadAlterno = "aerea";

	@Test
	public void test01CrearMegatron() {
		Megatron megatron = new Megatron();

		Assert.assertTrue(megatron.getNombre() == "Megatron");
	}

	@Test
	public void test02MegatronHumanoide() {
		Megatron megatron = new Megatron();
		Assert.assertTrue(megatron.vida() == vidaHumanoide);
		Assert.assertTrue(megatron.fuerzaAtaque() == fuerzaAtaqueHumanoide);
		Assert.assertTrue(megatron.distanciaAtaque() == distanciaAtaqueHumanoide);
		Assert.assertTrue(megatron.velocidad() == velocidadHumanoide);
		Assert.assertTrue(megatron.tipoUnidad() == unidadHumanoide);
	}

	@Test
	public void test03MegatronAlterno() {
		Megatron megatron = new Megatron("Alterno");
		Assert.assertTrue(megatron.vida() == vidaAlterno);
		Assert.assertTrue(megatron.fuerzaAtaque() == fuerzaAtaqueAlterno);
		Assert.assertTrue(megatron.distanciaAtaque() == distanciaAtaqueAlterno);
		Assert.assertTrue(megatron.velocidad() == velocidadAlterno);
		Assert.assertTrue(megatron.tipoUnidad() == unidadAlterno);
	}

	@Test
	public void test04MegatronTransformHumanoideAlterno() {
		Megatron megatron = new Megatron();
		megatron.transformarAlterno();
		Assert.assertTrue(megatron.vida() == vidaAlterno);
		Assert.assertTrue(megatron.fuerzaAtaque() == fuerzaAtaqueAlterno);
		Assert.assertTrue(megatron.distanciaAtaque() == distanciaAtaqueAlterno);
		Assert.assertTrue(megatron.velocidad() == velocidadAlterno);
		Assert.assertTrue(megatron.tipoUnidad() == unidadAlterno);
	}

	@Test
	public void test05MegatronTransformAlternoHumanoide() {
		Megatron megatron = new Megatron("Alterno");
		megatron.transformarHumaniode();
		Assert.assertTrue(megatron.vida() == vidaHumanoide);
		Assert.assertTrue(megatron.fuerzaAtaque() == fuerzaAtaqueHumanoide);
		Assert.assertTrue(megatron.distanciaAtaque() == distanciaAtaqueHumanoide);
		Assert.assertTrue(megatron.velocidad() == velocidadHumanoide);
		Assert.assertTrue(megatron.tipoUnidad() == unidadHumanoide);
	}
}
