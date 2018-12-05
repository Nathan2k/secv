package mbean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import DAO.CurriculoDAO;
import entity.Curriculo;
import entity.Filtro;
import service.Experiencia;
import service.Formacao;

@ManagedBean
@SessionScoped
public class HistoricoMBean {

	Curriculo cur = new Curriculo();
	Formacao ff = new Formacao();
	Experiencia xp = new Experiencia();

	List<Curriculo> cl;
	Filtro filtroSelecionado;

	CurriculoDAO clDAO = new CurriculoDAO();

	boolean filtroP = false; // é o rendered da tela depois de clicar pra vizualizar um filtro
	boolean filtroF = true;

	Integer idFiltro;

	
	
	@ManagedProperty(value = "#{usuarioMBean}")
	private UsuarioMBean userMb;

	List<Filtro> filtros;
	
	public void setUserMb(UsuarioMBean userMb) {
		this.userMb = userMb;
	}



	
	@PostConstruct
	public void init() {
		criarFiltros();
	}

	
	public void listarCur() {
		cl = clDAO.listarCurriculo(filtroSelecionado.getId());
		filtroP = true;
		filtroF = false;
	}
	
	// ESSE CARA SERVE PARA LISTAR OS FILTROS NO ADM OU NO USUARIO EMPRESA!(TELA HISTORICO)
	public void criarFiltros() {
		if (userMb.getAdm() == null) {

			filtros = clDAO.listarFiltro(userMb.getEmp().getId(), false);

		} else {
			filtros = clDAO.listarFiltro(userMb.getAdm().getId(), true);

		}
	}

	public String imprimir() {

		FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);

		FacesContext.getCurrentInstance().getExternalContext().getFlash().put("curImp", cur);

		return "curriculo?faces-redirect=true";
	}
	
	public String finalizar(){
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		session.removeAttribute("historicoMBean");
		
		return "historico?faces-redirect=true";
	}
	
	
	public String finalizarAdm(){
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		session.removeAttribute("historicoMBean");
		
		return "historicoADM?faces-redirect=true";
	}
	
	

//	public void listarCurAdm() {
//		
//		System.out.println(filtroMB.idFiltro);
//
//		cl = clDAO.listarCurriculo(filtroSelecionado.getId());
//		filtroP = true;
//		filtroF = false;
//		
//	}

	public Integer getIdFiltro() {
		return idFiltro;
	}

	public void setIdFiltro(Integer idFiltro) {
		this.idFiltro = idFiltro;
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


	public List<Filtro> getFiltros() {
		return filtros;
	}


	public void setFiltros(List<Filtro> filtros) {
		this.filtros = filtros;
	}

}
