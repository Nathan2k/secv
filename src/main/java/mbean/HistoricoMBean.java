package mbean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import DAO.CurriculoDAO;
import entity.Curriculo;
import entity.Filtro;
import service.Experiencia;
import service.Formacao;

@ManagedBean
@ViewScoped
public class HistoricoMBean {

	Curriculo cur;
	Formacao ff;
	Experiencia xp;

	List<Curriculo> cl;
	Filtro filtroSelecionado = new Filtro();

	CurriculoDAO clDAO;
	
	boolean filtroP = false; // é o rendered da tela depois de clicar pra vizualizar um filtro
	boolean filtroF = true;

	public void listarCur() {

		cur = new Curriculo();
		ff = new Formacao();
		xp = new Experiencia();
		clDAO = new CurriculoDAO();
		cl = clDAO.listarCurriculo(filtroSelecionado.getId());
		filtroP = true;
		filtroF = false;
		clDAO = new CurriculoDAO();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

	public List<Curriculo> getCl() {
		return cl;
	}

	public void setCl(List<Curriculo> cl) {
		this.cl = cl;
	}

	public Filtro getFiltroSelecionado() {
		return filtroSelecionado;
	}

	public void setFiltroSelecionado(Filtro filtroSelecionado) {
		this.filtroSelecionado = filtroSelecionado;
	}

	public Curriculo getCur() {
		return cur;
	}

	public void setCur(Curriculo cur) {
		this.cur = cur;
	}

	public Formacao getFf() {
		return ff;
	}

	public void setFf(Formacao ff) {
		this.ff = ff;
	}

	public Experiencia getXp() {
		return xp;
	}

	public void setXp(Experiencia xp) {
		this.xp = xp;
	}

	public CurriculoDAO getClDAO() {
		return clDAO;
	}

	public void setClDAO(CurriculoDAO clDAO) {
		this.clDAO = clDAO;
	}

}
