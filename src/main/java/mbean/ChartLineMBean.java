package mbean;

import java.util.List;

import javax.faces.bean.ManagedBean;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.HorizontalBarChartModel;

import DAO.GraficosDAO;
import entity.GraficoSexo;

@ManagedBean
public class ChartLineMBean {

	private HorizontalBarChartModel horizontalBarModel;
	private GraficosDAO gDao = new GraficosDAO();
	List<GraficoSexo> lista;
	Integer max = 0;

	public ChartLineMBean() {
		createHorizontalBarModel();
	}

	public void setHorizontalBarModel(HorizontalBarChartModel horizontalBarModel) {
		this.horizontalBarModel = horizontalBarModel;
	}

	private void createHorizontalBarModel() {
		horizontalBarModel = initHorizontalBarChartModel();
		horizontalBarModel.setShowPointLabels(true);
		horizontalBarModel.setTitle("Sexo por Filtro");
		horizontalBarModel.setLegendPosition("ne");
		horizontalBarModel.setSeriesColors("800000,e60000,b30000,4d0000,ff1a1a,1a0000");

		Axis xAxis = horizontalBarModel.getAxis(AxisType.X);
		xAxis.setLabel("Quantidade");
		xAxis.setMin(0);
		xAxis.setMax(max+5);
		xAxis.setTickFormat("%d");

		Axis yAxis = horizontalBarModel.getAxis(AxisType.Y);
		yAxis.setLabel("Genero");
	}

	private HorizontalBarChartModel initHorizontalBarChartModel() {
		HorizontalBarChartModel model = new HorizontalBarChartModel();

		lista = gDao.contaSexo();

		for (GraficoSexo cs : lista) {
			ChartSeries sexo = new ChartSeries();

			sexo.setLabel(cs.getSexoNome());
			if (cs.getQtd() > max) {
				max = cs.getQtd();
			}
			sexo.set("", cs.getQtd());

			model.addSeries(sexo);
		}
		return model;
	}

	public HorizontalBarChartModel HorizontalBarModel() {
		return horizontalBarModel;
	}

	public HorizontalBarChartModel getHorizontalBarModel() {
		return horizontalBarModel;
	}

}
