/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cnpq.pdtic.necessidades.dto;

import java.io.Serializable;
import java.util.List;

import br.cnpq.pdtic.necessidades.entities.Grupo;
import br.cnpq.pdtic.necessidades.entities.Questao;


public class DTOProjeto implements Serializable{
    private static final long serialVersionUID = 1L;
    
	private Integer id;
	
	private String nome;

	private String descricao;

	private String justificativa;

	private Integer ordem;

    private Grupo grupo;

	private List<DTONecessidade> necessidades;
	
	
	public static final Integer ID_GRUPO_OUTRAS_NECESSIDADES = 10;

	
	public static DTOProjeto converteEntity(Questao questao){
		DTOProjeto dto = new DTOProjeto();
		
		dto.setId(questao.getId());
		dto.setNome(questao.getNome());
		dto.setDescricao(questao.getDescricao());
		dto.setJustificativa(questao.getJustificativa());
		dto.setOrdem(questao.getOrdem());
		
		dto.setGrupo(questao.getGrupo());


		return dto;
	}


	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}


	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}


	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
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
	 * @return the justificativa
	 */
	public String getJustificativa() {
		return justificativa;
	}


	/**
	 * @param justificativa the justificativa to set
	 */
	public void setJustificativa(String justificativa) {
		this.justificativa = justificativa;
	}


	/**
	 * @return the ordem
	 */
	public Integer getOrdem() {
		return ordem;
	}


	/**
	 * @param ordem the ordem to set
	 */
	public void setOrdem(Integer ordem) {
		this.ordem = ordem;
	}


	/**
	 * @return the grupo
	 */
	public Grupo getGrupo() {
		return grupo;
	}


	/**
	 * @param grupo the grupo to set
	 */
	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}


	/**
	 * @return the necessidades
	 */
	public List<DTONecessidade> getNecessidades() {
		return necessidades;
	}


	/**
	 * @param necessidades the necessidades to set
	 */
	public void setNecessidades(List<DTONecessidade> necessidades) {
		this.necessidades = necessidades;
	}

	
    
}
