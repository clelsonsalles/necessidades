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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.PostLoad;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;


@Entity
@Table(name = "Questao")
@NamedQueries({
    @NamedQuery(name = "questao.findAll", query = "SELECT q FROM Questao q")})
public class Questao implements Serializable{
    private static final long serialVersionUID = 1L;
    
	@Id
/*	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Questao")
	@SequenceGenerator(name = "id_Questao", sequenceName = "ID_QUESTAO")
*/	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id")
	private Integer id;
	
	@NotNull
	@Column(name = "nome")
	private String nome;
	
	@NotNull
	@Column(name = "descricao", length = 10000)
	private String descricao;

	@NotNull
	@Column(name = "justificativa", length = 10000)
	private String justificativa;
	
	@Column(name = "ordem")
	private Integer ordem;

	
	@JoinColumn(name = "grupo", referencedColumnName = "id")
    @ManyToOne(fetch=FetchType.EAGER)
    private Grupo grupo;

	@OneToMany(mappedBy = "questao")
	private List<Necessidade> necessidades;

	
	public Questao() {
    }

    public Questao(Integer id) {
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

	public List<Necessidade> getNecessidades() {
		return necessidades;
	}

	public void setNecessidades(List<Necessidade> necessidades) {
		this.necessidades = necessidades;
	}

    
}
