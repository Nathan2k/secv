package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.VPS04.JDBC.ConnectionDB;

import entity.Curriculo;
import service.ClasseGenerica;
import service.Experiencia;
import service.Formacao;

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
				+ "semestre, sexo, deficiencia) " 
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, c.getNomeDoAluno());
			ps.setLong(2, c.getIdade()); // VER SOBRE A PORRA DO LONG VER SE NAO VAI DAR MERDA PQ NO BD ESTA VARCHAR
			ps.setInt(3, c.getNivel_ingles());
			ps.setInt(4, c.getNivel_espanhol());
			ps.setString(5, c.getEstado());
			ps.setString(6, c.getCidade());
			ps.setString(7, c.getCurso());
			ps.setInt(8, c.getSemestre());
			ps.setInt(9, c.getSexo());
			ps.setInt(10, c.getDeficiencia());
			
			
			if (ps.executeUpdate() == 1) {
				System.out.println("Curriculo cadastrado ");
			} else {
				System.out.println("Problemas ao cadastrar Curriculo");
				return false;
			}
			return true;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// FICAR ATENTO AO TIPO DE VARIAVEIS
		// CONTINUAR A FAZER O INSERIR CURRICULO E SEM SEGUIDA FAZER O DAO INSERIR EXPERIENCIA E O DAO FORMACAO
		return false;
	}
	
	//---------------------------------------------------------------------------------------------------

	
	public boolean inserirExperiencia(Experiencia ex) {
		
		String sql = "INSERT INTO experiencia(nomeDaEmpresa, data_inicio, data_fim, funçao, cargo) VALUES(?, ?, ?, ?, ?) ";
		
		
		try {
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, ex.getEmpresa());
			ps.setLong(2, ex.getData_inicio());
			ps.setLong(3, ex.getData_fim());
			ps.setString(4, ex.getFuncoes());
			ps.setString(5, ex.getCargo());
			
			if (ps.executeUpdate() == 1) {
				System.out.println("Experiencia cadastrada ");
			} else {
				System.out.println("Problemas ao cadastrar experiencia");
				return false;
			}
			return true;
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return false;
		
	}
	
	public boolean inserirFormacao(Formacao fo) {
		
		String sql = "INSERT INTO formacao(nomeDoCurso, data_inicio, data_fim, escola) VALUES(?, ?, ?, ?)";
		
		try {
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, fo.getNome());
			ps.setLong(2, fo.getData_inicio());
			ps.setLong(3, fo.getData_fim());
			ps.setString(4, fo.getEscola());
			
			if (ps.executeUpdate() == 1) {
				System.out.println("Formação cadastrada ");
			} else {
				System.out.println("Problemas ao cadastrar Formação");
				return false;
			}
			return true;
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		return false;
	}
	
	
	
	
	
	
	
	
	
	
	

}
