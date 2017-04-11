package br.cnpq.pdtic.necessidades.entities.enums;

import br.cnpq.pdtic.necessidades.entities.DominioCargo;

public enum DominioCargoEnum {
	
    DIRETOR(1, "Diretor"), 
    ASSESSOR(2, "Assessor"),
    ASSISTENTE(3, "Assistente"),
    COORDENADOR_GERAL(4, "Coordenador(a) Geral"),
    COORDENADOR_TECNICO(5, "Coordenador(a) Técnico"),
    CHEFE_SERVICO(6, "Chefe de Serviço");
    
    private Integer id;
    private String descricao;
    private DominioCargo entidade;

    private DominioCargoEnum(Integer id, String descricao) {
        this.id = id;
        this.descricao = descricao;
        
        entidade = new DominioCargo(getId());
    }

    public Integer getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }
    
    public DominioCargo getEntidade(){
    	return entidade;
    }
}
