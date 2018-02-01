package sistemaDeApostas;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Classe que controla o sistema de apostas, e contem uma lista de cenarios, um
 * caixa e uma taxa.
 * 
 * @author Jardely Maris da Silva Santos - 117110274
 *
 */
public class Controller {

	private ArrayList<Cenario> cenarios;
	private int caixa;
	private double taxa;

	/**
	 * Construtor de Controller que inicializa o array de cenarios.
	 */
	public Controller() {
		this.cenarios = new ArrayList<>();
	}

	/**
	 * Metodo que inicializa o sistema.
	 * 
	 * @param caixa
	 *            valor inicial do caixa em centavos no formato inteiro.
	 * @param taxa
	 *            valor da taxa que sera cobrada pelo sistema.
	 * @throws IllegalArgumentException
	 *             excecao lancada quando o caixa eh iniciado com valor menor que
	 *             zero.
	 */
	public void inicializaSistema(int caixa, double taxa) throws IllegalArgumentException {
		if (caixa < 0) {
			throw new IllegalArgumentException("Erro na inicializacao: Caixa nao pode ser inferior a 0");
		}
		if (taxa < 0) {
			throw new IllegalArgumentException("Erro na inicializacao: Taxa nao pode ser inferior a 0");
		}

		this.caixa = caixa;
		this.taxa = taxa;
	}

	/**
	 * Metodo que retorna o valor em caixa do sistema.
	 * 
	 * @return valor inteiro da caixa do sistema.
	 */
	public int getCaixa() {
		return this.caixa;
	}

	/**
	 * Metodo que cadastra cenario e renorna um inteiro que o identifica.
	 * 
	 * @param descricao((CenarioBonus) 
	 *            descricao do cenario no formato string.
	 * @return o identificador inteiro do cenario.
	 */
	public int cadastrarCenario(String descricao) {
		Cenario cenario = new CenarioNormal(descricao, cenarios.size() + 1);
		this.cenarios.add(cenario);
		return cenarios.size();
	}
	
	public int cadastrarCenario(String descricao, int bonus) {
		this.caixa -= bonus;
		Cenario cenario = new CenarioBonus(descricao, cenarios.size() + 1, bonus);
		this.cenarios.add(cenario);
		
		return cenarios.size();
		
	}

	/**
	 * Metodo que exibe um cenario a partir de seu identificador.
	 * 
	 * @param idCenario
	 *            identificador inteiro do cenario.
	 * @return uma string que representa o cenario.
	 * @throws IllegalArgumentException
	 *             excecao lancada quando o id eh invalido.
	 */
	public String exibirCenario(int idCenario) throws IllegalArgumentException {
		if (idCenario <= 0) {
			throw new IllegalArgumentException("Erro na consulta de cenario: Cenario invalido");
		}
		for (Cenario cenario : cenarios) {
			if (cenario.getNumeracaoDoCenario() == idCenario) {
				return cenario.toString();
			}
		}
		throw new IllegalArgumentException("Erro na consulta de cenario: Cenario nao cadastrado");
	}

	/**
	 * Metodo que exibe todos os cenarios cadastrados.
	 * 
	 * @return uma string contendo a exibicao dos cenarios.
	 */
	public String exibirCenarios() {
		String stringCenarios = "";
		for (Cenario cenario : this.cenarios) {
			stringCenarios += cenario.toString() + "\n";
		}
		return stringCenarios;
	}

	/**
	 * Metodo que fecha uma aposta.
	 * 
	 * @param idCenario
	 *            identificador que indica qual cenario sera fechado.
	 * @param ocorreu
	 *            boolean que indica se o cenario ocorreu ou nao.
	 * @throws IllegalArgumentException
	 *             excessao lancada quando o cenario eh invalido, nao esta
	 *             cadastrado ou ja esta fechado.
	 */
	public void fecharAposta(int idCenario, boolean ocorreu) throws IllegalArgumentException {
		if (idCenario <= 0) {
			throw new IllegalArgumentException("Erro ao fechar aposta: Cenario invalido");
		}
		if (idCenario > cenarios.size()) {
			throw new IllegalArgumentException("Erro ao fechar aposta: Cenario nao cadastrado");
		}
		if (!cenarios.get(idCenario - 1).getEstado().equals("Nao finalizado")) {
			throw new IllegalArgumentException("Erro ao fechar aposta: Cenario ja esta fechado");
		}
		this.cenarios.get(idCenario - 1).encerraCenario(ocorreu);
	}

	public boolean cadastrarAposta(int idCenario, String nome, int valor, String previsao) {
		if (idCenario <= 0) {
			throw new IllegalArgumentException("Erro no cadastro de aposta: Cenario invalido");
		}
		for (Cenario cenario : cenarios) {
			if (cenario.getNumeracaoDoCenario() == idCenario) {
				return cenario.cadastraAposta(nome, valor, previsao);
			}
		}
		throw new IllegalArgumentException("Erro no cadastro de aposta: Cenario nao cadastrado");
	}

	/**
	 * Metodo que exibe o valor total das apostas de um cenario.
	 * 
	 * @param idCenario
	 *            identificador do cenario.
	 * @return um inteiro que representa o valor total das aposta de um cenario
	 * @throws IllegalArgumentException
	 *             excecao lancada quando o id eh invalido.
	 */
	public int exibirValorTotalApostas(int idCenario) throws IllegalArgumentException {
		if (idCenario <= 0) {
			throw new IllegalArgumentException("Erro na consulta do valor total de apostas: Cenario invalido");
		}
		if (idCenario > cenarios.size()) {
			throw new IllegalArgumentException("Erro na consulta do valor total de apostas: Cenario nao cadastrado");
		}
		return this.cenarios.get(idCenario - 1).getValorTotalApostas();
	}

	/**
	 * Metodo que exibe a quantidade de apostas de um cenario.
	 * 
	 * @param idCenario
	 *            identificador do cenario.
	 * @return um inteiro que indica a quantida de apostas de um cenario
	 * @throws IllegalArgumentException
	 *             excecao lancada quando o id do cenario eh invalido.
	 */
	public int exibirTotalApostas(int idCenario) throws IllegalArgumentException {
		if (idCenario <= 0) {
			throw new IllegalArgumentException("Erro na consulta do total de apostas: Cenario invalido");
		}
		if (idCenario > cenarios.size()) {
			throw new IllegalArgumentException("Erro na consulta do total de apostas: Cenario nao cadastrado");
		}
		return this.cenarios.get(idCenario - 1).totalApostas();
	}

	/**
	 * Metodo que lista as aposta de um cenario.
	 * 
	 * @param idCenario
	 *            identificador do cenairo
	 * @return uma string que representa a listagem de apostas de um cenario.
	 */
	public String exibeApostas(int idCenario) {
		return this.cenarios.get(idCenario - 1).listarApostas();
	}

	/**
	 * Metodo que retorna o valor do caixa de um cenario
	 * 
	 * @param idCenario
	 *            identificador do cenario.
	 * @return o valor inteiro que o caixa do cenario contem
	 * @throws IllegalArgumentException
	 *             excessao lancada quando o id do cenario eh invalido ou quando o
	 *             cenario ainda esta aberto.
	 */
	public int caixaCenario(int idCenario) throws IllegalArgumentException {
		if (idCenario <= 0) {
			throw new IllegalArgumentException("Erro na consulta do caixa do cenario: Cenario invalido");
		}
		if (idCenario > cenarios.size()) {
			throw new IllegalArgumentException("Erro na consulta do caixa do cenario: Cenario nao cadastrado");
		}
		if (cenarios.get(idCenario - 1).getEstado().equals("Nao finalizado")) {
			throw new IllegalArgumentException("Erro na consulta do caixa do cenario: Cenario ainda esta aberto");
		}
		return (int) (this.cenarios.get(idCenario - 1).valorApostas() * this.taxa);
	}

	/**
	 * Metodo que retorna o valor do rateio da aposta.
	 * 
	 * @param idCenario
	 *            identificador do cenario.
	 * @return o valor inteiro do rateio do cenario.
	 * @throws IllegalArgumentException
	 *             excecao lancada quando o identificador do cenario eh invalido ou
	 *             quando o enario ainda esta aberto.
	 */
	public int rateioCenario(int idCenario) throws IllegalArgumentException {
		if (idCenario <= 0) {
			throw new IllegalArgumentException("Erro na consulta do total de rateio do cenario: Cenario invalido");
		}
		if (idCenario > cenarios.size()) {
			throw new IllegalArgumentException(
					"Erro na consulta do total de rateio do cenario: Cenario nao cadastrado");
		}
		if (cenarios.get(idCenario - 1).getEstado().equals("Nao finalizado")) {
			throw new IllegalArgumentException(
					"Erro na consulta do total de rateio do cenario: Cenario ainda esta aberto");
		}
		this.caixa += this.cenarios.get(idCenario - 1).valorApostas() * this.taxa;
		return (int) ((this.cenarios.get(idCenario - 1).valorApostas()
				- this.cenarios.get(idCenario - 1).valorApostas() * this.taxa)) + this.cenarios.get(idCenario -1).getBonus();
	}
	
}
