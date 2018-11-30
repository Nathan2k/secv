package mbean;

import java.sql.SQLException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import DAO.UsuarioAdmDAO;
import DAO.UsuarioEmpresaDAO;
import entity.UsuarioADM;
import entity.UsuarioEmpresa;
import utils.Replace;

@ManagedBean
@SessionScoped
public class UsuarioMBean {

	public UsuarioEmpresaDAO uDao;
	public UsuarioAdmDAO admDAO;

	public String imagem;

	private UsuarioEmpresa emp;
	private UsuarioADM adm;

	public String empreOUadm;
	public String senha;
	
	public boolean logado = false;

	public UsuarioMBean() {
		imagem = "off";
		uDao = new UsuarioEmpresaDAO();
		admDAO = new UsuarioAdmDAO();

	}

	public void trocaImagem() {
		imagem = imagem.equals("on") ? "off" : "on";
		System.out.println("Caiu");
	}

	private String loginEmpresa() {
		empreOUadm = Replace.format(empreOUadm);
		try {
			emp = uDao.buscarEmpresa(empreOUadm, senha);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			mensagem(e.toString());
		}
		if (emp != null) {
			 logado = true;
			return "/telas-empresa/temfiltro?faces-redirect=true";
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuário e/ou  Senha invalido(s)"));
			return "login.xhtml";
		}
	}
	

	private String loginADM() {
		adm = admDAO.buscarADM((empreOUadm), senha);
		if (adm != null) {

			return "/telas-adm/homeADM?faces-redirect=true";
		}
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuário e/ou Senha invalido(s)"));
		return "login.xhtml";
	}

	public String logar() {
		if (imagem.equals("on")) {
			return loginADM();
		} else if (imagem.equals("off")) {
			return loginEmpresa();
		} else {
			return null;
		}
	}
	
	

	public boolean isLogado() {
		return logado;
	}

	public void setLogado(boolean logado) {
		this.logado = logado;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public UsuarioADM getAdm() {
		return adm;
	}

	public void setAdm(UsuarioADM adm) {
		this.adm = adm;
	}

	public String getEmpreOUadm() {
		return empreOUadm;
	}

	public void setEmpreOUadm(String empreOUadm) {
		this.empreOUadm = empreOUadm;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public UsuarioEmpresaDAO getuDao() {
		return uDao;
	}

	public void setuDao(UsuarioEmpresaDAO uDao) {
		this.uDao = uDao;
	}

	public UsuarioAdmDAO getAdmDAO() {
		return admDAO;
	}

	public void setAdmDAO(UsuarioAdmDAO admDAO) {
		this.admDAO = admDAO;
	}

	public UsuarioEmpresa getEmp() {
		return emp;
	}

	public void setEmp(UsuarioEmpresa emp) {
		this.emp = emp;
	}

	public void mensagem(String s) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(s));

	}
	
	

		


//	value="#{UsuarioMBean.uEmpresa.CNPJ}"

//	action="#{usuarioMBean.doEfetuarLogin}"
}
