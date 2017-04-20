/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cnpq.pdtic.necessidades.dao;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.cnpq.pdtic.necessidades.dto.DTOChaveValor;
import br.cnpq.pdtic.necessidades.entities.Usuario;

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

    
    public List<DTOChaveValor> recuperaTotalUsuariosLotacao(){
    	List<DTOChaveValor> totalUsuariosLotacao = new ArrayList<DTOChaveValor>();

    	String select =	"Select lot.nome as descricao, count(nec.id) as valor " 
    			+ "from Necessidade nec "
    			+ "inner join Usuario u on nec.usuario = u.idUsuario "
    			+ "inner join DominioLotacao lot on u.lotacao = lot.idlotacao "
    			+ "Group by lot.nome";
    	Query query = getEntityManager().createNativeQuery(select, "DTOChaveValorMapping");

    	totalUsuariosLotacao = query.getResultList();
    	return totalUsuariosLotacao;
    }
    
    public List<DTOChaveValor> recuperaTotalUsuariosCargo(){
    	List<DTOChaveValor> totalUsuariosCargo = new ArrayList<DTOChaveValor>();

    	String select =	"Select car.nome as descricao, count(u.idUsuario) as valor " 
    			+ "from Usuario u "
    			+ "inner join dominiocargo car on u.cargo = car.idcargo "
    			+ "Group by car.nome";
    	Query query = getEntityManager().createNativeQuery(select, "DTOChaveValorMapping");

    	totalUsuariosCargo = query.getResultList();
    	return totalUsuariosCargo;
    }

    public List<DTOChaveValor> recuperaTotalUsuariosUnidade(){
    	List<DTOChaveValor> totalUsuariosUnidade = new ArrayList<DTOChaveValor>();

    	String select =	"Select u.unidade as descricao, count(u.idUsuario) as valor " 
    			+ "from Usuario u "
    			+ "Group by u.unidade";
    	Query query = getEntityManager().createNativeQuery(select, "DTOChaveValorMapping");

    	totalUsuariosUnidade = query.getResultList();
    	return totalUsuariosUnidade;
    }


    public Integer recuperaTotalUsuariosFinalizados(){
    	String select =	"Select count(u.idUsuario) " 
    			+ "from Usuario u "
    			+ "WHERE u.finalizado = true";
    	Query query = getEntityManager().createNativeQuery(select);

    	return ((BigInteger)  query.getSingleResult()).intValue();
    }

    
}
