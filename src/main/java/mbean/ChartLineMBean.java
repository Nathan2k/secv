package mbean;

import java.util.List;

import javax.faces.bean.ManagedBean;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.LineChartModel;

import DAO.GraficosDAO;
import entity.GraficoSexo;
 
@ManagedBean
public class ChartLineMBean {
 
    private LineChartModel areaModel;
    private GraficosDAO gDao = new GraficosDAO();
    
    public ChartLineMBean() {
    	createLineModels();
    }
 //tem anotações no ChartsMBean sobre essa bosta
	private void createLineModels() {
        areaModel = initCategoryModel();
        areaModel.setTitle("Sexo");
        areaModel.setLegendPosition("ne");
        //areaModel.setStacked(true);
        areaModel.setShowPointLabels(true);
        Axis xAxis = new CategoryAxis("Mês");
        areaModel.getAxes().put(AxisType.X, xAxis);
        Axis yAxis = areaModel.getAxis(AxisType.Y);
        yAxis.setLabel("Quantidade");
        yAxis.setMin(0);
        yAxis.setMax(30);
    }
 
	private LineChartModel initCategoryModel() {
		LineChartModel model = new LineChartModel();
		
		List<GraficoSexo> lista = gDao.contaSexo();
		
		ChartSeries boys = new ChartSeries();
		ChartSeries girls = new ChartSeries();
		
		boys.setLabel("Masculino");
		girls.setLabel("Feminino");
		for(GraficoSexo cs : lista) {
			boys.set(cs.getSexo(), cs.getQtd());
		}
		for(GraficoSexo cs : lista) {
			girls.set(cs.getSexo(), cs.getQtd());
		}
		
		model.addSeries(boys);
		model.addSeries(girls);
		
		return model;
	}
	
	
	
	

	public LineChartModel getLineModel() {
		return areaModel;
	}
	
	
	
	
	
	public void setLineModel(LineChartModel areaModel) {
		this.areaModel = areaModel;
	}

}























