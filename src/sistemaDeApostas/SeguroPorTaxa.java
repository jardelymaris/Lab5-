package sistemaDeApostas;

public class SeguroPorTaxa extends Seguro{

	private double taxa;
	
	public SeguroPorTaxa(int custo, double taxa) {
		super(custo);
		this.taxa = taxa;
	}

	public double getTaxa() {
		return this.taxa;
	}
	
	public String toString() {
		return "- ASSEGURADA (TAXA) - " + this.taxa;
	}

}
