package mbean;

import java.sql.SQLException;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import DAO.UsuarioAdmDAO;
import DAO.UsuarioEmpresaDAO;
import entity.UsuarioADM;
import entity.UsuarioEmpresa;

@ManagedBean
@ViewScoped
public class tabelaMBean {

	public UsuarioEmpresaDAO uDao;
	public UsuarioAdmDAO admDAO;
	UsuarioEmpresa ue;
	List<UsuarioEmpresa> ues;
	UsuarioEmpresaDAO ueDAO;
	@ManagedProperty(value = "#{usuarioMBean}")
	private UsuarioMBean userMb;
	private UsuarioEmpresa selectemp;

	public UsuarioEmpresa getSelectemp() {
		return selectemp;
	}

	public void setSelectemp(UsuarioEmpresa selectemp) {
		this.selectemp = selectemp;
	}

	public void excluir() {
		try {
			System.out.println("entro no else");
			if (uDao.deletar(selectemp)) {
				ues.remove(selectemp);
				ues = uDao.listarTodos();
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Excluido com sucesso!"));
				//return "perfilADM?faces-redirect=true";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		return null;
	}

	public tabelaMBean() {

		ue = new UsuarioEmpresa();
		ueDAO = new UsuarioEmpresaDAO();
		ues = ueDAO.listarTodos();
		uDao = new UsuarioEmpresaDAO();
	}

	public void setUserMb(UsuarioMBean userMb) {
		this.userMb = userMb;
	}

	public UsuarioEmpresa getUe() {
		return ue;
	}

	public void setUe(UsuarioEmpresa ue) {
		this.ue = ue;
	}

	public List<UsuarioEmpresa> getUes() {
		return ues;
	}

	public void setUes(List<UsuarioEmpresa> ues) {
		this.ues = ues;
	}

	public UsuarioEmpresaDAO getUeDAO() {
		return ueDAO;
	}

	public void setUeDAO(UsuarioEmpresaDAO ueDAO) {
		this.ueDAO = ueDAO;
	}

}
