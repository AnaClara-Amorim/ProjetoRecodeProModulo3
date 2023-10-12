package agencia;

public class Pacotes {

	// Atributos
	
	private int idPacote;
	private String destino;
	private double preco;
	private String promocao;
	
	// Método construtor
	
		public Pacotes() {
		}		
			

		public Pacotes(int idPacote, String destino, double preco, String promocao) {
		super();
		this.idPacote = idPacote;
		this.destino = destino;
		this.preco = preco;
		this.promocao = promocao;
	}

		
		// Métodos getters and setters
		
		public int getIdPacote() {
			return idPacote;
		}

		public void setIdPacote(int idPacote) {
			this.idPacote = idPacote;
		}

		public String getDestino() {
			return destino;
		}

		public void setDestino(String destino) {
			this.destino = destino;
		}

		public double getPreco() {
			return preco;
		}

		public void setPreco(double preco) {
			this.preco = preco;
		}

		public String getPromocao() {
			return promocao;
		}

		public void setPromocao(String promocao) {
			this.promocao = promocao;
		}		
		
}
