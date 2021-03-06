package mbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import DAO.UsuarioAdmDAO;
import DAO.UsuarioEmpresaDAO;
import entity.UsuarioADM;
import entity.UsuarioEmpresa;

@ManagedBean
public class AlterarPerfilMBean {

	public UsuarioEmpresaDAO uDao;
	public UsuarioAdmDAO admDAO;

	@ManagedProperty(value = "#{usuarioMBean}")
	private UsuarioMBean userMb;

	private UsuarioEmpresa emp;
	private UsuarioADM adm;

	public AlterarPerfilMBean() {

		uDao = new UsuarioEmpresaDAO();
		admDAO = new UsuarioAdmDAO();
	}

	public String alterar() {

		emp = userMb.getEmp();

		uDao.alterar(emp);

		return "perfilEmpresa?faces-redirect=true";

	}

	public String alterarADM() {

		adm = userMb.getAdm();

		admDAO.mudarADM(adm);

		return "perfilADM?faces-redirect=true";

	}

	public void setUserMb(UsuarioMBean userMb) {
		this.userMb = userMb;
	}

}
