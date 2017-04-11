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

import br.cnpq.pdtic.necessidades.entities.ObjetivoEstrategico;

@Repository
public class ObjetivoEstrategicoDAO extends AbstractDAO<ObjetivoEstrategico> {
    
	@PersistenceContext
    private EntityManager emf;
    

    public EntityManager getEntityManager(){
        return emf;
    }

     public ObjetivoEstrategicoDAO() {
        super(ObjetivoEstrategico.class);
    }

    @Override
    public String getNomeEntidade() {
        return "ObjetivoEstrategico";
    }

	public List<ObjetivoEstrategico> recuperaListaObjetivosCNPq() throws Exception {
        String select = "SELECT oe FROM ObjetivoEstrategico oe WHERE oe.tipo = 'CNPq' ORDER BY oe.titulo";
        Query query = getEntityManager().createQuery(select);

        return query.getResultList();
	}

	public List<ObjetivoEstrategico> recuperaListaObjetivosEGD() throws Exception {
        String select = "SELECT oe FROM ObjetivoEstrategico oe WHERE oe.tipo = 'EGD' ORDER BY oe.titulo";
        Query query = getEntityManager().createQuery(select);

        return query.getResultList();
	}

}
