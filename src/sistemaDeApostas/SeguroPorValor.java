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
	public SeguroPorValor(int custo, int valor) {
		super(custo);
		this.valor = valor;
	}

	/**
	 * Metodo toString sobrescrito.
	 * 
	 * @return uma string contendo as informacoes da aposta assegurada por valor.
	 */
	public String toString() {
		return " - ASSEGURADA(VALOR) - " + "R$"+ this.valor +",00";
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

}
