package mbean;

import java.util.List;

import javax.faces.bean.ManagedBean;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.HorizontalBarChartModel;
import org.primefaces.model.chart.LegendPlacement;

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
		horizontalBarModel.setLegendPlacement(LegendPlacement.OUTSIDE);
		horizontalBarModel.setSeriesColors("330000,660000,990000,cc0000,ff0000,ff3333,ff6666,ff9999,ffcccc");

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
