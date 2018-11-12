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
		cidades.set("2016", 12);
		cidades.set("2015", 32);
		cidades.setLabel("Campinas");
        
		ChartSeries cidades2 = new ChartSeries();
		cidades2.setLabel("Jaguariuna");
		cidades2.set("2015", 32);
		cidades2.set("2016", 67);
        

     
 
        model.addSeries(cidades);
        model.addSeries(cidades2);

        model.setSeriesColors("1f1f1f,ff0000");
         
        return model;
    }
     
    private void createBarModels() {
        createBarModel();
    }
     
    private void createBarModel() {
        barModel = initBarModel();
         
        barModel.setTitle("Sexo");
        barModel.setLegendPosition("ne");
         
        Axis xAxis = barModel.getAxis(AxisType.X);
        xAxis.setLabel("Meses");
         
        Axis yAxis = barModel.getAxis(AxisType.Y);
        yAxis.setLabel("Quantidade");
        yAxis.setMin(0);
        yAxis.setMax(200);
    }
     

}