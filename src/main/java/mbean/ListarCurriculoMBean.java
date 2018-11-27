package mbean;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import DAO.CurriculoDAO;
import DAO.FiltroDAO;
import entity.Curriculo;
import service.Experiencia;
import service.Formacao;

@ManagedBean
@ViewScoped
public class ListarCurriculoMBean {
	
	Curriculo cur;
	Formacao ff;
	Experiencia xp;
	
	List<Curriculo> cl;
	
	CurriculoDAO clDAO;
	private Curriculo selectcl;
	FiltroDAO fDAO;
	
	Integer idFiltro;
	
	@ManagedProperty("#{filtroMBean}")
	private FiltroMBean filtroMB;
	
	public void setFiltroMB(FiltroMBean filtroMB) {
		this.filtroMB = filtroMB;
	}
	@PostConstruct
	public void postConstruct() {
		
		idFiltro = filtroMB.getIdFiltro();
		
		cur = new Curriculo();
		ff = new Formacao();
		xp = new Experiencia();
		clDAO = new CurriculoDAO();
		cl = clDAO.listarCurriculo(idFiltro);
		clDAO = new CurriculoDAO();
		
	}
	
	// VER SE ISSO TA CERTO, PQ TA ZUADO N SEI PQ NAO TA LISTANDO
	
	public ListarCurriculoMBean(){
		
		
	}
	
	public String imprimir() {
		
		FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
		
		FacesContext.getCurrentInstance().getExternalContext().getFlash().put("curImp", cur);
		
		//VER COMO COLOCAR EXPERIENCIA/FORMAÇÃO NO CURRICULO
		

		return "curriculo?faces-redirect=true";
	}
	
	public String convertData(Long data) {
		Calendar c = Calendar.getInstance();
		
		c.setTimeInMillis(data);
		
		return new SimpleDateFormat("dd/MM/yyyy").format(c.getTimeInMillis());
	}
	
	

	
	public Formacao getFf() {
		return ff;
	}

	public void setFf(Formacao ff) {
		this.ff = ff;
	}

	public FiltroDAO getfDAO() {
		return fDAO;
	}

	public void setfDAO(FiltroDAO fDAO) {
		this.fDAO = fDAO;
	}

	public List<Curriculo> getCl() {
		return cl;
	}

	public void setCl(List<Curriculo> cl) {
		this.cl = cl;
	}

	public CurriculoDAO getClDAO() {
		return clDAO;
	}

	public void setClDAO(CurriculoDAO clDAO) {
		this.clDAO = clDAO;
	}

	public Curriculo getCur() {
		return cur;
	}

	public void setCur(Curriculo cur) {
		this.cur = cur;
	}

	public Curriculo getSelectcl() {
		return selectcl;
	}

	public void setSelectcl(Curriculo selectcl) {
		this.selectcl = selectcl;
	}
	
	

}
