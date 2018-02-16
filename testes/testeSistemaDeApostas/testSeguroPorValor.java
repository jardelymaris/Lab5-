package testeSistemaDeApostas;

import static org.junit.Assert.*;

import org.junit.Test;

import sistemaDeApostas.SeguroPorValor;

/**
 * Classe de teste que testa a classe SeguroPorValor
 * 
 * @author Jardely Maris da Silva Santos - 117110274
 *
 */
public class testSeguroPorValor {

	/**
	 * Representacao do seguro por valor
	 */
	private SeguroPorValor seguroV;

	/**
	 * Metodo que testa criar seguro por valor com valor zero.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCriaSeguroPorValorComValorZero() {
		this.seguroV = new SeguroPorValor(50, 0);
		fail("Valor nao pode ser zero");
	}

	/**
	 * Metodo que testa criar seguro por valor com valor menor que zero.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCriaSeguroPorValorComValorMenorZero() {
		this.seguroV = new SeguroPorValor(50, -1);
		fail("Valor nao pode ser menor que zero");
	}

	/**
	 * Metodo que testa o toString.
	 */
	@Test
	public void testToString() {
		this.seguroV = new SeguroPorValor(50, 200);
		assertEquals(" - ASSEGURADA(VALOR) - R$200,00", this.seguroV.toString());
	}

	/**
	 * Metodo que testa o Equals com seguros iguais.
	 */
	@Test
	public void testEqualsComSeguroIguais() {
		this.seguroV = new SeguroPorValor(50, 100);
		SeguroPorValor seguroV2 = new SeguroPorValor(50, 100);
		assertTrue(this.seguroV.equals(seguroV2));
	}

	/**
	 * Metodo que testa o Equals com seguros diferentes.
	 */
	@Test
	public void testEqualsComSegurosDiferentes() {
		this.seguroV = new SeguroPorValor(50, 100);
		SeguroPorValor seguroV2 = new SeguroPorValor(50, 200);
		assertFalse(this.seguroV.equals(seguroV2));
	}
}
