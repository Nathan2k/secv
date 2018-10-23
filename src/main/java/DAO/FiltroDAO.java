package DAO;

import java.sql.Connection;
import java.sql.SQLException;

import com.VPS04.JDBC.ConnectionDB;

public class FiltroDAO {
	
	Connection conn;

	public FiltroDAO() {
		
		try {
			conn = ConnectionDB.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	//fazer DAO de inserir curriculo!
	
	// ver sobre o curriculoVitae e sobre curriculo
	
	//VER ATABELA FORMAÇÃO NO BANCO e perguntar a diferença de nome e formação
	
	//falar sobre o afax nao suportado
	
	//ver sobre o metodo no mbean que vai passando
	
	
	
	
	
	
	

}
