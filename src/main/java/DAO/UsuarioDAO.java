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

	public UsuarioDAO() throws SQLException {

		conn = ConnectionDB.getConnection();

	}

	public Usuario busca(String email) {

		Usuario uadm = buscarADM(email);

		UsuarioEmpresa uemp = null;

		try {
			uemp = buscarEmpresa(email);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (uadm != null) {

			return uadm;

		} else if (uemp != null) {

			return uemp;
		}

		return null;
	}
	
	
	
	
	
	

	public UsuarioADM buscarADM(String nif) {

		String sql = "SELECT * FROM administrador " + "WHERE NIF = ?;";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, nif);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				UsuarioADM adm = new UsuarioADM();

				adm.setId(rs.getInt("id"));
				adm.setNIF(rs.getString("NIF"));
				adm.setEmail(rs.getString("email"));
				adm.setNome(rs.getString("nome"));
				adm.setSenha(rs.getString("senha"));
				adm.setTelefone(rs.getString("telefone"));

				return adm;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public UsuarioEmpresa buscarEmpresa(String cnpj) throws SQLException { // perguntar sobre a senha

		String sql = "SELECT * FROM empresa " + "WHERE CNPJ = ?;"; // perguntar se falta alguma coisa

		PreparedStatement ps = conn.prepareStatement(sql);

		ps.setString(1, cnpj);

		ResultSet rs = ps.executeQuery(); // perguntar como tirar o java.sql.resultset
		UsuarioEmpresa emp = null;
		if (rs.next()) {
			emp = new UsuarioEmpresa();

			emp.setId(rs.getInt("id"));// perguntar se o ID é igual a variavel q esta no banco
			emp.setBairro(rs.getString("bairro"));
			emp.setCidade(rs.getString("cidade"));
			emp.setRua(rs.getString("rua"));
			emp.setSenha(rs.getString("senha"));
			emp.setNome(rs.getString("nome"));
			emp.setCNPJ(rs.getString("CNPJ"));
			emp.setEmail(rs.getString("email"));
			emp.setRepresentante(rs.getString("representante"));
			emp.setTelefone(rs.getString("telefone"));

		}
		return emp;

	}

}
