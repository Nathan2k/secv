package mbean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import DAO.CidadeDAO;
import entity.Cidade;
import entity.Estado;
import entity.UsuarioEmpresa;

@ManagedBean
@ViewScoped
public class CidadeMBean {

	Cidade city;
	List<Cidade> cd;
	CidadeDAO cdDAO;

	Estado state;
	List<Estado> est;

	@ManagedProperty(value = "#{cadastroEmpresaMBean}")
	private CadastroEmpresaMBean userEmp;

	private UsuarioEmpresa emp;

	public void setUserEmp(CadastroEmpresaMBean userEmp) {
		this.userEmp = userEmp;
	}

	public CidadeMBean() {

		System.out.println("listando cidades");

		emp = userEmp.getEmp(); //TENTANDO PEGAR O USUARIO EMP PARA PODER PEGAR O ESTADO!

		city = new Cidade();
		cdDAO = new CidadeDAO();

		state = new Estado();
		est = cdDAO.listarEstados();

		cd = cdDAO.listarCidade(Integer.parseInt(emp.getEstado()));
		cdDAO = new CidadeDAO();

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

}
