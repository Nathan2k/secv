package mbean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import entity.Curriculo;
import entity.Filtro;
import service.ClasseGenerica;
import utils.FiltroService;
import utils.MensFaces;

import com.google.gson.Gson;
import com.google.gson.annotations.*;

import DAO.FiltroDAO;

@ManagedBean
@ViewScoped
public class FiltroMBean {

	private Filtro eFiltro = new Filtro();

	List<ClasseGenerica> estado = new ArrayList<>();
	List<ClasseGenerica> cidades = new ArrayList<>();
	List<ClasseGenerica> area = new ArrayList<>();
	List<ClasseGenerica> curso = new ArrayList<>();
	List<ClasseGenerica> semestre = new ArrayList<>();
	List<ClasseGenerica> idioma = new ArrayList<>();

	List<ClasseGenerica> selCidade = new ArrayList<>();

	FiltroDAO fDao = new FiltroDAO();
	
	boolean filtroP = false;

	FiltroService fs = new FiltroService();

	// PEGA AS CIDADES COM CURRICULO CADASTRADO
	public FiltroMBean() {
		try {
			cidades = fs.cCidade();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// PEGA AS AREAS COM CURRICULO CADASTRADO
	public void attArea() {
		System.out.println(eFiltro.getArea());
		try {
			area = fs.cArea(eFiltro);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// PEGA OS CURSOS COM CURRICULO CADASTRADO
	public void attCurso() {
		try {
			curso = fs.cCurso(eFiltro);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// PEGA OS SEMESTRES COM CURRICULO CADASTRADO
	public void attSemestre() {
		try {
			semestre = fs.cSemestre(eFiltro);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	public void enviarFiltro() throws IOException {
		System.out.println("sim");
		List<Curriculo> curriculos = fs.enviarFiltro(eFiltro);

		if (curriculos == null) {

			MensFaces.m("Ocorreu um erro ao enviar o filtro!");
			FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);

			if (curriculos.isEmpty()) { // PERGUNTAR SE TER Q FAZER ESSE IF DO EMPTY FORA DO IF DO NULL 

				MensFaces.m("Nenhum Curriculo foi encontrado!");
				FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
			}
		} else {
			
			for(Curriculo c : curriculos) {
				
				fDao.inserirCurriculo(c);  // FICA ANDANDO NA LISTA E INSERE UM POR UM
			}
			
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

	public FiltroService getFs() {
		return fs;
	}

	public void setFs(FiltroService fs) {
		this.fs = fs;
	}

}
