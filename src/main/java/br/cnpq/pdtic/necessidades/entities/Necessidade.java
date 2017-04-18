/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cnpq.pdtic.necessidades.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
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
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.cnpq.pdtic.necessidades.dto.DTOChaveValor;

@SqlResultSetMapping(name="DTOChaveValorMapping",
classes = {
 @ConstructorResult(targetClass = DTOChaveValor.class,
   columns = {@ColumnResult(name="descricao", type=String.class), @ColumnResult(name="valor", type=Integer.class)}
 )}
)
@Entity
@Table(name = "Necessidade")
@NamedQueries({
    @NamedQuery(name = "necessidade.findAll", query = "SELECT n FROM Necessidade n"),
    @NamedQuery(name = "necessidade.listaTodasOrdemTitulo", query = "SELECT n FROM Necessidade n order by n.titulo")})
public class Necessidade implements Serializable{
    private static final long serialVersionUID = 1L;
    
	@Id
/*	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Necessidade")
	@SequenceGenerator(name = "id_Necessidade", sequenceName = "ID_NECESSIDADE")
*/	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id")
	private Integer id;
	
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 200)
	@Column(name = "titulo")
	private String titulo;
	
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 500)
	@Column(name = "descricao")
	private String descricao;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 1000)
	@Column(name = "justificativa")
	private String justificativa;

	@Column(name = "sistema")
	private String sistema;

	@Column(name = "plataforma")
	private String plataforma;

	@Column(name = "assunto")
	private String assunto;

	@Column(name = "ordem")
	private Integer ordem;

	@JoinColumn(name = "questao", referencedColumnName = "id")
    @ManyToOne
    private Questao questao;

	@JoinColumn(name = "usuario", referencedColumnName = "idUsuario")
    @ManyToOne
    private Usuario usuario;
	
	@OneToMany(mappedBy = "necessidade", fetch=FetchType.EAGER, cascade = CascadeType.REMOVE)
	private List<AlinhamentoNecessidadeObjetivo> alinhamentos;


	public Necessidade() {
    }

    public Necessidade(Integer id) {
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
