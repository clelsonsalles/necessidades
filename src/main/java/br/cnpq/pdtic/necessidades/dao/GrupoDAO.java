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
public class GrupoDAO extends AbstractDAO<Grupo> {
 
	@PersistenceContext
    private EntityManager emf;
    

    public EntityManager getEntityManager(){
        return emf;
    }
	
    public GrupoDAO() {
        super(Grupo.class);
    }

    @Override
    public String getNomeEntidade() {
        return "grupo";
    }

    public List<Grupo> recuperaListaGruposProjetosEspecificos_semDGTI(){
        String select = "SELECT g FROM Grupo g WHERE g.id in(4, 5, 6, 7, 8, 9) order by g.id";

        return (List<Grupo>) getEntityManager().createQuery(select).getResultList();
    }


}
