package mbean;


import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;

import DAO.GraficosDAO;
import entity.GraficoCidade;
 
@ManagedBean
public class ChartBarMBean{
 
    private BarChartModel barModel;
    private GraficosDAO gDao = new GraficosDAO();
 
    @PostConstruct
    public void init() {
        createBarModels();
    }

     
    private void createBarModels() {
        createBarModel();
    }
     
    private void createBarModel() {
        barModel = initBarModel();
        barModel.setTitle("Cidades");
        barModel.setLegendPosition("ne");
         
        Axis xAxis = barModel.getAxis(AxisType.X);
        xAxis.setLabel(".");
         
        Axis yAxis = barModel.getAxis(AxisType.Y);
        yAxis.setLabel("Quantidade");
        yAxis.setMin(0);
        yAxis.setMax(20);
        yAxis.setTickFormat("%d");
    }
    
    private BarChartModel initBarModel() {
        BarChartModel model = new BarChartModel();
 
        List<GraficoCidade> lista = gDao.contaCidade();
        
        for (GraficoCidade cs : lista) {
        	ChartSeries cidades = new ChartSeries();
            
            cidades.setLabel(cs.getCidade());
        	cidades.set("Cidades", cs.getQtd());
        	
        	model.addSeries(cidades);
        	model.setSeriesColors("800000,cc0000,4d0000,ffd699");
        }         
        return model;
    }
    
    public BarChartModel getBarModel() {
        return barModel;
    }
     

}








