/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cnpq.pdtic.necessidades.entities;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table(name = "AlinhamentoEstrategico")
@NamedQueries({
    @NamedQuery(name = "alinhamentoNecessidadeObjetivo.findAll", query = "SELECT ae FROM AlinhamentoNecessidadeObjetivo ae")})
public class AlinhamentoNecessidadeObjetivo implements Serializable{
    private static final long serialVersionUID = 1L;
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id")
	private Integer id;
	
	
	@JoinColumn(name = "necessidade", referencedColumnName = "id")
    @ManyToOne
    private Necessidade necessidade;

	@JoinColumn(name = "objetivoEstrategico", referencedColumnName = "id")
    @ManyToOne
    private ObjetivoEstrategico objetivoEstrategico;
	

	public AlinhamentoNecessidadeObjetivo() {
    }

    public AlinhamentoNecessidadeObjetivo(Integer idAlinhamento) {
        this.id = idAlinhamento;
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
	 * @return the necessidade
	 */
	public Necessidade getNecessidade() {
		return necessidade;
	}

	/**
	 * @param necessidade the necessidade to set
	 */
	public void setNecessidade(Necessidade necessidade) {
		this.necessidade = necessidade;
	}

	/**
	 * @return the objetivoEstrategico
	 */
	public ObjetivoEstrategico getObjetivoEstrategico() {
		return objetivoEstrategico;
	}

	/**
	 * @param objetivoEstrategico the objetivoEstrategico to set
	 */
	public void setObjetivoEstrategico(ObjetivoEstrategico objetivoEstrategico) {
		this.objetivoEstrategico = objetivoEstrategico;
	}
    
}
