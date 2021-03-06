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
import entity.Filtro;
import service.Experiencia;
import service.Formacao;

@ManagedBean
@ViewScoped
public class ListarCurriculoMBean {

	Curriculo cur;
	Formacao ff;
	Experiencia xp;

	List<Curriculo> cl;

	Filtro filtroSelecionado;

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
		
		System.out.println("Intancia nova de ListarCurriculoMBean");

		idFiltro = filtroMB.getIdFiltro();

		cur = new Curriculo();
		ff = new Formacao();
		xp = new Experiencia();
		clDAO = new CurriculoDAO();
		//cl = clDAO.listarCurriculo(idFiltro);
		clDAO = new CurriculoDAO();

	}

//	public void listarCurriculosFiltro() {
//
//		idFiltro = filtroSelecionado.getId();
//
//		cur = new Curriculo(); // CURRICULO
//		ff = new Formacao(); // FORMACAO
//		xp = new Experiencia(); // EXPERIENCIA
//		clDAO = new CurriculoDAO(); 
//		cl = clDAO.listarCurriculo(idFiltro); // LISTA DE CURRICULOS
//		//clDAO = new CurriculoDAO();
//
//	}

	public String imprimir() {

		FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);

		FacesContext.getCurrentInstance().getExternalContext().getFlash().put("curImp", cur);

		// VER COMO COLOCAR EXPERIENCIA/FORMA��O NO CURRICULO

		return "curriculo?faces-redirect=true";
	}

	public String convertData(Long data) {
		Calendar c = Calendar.getInstance();

		c.setTimeInMillis(data);

		return new SimpleDateFormat("dd/MM/yyyy").format(c.getTimeInMillis());
	}

	public Experiencia getXp() {
		return xp;
	}

	public void setXp(Experiencia xp) {
		this.xp = xp;
	}

	public Filtro getFiltroSelecionado() {
		return filtroSelecionado;
	}

	public void setFiltroSelecionado(Filtro filtroSelecionado) {
		this.filtroSelecionado = filtroSelecionado;
	}

	public Integer getIdFiltro() {
		return idFiltro;
	}

	public void setIdFiltro(Integer idFiltro) {
		this.idFiltro = idFiltro;
	}

	public FiltroMBean getFiltroMB() {
		return filtroMB;
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
