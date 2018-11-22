package mbean;

import java.io.IOException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import DAO.CurriculoDAO;
import DAO.FiltroDAO;
import entity.Curriculo;
import service.Formacao;

@ManagedBean
@ViewScoped
public class ListarCurriculoMBean {
	
	Curriculo cur;
	Formacao ff;
	List<Curriculo> cl;
	List<Formacao> forma;
	CurriculoDAO clDAO;
	private Curriculo selectcl;
	FiltroDAO fDAO;
	
	// VER SE ISSO TA CERTO, PQ TA ZUADO N SEI PQ NAO TA LISTANDO
	
	public ListarCurriculoMBean(){
		
		cur = new Curriculo();
		ff = new Formacao();
		clDAO = new CurriculoDAO();
		cl = clDAO.listarCurriculo();
		forma = clDAO.listarFormacao(cur.getId());
		clDAO = new CurriculoDAO();
	}
	
	public String imprimir() {
		
		forma = clDAO.listarFormacao(cur.getId());
		
		System.out.println(forma);
		
		FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
		
		FacesContext.getCurrentInstance().getExternalContext().getFlash().put("curImp", cur);
		
		FacesContext.getCurrentInstance().getExternalContext().getFlash().put("formei", forma);
		
		//VER COMO COLOCAR EXPERIENCIA/FORMAÇÃO NO CURRICULO
		

		return "curriculo?faces-redirect=true";
	}
	
	

	
	public Formacao getFf() {
		return ff;
	}

	public void setFf(Formacao ff) {
		this.ff = ff;
	}

	public List<Formacao> getForma() {
		return forma;
	}

	public void setForma(List<Formacao> forma) {
		this.forma = forma;
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
