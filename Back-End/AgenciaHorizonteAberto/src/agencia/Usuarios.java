package agencia;

public class Usuarios {

	// Atributos

	private int idUsuario;
	private String nome;
	private String endereco;
	private String email;
	private String senha;

	// Método construtor
	
	
	
	public Usuarios(int idUsuario, String nome, String endereco, String email, String senha) {
		super();
		this.idUsuario = idUsuario;
		this.nome = nome;
		this.endereco = endereco;
		this.email = email;
		this.senha = senha;
	}

	
	public Usuarios() {
	}

	// Métodos getters and setters

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	

}
