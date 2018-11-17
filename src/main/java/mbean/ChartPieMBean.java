package mbean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import org.primefaces.model.chart.PieChartModel;

import DAO.GraficosDAO;
import entity.GraficoPizza;



@ManagedBean
public class ChartPieMBean {

    private PieChartModel pieModel1;
    private GraficosDAO gDao = new GraficosDAO();
    
 
    public PieChartModel getPieModel1() {
        return pieModel1;
    }
    public ChartPieMBean() {
        createPieModel1();
        }
 
    private void createPieModel1() {
        pieModel1 = initPieChartModel();
         
        pieModel1.setTitle("Cursos");
        pieModel1.setLegendPosition("ne");
        pieModel1.setShadow(false);
    }
    
    private PieChartModel initPieChartModel() {
    	PieChartModel model = new PieChartModel();
    	
    	List<GraficoPizza> lista = gDao.contarCurso();
    	
    	
    	for(GraficoPizza cs : lista) {
    		model.set(cs.getCurso(), cs.getQtd());
    		model.setSeriesColors("800000,b30000,4d0000,e60000");
    	}
    	//model.addSeries(boys);
    	
		return model;
    }



}





