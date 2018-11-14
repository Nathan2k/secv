package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.VPS04.JDBC.ConnectionDB;

import entity.Cidade;

public class CidadeDAO {
	
	Connection conn;
	

	public CidadeDAO(){
		try {
			conn = ConnectionDB.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
}
	
	public List<Cidade> listarCidade(){
		
		List<Cidade> list = new ArrayList<>();
		
		String sql = " SELECT * FROM cidade; ";
		
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
		while (rs.next()) {
			
			Cidade cd = new Cidade();
			
			cd.setId(rs.getInt("id"));
			cd.setNome(rs.getString("nomeCidade"));
			
			list.add(cd);
		}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
	}
}
