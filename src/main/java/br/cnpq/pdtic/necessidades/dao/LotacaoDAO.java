/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cnpq.pdtic.necessidades.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.cnpq.pdtic.necessidades.entities.DominioLotacao;

@Repository
public class LotacaoDAO extends AbstractDAO<DominioLotacao> {
    
	@PersistenceContext
    private EntityManager emf;
    

    public EntityManager getEntityManager(){
        return emf;
    }

    public LotacaoDAO() {
        super(DominioLotacao.class);
    }

    @Override
    public String getNomeEntidade() {
        return "lotacao";
    }


	public List<DominioLotacao> recuperaListaLotacao() throws Exception {
		return findAll();
	}
	

}
