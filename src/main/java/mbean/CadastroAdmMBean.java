package mbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import DAO.UsuarioAdmDAO;
import DAO.UsuarioEmpresaDAO;
import entity.UsuarioADM;
import utils.MensFaces;

@ManagedBean
@ViewScoped
public class CadastroAdmMBean {

	UsuarioAdmDAO uDao = new UsuarioAdmDAO();
	private UsuarioADM adm;
	private UsuarioEmpresaDAO eDao = new UsuarioEmpresaDAO();

	public CadastroAdmMBean() {
		adm = new UsuarioADM();
	}

	public String salvar() {

		try {

			if (uDao.buscarEmailADM(adm.getEmail()) == null) {

				if (uDao.buscarADM(adm.getNIF()) == null) {

					if (eDao.buscarEmpresa(adm.getEmail()) == null) {


						if (uDao.inserirADM(adm)) {
							MensFaces.m("Usuario cadastrado com sucesso!");
							FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
							return "criarUsuarioAdm?faces-redirect=true"; // VER ISSO AQUI DEPOIS, PQ É UM POPUP
						}else {
							
							MensFaces.m("ERRO TECNICO, CONTATE O ADMINISTRADOR!");
						}
					} else {
						MensFaces.m("Este Email ja esta Cadastrado para uma Empresa!");
					}

				} else {

					MensFaces.m("Este NIF ja esta Cadastrado!");
				}

			} else {
				MensFaces.m("Este Email ja esta Cadastrado!");
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return null;

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
