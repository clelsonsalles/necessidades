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
import br.cnpq.pdtic.necessidades.entities.Grupo;
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
        String select = "SELECT q FROM Questao q WHERE q.grupo.id in(4, 5, 6, 7, 8, 9) order by q.ordem";

        return (List<Questao>) getEntityManager().createQuery(select).getResultList();
    }

    public List<Questao> recuperaListaProjetosEspecificosDGTI_E1(){
        String select = "SELECT q FROM Questao q WHERE q.grupo.id = 2 order by q.ordem";

        return (List<Questao>) getEntityManager().createQuery(select).getResultList();
    }

    public List<Questao> recuperaListaProjetosEspecificosDGTI_Outros(){
        String select = "SELECT q FROM Questao q WHERE q.grupo.id = 3 order by q.ordem";

        return (List<Questao>) getEntityManager().createQuery(select).getResultList();
    }
    
    public Questao recuperaQuestaoOutrasNecessidades(){
        String select = "SELECT q FROM Questao q WHERE q.grupo.id = " + DTOProjeto.ID_GRUPO_OUTRAS_NECESSIDADES
        		+ " order by q.ordem";

        return (Questao) getEntityManager().createQuery(select).getSingleResult();
    }

    public List<Questao>  recuperaQuestoes(Grupo grupo){
        String select = "SELECT q FROM Questao q WHERE q.grupo.id = " + grupo.getId()
        		+ " order by q.ordem";

        return (List<Questao>) getEntityManager().createQuery(select).getResultList();
    }

}
