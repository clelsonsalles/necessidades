/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cnpq.pdtic.necessidades.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.cnpq.pdtic.necessidades.entities.AlinhamentoNecessidadeObjetivo;

@Repository
public class AlinhamentoNecessidadeObjetivoDAO extends AbstractDAO<AlinhamentoNecessidadeObjetivo> {
    
	@PersistenceContext
    private EntityManager emf;
    

    public EntityManager getEntityManager(){
        return emf;
    }

     public AlinhamentoNecessidadeObjetivoDAO() {
        super(AlinhamentoNecessidadeObjetivo.class);
    }

    @Override
    public String getNomeEntidade() {
        return "AlinhamentoNecessidadeObjetivo";
    }
    
    
	public List<AlinhamentoNecessidadeObjetivo> recuperaListaAlinhamentoNecessidade(Integer idNecessidade) throws Exception {
        String select = "SELECT ae FROM AlinhamentoNecessidadeObjetivo ae WHERE ae.necessidade.id = " + idNecessidade;
        Query query = getEntityManager().createQuery(select);

        return query.getResultList();
	}


}
