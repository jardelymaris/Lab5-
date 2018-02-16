package sistemaDeApostas;

/**
 * Classe filha da classe Seguro que cria um Seguro por valor.
 * 
 * @author Jardely Maris da Silva Santos - 117110274
 *
 */
public class SeguroPorValor extends Seguro {

	/**
	 * Representacao do valor do seguro por valor, no tipo inteiro.
	 */
	private int valor;

	/**
	 * Construtor do Seguro por valor que recebe como parametro o valor da aposta e
	 * o custo.
	 * 
	 * @param custo
	 *            custo da aposta, no tipo inteiro.
	 * @param valor
	 *            valor da aposta, no tipo inteiro.
	 */
	public SeguroPorValor(int custo, int valor) throws IllegalArgumentException {
		super(custo);
		if (valor <= 0) {
			throw new IllegalArgumentException();
		}
		this.valor = valor;
	}

	/**
	 * Metodo toString sobrescrito.
	 * 
	 * @return uma string contendo as informacoes da aposta assegurada por valor.
	 */
	public String toString() {
		return " - ASSEGURADA(VALOR) - " + "R$" + this.valor + ",00";
	}

	/**
	 * Metodo sobrescrito da classe pai.
	 * 
	 * @return o valor do seguro.
	 */
	@Override
	public double valorASerRecebidoSeguro() {
		return this.valor;
	}

	/**
	 * Metodo hashCode sobrescrito.
	 * 
	 * @return um inteiro que representa o hashCode.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + valor;
		return result;
	}

	/**
	 * Metodo equals sobrescrito que compara o valor.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SeguroPorValor other = (SeguroPorValor) obj;
		if (valor != other.valor)
			return false;
		return true;
	}

}
