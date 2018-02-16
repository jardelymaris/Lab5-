package sistemaDeApostas;

import java.util.Comparator;

/**
 * Classe que que possui o metodo que implementa o Comparator, comparando
 * cenarios pela quantidade de apostas.
 * 
 * @author Jardely Maris da Silva Santos - 117110274
 *
 */
public class ApostasComparator implements Comparator<Cenario> {

	/**
	 * Metodo que implementa o compare, comparando os cenarios pelo quantidade de
	 * apostas.
	 * 
	 * @return um inteiro que indica se é maior, menor ou se são iguais.
	 */
	@Override
	public int compare(Cenario c1, Cenario c2) {
		if (c2.getQtdApostasCenario() < c1.getQtdApostasCenario()) {
			return -1;
		}
		if (c2.getQtdApostasCenario() > c1.getQtdApostasCenario()) {
			return 1;
		}
		return c1.getNumeracaoDoCenario() - c2.getNumeracaoDoCenario();
	}
}
