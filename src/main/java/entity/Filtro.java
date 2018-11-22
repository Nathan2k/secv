package entity;

import java.util.ArrayList;
import java.util.List;

public class Filtro {

	private String nomeFiltro;
	private Integer id;
	private Integer idEmpresa;
	private Integer idAdm;
	private String idCurso; // vai
	private Integer semestre; // vai
	private List<String> idCidade; // vai
	private Integer experiencia; // 0=indiferente 1=SIM 2= NÃO
	private String sexo; // vai 0=indiferente 1=MACHO 2= MULHER
	private Integer qualIdioma;// vai 0=indiferente 1=INGLES 2= ESPANHOL
	private String deficiencia;// vai 0=indiferente 1=SIM 2= NÃO
	private Integer idade_inicio;
	private Integer idade_fim; // VER SE JA DA PRA SETAR O 18 E 40 AQUI PRA PODER MANDAR ELES DIRETO
	private Integer idEstado;
	private String area;

	public Integer getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(Integer idEstado) {
		this.idEstado = idEstado;
	}

	public Integer getIdAdm() {
		return idAdm;
	}

	public void setIdAdm(Integer idAdm) {
		this.idAdm = idAdm;
	}

	public Integer getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(Integer idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(String idCurso) {
		this.idCurso = idCurso;
	}

	public Integer getSemestre() {
		return semestre;
	}

	public String getNomeFiltro() {
		return nomeFiltro;
	}

	public void setNomeFiltro(String nomeFiltro) {
		this.nomeFiltro = nomeFiltro;
	}

	public Integer getIdade_inicio() {
		return idade_inicio;
	}

	public void setIdade_inicio(Integer idade_inicio) {
		this.idade_inicio = idade_inicio;
	}

	public Integer getIdade_fim() {
		return idade_fim;
	}

	public void setIdade_fim(Integer idade_fim) {
		this.idade_fim = idade_fim;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public void setSemestre(Integer semestre) {
		this.semestre = semestre;
	}

	public Integer getExperiencia() {
		return experiencia;
	}

	public void setExperiencia(Integer experiencia) {
		this.experiencia = experiencia;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Integer getQualIdioma() {
		return qualIdioma;
	}

	public void setQualIdioma(Integer qualIdioma) {
		this.qualIdioma = qualIdioma;
	}

	public String getDeficiencia() {
		return deficiencia;
	}

	public void setDeficiencia(String deficiencia) {
		this.deficiencia = deficiencia;
	}

	public List<String> getIdCidade() {
		return idCidade;
	}

	public void setIdCidade(List<String> idCidade) {
		this.idCidade = idCidade;
	}
	
	
	
	
	public String getSexoNome() {
		String genero;

		if (this.sexo.equals("0")) {
			genero = "Indiferente";
			return genero;
		}
		if (this.sexo.equals("1")) {
			genero = "Homem";
			return genero;
		} else if (this.sexo.equals("2")) {
			genero = "Mulher";
			return genero;
		}
		return null;
	}

}
