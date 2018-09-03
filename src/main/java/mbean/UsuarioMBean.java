package mbean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import DAO.UsuarioDAO;
import entity.UsuarioADM;
import entity.UsuarioEmpresa;

@ManagedBean
@SessionScoped
public class UsuarioMBean {

	UsuarioEmpresa uEmpresa;
	UsuarioADM uAdm;
	UsuarioDAO uDao;
	
	String imagem;
	
	
	public UsuarioMBean() {
		imagem = "on";
	}
	public void trocaImagem() {
		imagem = imagem.equals("on") ? "off" : "on" ;
		System.out.println("Caiu");
	}
	
	public String loginEmpresa() {
		if(uDao.buscarEmpresa(uEmpresa.getCNPJ())!= null) {
			return "temfiltro.xgtml";
		}
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuário e/ou  Senha invalido(s)"));
		return null;
	}
	
	
	public String loginADM() {
		if(uDao.buscarADM(uAdm.getNIF())!= null) {
			return "homeADM.xhtml";
		}
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuário e/ou  Senha invalido(s)"));
		return null;
	}
	public String getImagem() {
		return imagem;
	}
	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
	

	
//	value="#{UsuarioMBean.uEmpresa.CNPJ}"
	
//	action="#{usuarioMBean.doEfetuarLogin}"
}
