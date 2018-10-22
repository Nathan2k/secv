package mbean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import entity.Filtro;
import service.ClasseGenerica;
import utils.FiltroService;

import com.google.gson.Gson;
import com.google.gson.annotations.*;

@ManagedBean
public class FiltroMBean {

	private Filtro eFiltro = new Filtro();

	List<ClasseGenerica> estado = new ArrayList<>();
	List<ClasseGenerica> cidades = new ArrayList<>();
	List<ClasseGenerica> area = new ArrayList<>();
	List<ClasseGenerica> curso = new ArrayList<>();
	List<ClasseGenerica> semestre = new ArrayList<>();
	List<ClasseGenerica> idioma = new ArrayList<>();
	
	List<ClasseGenerica> selCidade = new ArrayList<>();
	ClasseGenerica selArea = new ClasseGenerica();
	
	
	
	FiltroService fs = new FiltroService();

	public FiltroMBean() {

		try {
			cidades = fs.cCidade();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public Filtro geteFiltro() {
		return eFiltro;
	}

	public void seteFiltro(Filtro eFiltro) {
		this.eFiltro = eFiltro;
	}

}

