package entity;



public class UsuarioADM {

	private Integer id;
	private String nome;
	private String senha;
	private String email;
	private Integer telefone;
	private Integer NIF;
	
	
	
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
	public Integer getTelefone() {
		return telefone;
	}
	public void setTelefone(Integer telefone) {
		this.telefone = telefone;
	}
	public Integer getNIF() {
		return NIF;
	}
	public void setNIF(Integer nIF) {
		NIF = nIF;
	}

}
