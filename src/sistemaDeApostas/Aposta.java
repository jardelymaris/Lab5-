package sistemaDeApostas;

import java.text.DecimalFormat;

public class Aposta {

	private String nomeApostador;
	private int valorAposta;
	private String previsao;
	private DecimalFormat df = new DecimalFormat("0.00");

	public Aposta(String nome, int valor, String previsao) throws NullPointerException, IllegalArgumentException {
		if (nome == null || previsao == null) {
			throw new NullPointerException();
		}
		if (nome.equals("") || valor <= 0 || previsao.equals("")) {
			throw new IllegalArgumentException();
		}
		this.nomeApostador = nome;
		this.valorAposta = valor;
		this.previsao = previsao;
	}

	@Override
	public String toString() {
		return this.nomeApostador + " - R$" + df.format(this.valorAposta / 100.00) + " - " + this.previsao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((previsao == null) ? 0 : previsao.hashCode());
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
		Aposta other = (Aposta) obj;
		if (previsao == null) {
			if (other.previsao != null)
				return false;
		} else if (!previsao.equals(other.previsao))
			return false;
		return true;
	}

}
