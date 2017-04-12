/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cnpq.pdtic.necessidades.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "Grupo")
@NamedQueries({
    @NamedQuery(name = "grupo.findAll", query = "SELECT g FROM Grupo g")})
public class Grupo implements Serializable{
    private static final long serialVersionUID = 1L;
    
	@Id
/*	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Grupo")
	@SequenceGenerator(name = "id_Grupo", sequenceName = "ID_GRUPO")
*/	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "titulo")
	private String titulo;

	@OneToMany(mappedBy = "grupo")
	private List<Questao> questoes;

	
    public Grupo() {
    }

    public Grupo(Integer id) {
        this.id = id;
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
	public List<Questao> getQuestoes() {
		return questoes;
	}

	/**
	 * @param questoes the questoes to set
	 */
	public void setQuestoes(List<Questao> questoes) {
		this.questoes = questoes;
	}

    
}
