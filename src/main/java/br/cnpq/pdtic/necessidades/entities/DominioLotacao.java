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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "DominioLotacao")
@NamedQueries({
    @NamedQuery(name = "DominioLotacao.findAll", query = "SELECT dl FROM DominioLotacao dl")})
public class DominioLotacao implements Serializable{
    private static final long serialVersionUID = 1L;
    
	@Id
/*	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Lotacao")
	@SequenceGenerator(name = "id_Lotacao", sequenceName = "ID_LOTACAO")
*/
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "idLotacao")
	private Integer idLotacao;
	
	@Basic(optional = false)
	@NotNull
	@Column(name = "nome")
	private String nome;
	
    public DominioLotacao() {
    }

    public DominioLotacao(Integer idLotacao) {
        this.idLotacao = idLotacao;
    }

	/**
	 * @return the idLotacao
	 */
	public Integer getIdLotacao() {
		return idLotacao;
	}

	/**
	 * @param idLotacao the idLotacao to set
	 */
	public void setIdLotacao(Integer idLotacao) {
		this.idLotacao = idLotacao;
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
    
    
    


}
