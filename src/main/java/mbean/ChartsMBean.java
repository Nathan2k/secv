package mbean;

import java.util.List;

import javax.faces.bean.ManagedBean;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.LineChartModel;

import DAO.GraficosDAO;
import entity.GraficoFiltro;
import entity.GraficoSexo;

import org.primefaces.model.chart.ChartSeries;

@ManagedBean
public class ChartsMBean {
	
	private LineChartModel lineModel;
	private GraficosDAO gDao = new GraficosDAO();
	List<GraficoSexo> lista;
	Integer max = 0;

	public ChartsMBean() {
		createLineModels();
	}

	private void createLineModels() {
		lineModel = initCategoryModel();
		lineModel.setTitle("Histórico de Filtros"); // titulo do grafico
		lineModel.setLegendPosition("ne");
		lineModel.setShowPointLabels(true);
		lineModel.getAxes().put(AxisType.X, new CategoryAxis("Mês")); // nome linhaX
		
		Axis yAxis = lineModel.getAxis(AxisType.Y);
		yAxis.setLabel("Filtros"); // nome linha y
		yAxis.setMin(0);
		yAxis.setMax(max+5); 
		yAxis.setTickFormat("%d");
	}

	private LineChartModel initCategoryModel() {
		LineChartModel model = new LineChartModel();

		List<GraficoFiltro> lista = gDao.contarFiltro();

		ChartSeries filtros = new ChartSeries();

		filtros.setLabel("Filtros"); // nome da legenda do grafico

		for (GraficoFiltro cs : lista) {
			filtros.set(cs.getMes(), cs.getQtd());
			if (cs.getQtd() > max) {
				max = cs.getQtd();
			}
		}

		model.addSeries(filtros);
		model.setSeriesColors("800000");

		return model;
	}

	public LineChartModel getLineModel() {
		return lineModel;
	}

	public void setLineModel(LineChartModel lineModel) {
		this.lineModel = lineModel;
	}

}
