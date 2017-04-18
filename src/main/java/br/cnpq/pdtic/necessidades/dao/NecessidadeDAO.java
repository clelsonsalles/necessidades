/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cnpq.pdtic.necessidades.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.cnpq.pdtic.necessidades.dto.DTOChaveValor;
import br.cnpq.pdtic.necessidades.dto.DTOProjeto;
import br.cnpq.pdtic.necessidades.entities.Necessidade;
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
        return "necessidade";
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
    
    
    public List<DTOChaveValor> recuperaTotalNecessidadesLotacao(){
    	List<DTOChaveValor> totalNecessidadesLotacao = new ArrayList<DTOChaveValor>();
    	String select =	"Select lot.nome as descricao, count(nec.id) as valor " 
    			+ "from Necessidade nec "
    			+ "inner join Usuario u on nec.usuario = u.idUsuario "
    			+ "inner join DominioLotacao lot on u.lotacao = lot.idlotacao "
    			+ "Group by lot.nome";
    	
    	Query query = getEntityManager().createNativeQuery(select, "DTOChaveValorMapping");
    	
    	totalNecessidadesLotacao = query.getResultList();
    	
    	return totalNecessidadesLotacao;
    	
    	/*
    private Map<String, Integer> totalNecessidadesLotacao = new HashMap<String, Integer>();
    private Map<String, Integer> totalNecessidadesCargo = new HashMap<String, Integer>();
    private Map<String, Integer> totalNecessidadesUnidade = new HashMap<String, Integer>();
    
    
    private Map<String, Integer> totalUsuariosLotacao = new HashMap<String, Integer>();
    private Map<String, Integer> totalUsuariosCargo = new HashMap<String, Integer>();
    private Map<String, Integer> totalUsuariosUnidade = new HashMap<String, Integer>();
    	 
    	  
    	 */
    	
    	
    }
    
}
