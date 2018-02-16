package sistemaDeApostas;

/**
 * Classe abstrata que cria o seguro da aposta, esse Seguro pode ser por taxa ou por valor.
 * @author Jardely Maris da Silva Santos - 117110274
 *
 */
public abstract class Seguro {

	/**
	 * Representacao do custo da aposta assegurada, no tipo inteiro.
	 */
	private int custo;
	
	/**
	 * Construtor do seguro que recebe como parametro o custo.
	 * @param custo o custo do seguro, no formato inteiro.
	 */
	public Seguro(int custo)throws IllegalArgumentException {
		if (custo <= 0) {
			throw new IllegalArgumentException();
		}
		this.custo = custo;
	}
	
	/**
	 * Metodo hashCode sobrescrito.
	 * @return inteiro que contem o hashCode.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + custo;
		return result;
	}

	/**
	 * Metodo equals sobrescrito que compara o custo.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Seguro other = (Seguro) obj;
		if (custo != other.custo)
			return false;
		return true;
	}

	/**
	 * Metodo abstrato que recebe das filhas a taxa ou valor do seguro.
	 * @return o valor ou taxa do seguro, no formato double.
	 */
	public abstract double valorASerRecebidoSeguro();
	
	/**
	 * Metodo que retorna o custo da aposta.
	 * @return o custo da aposta no frmato inteiro.
	 */
	public int getCusto() {
		return this.custo;
	}
	
	/**
	 * Metodo abstrato toString.
	 */
	public abstract String toString();
}
