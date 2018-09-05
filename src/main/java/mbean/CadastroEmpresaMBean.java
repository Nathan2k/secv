package mbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import DAO.UsuarioEmpresaDAO;
import entity.UsuarioEmpresa;

@ManagedBean
@SessionScoped
public class CadastroEmpresaMBean {
	
	UsuarioEmpresaDAO uDao = new UsuarioEmpresaDAO();
	public UsuarioEmpresa emp = new UsuarioEmpresa();
	
	
	public String salvar() {
		if (uDao.inserirEmpresa(emp)) {
			return "login?faces-redirect=true";
		} else {
			return null;
		}
	}
	
	
	
	

}
