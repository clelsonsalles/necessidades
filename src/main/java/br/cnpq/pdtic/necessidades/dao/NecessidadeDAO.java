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
    }
    	
    public List<DTOChaveValor> recuperaTotalNecessidadesCargo(){
    	List<DTOChaveValor> totalNecessidadesCargo = new ArrayList<DTOChaveValor>();

    	String select =	"Select car.nome as descricao, count(nec.id) as valor " 
    			+ "from Necessidade nec "
    			+ "inner join Usuario u on nec.usuario = u.idUsuario "
    			+ "inner join dominiocargo car on u.cargo = car.idcargo "
    			+ "Group by car.nome";
    	Query query = getEntityManager().createNativeQuery(select, "DTOChaveValorMapping");

    	totalNecessidadesCargo = query.getResultList();
    	return totalNecessidadesCargo;
    }

    public List<DTOChaveValor> recuperaTotalNecessidadesUnidade(){
    	List<DTOChaveValor> totalNecessidadesUnidade = new ArrayList<DTOChaveValor>();

    	
    	String select =	"Select u.unidade as descricao, count(nec.id) as valor " 
    			+ "from Necessidade nec "
    			+ "inner join Usuario u on nec.usuario = u.idUsuario "
    			+ "Group by u.unidade";
    	Query query = getEntityManager().createNativeQuery(select, "DTOChaveValorMapping");

    	totalNecessidadesUnidade = query.getResultList();
    	return totalNecessidadesUnidade;
    }
    
    
    public List<DTOChaveValor> recuperaAlinhamentosEstrategicos(){
    	List<DTOChaveValor> totalNecessidadesEstrategicas = new ArrayList<DTOChaveValor>();

    	// Necessidades alinhadas a Projetos Transversais do CNPq 
    	String selectTransversaisCNPq =	"select 'Projetos Transversais' as descricao, count (nec.id) as valor  "
    			+ "from necessidade nec "
    			+ "inner join questao q on nec.questao = q.id "
    			+ "inner join grupo g on q.grupo = g.id "
    			+ "where g.id = 1";
    	Query queryTransversaisCNPq = getEntityManager().createNativeQuery(selectTransversaisCNPq, "DTOChaveValorMapping");
    	DTOChaveValor dtoTransversaisCNPq = (DTOChaveValor) queryTransversaisCNPq.getSingleResult();
    	totalNecessidadesEstrategicas.add(dtoTransversaisCNPq);

    	// Necessidades alinhadas a Projetos Específicos do CNPq 
    	String selectEspecificosCNPq =	"select 'Projetos Específicos' as descricao, count (nec.id) as valor  "
    			+ "from necessidade nec "
    			+ "inner join questao q on nec.questao = q.id "
    			+ "inner join grupo g on q.grupo = g.id "
    			+ "where g.id in (2,3,4,5,6,7,8,9)";
    	Query queryEspecificosCNPq = getEntityManager().createNativeQuery(selectEspecificosCNPq, "DTOChaveValorMapping");
    	DTOChaveValor dtoEspecificosCNPq = (DTOChaveValor) queryEspecificosCNPq.getSingleResult();
    	totalNecessidadesEstrategicas.add(dtoEspecificosCNPq);

    	// Necessidades alinhadas a objetivos estratégico do CNPq
    	String selectOECNPq =	"Select 'Objetivos Estratégicos CNPq' as descricao, count(distinct ae.necessidade) as valor  "
    			+ "from alinhamentoestrategico ae "
    			+ "inner join objetivoestrategico oe on ae.objetivoestrategico = oe.id "
    			+ "where oe.tipo = 'CNPq'";
    	Query queryOECNPq = getEntityManager().createNativeQuery(selectOECNPq, "DTOChaveValorMapping");
    	DTOChaveValor dtoOECNPq = (DTOChaveValor) queryOECNPq.getSingleResult();
    	totalNecessidadesEstrategicas.add(dtoOECNPq);

    	// Necessidades alinhadas a objetivos estratégico da EGD 
    	String selectOEEGD =	"Select 'Objetivos Estratégicos EGD' as descricao, count(distinct ae.necessidade)  as valor "
    			+ "from alinhamentoestrategico ae inner join objetivoestrategico oe on ae.objetivoestrategico = oe.id "
    			+ "where oe.tipo = 'EGD'";
    	Query queryOEEGD = getEntityManager().createNativeQuery(selectOEEGD, "DTOChaveValorMapping");
    	DTOChaveValor dtoOEEGD = (DTOChaveValor) queryOEEGD.getSingleResult();
    	totalNecessidadesEstrategicas.add(dtoOEEGD);

    	// Necessidades classificadas como Outras Necessidades
    	String selectOutrasNecessidades =	"select 'Outras Necessidades' as descricao, count (nec.id)  as valor "
    			+ "from necessidade nec inner join questao q on nec.questao = q.id "
    			+ "inner join grupo g on q.grupo = g.id "
    			+ "where g.id in (10) ";
    	Query queryOutrasNecessidades = getEntityManager().createNativeQuery(selectOutrasNecessidades, "DTOChaveValorMapping");
    	DTOChaveValor dtoOutrasNecessidades = (DTOChaveValor) queryOutrasNecessidades.getSingleResult();
    	// TODO: Definir como tratar, pois este resultado agrupo os Objetivos CNPq, EGD e outras
//    	totalNecessidadesEstrategicas.add(dtoOutrasNecessidades);

    	// Necessidades classificadas como Outras Necessidades E QUE NÃO ESTEJA associada a um objetivo estrategico do CNPq nem mesmo da EGD
//    	String selectOutrasNaoOE =	"select 'Outras Necessidades, não alinhadas aos Objetivos Estratégicos do CNPq nem da EGD' as descricao, count (nec.id) as valor  "
    	String selectOutrasNaoOE =	"select 'Outro alinhamento' as descricao, count (nec.id) as valor  "
    			+ "from necessidade nec "
    			+ "inner join questao q on nec.questao = q.id "
    			+ "inner join grupo g on q.grupo = g.id "
    			+ "where g.id in (10) and nec.id not in( "
    			+ "		Select distinct ae.necessidade "
    			+ " 	from alinhamentoestrategico ae "
    			+ "		inner join objetivoestrategico oe on ae.objetivoestrategico = oe.id "
    			+ "		where oe.tipo = 'EGD' OR oe.tipo = 'CNPq' "
    			+ ")";
    	Query queryOutrasNaoOE = getEntityManager().createNativeQuery(selectOutrasNaoOE, "DTOChaveValorMapping");
    	DTOChaveValor dtoOutrasNaoOE = (DTOChaveValor) queryOutrasNaoOE.getSingleResult();
    	totalNecessidadesEstrategicas.add(dtoOutrasNaoOE);

    	
    	return totalNecessidadesEstrategicas;
    }
    
    

}
