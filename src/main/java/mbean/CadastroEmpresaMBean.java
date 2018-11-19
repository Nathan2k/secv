package mbean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import DAO.CidadeDAO;
import DAO.UsuarioEmpresaDAO;
import entity.Cidade;
import entity.Estado;
import entity.UsuarioEmpresa;
import service.ClasseGenerica;
import utils.MensFaces;

@ManagedBean
@ViewScoped
public class CadastroEmpresaMBean {

	UsuarioEmpresaDAO uDao = new UsuarioEmpresaDAO();
	private UsuarioEmpresa emp;
	boolean liberado = true;

	// Integer teste = Integer.parseInt(emp.getEstado());

	Cidade city;
	List<Cidade> cd;
	CidadeDAO cdDAO;

	Estado state;
	List<Estado> est;

	public CadastroEmpresaMBean() {

		emp = new UsuarioEmpresa();

		city = new Cidade();
		cdDAO = new CidadeDAO();

		state = new Estado();
		est = cdDAO.listarEstados();

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

	public void liberaCidade() {

		if (emp.getEstado() != null) {

			cd = cdDAO.listarCidade(Integer.parseInt(emp.getEstado()));
			cdDAO = new CidadeDAO();

			System.out.println(emp.getEstado());
			liberado = false;
		} else {
			liberado = true;
		}

	}

	public boolean isLiberado() {
		return liberado;
	}

	public void setLiberado(boolean liberado) {
		this.liberado = liberado;
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

//	public Integer getTeste() {
//		return teste;
//	}
//
//	public void setTeste(Integer teste) {
//		this.teste = teste;
//	}

	public Cidade getCity() {
		return city;
	}

	public void setCity(Cidade city) {
		this.city = city;
	}

	public List<Cidade> getCd() {
		return cd;
	}

	public void setCd(List<Cidade> cd) {
		this.cd = cd;
	}

	public CidadeDAO getCdDAO() {
		return cdDAO;
	}

	public void setCdDAO(CidadeDAO cdDAO) {
		this.cdDAO = cdDAO;
	}

	public Estado getState() {
		return state;
	}

	public void setState(Estado state) {
		this.state = state;
	}

	public List<Estado> getEst() {
		return est;
	}

	public void setEst(List<Estado> est) {
		this.est = est;
	}

}
