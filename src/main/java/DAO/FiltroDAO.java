package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.VPS04.JDBC.ConnectionDB;

import entity.Cidade;
import entity.Curriculo;
import entity.Filtro;
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

	public boolean inserirCurriculo(Curriculo c) {

		String sql = "INSERT INTO curriculo (nome_aluno, idade, nivelIngles, nivelEspanhol, estado, cidade, curso, "
				+ "semestre, sexo, deficiencia, email, telefone, idFiltro) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";

		try {

			PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			ps.setString(1, c.getNomeDoAluno());
			ps.setLong(2, c.getIdade());
			ps.setInt(3, c.getNivel_ingles());
			ps.setInt(4, c.getNivel_espanhol());
			ps.setString(5, c.getEstado());
			ps.setString(6, c.getCidade());
			ps.setString(7, c.getCurso());
			ps.setInt(8, c.getSemestre()); // ARRUMAR AQUI Q TA COM ERRO!
			ps.setString(9, c.getSexo());
			ps.setString(10, c.getDeficiencia());
			ps.setString(11, c.getEmail());
			ps.setString(12, c.getTelefone());
			ps.setInt(13, c.getIdFiltro());

			if (ps.executeUpdate() > 0) {

				ResultSet rs = ps.getGeneratedKeys();
				Integer idCur = null;
				if (rs.next()) {
					idCur = rs.getInt(1); // perguntar do id
				}

				for (Experiencia e : c.getExperiencia()) {
					inserirExperiencia(e, idCur);
				}
				for (Formacao fo : c.getForma��o()) { // AQUI ESTAMOS COLOCANDO NA LISTA FORMA��O E EXPERIENCIA AS
														// FORMA��ES E EXPERIENCIAS
					inserirFormacao(fo, idCur);
				}

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
		return false;
	}

	// ---------------------------------------------------------------------------------------------------

	public boolean inserirExperiencia(Experiencia ex, int cod) {

		String sql = "INSERT INTO experiencia(nomeDaEmpresa, data_inicio, data_fim, fun�ao, cargo, idCurriculo) VALUES(?, ?, ?, ?, ?, ?) ";

		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);

			ps.setString(1, ex.getEmpresa());
			ps.setLong(2, ex.getData_inicio());
			ps.setLong(3, ex.getData_fim());
			ps.setString(4, ex.getFuncoes());
			ps.setString(5, ex.getCargo());
			ps.setInt(6, cod);
			// colocar o IDCORRUCILO

			if (ps.executeUpdate() > 0) {
				System.out.println("Experiencia cadastrada ");
				return true;
			} else {
				System.out.println("Problemas ao cadastrar experiencia");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	// ---------------------------------------------------------------------------------------------------

	public boolean inserirFormacao(Formacao fo, int cod) {

		String sql = "INSERT INTO formacao(nomeDoCurso, data_inicio, data_fim, escola, idCurriculo) VALUES(?, ?, ?, ?, ?)";

		try {

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, fo.getNome());
			ps.setLong(2, fo.getData_inicio());
			ps.setLong(3, fo.getData_fim());
			ps.setString(4, fo.getEscola());
			ps.setInt(5, cod);

			if (ps.executeUpdate() > 0) {
				System.out.println("Forma��o cadastrada ");
				return true;
			} else {
				System.out.println("Problemas ao cadastrar Forma��o");
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

	// ---------------------------------------------------------------------------------------------------

	public Integer inserirFiltro(Filtro f) { // COLOCAR IDIOMA AQUI

		String sql = "INSERT INTO filtro(nome, experiencia, sexo, deficiencia, idEmpresa, idADM, "
				+ "area, curso, idade_inicio, idade_fim, qualIdioma, nvIdioma) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
		Integer idInserido = null;
		try {
			PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			ps.setString(1, f.getNomeFiltro());
			ps.setInt(2, f.getExperiencia());
			ps.setString(3, f.getSexo());
			ps.setString(4, f.getDeficiencia());
			ps.setString(5, f.getIdEmpresa() == 0 ? null : f.getIdEmpresa().toString()); // MUITO TOP
			ps.setString(6, f.getIdAdm() == 0 ? null : f.getIdAdm().toString());
			ps.setString(7, f.getArea());
			ps.setString(8, f.getIdCurso());
			ps.setInt(9, f.getIdade_inicio());
			ps.setInt(10, f.getIdade_fim());
			ps.setInt(11, f.getQualIdioma());
			ps.setInt(12, f.getNvIdioma() == null ? 0 : f.getNvIdioma());

			if (ps.executeUpdate() > 0) {

				ResultSet rs = ps.getGeneratedKeys();

				if (rs.next()) {

					idInserido = rs.getInt(1);

					List<String> cidades = f.getIdCidade();

					for (String i : cidades) {
						inserirCidade(idInserido, Integer.parseInt(i));
					}

				}

			}

			return idInserido;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	public boolean inserirCidade(int idFiltro, int idCidade) { // VER SE TA CERTO ISSO

		String sql = "INSERT INTO cidadeFiltro(idFiltro, idCidade) VALUES (?, ?)";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, idFiltro);
			ps.setInt(2, idCidade);

			if (ps.executeUpdate() > 0) {
				System.out.println("cidadeFiltro id cadastrada ");

			} else {
				System.out.println("ocorreu um erro cidadeFiltro ao tentar inserir!");
				return false;
			}
			return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

}
