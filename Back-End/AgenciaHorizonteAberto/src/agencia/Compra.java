package agencia;

public class Compra {
	private Usuarios usuarios;
	private Pacotes pacotes;
	private int idCompra;
	
	public Compra() {};
	
	public Compra(Usuarios usuarios, Pacotes pacotes, int idCompra) {
		super();
		this.usuarios = usuarios;
		this.pacotes = pacotes;
		this.idCompra = idCompra;
	}
	

	public int getIdCompra() {
		return idCompra;
	}

	public void setIdCompra(int idCompra) {
		this.idCompra = idCompra;
	}

	public Usuarios getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Usuarios usuarios) {
		this.usuarios = usuarios;
	}

	public Pacotes getPacotes() {
		return pacotes;
	}

	public void setPacotes(Pacotes pacotes) {
		this.pacotes = pacotes;
	};	
	
	

}
