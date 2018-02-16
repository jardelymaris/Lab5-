package testeSistemaDeApostas;

import static org.junit.Assert.*;

import org.junit.Test;

import sistemaDeApostas.Aposta;

/**
 * Classe que testa os metodos da classe Aposta.
 * 
 * @author Jardely Maris da Silva Santos - 117110274
 *
 */
public class testAposta {
	private Aposta aposta;

	/**
	 * Metodo que testa criar uma aposta assegurada com valorSeguro menor que zero.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAsseguradaValorSeguroMenorZero() {
		this.aposta = new Aposta("Adelma", 1000, "VAI ACONTECER", -1, 40, "valor");
		fail("O valor do seguro da aposta nao pode ser menor que zero");
	}

	/**
	 * Metodo que testa criar uma aposta assegurada com valorSeguro zero.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAsseguradaValorSeguroZero() {
		this.aposta = new Aposta("Adelma", 1000, "VAI ACONTECER", 0, 40, "valor");
		fail("O valor do seguro da aposta nao pode ser zero");
	}

	/**
	 * Metodo que testa criar uma aposta assegurada com custo zero.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAsseguaradaCustoSeguroZero() {
		this.aposta = new Aposta("Adelma", 1000, "VAI ACONTECER", 200, 0, "valor");
		fail("O custo do seguro da aposta nao pode ser zero");
	}

	/**
	 * Metodo que testa criar uma aposta assegurada com custo menor que zero.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAsseguaradaCustoSeguroMenorZero() {
		this.aposta = new Aposta("Adelma", 1000, "VAI ACONTECER", 200, -1, "valor");
		fail("O custo do seguro da aposta nao pode ser menor que zero");
	}

	/**
	 * Metodo que testa criar uma aposta com nome do apostador nulo.
	 */
	@Test(expected = NullPointerException.class)
	public void testNomeNulo() {
		this.aposta = new Aposta(null, 199, "VAI ACONTECER");
		fail("Nome nao pode ser nulo");
	}

	/**
	 * Metodo que testa criar uma aposta com previsao nulo.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPrevisaoNulo() {
		this.aposta = new Aposta("Rodolfo", 199, null);
		fail("Previsao nao pode ser nulo");
	}

	/**
	 * Metodo que testa criar uma aposta com nome do apostador vazio.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testNomeStringVazia() {
		this.aposta = new Aposta("", 199, "VAI ACONTECER");
		fail("Nome nao pode ser vazio");
	}

	/**
	 * Metodo que testa criar uma aposta com previsao vazia.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPrevisaoStringVazia() {
		this.aposta = new Aposta("Rodolfo", 199, "");
		fail("Previsao nao pode ser vazia");
	}

	/**
	 * Metodo que testa criar uma aposta com valor zero.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testValorZero() {
		this.aposta = new Aposta("Rodolfo", 0, "VAI ACONTECER");
		fail("O valor da aposta nao pode ser zero");
	}

	/**
	 * Metodo que testa criar uma aposta com valor menor que zero.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testValorMenorZero() {
		this.aposta = new Aposta("Rodolfo", -1, "VAI ACONTECER");
		fail("O valor da aposta nao pode ser menor que zero");
	}

	/**
	 * Metodo que testa o toString de Aposta.
	 */
	@Test
	public void testToString() {
		this.aposta = new Aposta("Rodolfo", 199, "VAI ACONTECER");
		assertEquals(aposta.toString(), "Rodolfo - R$1,99 - VAI ACONTECER");
	}

	/**
	 * Metodo que testa o toString de Aposta com seguro por valor.
	 */
	@Test
	public void testToStringComSeguroValor() {
		this.aposta = new Aposta("Isabel", 1000, "VAI ACONTECER", 200, 30, "valor");
		assertEquals(aposta.toString(), "Isabel - R$10,00 - VAI ACONTECER - ASSEGURADA(VALOR) - R$200,00");
	}

	/**
	 * Metodo que testa o toString de Aposta com seguro por taxa.
	 */
	@Test
	public void testToStringComSeguroTaxa() {
		this.aposta = new Aposta("Isabel", 1000, "VAI ACONTECER", 0.2, 30, "taxa");
		assertEquals(aposta.toString(), "Isabel - R$10,00 - VAI ACONTECER - ASSEGURADA(TAXA) - 20%");
	}

	/**
	 * Metodo que testa o equals com previsao igual.
	 */
	@Test
	public void testEqualsComPrevisaoIgual() {
		this.aposta = new Aposta("Rodolfo", 199, "VAI ACONTECER");
		Aposta aposta1 = new Aposta("Luna", 1000, "VAI ACONTECER");
		assertTrue(aposta.equals(aposta1));
	}

	/**
	 * Metodo que testa o equals com previsao diferente.
	 */
	@Test
	public void testEqualsComPrevisaoDiferente() {
		this.aposta = new Aposta("Rodolfo", 199, "VAI ACONTECER");
		Aposta aposta1 = new Aposta("Luna", 1000, "N VAI ACONTECER");
		assertFalse(aposta.equals(aposta1));
	}
}
