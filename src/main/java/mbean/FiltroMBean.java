package mbean;

import javax.faces.bean.ManagedBean;

import entity.Filtro;

import com.google.gson.Gson;
import com.google.gson.annotations.*;

@ManagedBean
public class FiltroMBean {

	private Filtro eFiltro = new Filtro();

	public Filtro geteFiltro() {
		return eFiltro;
	}

	public void seteFiltro(Filtro eFiltro) {
		this.eFiltro = eFiltro;
	}

}
