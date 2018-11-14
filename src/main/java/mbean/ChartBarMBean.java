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
        yAxis.setMax(100);
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
        }
 
        
        
        
        
        //ATUALIZA ESSA MERDA PRA PUXAR DO FILTRO, NAO DO BANCO DE CIDADES SEU BABACA!

        
        
        
        
        
        //DEPOIS TENTA PUXA O NOME DA POHA DA CIDADE PARA MOSTRAR NO GRAFICO FDP!
        
        
        
        
        
        
        
        
        
        //ATUALIZA ESSA MERDA PRA PUXAR DO FILTRO, NAO DO BANCO DE CIDADES SEU BABACA!

        
        
        
        
        
        //DEPOIS TENTA PUXA O NOME DA POHA DA CIDADE PARA MOSTRAR NO GRAFICO FDP!

        
        
        
        
        
        //ATUALIZA ESSA MERDA PRA PUXAR DO FILTRO, NAO DO BANCO DE CIDADES SEU BABACA!
        
        
        
        
        //DEPOIS TENTA PUXA O NOME DA POHA DA CIDADE PARA MOSTRAR NO GRAFICO FDP!

        
        
        
        
        
        //ATUALIZA ESSA MERDA PRA PUXAR DO FILTRO, NAO DO BANCO DE CIDADES SEU BABACA!

        
        
        
        //DEPOIS TENTA PUXA O NOME DA POHA DA CIDADE PARA MOSTRAR NO GRAFICO FDP!

        
        
        
        
        //ATUALIZA ESSA MERDA PRA PUXAR DO FILTRO, NAO DO BANCO DE CIDADES SEU BABACA!

        
        
        
        //DEPOIS TENTA PUXA O NOME DA POHA DA CIDADE PARA MOSTRAR NO GRAFICO FDP!

        
        
        
        //ATUALIZA ESSA MERDA PRA PUXAR DO FILTRO, NAO DO BANCO DE CIDADES SEU BABACA!

        
        
        
        
        
        //DEPOIS TENTA PUXA O NOME DA POHA DA CIDADE PARA MOSTRAR NO GRAFICO FDP!

        
        
        
        
        
        
        //ATUALIZA ESSA MERDA PRA PUXAR DO FILTRO, NAO DO BANCO DE CIDADES SEU BABACA!

        
        
        
        //DEPOIS TENTA PUXA O NOME DA POHA DA CIDADE PARA MOSTRAR NO GRAFICO FDP!

        
        
        
        
        //ATUALIZA ESSA MERDA PRA PUXAR DO FILTRO, NAO DO BANCO DE CIDADES SEU BABACA!

        
        
        
        //DEPOIS TENTA PUXA O NOME DA POHA DA CIDADE PARA MOSTRAR NO GRAFICO FDP!

        
        
        
        
        


         
        return model;
    }
    
    public BarChartModel getBarModel() {
        return barModel;
    }
     

}








