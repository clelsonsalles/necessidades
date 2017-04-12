/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cnpq.pdtic.necessidades.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.cnpq.pdtic.necessidades.entities.Grupo;
import br.cnpq.pdtic.necessidades.entities.Questao;


public class DTOGrupo implements Serializable{
    private static final long serialVersionUID = 1L;
    
	private Integer id;
	
	private String nome;
	
	private String titulo;

	private List<DTOProjeto> questoes = new ArrayList<DTOProjeto>();

	
	
	public static final Integer ID_GRUPO_OUTRAS_NECESSIDADES = 10;

	
	public static DTOGrupo converteEntity(Grupo grupo){
		DTOGrupo dto = new DTOGrupo();
		
		dto.setId(grupo.getId());
		dto.setNome(grupo.getNome());
		dto.setTitulo(grupo.getTitulo());

		List<Questao> questoesGrupo = grupo.getQuestoes();
		for (Questao questao : questoesGrupo) {
			DTOProjeto projeto = DTOProjeto.converteEntity(questao);
			dto.getQuestoes().add(projeto);
		}


		return dto;
	}

	public static List<DTOGrupo> converteEntity(List<Grupo> grupos){
		List<DTOGrupo> dtoGrupos = new ArrayList<DTOGrupo>();
		for (Grupo grupo : grupos) {
			DTOGrupo dto = DTOGrupo.converteEntity(grupo);
			dtoGrupos.add(dto);
		}
		return dtoGrupos;
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
	 * @return the questoes
	 */
	public List<DTOProjeto> getQuestoes() {
		return questoes;
	}


	/**
	 * @param questoes the questoes to set
	 */
	public void setQuestoes(List<DTOProjeto> questoes) {
		this.questoes = questoes;
	}


	
    
}
