package sistemaDeApostas;

import java.text.DecimalFormat;

/**
 * Classe filha da classe Cenario, que contem metodos e acoes de um cenario com
 * bonus.
 * 
 * @author Jardely Maris da Silva Santos - 117110274
 *
 */
public class CenarioBonus extends Cenario {

	/**
	 * Representacao do bonus do cenario, no tipo inteiro.
	 */
	private int bonus;
	/**
	 * Objeto do DecimalFormat para representar um numero com duas casas decimais.
	 */
	private DecimalFormat df = new DecimalFormat("0.00");

	/**
	 * Construtor do cenario com bonus que recebe como parametros o cenario, o
	 * identificador do cenario e o bonus, e lanca uma excecao sempre que o bonus
	 * for passado de forma inadequada.
	 * 
	 * @param cenario
	 *            descricao do cenario, no formato String.
	 * @param idCenario
	 *            identificador do cenario, no formato inteiro.
	 * @param bonus
	 *            valor do bonus do cenario, no formato inteiro.
	 * @throws IllegalArgumentException
	 *             excecao lancada sempre que o bonus passado for menor ou igual a
	 *             zero.
	 */
	public CenarioBonus(String cenario, int idCenario, int bonus) throws IllegalArgumentException {
		super(cenario, idCenario);
		if (bonus <= 0) {
			throw new IllegalArgumentException("Erro no cadastro de cenario: Bonus invalido");
		}
		this.bonus = bonus;
	}

	/**
	 * Metodo to String que retorna a representacao textual do cenario bonus.
	 * 
	 * @return uma String contendo as informacoes do cenario bonus.
	 */
	@Override
	public String toString() {
		return this.numeracaoDoCenario + " - " + this.cenario + " - " + this.estado + " - R$ "
				+ df.format(this.bonus / 100);
	}

	/**
	 * Metodo que retorna o bonus do cenario.
	 * 
	 * @return o valor do bonus no tipo inteiro.
	 */
	public int getExtra() {
		return bonus;
	}

	/**
	 * Metodo equals sobrescrito que compara o bonus.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + bonus;
		return result;
	}

	/**
	 * Metodo que retorna um inteiro representando o hashCode do objeto.
	 * 
	 * @return inteiro que representa o hashCode
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		CenarioBonus other = (CenarioBonus) obj;
		if (bonus != other.bonus)
			return false;
		return true;
	}
}
