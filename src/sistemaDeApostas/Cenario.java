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

	private String cenario;
	private ArrayList<Aposta> apostasNoCenario;
	private String estado;
	private int numeracaoDoCenario;

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
		if (cenario.equals("")) {
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
	 * Metodo que retorna o valor da soma das apostas vencedoras do cenario.
	 * 
	 * @return o valor inteiro da soma das apostas vencedoras do cenario.
	 */
	public int valorApostas() {
		String apostaPerdedora;

		if (this.estado.equals("Finalizado (ocorreu)")) {
			apostaPerdedora = "N VAI ACONTECER";
		} else {
			apostaPerdedora = "VAI ACONTECER";
		}
		int valor = 0;
		for (Aposta aposta : apostasNoCenario) {
			if (aposta.getPrevisao().equals(apostaPerdedora)) {
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
