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
	private String estado;
	private boolean experiencia;
	private String sexo;
	private String idioma;
	private String area;
	private String deficiencia;
	
	
	
	
	public String getDeficiencia() {
		return deficiencia;
	}

	public void setDeficiencia(String deficiencia) {
		this.deficiencia = deficiencia;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
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
	
	public boolean isExperiencia() {
		return experiencia;
	}

	public void setExperiencia(boolean experiencia) {
		this.experiencia = experiencia;
	}
	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}
	

	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();
		
		sb.append("Filtro");
		sb.append("ID = "+getId());
		sb.append("Nome = "+getNome());
		sb.append("Experiencia = "+isExperiencia());
		sb.append("Sexo = "+getSexo());
		sb.append("Deficiencia = ");
		sb.append("Idioma = "+getIdioma());
		sb.append("Faixa Etaria Inicio = ");
		sb.append("Faixa Etaria Fim = ");
		sb.append("Cidade = "+getCidade());
		sb.append("Estado = "+getEstado());
		sb.append("Area = "+getArea());
		sb.append("Curso = "+getArea());
		sb.append("Semestre = "+getSemestre());
		

		// TODO Auto-generated method stub
		return sb.toString();
	}

	
	
	
}
