package testeSistemaDeApostas;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import sistemaDeApostas.Controller;

/**
 * Classe que testa os metodos da classe Controller
 * 
 * @author JardelyMaris
 *
 */
public class testController {

	/**
	 * Representacao do controller.
	 */
	private Controller controle = new Controller();

	/**
	 * Metodo que inicializa o sistema antes para todos os metodos de teste da
	 * classe.
	 */
	@Before
	public void iniciaSistema() {
		this.controle.inicializaSistema(100, 0.01);
	}

	/**
	 * Metodo que testa inicializar o sistema com valor do caixa menor que zero, e
	 * depois testa inicializae o sistema com taxa menor que zero.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testInicializaSistemaValorMenorOuIgualZero() {
		this.controle.inicializaSistema(-1, 0.1);
		this.controle.inicializaSistema(10, -1);
	}

	/**
	 * Metodo que testa cadastrar um cenario.
	 */
	@Test
	public void testCadastrarCenario() {
		assertEquals(this.controle.cadastrarCenario("Vou superar a ultima semana de aula de Dezembro"), 1);
	}

	/**
	 * Metodo que testa cadastrar um cenario com descricao nulo.
	 */
	@Test(expected = NullPointerException.class)
	public void testCadastrarCenarioNulo() {
		this.controle.cadastrarCenario(null);
		fail("Descricao nao pode ser nulo");
	}

	/**
	 * Metodo que testa cadastrar um cenario descricao vazia.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastrarCenarioVazio() {
		this.controle.cadastrarCenario("");
		fail("Descricao nao pode ser vazia");
	}

	/**
	 * Metodo que testa cadastrar um cenario com bonus.
	 */
	@Test
	public void testCadastrarCenarioBonus() {
		assertEquals(this.controle.cadastrarCenario("Vai chover em PL", 1000), 1);
	}

	/**
	 * Metodo que testa cadastrar um cenario bonus com descricao nulo.
	 */
	@Test(expected = NullPointerException.class)
	public void testCadastrarCenarioBonusDescricaoNulo() {
		this.controle.cadastrarCenario(null, 1000);
		fail("Descricao nao pode ser nulo");
	}

	/**
	 * Metodo que testa cadastrar um cenario com bonus descricao vazia.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastrarCenarioBonusDescricaoVazio() {
		this.controle.cadastrarCenario("", 1000);
		fail("Descricao nao pode ser vazia");
	}
	
	/**
	 * Metodo que testa cadastrar um cenario com bonus zero.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastrarCenarioBonusZero() {
		this.controle.cadastrarCenario("Vai chover em PL", 0);
		fail("Bonus nao pode ser zero");
	}
	
	/**
	 * Metodo que testa cadastrar um cenario com bonus menor que zero.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastrarCenarioBonusMenorZero() {
		this.controle.cadastrarCenario("Vai chover em PL", -1);
		fail("Bonus nao pode ser menor que zero");
	}
	
	/**
	 * Metodo que testa exibir um cenario.
	 */
	@Test
	public void testExibirCenario() {
		this.controle.cadastrarCenario("Vou superar a ultima semana de aula de Dezembro");
		this.controle.cadastrarCenario("Rodolfo vai passar em um concurso");
		this.controle.cadastrarCenario("Vai chover hoje", 100);
		assertEquals(this.controle.exibirCenario(1),
				"1 - Vou superar a ultima semana de aula de Dezembro - Nao finalizado");
		assertEquals(this.controle.exibirCenario(3), "3 - Vai chover hoje - Nao finalizado - R$ 1,00");
		assertEquals(this.controle.exibirCenario(2), "2 - Rodolfo vai passar em um concurso - Nao finalizado");
		this.controle.fecharAposta(1, true);
		this.controle.fecharAposta(2, false);
		this.controle.fecharAposta(3, false);
		assertEquals(this.controle.exibirCenario(3),
				"3 - Vai chover hoje - Finalizado (n ocorreu) - R$ 1,00");
		assertEquals(this.controle.exibirCenario(1),
				"1 - Vou superar a ultima semana de aula de Dezembro - Finalizado (ocorreu)");
		assertEquals(this.controle.exibirCenario(2),
				"2 - Rodolfo vai passar em um concurso - Finalizado (n ocorreu)");

	}

	/**
	 * Metodo que testa exibir um cenario com id invalido.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testExibirCenarioIdInvalido() {
		this.controle.cadastrarCenario("Vou superar a ultima semana de aula de Dezembro");
		this.controle.cadastrarCenario("Rodolfo vai passar em um concurso");
		this.controle.exibirCenario(-1);
		this.controle.exibirCenario(0);
	}

	/**
	 * Metodo que testa exibir um cenario com id invalido, que nao esta cadastrado o
	 * cenario.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testExibirCenarioNaoCadastrado() {
		this.controle.cadastrarCenario("Vou superar a ultima semana de aula de Dezembro");
		this.controle.cadastrarCenario("Rodolfo vai passar em um concurso");
		this.controle.exibirCenario(8);
	}

	/**
	 * Metodo que testa listar cenarios.
	 */
	@Test
	public void testExibirCenarios() {
		this.controle.cadastrarCenario("Vou superar a ultima semana de aula de Dezembro");
		this.controle.cadastrarCenario("Rodolfo vai passar em um concurso");
		this.controle.cadastrarCenario("Luna vai tomar banho hj", 10000);
		assertEquals(this.controle.exibirCenarios(),
				"1 - Vou superar a ultima semana de aula de Dezembro - Nao finalizado\n"
						+ "2 - Rodolfo vai passar em um concurso - Nao finalizado\n" +
						"3 - Luna vai tomar banho hj - Nao finalizado - R$ 100,00\n");
	}

	/**
	 * Metodo que testa listar cenarios com a lista vazia.
	 */
	@Test
	public void testExibirCenariosArrayVazio() {
		assertEquals(this.controle.exibirCenarios(), "");
	}

	/**
	 * Metodo que testa cadastrar uma aposta.
	 */
	@Test
	public void testCadastraAposta() {
		this.controle.cadastrarCenario("Vou superar a ultima semana de aula de Dezembro");
		this.controle.cadastrarCenario("Rodolfo vai passar em um concurso");
		assertTrue(this.controle.cadastrarAposta(1, "Luna", 1000, "VAI ACONTECER"));
	}

	/**
	 * Metodo que testa cadastrar aposta assegurada por valor.
	 */
	@Test
	public void testCadastrarApostaSeguroPorValor() {
		this.controle.cadastrarCenario("vai chover");
		assertEquals(this.controle.cadastraApostaAsseguradaPorValor(1, "Luna", 1000, "VAI ACONTECER", 30, 20), 1);
	}
	
	/**
	 * Metodo que testa cadastrar aposta assegurada por valor com id do cenario invalido.
	 */
	@Test (expected = IllegalArgumentException.class)
	public void testCadastrarApostaAsseguradaPorValorIdInvalido() {
		this.controle.cadastrarCenario("vai chover");
		this.controle.cadastraApostaAsseguradaPorValor(2, "Luna", 1000, "VAI ACONTECER", 30, 20);
	}
	
	/**
	 * Metodo que testa cadastrar aposta assegurada por valor com nome vazio.
	 */
	@Test (expected = IllegalArgumentException.class)
	public void testCadastrarApostaAsseguradaPorValorNomeVazio() {
		this.controle.cadastrarCenario("vai chover");
		this.controle.cadastraApostaAsseguradaPorValor(1, "", 1000, "VAI ACONTECER", 30, 20);
	}
	
	/**
	 * Metodo que testa cadastrar aposta assegurada por valor com nome nulo.
	 */
	@Test (expected = NullPointerException.class)
	public void testCadastrarApostaAsseguradaPorValorNomeNulo() {
		this.controle.cadastrarCenario("vai chover");
		this.controle.cadastraApostaAsseguradaPorValor(1, null, 1000, "VAI ACONTECER", 30, 20);
	}
	
	/**
	 * Metodo que testa cadastrar aposta assegurada por valor com valor zero.
	 */
	@Test (expected = IllegalArgumentException.class)
	public void testCadastrarApostaAsseguradaPorValorValorZero() {
		this.controle.cadastrarCenario("vai chover");
		this.controle.cadastraApostaAsseguradaPorValor(1, "Luna", 0, "VAI ACONTECER", 30, 20);
	}
	
	/**
	 * Metodo que testa cadastrar aposta assegurada por valor com valor menor que zero.
	 */
	@Test (expected = IllegalArgumentException.class)
	public void testCadastrarApostaAsseguradaPorValorMenorZero() {
		this.controle.cadastrarCenario("vai chover");
		this.controle.cadastraApostaAsseguradaPorValor(1, "Luna", -1, "VAI ACONTECER", 30, 20);
	}
	
	/**
	 * Metodo que testa cadastrar aposta assegurada por valor com previsao vazia.
	 */
	@Test (expected = IllegalArgumentException.class)
	public void testCadastrarApostaAsseguradaPorValorPrevisaoVazia() {
		this.controle.cadastrarCenario("vai chover");
		this.controle.cadastraApostaAsseguradaPorValor(1, "Luna", 1000, "", 30, 20);
	}
	
	/**
	 * Metodo que testa cadastrar aposta assegurada por valor com previsao nula.
	 */
	@Test (expected = IllegalArgumentException.class)
	public void testCadastrarApostaAsseguradaPorValorPrevisaoNulo() {
		this.controle.cadastrarCenario("vai chover");
		this.controle.cadastraApostaAsseguradaPorValor(1, "Luna", 1000, null, 30, 20);
	}
	
	/**
	 * Metodo que testa cadastrar aposta assegurada por valor com valor do seguro zero.
	 */
	@Test (expected = IllegalArgumentException.class)
	public void testCadastrarApostaAsseguradaPorValorValorSeguroZero() {
		this.controle.cadastrarCenario("vai chover");
		this.controle.cadastraApostaAsseguradaPorValor(1, "Luna", 1000, "VAI ACONTECER", 0, 20);
	}
	
	/**
	 * Metodo que testa cadastrar aposta assegurada por valor com valor do seguro menor que zero.
	 */
	@Test (expected = IllegalArgumentException.class)
	public void testCadastrarApostaAsseguradaPorValorSeguroMenorZero() {
		this.controle.cadastrarCenario("vai chover");
		this.controle.cadastraApostaAsseguradaPorValor(1, "Luna", 1000, "VAI ACONTECER", -1, 20);
	}
	
	/**
	 * Metodo que testa cadastrar aposta assegurada por valor com custo zero.
	 */
	@Test (expected = IllegalArgumentException.class)
	public void testCadastrarApostaAsseguradaPorValorCustoZero() {
		this.controle.cadastrarCenario("vai chover");
		this.controle.cadastraApostaAsseguradaPorValor(1, "Luna", 1000, "VAI ACONTECER", 30, 0);
	}
	
	/**
	 * Metodo que testa cadastrar aposta assegurada por valor com custo menor que zero.
	 */
	@Test (expected = IllegalArgumentException.class)
	public void testCadastrarApostaAsseguradaPorValorCustoMenorZero() {
		this.controle.cadastrarCenario("vai chover");
		this.controle.cadastraApostaAsseguradaPorValor(1, "Luna", 1000, "VAI ACONTECER", 30, -1);
	}
	
	/**
	 * Metodo que testa cadastrar aposta assegurada por taxa.
	 */
	@Test
	public void testCadastrarApostaSeguroPorTaxa() {
		this.controle.cadastrarCenario("vai chover");
		assertEquals(this.controle.cadastraApostaAsseguradaPorTaxa(1, "Luna", 1000, "VAI ACONTECER", 0.3, 20), 1);
	}
	
	/**
	 * Metodo que testa cadastrar aposta assegurada por taxa com id d cenario invalido.
	 */
	@Test (expected = IllegalArgumentException.class)
	public void testCadastrarApostaAsseguradaPorTaxaIdInvalido() {
		this.controle.cadastrarCenario("vai chover");
		this.controle.cadastraApostaAsseguradaPorTaxa(2, "Luna", 1000, "VAI ACONTECER", 0.3, 20);
	}
	
	/**
	 * Metodo que testa cadastrar aposta assegurada por taxa com nome vazio.
	 */
	@Test (expected = IllegalArgumentException.class)
	public void testCadastrarApostaAsseguradaPorTaxaNomeVazio() {
		this.controle.cadastrarCenario("vai chover");
		this.controle.cadastraApostaAsseguradaPorTaxa(1, "", 1000, "VAI ACONTECER", 0.3, 20);
	}
	
	/**
	 * Metodo que testa cadastrar aposta assegurada por taxa com nome nulo.
	 */
	@Test (expected = NullPointerException.class)
	public void testCadastrarApostaAsseguradaPorTaxaNomeNulo() {
		this.controle.cadastrarCenario("vai chover");
		this.controle.cadastraApostaAsseguradaPorTaxa(1, null, 1000, "VAI ACONTECER", 0.3, 20);
	}
	
	/**
	 * Metodo que testa cadastrar aposta assegurada por taxa com valor zero.
	 */
	@Test (expected = IllegalArgumentException.class)
	public void testCadastrarApostaAsseguradaPorTaxaValorZero() {
		this.controle.cadastrarCenario("vai chover");
		this.controle.cadastraApostaAsseguradaPorTaxa(1, "Luna", 0, "VAI ACONTECER", 0.3, 20);
	}
	
	/**
	 * Metodo que testa cadastrar aposta assegurada por taxa com valor menor que zero.
	 */
	@Test (expected = IllegalArgumentException.class)
	public void testCadastrarApostaAsseguradaPorTaxaMenorZero() {
		this.controle.cadastrarCenario("vai chover");
		this.controle.cadastraApostaAsseguradaPorTaxa(1, "Luna", -1, "VAI ACONTECER", 0.3, 20);
	}
	
	/**
	 * Metodo que testa cadastrar aposta assegurada por taxa com previsao vazia.
	 */
	@Test (expected = IllegalArgumentException.class)
	public void testCadastrarApostaAsseguradaPorTaxaPrevisaoVazia() {
		this.controle.cadastrarCenario("vai chover");
		this.controle.cadastraApostaAsseguradaPorTaxa(1, "Luna", 1000, "", 0.3, 20);
	}
	
	/**
	 * Metodo que testa cadastrar aposta assegurada por taxa com previsao nula.
	 */
	@Test (expected = IllegalArgumentException.class)
	public void testCadastrarApostaAsseguradaPorTaxaPrevisaoNulo() {
		this.controle.cadastrarCenario("vai chover");
		this.controle.cadastraApostaAsseguradaPorTaxa(1, "Luna", 1000, null, 0.3, 20);
	}
	
	/**
	 * Metodo que testa cadastrar aposta assegurada por taxa com taxa zero.
	 */
	@Test (expected = IllegalArgumentException.class)
	public void testCadastrarApostaAsseguradaPorTaxaTaxaSeguroZero() {
		this.controle.cadastrarCenario("vai chover");
		this.controle.cadastraApostaAsseguradaPorTaxa(1, "Luna", 1000, "VAI ACONTECER", 0, 20);
	}
	
	/**
	 * Metodo que testa cadastrar aposta assegurada por taxa com taxa menor que zero.
	 */
	@Test (expected = IllegalArgumentException.class)
	public void testCadastrarApostaAsseguradaPorValorTaxaSeguroMenorZero() {
		this.controle.cadastrarCenario("vai chover");
		this.controle.cadastraApostaAsseguradaPorTaxa(1, "Luna", 1000, "VAI ACONTECER", -1, 20);
	}
	
	/**
	 * Metodo que testa cadastrar aposta assegurada por taxa com custo zero.
	 */
	@Test (expected = IllegalArgumentException.class)
	public void testCadastrarApostaAsseguradaPorTaxaCustoZero() {
		this.controle.cadastrarCenario("vai chover");
		this.controle.cadastraApostaAsseguradaPorTaxa(1, "Luna", 1000, "VAI ACONTECER", 0.3, 0);
	}
	
	/**
	 * Metodo que testa cadastrar aposta assegurada por taxa com custo menor que zero.
	 */
	@Test (expected = IllegalArgumentException.class)
	public void testCadastrarApostaAsseguradaPorTaxaCustoMenorZero() {
		this.controle.cadastrarCenario("vai chover");
		this.controle.cadastraApostaAsseguradaPorTaxa(1, "Luna", 1000, "VAI ACONTECER", 0.3, -1);
	}
	
	/**
	 * Metodo que testa alter o seguro de taxa para valor.
	 */
	@Test
	public void testAlterarSeguroValor() {
		this.controle.cadastrarCenario("vai chover");
		this.controle.cadastraApostaAsseguradaPorTaxa(1, "Luna", 1000, "VAI ACONTECER", 0.3, 30);
		assertEquals(this.controle.alterarSeguroValor(1, 1, 1000), 1);
	}
	
	/**
	 * Metodo que testa alter o seguro de valor para taxa.
	 */
	@Test
	public void testAlterarSeguroTaxa() {
		this.controle.cadastrarCenario("vai chover");
		this.controle.cadastraApostaAsseguradaPorValor(1, "Luna", 1000, "VAI ACONTECER", 50, 30);
		assertEquals(this.controle.alterarSeguroTaxa(1, 1, 0.6), 1);
	}
	
	/**
	 * Metodo que testa cadastrar uma aposta com id invalido e com previsao errada.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastraApostaIdInvalido() {
		this.controle.cadastrarCenario("Vou superar a ultima semana de aula de Dezembro");
		this.controle.cadastrarCenario("Rodolfo vai passar em um concurso");
		this.controle.cadastrarAposta(0, "Luna", 1000, "VAI ACONTECER");
		this.controle.cadastrarAposta(-1, "Luna", 1000, "VAI ACONTECER");
		this.controle.cadastrarAposta(8, "Luna", 1000, "VAI ACONTECER");
		this.controle.cadastrarAposta(2, "Adelma", 10009, "VAI");
	}

	/**
	 * Metodo que testa exibir o total de aposta do cenario.
	 */
	@Test
	public void testExibirTotalDeApostas() {
		this.controle.cadastrarCenario("Vou superar a ultima semana de aula de Dezembro");
		this.controle.cadastrarCenario("Rodolfo vai passar em um concurso");
		this.controle.cadastrarAposta(1, "Adelma", 100000, "VAI ACONTECER");
		this.controle.cadastrarAposta(1, "Luna", 100000, "VAI ACONTECER");
		this.controle.cadastrarAposta(1, "Aliedson", 100000, "VAI ACONTECER");
		assertEquals(this.controle.exibirTotalApostas(1), 3);
		assertEquals(this.controle.exibirTotalApostas(2), 0);
	}

	/**
	 * Metodo que testa exibir o total de aposta do cenario com id invalido.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testExibirTotalDeApostasIdInvalido() {
		this.controle.cadastrarCenario("Vou superar a ultima semana de aula de Dezembro");
		this.controle.cadastrarCenario("Rodolfo vai passar em um concurso");
		this.controle.cadastrarAposta(1, "Adelma", 100000, "VAI ACONTECER");
		this.controle.cadastrarAposta(1, "Luna", 100000, "VAI ACONTECER");
		this.controle.cadastrarAposta(1, "Aliedson", 100000, "VAI ACONTECER");
		this.controle.exibirTotalApostas(0);
		this.controle.exibirTotalApostas(-1);
		this.controle.exibirTotalApostas(8);
	}

	/**
	 * Metodo que testa exibir o valor total de aposta do cenario.
	 */
	@Test
	public void testExibirValorTotalDeApostas() {
		this.controle.cadastrarCenario("Vou superar a ultima semana de aula de Dezembro");
		this.controle.cadastrarCenario("Rodolfo vai passar em um concurso");
		this.controle.cadastrarAposta(1, "Adelma", 100000, "VAI ACONTECER");
		this.controle.cadastrarAposta(1, "Luna", 100000, "VAI ACONTECER");
		this.controle.cadastrarAposta(1, "Aliedson", 100000, "VAI ACONTECER");
		this.controle.fecharAposta(1, true);
		assertEquals(this.controle.exibirValorTotalApostas(1), 300000);
	}

	/**
	 * Metodo que testa exibir o valor total de aposta do cenario com id invalido.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testExibirValorTotalDeApostasIdInvalido() {
		this.controle.cadastrarCenario("Vou superar a ultima semana de aula de Dezembro");
		this.controle.cadastrarCenario("Rodolfo vai passar em um concurso");
		this.controle.cadastrarAposta(1, "Adelma", 100000, "VAI ACONTECER");
		this.controle.cadastrarAposta(1, "Luna", 100000, "VAI ACONTECER");
		this.controle.cadastrarAposta(1, "Aliedson", 100000, "VAI ACONTECER");
		this.controle.fecharAposta(1, true);
		assertEquals(this.controle.exibirValorTotalApostas(0), 300000);
		assertEquals(this.controle.exibirValorTotalApostas(-1), 300000);
		assertEquals(this.controle.exibirValorTotalApostas(9), 300000);
	}

	/**
	 * Metodo que testa exibir o valor do caixa do cenario que sera destinado ao
	 * caixa do sistema.
	 */
	@Test
	public void testCaixaCenario() {
		this.controle.cadastrarCenario("Vou superar a ultima semana de aula de Dezembro");
		this.controle.cadastrarCenario("Rodolfo vai passar em um concurso");
		this.controle.cadastrarAposta(1, "Adelma", 1000, "VAI ACONTECER");
		this.controle.cadastrarAposta(1, "Luna", 1000, "VAI ACONTECER");
		this.controle.cadastrarAposta(1, "Aliedson", 1000, "VAI ACONTECER");
		this.controle.fecharAposta(1, true);
		this.controle.cadastrarAposta(2, "Luna", 1000, "N VAI ACONTECER");
		this.controle.cadastrarAposta(2, "Luna", 2000, "VAI ACONTECER");
		this.controle.cadastraApostaAsseguradaPorTaxa(2, "Tico", 1000, "VAI ACONTECER", 0.1, 50);
		this.controle.fecharAposta(2, false);
		assertEquals(this.controle.caixaCenario(1), 0);
		assertEquals(this.controle.caixaCenario(2), 30);
	}

	/**
	 * Metodo que testa exibir o valor do caixa do cenario com id invalido (id = 0,
	 * id = -1, id = 9- nao cadastrado -, id = 1 que eh de um cenario que nao foi
	 * fechado, entao nao podera pegar o valor do caixa do cenario).
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCaixaCenarioIdInvalido() {
		this.controle.cadastrarCenario("Vou superar a ultima semana de aula de Dezembro");
		this.controle.cadastrarCenario("Rodolfo vai passar em um concurso");
		this.controle.cadastrarAposta(1, "Adelma", 100000, "VAI ACONTECER");
		this.controle.cadastrarAposta(1, "Luna", 100000, "VAI ACONTECER");
		this.controle.cadastrarAposta(1, "Aliedson", 100000, "VAI ACONTECER");
		this.controle.caixaCenario(0);
		this.controle.caixaCenario(-1);
		this.controle.caixaCenario(9);
		this.controle.caixaCenario(1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testRateioCenarioIdInvalido() {
		this.controle.cadastrarCenario("Vou superar a ultima semana de aula de Dezembro");
		this.controle.cadastrarCenario("Rodolfo vai passar em um concurso");
		this.controle.cadastrarAposta(1, "Adelma", 100000, "VAI ACONTECER");
		this.controle.cadastrarAposta(1, "Luna", 100000, "VAI ACONTECER");
		this.controle.cadastrarAposta(1, "Aliedson", 100000, "VAI ACONTECER");
		this.controle.rateioCenario(0);
		this.controle.rateioCenario(-1);
		this.controle.rateioCenario(9);
		this.controle.rateioCenario(1);
	}

	/**
	 * Metodo que testa exibir o valor do rateio do cenario que sera destinado aos
	 * vencedores da aposta.
	 */
	@Test
	public void testRateioCenario() {
		this.controle.cadastrarCenario("Vou superar a ultima semana de aula de Dezembro");
		this.controle.cadastrarCenario("Rodolfo vai passar em um concurso", 1000); //COM BONUS
		this.controle.cadastrarAposta(1, "Adelma", 1000, "VAI ACONTECER");
		this.controle.cadastrarAposta(1, "Luna", 1000, "VAI ACONTECER");
		this.controle.cadastrarAposta(1, "Aliedson", 1000, "VAI ACONTECER");
		this.controle.cadastrarAposta(1, "Adao", 30000, "N VAI ACONTECER");
		this.controle.fecharAposta(1, true);
		this.controle.cadastrarAposta(2, "Luna", 1000, "N VAI ACONTECER");
		this.controle.cadastrarAposta(2, "Luna", 2000, "VAI ACONTECER");
		this.controle.fecharAposta(2, false);
		assertEquals(this.controle.rateioCenario(1), 29700);
		assertEquals(this.controle.rateioCenario(2), 2980);
	}
	
	@Test
	public void testExibirCenarioOrdenadoNome() {
		this.controle.cadastrarCenario("Vou superar a ultima semana de aula de Dezembro");
		this.controle.cadastrarCenario("Rodolfo vai passar em um concurso", 1000); //COM BONUS
		this.controle.cadastrarCenario("Vou superar a ultima semana de aula de Dezembro", 2000);
		
		this.controle.alterarOrdemCenarios("nome");
		assertEquals(this.controle.exibirCenarioOrdenado(3), "3 - Vou superar a ultima semana de aula de Dezembro - Nao finalizado - R$ 20,00");
		assertEquals(this.controle.exibirCenarioOrdenado(2),"1 - Vou superar a ultima semana de aula de Dezembro - Nao finalizado");
		assertEquals(this.controle.exibirCenarioOrdenado(1), "2 - Rodolfo vai passar em um concurso - Nao finalizado - R$ 10,00");
	}
	
	@Test
	public void testExibirCenarioOrdenadoCadastro() {
		this.controle.cadastrarCenario("Vou superar a ultima semana de aula de Dezembro");
		this.controle.cadastrarCenario("Vou superar a ultima semana de aula de Dezembro", 2000);
		this.controle.cadastrarCenario("Rodolfo vai passar em um concurso", 1000); //COM BONUS
		this.controle.cadastrarCenario("Vai chover hoje");
		this.controle.alterarOrdemCenarios("cadastro");
		assertEquals(this.controle.exibirCenarioOrdenado(4), "4 - Vai chover hoje - Nao finalizado");
	}
	
	@Test
	public void testExibirCenarioOrdenadoApostas() {
		this.controle.cadastrarCenario("Vou superar a ultima semana de aula de Dezembro");
		this.controle.cadastrarCenario("Vou superar a ultima semana de aula de Dezembro", 2000);
		this.controle.cadastrarCenario("Rodolfo vai passar em um concurso", 1000); //COM BONUS
		this.controle.cadastrarCenario("Vai chover hoje");
		this.controle.cadastrarAposta(1, "Luna", 1000, "VAI ACONTECER");
		this.controle.cadastrarAposta(1, "Aliedson", 1000, "VAI ACONTECER");
		this.controle.cadastrarAposta(2, "Adao", 30000, "N VAI ACONTECER");
		this.controle.cadastrarAposta(2, "Rodolfo", 1000, "VAI ACONTECER");
		this.controle.cadastrarAposta(3, "Andre", 20000, "VAI ACONTECER");
		this.controle.cadastrarAposta(4, "Adelma", 30000, "N VAI ACONTECER");
		this.controle.alterarOrdemCenarios("apostas");
		assertEquals(this.controle.exibirCenarioOrdenado(4), "4 - Vai chover hoje - Nao finalizado");
		assertEquals(this.controle.exibirCenarioOrdenado(2), "2 - Vou superar a ultima semana de aula de Dezembro - Nao finalizado - R$ 20,00");
		assertEquals(this.controle.exibirCenarioOrdenado(3), "3 - Rodolfo vai passar em um concurso - Nao finalizado - R$ 10,00");
		assertEquals(this.controle.exibirCenarioOrdenado(1), "1 - Vou superar a ultima semana de aula de Dezembro - Nao finalizado");
	}
	
	@Test
	public void testExibirCenarioOrdenadoApostas2() {
		this.controle.cadastrarCenario("Vou superar a ultima semana de aula de Dezembro");
		this.controle.cadastrarCenario("Vou superar a ultima semana de aula de Dezembro", 2000);
		this.controle.cadastrarCenario("Rodolfo vai passar em um concurso", 1000); //COM BONUS
		this.controle.cadastrarCenario("Vai chover hoje");
		this.controle.cadastrarAposta(3, "Luna", 1000, "VAI ACONTECER");
		this.controle.cadastrarAposta(3, "Aliedson", 1000, "VAI ACONTECER");
		this.controle.cadastrarAposta(2, "Adao", 30000, "N VAI ACONTECER");
		this.controle.cadastrarAposta(3, "Rodolfo", 1000, "VAI ACONTECER");
		this.controle.cadastrarAposta(3, "Andre", 20000, "VAI ACONTECER");
		this.controle.cadastrarAposta(1, "Adelma", 30000, "N VAI ACONTECER");
		this.controle.alterarOrdemCenarios("apostas");
		assertEquals(this.controle.exibirCenarioOrdenado(4), "4 - Vai chover hoje - Nao finalizado");
		assertEquals(this.controle.exibirCenarioOrdenado(1), "3 - Rodolfo vai passar em um concurso - Nao finalizado - R$ 10,00");
		assertEquals(this.controle.exibirCenarioOrdenado(3), "2 - Vou superar a ultima semana de aula de Dezembro - Nao finalizado - R$ 20,00");
		assertEquals(this.controle.exibirCenarioOrdenado(2), "1 - Vou superar a ultima semana de aula de Dezembro - Nao finalizado");
	}
}
