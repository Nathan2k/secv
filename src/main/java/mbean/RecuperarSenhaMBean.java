package mbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import DAO.UsuarioAdmDAO;
import DAO.UsuarioDAO;
import DAO.UsuarioEmpresaDAO;
import entity.Mensagem;
import entity.RecuperarSenha;
import entity.Usuario;
import entity.UsuarioADM;
import entity.UsuarioEmpresa;

@ManagedBean
@ViewScoped
public class RecuperarSenhaMBean {

	Mensagem mens = new Mensagem();

	UsuarioAdmDAO uAdm = new UsuarioAdmDAO();
	private UsuarioEmpresa emp;
	private UsuarioADM adm;
	UsuarioEmpresaDAO uEmp = new UsuarioEmpresaDAO();
	UsuarioDAO uDao;
	Usuario user = new Usuario();

	String ID_USUARIO_FINAL = "";
	String verificaPassword = "";
	String Password = "";
	int codigo;

	private String verificaEmail(String email) {

		user = uDao.busca(email);

		if (user != null) {
			Integer aleatorio = (int) (Math.random() * 9999);
			RecuperarSenha rSenha = new RecuperarSenha();
			rSenha.setIdUsuario(user.getId());
			rSenha.setCodigo(aleatorio);
			
			if()) {
				
				
				
				
			}
			

		} else {

			// COLOCAR MENSAGEM FALANDO Q EMAIL NAO FOI ENCONTRADO

		}

		return null;
	}

	
	
	
	
	
	
	
	public Mensagem getMens() {
		return mens;
	}

	public void setMens(Mensagem mens) {
		this.mens = mens;
	}

	public UsuarioAdmDAO getuAdm() {
		return uAdm;
	}

	public void setuAdm(UsuarioAdmDAO uAdm) {
		this.uAdm = uAdm;
	}

	public UsuarioEmpresaDAO getuEmp() {
		return uEmp;
	}

	public void setuEmp(UsuarioEmpresaDAO uEmp) {
		this.uEmp = uEmp;
	}

	public String getID_USUARIO_FINAL() {
		return ID_USUARIO_FINAL;
	}

	public void setID_USUARIO_FINAL(String iD_USUARIO_FINAL) {
		ID_USUARIO_FINAL = iD_USUARIO_FINAL;
	}

	public String getVerificaPassword() {
		return verificaPassword;
	}

	public void setVerificaPassword(String verificaPassword) {
		this.verificaPassword = verificaPassword;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

}
