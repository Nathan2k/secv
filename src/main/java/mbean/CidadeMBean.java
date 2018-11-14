package mbean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import DAO.CidadeDAO;
import entity.Cidade;

@ManagedBean
@ViewScoped
public class CidadeMBean {

	Cidade city;
	List<Cidade> cd;
	CidadeDAO cdDAO;
	
	public CidadeMBean() {
		
		System.out.println("asdasdu");
	
		city = new Cidade();
		cdDAO = new CidadeDAO();
		cd = cdDAO.listarCidade();
		cdDAO = new CidadeDAO();
	}

	public Cidade getCity() {
		return city;
	}

	public void setCity(Cidade city) {
		this.city = city;
	}

	public List<Cidade> getCd() {
		return cd;
	}

	public void setCd(List<Cidade> cd) {
		this.cd = cd;
	}

	public CidadeDAO getCdDAO() {
		return cdDAO;
	}

	public void setCdDAO(CidadeDAO cdDAO) {
		this.cdDAO = cdDAO;
	}
	
	
	
}
