package testeSistemaDeApostas;

import static org.junit.Assert.*;

import org.junit.Test;

import sistemaDeApostas.Aposta;

public class testAposta {
	private Aposta aposta;

	@Test(expected = NullPointerException.class)
	public void testNomeNulo() {
		this.aposta = new Aposta(null, 199, "VAI ACONTECER");
		fail("Nome nao pode ser nulo");
	}

	@Test(expected = NullPointerException.class)
	public void testPrevisaoNulo() {
		this.aposta = new Aposta("Rodolfo", 199, null);
		fail("Previsao nao pode ser nulo");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testNomeStringVazia() {
		this.aposta = new Aposta("", 199, "VAI ACONTECER");
		fail("Nome nao pode ser vazio");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testPrevisaoStringVazia() {
		this.aposta = new Aposta("Rodolfo", 199, "");
		fail("Previsao nao pode ser vazia");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testValorZero() {
		this.aposta = new Aposta("Rodolfo", 0, "VAI ACONTECER");
		fail("O valor da aposta nao pode ser zero");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testValorMenorZero() {
		this.aposta = new Aposta("Rodolfo", -1, "VAI ACONTECER");
		fail("O valor da aposta nao pode ser menor que zero");
	}

	@Test
	public void testToString() {
		this.aposta = new Aposta("Rodolfo", 199, "VAI ACONTECER");
		assertEquals(aposta.toString(), "Rodolfo - R$1,99 - VAI ACONTECER");
	}

	@Test
	public void testEqualsComPrevisaoIgual() {
		this.aposta = new Aposta("Rodolfo", 199, "VAI ACONTECER");
		Aposta aposta1 = new Aposta("Luna", 1000, "VAI ACONTECER");
		assertTrue(aposta.equals(aposta1));
	}

	@Test
	public void testEqualsComPrevisaoDiferente() {
		this.aposta = new Aposta("Rodolfo", 199, "VAI ACONTECER");
		Aposta aposta1 = new Aposta("Luna", 1000, "N VAI ACONTECER");
		assertFalse(aposta.equals(aposta1));
	}
}
