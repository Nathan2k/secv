package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.VPS04.JDBC.ConnectionDB;

import entity.GraficoCidade;
import entity.GraficoFiltro;
import entity.GraficoPizza;
import entity.GraficoSexo;


public class GraficosDAO {

	Connection conn;

	public GraficosDAO() {

		try {
			conn = ConnectionDB.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	

	public List<GraficoFiltro> contarFiltro() {

		String sql = "SELECT COUNT(*) as qtd, DATE_FORMAT(data,'%m/%Y') as mes FROM filtro GROUP BY data;";

		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			List<GraficoFiltro> lista = new ArrayList<>();
			while (rs.next()) {
				GraficoFiltro fo = new GraficoFiltro();

				fo.setQtd(rs.getInt("qtd"));
				fo.setMes(rs.getString("mes"));

				lista.add(fo);
			}
			return lista;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	

	public List<GraficoPizza> contarCurso() {

		String sql = "SELECT COUNT(curso) AS qtd, curso FROM filtro GROUP BY curso;";

		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql); 				//conecta no banco

			ResultSet rs = ps.executeQuery(); 				//faz o codigo girar no sql("SELECT COUNT...")

			List<GraficoPizza> lista = new ArrayList<>(); 	//cria lista no java
			while (rs.next()) { 							//next na lista que vem do sql
				GraficoPizza fo = new GraficoPizza(); 		//criando linhas(objetos)

				fo.setQtd(rs.getInt("qtd")); 				//seta o valor do sql na linha
				fo.setCurso(rs.getString("curso"));

				lista.add(fo); 								//add linha na lista
			}
			return lista; 									//lista completa
		} catch (SQLException e) { 							//da exception caso de algo errado
			e.printStackTrace();
		}
		return null;
	}
	
	
	public List<GraficoCidade> contaCidade(){
		
		String sql = "SELECT c.nomeCidade AS cidade, COUNT(c.nomeCidade) AS qtd FROM cidade c INNER JOIN cidadefiltro cf on c.id = cf.idCidade GROUP BY c.nomeCidade;";
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			List<GraficoCidade> lista = new ArrayList<>();
			while (rs.next()) {
				GraficoCidade fo = new GraficoCidade();
				
				fo.setQtd(rs.getInt("qtd"));
				fo.setCidade(rs.getString("cidade"));
				
				lista.add(fo);
			}
			return lista;
		}catch (SQLException e) { 
			e.printStackTrace();
		}
		return null;
	}

	
	public List<GraficoSexo> contaSexo() {
		String sql = "SELECT COUNT(sexo) AS qtd, sexo FROM filtro GROUP BY sexo;";

		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			List<GraficoSexo> lista = new ArrayList<>();
			while (rs.next()) {
				GraficoSexo fo = new GraficoSexo();

				fo.setQtd(rs.getInt("qtd"));
				fo.setSexo(rs.getString("sexo"));

				lista.add(fo);
			}
			return lista;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
