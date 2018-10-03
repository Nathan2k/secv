package mbean;

import java.awt.Label;
import java.sql.SQLException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.commons.mail.EmailException;

import DAO.UsuarioAdmDAO;
import DAO.UsuarioDAO;
import DAO.UsuarioEmpresaDAO;
import entity.Mensagem;
import entity.RecuperarSenha;
import entity.Usuario;
import entity.UsuarioADM;
import entity.UsuarioEmpresa;
import utils.EnviaUtil;

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
	Label c;
	private boolean codigoCerto = false;
	RecuperarSenha protocolo;
	private String vCod = "";
	int vcod2;

	String ID_USUARIO_FINAL = "";
	String verificaPassword = "";
	String Password = "";

	public RecuperarSenhaMBean() {

		try {
			uDao = new UsuarioDAO();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		c = new Label();

	}

	private String verificaEmail(String email) {

		user = uDao.busca(email);

		if (user != null) {
			Integer aleatorio = (int) (Math.random() * 9999);
			RecuperarSenha rSenha = new RecuperarSenha();
			rSenha.setIdUsuario(user.getId());
			rSenha.setCodigo(aleatorio);

			if (uDao.inserirCodigo(rSenha)) {
				c.setText("<html>CÓDIGO: <b>" + aleatorio + "</b></html>");
				mens.setAssunto("Recupera Senha - Sistema SECV");
				mens.setDestinatario(user.getEmail());
				mens.setMensagem(c.getText());

				try {
					EnviaUtil.enviaEmail(mens);
					System.out.println("Email enviado com sucesso!");
					return "telacodigo?faces-redirect=true";
				} catch (EmailException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {

				System.out.println("Problema ao cadastrar codigo");
			}

		} else {
			System.out.println("Problema ao Enviar Email");
		}
		return null;
	}

	public String verificaCodigo() {

		if (vCod != "") {

			vcod2 = Integer.parseInt(vCod);
			protocolo = uDao.rec(vcod2);
			if (protocolo != null) {
				codigoCerto = true;
				return null;
			} else {
				// CODIGO ERRADO
				return null;
			}
		} else {
			// COLOQUE UM CODIGO
			return null;
		}
	}

//	public String novaSenha() {
//
//		if (Password.equals("") || verificaPassword.equals("")) {
//			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Preencha o campo em branco!"));
//			return null;
//			
//		}else {
//			if(Password.equals(verificaPassword)) {
//				if(uDao.alterar(new Usuario(pro, nome, senha, email, telefone))) {
//					uDao.deletaProtocologo(ID_USUARIO_FINAL);
//					for(int x = 1; x< 2;x++) {
//						FacesContext.getCurrentInstance().addMessage(null, 
//								new FacesMessage("SENHA ALTERADA COM SUCESSO!"));
//					}
//					return "index?faces-redirect=true";
//				}
//			}else {
//				FacesContext.getCurrentInstance().addMessage(null, 
//						new FacesMessage("Senhas diferentes. Veirifique password") );
//			}
//			return null;
//		}
//	}

	public String getvCod() {
		return vCod;
	}

	public void setvCod(String vCod) {
		this.vCod = vCod;
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

	public UsuarioEmpresa getEmp() {
		return emp;
	}

	public void setEmp(UsuarioEmpresa emp) {
		this.emp = emp;
	}

	public UsuarioADM getAdm() {
		return adm;
	}

	public void setAdm(UsuarioADM adm) {
		this.adm = adm;
	}

	public UsuarioDAO getuDao() {
		return uDao;
	}

	public void setuDao(UsuarioDAO uDao) {
		this.uDao = uDao;
	}

	public Usuario getUser() {
		return user;
	}

	public void setUser(Usuario user) {
		this.user = user;
	}

	public Label getC() {
		return c;
	}

	public void setC(Label c) {
		this.c = c;
	}

	public boolean isCodigoCerto() {
		return codigoCerto;
	}

	public void setCodigoCerto(boolean codigoCerto) {
		this.codigoCerto = codigoCerto;
	}

	public int getVcod2() {
		return vcod2;
	}

	public void setVcod2(int vcod2) {
		this.vcod2 = vcod2;
	}

}
