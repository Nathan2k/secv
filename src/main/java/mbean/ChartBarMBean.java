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
import entity.GraficoSexo;
 
@ManagedBean
public class ChartBarMBean{
 
    private BarChartModel barModel;
    private GraficosDAO gDao = new GraficosDAO();
	List<GraficoSexo> lista;
	Integer max = 0;
 
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
        barModel.setShowPointLabels(true);

        Axis xAxis = barModel.getAxis(AxisType.X);
        xAxis.setLabel("");
         
        Axis yAxis = barModel.getAxis(AxisType.Y);
        yAxis.setLabel("Quantidade");
        yAxis.setMin(0);
        yAxis.setMax(max+5);
        yAxis.setTickFormat("%d");
    }
    
    private BarChartModel initBarModel() {
        BarChartModel model = new BarChartModel();
 
        List<GraficoCidade> lista = gDao.contaCidade();
        
        for (GraficoCidade cs : lista) {
        	ChartSeries cidades = new ChartSeries();
            
            cidades.setLabel(cs.getCidade());
        	cidades.set("Cidades", cs.getQtd());
        	
			if (cs.getQtd() > max) {
				max = cs.getQtd();
			}
        	
        	model.addSeries(cidades);
        	model.setSeriesColors("800000,e60000,b30000,4d0000,ff1a1a,1a0000");
        }         
        return model;
    }
    
    public BarChartModel getBarModel() {
        return barModel;
    }
     

}








