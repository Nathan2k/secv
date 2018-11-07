package service;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

public class ClasseGenerica implements Converter {

	// entidade com variaveis genericas para outras entidades

	public ClasseGenerica() {

	}

	public ClasseGenerica(Integer codigo, String nome) {
		this.nome = nome;
		this.codigo = codigo;
	}

	private Integer codigo;
	private String nome;
	
	
	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		// TODO Auto-generated method stub
		return this;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		// TODO Auto-generated method stub
		return this.nome;
	}
	
	
}
	

	


