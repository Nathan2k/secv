package entity;

import java.util.List;

import service.ClasseGenerica;
import service.Experiencia;

public class Curriculo {

// RECEBO ESSE CARA
// NAO ESTA PRONTO
	private Integer id;
	private String nomeDoAluno;
	private Integer semestre;
	private ClasseGenerica curso;
	private List<Experiencia> experiencia; //
	private Integer sexo;
	private Integer deficiencia;
	private Integer nivel_ingles;
	private Integer nivel_espanhol;
	private Long idade; // COLOCAR EM M CALENDAR PRA PODER PEGAR A IDADE
	
	// lista forma�ao e experiencia

	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getSemestre() {
		return semestre;
	}

	public void setSemestre(Integer semestre) {
		this.semestre = semestre;
	}

	public ClasseGenerica getCurso() {
		return curso;
	}

	public void setCurso(ClasseGenerica curso) {
		this.curso = curso;
	}

	public String getNomeDoAluno() {
		return nomeDoAluno;
	}

	public void setNomeDoAluno(String nomeDoAluno) {
		this.nomeDoAluno = nomeDoAluno;
	}

	public List<Experiencia> getExperiencia() {
		return experiencia;
	}

	public void setExperiencia(List<Experiencia> experiencia) {
		this.experiencia = experiencia;
	}

	public Integer getSexo() {
		return sexo;
	}

	public void setSexo(Integer sexo) {
		this.sexo = sexo;
	}

	public Integer getDeficiencia() {
		return deficiencia;
	}

	public void setDeficiencia(Integer deficiencia) {
		this.deficiencia = deficiencia;
	}

	public Integer getNivel_ingles() {
		return nivel_ingles;
	}

	public void setNivel_ingles(Integer nivel_ingles) {
		this.nivel_ingles = nivel_ingles;
	}

	public Integer getNivel_espanhol() {
		return nivel_espanhol;
	}

	public void setNivel_espanhol(Integer nivel_espanhol) {
		this.nivel_espanhol = nivel_espanhol;
	}

	public Long getIdade() {
		return idade;
	}

	public void setIdade(Long idade) {
		this.idade = idade;
	}
	
	

}
