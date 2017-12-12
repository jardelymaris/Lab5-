package sistemaDeApostas;

public class Aposta {
	
	private String nomeApostador;
	private int valorAposta;
	private String previsao;
	
	public Aposta(String nome, int valor, String previsao) {
		this.nomeApostador = nome;
		this.valorAposta = valor;
		this.previsao = previsao;
	}
	
	public String previsao() {
		return this.previsao;
	}
	
	@Override
	public String toString() {
		return this.nomeApostador + " - R$" + this.valorAposta / 100.00 + " - " + this.previsao; 
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
