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

	/**
	 * Lista de cenarios do sistema.
	 */
	private ArrayList<Cenario> cenarios;
	/**
	 * Representacao do caixa do sistema, no tipo inteiro.
	 */
	private int caixa;
	/**
	 * Representacao da taxa do sistema, no tipo double.
	 */
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
	 * @param descricao
	 *            descricao do cenario no formato string.
	 * @return o identificador inteiro do cenario.
	 */
	public int cadastrarCenario(String descricao) {
		Cenario cenario = new Cenario(descricao, cenarios.size() + 1);
		this.cenarios.add(cenario);
		return cenarios.size();
	}

	/**
	 * Metodo que cadastra cenario com bonus e renorna um inteiro que o identifica.
	 * 
	 * @param descricao
	 *            descricao do cenario no formato string.
	 * @param bonus
	 *            inteiro que representa o bonus da aposta.
	 * @return o identificador inteiro do cenario.
	 */
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

	/**
	 * Metodo que cadastra uma aposta normal.
	 * 
	 * @param idCenario
	 *            inteiro identificador do cenario.
	 * @param nome
	 *            string que representa o nome do apostador.
	 * @param valor
	 *            inteiro que representa o valor da aposta.
	 * @param previsao
	 *            string que representa a previsao do apostador em relacao ao
	 *            cenario.
	 * @return um boolean que indica se foi cadastrado ou nao.
	 */
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
	 * Metodo que cadastra uma aposta assegurada por valor.
	 * 
	 * @param idCenario
	 *            inteiro identificador do cenario.
	 * @param apostador
	 *            string que representa o nome do apostador.
	 * @param valor
	 *            inteiro que representa o valor da aposta.
	 * @param previsao
	 *            string que representa a previsao do apostador em relacao ao
	 *            cenario.
	 * @param valorSeguro
	 *            valor do seguro da aposta assegurada por valor.
	 * @param custo
	 *            valor do custo da aposta assegurada.
	 * @return um boolean que indica se foi cadastrado ou nao.
	 */
	public int cadastraApostaAsseguradaPorValor(int idCenario, String apostador, int valor, String previsao,
			double valorSeguro, int custo) {
		if (idCenario <= 0) {
			throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por valor: Cenario invalido");
		}
		this.caixa += custo;
		for (Cenario cenario : cenarios) {
			if (cenario.getNumeracaoDoCenario() == idCenario) {
				return cenario.cadastraApostaAsseguradaPorValor(apostador, valor, previsao, (int) valorSeguro, custo);

			}
		}

		throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por valor: Cenario nao cadastrado");

	}

	/**
	 * Metodo que cadastra uma aposta assegurada por taxa.
	 * 
	 * @param idCenario
	 *            inteiro identificador do cenario.
	 * @param apostador
	 *            string que representa o nome do apostador.
	 * @param valor
	 *            inteiro que representa o valor da aposta.
	 * @param previsao
	 *            string que representa a previsao do apostador em relacao ao
	 *            cenario.
	 * @param valorSeguro
	 *            valor do seguro da aposta assegurada por taxa.
	 * @param custo
	 *            valor do custo da aposta assegurada.
	 * @return um boolean que indica se foi cadastrado ou nao.
	 */
	public int cadastraApostaAsseguradaPorTaxa(int idCenario, String apostador, int valor, String previsao,
			double valorSeguro, int custo) {
		if (idCenario <= 0) {
			throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por taxa: Cenario invalido");
		}
		this.caixa += custo;
		for (Cenario cenario : cenarios) {
			if (cenario.getNumeracaoDoCenario() == idCenario) {
				return cenario.cadastraApostaAsseguradaPorTaxa(apostador, valor, previsao, valorSeguro, custo);
			}
		}

		throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por taxa: Cenario nao cadastrado");
	}

	/**
	 * Metodo que altera de seguro por taxa para seguro por valor.
	 * 
	 * @param cenario
	 *            inteiro que identifica o cenario.
	 * @param apostaAssegurada
	 *            inteiro que identifica a aposta assegurada.
	 * @param valor
	 *            valor da aposta assegurada por valor.
	 * @return inteiro identificador da aposta.
	 */
	public int alterarSeguroValor(int cenario, int apostaAssegurada, int valor) {
		this.cenarios.get(cenario - 1).alterarSeguroValor(apostaAssegurada, valor);
		this.caixa -= valor;
		return apostaAssegurada;
	}

	/**
	 * Metodo que altera de seguro por valor para seguro por taxa.
	 * 
	 * @param cenario
	 *            inteiro que identifica o cenario.
	 * @param apostaAssegurada
	 *            inteiro que identifica a aposta assegurada.
	 * @param valor
	 *            valor da aposta assegurada por taxa.
	 * @return inteiro identificador da aposta.
	 */
	public int alterarSeguroTaxa(int cenario, int apostaAssegurada, double taxa) {
		this.cenarios.get(cenario - 1).alterarSeguroTaxa(apostaAssegurada, taxa);
		this.caixa -= (int) (this.cenarios.get(cenario - 1).getValorAposta(apostaAssegurada) * taxa);
		return apostaAssegurada;
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
		double caixaRecebe = this.cenarios.get(idCenario - 1).valorApostas() * this.taxa;
		this.caixa += caixaRecebe;
		double valorRateio = Math.ceil(this.cenarios.get(idCenario - 1).valorApostas() - caixaRecebe)
				+ this.cenarios.get(idCenario - 1).getExtra();
		return (int) (valorRateio);
	}

}
