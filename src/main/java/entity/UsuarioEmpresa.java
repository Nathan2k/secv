package entity;

public class UsuarioEmpresa extends Usuario {

	private String CNPJ;
	private String representante;
	private String rua;
	private String bairro;
	private String cidade;
	private Cidade cidadeE;
	private String estado; 
	
	
	
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getCNPJ() {
		return CNPJ;
	}
	public void setCNPJ(String cNPJ) {
		CNPJ = cNPJ;
	}
	public String getRepresentante() {
		return representante;
	}
	public void setRepresentante(String representante) {
		this.representante = representante;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public Cidade getCidadeE() {
		return cidadeE;
	}
	public void setCidadeE(Cidade cidadeE) {
		this.cidadeE = cidadeE;
	}
	
	
}

