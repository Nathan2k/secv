package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.UsuarioADM;
import entity.UsuarioEmpresa;

public class UsuarioDAO {

	Connection conn;
	
	public UsuarioEmpresa buscarEmpresa(int cnpj) { // perguntar sobre a senha
		
		String sql = " SELECT * FROM empresa"
				+ " WHERE CNPJ = ? AND senha = ?"; // perguntar se falta alguma coisa 		
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, cnpj);
			
			java.sql.ResultSet rs = ps.executeQuery(); //perguntar como tirar o java.sql.resultset
			
			if(rs.next()) {
				UsuarioEmpresa emp = new UsuarioEmpresa();
				
				emp.setId(rs.getInt("id"));// perguntar se o ID é igual a variavel q esta no banco
				emp.setBairro(rs.getString("bairro"));
				emp.setCidade(rs.getString("cidade"));
				emp.setRua(rs.getString("rua"));
				emp.setSenha(rs.getString("senha"));
				emp.setNome(rs.getString("nome"));
				
				return emp;
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	//---------------------------------------------------------------------------------------------
	
	public UsuarioADM buscarADM(int nif) {
		
		String sql = " SELECT * FROM administrador"
				+ " WHERE CNPJ = ? AND senha = ?";
		
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, nif);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				
				UsuarioADM adm = new UsuarioADM();
				
				adm.setId(rs.getInt("id"));
				adm.setNIF(rs.getInt("NIF"));
				adm.setEmail(rs.getString("email"));
				adm.setNome(rs.getString("nome"));
				adm.setSenha(rs.getString("senha"));
				adm.setTelefone(rs.getInt("telefone"));
				
				return adm;
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	
	//---------------------------------------------------------------------------------------------

	public boolean inserirEmpresa(UsuarioEmpresa emp) {
		
		
		return false;
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
}
