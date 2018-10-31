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

	// ENVIA O FILTRO PRO DONI
	public List<Curriculo> enviarFiltro(Filtro f) throws IOException {

		String url = "http://10.0.2.2:8080/aula_rest/ws/filmes/todos"; // URL FICTICIO!

		HttpHelper http = new HttpHelper();

		Gson gson = new Gson();

		String json = gson.toJson(f, Filtro.class);
		http.setContentType("application/json");

		String response = http.doPost(url, json.getBytes(), "UTF-8");

		Type collectionType = new TypeToken<List<Curriculo>>() {
		}.getType();
		List<Curriculo> curriculos = gson.fromJson(response, collectionType);

		return curriculos;
	}

	// RECEBE AS CIDADES QUE TEM CURRICULO
	public List<ClasseGenerica> cCidade() throws IOException {

		String url = "http://10.87.202.146:8080/sccv-api/ws/cidades/disponiveis"; // URL CERTO!
		HttpHelper http = new HttpHelper();
		Gson gson = new Gson();

		String response = http.doGet(url);

		Type collectionType = new TypeToken<List<ClasseGenerica>>() {}.getType();
		List<ClasseGenerica> cidades = gson.fromJson(response, collectionType);

		return cidades;
	}

	// RECEBE AS AREAS QUE TEM CURRICULO
	public List<ClasseGenerica> cArea(Filtro cidade) throws IOException {

		String url = "http://10.87.202.146:8080/sccv-api/ws/areas/por-cidades"; // URL CERTO!
		HttpHelper http = new HttpHelper();
		Gson gson = new Gson();
		
		String json = gson.toJson(cidade, Filtro.class);
		http.setContentType("application/json");

		String response = http.doPost(url, json.getBytes(), "UTF-8");
		
		Type collectionType = new TypeToken<List<ClasseGenerica>>() {}.getType();
		List<ClasseGenerica> area = gson.fromJson(response, collectionType);

		return area;
	}

	// RECEBE OS CURSOS QUE TEM CURRICULO
	public List<ClasseGenerica> cCurso(Filtro area) throws IOException {

		String url = "http://10.87.202.146:8080/sccv-api/ws/cursos/por-filtro"; // URL CERTO!
		HttpHelper http = new HttpHelper();
		Gson gson = new Gson();

		Type collectionType = new TypeToken<List<ClasseGenerica>>() {
		}.getType();

		String json = gson.toJson(area, collectionType);
		http.setContentType("application/json");

		String response = http.doPost(url, json.getBytes(), "UTF-8");

		List<ClasseGenerica> curso = gson.fromJson(response, collectionType);

		return curso;
	}

	// RECEBE OS SEMESTRES QUE TEM CURRICULO
	public List<ClasseGenerica> cSemestre(Filtro curso) throws IOException {

		String url = "http://10.0.2.2:8080/aula_rest/ws/filmes/todos"; // URL FICTICIO!
		HttpHelper http = new HttpHelper();
		Gson gson = new Gson();

		Type collectionType = new TypeToken<List<ClasseGenerica>>() {
		}.getType();

		String json = gson.toJson(curso, collectionType);
		http.setContentType("application/json");

		String response = http.doPost(url, json.getBytes(), "UTF-8");

		List<ClasseGenerica> semestre = gson.fromJson(response, collectionType);

		return semestre;
	}

	// RECEBE OS IDIOMAS QUE TEM CURRICULO
	public List<ClasseGenerica> cIdioma(Filtro semestre) throws IOException {

		String url = "http://10.0.2.2:8080/aula_rest/ws/filmes/todos"; // URL FICTICIO!
		HttpHelper http = new HttpHelper();
		Gson gson = new Gson();

		Type collectionType = new TypeToken<List<ClasseGenerica>>() {
		}.getType();

		String json = gson.toJson(semestre, collectionType);
		http.setContentType("application/json");

		String response = http.doPost(url, json.getBytes(), "UTF-8");

		List<ClasseGenerica> idioma = gson.fromJson(response, collectionType);

		return idioma;
	}

//	public boolean experiencia() {
//
//		String url = "http://10.0.2.2:8080/aula_rest/ws/filmes/todos"; // URL FICTICIO!
//		HttpHelper http = new HttpHelper();
//		Gson gson = new Gson();
//
//		
//		
//		
//		return false;
//	}

}
