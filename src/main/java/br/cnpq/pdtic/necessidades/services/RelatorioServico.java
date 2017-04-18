/**
 * 
 */
package br.cnpq.pdtic.necessidades.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import br.cnpq.pdtic.necessidades.dao.AlinhamentoNecessidadeObjetivoDAO;
import br.cnpq.pdtic.necessidades.dao.CargoDAO;
import br.cnpq.pdtic.necessidades.dao.GrupoDAO;
import br.cnpq.pdtic.necessidades.dao.LotacaoDAO;
import br.cnpq.pdtic.necessidades.dao.NecessidadeDAO;
import br.cnpq.pdtic.necessidades.dao.ObjetivoEstrategicoDAO;
import br.cnpq.pdtic.necessidades.dao.QuestaoDAO;
import br.cnpq.pdtic.necessidades.dao.UsuarioDAO;
import br.cnpq.pdtic.necessidades.dto.DTONecessidade;
import br.cnpq.pdtic.necessidades.dto.DTOProjeto;
import br.cnpq.pdtic.necessidades.dto.DTORelatorio;
import br.cnpq.pdtic.necessidades.entities.AlinhamentoNecessidadeObjetivo;
import br.cnpq.pdtic.necessidades.entities.DominioCargo;
import br.cnpq.pdtic.necessidades.entities.DominioLotacao;
import br.cnpq.pdtic.necessidades.entities.Grupo;
import br.cnpq.pdtic.necessidades.entities.Necessidade;
import br.cnpq.pdtic.necessidades.entities.ObjetivoEstrategico;
import br.cnpq.pdtic.necessidades.entities.Questao;
import br.cnpq.pdtic.necessidades.entities.Usuario;

/**
 * @author Siva
 *
 */
public class RelatorioServico 
{
	

	@Autowired
	private UsuarioDAO usuarioDAO;
	
	@Autowired
	private LotacaoDAO lotacaoDAO;

	@Autowired
	private CargoDAO cargoDAO;
	
	@Autowired
	private QuestaoDAO questaoDAO;
	
	@Autowired
	private GrupoDAO grupoDAO;

	@Autowired
	private NecessidadeDAO necessidadeDAO;
	
	@Autowired
	private ObjetivoEstrategicoDAO objetivoEstrategicoDAO;

	@Autowired
	private AlinhamentoNecessidadeObjetivoDAO alinhamentoNecessidadeObjetivoDAO;


	public DTORelatorio carregaResultados(){
		DTORelatorio relat = new DTORelatorio();
		
		relat.setTotalNecessidades(necessidadeDAO.count());
		
		relat.setTotalUsuarios(usuarioDAO.count());

		relat.setTotalNecessidadesLotacao(necessidadeDAO.recuperaTotalNecessidadesLotacao());
		
		
		return relat;
	}
	
	
	public List<DTONecessidade> recuperaListaNecessidades() {
		// TODO Auto-generated method stub
		List<DTONecessidade> dtos =  new ArrayList<DTONecessidade>();
		try {
			List<Necessidade> necessidades =  necessidadeDAO.getList("listaTodasOrdemTitulo", new HashMap<String, String>());
			for (Necessidade necessidade : necessidades) {
				dtos.add(DTONecessidade.converteEntity(necessidade));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return dtos;
	}


	
	
}
