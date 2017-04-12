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
@Table(name = "DominioCargo")
@NamedQueries({
    @NamedQuery(name = "dominioCargo.findAll", query = "SELECT dl FROM DominioCargo dl")})
public class DominioCargo implements Serializable{
    private static final long serialVersionUID = 1L;
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
/*	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Cargo")
	@SequenceGenerator(name = "id_Cargo", sequenceName = "ID_CARGO")
*/	@Basic(optional = false)
	@Column(name = "idCargo")
	private Integer idCargo;
	
	@Basic(optional = false)
	@NotNull
	@Column(name = "nome")
	private String nome;
	
    public DominioCargo() {
    }

    public DominioCargo(Integer idCargo) {
        this.idCargo = idCargo;
    }

	/**
	 * @return the idCargo
	 */
	public Integer getIdCargo() {
		return idCargo;
	}

	/**
	 * @param idCargo the idCargo to set
	 */
	public void setIdCargo(Integer idCargo) {
		this.idCargo = idCargo;
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
