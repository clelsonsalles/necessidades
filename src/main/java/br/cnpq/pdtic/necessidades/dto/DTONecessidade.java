/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cnpq.pdtic.necessidades.dto;

import java.io.Serializable;

import br.cnpq.pdtic.necessidades.entities.Necessidade;
import br.cnpq.pdtic.necessidades.entities.Questao;
import br.cnpq.pdtic.necessidades.entities.Usuario;


public class DTONecessidade implements Serializable{
    private static final long serialVersionUID = 1L;
    
	private Integer id;

	private String titulo;

	private String descricao;

	private String justificativa;
	
	private String sistema;
	
	private String plataforma;
	
	private String assunto;

	private Integer ordem;

    private Questao questao;

    private Usuario usuario;

    
	public static DTONecessidade converteEntity(Necessidade necessidade){
		DTONecessidade dto = new DTONecessidade();
		
		dto.setId(necessidade.getId());
		dto.setTitulo(necessidade.getTitulo());
		dto.setDescricao(necessidade.getDescricao());
		dto.setJustificativa(necessidade.getJustificativa());
		dto.setOrdem(necessidade.getOrdem());
		
		dto.setSistema(necessidade.getSistema());
		dto.setPlataforma(necessidade.getPlataforma());
		dto.setAssunto(necessidade.getAssunto());

		dto.setQuestao(necessidade.getQuestao());
		dto.setUsuario(necessidade.getUsuario());

		return dto;
	}

	
	public Necessidade converteDTO(){
		Necessidade entity = new Necessidade();
		
		entity.setId(this.getId());
		entity.setTitulo(this.getTitulo());
		entity.setDescricao(this.getDescricao());
		entity.setJustificativa(this.getJustificativa());
		entity.setOrdem(this.getOrdem());
		
		entity.setSistema(this.getSistema());
		entity.setPlataforma(this.getPlataforma());
		entity.setAssunto(this.getAssunto());

		entity.setQuestao(this.getQuestao());
		entity.setUsuario(this.getUsuario());

		return entity;
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
	 * @return the titulo
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * @param titulo the titulo to set
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
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
	 * @return the questao
	 */
	public Questao getQuestao() {
		return questao;
	}

	/**
	 * @param questao the questao to set
	 */
	public void setQuestao(Questao questao) {
		this.questao = questao;
	}

	/**
	 * @return the usuario
	 */
	public Usuario getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return the sistema
	 */
	public String getSistema() {
		return sistema;
	}

	/**
	 * @param sistema the sistema to set
	 */
	public void setSistema(String sistema) {
		this.sistema = sistema;
	}

	/**
	 * @return the plataforma
	 */
	public String getPlataforma() {
		return plataforma;
	}

	/**
	 * @param plataforma the plataforma to set
	 */
	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}

	/**
	 * @return the assunto
	 */
	public String getAssunto() {
		return assunto;
	}

	/**
	 * @param assunto the assunto to set
	 */
	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}
    
    
}
