package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import entity.Empresa;

public class UsuarioDAO {

	Connection conn;
	
	public Empresa buscarUsuario(int cnpj) { // perguntar sobre a senha
		
		String sql = " SELECT * FROM empresa"
				+ " WHERE CNPJ = ? AND senha = ?"; // perguntar se falta alguma coisa 		
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, cnpj);
			
			java.sql.ResultSet rs = ps.executeQuery(); //perguntar como tirar o java.sql.resultset
			
			if(rs.next()) {
				Empresa emp = new Empresa();
				
				emp.setId(rs.getInt("id"));// perguntar se o ID é igual a variavel q esta no banco
				emp.setBairro(rs.getString("bairro"));
				emp.setCidade(rs.getString("cidade"));
				emp.setRua(rs.getString("rua"));
				emp.setSenha(rs.getString("senha"));
				emp.setNome(rs.getString("nome"));
				
			}
			
			
			
			
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return null;
	}
	
	/*
	 *  PreparedStatement ps = conn.prepareStatement(sql);
			
			//Substitui a interrogação pelo conteudo da variavel usuário
			ps.setString(1, usuario);
			
			//executar a consulta
			ResultSet rs = ps.executeQuery();
			
			//se retornar pelo menos um registro
			if(rs.next()){
				Usuario u = new Usuario();
				//preenche o usuario a ser retornado
				u.setCodUsuario(rs.getInt("codUsuario"));
				u.setNome(rs.getString("nome"));
				u.setUsuario(rs.getString("usuario"));
				u.setSenha(rs.getString("senha"));
				Acesso a = new Acesso();
				a.setCodAcesso(rs.getInt("codAcesso"));
				a.setDescricao(rs.getString("descricao"));
				u.setAcesso(a);
				
				//retorna usuario
				return u;
	 *  
	 *  */
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
