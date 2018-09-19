package mbean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import DAO.UsuarioEmpresaDAO;
import entity.UsuarioEmpresa;

@ManagedBean
@ViewScoped
public class CadastroEmpresaMBean {

	UsuarioEmpresaDAO uDao = new UsuarioEmpresaDAO();
	private UsuarioEmpresa emp;

	public CadastroEmpresaMBean() {
		emp = new UsuarioEmpresa();
	}

	public String salvar() {
		if (uDao.inserirEmpresa(emp)) {
			return "login?faces-redirect=true";
		} else {
			return null;
		}
	}
	
	public UsuarioEmpresaDAO getuDao() {
		return uDao;
	}

	public void setuDao(UsuarioEmpresaDAO uDao) {
		this.uDao = uDao;
	}

	public UsuarioEmpresa getEmp() {
		return emp;
	}

	public void setEmp(UsuarioEmpresa emp) {
		this.emp = emp;
	}

}
