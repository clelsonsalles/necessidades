/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cnpq.pdtic.necessidades.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.cnpq.pdtic.necessidades.entities.DominioCargo;

@Repository
public class CargoDAO extends AbstractDAO<DominioCargo> {
    
	@PersistenceContext
    private EntityManager emf;
    

    public EntityManager getEntityManager(){
        return emf;
    }

     public CargoDAO() {
        super(DominioCargo.class);
    }

    @Override
    public String getNomeEntidade() {
        return "cargo";
    }

	public List<DominioCargo> recuperaListaCargo() throws Exception {
		return findAll();
	}


}
