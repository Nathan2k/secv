package mbean;


import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
 
@ManagedBean
public class ChartBarMBean{
 
    private BarChartModel barModel;
 
    @PostConstruct
    public void init() {
        createBarModels();
    }
 
    public BarChartModel getBarModel() {
        return barModel;
    }
     

 
    private BarChartModel initBarModel() {
        BarChartModel model = new BarChartModel();
 

		ChartSeries cidades = new ChartSeries();
		cidades.setLabel("Campinas");
		cidades.set("2016", 12);
        
		ChartSeries cidades2 = new ChartSeries();
		cidades2.setLabel("Jaguariuna");
		cidades2.set("2016", 67);
     
		ChartSeries cidades3 = new ChartSeries();
		cidades3.setLabel("Sumaré");
		cidades3.set("2016", 80);
		
		ChartSeries cidades4 = new ChartSeries();
		cidades4.setLabel("Amparo");
		cidades4.set("2016", 100);

     
 
        model.addSeries(cidades);
        model.addSeries(cidades2);
        model.addSeries(cidades3);
        model.addSeries(cidades4);

        model.setSeriesColors("c2c2f0,ff9999,99ffbb,ffd699");
         
        return model;
    }
     
    private void createBarModels() {
        createBarModel();
    }
     
    private void createBarModel() {
        barModel = initBarModel();
         
        barModel.setTitle("Cidades");
        barModel.setLegendPosition("ne");
         
        Axis xAxis = barModel.getAxis(AxisType.X);
        xAxis.setLabel("Meses");
         
        Axis yAxis = barModel.getAxis(AxisType.Y);
        yAxis.setLabel("Quantidade");
        yAxis.setMin(0);
        yAxis.setMax(200);
        yAxis.setTickFormat("%d");
    }
     

}