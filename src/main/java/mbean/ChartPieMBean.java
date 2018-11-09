package mbean;

import java.util.List;

import javax.faces.bean.ManagedBean;

import org.primefaces.model.chart.ChartSeries;
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
         
        pieModel1.set("Info", 500);
        pieModel1.set("Meca", 325);
        pieModel1.set("Admin", 702);
        pieModel1.set("Engen", 421);
         
        pieModel1.setTitle("Cursos");
        pieModel1.setLegendPosition("w");
        pieModel1.setShadow(false);
    }
    
    private PieChartModel initPieChartModel() {
    	PieChartModel model = new PieChartModel();
    	
    	List<GraficoPizza> lista = gDao.contarCurso();
    	
    	ChartSeries boys = new ChartSeries();
    	
    	boys.setLabel("curso");
    	
    	for(GraficoPizza cs : lista) {
    		boys.set(cs.getCurso(), cs.getQtd());
    	}
    	//model.addSeries(boys);
    	
		return model;
    }



}






































