package utils;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

import javax.faces.bean.ManagedBean;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import entity.Curriculo;
import entity.Filtro;

@ManagedBean
public class FiltroService {

	private Filtro eFiltro = new Filtro();

	public List<Curriculo> enviarFiltro(Filtro f) throws IOException {

		String url = "http://10.0.2.2:8080/aula_rest/ws/filmes/todos"; // URL FICTICIO!

		HttpHelper http = new HttpHelper();
		
		Gson gson = new Gson();
		
		String json = gson.toJson(f, Filtro.class);
		http.setContentType("application/json");

		String response = http.doPost(url, json.getBytes(), "UTF-8");

		Type collectionType = new TypeToken<List<Curriculo>>(){}.getType();
		List<Curriculo> curriculos = gson.fromJson(response, collectionType);
		
		
		return curriculos;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public Filtro geteFiltro() {
		return eFiltro;
	}

	public void seteFiltro(Filtro eFiltro) {
		this.eFiltro = eFiltro;
	}

}
