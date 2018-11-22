package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.VPS04.JDBC.ConnectionDB;

import entity.Curriculo;

public class CurriculoDAO {

	Connection conn;

	public CurriculoDAO() {
		try {
			conn = ConnectionDB.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public List<Curriculo> listarCurriculo() {

		List<Curriculo> list = new ArrayList<>();

		String sql = " SELECT * FROM curriculo; ";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				Curriculo cl = new Curriculo();

				cl.setId(rs.getInt("id"));
				cl.setEmail(rs.getString("email"));
				cl.setNomeDoAluno(rs.getString("nome_aluno"));
				cl.setIdade(rs.getString("idade"));
				cl.setNivel_ingles(rs.getInt("nivelIngles"));
				cl.setNivel_espanhol(rs.getInt("nivelEspanhol"));
				cl.setCidade(rs.getString("cidade"));
				cl.setEstado(rs.getString("estado"));
				cl.setCurso(rs.getString("curso"));
				cl.setSemestre(rs.getInt("semestre"));
				cl.setSexo(rs.getString("sexo"));
				cl.setDeficiencia(rs.getString("deficiencia"));
				cl.setTelefone(rs.getString("telefone"));

				list.add(cl);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;

	}
}
