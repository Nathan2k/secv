package mbean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import entity.Curriculo;
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
	
	boolean filtroP = false;
	
	FiltroService fs = new FiltroService();
	
	
	

	


	public FiltroMBean() {
		
		try {
			cidades = fs.cCidade();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void attArea(){
		try {
			area = fs.cArea(eFiltro);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	public void enviarFiltro() throws IOException {
		System.out.println("sim");
		List<Curriculo> curriculos = fs.enviarFiltro(eFiltro);
		
		if(curriculos == null) {
			//colocar mensagem falando que deu um erro no filtro.
			if(curriculos.isEmpty()) {
				//colocar mensagem falando que nenhum curriculo foi encontrado
			}
		}else {
			
			//chamar o dao para salvar os curriculos
			//true na variavel de controle renreded
		}
	}

	
	
	public boolean isFiltroP() {
		return filtroP;
	}


	public void setFiltroP(boolean filtroP) {
		this.filtroP = filtroP;
	}
	
	public Filtro geteFiltro() {
		return eFiltro;
	}

	public void seteFiltro(Filtro eFiltro) {
		this.eFiltro = eFiltro;
	}

	public List<ClasseGenerica> getEstado() {
		return estado;
	}

	public void setEstado(List<ClasseGenerica> estado) {
		this.estado = estado;
	}

	public List<ClasseGenerica> getCidades() {
		return cidades;
	}

	public void setCidades(List<ClasseGenerica> cidades) {
		this.cidades = cidades;
	}

	public List<ClasseGenerica> getArea() {
		return area;
	}

	public void setArea(List<ClasseGenerica> area) {
		this.area = area;
	}

	public List<ClasseGenerica> getCurso() {
		return curso;
	}

	public void setCurso(List<ClasseGenerica> curso) {
		this.curso = curso;
	}

	public List<ClasseGenerica> getSemestre() {
		return semestre;
	}

	public void setSemestre(List<ClasseGenerica> semestre) {
		this.semestre = semestre;
	}

	public List<ClasseGenerica> getIdioma() {
		return idioma;
	}

	public void setIdioma(List<ClasseGenerica> idioma) {
		this.idioma = idioma;
	}

	public List<ClasseGenerica> getSelCidade() {
		return selCidade;
	}

	public void setSelCidade(List<ClasseGenerica> selCidade) {
		this.selCidade = selCidade;
	}

	public ClasseGenerica getSelArea() {
		return selArea;
	}

	public void setSelArea(ClasseGenerica selArea) {
		this.selArea = selArea;
	}

	public FiltroService getFs() {
		return fs;
	}

	public void setFs(FiltroService fs) {
		this.fs = fs;
	}

}

