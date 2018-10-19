package entity;

import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.List;

import service.Experiencia;

public class Curriculo {
// NAO ESTA PRONTO
	private Integer id;
	private String nomeDoAluno;
	private Integer semestre;
	private String curso;
	private List<Experiencia> experiencia; //

	private Integer sexo;

	private Integer deficiencia;

	private Integer nivel_ingles;
	private Integer nivel_espanhol;
	private Long idade; // COLOCAR EM M CALENDAR PRA PODER PEGAR A IDADE
	private String estado; // entidade estado
	private String cidade; // tira

	// lista formaçao e experiencia
	
	
	public void calendario() {
		
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(idade);
		
		LocalDate TESTE =LocalDate.
		
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
		this.nome = nome;
	}

	public Integer getSemestre() {
		return semestre;
	}

	public void setSemestre(Integer semestre) {
		this.semestre = semestre;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getTurma() {
		return turma;
	}

	public void setTurma(String turma) {
		this.turma = turma;
	}

	public boolean isExperiencia() {
		return experiencia;
	}

	public void setExperiencia(boolean experiencia) {
		this.experiencia = experiencia;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public boolean isDeficiencia() {
		return deficiencia;
	}

	public void setDeficiencia(boolean deficiencia) {
		this.deficiencia = deficiencia;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public String getIdade() {
		return idade;
	}

	public void setIdade(String idade) {
		this.idade = idade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

}
