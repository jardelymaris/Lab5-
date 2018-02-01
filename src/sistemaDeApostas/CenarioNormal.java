package sistemaDeApostas;

public class CenarioNormal extends Cenario {

	public CenarioNormal(String cenario, int idCenario) throws NullPointerException, IllegalArgumentException {
		super(cenario, idCenario);
		
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
	
	public int getBonus() {
		return 0;
	}

}
