package service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import entity.Filtro;
import utils.FiltroService;

public class Teste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		FiltroService fService = new FiltroService();
//		Filtro f = new Filtro();
//		f.setArea("Area teste");
//		f.setDeficiencia(true);
//		f.setExperiencia(false);
//		f.setId(1);
//		f.setIdCurso(10);
//		f.setIdioma(false);
//		
//		try {
//			fService.enviarFiltro(f);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		Long l = (long) 915667200;

		System.out.println(CalcIdade.calc(l));

	}

}
