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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "ObjetivoEstrategico")
@NamedQueries({
    @NamedQuery(name = "objetivoEstrategico.findAll", query = "SELECT oe FROM ObjetivoEstrategico oe")})
public class ObjetivoEstrategico implements Serializable{
    private static final long serialVersionUID = 1L;
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id")
	private Integer id;
	
	@Basic(optional = false)
	@NotNull
	@Column(name = "tipo")
	private String tipo;

	@Basic(optional = false)
	@NotNull
	@Column(name = "titulo")
	private String titulo;

	@Basic(optional = false)
	@NotNull
	@Column(name = "nome", columnDefinition="TEXT")
	private String nome;
	
	@OneToMany(mappedBy = "objetivoEstrategico")
	private List<AlinhamentoNecessidadeObjetivo> alinhamentos;

	public ObjetivoEstrategico() {
    }

    public ObjetivoEstrategico(Integer idObjetivo) {
        this.id= idObjetivo;
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
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
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
	 * @return the alinhamentos
	 */
	public List<AlinhamentoNecessidadeObjetivo> getAlinhamentos() {
		return alinhamentos;
	}

	/**
	 * @param alinhamentos the alinhamentos to set
	 */
	public void setAlinhamentos(List<AlinhamentoNecessidadeObjetivo> alinhamentos) {
		this.alinhamentos = alinhamentos;
	}

    
}
