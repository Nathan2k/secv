package service;

import java.util.Calendar;

public class Formacao {

	public Formacao() {
	}

	public Formacao(Integer id, String nome, Calendar data_inicio, Calendar data_fim, String escola,
			Integer id_curriculum_vitae) {

		this.id = id;
		this.nome = nome;
		this.escola = escola;
		this.id_curriculum_vitae = id_curriculum_vitae;
	}

	private Integer id;
	private String nome; //esse � o nome do curso!
	private Long data_inicio;
	private Long data_fim;
	private String escola;
	private Integer id_curriculum_vitae;

	public String getEscola() {
		return escola;
	}

	public void setEscola(String escola) {
		this.escola = escola;
	}

	public Integer getId_curriculum_vitae() {
		return id_curriculum_vitae;
	}

	public void setId_curriculum_vitae(Integer id_curriculum_vitae) {
		this.id_curriculum_vitae = id_curriculum_vitae;
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

	public Long getData_inicio() {
		return data_inicio;
	}

	public void setData_inicio(Long data_inicio) {
		this.data_inicio = data_inicio;
	}

	public Long getData_fim() {
		return data_fim;
	}

	public void setData_fim(Long data_fim) {
		this.data_fim = data_fim;
	}

}
