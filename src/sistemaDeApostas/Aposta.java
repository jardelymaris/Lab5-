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

	private String nomeApostador;
	private int valorAposta;
	private String previsao;
	private DecimalFormat df = new DecimalFormat("0.00");
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
		if (nome.equals("") || nome.equals("  ")) {
			throw new IllegalArgumentException("Erro no cadastro de aposta: Apostador nao pode ser vazio ou nulo");
		}
		if (valor <= 0) {
			throw new IllegalArgumentException("Erro no cadastro de aposta: Valor nao pode ser menor ou igual a zero");
		}

		if (previsao == null || previsao.equals("") || previsao.equals("   ")) {
			throw new IllegalArgumentException("Erro no cadastro de aposta: Previsao nao pode ser vazia ou nula");
		} else if (!previsao.equals("VAI ACONTECER") && !previsao.equals("N VAI ACONTECER")) {
			throw new IllegalArgumentException("Erro no cadastro de aposta: Previsao invalida");
		}
		this.nomeApostador = nome;
		this.valorAposta = valor;
		this.previsao = previsao;
	}

	public Aposta(String nome, int valor, String previsao, double valorSeguro, int custo, String tipo) {
		this(nome, valor, previsao);
		if (tipo.equals("valor")) {
			this.seguro = new SeguroPorValor(custo, (int) valorSeguro);

		}
		if (tipo.equals("taxa")) {
			this.seguro = new SeguroPorTaxa(custo, valorSeguro);

		}

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
		return this.nomeApostador + " - R$" + df.format(this.valorAposta / 100.00) + " - " + this.previsao;
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
