package entity;

public class Usuario {

	private Integer id;
	private String nome;
	private String senha;
	private String email;
	private String telefone;
	private String nomex;

	public Usuario() {

	}

	public Usuario(Integer id, String nome, String senha, String email, String telefone, String nomex) {
		super();
		this.id = id;
		this.nome = nome;
		this.senha = senha;
		this.email = email;
		this.telefone = telefone;
		this.nomex = nomex;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		
		return nome;
	}

	public void setNome(String nome) {
		nome = nome.trim();
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getNomex() {
		return nomex;
	}

	public void setNomex(String nomex) {
		this.nomex = nomex;
	}

}
