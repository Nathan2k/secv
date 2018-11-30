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

	boolean filtroP = false; // � o rendered da tela depois de clicar pra vizualizar um filtro
	boolean filtroF = true;

	// VER SE ISSO TA CERTO
	// A DIFEREN�A DE UM PRA OUTRO� Q ESSE SE ENCONTRA EM OUTRA TELA E O XHTML JA
	// ESTA ME TRAZENDO O NOME E O ID DO FILTRO ENT�O � SO EU PEGAR O ID DO FILTRO E
	// LISTAR
	// ISSO PELO SETPROPERTYACTIONLISTENER
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
	
	
	
	
	
	

	public boolean isFiltroP() {
		return filtroP;
	}

	public void setFiltroP(boolean filtroP) {
		this.filtroP = filtroP;
	}

	public boolean isFiltroF() {
		return filtroF;
	}

	public void setFiltroF(boolean filtroF) {
		this.filtroF = filtroF;
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
