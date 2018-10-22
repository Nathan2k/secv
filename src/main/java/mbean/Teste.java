package mbean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import entity.Cidade;
import service.ClasseGenerica;
import utils.FiltroService;

public class Teste {

	public static void main(String[] args) {
		
		List<ClasseGenerica> cidades = new ArrayList<>();
		FiltroService fs = new FiltroService();
		try {
			cidades = fs.cCidade();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(ClasseGenerica cidade : cidades) {
			System.out.println(cidade.getCodigo() + cidade.getNome());
		}
		
	}

}
