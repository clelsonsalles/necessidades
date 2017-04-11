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
import br.cnpq.pdtic.necessidades.entities.Necessidade;
import br.cnpq.pdtic.necessidades.entities.Questao;
import br.cnpq.pdtic.necessidades.entities.Usuario;

@Repository
public class NecessidadeDAO extends AbstractDAO<Necessidade> {
 
	@PersistenceContext
    private EntityManager emf;
    

    public EntityManager getEntityManager(){
        return emf;
    }
	
    public NecessidadeDAO() {
        super(Necessidade.class);
    }

    @Override
    public String getNomeEntidade() {
        return "Necessidade";
    }

    public void incluirNecessidade(Necessidade necessidade) throws Exception {
		create(necessidade);
	}

    
    public List<Necessidade> recuperaListaNecessidades(DTOProjeto projeto, Usuario usuario){
        String select = "SELECT ne FROM Necessidade ne WHERE ne.usuario.idUsuario = " + usuario.getIdUsuario()
        		+ " and ne.questao.id = " + projeto.getId()
        		+ " order by ne.ordem";
	
        return (List<Necessidade>) getEntityManager().createQuery(select).getResultList();

    }
    
}
