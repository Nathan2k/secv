package mbean;

import javax.faces.bean.ManagedBean;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.HorizontalBarChartModel;
import DAO.GraficosDAO;

@ManagedBean
public class ChartLineMBean {

	private GraficosDAO gDao = new GraficosDAO();

	private HorizontalBarChartModel horizontalBarModel;

	public ChartLineMBean() {
		createHorizontalBarModel();
	}

	private void createHorizontalBarModel() {
		horizontalBarModel = new HorizontalBarChartModel();



        ChartSeries boys = new ChartSeries();
        boys.setLabel("Garotos");
        boys.set("12", 120);


		
        ChartSeries girls = new ChartSeries();
        girls.setLabel("Garotas");
        girls.set("12", 52);


        
		horizontalBarModel.setTitle("Cidades");
		horizontalBarModel.setLegendPosition("l");

		horizontalBarModel.addSeries(boys);
		horizontalBarModel.addSeries(girls);



		horizontalBarModel.setTitle("Garotos e Garotas");
		horizontalBarModel.setLegendPosition("e");
		
		 
        Axis xAxis = horizontalBarModel.getAxis(AxisType.X);
        xAxis.setLabel("Births");
        xAxis.setMin(0);
        xAxis.setMax(200);
 
        Axis yAxis = horizontalBarModel.getAxis(AxisType.Y);
        yAxis.setLabel("Gender");
	}

	public HorizontalBarChartModel getHorizontalBarModel() {
		return horizontalBarModel;
	}

	public void setHorizontalBarModel(HorizontalBarChartModel horizontalBarModel) {
		this.horizontalBarModel = horizontalBarModel;
	}

}
