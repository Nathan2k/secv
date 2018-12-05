package mbean;

import java.awt.Label;
import java.sql.SQLException;
import java.util.UUID;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

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
import utils.MensFaces;

@ManagedBean
@SessionScoped
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

	public String verificaEmail() {

		System.out.println(mens.getDestinatario());

		user = uDao.busca(mens.getDestinatario());

		if (user != null) {
			Integer aleatorio = (int) (Math.random() * 9999);
			RecuperarSenha rSenha = new RecuperarSenha();
			rSenha.setEmailUsuario(user.getEmail()); // FICA ESPERTO COM ESSA LINHA
			rSenha.setCodigo(aleatorio.toString());

			if (uDao.inserirCodigo(rSenha)) {

				// TODO Auto-generated method stub
				c.setText("<html>CÓDIGO: <b>" + aleatorio + "</b></html>");
				mens.setAssunto("Recupera Senha - Sistema SECV");
				mens.setDestinatario(user.getEmail());
				mens.setMensagem(c.getText());

				try {
					EnviaUtil.enviaEmail(mens);
				} catch (EmailException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				System.out.println("Email enviado com sucesso!");
				MensFaces.m("Verifique seu Email!");
				FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
				return "telaCodigo?faces-redirect=true";

			} else {

				System.out.println("Problema ao cadastrar codigo");
			}
		} else {
			System.out.println("Problema ao Enviar Email");
		}
		return null;
	}

	public void verificaCodigo() {

		protocolo = uDao.verificaCodigo(vCod);
		if (protocolo != null) {
			codigoCerto = true;
			MensFaces.m("Codigo autorizado!");
			FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("O Codigo esta Incorreto!"));
			System.out.println("Codigos diferentes!!");
		}
	}

	public String novaSenha() {

		if (Password.equals(verificaPassword)) {

			System.out.println(protocolo.getEmailUsuario());
			
			
			Usuario usuarioP = new Usuario(null, null, Password, protocolo.getEmailUsuario(), null, ID_USUARIO_FINAL);

			if (uDao.alterar(usuarioP)) {

				uDao.deletaProtocolo(protocolo);

				for (int x = 1; x < 2; x++) {
					FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("SENHA ALTERADA COM SUCESSO!"));
				}

				return "login?faces-redirect=true";
			}
		} else {

			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("Senhas diferentes. Veirifique password"));

		}

		return null;

	}

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

	public RecuperarSenha getProtocolo() {
		return protocolo;
	}

	public void setProtocolo(RecuperarSenha protocolo) {
		this.protocolo = protocolo;
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
