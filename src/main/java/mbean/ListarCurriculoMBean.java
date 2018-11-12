package mbean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import DAO.CurriculoDAO;
import entity.Curriculo;

@ManagedBean
@ViewScoped
public class ListarCurriculoMBean {
	
	List<Curriculo> cl;
	CurriculoDAO clDAO;
	
	
	//É PRA LISTAR O CURRICULO SE VAI FUNCIONAR EU JA NAO SEI  XD
	public ListarCurriculoMBean(){
		
		clDAO = new CurriculoDAO();
		cl = clDAO.listarCurriculo();
		
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
	
	

}
