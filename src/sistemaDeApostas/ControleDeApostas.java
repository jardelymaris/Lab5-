package sistemaDeApostas;

import java.util.ArrayList;
import java.util.HashMap;

public class ControleDeApostas {

	private ArrayList<Cenario> cenarios;
	private int caixa;
	private double taxa;

	public int getCaixa() {
		return this.caixa;
	}

	public ControleDeApostas(int caixa, double taxa) {
		this.cenarios = new ArrayList<>();
		this.caixa = caixa;
		this.taxa = taxa;
	}

	public int cadastrarCenario(String descricao) {
		for (Cenario cenario : cenarios) {
			if (!cenario.equals(descricao)) {
				Cenario cenarioAdd = new Cenario(descricao);
				this.cenarios.add(cenarioAdd);
			}
		}
		return cenarios.size() + 1;
	}

	public String exibirCenario(int cenario) {
		return cenario + " - " + this.cenarios.get(cenario).toString();
	}

	public String exibirCenarios() {
		String stringCenarios = "";
		int contadorAuxiliar = 1;
		for (Cenario cenario : this.cenarios) {
			stringCenarios += contadorAuxiliar + " - " + cenario.toString() + "\n";
			contadorAuxiliar++;
		}
		return stringCenarios;
	}

	public void fecharAposta(int cenario, boolean ocorreu) {
		this.cenarios.get(cenario).encerraCenario(ocorreu);
	}

	public void cadastrarAposta(int cenario, String nome, int valor, String previsao) {
		this.cenarios.get(cenario).cadastraAposta(nome, valor, previsao);
	}

	public int exibirValorTotalApostas(int cenario) {
		return this.cenarios.get(cenario).getValorApostas();
	}

	public int exibirTotalApostas(int cenario) {
		return this.cenarios.get(cenario).totalApostas();
	}

	public String exibeApostas(int cenario) {
		return this.cenarios.get(cenario).listarApostas();
	}

	public int caixaCenario(int cenario) {
		return (int) (this.cenarios.get(cenario).getValorApostas() * this.taxa);
	}

	public int rateioCenario(int cenario) {
		this.caixa += this.cenarios.get(cenario).getValorApostas() * this.taxa;
		return (int) (this.cenarios.get(cenario).getValorApostas()
				- this.cenarios.get(cenario).getValorApostas() * this.taxa);
	}
}
