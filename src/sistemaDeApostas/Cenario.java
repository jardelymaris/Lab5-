package sistemaDeApostas;

import java.util.ArrayList;

public class Cenario {

	private String cenario;
	private ArrayList<Aposta> apostasNoCenario;
	private String estado;
	private int valorApostas;

	public Cenario(String cenario) throws NullPointerException, IllegalArgumentException {
		if (cenario == null) {
			throw new NullPointerException();
		}
		if (cenario.equals("")) {
			throw new IllegalArgumentException();
		}
		this.apostasNoCenario = new ArrayList<>();
		this.cenario = cenario;
		this.estado = "Nao finalizado";
		this.valorApostas = 0;
	}

	public boolean cadastraAposta(String nome, int valor, String previsao) {
		Aposta aposta = new Aposta(nome, valor, previsao);
		this.valorApostas += valor;
		return apostasNoCenario.add(aposta);
	}

	public int getValorApostas() {
		return this.valorApostas;
	}

	public String listarApostas() {
		String stringDeApostas = "";
		for (Aposta ap : apostasNoCenario) {
			stringDeApostas += ap.toString() + "\n";
		}
		return stringDeApostas;
	}

	public int totalApostas() {
		return this.apostasNoCenario.size();
	}

	public String encerraCenario(boolean ocorreu) {
		if (ocorreu) {
			this.estado = "Finalizado (ocorreu)";
		} else {
			this.estado = "Finalizado (nao ocorreu)";
		}
		return this.estado;
	}

	@Override
	public String toString() {
		return this.cenario + " - " + this.estado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cenario == null) ? 0 : cenario.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cenario other = (Cenario) obj;
		if (cenario == null) {
			if (other.cenario != null)
				return false;
		} else if (!cenario.equals(other.cenario))
			return false;
		return true;
	}

}
