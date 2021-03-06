package sistemaDeApostas;

/**
 * Classe filha de Seguro que contem metodos e acoes de um seguro por taxa.
 * 
 * @author Jardely Maris da Silva Santos - 117110274
 *
 */
public class SeguroPorTaxa extends Seguro {

	/**
	 * Representacao da taxa da aposta assegurada por taxa.
	 */
	private double taxa;

	/**
	 * Construtor do seguro por taxa que recebe como parametros o custo e a taxa.
	 * 
	 * @param custo
	 *            o custo do seguro, no formato inteiro.
	 * @param taxa
	 *            a taxa da aposta assegurada por taxa, no formato double.
	 */
	public SeguroPorTaxa(int custo, double taxa) throws IllegalArgumentException {
		super(custo);
		if (taxa <= 0) {
			throw new IllegalArgumentException();
		}
		this.taxa = taxa;
	}

	/**
	 * Metodo toString sobrescrito.
	 * 
	 * @return uma string contendo as informacoes do seguro por taxa.
	 */
	public String toString() {
		return " - ASSEGURADA(TAXA) - " + (int) (this.taxa * 100) + "%";
	}

	/**
	 * Metodo sobrescrito da classe pai.
	 * 
	 * @return a taxa do seguro.
	 */
	@Override
	public double valorASerRecebidoSeguro() {
		return this.taxa;
	}

	/**
	 * Metodo hashCode sobrescrito.
	 * 
	 * @return inteiro que representa o hashCode.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(taxa);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	/**
	 * Metodo equals sobrescrito que compara a taxa.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SeguroPorTaxa other = (SeguroPorTaxa) obj;
		if (Double.doubleToLongBits(taxa) != Double.doubleToLongBits(other.taxa))
			return false;
		return true;
	}
}
