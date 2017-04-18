/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cnpq.pdtic.necessidades.dao;

import java.util.HashMap;

import javax.persistence.EntityManager;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.cnpq.pdtic.necessidades.entities.Usuario;
import br.cnpq.pdtic.necessidades.util.PasswordUtils;

@Repository
public class UsuarioDAO extends AbstractDAO<Usuario> {
 
	@PersistenceContext
    private EntityManager emf;
    

    public EntityManager getEntityManager(){
        return emf;
    }
	
    public UsuarioDAO() {
        super(Usuario.class);
    }

    @Override
    public String getNomeEntidade() {
        return "usuario";
    }

    public void criarUsuario(Usuario usuario) throws Exception {
		create(usuario);
	}
	
    public void atualizarUsuario(Usuario usuario) throws Exception {
		edit(usuario);
	}

    public void informarLeuInstrucoes(Usuario usuario) throws Exception {
		usuario.setLeuInstrucoes(true);
		
		edit(usuario);;
	}
    
    public Usuario login(String login, String password) throws Exception {
        String select = "SELECT t FROM Usuario t WHERE t.email = :nmLogin and t.senha = :nmSenha";

        HashMap<String, Object> map = new HashMap<>();
        map.put("nmLogin", login);
        map.put("nmSenha", password);
        Usuario tbUsuario = selectObject(select, map);

        return tbUsuario;
    }

    public Usuario findByEmail(String eeEmail) throws NonUniqueResultException {
    	Usuario usuario = null;
    	try {
    		String select = "SELECT t FROM Usuario t WHERE t.email = :eeEmail";
    		HashMap<String, Object> map = new HashMap<>();
    		map.put("eeEmail", eeEmail);
    		usuario = selectObject(select, map);
    	} catch (NonUniqueResultException e) {
    		throw e;
    	} catch (Exception e) {
			e.printStackTrace();
		}
    	return usuario;
    }

    public Usuario findByLogin(String login) throws Exception {
        String select = "SELECT t FROM Usuario t WHERE t.email = :nmLogin";

        HashMap<String, Object> map = new HashMap<>();
        map.put("nmLogin", login);
        Usuario tbUsuario = selectObject(select, map);

        return tbUsuario;
    }

    
    
}
