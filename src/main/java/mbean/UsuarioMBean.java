package mbean;

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
	public String empreOUadm;
	public String senha;

	public UsuarioMBean() {
		imagem = "on";
		uDao = new UsuarioEmpresaDAO();
	}

	public void trocaImagem() {
		imagem = imagem.equals("on") ? "off" : "on";
		System.out.println("Caiu");
	}

	private String loginEmpresa() {
		empreOUadm = Replace.format(empreOUadm);
		emp = uDao.buscarEmpresa(empreOUadm, senha);
		if ( emp != null) {
			return "temfiltro.xhtml";
		}
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuário e/ou  Senha invalido(s)"));
		return "login.xhtml";
	}

	private String loginADM() {
		UsuarioADM adm = admDAO.buscarADM(Integer.valueOf(empreOUadm), senha);
		if (adm != null) {
			return "homeADM.xhtml";
		}
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuário e/ou  Senha invalido(s)"));
		return "login.xhtml";
	}
	
	public String logar() {
		if(imagem.equals("on")) {
			return loginADM();
		}else if(imagem.equals("off")) {
			return loginEmpresa();
		}else {
			return null;
		}
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
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

	
//	value="#{UsuarioMBean.uEmpresa.CNPJ}"

//	action="#{usuarioMBean.doEfetuarLogin}"
}
