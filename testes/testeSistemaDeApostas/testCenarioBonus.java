package testeSistemaDeApostas;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import sistemaDeApostas.CenarioBonus;

/**
 * Classe de testes de CenarioBonus.
 * 
 * @author Jardely Maris da Silva Santos - 117110274
 */

public class testCenarioBonus {

	/**
	 * Representacao de um cenario bonus.
	 */
	private CenarioBonus cenarioBonus;

	/**
	 * Metodo que cria um cenarioBonus.
	 */
	@Before
	public void criaCenarioBonus() {
		this.cenarioBonus = new CenarioBonus("Feriado na quarta-feira de cinzas", 1, 1000);
	}

	/**
	 * Metodo que testa criar um cenario bonus com bonus zero.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCriaCenarioBonusComBonusZero() {
		this.cenarioBonus = new CenarioBonus("Pagar Calculo II", 2, 0);
		fail("Bonus nao pode ser zero.");
	}

	/**
	 * Metodo que testa criar um cenario bonus com bonus menor que zero.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCriaCenarioBonusComBonusMenorZero() {
		this.cenarioBonus = new CenarioBonus("Pagar Calculo II", 2, -1);
		fail("Bonus nao pode ser menor que zero.");
	}

	/**
	 * Metodo que testa pegar o bonus do cenario com bonus.
	 */
	@Test
	public void testGetExtra() {
		assertEquals(this.cenarioBonus.getExtra(), 1000);
	}

	/**
	 * Metodo que testa o toString do cenario bonus.
	 */
	@Test
	public void testToString() {
		assertEquals(this.cenarioBonus.toString(), "1 - Feriado na quarta-feira de cinzas - Nao finalizado - R$ 10,00");
	}

	/**
	 * Metodo que testa se dois cenarios iguais são iguais comparando o bonus.
	 */
	@Test
	public void testEqualsCenariosIguais() {
		CenarioBonus cenarioB = new CenarioBonus("Feriado na quarta-feira de cinzas", 2, 1000);
		assertTrue(this.cenarioBonus.equals(cenarioB));
	}

	/**
	 * Metodo que testa se dois cenarios diferentes são iguais comparando o bonus.
	 */
	@Test
	public void testEqualsCenariosDiferentes() {
		CenarioBonus cenarioB = new CenarioBonus("Feriado na quarta-feira de cinzas", 2, 2000);
		assertFalse(this.cenarioBonus.equals(cenarioB));
	}

}
