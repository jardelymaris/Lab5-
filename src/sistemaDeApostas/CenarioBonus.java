package sistemaDeApostas;

public class CenarioBonus extends Cenario {

	private int bonus;
	
	public CenarioBonus(String cenario, int idCenario, int bonus) throws NullPointerException, IllegalArgumentException {
		super(cenario, idCenario);
		this.bonus = bonus;
	}

	@Override
	public String toString() {
		return this.numeracaoDoCenario + " - " + this.cenario + " - " + this.estado + " - " + this.bonus;
	}
	
	public int getBonus() {
		return bonus;
	}
}
