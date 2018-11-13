package mbean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import DAO.CurriculoDAO;
import entity.Curriculo;

@ManagedBean
@ViewScoped
public class ListarCurriculoMBean {
	
	Curriculo cur;
	List<Curriculo> cl;
	CurriculoDAO clDAO;
	private Curriculo selectcl;
	
	
	//É PRA LISTAR O CURRICULO SE VAI FUNCIONAR EU JA NAO SEI  XD
	public ListarCurriculoMBean(){
		
		System.out.println("criou");
		
		cur = new Curriculo();
		clDAO = new CurriculoDAO();
		cl = clDAO.listarCurriculo();
		clDAO = new CurriculoDAO();
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
