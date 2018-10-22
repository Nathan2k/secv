package entity;

import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.List;

import service.Experiencia;

public class Curriculo {

// RECEBO ESSE CARA
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

		//ta errado
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(idade);

		// LocalDate TESTE =LocalDate.

	}

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

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
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
