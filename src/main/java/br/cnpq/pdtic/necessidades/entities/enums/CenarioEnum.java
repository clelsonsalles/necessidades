package br.cnpq.pdtic.necessidades.entities.enums;

public enum CenarioEnum {
	
    INICIAL(1, "Inicial"), 
    INCLUSAO(2, "Inclusão"),
    EXCLUSAO(3, "Exclusão"),
    EDICAO(4, "Edição");
    
    private Integer id;
    private String descricao;

    private CenarioEnum(Integer id, String descricao) {
        this.id = id;
        this.descricao = descricao;
        
    }

    public Integer getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }
    
    public boolean isInicial(){
    	return this.id.equals(CenarioEnum.INICIAL.getId());
    }
    public boolean isInclusao(){
    	return this.id.equals(CenarioEnum.INCLUSAO.getId());
    }
    public boolean isExclusao(){
    	return this.id.equals(CenarioEnum.EXCLUSAO.getId());
    }
    public boolean isEdicao(){
    	return this.id.equals(CenarioEnum.EDICAO.getId());
    }
}
