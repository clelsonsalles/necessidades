package br.cnpq.pdtic.necessidades.controle;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

import org.primefaces.model.chart.MeterGaugeChartModel;
import org.primefaces.model.chart.PieChartModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.cnpq.pdtic.necessidades.dto.DTOChaveValor;
import br.cnpq.pdtic.necessidades.dto.DTONecessidade;
import br.cnpq.pdtic.necessidades.dto.DTORelatorio;
import br.cnpq.pdtic.necessidades.services.RelatorioServico;
 
@ManagedBean(name="chartView")
@ViewScoped
@Component
@Scope("session")
public class ChartView implements Serializable {
 
	@Autowired
	private RelatorioServico relatorioServico;

	private DTORelatorio relatorio;

    private MeterGaugeChartModel calibradorGraficoUsuariosModel;
    private MeterGaugeChartModel calibradorGraficoNecessidadesModel;
    
    private PieChartModel pizzaTotalNecessidadeLotacao = new PieChartModel();
    
    private List<DTONecessidade>  listaTodasNecessidades = new ArrayList<DTONecessidade>();

    /*
    @PostConstruct
    public void init() {
        iniciaRelatorio();
        createCalibradorGraficoModels();
        listaTodasNecessidades = relatorioServico.recuperaListaNecessidades();
    }
 	*/

	/**
	 * Carrega os dados para consolidação do Relatório do Levantamento
	 */
	public String iniciaRelatorio(){
		relatorio = relatorioServico.carregaResultados();
        
		createCalibradorGraficoModels();
        criaPizzaTotalNecessidadeLotacaoModel();
        
        listaTodasNecessidades = relatorioServico.recuperaListaNecessidades();
        
        
		return "/pdtic/relatorio.xhtml";

	}

    private MeterGaugeChartModel initCalibradorGraficoUsuariosModel() {
        List<Number> intervals = new ArrayList<Number>(){{
            add(30);
            add(60);
            add(90);
            add(120);
        }};
         
        return new MeterGaugeChartModel(relatorio.getTotalUsuarios(), intervals);
    }
 
    private MeterGaugeChartModel initCalibradorGraficoNecessidadesModel() {
    	
    	
        List<Number> intervals = new ArrayList<Number>(){{
        	Number valorMedida = relatorio.getTotalNecessidades() < 100 ? 30 : new Integer( ((relatorio.getTotalNecessidades() * 3)/2)/4 );
            add(valorMedida);
            add( valorMedida.intValue() * 2 );
            add(valorMedida.intValue() * 3);
            add(valorMedida.intValue() * 4);
        }};
         
        return new MeterGaugeChartModel(relatorio.getTotalNecessidades(), intervals);
    }

    private void createCalibradorGraficoModels() {
        calibradorGraficoUsuariosModel = initCalibradorGraficoUsuariosModel();
        calibradorGraficoUsuariosModel.setTitle("Quantidade de Usuários: " + relatorio.getTotalUsuarios());
        calibradorGraficoUsuariosModel.setGaugeLabel("Usuários");
        
        
        calibradorGraficoNecessidadesModel = initCalibradorGraficoNecessidadesModel();
        calibradorGraficoNecessidadesModel.setTitle("Quantidade de Necessidades: " + relatorio.getTotalNecessidades());
        calibradorGraficoNecessidadesModel.setGaugeLabel("Necessidades");

    }
    
    
    
    private void criaPizzaTotalNecessidadeLotacaoModel() {
        pizzaTotalNecessidadeLotacao = new PieChartModel();
        
        List<DTOChaveValor> totalNecessidadesLotacao = relatorio.getTotalNecessidadesLotacao();
        for (DTOChaveValor dto : totalNecessidadesLotacao) {
        	pizzaTotalNecessidadeLotacao.set(dto.getDescricao(), dto.getValor());
		}
         
        pizzaTotalNecessidadeLotacao.setTitle("Total de Necessidades por Lotação");
        pizzaTotalNecessidadeLotacao.setLegendPosition("e");
//        pizzaTotalNecessidadeLotacao.setFill(false);
        pizzaTotalNecessidadeLotacao.setShowDataLabels(true);
        pizzaTotalNecessidadeLotacao.setDiameter(180);
    }


	/**
	 * @return the relatorio
	 */
	public DTORelatorio getRelatorio() {
		return relatorio;
	}


	/**
	 * @param relatorio the relatorio to set
	 */
	public void setRelatorio(DTORelatorio relatorio) {
		this.relatorio = relatorio;
	}


	/**
	 * @return the calibradorGraficoUsuariosModel
	 */
	public MeterGaugeChartModel getCalibradorGraficoUsuariosModel() {
		return calibradorGraficoUsuariosModel;
	}


	/**
	 * @param calibradorGraficoUsuariosModel the calibradorGraficoUsuariosModel to set
	 */
	public void setCalibradorGraficoUsuariosModel(MeterGaugeChartModel calibradorGraficoUsuariosModel) {
		this.calibradorGraficoUsuariosModel = calibradorGraficoUsuariosModel;
	}


	/**
	 * @return the calibradorGraficoNecessidadesModel
	 */
	public MeterGaugeChartModel getCalibradorGraficoNecessidadesModel() {
		return calibradorGraficoNecessidadesModel;
	}


	/**
	 * @param calibradorGraficoNecessidadesModel the calibradorGraficoNecessidadesModel to set
	 */
	public void setCalibradorGraficoNecessidadesModel(MeterGaugeChartModel calibradorGraficoNecessidadesModel) {
		this.calibradorGraficoNecessidadesModel = calibradorGraficoNecessidadesModel;
	}


	/**
	 * @return the listaTodasNecessidades
	 */
	public List<DTONecessidade> getListaTodasNecessidades() {
		return listaTodasNecessidades;
	}


	/**
	 * @param listaTodasNecessidades the listaTodasNecessidades to set
	 */
	public void setListaTodasNecessidades(List<DTONecessidade> listaTodasNecessidades) {
		this.listaTodasNecessidades = listaTodasNecessidades;
	}

	/**
	 * @return the pizzaTotalNecessidadeLotacao
	 */
	public PieChartModel getPizzaTotalNecessidadeLotacao() {
		return pizzaTotalNecessidadeLotacao;
	}

	/**
	 * @param pizzaTotalNecessidadeLotacao the pizzaTotalNecessidadeLotacao to set
	 */
	public void setPizzaTotalNecessidadeLotacao(PieChartModel pizzaTotalNecessidadeLotacao) {
		this.pizzaTotalNecessidadeLotacao = pizzaTotalNecessidadeLotacao;
	}
 
}