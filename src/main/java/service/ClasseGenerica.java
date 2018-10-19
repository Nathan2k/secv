package service;

public class ClasseGenerica {

	// entidade com variaveis genericas para outras entidades

	public ClasseGenerica() {

	}

	public ClasseGenerica(Integer id, String nome) {
		this.nome = nome;
		this.id = id;
	}

	private Integer id;
	private String nome;

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

}
