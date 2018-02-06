package sistemaDeApostas;

public class SeguroPorValor extends Seguro{

	private int valor;
	
	public SeguroPorValor(int custo, int valor) {
		super(custo);
		this.valor = valor;
	}
	
	public int getValor() {
		return this.valor;
	}

	public String toString() {
		return "- ASSEGURADA (VALOR) - " + this.valor;
	}
	
	

	


	
	

}
