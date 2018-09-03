package entity;

public class Filtro {

	private Integer id;
	private String nome;
	private String vaga;
	private String curso;
	private Integer semestre;
	private Integer candidatos;
	private Integer qtdVagas;
	private String cidade;
	
	
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
	public String getVaga() {
		return vaga;
	}
	public void setVaga(String vaga) {
		this.vaga = vaga;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public Integer getSemestre() {
		return semestre;
	}
	public void setSemestre(Integer semestre) {
		this.semestre = semestre;
	}
	public Integer getCandidatos() {
		return candidatos;
	}
	public void setCandidatos(Integer candidatos) {
		this.candidatos = candidatos;
	}
	public Integer getQtdVagas() {
		return qtdVagas;
	}
	public void setQtdVagas(Integer qtdVagas) {
		this.qtdVagas = qtdVagas;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
}
