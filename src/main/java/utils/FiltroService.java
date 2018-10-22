package utils;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

import javax.faces.bean.ManagedBean;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import entity.Cidade;
import entity.Curriculo;
import entity.Filtro;
import service.ClasseGenerica;
import service.CurriculumVitae;

@ManagedBean
public class FiltroService {
// MANDO ESSE CARA
	private Filtro eFiltro = new Filtro();

	// ENVIA O FILTRO PRO DONI
	public List<CurriculumVitae> enviarFiltro(Filtro f) throws IOException {

		String url = "http://10.0.2.2:8080/aula_rest/ws/filmes/todos"; // URL FICTICIO!

		HttpHelper http = new HttpHelper();

		Gson gson = new Gson();

		String json = gson.toJson(f, Filtro.class);
		http.setContentType("application/json");

		String response = http.doPost(url, json.getBytes(), "UTF-8");

		Type collectionType = new TypeToken<List<CurriculumVitae>>() {
		}.getType();
		List<CurriculumVitae> curriculos = gson.fromJson(response, collectionType);

		return curriculos;
	}

	// RECEBE AS CIDADES QUE TEM CURRICULO
	public List<ClasseGenerica> cCidade() throws IOException {

		String url = "http://10.87.202.146:8080/sccv-api/ws/cidades/disponiveis"; // URL FICTICIO!
		HttpHelper http = new HttpHelper();
		Gson gson = new Gson();

		String response = http.doGet(url);

		Type collectionType = new TypeToken<List<ClasseGenerica>>() {
		}.getType();
		List<ClasseGenerica> cidades = gson.fromJson(response, collectionType);

		return cidades;
	}

	// RECEBE AS AREAS QUE TEM CURRICULO
	public List<ClasseGenerica> cArea(List<ClasseGenerica> cidade) throws IOException {

		String url = "http://10.0.2.2:8080/aula_rest/ws/filmes/todos"; // URL FICTICIO!
		HttpHelper http = new HttpHelper();
		Gson gson = new Gson();
		
		String json = gson.toJson(cidade, Filtro.class);
		http.setContentType("application/json");

		String response = http.doPost(url, json.getBytes(), "UTF-8");

		Type collectionType = new TypeToken<List<ClasseGenerica>>() {
		}.getType();
		List<ClasseGenerica> area = gson.fromJson(response, collectionType);

		return area;
	}

	// RECEBE OS CURSOS QUE TEM CURRICULO
	public List<ClasseGenerica> cCurso() throws IOException {

		String url = "http://10.0.2.2:8080/aula_rest/ws/filmes/todos"; // URL FICTICIO!
		HttpHelper http = new HttpHelper();
		Gson gson = new Gson();

		String response = http.doGet(url);

		Type collectionType = new TypeToken<List<ClasseGenerica>>() {
		}.getType();
		List<ClasseGenerica> curso = gson.fromJson(response, collectionType);

		return curso;
	}

	// RECEBE OS SEMESTRES QUE TEM CURRICULO
	public List<ClasseGenerica> cSemestre() throws IOException {

		String url = "http://10.0.2.2:8080/aula_rest/ws/filmes/todos"; // URL FICTICIO!
		HttpHelper http = new HttpHelper();
		Gson gson = new Gson();
		String response = http.doGet(url);

		Type collectionType = new TypeToken<List<ClasseGenerica>>() {
		}.getType();
		List<ClasseGenerica> semestre = gson.fromJson(response, collectionType);

		return semestre;
	}

	// RECEBE OS IDIOMAS QUE TEM CURRICULO
	public List<ClasseGenerica> cIdioma() throws IOException {

		String url = "http://10.0.2.2:8080/aula_rest/ws/filmes/todos"; // URL FICTICIO!
		HttpHelper http = new HttpHelper();
		Gson gson = new Gson();
		String response = http.doGet(url);

		Type collectionType = new TypeToken<List<ClasseGenerica>>() {
		}.getType();
		List<ClasseGenerica> idioma = gson.fromJson(response, collectionType);

		return idioma;
	}

	public Filtro geteFiltro() {
		return eFiltro;
	}

	public void seteFiltro(Filtro eFiltro) {
		this.eFiltro = eFiltro;
	}

}
