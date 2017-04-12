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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name = "Usuario")
@NamedQueries({
    @NamedQuery(name = "usuario.findAll", query = "SELECT t FROM Usuario t")})
public class Usuario implements Serializable{
    private static final long serialVersionUID = 1L;
    
	@Id
/*	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Usuario")
	@SequenceGenerator(name = "id_Usuario", sequenceName = "ID_USUARIO")
*/	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "idUsuario")
	private Integer idUsuario;
	
	@Basic(optional = false)
	@NotNull
	@Column(name = "nome")
	private String nome;
	
	@Basic(optional = false)
	@NotNull
	@Column(name = "email", unique = true)
	private String email;
	
	
	@Basic(optional = false)
	@NotNull
	@Column(name = "senha")
	private String senha;
	
	@Column(name = "unidade")
	private String unidade;
	
	@Column(name = "leuInstrucoes")
	private Boolean leuInstrucoes;

	@Column(name = "comentarios", columnDefinition="TEXT")
	private String comentarios;

	@Column(name = "finalizado")
	private Boolean finalizado;


	@JoinColumn(name = "cargo", referencedColumnName = "idCargo")
    @ManyToOne
    private DominioCargo cargo;

    @JoinColumn(name = "lotacao", referencedColumnName = "idLotacao")
    @ManyToOne
    private DominioLotacao lotacao;

    public Usuario() {
    }

    public Usuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

	/**
	 * @return the idUsuario
	 */
	public Integer getIdUsuario() {
		return idUsuario;
	}

	/**
	 * @param idUsuario the idUsuario to set
	 */
	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
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
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the senha
	 */
	public String getSenha() {
		return senha;
	}

	/**
	 * @param senha the senha to set
	 */
	public void setSenha(String senha) {
		this.senha = senha;
	}

	/**
	 * @return the unidade
	 */
	public String getUnidade() {
		return unidade;
	}

	/**
	 * @param unidade the unidade to set
	 */
	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}

	/**
	 * @return the cargo
	 */
	public DominioCargo getCargo() {
		return cargo;
	}

	/**
	 * @param cargo the cargo to set
	 */
	public void setCargo(DominioCargo cargo) {
		this.cargo = cargo;
	}

	/**
	 * @return the lotacao
	 */
	public DominioLotacao getLotacao() {
		return lotacao;
	}

	/**
	 * @param lotacao the lotacao to set
	 */
	public void setLotacao(DominioLotacao lotacao) {
		this.lotacao = lotacao;
	}

	/**
	 * @return the leuInstrucoes
	 */
	public Boolean getLeuInstrucoes() {
		return leuInstrucoes;
	}

	/**
	 * @param leuInstrucoes the leuInstrucoes to set
	 */
	public void setLeuInstrucoes(Boolean leuInstrucoes) {
		this.leuInstrucoes = leuInstrucoes;
	}

	/**
	 * @return the finalizado
	 */
	public Boolean getFinalizado() {
		return finalizado;
	}

	/**
	 * @param finalizado the finalizado to set
	 */
	public void setFinalizado(Boolean finalizado) {
		this.finalizado = finalizado;
	}

	/**
	 * @return the comentarios
	 */
	public String getComentarios() {
		return comentarios;
	}

	/**
	 * @param comentarios the comentarios to set
	 */
	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}


    
}
