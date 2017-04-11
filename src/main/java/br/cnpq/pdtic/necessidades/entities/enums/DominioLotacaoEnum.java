package br.cnpq.pdtic.necessidades.entities.enums;

import br.cnpq.pdtic.necessidades.entities.DominioLotacao;

public enum DominioLotacaoEnum {
	
    DCOI(1, "DCOI"), 
    DEHS(2, "DEHS"),
    DABS(3, "DABS"),
    DGTI(4, "DGTI"),
    PRESIDENCIA(5, "Presidência");
    
    private Integer id;
    private String descricao;
    private DominioLotacao entidade;


    private DominioLotacaoEnum(Integer id, String descricao) {
        this.id = id;
        this.descricao = descricao;
        
        entidade = new DominioLotacao(getId());
    }

    public Integer getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }
    
    public DominioLotacao getEntidade(){
    	return entidade;
    }
}
