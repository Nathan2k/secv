package mbean;

import java.awt.geom.Area;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import org.primefaces.behavior.ajax.AjaxBehaviorHandler;
import org.primefaces.component.selectonemenu.SelectOneMenu;

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
	String areaSel;

	FiltroDAO fDao = new FiltroDAO();
	
	boolean filtroP = false;

	FiltroService fs = new FiltroService();
	

	public void salvaFiltro() {
		
//		if(fs.enviarFiltro(eFiltro) != null) {
//			
//			
//			
//			
//		}
		
	}
	
	
//	public List<SelectItem> getEmpresas() {  
//	    List<SelectItem> items = new ArrayList<SelectItem>();  
//	    for (Empresa e : this.empresas) {  
//	        // observem que o value do meu SelectItem é a própria entidade  
//	        items.add(new SelectItem(e, e.getNome()));  
//	    }  
//	    return items;  
//	}  
	
	// RESPONSAVEL POR CONSEGUIR PASSAR A ENTIDADE NO VALUE DO SELECT ONE MENU
	
	public List<SelectItem> pegandoArea(){
		
		List<SelectItem> pArea = new ArrayList<SelectItem>();
		
		for(ClasseGenerica c : this.area) {
			
			pArea.add(new SelectItem(c, c.getNome()));
		}
		
		return pArea;
		
	}
	
	
	
	
	
	
	
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
		try {
			area = fs.cArea(eFiltro);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// PEGA OS CURSOS COM CURRICULO CADASTRADO
	public void attCurso(AjaxBehaviorEvent event) {
		areaSel = eFiltro.getArea();
		String codigo = areaSel.substring(0, areaSel.lastIndexOf("-"));
		areaSel = areaSel.substring(areaSel.lastIndexOf("-") + 1);
		eFiltro.setArea(codigo);
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
	
	

	
	public FiltroDAO getfDao() {
		return fDao;
	}

	public void setfDao(FiltroDAO fDao) {
		this.fDao = fDao;
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


	public String getAreaSel() {
		return areaSel;
	}


	public void setAreaSel(String areaSel) {
		this.areaSel = areaSel;
	}
	
	


	
}
