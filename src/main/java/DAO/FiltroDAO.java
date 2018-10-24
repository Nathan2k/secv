package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.VPS04.JDBC.ConnectionDB;

import entity.Curriculo;
import service.ClasseGenerica;
import service.Experiencia;

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

	
	
	
	// ver sobre o curriculoVitae e sobre curriculo OKAYDA
	
	//VER ATABELA FORMAÇÃO NO BANCO e perguntar a diferença de nome e formação OKAYDA
	
	//falar sobre o ajax nao suportado
	
	//fazer DAO de inserir curriculo!
	
	//perguntar sobre o banco de dados como q vai fazer o inserir se tem varias tabelas
	
	//ver sobre o metodo no mbean que vai passando
	
	
	public boolean inserirCurriculo(Curriculo c) {
		
		String sql = "INSERT INTO curriculo (nome_aluno, idade, nivelIngles, nivelEspanhol, estado, cidade, curso, "
				+ "semestre, sexo, deficiencia, idExperiecia, idFormaçao) " 
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, c.getNomeDoAluno());
			ps.setLong(2, c.getIdade()); // VER SOBRE A PORRA DO LONG VER SE NAO VAI DAR MERDA PQ NO BD ESTA VARCHAR
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// FICAR ATENTO AO TIPO DE VARIAVEIS
		// CONTINUAR A FAZER O INSERIR CURRICULO E SEM SEGUIDA FAZER O DAO INSERIR EXPERIENCIA E O DAO FORMACAO
		
		
		
		return false;
	}
	
	
	
	

}
