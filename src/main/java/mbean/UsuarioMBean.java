package mbean;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import DAO.UsuarioDAO;
import entity.UsuarioADM;
import entity.UsuarioEmpresa;

public class UsuarioMBean {

	UsuarioEmpresa uEmpresa;
	UsuarioADM uAdm;
	UsuarioDAO uDao;
	
	public String loginEmpresa() {
		if(uDao.buscarEmpresa(uEmpresa.getCNPJ())!= null) {
			return "temfiltro.xgtml";
		}
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuário e/ou  Senha invalido(s)"));
		return null;
	}
	
	
//	public String loginAdm() {
//		if(uDao.buscarUsuario())
//	}
	
	
//	value="#{UsuarioMBean.uEmpresa.CNPJ}"
	
//	action="#{usuarioMBean.doEfetuarLogin}"
}
