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
		assertEquals(this.controle.cadastrarCenario(null), 1);
	}

	/**
	 * Metodo que testa cadastrar um cenario descricao vazia.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastrarCenarioVazio() {
		assertEquals(this.controle.cadastrarCenario(""), 1);
	}

	/**
	 * Metodo que testa exibir um cenario.
	 */
	@Test
	public void testExibirCenario() {
		this.controle.cadastrarCenario("Vou superar a ultima semana de aula de Dezembro");
		this.controle.cadastrarCenario("Rodolfo vai passar em um concurso");
		assertEquals(this.controle.exibirCenario(1),
				"1 - Vou superar a ultima semana de aula de Dezembro - Nao finalizado");
		assertEquals(this.controle.exibirCenario(2), "2 - Rodolfo vai passar em um concurso - Nao finalizado");
		this.controle.fecharAposta(1, true);
		this.controle.fecharAposta(2, false);
		assertEquals(this.controle.exibirCenario(1),
				"1 - Vou superar a ultima semana de aula de Dezembro - Finalizado (ocorreu)");
		assertEquals(this.controle.exibirCenario(2),
				"2 - Rodolfo vai passar em um concurso - Finalizado (nao ocorreu)");

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
		assertEquals(this.controle.exibirCenarios(),
				"1 - Vou superar a ultima semana de aula de Dezembro - Nao finalizado\n"
						+ "2 - Rodolfo vai passar em um concurso - Nao finalizado\n");
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
		this.controle.fecharAposta(2, false);
		assertEquals(this.controle.caixaCenario(1), 0);
		assertEquals(this.controle.caixaCenario(2), 20);
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
		this.controle.cadastrarCenario("Rodolfo vai passar em um concurso");
		this.controle.cadastrarAposta(1, "Adelma", 1000, "VAI ACONTECER");
		this.controle.cadastrarAposta(1, "Luna", 1000, "VAI ACONTECER");
		this.controle.cadastrarAposta(1, "Aliedson", 1000, "VAI ACONTECER");
		this.controle.cadastrarAposta(1, "Adao", 30000, "N VAI ACONTECER");
		this.controle.fecharAposta(1, true);
		this.controle.cadastrarAposta(2, "Luna", 1000, "N VAI ACONTECER");
		this.controle.cadastrarAposta(2, "Luna", 2000, "VAI ACONTECER");
		this.controle.fecharAposta(2, false);
		assertEquals(this.controle.rateioCenario(1), 29700);
		assertEquals(this.controle.rateioCenario(2), 1980);
	}
}
