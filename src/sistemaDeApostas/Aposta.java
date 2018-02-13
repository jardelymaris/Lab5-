package sistemaDeApostas;

import java.text.DecimalFormat;

/**
 * Classe Aposta que cria uma aposta contendo o nome do apostador, valor da
 * aposta, e uma previsao.
 * 
 * @author Jardely Maris da Silva Santos - 117110274
 *
 */
public class Aposta {

	/**
	 * Representacao do nome do apostador, no formato string.
	 */
	private String nomeApostador;

	/**
	 * Representacao do valor da aposta no formato inteiro.
	 */
	private int valorAposta;
	/**
	 * Representacao da previsao do apostador, no formato string.
	 */
	private String previsao;

	/**
	 * Objeto DecimalFormat para deixar numros com duas casas decimais.
	 */
	private DecimalFormat df = new DecimalFormat("0.00");

	/**
	 * Representacao do seguro no formato Seguro.
	 */
	private Seguro seguro;

	/**
	 * Construtor de Aposta que recebe nome do apostador, valor e previsao, e lanca
	 * excecao sempre quando algum parametro for passado de forma inadequada.
	 * 
	 * @param nome
	 *            nome do apostador no formato String.
	 * @param valor
	 *            valor da aposta em centavos, no formato inteiro.
	 * @param previsao
	 *            eh a previsao que ou a aposta vai acontecer ou nao.
	 * @throws NullPointerException
	 *             eh lancado quando o nome ou previsao eh nulo
	 * @throws IllegalArgumentException
	 *             eh lancado quando nome, valor ou previsao eh passado de forma
	 *             inadequada.
	 */
	public Aposta(String nome, int valor, String previsao) throws NullPointerException, IllegalArgumentException {
		if (nome == null) {
			throw new NullPointerException("Erro no cadastro de aposta: Apostador nao pode ser vazio ou nulo");
		}
		if (nome.trim().isEmpty()) {
			throw new IllegalArgumentException("Erro no cadastro de aposta: Apostador nao pode ser vazio ou nulo");
		}
		if (valor <= 0) {
			throw new IllegalArgumentException("Erro no cadastro de aposta: Valor nao pode ser menor ou igual a zero");
		}

		if (previsao == null || previsao.trim().isEmpty()) {
			throw new IllegalArgumentException("Erro no cadastro de aposta: Previsao nao pode ser vazia ou nula");
			
		} else if (!previsao.equals("VAI ACONTECER") && !previsao.equals("N VAI ACONTECER")) {
			throw new IllegalArgumentException("Erro no cadastro de aposta: Previsao invalida");
		}
		this.nomeApostador = nome;
		this.valorAposta = valor;
		this.previsao = previsao;
	}

	/**
	 * Construtor de Aposta que recebe nome do apostador, valor, previsao, valor do
	 * seguro, custo do seguro e tipo do seguro, e lanca excecao sempre quando algum
	 * parametro for passado de forma inadequada.
	 * 
	 * @param nome
	 *            nome do apostador no formato String.
	 * @param valor
	 *            valor da aposta em centavos, no formato inteiro.
	 * @param previsao
	 *            eh a previsao que ou a aposta vai acontecer ou nao.
	 * @param valorSeguro
	 *            valor do seguro que pode ser a taxa ou valor, dependendo do tipo
	 *            do seguro, no formato double.
	 * @param custo
	 *            o cuto do seguro, no formato inteiro.
	 * @param tipo
	 *            o tipo do seguro, taxa ou valor, no formato string.
	 * @throws NullPointerException
	 *             eh lancado quando o nome ou previsao eh nulo
	 * @throws IllegalArgumentException
	 *             eh lancado quando nome, valor ou previsao eh passado de forma
	 *             inadequada.
	 */
	public Aposta(String nome, int valor, String previsao, double valorSeguro, int custo, String tipo) {
		this.nomeApostador = nome;
		this.valorAposta = valor;
		this.previsao = previsao;
		
		if (tipo.equals("valor")) {
			if (valorSeguro <= 0) {
				throw new IllegalArgumentException(
						"Erro no cadastro de aposta assegurada por valor: Valor nao pode ser menor ou igual a zero");
			}
			this.seguro = new SeguroPorValor(custo, (int) valorSeguro);
		}
		if (tipo.equals("taxa")) {
			this.seguro = new SeguroPorTaxa(custo, valorSeguro);
		}
	}

	/**
	 * Metodo que altera o seguro da aposta de seguro por taxa para seguro por
	 * valor.
	 * 
	 * @param valor
	 *            valor do seguro da aposta, no formato inteiro.
	 */
	public void alteraSeguroValor(int valor) {
		Seguro seg = new SeguroPorValor(this.seguro.getCusto(), valor);
		this.seguro = seg;
	}

	/**
	 * Metodo que altera o seguro da aposta de seguro por valor para seguro por
	 * taxa.
	 * 
	 * @param taxa
	 *            a taxa do seguro da aposta, no formato double.
	 */
	public void alteraSeguroTaxa(double taxa) {
		Seguro seg = new SeguroPorTaxa(this.seguro.getCusto(), taxa);
		this.seguro = seg;
	}

	/**
	 * Metodo que retorna o valor da aposta.
	 * 
	 * @return o valor da aposta na representacao inteira
	 */
	public int getValorAposta() {
		return this.valorAposta;
	}

	/**
	 * Metodo que retorna a previsa da aposta.
	 * 
	 * @return uma string que contem a previsao.
	 */
	public String getPrevisao() {
		return this.previsao;
	}

	/**
	 * Metodo que retorna uma string contendo as informacoes da aposta.
	 * 
	 * @return uma string que contem a representacao da aposta, no formato: nome -
	 *         R$valor - previsao.
	 */
	@Override
	public String toString() {
		if (this.seguro == null) {
			return this.nomeApostador + " - R$" + df.format(this.valorAposta / 100.00) + " - " + this.previsao;
		}
		return this.nomeApostador + " - R$" + df.format(this.valorAposta / 100.00) + " - " + this.previsao + this.seguro.toString();
	}

	/**
	 * Metodo que retorna um inteiro representando o hashCode do objeto.
	 * 
	 * @return inteiro que representa o hashCode
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((previsao == null) ? 0 : previsao.hashCode());
		return result;
	}

	/**
	 * Metodo equals sobrescrito que compara a previsao
	 * 
	 * @return um boolean que define se eh igual ou nao.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aposta other = (Aposta) obj;
		if (previsao == null) {
			if (other.previsao != null)
				return false;
		} else if (!previsao.equals(other.previsao))
			return false;
		return true;
	}

}
