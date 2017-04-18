/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cnpq.pdtic.necessidades.dto;

import java.io.Serializable;


public class DTOChaveValor implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private String descricao;
	private Integer valor;
	
	
	
	public DTOChaveValor(String descricao, Integer valor) {
		super();
		this.descricao = descricao;
		this.valor = valor;
	}
	
	
	public DTOChaveValor(String descricao, String valor) {
		super();
		this.descricao = descricao;
		this.valor = Integer.parseInt(valor);
	}
	
	public DTOChaveValor() {
		super();
		// TODO Auto-generated constructor stub
	}


	/**
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}
	/**
	 * @param descricao the descricao to set
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	/**
	 * @return the valor
	 */
	public Integer getValor() {
		return valor;
	}
	/**
	 * @param valor the valor to set
	 */
	public void setValor(Integer valor) {
		this.valor = valor;
	}

	
	
    
}
