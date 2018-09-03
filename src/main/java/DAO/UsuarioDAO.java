package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

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
		
		//PERGUNTAR SE TEM QUE COLOCAR O ID TAMBEM ALI NO INSERT INTO
		
		String sql = " INSERT INTO empresa (senha, nome, CNPJ, cidade, "
				   + " bairro, rua, email, telefone, representante)"
				   + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?) ";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, emp.getSenha());
			ps.setString(2, emp.getNome());
			ps.setInt(3, emp.getCNPJ());
			ps.setString(4, emp.getCidade());
			ps.setString(5, emp.getBairro());
			ps.setString(6, emp.getRua());
			ps.setString(7, emp.getEmail());
			ps.setInt(8, emp.getTelefone());
			ps.setString(9, emp.getRepresentante());
			
			if(ps.executeUpdate() == 1){
				System.out.println("Usuário empresa cadastrado ");
			}else{
				System.out.println("Problemas ao cadastrar usuário empresa");
			}
			return true;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		
		
	}
	
	//falta fazer o inserir adm
	
	
	public boolean inserirADM(UsuarioADM adm) {
		
		//PERGUNTAR SE TEM QUE COLOCAR O ID TAMBEM ALI NO INSERT INTO
		
		String sql = " INSERT INTO administrador (NIF, email, nome, senha, "
				   + " telefone)"
				   + " VALUES (?, ?, ?, ?, ?) ";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, adm.getNIF());
			ps.setString(2, adm.getEmail());
			ps.setString(3, adm.getNome());
			ps.setString(4, adm.getSenha());
			ps.setInt(5, adm.getTelefone());

			if(ps.executeUpdate() == 1){
				System.out.println("Usuário adm cadastrado ");
			}else{
				System.out.println("Problemas ao cadastrar usuário adm");
			}
			return true;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	
	
	
	
	
}
