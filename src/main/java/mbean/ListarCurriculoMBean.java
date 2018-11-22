package mbean;

import java.io.IOException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import DAO.CurriculoDAO;
import DAO.FiltroDAO;
import entity.Curriculo;

@ManagedBean
@ViewScoped
public class ListarCurriculoMBean {
	
	Curriculo cur;
	List<Curriculo> cl;
	CurriculoDAO clDAO;
	private Curriculo selectcl;
	FiltroDAO fDAO;
	
	public ListarCurriculoMBean(){
		
		cur = new Curriculo();
		clDAO = new CurriculoDAO();
		cl = clDAO.listarCurriculo();
		clDAO = new CurriculoDAO();
	}
	
	public String imprimir() {
		
		FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
		
		FacesContext.getCurrentInstance().getExternalContext().getFlash().put("curImp", cur);
		
		//VER COMO COLOCAR EXPERIENCIA/FORMAÇÃO NO CURRICULO
		

		return "curriculo?faces-redirect=true";
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
