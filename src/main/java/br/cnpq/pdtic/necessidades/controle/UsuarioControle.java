package br.cnpq.pdtic.necessidades.controle;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.primefaces.context.RequestContext;
import org.primefaces.event.TabChangeEvent;
import org.primefaces.event.TabCloseEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.cnpq.pdtic.necessidades.dto.DTOGrupo;
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
import br.cnpq.pdtic.necessidades.entities.enums.CenarioEnum;
import br.cnpq.pdtic.necessidades.entities.enums.DominioCargoEnum;
import br.cnpq.pdtic.necessidades.entities.enums.DominioLotacaoEnum;
import br.cnpq.pdtic.necessidades.services.UsuarioServico;
import br.cnpq.pdtic.necessidades.util.PasswordUtils;


@ManagedBean(name="usuarioControle")
@SessionScoped
@Component
public class UsuarioControle extends AbstractControle implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private UsuarioServico usuarioServico;

	private Usuario usuario = new Usuario();
	
	private List<DominioLotacao> listaLotacao = new ArrayList<DominioLotacao>();
	private Integer idLotacao;
	
	private List<DominioCargo> listaCargo = new ArrayList<DominioCargo>();
	private Integer idCargo;
	
	private boolean confirmaCadastro;
	private boolean informouLeitura;


	private List<DTOProjeto> projetosTransversais = new ArrayList<DTOProjeto>();
	private List<DTOProjeto> projetosEspecificos = new ArrayList<DTOProjeto>();
	private List<DTOProjeto> projetosEspecificosDGTI_E1 = new ArrayList<DTOProjeto>();
	private List<DTOProjeto> projetosEspecificosDGTI_Outros = new ArrayList<DTOProjeto>();
	
	private List<DTOGrupo> listaGruposProjetosEspecificos_semDGTI = new ArrayList<DTOGrupo>();

	private DTONecessidade necessidade;
	
	private String idProjetoSelecionado;
	
	private Questao projetoSelecionado;
	
	private Integer[] idsObjetivosCNPq = ArrayUtils.EMPTY_INTEGER_OBJECT_ARRAY;
	private Integer[] idsObjetivosEGD = ArrayUtils.EMPTY_INTEGER_OBJECT_ARRAY;
	
	private List<ObjetivoEstrategico> objetivosCNPq = new ArrayList<ObjetivoEstrategico>();
	private List<ObjetivoEstrategico> objetivosEGD = new ArrayList<ObjetivoEstrategico>();
	
	private List<DTONecessidade> listaOutrasNecessidades = new ArrayList<DTONecessidade>();
	
	private CenarioEnum cenario = CenarioEnum.INICIAL;
	

    public void tabProjetoTransversalAlterada(TabChangeEvent event) {
        FacesMessage msg = new FacesMessage("Tab Changed", "Active Tab: " + event.getTab().getTitle());
        FacesContext.getCurrentInstance().addMessage(null, msg);
        
        Object data = event.getData();
        
        setIdProjetoSelecionado(event.getTab().getTitletip());
    }
         
    public void tabProjetoTransversalFechada(TabCloseEvent event) {
        FacesMessage msg = new FacesMessage("Tab Changed", "Active Tab: " + event.getTab().getTitle());
        FacesContext.getCurrentInstance().addMessage(null, msg);
        
        Object data = event.getData();
        
        setIdProjetoSelecionado(event.getTab().getTitletip());
    }

    public void onTabClose(TabCloseEvent event) {
        FacesMessage msg = new FacesMessage("Tab Closed", "Closed tab: " + event.getTab().getTitle());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    
    public Integer getIdProjetoTransversalSelecionadoIntger(){
    	return idProjetoSelecionado == null ? null : Integer.parseInt(idProjetoSelecionado);
    }

	public void onTabTransversalChange(TabChangeEvent event) {
        FacesMessage msg = new FacesMessage("Tab Changed", "Active Tab: " + event.getTab().getTitle());
        FacesContext.getCurrentInstance().addMessage(null, msg);
        
        System.out.println(idProjetoSelecionado);
    }
         
    public void onTabTransversalClose(TabCloseEvent event) {
        FacesMessage msg = new FacesMessage("Tab Closed", "Closed tab: " + event.getTab().getTitle());
        FacesContext.getCurrentInstance().addMessage(null, msg);
        
        System.out.println(idProjetoSelecionado);
    }
	
	private static final String MENSAGEM_ATRASO_UNIDADE = 
			"Esta manifestação se encontra em atraso por parte %s %s. Caso queira notificar os envolvidos favor clicar no botão ao lado";
	
	
    public String voltar() {
    	return "index.html?faces-redirect=true";
    }
    
    public void salvarNecessidade(){
		try {
			//TODO Salvar os dados da necessidade
	        System.out.println(idProjetoSelecionado);
	        
	        if (StringUtils.isEmpty(necessidade.getTitulo()) || 
	        		StringUtils.isEmpty(necessidade.getDescricao()) ||
	        		StringUtils.isEmpty(necessidade.getJustificativa()) ){
				addMessageError("Informe Título, Descrição e Justificativa para a necessidade!");
				return;
	        }
	        
	        Necessidade necessidadeInformada = necessidade.converteDTO();
	        necessidadeInformada.setQuestao(new Questao(Integer.parseInt(idProjetoSelecionado)));
	        necessidadeInformada.setUsuario(usuario);
	        necessidadeInformada.setOrdem(1);
	        
	        usuarioServico.incluirNecessidade(necessidadeInformada);
			
	        //RequestContext.getCurrentInstance().closeDialog("dialogNecessidade");
	        RequestContext.getCurrentInstance().closeDialog(0);

	        atualizaListaProjetosTransversais();
	        atualizaListaProjetosEspecificos();

	        addMessageInfo("A necessidade foi registrada com sucesso");
	        
	        RequestContext.getCurrentInstance().update("idFormNecessidades");

//	        return "/pdtic/003_projetosTransversais.xhtml";
	        
		} catch (Exception e) {
			// TODO Auto-generated catch block
			addMessageError("Problemas no registro da necessidade!");
			e.printStackTrace();
		}
		
//		return null;
    }
    
    public void editarNecessidade(){
		try {
	        Necessidade necessidadeInformada = usuarioServico.recuperaNecessidade(necessidade.getId());

	        necessidadeInformada.setTitulo(necessidade.getTitulo());
	        necessidadeInformada.setDescricao(necessidade.getDescricao());
	        necessidadeInformada.setJustificativa(necessidade.getJustificativa());
 
	        usuarioServico.editarNecessidade(necessidadeInformada);
			
	        RequestContext.getCurrentInstance().closeDialog(0);
	        RequestContext.getCurrentInstance().closeDialog(1);
	        RequestContext.getCurrentInstance().closeDialog(null);

	        atualizaListaProjetosTransversais();
	        atualizaListaProjetosEspecificos();

	        addMessageInfo("A necessidade foi alterada com sucesso");
	        RequestContext.getCurrentInstance().update("idFormNecessidades");

//	        return "/pdtic/003_projetosTransversais.xhtml";
	        
		} catch (Exception e) {
			// TODO Auto-generated catch block
			addMessageError("Problemas no registro da necessidade!");
			e.printStackTrace();
		}
		
//		return null;
    }

    public void excluirNecessidade(){
		try {
	        Necessidade necessidadeInformada = usuarioServico.recuperaNecessidade(necessidade.getId());

	        usuarioServico.excluirNecessidade(necessidadeInformada);

	        RequestContext.getCurrentInstance().closeDialog(0);
	        RequestContext.getCurrentInstance().closeDialog(1);
	        RequestContext.getCurrentInstance().closeDialog(null);

	        atualizaListaProjetosTransversais();
	        atualizaListaProjetosEspecificos();

	        addMessageInfo("A necessidade foi excluída com sucesso");
	        RequestContext.getCurrentInstance().update("idFormNecessidades");

//	        return "/pdtic/003_projetosTransversais.xhtml";
	        
		} catch (Exception e) {
			// TODO Auto-generated catch block
			addMessageError("Problemas no registro da necessidade!");
			e.printStackTrace();
		}
		
//		return null;
    }

    public void iniciarIncluirNecessidade(){
		try {
			//TODO Salvar os dados da necessidade
			cenario = CenarioEnum.INCLUSAO;
	        System.out.println(idProjetoSelecionado);
	        
	        projetoSelecionado = usuarioServico.recuperaQuestao(Integer.parseInt(idProjetoSelecionado));
	        
	        necessidade = new DTONecessidade();
	        
	        Map<String,Object> options = new HashMap<String, Object>();
	        options.put("resizable", false);
	        //options.put("widgetVar", "dialogNecessidade");
	        RequestContext.getCurrentInstance().openDialog("viewNecessidade", options, null);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			addMessageError("Problemas no registro da necessidade!");
			e.printStackTrace();
		}
    	
    }

    public void iniciaEditarNecessidade(){
		try {
			cenario = CenarioEnum.EDICAO;
	        necessidade = DTONecessidade.converteEntity(usuarioServico.recuperaNecessidade(necessidade.getId()));
	        
	        Map<String,Object> options = new HashMap<String, Object>();
	        options.put("resizable", false);
	        //options.put("widgetVar", "dialogNecessidade");
	        RequestContext.getCurrentInstance().openDialog("viewNecessidade", options, null);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			addMessageError("Problemas no registro da necessidade!");
			e.printStackTrace();
		}
    }

    public void iniciaExcluirNecessidade(){
		try {
			cenario = CenarioEnum.EXCLUSAO;
	        
	        necessidade = DTONecessidade.converteEntity(usuarioServico.recuperaNecessidade(necessidade.getId()));
	        
	        Map<String,Object> options = new HashMap<String, Object>();
	        options.put("resizable", false);
	        //options.put("widgetVar", "dialogNecessidade");
	        RequestContext.getCurrentInstance().openDialog("viewNecessidade", options, null);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			addMessageError("Problemas no registro da necessidade!");
			e.printStackTrace();
		}
    	
    }


    public String iniciaEditarOutraNecessidade(){
		try {
			cenario = CenarioEnum.EDICAO;

			recuperaNecessidadeAlinhamentos();

			addMessageInfo("Edite os dados da necessidade selecionada!");
			return "/pdtic/005_novosProjetos.xhtml";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			addMessageError("Problemas no registro da necessidade!");
			e.printStackTrace();
		}
    	
		return null;
    }

    public String iniciaExcluirOutraNecessidade(){
		try {
			cenario = CenarioEnum.EXCLUSAO;

			recuperaNecessidadeAlinhamentos();
	        
			addMessageInfo("Visualize os dados da necessidade selecionada, para confirmar a exclusão!");
			return "/pdtic/005_novosProjetos.xhtml";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			addMessageError("Problemas no registro da necessidade!");
			e.printStackTrace();
		}
    	
		return null;
    }

	private void recuperaNecessidadeAlinhamentos() {
		Necessidade entidade = usuarioServico.recuperaNecessidade(necessidade.getId());
		necessidade = DTONecessidade.converteEntity(entidade);
		
		List<AlinhamentoNecessidadeObjetivo> alinhanos = entidade.getAlinhamentos();
		List<Integer> listaObjetivosCNPq = new ArrayList<Integer>();
		List<Integer> listaObjetivosEGD = new ArrayList<Integer>();
		for (AlinhamentoNecessidadeObjetivo alinhano : alinhanos) {
			if (alinhano.getObjetivoEstrategico().getTipo().equals("CNPq"))
				listaObjetivosCNPq.add(alinhano.getObjetivoEstrategico().getId());
			if (alinhano.getObjetivoEstrategico().getTipo().equals("EGD"))
				listaObjetivosEGD.add(alinhano.getObjetivoEstrategico().getId());
		}
		
		idsObjetivosCNPq = listaObjetivosCNPq.isEmpty() ? ArrayUtils.EMPTY_INTEGER_OBJECT_ARRAY : listaObjetivosCNPq.toArray(new Integer[listaObjetivosCNPq.size()]);
		idsObjetivosEGD = listaObjetivosEGD.isEmpty() ? ArrayUtils.EMPTY_INTEGER_OBJECT_ARRAY : listaObjetivosEGD.toArray(new Integer[listaObjetivosEGD.size()]);
	}

    
    public void sairViewNecessidade(){
        RequestContext.getCurrentInstance().closeDialog(0);
    	
    }
    
/*    
    @PostConstruct
    public void init() {
    	try {
    		usuario = new Usuario();
    		listaLotacao = usuarioServico.recuperaListaLotacao();
    		listaCargo = usuarioServico.recuperaListaCargo();
			
		} catch (Exception e) {
			addMessageError("Problemas na recuperação dos dados!");
			e.printStackTrace();
		}
    }
*/    
    
	public String iniciarCadastrarUsuario() {
    	try {
    		usuario = new Usuario();
    		listaLotacao = usuarioServico.recuperaListaLotacao();
    		listaCargo = usuarioServico.recuperaListaCargo();
			
		} catch (Exception e) {
			addMessageError("Problemas na recuperação dos dados!");
			e.printStackTrace();
		}

    	return "/pdtic/001_cadastro.xhtml";
    }
    
    
    public List<DTOProjeto> listaProjetosTransversais(){
    	if (projetosTransversais == null || projetosTransversais.isEmpty()){
    		atualizaListaProjetosTransversais();
    	}
    	
    	return projetosTransversais;
    }

	private void atualizaListaProjetosTransversais() {
		projetosTransversais = usuarioServico.recuperaProjetosTransversais();
		for (DTOProjeto projTrans : projetosTransversais) {
			List<DTONecessidade> necessidades = usuarioServico.recuperaListaNecessidades(projTrans, usuario);
			projTrans.setNecessidades(necessidades);
		}
	}


	
    public List<DTOProjeto> listaProjEspE1DGTI(){
    	if (projetosEspecificosDGTI_E1 == null || projetosEspecificosDGTI_E1.isEmpty()){
    		atualizaListaProjEspE1DGTI();
    	}
    	
    	return projetosEspecificosDGTI_E1;
    }

	private void atualizaListaProjEspE1DGTI() {
		projetosEspecificosDGTI_E1 = usuarioServico.recuperaProjetosEspecificosDGTI_E1();
		for (DTOProjeto projEspE1 : projetosEspecificosDGTI_E1) {
			List<DTONecessidade> necessidades = usuarioServico.recuperaListaNecessidades(projEspE1, usuario);
			projEspE1.setNecessidades(necessidades);
		}
	}


    public List<DTOProjeto> listaProjEspDGTIOutros(){
    	if (projetosEspecificosDGTI_Outros == null || projetosEspecificosDGTI_Outros.isEmpty()){
    		atualizaListaProjEspDGTIOutros();
    	}
    	
    	return projetosEspecificosDGTI_Outros;
    }

	private void atualizaListaProjEspDGTIOutros() {
		projetosEspecificosDGTI_Outros = usuarioServico.recuperaProjetosEspecificosDGTI_Outros();
		for (DTOProjeto projEspOutros : projetosEspecificosDGTI_Outros) {
			List<DTONecessidade> necessidades = usuarioServico.recuperaListaNecessidades(projEspOutros, usuario);
			projEspOutros.setNecessidades(necessidades);
		}
	}

	
	/**
	 * Recupera a lisa de outras necessidades conforme o usuário logado
	 */
	private void atualizaListaOutrasNecessidade() {
		DTOProjeto questaoOutrasNecesssidade = usuarioServico.recuperaProjetoOutrasNecessidade();
		listaOutrasNecessidades = usuarioServico.recuperaListaNecessidades(questaoOutrasNecesssidade, usuario);
		 
	}

	public List<DTOProjeto> listaProjetosEspecificos(){
    	if (projetosEspecificos== null || projetosEspecificos.isEmpty()){
    		atualizaListaProjetosEspecificos();
    	}
    	
    	return projetosEspecificos;
    }

	private void atualizaListaProjetosEspecificos() {
		projetosEspecificos = usuarioServico.recuperaProjetosTransversais();
		for (DTOProjeto projEspec : projetosEspecificos) {
			List<DTONecessidade> necessidades = usuarioServico.recuperaListaNecessidades(projEspec, usuario);
			projEspec.setNecessidades(necessidades);
		}
	}

    public String cadastrarUsuarioAction() {
    	
    	if (validaCamposCadastro()){
    		
    		try {
    			//Gera hash MD5 da senha informada
    			usuario.setSenha(PasswordUtils.getMD5(usuario.getSenha()));
    			usuarioServico.criarUsuario(usuario);
				addMessageInfo("Usuário cadastrado com sucesso!");
				
				return "/pdtic/002_instrucoes.xhtml";
			} catch (Exception e) {
				// TODO Auto-generated catch block
				addMessageError("Problemas no registro do usuário!");
				e.printStackTrace();
			}
    	}
    	return null;
    }


    public String loginAction() {
		//Gera hash MD5 da senha informada
		usuario.setSenha(PasswordUtils.getMD5(usuario.getSenha()));
		try {
	    	Usuario login = usuarioServico.login(usuario);
	    	if (login != null){
    		
				addMessageInfo("Bem-vindo novamente!");
				usuario = login;
				return "/pdtic/002_instrucoes.xhtml";
	    	}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			addMessageError("Problemas no login do usuário!");
			e.printStackTrace();
		}

    	addMessageWarn("E-mail ou senha inválidos");
		
    	return null;
    }

    
    
    public String informarLeuInstrucoes() {
		try {
			usuarioServico.informarLeuInstrucoes(usuario);
			return iniciarProjetosTransversais();
		} catch (Exception e) {
			addMessageError("Problemas na recuperação dos dados!");
			e.printStackTrace();
		}
		return null;
	}


    public String iniciarProjetosTransversais() {
    	atualizaListaProjetosTransversais();
    	
    	DTOProjeto projetoTransversalInicial = listaProjetosTransversais().get(0);
    		
    	setIdProjetoSelecionado("" + projetoTransversalInicial.getId());
    	
    	necessidade = new DTONecessidade();
    	
		return "/pdtic/003_projetosTransversais.xhtml";

    }

    public String iniciarProjetosEspecificos() {
    	atualizaListaProjetosEspecificos();
    	
    	DTOProjeto projetoEspecificoInicial = listaProjetosEspecificos().get(0);
    		
    	setIdProjetoSelecionado("" + projetoEspecificoInicial.getId());
    	
    	necessidade = new DTONecessidade();
    	
		return "/pdtic/004_projetosEspecificos.xhtml";

    }

    private boolean validaCamposCadastro() {
    	// Valida os valores da Lotação selecionada
    	boolean lotacaoValida = false;
    	DominioLotacaoEnum[] lotacoes = DominioLotacaoEnum.values();
    	if (idLotacao != null){
    		for (DominioLotacaoEnum lotacaoEnum : lotacoes) {
    			if (lotacaoEnum.getId().equals(idLotacao)){
    				usuario.setLotacao(lotacaoEnum.getEntidade());
    				lotacaoValida = true;
    				break;
    			}
    		}
    	}
    	if (!lotacaoValida){
    		addMessageError("Informe a lotaçao");
    	}
    	
    	// Valida os valores do Cargo selecionado
    	boolean cargoValido = false;
    	DominioCargoEnum[] cargos = DominioCargoEnum.values();
    	if (idCargo != null){
    		for (DominioCargoEnum cargoEnum : cargos) {
    			if (cargoEnum.getId().equals(idCargo)){
    				usuario.setCargo(cargoEnum.getEntidade());
    				cargoValido = true;
    				break;
    			}
    		}
    	}
    	if (!cargoValido){
    		addMessageError("Informe o seu cargo");
    	}
    	
    	return cargoValido && lotacaoValida;

	}

    
    public String iniciarOutrasNecessidades() {

    	try {
			cenario = CenarioEnum.INCLUSAO;

    		if (objetivosEGD == null || objetivosCNPq == null ||
    				objetivosEGD.isEmpty() || objetivosCNPq.isEmpty()){
    			objetivosEGD = usuarioServico.recuperaListaObjetivosEGD();
    			objetivosCNPq = usuarioServico.recuperaListaObjetivosCNPq();
    		}
    		idsObjetivosCNPq = ArrayUtils.EMPTY_INTEGER_OBJECT_ARRAY;
    		idsObjetivosEGD = ArrayUtils.EMPTY_INTEGER_OBJECT_ARRAY;
    		
    		//Preparar o campo necessidade
    		necessidade = new DTONecessidade();
    		necessidade.setQuestao(usuarioServico.recuperaQuestaoOutrasNecessidade());
    		// Recupera as outras necessidades informadas pelo usuario
    		atualizaListaOutrasNecessidade();
    		
    		return "/pdtic/005_novosProjetos.xhtml";
			
		} catch (Exception e) {
			// TODO: handle exception
			addMessageError("Problemas na recuperação dos objetivos estratégicos");
			e.printStackTrace();
		}
    	return null;
    }
    
    
    public String incluirOutraNecessidade(){
		try {
			//TODO Salvar os dados da necessidade
	        if (StringUtils.isEmpty(necessidade.getTitulo()) || 
	        		StringUtils.isEmpty(necessidade.getDescricao()) ||
	        		StringUtils.isEmpty(necessidade.getJustificativa()) ){
				addMessageError("Informe Título, Descrição e Justificativa para a necessidade!");
				return null;
	        }

			Necessidade necessidadeInformada = necessidade.converteDTO();
	        necessidadeInformada.setQuestao(usuarioServico.recuperaQuestaoOutrasNecessidade());
	        necessidadeInformada.setUsuario(usuario);
	        necessidadeInformada.setOrdem(1);
	        
	        usuarioServico.incluirNecessidade(necessidadeInformada, idsObjetivosCNPq, idsObjetivosEGD);

	        addMessageInfo("A necessidade foi registrada com sucesso");
	        
	        return iniciarOutrasNecessidades();
	        
		} catch (Exception e) {
			// TODO Auto-generated catch block
			addMessageError("Problemas no registro da necessidade!");
			e.printStackTrace();
		}
		
		return null;
    }
    
    public String editarOutraNecessidade(){
		try {
	        Necessidade necessidadeInformada = usuarioServico.recuperaNecessidade(necessidade.getId());

	        necessidadeInformada.setTitulo(necessidade.getTitulo());
	        necessidadeInformada.setDescricao(necessidade.getDescricao());
	        necessidadeInformada.setJustificativa(necessidade.getJustificativa());
 
	        necessidadeInformada.setSistema(necessidade.getSistema());
	        necessidadeInformada.setPlataforma(necessidade.getPlataforma());
	        necessidadeInformada.setAssunto(necessidade.getAssunto());
	        
	        usuarioServico.editarNecessidade(necessidadeInformada, idsObjetivosCNPq, idsObjetivosEGD);
			
	        addMessageInfo("A necessidade foi alterada com sucesso");

	        return iniciarOutrasNecessidades();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			addMessageError("Problemas no registro da necessidade!");
			e.printStackTrace();
		}
		
		return null;
    }

    public String excluirOutraNecessidade(){
		try {
	        Necessidade necessidadeInformada = usuarioServico.recuperaNecessidade(necessidade.getId());

	        usuarioServico.excluirNecessidade(necessidadeInformada);

	        addMessageInfo("A necessidade foi excluída com sucesso");
	        return iniciarOutrasNecessidades();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			addMessageError("Problemas no registro da necessidade!");
			e.printStackTrace();
		}
		
		return null;
    }
    
    

    
    public String iniciarFinalizacao() {
    	
    	//Atualizar os dados do usuário logado
    	usuarioServico.recarregarUsuario(usuario);
    	
		return "/pdtic/006_finalizacao.xhtml";

    }
    
    
    public void salvarComentarios(){
    	try {
    		usuarioServico.atualizarUsuario(usuario);
			addMessageInfo("Seus comentário foram registrados.");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			addMessageError("Problemas no registro de comentário!");
			e.printStackTrace();
		}

    	
    }


    public String finalizarLevantamento(){
    	try {
    		usuario.setFinalizado(true);
    		usuarioServico.atualizarUsuario(usuario);

	        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
	        addMessageInfo("Seus comentário foram registrados. Você finalizou o levantamento!");
	        // Configura os dados iniciais para o levantamento
	        iniciarCadastrarUsuario();
	        
			return "/pdtic/001_inicio.xhtml";

    	} catch (Exception e) {
			// TODO Auto-generated catch block
			addMessageError("Problemas no registro de comentário e finalização!");
			e.printStackTrace();
		}

    	return null;
    }

    /**
	 * @return the usuario
	 */
	public Usuario getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return the listaLotacao
	 */
	public List<DominioLotacao> getListaLotacao() {
		return listaLotacao;
	}

	/**
	 * @param listaLotacao the listaLotacao to set
	 */
	public void setListaLotacao(List<DominioLotacao> listaLotacao) {
		this.listaLotacao = listaLotacao;
	}

	/**
	 * @return the idLotacao
	 */
	public Integer getIdLotacao() {
		return idLotacao;
	}

	/**
	 * @param idLotacao the idLotacao to set
	 */
	public void setIdLotacao(Integer idLotacao) {
		this.idLotacao = idLotacao;
	}

	/**
	 * @return the listaCargo
	 */
	public List<DominioCargo> getListaCargo() {
		return listaCargo;
	}

	/**
	 * @param listaCargo the listaCargo to set
	 */
	public void setListaCargo(List<DominioCargo> listaCargo) {
		this.listaCargo = listaCargo;
	}

	/**
	 * @return the idCargo
	 */
	public Integer getIdCargo() {
		return idCargo;
	}

	/**
	 * @param idCargo the idCargo to set
	 */
	public void setIdCargo(Integer idCargo) {
		this.idCargo = idCargo;
	}

	/**
	 * @return the confirmaCadastro
	 */
	public boolean isConfirmaCadastro() {
		return confirmaCadastro;
	}

	/**
	 * @param confirmaCadastro the confirmaCadastro to set
	 */
	public void setConfirmaCadastro(boolean confirmaCadastro) {
		this.confirmaCadastro = confirmaCadastro;
	}

	/**
	 * @return the informouLeitura
	 */
	public boolean isInformouLeitura() {
		informouLeitura = usuario.getLeuInstrucoes() == null ? false : true;
		return informouLeitura;
	}

	/**
	 * @param informouLeitura the informouLeitura to set
	 */
	public void setInformouLeitura(boolean informouLeitura) {
		this.informouLeitura = informouLeitura;
	}

	/**
	 * @return the necessidade
	 */
	public DTONecessidade getNecessidade() {
		return necessidade;
	}

	/**
	 * @param necessidade the necessidade to set
	 */
	public void setNecessidade(DTONecessidade necessidade) {
		this.necessidade = necessidade;
	}

	public String getIdProjetoSelecionado() {
		return idProjetoSelecionado;
	}

	public void setIdProjetoSelecionado(String idProjetoSelecionado) {
		this.idProjetoSelecionado = idProjetoSelecionado;
	}

	public Questao getProjetoSelecionado() {
		return projetoSelecionado;
	}

	public void setProjetoSelecionado(Questao projetoTransversalSelecionado) {
		this.projetoSelecionado = projetoTransversalSelecionado;
	}

	/**
	 * @return the cenario
	 */
	public CenarioEnum getCenario() {
		return cenario;
	}

	/**
	 * @param cenario the cenario to set
	 */
	public void setCenario(CenarioEnum cenario) {
		this.cenario = cenario;
	}

	/**
	 * @return the idsObjetivosCNPq
	 */
	public Integer[] getIdsObjetivosCNPq() {
		return idsObjetivosCNPq;
	}

	/**
	 * @param idsObjetivosCNPq the idsObjetivosCNPq to set
	 */
	public void setIdsObjetivosCNPq(Integer[] idsObjetivosCNPq) {
		this.idsObjetivosCNPq = idsObjetivosCNPq;
	}

	/**
	 * @return the idsObjetivosEGD
	 */
	public Integer[] getIdsObjetivosEGD() {
		return idsObjetivosEGD;
	}

	/**
	 * @param idsObjetivosEGD the idsObjetivosEGD to set
	 */
	public void setIdsObjetivosEGD(Integer[] idsObjetivosEGD) {
		this.idsObjetivosEGD = idsObjetivosEGD;
	}

	/**
	 * @return the objetivosCNPq
	 */
	public List<ObjetivoEstrategico> getObjetivosCNPq() {
		return objetivosCNPq;
	}

	/**
	 * @param objetivosCNPq the objetivosCNPq to set
	 */
	public void setObjetivosCNPq(List<ObjetivoEstrategico> objetivosCNPq) {
		this.objetivosCNPq = objetivosCNPq;
	}

	/**
	 * @return the objetivosEGD
	 */
	public List<ObjetivoEstrategico> getObjetivosEGD() {
		return objetivosEGD;
	}

	/**
	 * @param objetivosEGD the objetivosEGD to set
	 */
	public void setObjetivosEGD(List<ObjetivoEstrategico> objetivosEGD) {
		this.objetivosEGD = objetivosEGD;
	}

	/**
	 * @return the listaOutrasNecessidades
	 */
	public List<DTONecessidade> getListaOutrasNecessidades() {
		if (listaOutrasNecessidades == null || listaOutrasNecessidades.isEmpty()){
			atualizaListaOutrasNecessidade();
		}

		return listaOutrasNecessidades;
	}

	/**
	 * @param listaOutrasNecessidades the listaOutrasNecessidades to set
	 */
	public void setListaOutrasNecessidades(List<DTONecessidade> listaOutrasNecessidades) {
		this.listaOutrasNecessidades = listaOutrasNecessidades;
	}
	
	
	/**
	 * Monta uma lista com os ids dos accordions para os grupo de projetos específicos
	 * 
	 * @return - uma lista com os ids dos accordions para os grupo de projetos específicos, iniciada e separada com vírgulas
	 */
	public String listaPaineisAccordionEspecificos(){
		String retorno = "";
		List<DTOGrupo> gruposProjetoEspecifico = getListaGruposProjetosEspecificos_semDGTI();
		for (DTOGrupo grupoProjetoEspecifico : gruposProjetoEspecifico) {
			retorno += ", #accordionGrupo_" + grupoProjetoEspecifico.getId();
		}
		
		
		return retorno;
	}
	
	

	/**
	 * @return the listaGruposProjetosEspecificos_semDGTI
	 */
	public List<DTOGrupo> getListaGruposProjetosEspecificos_semDGTI() {
		if (listaGruposProjetosEspecificos_semDGTI == null || listaGruposProjetosEspecificos_semDGTI.isEmpty()){
			
			List<Grupo> grupos = usuarioServico.recuperaListaGruposProjetosEspecificos_semDGTI();
			List<DTOGrupo> retorno = new ArrayList<DTOGrupo>();
			for (Grupo grupo : grupos) {
				List<Questao> questoesGrupo = usuarioServico.recuperaListaQuestoes(grupo);
				grupo.setQuestoes(questoesGrupo);
				
				// Converte em dtogrupo, contendo a lista de questões
				DTOGrupo grupoDTO = DTOGrupo.converteEntity(grupo);
				retorno.add(grupoDTO);
			}
			
			listaGruposProjetosEspecificos_semDGTI = retorno;
		}
		// Mantém a lista de necessidades atualizada (considerando a questão e o usuário logado)
		for (DTOGrupo grupoDTO : listaGruposProjetosEspecificos_semDGTI ) {
			List<DTOProjeto> projetosGrupo = grupoDTO.getQuestoes();
			for (DTOProjeto dtoProjeto : projetosGrupo) {
				List<DTONecessidade> necessidadesQuestao = usuarioServico.recuperaListaNecessidades(dtoProjeto, usuario);
				dtoProjeto.setNecessidades(necessidadesQuestao);
			}
		}
			
		return listaGruposProjetosEspecificos_semDGTI;
	}

	/**
	 * @param listaGruposProjetosEspecificos_semDGTI the listaGruposProjetosEspecificos_semDGTI to set
	 */
	public void setListaGruposProjetosEspecificos_semDGTI(List<DTOGrupo> listaGruposProjetosEspecificos_semDGTI) {
		this.listaGruposProjetosEspecificos_semDGTI = listaGruposProjetosEspecificos_semDGTI;
	}
	
	
	
	
	/**
	 * Gera uma nova senha para a manifestação e notifica o manifestante por
	 * e-mail
	public void generateNewPassword() {
		try {
			// Altera a senha no banco
			TbManifestacao newManifestation = dao.find(manifestacao.getIdManifestacao());
			String newPassword = PasswordUtils.generatePassword();
			newManifestation.setDsSenha(newPassword);
			manifestacao.setDsSenha(newPassword);
			dao.edit(newManifestation);
			
			// Notifica o manifestante por email
			List<String> emails = ManifestacaoUtils.converterEmListaDeEmails(manifestacao, true);
			for (String email : emails) {
				enviarEmail(manifestacao.getNmPessoa(), email, EmailAutomatizadoEnum.NOVA_SENHA_MANIFESTACAO, true);
			}
			MensagemFaceUtil.info("Nova senha gerada com sucesso", null);
		} catch (InfrastructureException e) {
			MensagemFaceUtil.erro("Não foi possível alterar a senha da manifestação", null);
			e.printStackTrace();
		} catch (EmailException e) {
			MensagemFaceUtil.erro("Não foi possível notificar o manifestante por email sobre a alteração da senha", null);
			e.printStackTrace();
		}
	}
	 */
	
}