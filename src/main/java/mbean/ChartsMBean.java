package mbean;


import java.util.List;

import javax.faces.bean.ManagedBean;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.LineChartModel;

import DAO.GraficosDAO;
import entity.GraficoFiltro;

import org.primefaces.model.chart.ChartSeries;


@ManagedBean
public class ChartsMBean {

    private LineChartModel lineModel;
    private GraficosDAO gDao = new GraficosDAO();

    public ChartsMBean() {
        createLineModels();
    }
     
    private void createLineModels() {
        lineModel = initCategoryModel();
        lineModel.setTitle("Histórico de Filtros");
        lineModel.setLegendPosition("e");
        lineModel.setShowPointLabels(true);
        lineModel.getAxes().put(AxisType.X, new CategoryAxis("Mês"));
        Axis yAxis = lineModel.getAxis(AxisType.Y);
        yAxis.setLabel("FILTROS");
        yAxis.setMin(0);
        yAxis.setMax(5);
    }
     
    private LineChartModel initCategoryModel() {
        LineChartModel model = new LineChartModel();
 
        List<GraficoFiltro> lista = gDao.contarFiltro();
        
        ChartSeries boys = new ChartSeries();
        
        boys.setLabel("Filtros");
        
        for(GraficoFiltro cs : lista) { 
        	boys.set(cs.getMes(), cs.getQtd());
        }
      
 
        model.addSeries(boys);
         
        return model;
    }





	public LineChartModel getLineModel() {
		return lineModel;
	}





	public void setLineModel(LineChartModel lineModel) {
		this.lineModel = lineModel;
	}
    
}
