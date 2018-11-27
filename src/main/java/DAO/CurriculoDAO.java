package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.VPS04.JDBC.ConnectionDB;

import entity.Curriculo;
import service.Experiencia;
import service.Formacao;

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

	public List<Curriculo> listarCurriculo(Integer idFiltro) {

		List<Curriculo> list = new ArrayList<>();

		String sql = " SELECT * FROM curriculo WHERE idFiltro = ?";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, idFiltro);
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
				
				cl.setExperiencia(listarExperiencia(cl.getId()));
				cl.setFormação(listarFormacao(cl.getId()));

				list.add(cl);
				
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;

	}

	// -----------------------------------------------------------------------------------------------------------

	public List<Formacao> listarFormacao(Integer idCurriculo) { // VER PQ NAO TA LISTANDO FORMAÇÃO NEM EXPERIENCIA

		List<Formacao> list = new ArrayList<>();

		String sql = "SELECT * FROM formacao WHERE idCurriculo = ?";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, idCurriculo);
			ResultSet rs = ps.executeQuery();

			// crt
			while (rs.next()) {

				Formacao forma = new Formacao();

				forma.setId(rs.getInt("id"));
				forma.setIdCurriculo(rs.getInt("idCurriculo"));
				forma.setData_inicio(rs.getLong("data_inicio"));
				forma.setData_fim(rs.getLong("data_fim"));
				forma.setEscola(rs.getString("escola"));
				forma.setNome(rs.getString("nomeDoCurso"));

				list.add(forma);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Ele nao entrou no While no ListarFormacao!");
			e.printStackTrace();
		}

		return list;
	}

	// -----------------------------------------------------------------------------------------------------------

	public List<Experiencia> listarExperiencia(Integer idCurriculo) {

		List<Experiencia> list = new ArrayList<>();

		String sql = "SELECT * FROM experiencia WHERE idCurriculo = ?";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, idCurriculo);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				Experiencia exp = new Experiencia();

				exp.setId(rs.getInt("id"));
				exp.setIdCurriculo(rs.getInt("idCurriculo"));
				exp.setData_inicio(rs.getLong("data_inicio"));
				exp.setData_fim(rs.getLong("data_fim"));
				exp.setCargo(rs.getString("cargo"));
				exp.setFuncoes(rs.getString("funçao"));
				exp.setEmpresa(rs.getString("nomeDaEmpresa"));

				list.add(exp);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}
	
	

}
