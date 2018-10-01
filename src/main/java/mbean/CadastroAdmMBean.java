package mbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import DAO.UsuarioAdmDAO;
import entity.UsuarioADM;

@ManagedBean
@ViewScoped
public class CadastroAdmMBean {
	
	
	UsuarioAdmDAO uDao = new UsuarioAdmDAO();
	private UsuarioADM adm;
	
	public CadastroAdmMBean() {
		adm = new UsuarioADM();
	}

	public String salvar() {
		if (uDao.inserirADM(adm)) {
			return "criarUsuarioAdm?faces-redirect=true"; // VER ISSO AQUI DEPOIS, PQ É UM POPUP
		} else {
			return null;
		}
	}

	public UsuarioAdmDAO getuDao() {
		return uDao;
	}

	public void setuDao(UsuarioAdmDAO uDao) {
		this.uDao = uDao;
	}

	public UsuarioADM getAdm() {
		return adm;
	}

	public void setAdm(UsuarioADM adm) {
		this.adm = adm;
	}
	
	
	
	
	
}
