package sistemaDeApostas;

import easyaccept.EasyAccept;

/**
 * Classe Facade que contem os metodos dos controllers do sistema.
 * A facade eh uma classe que tem por finalidade abstrair todo um sistema para facilitar seu uso.
 * @author Jardely Maris da Silva Santos - 117110274
 *
 */
public class Facade {
	/**
	 * Inicializando o controller.
	 */
	Controller controle = new Controller();

	/**
	 * Metodo main para realizar os testes do easyAccept.
	 * @param args os arquivos que contem os testes do easyAccept
	 */
	public static void main(String[] args) {
		args = new String[] { "sistemaDeApostas.Facade", "lib/acceptance_test/us1_test.txt",
				"lib/acceptance_test/us2_test.txt", "lib/acceptance_test/us3_test.txt",
				"lib/acceptance_test/us4_test.txt" };
		EasyAccept.main(args);
	}

	/**
	 * Metodo que inicializa o sistema.
	 * @param caixa valor inteiro que representa o valor inicial do caixa do sistema.
	 * @param taxa valor double que representa a taxa que ira ser retirada de cada aposta perdedora.
	 */
	public void inicializa(int caixa, double taxa) {
		this.controle.inicializaSistema(caixa, taxa);
	}

	/**
	 * Metodo que recupera o valor do caixa do sistema.
	 * @return um inteiro que contem o valor do caixa do sistema.
	 */
	public int getCaixa() {
		return this.controle.getCaixa();
	}

	/**
	 * Metodo que cadastra um cenario no sistema.
	 * @param descricao uma string que representa a descricao do cenario, exemplo: "Vai chover hoje".
	 * @return um inteiro que identifica o cenario cadastrado.
	 */
	public int cadastrarCenario(String descricao) {
		return this.controle.cadastrarCenario(descricao);
	}

	/**
	 * Metodo que exibe um cenario a partir do seu identificador.
	 * @param cenario numero inteiro que representa a identificacao de um cenario.
	 * @return uma string contendo as informacoes do cenario.
	 */
	public String exibirCenario(int cenario) {
		return this.controle.exibirCenario(cenario);
	}

	/**
	 * Metodo que exibe todos os cenarios cadastrados no sistema.
	 * @return uma string contendo todos os cenario do sistema.
	 */
	public String exibirCenarios() {
		return this.controle.exibirCenarios();
	}

	/**
	 * Metodo que cadastra uma aposta em um cenario.
	 * @param cenario numero inteiro que representa a identificacao de um cenario.
	 * @param apostador uma string contendo nome da pessoa que ira apostar.
	 * @param valor valor double da aposta.
	 * @param previsao o que o apostador acha sobre o cenario, se vai acontecer ou nao.
	 */
	public void cadastrarAposta(int cenario, String apostador, int valor, String previsao) {
		this.controle.cadastrarAposta(cenario, apostador, valor, previsao);
	}

	/**
	 * Metodo que retorna o valor total das apostas de um cenario.
	 * @param cenario numero inteiro que representa a identificacao de um cenario.
	 * @return um numero inteiro que representa o valor das apostas.
	 */
	public int valorTotalDeApostas(int cenario) {
		return this.controle.exibirValorTotalApostas(cenario);
	}

	/**
	 * Metodo que retorna a quantidade de apostas de um cenario.
	 * @param cenario numero inteiro que representa a identificacao de um cenario.
	 * @return um inteiro que indica a quantidade de apostas de um cenario.
	 */
	public int totalDeApostas(int cenario) {
		return this.controle.exibirTotalApostas(cenario);
	}

	/**
	 * Metodo que exibe as apostas de um cenario.
	 * @param cenario numero inteiro que representa a identificacao de um cenario.
	 * @return uma string contendo as apostas de um cenario.
	 */
	public String exibeApostas(int cenario) {
		return this.controle.exibeApostas(cenario);
	}

	/**
	 * Metodo que fecha uma aposta do sistema.
	 * @param cenario numero inteiro que representa a identificacao de um cenario.
	 * @param ocorreu um boolean que indica se o cenario que foi finalizado ocorreu ou nao.
	 */
	public void fecharAposta(int cenario, boolean ocorreu) {
		this.controle.fecharAposta(cenario, ocorreu);
	}

	/**
	 * Metodo que recupera o valor do caixa de um cenario.
	 * @param cenario numero inteiro que representa a identificacao de um cenario.
	 * @return um inteiro que representa o valor do caixa de um cenario.
	 */
	public int getCaixaCenario(int cenario) {
		return this.controle.caixaCenario(cenario);
	}

	/**
	 * Metodo que recupera o valor do rateio de uma cenario finalizado.
	 * @param cenario numero inteiro que representa a identificacao de um cenario.
	 * @return o valor inteiro do rateio.
	 */
	public int getTotalRateioCenario(int cenario) {
		return this.controle.rateioCenario(cenario);
	}
}
