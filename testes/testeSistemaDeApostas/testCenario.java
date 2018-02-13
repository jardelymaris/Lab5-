package testeSistemaDeApostas;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import sistemaDeApostas.Cenario;
import sistemaDeApostas.CenarioBonus;

/**
 * Classe teste de Cenario.
 * 
 * @author Jardely Maris da Silva Santos - 117110274
 *
 */
public class testCenario {

	private Cenario cenario;
	private Cenario cenarioBonus;

	/**
	 * Metodo Before que cria para todos os metodos de testes o objeto cenario.
	 */
	@Before
	public void criaCenario() {
		this.cenario = new Cenario("Vou superar a ultima semana de aula de dezembro", 1);
		this.cenarioBonus = new CenarioBonus("Carnaval programando", 2, 1000);
	}

	/**
	 * Metodo que testa criar um cenario com descricao nula.
	 */
	@Test(expected = NullPointerException.class)
	public void testCenarioNulo() {
		this.cenario = new Cenario(null, 1);
		fail("O argumento do cenario nao pode ser nulo");
	}
	
	/**
	 * Metodo que testa criar um cenario com bonus com descricao nula.
	 */
	@Test(expected = NullPointerException.class)
	public void testCenarioBonusNulo() {
		this.cenarioBonus = new CenarioBonus(null, 2, 1000);
		fail("O argumento do cenario nao pode ser nulo");
	}

	/**
	 * Metodo que testa criar um cenario com descricao vazia.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCenarioVazio() {
		this.cenario = new Cenario("", 1);
		fail("O argumento do cenario nao pode ser vazio");
	}
	
	/**
	 * Metodo que testa criar um cenario bonus com descricao vazia.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCenarioBonusVazio() {
		this.cenarioBonus = new CenarioBonus("", 2, 1000);
		fail("O argumento do cenario nao pode ser vazio");
	}
	
	/**
	 * Metodo que testa criar um cenario bonus com bonus menor que zero.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCenarioBonusMenorZero() {
		this.cenarioBonus = new CenarioBonus("Programar no carnaval", 2, -1);
		fail("O bonus do cenario nao pode ser menor que zero");
	}
	
	/**
	 * Metodo que testa criar um cenario bonus com bonus igual zero.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCenarioBonusIgualZero() {
		this.cenarioBonus = new CenarioBonus("Programar no carnaval", 2, 0);
		fail("O bonus do cenario nao pode ser zero");
	}

	/**
	 * Metodo que cadastra aposta com nome nulo.
	 */
	@Test(expected = NullPointerException.class)
	public void testCadastraApostaNomeNulo() {
		this.cenario.cadastraAposta(null, 1000, "N VAI ACONTECER");
		fail("Nome do apostador nao pode ser nulo");
	}
	
	/**
	 * Metodo que cadastra aposta segurada por valor com nome nulo.
	 */
	@Test(expected = NullPointerException.class)
	public void testCadastraApostaSeguroValorNomeNulo() {
		this.cenario.cadastraApostaAsseguradaPorValor(null, 1000, "VAI ACONTECER", 200, 50);
		fail("Nome do apostador nao pode ser nulo");
	}

	/**
	 * Metodo que cadastra aposta com Previsao nulo.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastraApostaPrevisaoNula() {
		this.cenario.cadastraAposta("Rodolfo", 1000, null);
		fail("Previsao da aposta nao pode ser nula");
	}
	
	/**
	 * Metodo que cadastra aposta segurada por valor com nome vazio.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastraApostaSeguroValorNomeVazio() {
		this.cenario.cadastraApostaAsseguradaPorValor("", 1000, "VAI ACONTECER", 200, 50);
		fail("Nome do apostador nao pode ser vazio");
	}

	/**
	 * Metodo que cadastra aposta segurada por valor com previsao nulo.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastraApostaSeguroValorPrevisaoNulo() {
		this.cenario.cadastraApostaAsseguradaPorValor("Luna", 1000, null, 200, 50);
		fail("Previsao nao pode ser nulo");
	}
	
	/**
	 * Metodo que cadastra aposta segurada por valor com previsao nulo.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastraApostaSeguroValorPrevisaoVazio() {
		this.cenario.cadastraApostaAsseguradaPorValor("Luna", 1000, "", 200, 50);
		fail("Previsao nao pode ser vazio");
	}
	
	/**
	 * Metodo que cadastra aposta segurada por valor com valor menor que zero.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastraApostaSeguroValorMenorZero() {
		this.cenario.cadastraApostaAsseguradaPorValor("Luna", -1, "VAI ACONTECER", 200, 50);
		fail("Previsao valor nao pode ser menor que zero");
	}
	
	/**
	 * Metodo que cadastra aposta segurada por valor com valor zero.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastraApostaSeguroValorIgualZero() {
		this.cenario.cadastraApostaAsseguradaPorValor("Luna", 0, "VAI ACONTECER", 200, 50);
		fail("Previsao valor nao pode ser zero");
	}
	
	/**
	 * Metodo que cadastra aposta segurada por valor com custo menor que zero.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastraApostaSeguroValorCustoMenorZero() {
		this.cenario.cadastraApostaAsseguradaPorValor("Luna", 1000, "VAI ACONTECER", 200, -1);
		fail("Previsao custo nao pode ser menor que zero");
	}
	
	/**
	 * Metodo que cadastra aposta segurada por valor com valor zero.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastraApostaSeguroValorCustoIgualZero() {
		this.cenario.cadastraApostaAsseguradaPorValor("Luna", 1000, "VAI ACONTECER", 200, 0);
		fail("Previsao custo nao pode ser zero");
	}
	
	/**
	 * Metodo que cadastra aposta segurada por valor com valor menor que zero.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastraApostaSeguroValorValorSeguroMenorZero() {
		this.cenario.cadastraApostaAsseguradaPorValor("Luna", 1000, "VAI ACONTECER", -1, 50);
		fail("Previsao valor do seguro nao pode ser menor que zero");
	}
	
	/**
	 * Metodo que cadastra aposta segurada por valor com valor zero.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastraApostaSeguroValorValorSeguroIgualZero() {
		this.cenario.cadastraApostaAsseguradaPorValor("Luna", 1000, "VAI ACONTECER", 0, 50);
		fail("Previsao valor do seguro nao pode ser zero");
	}
	
	/**
	 * Metodo que cadastra aposta segurada por taxa com nome nulo.
	 */
	@Test(expected = NullPointerException.class)
	public void testCadastraApostaSeguroTaxaNomeNulo() {
		this.cenario.cadastraApostaAsseguradaPorTaxa(null, 1000, "VAI ACONTECER", 0.02, 50);
		fail("Nome do apostador nao pode ser nulo");
	}
	
	/**
	 * Metodo que cadastra aposta segurada por taxa com nome vazio.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastraApostaSeguroTaxaNomeVazio() {
		this.cenario.cadastraApostaAsseguradaPorTaxa("", 1000, "VAI ACONTECER", 0.02, 50);
		fail("Nome do apostador nao pode ser vazio");
	}

	/**
	 * Metodo que cadastra aposta segurada por taxa com previsao nulo.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastraApostaSeguroTaxaPrevisaoNulo() {
		this.cenario.cadastraApostaAsseguradaPorTaxa("Luna", 1000, null, 0.02, 50);
		fail("Previsao nao pode ser nulo");
	}
	
	/**
	 * Metodo que cadastra aposta segurada por taxa com previsao nulo.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastraApostaSeguroTaxaPrevisaoVazio() {
		this.cenario.cadastraApostaAsseguradaPorTaxa("Luna", 1000, "", 0.02, 50);
		fail("Previsao nao pode ser vazio");
	}
	
	/**
	 * Metodo que cadastra aposta segurada por taxa com valor menor que zero.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastraApostaSeguroTaxaValorMenorZero() {
		this.cenario.cadastraApostaAsseguradaPorTaxa("Luna", -1, "VAI ACONTECER", 0.02, 50);
		fail("Previsao valor nao pode ser menor que zero");
	}
	
	/**
	 * Metodo que cadastra aposta segurada por taxa com valor zero.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastraApostaSeguroTaxaValorIgualZero() {
		this.cenario.cadastraApostaAsseguradaPorTaxa("Luna", 0, "VAI ACONTECER", 0.02, 50);
		fail("Previsao valor nao pode ser zero");
	}
	
	/**
	 * Metodo que cadastra aposta segurada por taxa com custo menor que zero.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastraApostaSeguroTaxaCustoMenorZero() {
		this.cenario.cadastraApostaAsseguradaPorTaxa("Luna", 1000, "VAI ACONTECER", 0.02, -1);
		fail("Previsao custo nao pode ser menor que zero");
	}
	
	/**
	 * Metodo que cadastra aposta segurada por taxa com valor zero.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastraApostaSeguroTaxaCustoIgualZero() {
		this.cenario.cadastraApostaAsseguradaPorTaxa("Luna", 1000, "VAI ACONTECER", 0.02, 0);
		fail("Previsao custo nao pode ser zero");
	}
	
	/**
	 * Metodo que cadastra aposta segurada por taxa com valor menor que zero.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastraApostaSeguroTaxaMenorZero() {
		this.cenario.cadastraApostaAsseguradaPorValor("Luna", 1000, "VAI ACONTECER", -1, 50);
		fail("Previsao valor do seguro nao pode ser menor que zero");
	}
	
	/**
	 * Metodo que cadastra aposta segurada por taxa com valor zero.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastraApostaSeguroTaxaIgualZero() {
		this.cenario.cadastraApostaAsseguradaPorTaxa("Luna", 1000, "VAI ACONTECER", 0, 50);
		fail("Previsao valor do seguro nao pode ser zero");
	}
	
	/**
	 * Metodo que cadastra aposta com nome vazio.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastraApostaNomeVazio() {
		this.cenario.cadastraAposta("", 1000, "N VAI ACONTECER");
		fail("Nome do apostador nao pode ser vazio");
	}

	/**
	 * Metodo que cadastra aposta com previsao vazia.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastraApostaPrevisaoVazia() {
		this.cenario.cadastraAposta("Rodolfo", 1000, "");
		fail("A previsao da aposta nao pode ser vazia");
	}

	/**
	 * Metodo que cadastra aposta com valor zero.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastraApostaValorZero() {
		this.cenario.cadastraAposta("Rodolfo", 0, "N VAI ACONTECER");
		fail("Valor da aposta nao pode ser zero");
	}

	/**
	 * Metodo que cadastra aposta com valor menor que zero.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastraApostaValorMenorZero() {
		this.cenario.cadastraAposta("Rodolfo", -1, "N VAI ACONTECER");
		fail("Valor da aposta nao pode ser menor que zero");
	}

	/**
	 * Metodo que testa cadastrar aposta.
	 */
	@Test
	public void testCadastraAposta() {
		assertTrue(cenario.cadastraAposta("Rodolfo", 1000, "N VAI ACONTECER"));
	}
	
	/**
	 * Metodo que testa cadastrar aposta com seguro por valor.
	 */
	@Test
	public void testCadastraApostaSeguroValor() {
		assertEquals(1, cenario.cadastraApostaAsseguradaPorValor("Luna", 1000, "N VAI ACONTECER", 200, 50));
	}
	
	/**
	 * Metodo que testa cadastrar aposta com seguro por taxa.
	 */
	@Test
	public void testCadastraApostaSeguroTaxa() {
		assertEquals(1, cenario.cadastraApostaAsseguradaPorTaxa("Luna", 1000, "N VAI ACONTECER", 0.02, 50));
	}

	/**
	 * Metodo que testa listar as apostas do cenario.
	 */
	@Test
	public void testListarApostas() {
		this.cenario.cadastraAposta("Rodolfo", 100000, "VAI ACONTECER");
		this.cenario.cadastraAposta("Andre", 199, "N VAI ACONTECER");
		this.cenario.cadastraAposta("Adelma", 200000, "VAI ACONTECER");
		this.cenario.cadastraApostaAsseguradaPorTaxa("Luna", 1000, "N VAI ACONTECER", 0.02, 50);
		this.cenario.cadastraApostaAsseguradaPorValor("Luna", 1000, "N VAI ACONTECER", 200, 50);
		assertEquals(this.cenario.listarApostas(), "Rodolfo - R$1000,00 - VAI ACONTECER\n"
				+ "Andre - R$1,99 - N VAI ACONTECER\n" + "Adelma - R$2000,00 - VAI ACONTECER\n" + 
				"Luna - R$10,00 - N VAI ACONTECER - ASSEGURADA(TAXA) - 2%\n" +
				"Luna - R$10,00 - N VAI ACONTECER - ASSEGURADA(VALOR) - R$200,00\n");
	}

	/**
	 * Metodo que testa listar as apostas do cenario com a lista vazia.
	 */
	@Test
	public void testListarApostasVazio() {
		assertEquals(this.cenario.listarApostas(), "");
	}

	/**
	 * Metodo que testa se retorna a quantidade total de apostas do cenario.
	 */
	@Test
	public void testTotalApostas() {
		this.cenario.cadastraAposta("Rodolfo", 100000, "VAI ACONTECER");
		this.cenario.cadastraAposta("Andre", 199, "N VAI ACONTECER");
		this.cenario.cadastraAposta("Adelma", 200000, "VAI ACONTECER");
		assertEquals(this.cenario.totalApostas(), 3);
	}

	/**
	 * Metodo que testa se retorna a quantidade total de apostas do cenario, igual a
	 * zero.
	 */
	@Test
	public void testTotalApostasZero() {
		assertEquals(this.cenario.totalApostas(), 0);
	}

	/**
	 * Metodo que testa encerrar um cenario como que ocorreu.
	 */
	@Test
	public void testEncerraCenarioOcorreu() {
		assertEquals(this.cenario.encerraCenario(true), "Finalizado (ocorreu)");
	}

	/**
	 * Metodo que testa encerrar um cenario como que nao ocorreu.
	 */
	@Test
	public void testEncerraCenarioNaoOcorreu() {
		assertEquals(this.cenario.encerraCenario(false), "Finalizado (nao ocorreu)");
	}

	/**
	 * Testa o metodo toString com cenario nao finalizado.
	 */
	@Test
	public void testToStringCenarioNaoFinalizado() {
		assertEquals(this.cenario.toString(), "1 - Vou superar a ultima semana de aula de dezembro - Nao finalizado");
	}

	/**
	 * Testa o metodo toString com cenario finalizado, ocorreu.
	 */
	@Test
	public void testToStringCenarioFinalizadoOcorreu() {
		this.cenario.encerraCenario(true);
		assertEquals(this.cenario.toString(),
				"1 - Vou superar a ultima semana de aula de dezembro - Finalizado (ocorreu)");
	}

	/**
	 * Testa o metodo toString com cenario finalizado nao ocorreu.
	 */
	@Test
	public void testToStringCenarioFinalizadoNaoOcorreu() {
		this.cenario.encerraCenario(false);
		assertEquals(this.cenario.toString(),
				"1 - Vou superar a ultima semana de aula de dezembro - Finalizado (nao ocorreu)");
	}

	/**
	 * Metodo que testa o equals com cenarios iguais.
	 */
	@Test
	public void testEqualsCenariosIguais() {
		Cenario cenario1 = new Cenario("Vou superar a ultima semana de aula de dezembro", 2);
		assertTrue(cenario.equals(cenario1));
	}

	/**
	 * Metodo que testa o equals com cenarios diferentes.
	 */
	@Test
	public void testEqualsCenariosDiferentes() {
		Cenario cenario1 = new Cenario("2 - Ser fitness em 2018!", 2);
		assertFalse(cenario.equals(cenario1));
	}
}
