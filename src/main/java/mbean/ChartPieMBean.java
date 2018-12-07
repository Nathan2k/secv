package mbean;

import java.util.List;

import javax.faces.bean.ManagedBean;

import org.primefaces.model.chart.LegendPlacement;
import org.primefaces.model.chart.PieChartModel;

import DAO.GraficosDAO;
import entity.GraficoPizza;

@ManagedBean
public class ChartPieMBean {

	private PieChartModel pieModel1;
	private GraficosDAO gDao = new GraficosDAO();

	public PieChartModel getPieModel1() {
		return pieModel1;
	}

	public ChartPieMBean() {
		createPieModel1();
	}

	private void createPieModel1() {
		pieModel1 = initPieChartModel();

		pieModel1.setTitle("Cursos");
		pieModel1.setLegendPosition("e");
		pieModel1.setLegendPlacement(LegendPlacement.INSIDE);
		pieModel1.setShadow(false);
		pieModel1.setShowDataLabels(true);
	}

	private PieChartModel initPieChartModel() {
		PieChartModel model = new PieChartModel();

		List<GraficoPizza> lista = gDao.contarCurso();

		for (GraficoPizza cs : lista) {
			model.set(cs.getCurso(), cs.getQtd());
			model.setSeriesColors(
					"800000,cc0000,d11a00,d63300,db4c00,e06600,e68000,eb9900,f0b200,f5cc00,fae600,e06600");
		}
		// model.addSeries(boys);

		return model;
	}

}
