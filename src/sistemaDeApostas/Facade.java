package sistemaDeApostas;

public class Facade {

	private ControleDeApostas controle;

	public void inicializa(int caixa, double taxa) {
		this.controle = new ControleDeApostas(caixa, taxa);
	}

	public int getCaixa() {
		return this.controle.getCaixa();
	}

	public int cadastrarCenario(String descricao) {
		return this.controle.cadastrarCenario(descricao);
	}

	public String exibirCenario(int cenario) {
		return this.controle.exibirCenario(cenario);
	}

	public String exibirCenarios() {
		return this.controle.exibirCenarios();
	}

	public void cadastrarAposta(int cenario, String apostador, int valor, String previsao) {
		this.controle.cadastrarAposta(cenario, apostador, valor, previsao);
	}

	public int valorTotalDeApostas(int cenario) {
		return this.controle.exibirValorTotalApostas(cenario);
	}

	public int totalDeApostas(int cenario) {
		return this.controle.exibirTotalApostas(cenario);
	}

	public String exibeApostas(int cenario) {
		return this.controle.exibeApostas(cenario);
	}

	public void fecharAposta(int cenario, boolean ocorreu) {
		this.controle.fecharAposta(cenario, ocorreu);
	}

	public int getCaixaCenario(int cenario) {
		return this.controle.caixaCenario(cenario);
	}

	public int getTotalRateioCenario(int cenario) {
		return this.controle.rateioCenario(cenario);
	}
}
