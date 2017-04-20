package br.cnpq.pdtic.necessidades.controle;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
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
    private MeterGaugeChartModel calibradorGraficoUsuariosFinalizadosModel;
    private MeterGaugeChartModel calibradorGraficoNecessidadesModel;
    
    private PieChartModel pizzaTotalNecessidadeLotacao = new PieChartModel();
    private PieChartModel pizzaTotalUsuarioLotacao = new PieChartModel();
    
    private BarChartModel barraTotalUsuarioCargo;    
    private BarChartModel barraTotalUsuarioUnidade;    

    private BarChartModel barraTotalNecessidadeCargo;    
    private BarChartModel barraTotalNecessidadeUnidade;    
    
    private List<DTONecessidade>  listaTodasNecessidades = new ArrayList<DTONecessidade>();

	/**
	 * Carrega os dados para consolidação do Relatório do Levantamento
	 */
	public String iniciaRelatorio(){
		relatorio = relatorioServico.carregaResultados();
        
		initCalibradorGraficoUsuariosModel();
		initCalibradorGraficoUsuariosFinalizadosModel();
		initCalibradorGraficoNecessidadesModel();
		
		pizzaTotalNecessidadeLotacao = criaPizzaGraficoModel(relatorio.getTotalNecessidadesLotacao(), "Total de Necessidades por Lotação");
		pizzaTotalUsuarioLotacao = criaPizzaGraficoModel(relatorio.getTotalUsuariosLotacao(), "Total de Usuários por Lotação");

		barraTotalUsuarioCargo 		= criaBarrasGraficoModel(relatorio.getTotalUsuariosCargo(), "Total de Usuários por Cargo", "Cargo", "Total de Usuários");
		barraTotalUsuarioUnidade 	= criaBarrasGraficoModel(relatorio.getTotalUsuariosUnidade(), "Total de Usuários por Unidade", "Unidade", "Total de Usuários");
		
		barraTotalNecessidadeCargo 		= criaBarrasGraficoModel(relatorio.getTotalNecessidadesCargo(), "Total de Necessidadeas por Cargo", "Cargo", "Total de Necessidades");
		barraTotalNecessidadeUnidade 	= criaBarrasGraficoModel(relatorio.getTotalNecessidadesUnidade(), "Total de Necessidades por Unidade", "Unidade", "Total de Necessidades");

		listaTodasNecessidades = relatorioServico.recuperaListaNecessidades();
        
        
		return "/pdtic/relatorio.xhtml";

	}

    private void initCalibradorGraficoUsuariosModel() {
        List<Number> intervals = new ArrayList<Number>(){{
            add(30);
            add(60);
            add(90);
            add(120);
        }};
         
        String titulo = "Quantidade de Usuários: " + relatorio.getTotalUsuarios();
        String label = relatorio.getTotalUsuarios() + " usuários";
        
        calibradorGraficoUsuariosModel = createCalibradorGraficoModels(relatorio.getTotalUsuarios(), intervals, titulo, label);
    }
 
    private void initCalibradorGraficoUsuariosFinalizadosModel() {
        List<Number> intervals = new ArrayList<Number>(){{
            add(30);
            add(60);
            add(90);
            add(120);
        }};
         
        String titulo = "Quantidade de Levantamentos Finalizados: " + relatorio.getTotalUsuariosFinalizados();
        String label = relatorio.getTotalUsuariosFinalizados() + " Levantamentos Finalizados";
        
        calibradorGraficoUsuariosFinalizadosModel = createCalibradorGraficoModels(relatorio.getTotalUsuariosFinalizados(), intervals, titulo, label);
    }

    private void initCalibradorGraficoNecessidadesModel() {
    	
    	
        List<Number> intervals = new ArrayList<Number>(){{
        	Number valorMedida = relatorio.getTotalNecessidades() < 100 ? 30 : new Integer( ((relatorio.getTotalNecessidades() * 3)/2)/4 );
            add(valorMedida);
            add( valorMedida.intValue() * 2 );
            add(valorMedida.intValue() * 3);
            add(valorMedida.intValue() * 4);
        }};
         
        String titulo = "Quantidade de Necessidades: " + relatorio.getTotalNecessidades();
        String label = relatorio.getTotalNecessidades() + " necessidades";
        
        calibradorGraficoNecessidadesModel = createCalibradorGraficoModels(relatorio.getTotalNecessidades(), intervals, titulo, label);
    }

    private MeterGaugeChartModel createCalibradorGraficoModels(Number valor, List<Number> intervalo, String titulo, String label) {

    	MeterGaugeChartModel chartModel = new MeterGaugeChartModel(valor, intervalo);
    	chartModel.setTitle(titulo);
    	chartModel.setGaugeLabel(label);
    	chartModel.setGaugeLabelPosition("bottom");
    	chartModel.setShowTickLabels(true);
    	
    	
    	return chartModel;
    	
    }
    
    
    
    private PieChartModel criaPizzaGraficoModel(List<DTOChaveValor> dadosDTO, String titulo) {
    	PieChartModel pizzaGrafico = new PieChartModel();
        
        for (DTOChaveValor dto : dadosDTO) {
        	pizzaGrafico.set(dto.getDescricao(), dto.getValor());
		}
         
        pizzaGrafico.setTitle(titulo);
        pizzaGrafico.setLegendPosition("e");
//        pizzaTotalNecessidadeLotacao.setFill(false);
        pizzaGrafico.setShowDataLabels(true);
        pizzaGrafico.setDiameter(180);
        
        return pizzaGrafico;
    }

    
    private BarChartModel criaBarrasGraficoModel(List<DTOChaveValor> dadosDTO, String titulo, String labelX, String labelY){
    	BarChartModel barraModel = new BarChartModel();
    	ChartSeries barraSeries = new ChartSeries();
    	Number maiorValor = 0;
		for (DTOChaveValor dto : dadosDTO) {
			 barraSeries.set(dto.getDescricao(), dto.getValor());
			 maiorValor = dto.getValor() > maiorValor.intValue() ? dto.getValor() : maiorValor;
		}
		barraModel.addSeries(barraSeries);
		
		barraModel.setTitle(titulo);
		barraModel.setLegendPosition("ne");
         
        Axis xAxis = barraModel.getAxis(AxisType.X);
        xAxis.setLabel(labelX);
         
        Axis yAxis = barraModel.getAxis(AxisType.Y);
        yAxis.setLabel(labelY);
        yAxis.setMin(0);
        yAxis.setMax((maiorValor.intValue() * 1.5));
        
        return barraModel;
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

	/**
	 * @return the pizzaTotalUsuarioLotacao
	 */
	public PieChartModel getPizzaTotalUsuarioLotacao() {
		return pizzaTotalUsuarioLotacao;
	}

	/**
	 * @param pizzaTotalUsuarioLotacao the pizzaTotalUsuarioLotacao to set
	 */
	public void setPizzaTotalUsuarioLotacao(PieChartModel pizzaTotalUsuarioLotacao) {
		this.pizzaTotalUsuarioLotacao = pizzaTotalUsuarioLotacao;
	}

	/**
	 * @return the calibradorGraficoUsuariosFinalizadosModel
	 */
	public MeterGaugeChartModel getCalibradorGraficoUsuariosFinalizadosModel() {
		return calibradorGraficoUsuariosFinalizadosModel;
	}

	/**
	 * @param calibradorGraficoUsuariosFinalizadosModel the calibradorGraficoUsuariosFinalizadosModel to set
	 */
	public void setCalibradorGraficoUsuariosFinalizadosModel(
			MeterGaugeChartModel calibradorGraficoUsuariosFinalizadosModel) {
		this.calibradorGraficoUsuariosFinalizadosModel = calibradorGraficoUsuariosFinalizadosModel;
	}

	/**
	 * @return the barraTotalUsuarioCargo
	 */
	public BarChartModel getBarraTotalUsuarioCargo() {
		return barraTotalUsuarioCargo;
	}

	/**
	 * @param barraTotalUsuarioCargo the barraTotalUsuarioCargo to set
	 */
	public void setBarraTotalUsuarioCargo(BarChartModel barraTotalUsuarioCargo) {
		this.barraTotalUsuarioCargo = barraTotalUsuarioCargo;
	}

	/**
	 * @return the barraTotalUsuarioUnidade
	 */
	public BarChartModel getBarraTotalUsuarioUnidade() {
		return barraTotalUsuarioUnidade;
	}

	/**
	 * @param barraTotalUsuarioUnidade the barraTotalUsuarioUnidade to set
	 */
	public void setBarraTotalUsuarioUnidade(BarChartModel barraTotalUsuarioUnidade) {
		this.barraTotalUsuarioUnidade = barraTotalUsuarioUnidade;
	}

	/**
	 * @return the barraTotalNecessidadeCargo
	 */
	public BarChartModel getBarraTotalNecessidadeCargo() {
		return barraTotalNecessidadeCargo;
	}

	/**
	 * @param barraTotalNecessidadeCargo the barraTotalNecessidadeCargo to set
	 */
	public void setBarraTotalNecessidadeCargo(BarChartModel barraTotalNecessidadeCargo) {
		this.barraTotalNecessidadeCargo = barraTotalNecessidadeCargo;
	}

	/**
	 * @return the barraTotalNecessidadeUnidade
	 */
	public BarChartModel getBarraTotalNecessidadeUnidade() {
		return barraTotalNecessidadeUnidade;
	}

	/**
	 * @param barraTotalNecessidadeUnidade the barraTotalNecessidadeUnidade to set
	 */
	public void setBarraTotalNecessidadeUnidade(BarChartModel barraTotalNecessidadeUnidade) {
		this.barraTotalNecessidadeUnidade = barraTotalNecessidadeUnidade;
	}
 
}