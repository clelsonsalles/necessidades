/**
 * 
 */
package br.cnpq.pdtic.necessidades.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.cnpq.pdtic.necessidades.dao.NecessidadeDAO;
import br.cnpq.pdtic.necessidades.dao.UsuarioDAO;
import br.cnpq.pdtic.necessidades.dto.DTONecessidade;
import br.cnpq.pdtic.necessidades.dto.DTORelatorio;
import br.cnpq.pdtic.necessidades.entities.Necessidade;

/**
 * @author Clelson Salles Rodrigues
 *
 */
public class RelatorioServico 
{
	

	@Autowired
	private UsuarioDAO usuarioDAO;
	
	@Autowired
	private NecessidadeDAO necessidadeDAO;
	

	public DTORelatorio carregaResultados(){
		DTORelatorio relat = new DTORelatorio();
		
		relat.setTotalNecessidades(necessidadeDAO.count());
		
		relat.setTotalUsuarios(usuarioDAO.count());

		relat.setTotalNecessidadesLotacao(necessidadeDAO.recuperaTotalNecessidadesLotacao());
		relat.setTotalNecessidadesCargo(necessidadeDAO.recuperaTotalNecessidadesCargo());
		relat.setTotalNecessidadesUnidade(necessidadeDAO.recuperaTotalNecessidadesUnidade());

		relat.setTotalUsuariosLotacao(usuarioDAO.recuperaTotalUsuariosLotacao());
		relat.setTotalUsuariosCargo(usuarioDAO.recuperaTotalUsuariosCargo());
		relat.setTotalUsuariosUnidade(usuarioDAO.recuperaTotalUsuariosUnidade());
		
		relat.setTotalUsuariosFinalizados(usuarioDAO.recuperaTotalUsuariosFinalizados());
		
		relat.setAlinhamentosEstrategicos(necessidadeDAO.recuperaAlinhamentosEstrategicos());
		
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
