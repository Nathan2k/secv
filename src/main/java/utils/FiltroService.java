package utils;

import java.io.IOException;

import javax.faces.bean.ManagedBean;

import com.google.gson.Gson;

import entity.Filtro;

@ManagedBean
public class FiltroService {

	private Filtro eFiltro = new Filtro();

	public void enviarFiltro() throws IOException {

		String url = "http://10.0.2.2:8080/aula_rest/ws/filmes/todos"; // URL FICTICIO!

		HttpHelper http = new HttpHelper();

		String json = http.doGet(url);

		Gson gson = new Gson();

		json = gson.toJson(eFiltro, Filtro.class);

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public Filtro geteFiltro() {
		return eFiltro;
	}

	public void seteFiltro(Filtro eFiltro) {
		this.eFiltro = eFiltro;
	}

}
