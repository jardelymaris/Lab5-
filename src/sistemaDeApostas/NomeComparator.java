package sistemaDeApostas;

import java.util.Comparator;

/**
 * Classe que possui o metodo que implementa o Comparator, comparando cenarios pelo nome.
 * @author Jardely Maris da Silva Santos - 117110274
 *
 */
public class NomeComparator implements Comparator<Cenario> {

	/**
	 * Metodo que implementa o compare, comparando os cenarios pelo nome do cenario.
	 * @return um inteiro que indica se é maior, menor ou se são iguais.
	 */
	@Override
	public int compare(Cenario c1, Cenario c2) {
		return c1.getCenario().compareTo(c2.getCenario());
	}

}
