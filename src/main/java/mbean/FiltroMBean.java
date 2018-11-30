package mbean;

import java.awt.geom.Area;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import org.eclipse.jdt.internal.compiler.parser.ParserBasicInformation;
import org.primefaces.behavior.ajax.AjaxBehaviorHandler;
import org.primefaces.component.selectonemenu.SelectOneMenu;

import entity.Curriculo;
import entity.Filtro;
import entity.UsuarioEmpresa;
import service.ClasseGenerica;
import utils.FiltroService;
import utils.MensFaces;

import com.google.gson.Gson;
import com.google.gson.annotations.*;

import DAO.CurriculoDAO;
import DAO.FiltroDAO;

@ManagedBean(eager = true)
@SessionScoped
public class FiltroMBean {

	private Filtro eFiltro = new Filtro();

	List<ClasseGenerica> estado = new ArrayList<>();
	List<ClasseGenerica> cidades = new ArrayList<>();
	List<ClasseGenerica> area = new ArrayList<>();
	List<ClasseGenerica> curso = new ArrayList<>();
	List<ClasseGenerica> semestre = new ArrayList<>();
	List<ClasseGenerica> idioma = new ArrayList<>();
	List<ClasseGenerica> selCidade = new ArrayList<>();
	String areaSel;
	String cursoSel;

	Integer idFiltro;

	boolean liberado = true; // RESPONSAVEL POR LIBERAR O CAMPO NV IDIOMA

	Calendar anoAtual = GregorianCalendar.getInstance();

	FiltroDAO fDao = new FiltroDAO();
	CurriculoDAO cDao = new CurriculoDAO();

	boolean filtroP = false; // é o rendered da tela depois do filtro
	boolean filtroF = true; // é o rendered do filtro

	FiltroService fs = new FiltroService();

	@ManagedProperty(value = "#{usuarioMBean}")
	private UsuarioMBean userMb;

	List<Filtro> filtros;
	

	@PostConstruct
	public void conts() {
		criarFiltros();
		
	}

	// SALVA O FILTRO NO BANCO E MUDA A TELA DO filtro.xhtml
	public Integer salvaFiltro() {
		if (userMb.getEmp() != null) {
			eFiltro.setIdEmpresa(userMb.getEmp().getId());
			eFiltro.setIdAdm(0);
			filtroP = true;
			filtroF = false;
			criarFiltros();
			eFiltro.setIdCurso(cursoSel);
			
			return fDao.inserirFiltro(eFiltro);

		} else {

			eFiltro.setIdAdm(userMb.getAdm().getId());
			eFiltro.setIdEmpresa(0);
			filtroP = true;
			filtroF = false;
			criarFiltros();
			return fDao.inserirFiltro(eFiltro);
		}
	}

	public void finalizaBt() {

		filtroP = false;
		filtroF = true;

	}

	// RESPONSAVEL POR LIBERAR O CAMPO NV IDIOMA
	public void liberaIdioma() {

		if (eFiltro.getQualIdioma() != null && eFiltro.getQualIdioma() != 0) {

			liberado = false;

		} else {
			liberado = true;
		}

	}

	// ESSE CARA SERVE PARA LISTAR OS FILTROS NO ADM OU NO USUARIO EMPRESA!(TELA HISTORICO)
	public void criarFiltros() {
		if (userMb.getAdm() == null) {

			filtros = cDao.listarFiltro(userMb.getEmp().getId(), false);

		} else {
			filtros = cDao.listarFiltro(userMb.getAdm().getId(), true);

		}
	}
	
	
	
	
	
	

	// RESPONSAVEL POR CONSEGUIR PASSAR A ENTIDADE NO VALUE DO SELECT ONE MENU
	public List<SelectItem> pegandoArea() {

		List<SelectItem> pArea = new ArrayList<SelectItem>();

		for (ClasseGenerica c : this.area) {

			pArea.add(new SelectItem(c, c.getNome()));
		}

		return pArea;

	}

	// PEGA AS CIDADES COM CURRICULO CADASTRADO
	public FiltroMBean() {
		eFiltro.setIdade_inicio(18);
		eFiltro.setIdade_fim(40);
		eFiltro.setIdEstado(1);
		try {
			cidades = fs.cCidade();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// PEGA AS AREAS COM CURRICULO CADASTRADO
	public void attArea() {
		try {
			area = fs.cArea(eFiltro);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// PEGA OS CURSOS COM CURRICULO CADASTRADO
	public void attCurso(AjaxBehaviorEvent event) {
		areaSel = eFiltro.getArea();
		String codigo = areaSel.substring(0, areaSel.lastIndexOf("-"));
		areaSel = areaSel.substring(areaSel.lastIndexOf("-") + 1);
		eFiltro.setArea(codigo);
		try {
			curso = fs.cCurso(eFiltro);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// PEGA OS SEMESTRES COM CURRICULO CADASTRADO
	public void attSemestre() {
		cursoSel = eFiltro.getIdCurso().toString();
		String codigo = cursoSel.substring(0, cursoSel.lastIndexOf("-"));
		cursoSel = cursoSel.substring(cursoSel.lastIndexOf("-") + 1);
		eFiltro.setIdCurso(codigo);
		try {
			semestre = fs.cSemestre(eFiltro);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void enviarFiltro() throws IOException {
		System.out.println("Chamou o EnviarFiltro");
		System.out.println(anoAtual.get(Calendar.YEAR));

		eFiltro.setIdade_fim(trocandoAno(eFiltro.getIdade_fim())); // VER SE TA CERTO!!
		eFiltro.setIdade_inicio(trocandoAno(eFiltro.getIdade_inicio()));

		areaSel = eFiltro.getArea();
		String codigo = areaSel.substring(0, areaSel.lastIndexOf("-"));
		areaSel = areaSel.substring(areaSel.lastIndexOf("-") + 1);
		eFiltro.setArea(codigo);

		cursoSel = eFiltro.getIdCurso().toString();
		String codigo2 = cursoSel.substring(0, cursoSel.lastIndexOf("-"));
		cursoSel = cursoSel.substring(cursoSel.lastIndexOf("-") + 1);
		eFiltro.setIdCurso(codigo2);

		List<Curriculo> curriculos = fs.enviarFiltro(eFiltro); // DA ERRO 404 AQUI

		if (curriculos == null) {

			MensFaces.m("Ocorreu um erro ao enviar o filtro!");
			FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);

		}
		if (curriculos.isEmpty()) {

			MensFaces.m("Nenhum Curriculo foi encontrado! Tente mudar algum Filtro!");
			FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
		} else {
			idFiltro = salvaFiltro();
			for (Curriculo c : curriculos) {
				c.setIdFiltro(idFiltro);
				fDao.inserirCurriculo(c); // FICA ANDANDO NA LISTA E INSERE UM POR UM
			}
		}
	}
	
	
	public Integer trocandoAno(int anoConvertido) {

		System.out.println(anoAtual.get(Calendar.YEAR));

		int anoAt;

		anoAt = anoAtual.get(Calendar.YEAR);

		anoConvertido = anoAt - anoConvertido;

		return anoConvertido;
	}

	// PERGUNTAR COMO CAPTURAR E ENVIAR FAIXA ETARIA

	public FiltroDAO getfDao() {
		return fDao;
	}

	public void setfDao(FiltroDAO fDao) {
		this.fDao = fDao;
	}

	public boolean isFiltroP() {
		return filtroP;
	}

	public void setFiltroP(boolean filtroP) {
		this.filtroP = filtroP;
	}

	public String getCursoSel() {
		return cursoSel;
	}

	public Integer getIdFiltro() {
		return idFiltro;
	}

	public List<Filtro> getFiltros() {
		return filtros;
	}

	public void setFiltros(List<Filtro> filtros) {
		this.filtros = filtros;
	}

	public void setIdFiltro(Integer idFiltro) {
		this.idFiltro = idFiltro;
	}

	public void setCursoSel(String cursoSel) {
		this.cursoSel = cursoSel;
	}

	public Calendar getAnoAtual() {
		return anoAtual;
	}

	public void setAnoAtual(Calendar anoAtual) {
		this.anoAtual = anoAtual;
	}

	public UsuarioMBean getUserMb() {
		return userMb;
	}

	public Filtro geteFiltro() {
		return eFiltro;
	}

	public void seteFiltro(Filtro eFiltro) {
		this.eFiltro = eFiltro;
	}
	
	

	public CurriculoDAO getcDao() {
		return cDao;
	}

	public void setcDao(CurriculoDAO cDao) {
		this.cDao = cDao;
	}


	public List<ClasseGenerica> getEstado() {
		return estado;
	}

	public void setEstado(List<ClasseGenerica> estado) {
		this.estado = estado;
	}

	public List<ClasseGenerica> getCidades() {
		return cidades;
	}

	public void setCidades(List<ClasseGenerica> cidades) {
		this.cidades = cidades;
	}

	public List<ClasseGenerica> getArea() {
		return area;
	}

	public void setArea(List<ClasseGenerica> area) {
		this.area = area;
	}

	public List<ClasseGenerica> getCurso() {
		return curso;
	}

	public void setCurso(List<ClasseGenerica> curso) {
		this.curso = curso;
	}

	public List<ClasseGenerica> getSemestre() {
		return semestre;
	}

	public void setSemestre(List<ClasseGenerica> semestre) {
		this.semestre = semestre;
	}

	public List<ClasseGenerica> getIdioma() {
		return idioma;
	}

	public void setIdioma(List<ClasseGenerica> idioma) {
		this.idioma = idioma;
	}

	public List<ClasseGenerica> getSelCidade() {
		return selCidade;
	}

	public void setSelCidade(List<ClasseGenerica> selCidade) {
		this.selCidade = selCidade;
	}

	public FiltroService getFs() {
		return fs;
	}

	public void setFs(FiltroService fs) {
		this.fs = fs;
	}

	public String getAreaSel() {
		return areaSel;
	}

	public void setAreaSel(String areaSel) {
		this.areaSel = areaSel;
	}

	public boolean isFiltroF() {
		return filtroF;
	}

	public void setFiltroF(boolean filtroF) {
		this.filtroF = filtroF;
	}

	public void setUserMb(UsuarioMBean userMb) {
		this.userMb = userMb;
	}

	public boolean isLiberado() {
		return liberado;
	}

	public void setLiberado(boolean liberado) {
		this.liberado = liberado;
	}

}
