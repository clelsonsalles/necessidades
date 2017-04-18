/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cnpq.pdtic.necessidades.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.cnpq.pdtic.necessidades.entities.Grupo;
import br.cnpq.pdtic.necessidades.entities.Questao;


public class DTORelatorio implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private Integer totalUsuarios;
    private Integer totalUsuariosFinalizados;
    
    private Integer totalNecessidades;
    private Integer totalNecessidadesAlinhadasCNPq;
    private Integer totalNecessidadesAlinhadasEGD;
    private Integer totalNecessidadesProjetosTransversais;
    private Integer totalNecessidadesProjetosEspecificos;
    private Integer totalNecessidadesOutras;
    
    
    private List<DTOChaveValor> totalNecessidadesLotacao = new ArrayList<DTOChaveValor>();
    private List<DTOChaveValor> totalNecessidadesCargo = new ArrayList<DTOChaveValor>();
    private List<DTOChaveValor> totalNecessidadesUnidade = new ArrayList<DTOChaveValor>();
    
    private List<DTOChaveValor> totalUsuariosLotacao = new ArrayList<DTOChaveValor>();
    private List<DTOChaveValor> totalUsuariosCargo = new ArrayList<DTOChaveValor>();
    private List<DTOChaveValor> totalUsuariosUnidade = new ArrayList<DTOChaveValor>();
    
    
	/**
	 * @return the totalUsuarios
	 */
	public Integer getTotalUsuarios() {
		return totalUsuarios;
	}
	/**
	 * @param totalUsuarios the totalUsuarios to set
	 */
	public void setTotalUsuarios(Integer totalUsuarios) {
		this.totalUsuarios = totalUsuarios;
	}
	/**
	 * @return the totalUsuariosFinalizados
	 */
	public Integer getTotalUsuariosFinalizados() {
		return totalUsuariosFinalizados;
	}
	/**
	 * @param totalUsuariosFinalizados the totalUsuariosFinalizados to set
	 */
	public void setTotalUsuariosFinalizados(Integer totalUsuariosFinalizados) {
		this.totalUsuariosFinalizados = totalUsuariosFinalizados;
	}
	/**
	 * @return the totalNecessidades
	 */
	public Integer getTotalNecessidades() {
		return totalNecessidades;
	}
	/**
	 * @param totalNecessidades the totalNecessidades to set
	 */
	public void setTotalNecessidades(Integer totalNecessidades) {
		this.totalNecessidades = totalNecessidades;
	}
	/**
	 * @return the totalNecessidadesAlinhadasCNPq
	 */
	public Integer getTotalNecessidadesAlinhadasCNPq() {
		return totalNecessidadesAlinhadasCNPq;
	}
	/**
	 * @param totalNecessidadesAlinhadasCNPq the totalNecessidadesAlinhadasCNPq to set
	 */
	public void setTotalNecessidadesAlinhadasCNPq(Integer totalNecessidadesAlinhadasCNPq) {
		this.totalNecessidadesAlinhadasCNPq = totalNecessidadesAlinhadasCNPq;
	}
	/**
	 * @return the totalNecessidadesAlinhadasEGD
	 */
	public Integer getTotalNecessidadesAlinhadasEGD() {
		return totalNecessidadesAlinhadasEGD;
	}
	/**
	 * @param totalNecessidadesAlinhadasEGD the totalNecessidadesAlinhadasEGD to set
	 */
	public void setTotalNecessidadesAlinhadasEGD(Integer totalNecessidadesAlinhadasEGD) {
		this.totalNecessidadesAlinhadasEGD = totalNecessidadesAlinhadasEGD;
	}
	/**
	 * @return the totalNecessidadesProjetosTransversais
	 */
	public Integer getTotalNecessidadesProjetosTransversais() {
		return totalNecessidadesProjetosTransversais;
	}
	/**
	 * @param totalNecessidadesProjetosTransversais the totalNecessidadesProjetosTransversais to set
	 */
	public void setTotalNecessidadesProjetosTransversais(Integer totalNecessidadesProjetosTransversais) {
		this.totalNecessidadesProjetosTransversais = totalNecessidadesProjetosTransversais;
	}
	/**
	 * @return the totalNecessidadesProjetosEspecificos
	 */
	public Integer getTotalNecessidadesProjetosEspecificos() {
		return totalNecessidadesProjetosEspecificos;
	}
	/**
	 * @param totalNecessidadesProjetosEspecificos the totalNecessidadesProjetosEspecificos to set
	 */
	public void setTotalNecessidadesProjetosEspecificos(Integer totalNecessidadesProjetosEspecificos) {
		this.totalNecessidadesProjetosEspecificos = totalNecessidadesProjetosEspecificos;
	}
	/**
	 * @return the totalNecessidadesOutras
	 */
	public Integer getTotalNecessidadesOutras() {
		return totalNecessidadesOutras;
	}
	/**
	 * @param totalNecessidadesOutras the totalNecessidadesOutras to set
	 */
	public void setTotalNecessidadesOutras(Integer totalNecessidadesOutras) {
		this.totalNecessidadesOutras = totalNecessidadesOutras;
	}
	/**
	 * @return the totalNecessidadesLotacao
	 */
	public List<DTOChaveValor> getTotalNecessidadesLotacao() {
		return totalNecessidadesLotacao;
	}
	/**
	 * @param totalNecessidadesLotacao the totalNecessidadesLotacao to set
	 */
	public void setTotalNecessidadesLotacao(List<DTOChaveValor> totalNecessidadesLotacao) {
		this.totalNecessidadesLotacao = totalNecessidadesLotacao;
	}
	/**
	 * @return the totalNecessidadesCargo
	 */
	public List<DTOChaveValor> getTotalNecessidadesCargo() {
		return totalNecessidadesCargo;
	}
	/**
	 * @param totalNecessidadesCargo the totalNecessidadesCargo to set
	 */
	public void setTotalNecessidadesCargo(List<DTOChaveValor> totalNecessidadesCargo) {
		this.totalNecessidadesCargo = totalNecessidadesCargo;
	}
	/**
	 * @return the totalNecessidadesUnidade
	 */
	public List<DTOChaveValor> getTotalNecessidadesUnidade() {
		return totalNecessidadesUnidade;
	}
	/**
	 * @param totalNecessidadesUnidade the totalNecessidadesUnidade to set
	 */
	public void setTotalNecessidadesUnidade(List<DTOChaveValor> totalNecessidadesUnidade) {
		this.totalNecessidadesUnidade = totalNecessidadesUnidade;
	}
	/**
	 * @return the totalUsuariosLotacao
	 */
	public List<DTOChaveValor> getTotalUsuariosLotacao() {
		return totalUsuariosLotacao;
	}
	/**
	 * @param totalUsuariosLotacao the totalUsuariosLotacao to set
	 */
	public void setTotalUsuariosLotacao(List<DTOChaveValor> totalUsuariosLotacao) {
		this.totalUsuariosLotacao = totalUsuariosLotacao;
	}
	/**
	 * @return the totalUsuariosCargo
	 */
	public List<DTOChaveValor> getTotalUsuariosCargo() {
		return totalUsuariosCargo;
	}
	/**
	 * @param totalUsuariosCargo the totalUsuariosCargo to set
	 */
	public void setTotalUsuariosCargo(List<DTOChaveValor> totalUsuariosCargo) {
		this.totalUsuariosCargo = totalUsuariosCargo;
	}
	/**
	 * @return the totalUsuariosUnidade
	 */
	public List<DTOChaveValor> getTotalUsuariosUnidade() {
		return totalUsuariosUnidade;
	}
	/**
	 * @param totalUsuariosUnidade the totalUsuariosUnidade to set
	 */
	public void setTotalUsuariosUnidade(List<DTOChaveValor> totalUsuariosUnidade) {
		this.totalUsuariosUnidade = totalUsuariosUnidade;
	}


	
}
