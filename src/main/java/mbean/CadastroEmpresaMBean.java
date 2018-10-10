package mbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import DAO.UsuarioEmpresaDAO;
import entity.UsuarioEmpresa;
import utils.MensFaces;

@ManagedBean
@ViewScoped
public class CadastroEmpresaMBean {

	UsuarioEmpresaDAO uDao = new UsuarioEmpresaDAO();
	private UsuarioEmpresa emp;

	public CadastroEmpresaMBean() {
		emp = new UsuarioEmpresa();
	}

	public String salvar() {
		try {
			if (uDao.buscarEmpresa(emp.getEmail()) == null) {

				if (uDao.buscaCnpj(emp.getCNPJ()) == null) {

					if (uDao.inserirEmpresa(emp)) {
						MensFaces.m("Sucesso ao cadastrar o Usuario!");
						FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
						return "login?faces-redirect=true";
					} else {
						MensFaces.m("Erro TECNICO, contate o Administrador!");
					}
				} else {

					MensFaces.m("Este CNPJ ja esta cadastrado!");
				}
			} else {
				MensFaces.m("Este email ja esta cadastrado!");
			}
		} catch (Exception e) {
			MensFaces.m(e.toString());
		}
		return null;

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
