package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.VPS04.JDBC.ConnectionDB;

import entity.UsuarioADM;

public class UsuarioAdmDAO {

	
	Connection conn;

	public UsuarioAdmDAO() {
		conn = ConnectionDB.getConnection();
	}
	
	
	
	public UsuarioADM buscarADM(int nif, String senha) {

		String sql = "SELECT * FROM administrador " + "WHERE NIF = ? AND senha = ?;";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, nif);
			ps.setString(2, senha);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

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
	
	//---------------------------------------------------------------------------------------------------
	
	
	
	
	
	
	
	
	
	
	
	
}
