/**
 * 
 */
package br.cnpq.pdtic.necessidades.services;

import java.util.ArrayList;
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
import br.cnpq.pdtic.necessidades.entities.AlinhamentoNecessidadeObjetivo;
import br.cnpq.pdtic.necessidades.entities.DominioCargo;
import br.cnpq.pdtic.necessidades.entities.DominioLotacao;
import br.cnpq.pdtic.necessidades.entities.Grupo;
import br.cnpq.pdtic.necessidades.entities.Necessidade;
import br.cnpq.pdtic.necessidades.entities.ObjetivoEstrategico;
import br.cnpq.pdtic.necessidades.entities.Questao;
import br.cnpq.pdtic.necessidades.entities.Usuario;

/**
 * 
 * @author Clelson Salles Rodrigues
 *
 */
public class UsuarioServico 
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

/*	<bean id="transactionManager" 
			class="org.springframework.orm.jpa.JpaTransactionManager"

	@Autowired
	private UserTransaction transactionManager;
	@Autowired
	private JpaTransactionManager transactionManager;
	transactionManager.setEntityManagerFactory(usuarioDAO.getEntityManager().getEntityManagerFactory());
*/
	
	@Transactional
    public void criarUsuario(Usuario usuario) throws Exception {

		usuarioDAO.criarUsuario(usuario);
		
	}
    
    public boolean verificaEmailCadastrado(String email) throws Exception {

    	Usuario usuario = usuarioDAO.findByEmail(email);
    	return usuario != null && usuario.getIdUsuario() != null;
		
	}

    @Transactional
    public void atualizarUsuario(Usuario usuario) throws Exception {

		usuarioDAO.atualizarUsuario(usuario);
		
	}

	/**
	 * Atualiza os dados do usuário informado
	 * 
	 * @param usuario
	 */
	public void recarregarUsuario(Usuario usuario) {
		usuarioDAO.refresh(usuario);
		
	}

	@Transactional
    public void incluirNecessidade(Necessidade necessidade) throws Exception {
		Questao questao = questaoDAO.find(necessidade.getQuestao().getId());
		Usuario usuario = usuarioDAO.find(necessidade.getUsuario().getIdUsuario());
		
		necessidade.setQuestao(questao);
		necessidade.setUsuario(usuario);
		
		necessidadeDAO.incluirNecessidade(necessidade);
//		usuarioDAO.salvarUsuario(usuario);
		
	}

	@Transactional
    public void editarNecessidade(Necessidade necessidade) throws Exception {
		
		necessidadeDAO.edit(necessidade);
	}

	@Transactional
    public void excluirNecessidade(Necessidade necessidade) throws Exception {
		
		necessidadeDAO.remove(necessidade);
	}

	@Transactional
    public void informarLeuInstrucoes(Usuario usuario) throws Exception {
		usuarioDAO.informarLeuInstrucoes(usuario);
	}

	public List<DominioLotacao> recuperaListaLotacao() throws Exception {
		return lotacaoDAO.recuperaListaLotacao();
	}
	
	public List<DominioCargo> recuperaListaCargo() throws Exception {
		return cargoDAO.recuperaListaCargo();
	}

	public Usuario login(Usuario usuario) throws Exception {
		Usuario login = usuarioDAO.login(usuario.getEmail(), usuario.getSenha());
		
		return login;
	}
	/*	
	*/


	
	public List<DTOProjeto> recuperaProjetosTransversais() {
		// Carregar os projetos transversais do serviço
		List<DTOProjeto> dtos = new ArrayList<>();
		
		List<Questao> questoes = questaoDAO.recuperaListaProjetosTransversais();
		for (Questao questao : questoes) {
			dtos.add(DTOProjeto.converteEntity(questao));
		}
		return dtos;
	}

	
	
	public List<DTOProjeto> recuperaProjetosEspecificos() {
		// Carregar os projetos especificos do serviço
		List<DTOProjeto> dtos = new ArrayList<>();
		
		List<Questao> questoes = questaoDAO.recuperaListaProjetosEspecificos();
		for (Questao questao : questoes) {
			dtos.add(DTOProjeto.converteEntity(questao));
		}
		return dtos;
	}

	public List<DTOProjeto> recuperaProjetosEspecificosDGTI_E1() {
		// Carregar os projetos especificos do serviço
		List<DTOProjeto> dtos = new ArrayList<>();
		
		List<Questao> questoes = questaoDAO.recuperaListaProjetosEspecificosDGTI_E1();
		for (Questao questao : questoes) {
			dtos.add(DTOProjeto.converteEntity(questao));
		}
		return dtos;
	}

	public List<DTOProjeto> recuperaProjetosEspecificosDGTI_Outros() {
		// Carregar os projetos especificos do serviço
		List<DTOProjeto> dtos = new ArrayList<>();
		
		List<Questao> questoes = questaoDAO.recuperaListaProjetosEspecificosDGTI_Outros();
		for (Questao questao : questoes) {
			dtos.add(DTOProjeto.converteEntity(questao));
		}
		return dtos;
	}

	public List<DTONecessidade> recuperaListaNecessidades(DTOProjeto projeto, Usuario usuario) {
		// TODO Auto-generated method stub
		List<Necessidade> necessidades =  necessidadeDAO.recuperaListaNecessidades(projeto, usuario);
		List<DTONecessidade> dtos =  new ArrayList<DTONecessidade>();
		for (Necessidade necessidade : necessidades) {
			dtos.add(DTONecessidade.converteEntity(necessidade));

		}
		
		return dtos;
	}
	
	public List<Grupo> recuperaListaGruposProjetosEspecificos_semDGTI(){
		List<Grupo> grupos = grupoDAO.recuperaListaGruposProjetosEspecificos_semDGTI();
		return grupos;  
	}
	
	public List<Questao> recuperaListaQuestoes(Grupo grupo){
		List<Questao>  questoesGrupo = questaoDAO.recuperaQuestoes(grupo);
		return questoesGrupo;
	}

	public Necessidade recuperaNecessidade(Integer id) {
		// TODO Auto-generated method stub
		return necessidadeDAO.find(id);
	}

	public List<ObjetivoEstrategico> recuperaListaObjetivosEGD()  throws Exception {
		// TODO Auto-generated method stub
		return objetivoEstrategicoDAO.recuperaListaObjetivosEGD();
	}

	public List<ObjetivoEstrategico> recuperaListaObjetivosCNPq()  throws Exception {
		// TODO Auto-generated method stub
		return objetivoEstrategicoDAO.recuperaListaObjetivosCNPq();
	}

	public DTOProjeto recuperaProjetoOutrasNecessidade() {
		// TODO Auto-generated method stub
		Questao questaoOutrasNecessidade = questaoDAO.recuperaQuestaoOutrasNecessidades();
		
		return DTOProjeto.converteEntity(questaoOutrasNecessidade);
	}

	public Questao recuperaQuestaoOutrasNecessidade() {
		// TODO Auto-generated method stub
		Questao questaoOutrasNecessidade = questaoDAO.recuperaQuestaoOutrasNecessidades();
		
		return questaoOutrasNecessidade;
	}

	public Questao recuperaQuestao(Integer idQuestao) {
		// TODO Auto-generated method stub
		Questao questao = questaoDAO.find(idQuestao);
		
		return questao;
	}

	@Transactional
	public void incluirNecessidade(Necessidade necessidade, Integer[] idsObjetivosCNPq,
			Integer[] idsObjetivosEGD)   throws Exception {
		incluirNecessidade(necessidade);
		
		// Cria os novos alinhamentos informados
		incluirObjetivosEstrategicosNecessidades(necessidade, idsObjetivosCNPq, idsObjetivosEGD);

		necessidadeDAO.refresh(necessidade);
		// TODO Auto-generated method stub
		
	}

	@Transactional
	public void editarNecessidade(Necessidade necessidade, Integer[] idsObjetivosCNPq,
			Integer[] idsObjetivosEGD)   throws Exception {
		editarNecessidade(necessidade);
		
		// Remove os alinhamentos que possam existir
		List<AlinhamentoNecessidadeObjetivo> alinhamentosExistentes = 
				alinhamentoNecessidadeObjetivoDAO.recuperaListaAlinhamentoNecessidade(necessidade.getId());
		for (AlinhamentoNecessidadeObjetivo alinhano : alinhamentosExistentes) {
			alinhamentoNecessidadeObjetivoDAO.remove(alinhano);
		}
		
		// Cria os novos alinhamentos informados
		incluirObjetivosEstrategicosNecessidades(necessidade, idsObjetivosCNPq, idsObjetivosEGD);

		//necessidadeDAO.refresh(necessidade);
		// TODO Auto-generated method stub
		
	}

	private void incluirObjetivosEstrategicosNecessidades(Necessidade necessidade, Integer[] idsObjetivosCNPq,
			Integer[] idsObjetivosEGD) throws Exception {
		for (Integer idObjetivoCNP : idsObjetivosCNPq) {
			ObjetivoEstrategico oe = objetivoEstrategicoDAO.find(idObjetivoCNP);
			AlinhamentoNecessidadeObjetivo alinhano = new AlinhamentoNecessidadeObjetivo();
			alinhano.setNecessidade(necessidade);
			alinhano.setObjetivoEstrategico(oe);
			
			alinhamentoNecessidadeObjetivoDAO.create(alinhano);
		}
		
		for (Integer idObjetivoEGD : idsObjetivosEGD) {
			ObjetivoEstrategico oe = objetivoEstrategicoDAO.find(idObjetivoEGD);
			AlinhamentoNecessidadeObjetivo alinhano = new AlinhamentoNecessidadeObjetivo();
			alinhano.setNecessidade(necessidade);
			alinhano.setObjetivoEstrategico(oe);
			
			alinhamentoNecessidadeObjetivoDAO.create(alinhano);
		}
	}
	
}
