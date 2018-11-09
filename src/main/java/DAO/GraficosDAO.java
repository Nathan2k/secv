package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.VPS04.JDBC.ConnectionDB;

import entity.GraficoFiltro;
import entity.GraficoPizza;
import entity.GraficoSexo;

public class GraficosDAO{
	
	
	
	
	
	
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
		while(rs.next()) {
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
		ps = conn.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		
		List<GraficoPizza> lista = new ArrayList<>();
		while(rs.next()) {
			GraficoPizza fo = new GraficoPizza();
			
			fo.setQtd(rs.getInt("qtd"));
			fo.setCurso(rs.getString("curso"));
			
			lista.add(fo);
		}
		return lista;
	}catch (SQLException e) {
		e.printStackTrace();
	}
	return null;
}

public List<GraficoSexo> contaSexo(){
	String sql = "SELECT COUNT(sexo) AS qtd, sexo FROM filtro GROUP BY sexo;";
	
	PreparedStatement ps;
	try {
		ps = conn.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		
		List<GraficoSexo> lista = new ArrayList<>();
		while(rs.next()) {
			GraficoSexo fo = new GraficoSexo();
			
			fo.setQtd(rs.getInt("qtd"));
			fo.setSexo(rs.getString("sexo"));
			
			lista.add(fo);
		}
		return lista;
	}catch (SQLException e) {
		e.printStackTrace();
	}
	return null;	
}









}
