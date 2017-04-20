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

    
    
    private List<DTOChaveValor> totalNecessidadesLotacao = new ArrayList<DTOChaveValor>();
    private List<DTOChaveValor> totalNecessidadesCargo = new ArrayList<DTOChaveValor>();
    private List<DTOChaveValor> totalNecessidadesUnidade = new ArrayList<DTOChaveValor>();
    
    private List<DTOChaveValor> totalUsuariosLotacao = new ArrayList<DTOChaveValor>();
    private List<DTOChaveValor> totalUsuariosCargo = new ArrayList<DTOChaveValor>();
    private List<DTOChaveValor> totalUsuariosUnidade = new ArrayList<DTOChaveValor>();
    
    private List<DTOChaveValor> alinhamentosEstrategicos = new ArrayList<DTOChaveValor>();
    
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
	/**
	 * @return the alinhamentosEstrategicos
	 */
	public List<DTOChaveValor> getAlinhamentosEstrategicos() {
		return alinhamentosEstrategicos;
	}
	/**
	 * @param alinhamentosEstrategicos the alinhamentosEstrategicos to set
	 */
	public void setAlinhamentosEstrategicos(List<DTOChaveValor> alinhamentosEstrategicos) {
		this.alinhamentosEstrategicos = alinhamentosEstrategicos;
	}


	
}
