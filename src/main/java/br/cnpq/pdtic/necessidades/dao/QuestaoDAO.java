/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cnpq.pdtic.necessidades.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.cnpq.pdtic.necessidades.dto.DTOProjeto;
import br.cnpq.pdtic.necessidades.entities.Questao;

@Repository
public class QuestaoDAO extends AbstractDAO<Questao> {
 
	@PersistenceContext
    private EntityManager emf;
    

    public EntityManager getEntityManager(){
        return emf;
    }
	
    public QuestaoDAO() {
        super(Questao.class);
    }

    @Override
    public String getNomeEntidade() {
        return "Questão";
    }

    public List<Questao> recuperaListaProjetosTransversais(){
        String select = "SELECT q FROM Questao q WHERE q.grupo.id = 1 order by q.ordem";

        return (List<Questao>) getEntityManager().createQuery(select).getResultList();
    }
    
    
    public List<Questao> recuperaListaProjetosEspecificos(){
        String select = "SELECT q FROM Questao q WHERE q.grupoid in(2,3) order by q.ordem";

        return (List<Questao>) getEntityManager().createQuery(select).getResultList();
    }

    public Questao recuperaQuestaoOutrasNecessidades(){
        String select = "SELECT q FROM Questao q WHERE q.grupo.id = " + DTOProjeto.ID_GRUPO_OUTRAS_NECESSIDADES
        		+ " order by q.ordem";

        return (Questao) getEntityManager().createQuery(select).getSingleResult();
    }

}
