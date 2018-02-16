package testeSistemaDeApostas;

import static org.junit.Assert.*;

import org.junit.Test;

import sistemaDeApostas.SeguroPorTaxa;

/**
 * Classe de teste que testa os metodos da classe SeguroPorTaxa.
 * 
 * @author Jardely Maris da Silva Santos - 117110274
 *
 */
public class testSeguroPorTaxa {

	/**
	 * Representacao do seguro por taxa.
	 */
	private SeguroPorTaxa seguroT;

	/**
	 * Metodo que testa criar seguro por taxa com taxa zero.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCriaSeguroPorTaxaComTaxaZero() {
		this.seguroT = new SeguroPorTaxa(50, 0);
		fail("Taxa nao pode ser zero");
	}

	/**
	 * Metodo que testa criar seguro por taxa com taxa menor que zero.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCriaSeguroPorValorComTaxaMenorZero() {
		this.seguroT = new SeguroPorTaxa(50, -1);
		fail("Taxa nao pode ser menor que zero");
	}

	/**
	 * Metodo que testa o toString.
	 */
	@Test
	public void testToString() {
		this.seguroT = new SeguroPorTaxa(50, 2);
		assertEquals(" - ASSEGURADA(TAXA) - 200%", this.seguroT.toString());
	}

	/**
	 * Metodo que testa o Equals com seguros iguais.
	 */
	@Test
	public void testEqualsComSeguroIguais() {
		this.seguroT = new SeguroPorTaxa(50, 2);
		SeguroPorTaxa seguroT2 = new SeguroPorTaxa(50, 2);
		assertTrue(this.seguroT.equals(seguroT2));
	}

	/**
	 * Metodo que testa o Equals com seguros diferentes.
	 */
	@Test
	public void testEqualsComSegurosDiferentes() {
		this.seguroT = new SeguroPorTaxa(50, 1);
		SeguroPorTaxa seguroT2 = new SeguroPorTaxa(50, 2);
		assertFalse(this.seguroT.equals(seguroT2));
	}
}
