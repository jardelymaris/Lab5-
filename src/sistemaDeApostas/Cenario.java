package sistemaDeApostas;

import java.util.ArrayList;

/**
 * Classe que cria um cenario contendo uma lista de apostas, um estado, uma
 * descricao e uma representacao inteira.
 * 
 * @author Jardely Maris da Silva Santos - 117110274
 *
 */
public class Cenario {

	/**
	 * Representacao do cenario, no fomato String.
	 */
	protected String cenario;
	/**
	 * Uma lista de apostas de um cenario.
	 */
	protected ArrayList<Aposta> apostasNoCenario;
	/**
	 * Representacao do estado de um cenario, no formato String.
	 */
	protected String estado;
	/**
	 * Representacao da numeracao de cenarios, no formato inteiro.
	 */
	protected int numeracaoDoCenario;

	/**
	 * Construtor de Cenario que recebe uma descricao e identificador.
	 * 
	 * @param cenario
	 *            descricao do cenario no formsto string.
	 * @param idCenario
	 *            numero que identifica o cenario, no formato inteiro.
	 * @throws NullPointerException
	 *             excecao lancada quando a descricao eh nula.
	 * @throws IllegalArgumentException
	 *             excecao lancada quando o id e a descricao eh passada de forma
	 *             inadequada.
	 */
	public Cenario(String cenario, int idCenario) throws NullPointerException, IllegalArgumentException {
		if (cenario == null) {
			throw new NullPointerException("Erro no cadastro de cenario: Descricao nao pode ser vazia");
		}
		if (cenario.trim().isEmpty()) {
			throw new IllegalArgumentException("Erro no cadastro de cenario: Descricao nao pode ser vazia");
		}
		if (idCenario <= 0) {
			throw new IllegalArgumentException("Erro no cadastro de aposta: Cenario invalido");
		}
		this.numeracaoDoCenario = idCenario;
		this.apostasNoCenario = new ArrayList<>();
		this.cenario = cenario;
		this.estado = "Nao finalizado";
	}

	/**
	 * Metodo que retorna a numeracao do cenario.
	 * 
	 * @return o numero identificador do cenario.
	 */
	public int getNumeracaoDoCenario() {
		return this.numeracaoDoCenario;
	}

	/**
	 * Metodo que cadastra a aposta na lista do cenario.
	 * 
	 * @param nome
	 *            nome do apostador no formato string.
	 * @param valor
	 *            valor da aposta em centavos, no formato inteiro.
	 * @param previsao
	 *            afirma se o cenario vai ou nao acontecer, no formato string.
	 * @return um boolean que indica se a aposta foi cadastrada.
	 */
	public boolean cadastraAposta(String nome, int valor, String previsao) {
		Aposta aposta = new Aposta(nome, valor, previsao);
		return apostasNoCenario.add(aposta);
	}

	/**
	 * Metodo que cadastra uma aposta assegurada por valor.
	 * 
	 * @param apostador
	 *            string que contem o nome do apostador.
	 * @param valor
	 *            inteiro que representa o valor da aposta.
	 * @param previsao
	 *            afirma se o cenario vai ou nao acontecer, no formato string.
	 * @param valorSeguro
	 *            inteiro que representa o valor da aposta assegurada por valor.
	 * @param custo
	 *            inteiro que representa o custo da aposta assegurada.
	 * @return um inteiro que identifica a aposta cadastrada.
	 */
	public int cadastraApostaAsseguradaPorValor(String apostador, int valor, String previsao, int valorSeguro,
			int custo) {
		if (apostador == null) {
			throw new NullPointerException(
					"Erro no cadastro de aposta assegurada por valor: Apostador nao pode ser vazio ou nulo");
		}
		if (apostador.trim().isEmpty()) {
			throw new IllegalArgumentException(
					"Erro no cadastro de aposta assegurada por valor: Apostador nao pode ser vazio ou nulo");
		}
		if (valor <= 0) {
			throw new IllegalArgumentException(
					"Erro no cadastro de aposta assegurada por valor: Valor nao pode ser menor ou igual a zero");
		}
		if (valorSeguro <= 0) {
			throw new IllegalArgumentException(
					"Erro no cadastro de aposta assegurada por valor: Valor do seguro nao pode ser menor ou igual a zero");
		}
		if (custo <= 0) {
			throw new IllegalArgumentException(
					"Erro no cadastro de aposta assegurada por valor: Custo nao pode ser menor ou igual a zero");
		}
		if (previsao == null || previsao.trim().isEmpty()) {
			throw new IllegalArgumentException(
					"Erro no cadastro de aposta assegurada por valor: Previsao nao pode ser vazia ou nula");
			
		} else if (!previsao.equals("VAI ACONTECER") && !previsao.equals("N VAI ACONTECER")) {
			throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por valor: Previsao invalida");
		}
		
		Aposta aposta = new Aposta(apostador, valor, previsao, valorSeguro, custo, "valor");
		this.apostasNoCenario.add(aposta);
		return this.apostasNoCenario.size();
	}

	/**
	 * Metodo que cadastra uma aposta assegurada por taxa.
	 * 
	 * @param apostador
	 *            string que contem o nome do apostador.
	 * @param valor
	 *            inteiro que representa o valor da aposta.
	 * @param previsao
	 *            afirma se o cenario vai ou nao acontecer, no formato string.
	 * @param taxa
	 *            double que representa a taxa da aposta.
	 * @param custo
	 *            inteiro que representa o custo da aposta assegurada por taxa.
	 * @return um inteiro que identifica a aposta cadastrada.
	 */
	public int cadastraApostaAsseguradaPorTaxa(String apostador, int valor, String previsao, double taxa, int custo) {
		if (apostador == null) {
			throw new NullPointerException(
					"Erro no cadastro de aposta assegurada por taxa: Apostador nao pode ser vazio ou nulo");
		}
		if (apostador.trim().isEmpty()) {
			throw new IllegalArgumentException(
					"Erro no cadastro de aposta assegurada por taxa: Apostador nao pode ser vazio ou nulo");
		}
		if (valor <= 0) {
			throw new IllegalArgumentException(
					"Erro no cadastro de aposta assegurada por taxa: Valor nao pode ser menor ou igual a zero");
		}
		if (taxa <= 0) {
			throw new IllegalArgumentException(
					"Erro no cadastro de aposta assegurada por taxa: Valor do seguro nao pode ser menor ou igual a zero");
		}
		if (custo <= 0) {
			throw new IllegalArgumentException(
					"Erro no cadastro de aposta assegurada por taxa: Custo nao pode ser menor ou igual a zero");
		}
		if (previsao == null || previsao.trim().isEmpty()) {
			throw new IllegalArgumentException(
					"Erro no cadastro de aposta assegurada por taxa: Previsao nao pode ser vazia ou nula");
			
		} else if (!previsao.equals("VAI ACONTECER") && !previsao.equals("N VAI ACONTECER")) {
			throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por taxa: Previsao invalida");
		}
		
		Aposta aposta = new Aposta(apostador, valor, previsao, taxa, custo, "taxa");
		this.apostasNoCenario.add(aposta);
		return this.apostasNoCenario.size();
	}

	/**
	 * Metodo que soma e retorna o valor das apostas no cenario.
	 * 
	 * @return um inteiro que representa o valor das apostas no cenario.
	 */
	public int getValorTotalApostas() {
		int caixaCenario = 0;
		for (Aposta aposta : apostasNoCenario) {
			caixaCenario += aposta.getValorAposta();
		}
		return caixaCenario;
	}

	/**
	 * Metodo que verifica se a posta é perdedora.
	 * 
	 * @return uma string que informa se aposta eh perdedora.
	 */
	public String verificaPerdedor() {
		String apostaPerdedora;

		if (this.estado.equals("Finalizado (ocorreu)")) {
			apostaPerdedora = "N VAI ACONTECER";
		} else {
			apostaPerdedora = "VAI ACONTECER";
		}
		return apostaPerdedora;
	}

	/**
	 * Metodo que retorna o valor da soma das apostas vencedoras do cenario.
	 * 
	 * @return o valor inteiro da soma das apostas vencedoras do cenario.
	 */
	public int valorApostas() {
		int valor = 0;
		for (Aposta aposta : apostasNoCenario) {
			if (aposta.getPrevisao().equals(this.verificaPerdedor())) {
				valor += aposta.getValorAposta();
			}
		}
		return valor;
	}

	/**
	 * Metodo que retona o estado da aposta.
	 * 
	 * @return o estado da aposta no formato string.
	 */
	public String getEstado() {
		return this.estado;
	}

	/**
	 * Metodo que retorta o valor de uma aposta.
	 * 
	 * @param idAposta
	 *            inteiro identificador do cenario.
	 * @return um inteiro que contem o valor de uma aposta.
	 */
	public int getValorAposta(int idAposta) {
		return this.apostasNoCenario.get(idAposta).getValorAposta();
	}

	/**
	 * Metodo que lista as apostas do cenario.
	 * 
	 * @return uma string representando a listagem de apostas do cenario.
	 */
	public String listarApostas() {
		String stringDeApostas = "";
		for (Aposta ap : apostasNoCenario) {
			stringDeApostas += ap.toString() + "\n";
		}
		return stringDeApostas;
	}

	/**
	 * Metodo que retorna o total de apostas feitas.
	 * 
	 * @return a quantidade de apostas do cenario, no formato inteiro.
	 */
	public int totalApostas() {
		return this.apostasNoCenario.size();
	}

	/**
	 * Metodo que altera de aposta assegurada por taxa para aposta assegurada por
	 * valor.
	 * 
	 * @param apostaAssegurada
	 *            inteiro identificador da aposta a ser trocada.
	 * @param taxa
	 *            valor inteiro que representa o valor da aposta.
	 */
	public void alterarSeguroValor(int apostaAssegurada, int valor) {
		this.apostasNoCenario.get(apostaAssegurada - 1).alteraSeguroValor(valor);
	}

	/**
	 * Metodo que altera de aposta assegurada por valor para aposta assegurada por
	 * taxa.
	 * 
	 * @param apostaAssegurada
	 *            inteiro identificador da aposta a ser trocada.
	 * @param taxa
	 *            valor double que representa a taxa da aposta.
	 */
	public void alterarSeguroTaxa(int apostaAssegurada, double taxa) {
		this.apostasNoCenario.get(apostaAssegurada - 1).alteraSeguroTaxa(taxa);
	}

	/**
	 * Metodo que encerra o cenario e retorna uma string contendo o estado do
	 * cenario.
	 * 
	 * @param ocorreu
	 *            um boolean que indica se o cenario ocorreu ou nao.
	 * @return uma string contendo o estado do cenario.
	 */
	public String encerraCenario(boolean ocorreu) {
		if (ocorreu) {
			this.estado = "Finalizado (ocorreu)";
		} else {
			this.estado = "Finalizado (nao ocorreu)";
		}
		return this.estado;
	}

	/**
	 * Metodo sobrescrito do toString.
	 * 
	 * @return uma string contendo a representacao do cenario no formato: numeracao
	 *         - cenario - estado.
	 */
	@Override
	public String toString() {
		return this.numeracaoDoCenario + " - " + this.cenario + " - " + this.estado;
	}

	/**
	 * Metodo que retorna o valor zero para apostas que não possuem bonus.
	 * 
	 * @return inteiro zero.
	 */
	public int getExtra() {
		return 0;
	}

	/**
	 * Metodo hashCode sobrescrito.
	 * 
	 * @return um inteiro contendo a representacao numerica do objeto.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cenario == null) ? 0 : cenario.hashCode());
		return result;
	}

	/**
	 * Metodo equals sobrescrito que compara a descricao do cenario.
	 * 
	 * @return um boolean que indica se eh igual ou nao.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cenario other = (Cenario) obj;
		if (cenario == null) {
			if (other.cenario != null)
				return false;
		} else if (!cenario.equals(other.cenario))
			return false;
		return true;
	}

}
