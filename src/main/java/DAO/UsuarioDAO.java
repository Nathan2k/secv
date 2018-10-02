package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.VPS04.JDBC.ConnectionDB;

import entity.Usuario;
import entity.UsuarioADM;
import entity.UsuarioEmpresa;

public class UsuarioDAO {

	Connection conn;
	private String tipoUsuario;

	public UsuarioDAO() throws SQLException {

		conn = ConnectionDB.getConnection();

	}

	public Usuario busca(String email) {

		Usuario u = buscarUsuarioPorEmail(email);
		
		if(u != null) {
			
			return u;	
		}
		
		return null;
	}
	
	
//	" UPDATE ? SET senha = ? "
//	ps.setString(1, tipoUsuario)
	
	
	public boolean alterar(Usuario user) {
		
		String sql = "UPDATE ? SET senha = ? "; 

		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, tipoUsuario);
			ps.setString(2, user.getSenha());
			

			return ps.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return false;
	}
	

	public Usuario buscarUsuarioPorEmail(String email) {

		String sql = "SELECT * FROM administrador " + " WHERE email = ?;";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, email);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				UsuarioADM adm = new UsuarioADM();

				adm.setId(rs.getInt("id"));
				adm.setNIF(rs.getString("NIF"));
				adm.setEmail(rs.getString("email"));
				adm.setNome(rs.getString("nome"));
				adm.setSenha(rs.getString("senha"));
				adm.setTelefone(rs.getString("telefone"));
				
				tipoUsuario = "administrador";
				
				return adm;
			}else {
				sql = "SELECT * FROM empresa " + " WHERE email = ?;";
				ps = conn.prepareStatement(sql);

				ps.setString(1, email);

				rs = ps.executeQuery();

				if (rs.next()) {

					UsuarioEmpresa emp = new UsuarioEmpresa();

					emp.setId(rs.getInt("id"));
					emp.setCNPJ(rs.getString("CNPJ"));
					emp.setEmail(rs.getString("email"));
					emp.setNome(rs.getString("nome"));
					emp.setSenha(rs.getString("senha"));
					emp.setTelefone(rs.getString("telefone"));
					
					tipoUsuario = "empresa";

					return emp;
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	

	public Integer inserirCodigo(int codigo) {
		
		String sql = " INSERT INTO recuperarSenha (idUsuario, codigo)" 
		+ " VALUES (?, ?) ";
		
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			
			
			ps.setString(1, .getNIF());
			ps.setString(2, adm.getEmail());
			
			
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}




























