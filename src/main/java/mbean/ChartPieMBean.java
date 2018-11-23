package mbean;

import java.util.List;

import javax.faces.bean.ManagedBean;

import org.primefaces.model.chart.LegendPlacement;
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
        pieModel1.setLegendPlacement(LegendPlacement.OUTSIDE);
        pieModel1.setShadow(false);
        pieModel1.setShowDataLabels(true);
    }
    
    private PieChartModel initPieChartModel() {
    	PieChartModel model = new PieChartModel();
    	
    	List<GraficoPizza> lista = gDao.contarCurso();
    	
    	
    	for(GraficoPizza cs : lista) {
    		model.set(cs.getCurso(), cs.getQtd());
    		model.setSeriesColors("330000,660000,990000,cc0000,ff0000,ff3333,ff6666,ff9999,ffcccc");
    	}
    	//model.addSeries(boys);
    	
		return model;
    }



}





