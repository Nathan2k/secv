package entity;

public class GraficoSexo {

	private Integer id;
	private Integer qtd;
	private String sexo;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getQtd() {
		return qtd;
	}
	public void setQtd(Integer qtd) {
		this.qtd = qtd;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
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
