package br.com.company.fks.servico;

import br.com.company.fks.controller.builder.Resposta;
import br.com.company.fks.repositorio.custom.PedidoCustomRepositorio;
import br.com.company.fks.excecao.IntegracaoException;
import br.com.company.fks.modelo.Andamento;
import br.com.company.fks.modelo.Anexo;
import br.com.company.fks.modelo.HistoricoTratamento;
import br.com.company.fks.modelo.PalavraChave;
import br.com.company.fks.modelo.Pedido;
import br.com.company.fks.modelo.Recurso;
import br.com.company.fks.modelo.Solicitante;
import br.com.company.fks.modelo.StatusSolicitacao;
import br.com.company.fks.modelo.StatusSolicitacaoRecurso;
import br.com.company.fks.modelo.StatusTramitacao;
import br.com.company.fks.modelo.Subtema;
import br.com.company.fks.modelo.Subunidade;
import br.com.company.fks.modelo.Tema;
import br.com.company.fks.modelo.TipoTratamento;
import br.com.company.fks.modelo.Unidade;
import br.com.company.fks.modelo.UsuarioAcessos;
import br.com.company.fks.modelo.dto.AlteracaoPedidoRecursoDTO;
import br.com.company.fks.modelo.dto.AnexoPedidoDetalhadoDTO;
import br.com.company.fks.modelo.dto.ConsultaHistoricoPedidoDTO;
import br.com.company.fks.modelo.dto.ConsultaPedidoDTO;
import br.com.company.fks.modelo.dto.ConsultaPedidoDulplicadoDTO;
import br.com.company.fks.modelo.dto.DevolvePedidoDTO;
import br.com.company.fks.modelo.dto.EouvDTO;
import br.com.company.fks.modelo.dto.FiltroPedidoDTO;
import br.com.company.fks.modelo.dto.PedidoDetalhadoDTO;
import br.com.company.fks.modelo.dto.PedidoRelatorioDTO;
import br.com.company.fks.modelo.dto.PedidoTelaAdministrativaDTO;
import br.com.company.fks.modelo.dto.PedidoTemaDTO;
import br.com.company.fks.modelo.dto.RecursoTelaAdministrativaDTO;
import br.com.company.fks.modelo.dto.RespostaClassificadaDTO;
import br.com.company.fks.modelo.dto.RespostaPedidoDTO;
import br.com.company.fks.modelo.dto.SolicitanteDTO;
import br.com.company.fks.modelo.dto.StatusSolicitacaoDTO;
import br.com.company.fks.modelo.dto.StatusSolicitacaoRecursoDTO;
import br.com.company.fks.modelo.dto.StatusTramitacaoDTO;
import br.com.company.fks.modelo.dto.StatusTramitacaoRecursoDTO;
import br.com.company.fks.modelo.dto.SubtemaDTO;
import br.com.company.fks.modelo.dto.TemaDTO;
import br.com.company.fks.modelo.dto.TemaSubtemaPalavraChaveDTO;
import br.com.company.fks.modelo.enums.FiltroPedidoEnum;
import br.com.company.fks.repositorio.AndamentoRepository;
import br.com.company.fks.repositorio.ClassificacaoRespostaRepository;
import br.com.company.fks.repositorio.FeriadoRepository;
import br.com.company.fks.repositorio.HistoricoTratamentoRepository;
import br.com.company.fks.repositorio.PedidoRepository;
import br.com.company.fks.repositorio.ProrrogacaoRepository;
import br.com.company.fks.repositorio.RecursoRepository;
import br.com.company.fks.repositorio.SituacaoPedidoRepository;
import br.com.company.fks.repositorio.SolicitanteRepository;
import br.com.company.fks.repositorio.StatusSolicitacaoRecursoRepository;
import br.com.company.fks.repositorio.StatusSolicitacaoRepository;
import br.com.company.fks.repositorio.StatusTramitacaoRepository;
import br.com.company.fks.repositorio.SubunidadeRepository;
import br.com.company.fks.repositorio.TemaRepository;
import br.com.company.fks.repositorio.UnidadeRepository;
import br.com.company.fks.repositorio.UsuarioAcessosRepository;
import br.com.company.fks.utils.Constants;
import br.com.company.fks.utils.DataUtil;
import br.com.company.fks.utils.ExceptionsUtil;
import br.com.company.fks.utils.UsuarioLogadoUtil;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;


@Service
public class PedidoService {

    private static final String ENVIADA_REVISAO = "Solicitação enviada para revisão";
    private static final String PARA_REVISAO = "Para Envio";
    private static final String ENTREGAR_RESPOSTA = "Solicitação entregue";
    private static final String DEVOLVIDA = "Solicitação Devolvida";
    private static final String DISTRIBUICAO_PF = "Distribuição PF";
    private static final String RESPOSTA_ASSINADA = "Resposta Assinada";
    private static final String PRODUCAO_DE_RESPOSTA = "Produção de Resposta";
    private static final String EDICAO_TECNICO = "Edição Técnico";
    private static final String RESPOSTA_SIC = "Resposta SIC";
    private static final String FKS_PONTO_FOCAL = "FKS.PONTO.FOCAL";

    @Autowired
    private PedidoCustomRepositorio pedidoCustomRepositorio;

    @Autowired
    private HistoricoTratamentoRepository historicoTratamentoRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private FeriadoRepository feriadoRepository;

    @Autowired
    private StatusTramitacaoRepository statusTramitacaoRepository;

    @Autowired
    private StatusSolicitacaoRepository statusSolicitacaoRepository;

    @Autowired
    private AndamentoService andamentoService;

    @Autowired
    private AndamentoRepository andamentoRepository;

    @Autowired
    private ProrrogacaoRepository prorrogacaoRepository;

    @Autowired
    private FeriadoService feriadoService;

    @Autowired
    private HistoricoTratamentoService historicoTratamentoService;

    @Autowired
    private UsuarioLogadoUtil usuarioLogadoUtil;

    @Autowired
    private ClassificacaoRespostaRepository classificacaoRespostaRepository;

    @Autowired
    private RecursoService recursoService;

    @Autowired
    private TemaRepository temaRepository;

    @Autowired
    private RecursoRepository recursoRepository;

    @Autowired
    private SolicitanteRepository solicitanteRepository;

    @Autowired
    private StatusSolicitacaoRecursoRepository statusSolicitacaoRecursoRepository;

    @Autowired
    private AndamentoRecursoService andamentoRecursoService;

    @Autowired
    private UnidadeRepository unidadeRepository;

    @Autowired
    private UsuarioAcessosRepository usuarioAcessosRepository;

    @Autowired
    private SituacaoPedidoRepository situacaoPedidoRepository;

    @Autowired
    private SubunidadeRepository subunidadeRepository;

    @Autowired
    private UnidadeService unidadeService;

    public Resposta<List<ConsultaPedidoDTO>> consultarPedido(FiltroPedidoDTO filtroPedidoDTO) throws IntegracaoException {
        List<Pedido> pedidosList = pedidoCustomRepositorio.efetuarConsultaPaginadaPedido(filtroPedidoDTO, false);
        pedidosList = filtrarPedidosSubTema(filtroPedidoDTO, pedidosList);
        List<ConsultaPedidoDTO> listaConsultaPedidoDTO = montarListaConsultaPedidoDTO(pedidosList);
        Long totalElementos = pedidoCustomRepositorio.efetuarConsultaContadorTotalPedido(filtroPedidoDTO);
        Resposta<List<ConsultaPedidoDTO>> resposta = new Resposta<>();
        resposta.setResultado(listaConsultaPedidoDTO);
        resposta.setTotalElementos(totalElementos);
        return resposta;
    }

    private List<Pedido> filtrarPedidosSubTema(FiltroPedidoDTO filtroPedidoDTO, List<Pedido> pedidosList) {
        return filtrarPedidos(pedidosList, filtroPedidoDTO);
    }

    private List<Pedido> filtrarPedidos(List<Pedido> pedidos, FiltroPedidoDTO filtroPedidoDTO) {
        List<Pedido> newPedidos = new ArrayList<>(pedidos);
        for (FiltroPedidoEnum filtro : FiltroPedidoEnum.values()) {
            newPedidos = FiltroPedidoEnum.runFilter(newPedidos, filtroPedidoDTO, filtro);
        }
        return newPedidos;
    }

    private List<ConsultaPedidoDTO> montarListaConsultaPedidoDTO(List<Pedido> listaPedido) {
        List<ConsultaPedidoDTO> listaConsultaPedidoDTO = new ArrayList<>();
        for (Pedido pedido : listaPedido) {
            Andamento andamento = andamentoRepository.findTopByPedidoIdAndStatusSolicitacaoId(pedido.getId(), pedido.getStatusSolicitacao().getId());
            ConsultaPedidoDTO consultaPedidoDTO = new ConsultaPedidoDTO(pedido.getId(),pedido.getProtocolo(),  pedido.getSolicitante().getNome(), pedido.getTema() == null ? "" : pedido.getTema().getNomeTema(), pedido.getStatusSolicitacao().getNome());
            consultaPedidoDTO.setDataAbertura(pedido.getDataRegistro());
            consultaPedidoDTO.setPrazoVencimento(pedido.getVencimentoUnidade());
            consultaPedidoDTO.setPrazoVencimentoESic(pedido.getPrazoAtendimento());
            consultaPedidoDTO.setIsEouv(pedido.getIsEOuv());
            consultaPedidoDTO.setNomeStatusSolicitacao(pedido.getStatusSolicitacao().getNome());
            if (andamento != null) {
                obterUnidadeSubunidade(andamento, consultaPedidoDTO);
                obterTecnicoResponsavel(andamento, consultaPedidoDTO);
            }
            listaConsultaPedidoDTO.add(consultaPedidoDTO);
        }
        return listaConsultaPedidoDTO;
    }

    public void associarPedidoTema(PedidoTemaDTO pedidoTema) {
        Pedido pedido = pedidoRepository.findById(pedidoTema.getIdPedido());
        Tema tema = temaRepository.findById(pedidoTema.getIdTema());
        zerarAssuntoSubtemaPalavraChave(pedido);
        pedido.setTema(tema);
        pedido.setSubtemaList(montarListaSubtema(pedidoTema));
        pedido.setPalavraChaveList(pedidoTema.getPalavrasChaves());
        pedidoRepository.save(pedido);
    }

    private List<Subtema> montarListaSubtema(PedidoTemaDTO pedidotema) {
        List<Subtema> subtemaList = new ArrayList<>();
        List<SubtemaDTO> subtemaDTOList = pedidotema.getSubtemaDTO();
        Tema tema = temaRepository.findById(pedidotema.getIdTema());
        List<PalavraChave> palavraChaves = pedidotema.getPalavrasChaves();
        for (SubtemaDTO subtemaDTO : subtemaDTOList) {
            Subtema subtema = new Subtema();
            subtema.setId(subtemaDTO.getIdSubtemaDTO());
            subtema.setNomeSubtema(subtemaDTO.getNomeSubtema());
            subtema.setPalavrasChaves(palavraChaves);
            subtema.setTema(tema);
            subtemaList.add(subtema);
        }
        return subtemaList;

    }

    private void zerarAssuntoSubtemaPalavraChave(Pedido pedido) {
        pedido.setTema(null);
        pedido.setSubtemaList(null);
        pedido.setPalavraChaveList(null);
        pedidoRepository.save(pedido);
    }

    public PedidoDetalhadoDTO detalharPedido(Long idPedido) {
        Pedido pedido = pedidoCustomRepositorio.detalharPedido(idPedido);
        PedidoDetalhadoDTO pedidoDetalhadoDTO = new PedidoDetalhadoDTO();
        preencherPedidoDetalhadoParte1(pedidoDetalhadoDTO, pedido, idPedido);
        preencherPedidoDetalhadoParte2(pedidoDetalhadoDTO, pedido, idPedido);
        preencherPedidoDetalhadoParte3(pedidoDetalhadoDTO, pedido, idPedido);
        Set<Anexo> anexos = pedido.getAnexos();
        for (Anexo anexo : anexos){
            pedidoDetalhadoDTO.getAnexos().add(new AnexoPedidoDetalhadoDTO(anexo.getNome()));
        }
        obterUnidadeSubunidadeDoPedido(idPedido, pedido.getStatusSolicitacao().getId(), pedidoDetalhadoDTO);
        return pedidoDetalhadoDTO;
    }

    private void preencherPedidoDetalhadoParte1(PedidoDetalhadoDTO pedidoDetalhadoDTO, Pedido pedido, Long idPedido){
        pedidoDetalhadoDTO.setIdPedido(pedido.getId());
        pedidoDetalhadoDTO.setIdRecurso(recursoService.buscarIdRecurso(idPedido));
        pedidoDetalhadoDTO.setProtocolo(pedido.getProtocolo());
        pedidoDetalhadoDTO.setNomeStatusSolicitacao(pedido.getStatusSolicitacao().getNome());
        pedidoDetalhadoDTO.setDataAbertura(pedido.getDataRegistro());
        pedidoDetalhadoDTO.setVencimentoUnidade(pedido.getVencimentoUnidade());
        pedidoDetalhadoDTO.setSolicitanteDTO(montarSolicitanteDTO(pedido.getSolicitante()));
        pedidoDetalhadoDTO.setNomeSituacaoPedido(pedido.getSituacaoPedido().getNome());
        pedidoDetalhadoDTO.setResumoSolicitacao(pedido.getResumoSolicitacao());
        pedidoDetalhadoDTO.setDetalhamentoSolicitacao(pedido.getDescricaoPedido());
        pedidoDetalhadoDTO.setObservacao(andamentoService.buscarObservacaoAndamento(idPedido));
        pedidoDetalhadoDTO.setFormaRecebimento(pedido.getFormaRecebimento());
        pedidoDetalhadoDTO.setVencimentoESic(pedido.getPrazoAtendimento());
        pedidoDetalhadoDTO.setRespostaFKS(pedido.getRespostaEsic());
        pedidoDetalhadoDTO.setDataRespostaEsic(pedido.getDataRespostaEsic());
        pedidoDetalhadoDTO.setOrgaoVinculado(pedido.getOrgaoVinculado());
        pedidoDetalhadoDTO.setTema(pedido.getTema());
    }

    private void preencherPedidoDetalhadoParte2(PedidoDetalhadoDTO pedidoDetalhadoDTO, Pedido pedido, Long idPedido){
        pedidoDetalhadoDTO.setPossuiTratamentoFinal(verificarSePedidoPossuiTratamentoFinal(idPedido));
        pedidoDetalhadoDTO.setDataEntradaProtocoloSistemaFKS(pedido.getDataEntradaProtocoloSistemaFKS());
        pedidoDetalhadoDTO.setProrrogado(prorrogacaoRepository.consultarProrrogacaoPorIdPedido(pedido, false) != null);
        pedidoDetalhadoDTO.setProrrogadoESic(prorrogacaoRepository.consultarProrrogacaoPorIdPedido(pedido, true) != null);
        pedidoDetalhadoDTO.setPossuiEOuv(pedido.getIsEOuv());
        pedidoDetalhadoDTO.setIsDevolver(pedido.getIsDevolver());
        pedidoDetalhadoDTO.setResposta(pedido.getRespostaEsic());
        pedidoDetalhadoDTO.setPossuiRespostaPerfil(verificaSeTemRespostaPerfil(idPedido));
        pedidoDetalhadoDTO.setIsClassificacaoResposta(pedido.getIsClassificacaoResposta());
        pedidoDetalhadoDTO.setIsClassificacaoRespostaSic(pedido.getIsClassificacaoRespostaSic());
        pedidoDetalhadoDTO.setPerfilUsuario(usuarioLogadoUtil.getPerfil());
        pedidoDetalhadoDTO.setPropostaResposta(pedido.getPropostaResposta());
        pedidoDetalhadoDTO.setPossuiClassificacaoResposta(verificaSeRespostaEClassificada(pedido.getId()));
        pedidoDetalhadoDTO.setPossuiClassificacaoRespostaSic(verificaSePossuiClassificacaoRespostaESic(pedido.getId()));
    }

    private void preencherPedidoDetalhadoParte3(PedidoDetalhadoDTO pedidoDetalhadoDTO, Pedido pedido, Long idPedido){
        List<Calendar> listaFeriados = feriadoService.listaFeriadosFKS();
        pedidoDetalhadoDTO.setVencimentoUnidadeProrrodadoFKS(DataUtil.getDataHoraFinalDia(DataUtil.somarDiasUteis(pedido.getVencimentoUnidade(), 5, listaFeriados)));
        pedidoDetalhadoDTO.setDataLimiteBotaoProrrogacao(DataUtil.getDataHoraFinalDia(DataUtil.somarDiasUteis(pedido.getDataRegistro(), 10, listaFeriados)));
        pedidoDetalhadoDTO.setDataLimiteBotaoEouv(DataUtil.getDataHoraFinalDia(DataUtil.somarDiasUteis(pedido.getDataRegistro(), 2, listaFeriados)));
        pedidoDetalhadoDTO.setRespostaAssinada(andamentoService.verificaAssinatura(pedido.getId()));
        pedidoDetalhadoDTO.setStatusQueAssinou(retornaStatusQueAssinou(idPedido));
        pedidoDetalhadoDTO.setDiasUteisMaior10(DataUtil.getDiasUteis(pedido.getDataRegistro(), feriadoRepository, 10));
    }

    public String statusSolicitacao (Long idPedido) {
        return pedidoRepository.findById(idPedido).getStatusSolicitacao().getNome();
    }

    public SolicitanteDTO montarSolicitanteDTO(Solicitante solicitante) {
        SolicitanteDTO solicitanteDTO = new SolicitanteDTO();
        solicitanteDTO.setIdSolicitante(solicitante.getId());
        solicitanteDTO.setTipoPessoa(solicitante.getTipoPessoa());
        solicitanteDTO.setNome(solicitante.getNome());
        solicitanteDTO.setCpfOuCnpj(solicitante.getCpfOuCnpj());
        solicitanteDTO.setPais(solicitante.getPais());
        solicitanteDTO.setCidade(solicitante.getCidade());
        solicitanteDTO.setProfissao(solicitante.getProfissao());
        solicitanteDTO.setEmail(solicitante.getEmail());
        solicitanteDTO.setDdd(solicitante.getDdd());
        solicitanteDTO.setDocumentoIdentificacao(solicitante.getDocumentoIdentificacao());
        solicitanteDTO.setSexo(solicitante.getSexo());
        solicitanteDTO.setTelefone(solicitante.getTelefone());
        solicitanteDTO.setEndereco(solicitante.getEndereco());
        solicitanteDTO.setUf(solicitante.getUf());
        solicitanteDTO.setCep(solicitante.getCep());
        return solicitanteDTO;
    }

    private Boolean verificarSePedidoPossuiTratamentoFinal(Long idPedido) {
        Boolean pedidoPossuiEncaminhamento = Boolean.FALSE;
        Long qtdeEncaminhamentoPedido = historicoTratamentoRepository.CountTratamentoFinalPedido(idPedido);
        if (qtdeEncaminhamentoPedido > 0) {
            pedidoPossuiEncaminhamento = Boolean.TRUE;
        }
        return pedidoPossuiEncaminhamento;
    }

    @Transactional
    public Pedido alterarStatusEouv(EouvDTO eouvDTO) {
        Long idPedido = eouvDTO.getIdPedido();
        Pedido pedido = pedidoRepository.findOne(idPedido);
        if (pedido.getStatusSolicitacao().getId() == 7L || pedido.getStatusSolicitacao().getId() == 6L) {
            pedido.setStatusTramitacao(statusTramitacaoRepository.findOne(StatusTramitacao.ANDAMENTO));
            pedido.setStatusSolicitacao(statusSolicitacaoRepository.findOne(StatusSolicitacao.RESPOSTA_ASSINADA_PF));
        } else if (pedido.getStatusSolicitacao().getId().equals(StatusSolicitacao.EDICAO_TECNICO)) {
            pedido.setStatusTramitacao(statusTramitacaoRepository.findOne(StatusTramitacao.ANDAMENTO));
            pedido.setStatusSolicitacao(statusSolicitacaoRepository.findOne(StatusSolicitacao.PRODUCAO_RESPOSTA));
        } else {
            pedido.setStatusTramitacao(statusTramitacaoRepository.findOne(StatusTramitacao.RESPONDIDAS));
            pedido.setStatusSolicitacao(statusSolicitacaoRepository.findOne(StatusSolicitacao.RESPOSTA_SIC));
        }
        pedido.setStatusRespostaAssinada(eouvDTO.getAssinou());
        pedido.setIsEOuv(true);
        pedido.setIsDevolver(false);
        return pedidoRepository.save(pedido);
    }

    @Transactional
    public Pedido alterarStatusFinalizarEouv(Long idPedido) throws IntegracaoException {
        Pedido pedido = pedidoRepository.findOne(idPedido);
        pedido.setStatusTramitacao(statusTramitacaoRepository.findOne(StatusTramitacao.E_OUV));
        pedido.setStatusSolicitacao(statusSolicitacaoRepository.findOne(StatusSolicitacao.ENVIADA));
        pedido.setIsEOuv(false);
        return pedidoRepository.save(pedido);
    }

    public byte[] exportarConsultaPedido(FiltroPedidoDTO filtroPedidoDTO) throws IntegracaoException, IOException {
        List<Pedido> listaPedido = pedidoCustomRepositorio.efetuarConsultaPaginadaPedido(filtroPedidoDTO, true);
        List<PedidoRelatorioDTO> listaPedidoRelatorioDTO = montarListaPedidoRelatorioDTO(listaPedido);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook();
        XSSFSheet xssfSheet = xssfWorkbook.createSheet("Consulta de Pedidos");
        criarLinhaCabecalho(xssfSheet);
        criarLinhasPlanilha(xssfSheet, listaPedidoRelatorioDTO);
        ExceptionsUtil.exceptionXssf(byteArrayOutputStream, xssfWorkbook);
        return byteArrayOutputStream.toByteArray();
    }

    private List<PedidoRelatorioDTO> montarListaPedidoRelatorioDTO(List<Pedido> listaPedido) {
        List<PedidoRelatorioDTO> listaPedidoRelatorioDTO = new ArrayList<>();
        for (Pedido pedido : listaPedido) {
            PedidoRelatorioDTO pedidoRelatorioDTO = montarPedidoRelatorioDTO(pedido);
            listaPedidoRelatorioDTO.add(pedidoRelatorioDTO);
        }
        return listaPedidoRelatorioDTO;
    }

    public PedidoRelatorioDTO montarPedidoRelatorioDTO(Pedido pedido) {
        PedidoRelatorioDTO pedidoRelatorioDTO = new PedidoRelatorioDTO();
        pedidoRelatorioDTO.setProtocolo(pedido.getProtocolo());
        pedidoRelatorioDTO.setStatusTramitacao(pedido.getStatusTramitacao().getNome());
        pedidoRelatorioDTO.setStatusSolicitacao(pedido.getStatusSolicitacao().getNome());
        pedidoRelatorioDTO.setUnidade(pedido.getAndamentos().get(pedido.getAndamentos().size() - 1).getUnidade() == null ? "" : pedido.getAndamentos().get(pedido.getAndamentos().size() - 1).getUnidade().getNomeUnidade());
        pedidoRelatorioDTO.setSubUnidade(pedido.getAndamentos().get(pedido.getAndamentos().size() - 1).getSubunidade() == null ? "" : pedido.getAndamentos().get(pedido.getAndamentos().size() - 1).getSubunidade().getNomeSubunidade());
        pedidoRelatorioDTO.setDataRegistro(pedido.getDataRegistro());
        pedidoRelatorioDTO.setDataRespostaESic(pedido.getDataRespostaEsic());
        pedidoRelatorioDTO.setVencimentoUnidade(pedido.getVencimentoUnidade());
        pedidoRelatorioDTO.setVencimentoEsic(pedido.getPrazoAtendimento());
        pedidoRelatorioDTO.setAssunto(pedido.getTema() == null ? "" : pedido.getTema().getNomeTema());
        pedidoRelatorioDTO.setSubAssunto(pedido.getSubtemaList().isEmpty() ? "" : pedido.getSubtemaList().toString());
        montarPedidoRelatorioDTOVerificacao1(pedido, pedidoRelatorioDTO);
        montarPedidoRelatorioDTOVerificacao2(pedido, pedidoRelatorioDTO);
        montarPedidoRelatorioDTOVerificacao3(pedido, pedidoRelatorioDTO);
        montarPedidoRelatorioDTOVerificacao4(pedido, pedidoRelatorioDTO);
        return pedidoRelatorioDTO;
    }

    private void montarPedidoRelatorioDTOVerificacao1(Pedido pedido, PedidoRelatorioDTO pedidoRelatorioDTO){
        if (pedido.getSubtemaList().isEmpty()) {
            pedidoRelatorioDTO.setSubAssunto("");
        } else {
            StringBuilder sb = new StringBuilder();
            for (Subtema subtema : pedido.getSubtemaList()) {
                String newString = subtema.getNomeSubtema() + ". ";
                sb.append(newString);
            }
            pedidoRelatorioDTO.setSubAssunto(sb.toString());
        }

    }

    private void montarPedidoRelatorioDTOVerificacao2(Pedido pedido, PedidoRelatorioDTO pedidoRelatorioDTO){
        if (pedido.getPalavraChaveList().isEmpty()) {
            pedidoRelatorioDTO.setPalavraChave("");
        } else {
            StringBuilder sb = new StringBuilder();
            for (PalavraChave chave : pedido.getPalavraChaveList()) {
                String newString = chave.getDescricao() + ". ";
                sb.append(newString);
            }
            pedidoRelatorioDTO.setPalavraChave(sb.toString());
        }
    }

    private void montarPedidoRelatorioDTOVerificacao3(Pedido pedido, PedidoRelatorioDTO pedidoRelatorioDTO){
        boolean flag = false;
        for (Andamento a : pedido.getAndamentos()) {
            if (a.getUsuarioAcessosAssinatura() != null) {
                pedidoRelatorioDTO.setAtendente(a.getUsuarioAcessosAssinatura().getNomeUsuario());
                flag = true;
            }
        }
        if (!flag) {
            pedidoRelatorioDTO.setAtendente("");
        }
        pedidoRelatorioDTO.setNomeSolicitante(pedido.getSolicitante().getNome());
        pedidoRelatorioDTO.setResumoSolicitacao(pedido.getResumoSolicitacao());
        pedidoRelatorioDTO.setDescricaoPedido(pedido.getDescricaoPedido());
        pedidoRelatorioDTO.setResposta(pedido.getRespostaEsic());
    }

    private void montarPedidoRelatorioDTOVerificacao4(Pedido pedido, PedidoRelatorioDTO pedidoRelatorioDTO){
        List<Recurso> listRecurso = recursoRepository.recuperarRecursoPeloProtocolo(pedido.getProtocolo());
        if (!listRecurso.isEmpty()) {
            pedidoRelatorioDTO.setRecurso1Instancia("SIM");
            pedidoRelatorioDTO.setRespostaRecurso1Instancia(listRecurso.get(0).getRespostaEsic() != null ? listRecurso.get(0).getRespostaEsic().replaceAll("(?s)<[^>]*>(\\s*<[^>]*>)*", " ").replaceAll("&nbsp;", "").replace("\n", "").replace("\r", "") : "");
            pedidoRelatorioDTO.setRecurso2Instancia(listRecurso.size() == 2 ? "SIM" : "NÃO");
            pedidoRelatorioDTO.setRespostaRecurso2Instancia(listRecurso.size() == 2 ? listRecurso.get(1).getRespostaEsic() != null ? listRecurso.get(1).getRespostaEsic().replaceAll("(?s)<[^>]*>(\\s*<[^>]*>)*", " ").replaceAll("&nbsp;", "").replace("\n", "").replace("\r", "") : "" : "");
        } else {
            pedidoRelatorioDTO.setRecurso1Instancia("NÃO");
            pedidoRelatorioDTO.setRespostaRecurso1Instancia("");
            pedidoRelatorioDTO.setRecurso2Instancia("NÃO");
            pedidoRelatorioDTO.setRespostaRecurso2Instancia("");
        }
    }

    private void criarLinhaCabecalho(XSSFSheet xssfSheet) {
        XSSFRow xssfRow = xssfSheet.createRow(Constants.ZERO);
        xssfRow.createCell(Constants.ZERO).setCellValue("Protocolo");
        xssfRow.createCell(Constants.UM).setCellValue("Status da Tramitação");
        xssfRow.createCell(Constants.DOIS).setCellValue("Status da Solicitação");
        xssfRow.createCell(Constants.TRES).setCellValue("Unidade");
        xssfRow.createCell(Constants.QUATRO).setCellValue("Sub Unidade");
        xssfRow.createCell(Constants.CINCO).setCellValue("Data de Abertura");
        xssfRow.createCell(Constants.SEIS).setCellValue("Data da Resposta");
        xssfRow.createCell(Constants.SETE).setCellValue("Vencimento Unidade");
        criarLinhaCabecalhoParte2(xssfRow);
    }

    private void criarLinhaCabecalhoParte2(XSSFRow xssfRow){
        xssfRow.createCell(Constants.OITO).setCellValue("Vencimento e-SIC");
        xssfRow.createCell(Constants.NOVE).setCellValue("Assunto");
        xssfRow.createCell(Constants.DEZ).setCellValue("Subassunto");
        xssfRow.createCell(Constants.ONZE).setCellValue("Palavra-Chave");
        xssfRow.createCell(Constants.DOZE).setCellValue("Atendente");
        xssfRow.createCell(Constants.TREZE).setCellValue("Classificação de Conteúdo");
        xssfRow.createCell(Constants.QUATORZE).setCellValue("Nome do Solicitante");
        xssfRow.createCell(Constants.QUINZE).setCellValue("Resumo da Solicitação");
        xssfRow.createCell(Constants.DEZESSEIS).setCellValue("Descrição do Pedido");
        xssfRow.createCell(Constants.DEZESETE).setCellValue("Resposta");
        xssfRow.createCell(Constants.DEZOITO).setCellValue("Recurso de 1ª instância ");
        xssfRow.createCell(Constants.DEZENOVE).setCellValue("Resposta do Recurso de 1ª instância");
        xssfRow.createCell(Constants.VINTE).setCellValue("Recurso de 2ª instância");
        xssfRow.createCell(Constants.VINTEUM).setCellValue("Resposta do Recurso de 2ª instância");
    }

    private void criarLinhasPlanilha(XSSFSheet xssfSheet, List<PedidoRelatorioDTO> listaPedidoRelatorioDTO) {
        int row = Constants.UM;
        for (PedidoRelatorioDTO pedidoRelatorioDTO : listaPedidoRelatorioDTO) {
            XSSFRow xssfRow = xssfSheet.createRow(row);
            preencherLinhaPlanilha(xssfRow, pedidoRelatorioDTO);
            row = row + 1;
        }
    }

    private void preencherLinhaPlanilha(XSSFRow xssfRow, PedidoRelatorioDTO pedidoRelatorioDTO) {
        xssfRow.createCell(Constants.ZERO).setCellValue(pedidoRelatorioDTO.getProtocolo());
        xssfRow.createCell(Constants.UM).setCellValue(pedidoRelatorioDTO.getStatusTramitacao());
        xssfRow.createCell(Constants.DOIS).setCellValue(pedidoRelatorioDTO.getStatusSolicitacao());
        xssfRow.createCell(Constants.TRES).setCellValue(pedidoRelatorioDTO.getUnidade());
        xssfRow.createCell(Constants.QUATRO).setCellValue(pedidoRelatorioDTO.getSubUnidade());
        xssfRow.createCell(Constants.CINCO).setCellValue(DataUtil.getDataFormatada(pedidoRelatorioDTO.getDataRegistro()));
        xssfRow.createCell(Constants.SEIS).setCellValue(DataUtil.getDataFormatada(pedidoRelatorioDTO.getDataRespostaESic()));
        xssfRow.createCell(Constants.SETE).setCellValue(DataUtil.getDataFormatada(pedidoRelatorioDTO.getVencimentoUnidade()));
        preencherLinhaPlanilhaParte2(xssfRow, pedidoRelatorioDTO);
    }

    private void preencherLinhaPlanilhaParte2(XSSFRow xssfRow, PedidoRelatorioDTO pedidoRelatorioDTO){
        xssfRow.createCell(Constants.OITO).setCellValue(DataUtil.getDataFormatada(pedidoRelatorioDTO.getVencimentoEsic()));
        xssfRow.createCell(Constants.NOVE).setCellValue(pedidoRelatorioDTO.getAssunto());
        xssfRow.createCell(Constants.DEZ).setCellValue(pedidoRelatorioDTO.getSubAssunto());
        xssfRow.createCell(Constants.ONZE).setCellValue(pedidoRelatorioDTO.getPalavraChave());
        xssfRow.createCell(Constants.DOZE).setCellValue(pedidoRelatorioDTO.getAtendente());
        xssfRow.createCell(Constants.TREZE).setCellValue(pedidoRelatorioDTO.getClassificacaoConteudo());
        xssfRow.createCell(Constants.QUATORZE).setCellValue(pedidoRelatorioDTO.getNomeSolicitante());
        xssfRow.createCell(Constants.QUINZE).setCellValue(pedidoRelatorioDTO.getResumoSolicitacao());
        xssfRow.createCell(Constants.DEZESSEIS).setCellValue(pedidoRelatorioDTO.getDescricaoPedido());
        xssfRow.createCell(Constants.DEZESETE).setCellValue(pedidoRelatorioDTO.getResposta());
        xssfRow.createCell(Constants.DEZOITO).setCellValue(pedidoRelatorioDTO.getRecurso1Instancia());
        xssfRow.createCell(Constants.DEZENOVE).setCellValue(pedidoRelatorioDTO.getRespostaRecurso1Instancia());
        xssfRow.createCell(Constants.VINTE).setCellValue(pedidoRelatorioDTO.getRecurso2Instancia());
        xssfRow.createCell(Constants.VINTEUM).setCellValue(pedidoRelatorioDTO.getRespostaRecurso2Instancia());
    }

    @Transactional
    public void enviarPedidoRevisao(Long id) throws IntegracaoException {
        Pedido pedido = pedidoRepository.findById(id);
        pedido.setStatusTramitacao(statusTramitacaoRepository.findOne(StatusTramitacao.RESPONDIDAS));
        pedido.setStatusSolicitacao(statusSolicitacaoRepository.findOne(StatusSolicitacao.REVISAO));
        Unidade unidade = unidadeRepository.findByCodigoUnidade("0000");
        andamentoService.reverterAndamento(pedido, ENVIADA_REVISAO, unidade);
        pedidoRepository.save(pedido);
    }

    @Transactional
    public void reverterAndamentoPedido(DevolvePedidoDTO devolvePedidoDTO) throws IntegracaoException {
        Pedido pedido = pedidoRepository.buscarPedidoEStatusSolicitacao(devolvePedidoDTO.getIdPedido());
        Long idStatusSolicitacao = pedido.getStatusSolicitacao().getId();
        Unidade unidade = null;
        Subunidade subunidade = subunidadeRepository.findOne(1L);
        UsuarioAcessos usuarioAcessosLogado = null;
        List<Andamento> listaAndamento = andamentoRepository.recuperarAndamentosPedido(devolvePedidoDTO.getIdPedido());
        if (pedido.getStatusSolicitacao().getNome().equals(DISTRIBUICAO_PF) || pedido.getStatusSolicitacao().getNome().equals("Revisão") || pedido.getStatusSolicitacao().getNome().equals(PARA_REVISAO)) {
            unidade = unidadeRepository.findByCodigoUnidade("0000");
        } else if (pedido.getStatusSolicitacao().getNome().equals(RESPOSTA_ASSINADA)) {
            subunidade = reverterAndamentoPedidoVerificacao2(subunidade, listaAndamento);
        }
        else if (pedido.getStatusSolicitacao().getNome().equals(PRODUCAO_DE_RESPOSTA) || pedido.getStatusSolicitacao().getNome().equals(PARA_REVISAO)) {
            unidade = usuarioLogadoUtil.getUsuario().getUnidade();
        } else if (pedido.getStatusSolicitacao().getNome().equals(EDICAO_TECNICO)) {
            subunidade = unidadeService.getOneSubunidadePeloUsuarioCpf(usuarioLogadoUtil.getCpf());
            Andamento andamento = listaAndamento.get(1);
            usuarioAcessosLogado = andamento.getUsuarioAcessos().get(0);
        } else if (pedido.getStatusSolicitacao().getNome().equals(RESPOSTA_SIC) && devolvePedidoDTO.getNomeStatusSolicitacao().equals("Triagem SIC")) {
            UsuarioAcessos usuarioAcessos = usuarioAcessosRepository.findFirstByCpfUsuario(usuarioLogadoUtil.getCpf());
            unidade = usuarioAcessos.getUnidade();
        }else {
            unidade = reverterAndamentoPedidoVerificacao4(pedido, devolvePedidoDTO, listaAndamento);
        }
        StatusTramitacao statusTramitacao = new StatusTramitacao();
        StatusSolicitacao statusSolicitacao = new StatusSolicitacao();
        verificaStatusSolicitacaoEInsereACorrespondenteParte1(idStatusSolicitacao, statusTramitacao, statusSolicitacao, pedido);
        pedido.setStatusTramitacao(statusTramitacao);
        pedido.setStatusSolicitacao(statusSolicitacao);
        pedido.setObservacao(devolvePedidoDTO.getJustificativa());
        pedido.setIsDevolver(true);
        reverterAndamentoPedidoVerificacao3(pedido, unidade, subunidade, usuarioAcessosLogado);
        pedidoRepository.save(pedido);
    }

    private Unidade reverterAndamentoPedidoVerificacao4(Pedido pedido, DevolvePedidoDTO devolvePedidoDTO, List<Andamento> listaAndamento){
         if (pedido.getStatusSolicitacao().getNome().equals(RESPOSTA_SIC)
                && devolvePedidoDTO.getNomeStatusSolicitacao().equals(DISTRIBUICAO_PF)) {
            for (Andamento andamento : listaAndamento) {
                if (andamento.getStatusSolicitacao().getId().equals(StatusSolicitacao.DISTRIBUICAO_PF)) {
                    return andamento.getUnidade();
                }
            }
        } else if (pedido.getStatusSolicitacao().getNome().equals(RESPOSTA_SIC)
                && devolvePedidoDTO.getNomeStatusSolicitacao().equals(RESPOSTA_ASSINADA)) {
            for (Andamento andamento : listaAndamento) {
                if (andamento.getStatusSolicitacao().getId().equals(StatusSolicitacao.RESPOSTA_ASSINADA_PF)) {
                    return andamento.getUnidade();
                }
            }
        }
         return null;
    }

    private Subunidade reverterAndamentoPedidoVerificacao2(Subunidade subunidade, List<Andamento> listaAndamento){
        UsuarioAcessos usuarioAcessosLogado;
        Subunidade novaSubunidade = subunidade;
        for (Andamento andamento : listaAndamento) {
            if (andamento.getStatusSolicitacao().getId().equals(StatusSolicitacao.PRODUCAO_RESPOSTA)) {
                usuarioAcessosLogado = andamento.getUsuarioAcessos().get(0);
                novaSubunidade = unidadeService.getOneSubunidadePeloUsuarioCpf(usuarioAcessosLogado.getCpfUsuario());
                break;
            }
        }
        return novaSubunidade;
    }

    private void reverterAndamentoPedidoVerificacao3(Pedido pedido, Unidade unidade, Subunidade subunidade, UsuarioAcessos usuarioAcessosLogado){
        if (usuarioLogadoUtil.getPerfil().equals("FKS.TECNICO")) {
            andamentoService.reverterAndamento(pedido, DEVOLVIDA, unidade, subunidade, usuarioAcessosLogado);
        } else if (usuarioLogadoUtil.getPerfil().equals(FKS_PONTO_FOCAL)
                && pedido.getStatusSolicitacao().getId().equals(StatusSolicitacao.PRODUCAO_RESPOSTA)) {
            andamentoService.reverterAndamento(pedido, DEVOLVIDA, subunidade, usuarioAcessosLogado);
        } else {
            andamentoService.reverterAndamento(pedido, DEVOLVIDA, unidade);
        }
    }

    private void verificaStatusSolicitacaoEInsereACorrespondenteParte1(Long idStatusSolicitacao, StatusTramitacao statusTramitacao, StatusSolicitacao statusSolicitacao, Pedido pedido) {
        if (idStatusSolicitacao.equals(StatusSolicitacao.REVISAO)) {
            statusTramitacao.setId(StatusSolicitacao.DISTRIBUICAO_PF);
            statusSolicitacao.setId(StatusSolicitacao.RESPOSTA_SIC);
        } else if (idStatusSolicitacao.equals(StatusSolicitacao.RESPOSTA_SIC)) {
            verificaStatusSolicitacaoEInsereACorrespondenteParte1Loop(pedido, statusSolicitacao, statusTramitacao);
        } else if (idStatusSolicitacao.equals(StatusSolicitacao.DISTRIBUICAO_PF)) {
            statusTramitacao.setId(StatusTramitacao.SIC);
            statusSolicitacao.setId(StatusSolicitacao.TRIAGEM_SIC);
        }
        verificaStatusSolicitacaoEInsereACorrespondenteParte2(idStatusSolicitacao, statusTramitacao, statusSolicitacao, pedido);
    }

    private void verificaStatusSolicitacaoEInsereACorrespondenteParte1Loop(Pedido pedido, StatusSolicitacao statusSolicitacao, StatusTramitacao statusTramitacao){
        List<Andamento> listaAndamento = andamentoRepository.recuperarAndamentosPedido(pedido.getId());
        for (Andamento andamento : listaAndamento) {
            if (andamento.getStatusSolicitacao().getId().equals(StatusSolicitacao.TRIAGEM_SIC)) {
                statusTramitacao.setId(StatusTramitacao.SIC);
                statusSolicitacao.setId(StatusSolicitacao.TRIAGEM_SIC);
                break;
            } else if (andamento.getStatusSolicitacao().getId().equals(StatusSolicitacao.DISTRIBUICAO_PF)) {
                statusTramitacao.setId(StatusTramitacao.ANDAMENTO);
                statusSolicitacao.setId(StatusSolicitacao.DISTRIBUICAO_PF);
                break;
            } else if (andamento.getStatusSolicitacao().getId().equals(StatusSolicitacao.RESPOSTA_ASSINADA_PF)) {
                statusTramitacao.setId(StatusTramitacao.ANDAMENTO);
                statusSolicitacao.setId(StatusSolicitacao.RESPOSTA_ASSINADA_PF);
                break;
            }
        }
    }

    private void verificaStatusSolicitacaoEInsereACorrespondenteParte2(Long idStatusSolicitacao, StatusTramitacao statusTramitacao, StatusSolicitacao statusSolicitacao, Pedido pedido) {
        if (idStatusSolicitacao.equals(StatusSolicitacao.PRODUCAO_RESPOSTA)
                && !pedido.getStatusRespostaAssinada()) {
            statusTramitacao.setId(StatusSolicitacao.RESPOSTA_SIC);
            statusSolicitacao.setId(StatusSolicitacao.DISTRIBUICAO_PF);
        } else if (idStatusSolicitacao.equals(StatusSolicitacao.RESPOSTA_ASSINADA_PF) || idStatusSolicitacao.equals(StatusSolicitacao.EDICAO_TECNICO)) {
            statusTramitacao.setId(StatusSolicitacao.RESPOSTA_SIC);
            statusSolicitacao.setId(StatusSolicitacao.PRODUCAO_RESPOSTA);
        } else if (idStatusSolicitacao.equals(StatusSolicitacao.PARA_ENVIO)) {
            statusTramitacao.setId(StatusSolicitacao.DISTRIBUICAO_PF);
            statusSolicitacao.setId(StatusSolicitacao.REVISAO);
        }
    }

    @Transactional
    public void salvarResposta(RespostaPedidoDTO respostaPedidoDTO) throws IntegracaoException {
        Pedido pedido = pedidoRepository.findById(respostaPedidoDTO.getIdPedido());
        if (pedido.getRespostaEsic() == null) {
            pedido.setStatusRespostaAssinada(true);
            pedido.setRespostaEsic(respostaPedidoDTO.getRespostaPedido());
            historicoTratamentoService.gerarHistoricoTratamento(pedido, TipoTratamento.RESPOSTA, true);
        } else {
            pedido.setRespostaEsic(respostaPedidoDTO.getRespostaPedido());
            historicoTratamentoService.gerarHistoricoTratamento(pedido, TipoTratamento.RESPOSTA_EDITADA, false);
        }
        pedidoRepository.save(pedido);
    }

    @Transactional
    public void cancelarResposta(Long id) throws IntegracaoException {
        Pedido pedido = pedidoRepository.findById(id);
        List<HistoricoTratamento> consultaHistoricoPedidos = historicoTratamentoService.recuperarHistoricos(id);
        List<ConsultaHistoricoPedidoDTO> consultaHistoricoPedidoDTOS = montarListaConsultaPedidoDTOPorHistorico(consultaHistoricoPedidos);
        for(ConsultaHistoricoPedidoDTO consultaHistoricoPedidoDTO : consultaHistoricoPedidoDTOS){
            if(consultaHistoricoPedidoDTO.getNomeResponsavel().equals(usuarioLogadoUtil.getNome())){
                if (consultaHistoricoPedidoDTOS.get(consultaHistoricoPedidoDTOS.size()-1) == consultaHistoricoPedidoDTO){
                    historicoTratamentoService.gerarHistoricoTratamento(pedido,TipoTratamento.RESPOSTA_CANCELADA,false);
                }
            }
        }
        cancelarRespostaVerificacao(pedido, id);
    }

    @Transactional
    public void cancelarRespostaVerificacao(Pedido pedido, Long id){
        if((historicoTratamentoService.recuperarRespostaPedidoPerfil(id) == null)){
            pedido.setRespostaEsic(null);
            pedido.setStatusRespostaAssinada(false);
            pedido.setIsEOuv(false);
            pedido.setIsDevolver(false);
            pedidoRepository.save(pedido);
        }else{
            pedido.setIsEOuv(false);
            pedido.setIsDevolver(false);
            pedido.setRespostaEsic(historicoTratamentoService.recuperarRespostaPedidoPerfil(id));
            pedidoRepository.save(pedido);
        }
    }

    @Transactional
    public void salvarRespostaClassificada(RespostaClassificadaDTO respostaClassificadaDTO) {
        Pedido pedido = pedidoRepository.findById(respostaClassificadaDTO.getId());
        pedido.setClassificacaoResposta(respostaClassificadaDTO.getListaClassificacaoResposta());
        classificacaoRespostaRepository.save(pedido.getClassificacaoResposta());
        pedido.setIsClassificacaoResposta(true);
        pedidoRepository.save(pedido);
    }

    public Pedido buscarRespostaPedido(Long id) {
        Pedido pedido = pedidoRepository.findById(id);
        if (historicoTratamentoService.recuperarRespostaPedidoPerfil(id) == null) {
            pedido.setRespostaEsic(historicoTratamentoService.recuperarRespostaPedido(id));
        } else {
            pedido.setRespostaEsic(historicoTratamentoService.recuperarRespostaPedidoPerfil(id));
        }

        return pedido;
    }

    public boolean verificaSeRespostaEClassificada(Long id) {
        Pedido pedido = pedidoRepository.findById(id);
        return pedido.getClassificacaoResposta().isEmpty();
    }

    public boolean verificaSePossuiClassificacaoRespostaESic(Long id) {
        Pedido pedido = pedidoRepository.findById(id);
        return pedido.getClassificarRespostaSic() != null;
    }

    public Pedido entregarResposta(Long id) throws IntegracaoException {
        Pedido pedido = pedidoRepository.findOne(id);
        pedido.setStatusTramitacao(statusTramitacaoRepository.findOne(StatusTramitacao.ENVIADAS));
        pedido.setStatusSolicitacao(statusSolicitacaoRepository.findOne(StatusSolicitacao.ENVIADA));
        pedido.setSituacaoPedido(situacaoPedidoRepository.findOne(2L));
        Unidade unidade = unidadeRepository.findOne(1L);
        andamentoService.reverterAndamento(pedido, ENTREGAR_RESPOSTA, unidade);
        return pedidoRepository.save(pedido);
    }

    public DevolvePedidoDTO consultarStatusRecurso(Long idPedido) {
        Pedido pedido = pedidoRepository.buscarPedidoEStatusSolicitacao(idPedido);
        DevolvePedidoDTO devolvePedidoDTO = new DevolvePedidoDTO();
        List<Andamento> listaAndamento = andamentoRepository.recuperarAndamentosPedido(idPedido);
        Andamento penultimoAndamento = listaAndamento.get(1);
        verificaStatusDevolucaoParte1(pedido, devolvePedidoDTO, penultimoAndamento);
        return devolvePedidoDTO;
    }

    private void verificaStatusDevolucaoParte1(Pedido pedido, DevolvePedidoDTO devolvePedidoDTO, Andamento penultimoAndamento) {
        if (pedido.getStatusSolicitacao().getId().equals(StatusSolicitacao.REVISAO)) {
            devolvePedidoDTO.setNomeStatusSolicitacao(DevolvePedidoDTO.RESPOSTA_SIC);
        } else if (pedido.getStatusSolicitacao().getId().equals(StatusSolicitacao.DISTRIBUICAO_PF)) {
            devolvePedidoDTO.setNomeStatusSolicitacao(DevolvePedidoDTO.TRIAGEM_SIC);
        } else if (pedido.getStatusSolicitacao().getId().equals(StatusSolicitacao.RESPOSTA_ASSINADA_PF)) {
            devolvePedidoDTO.setNomeStatusSolicitacao(DevolvePedidoDTO.PRODUCAO_RESPOSTA);
        } else if (pedido.getStatusSolicitacao().getId().equals(StatusSolicitacao.RESPOSTA_SIC)
                && penultimoAndamento.getStatusSolicitacao().getId().equals(StatusSolicitacao.TRIAGEM_SIC)) {
            devolvePedidoDTO.setNomeStatusSolicitacao(DevolvePedidoDTO.TRIAGEM_SIC);
        } else if (pedido.getStatusSolicitacao().getId().equals(StatusSolicitacao.RESPOSTA_SIC)) {
            List<Andamento> listaAndamento = andamentoRepository.recuperarAndamentosPedido(pedido.getId());
            verificaStatusDevolucaoVerificacao(devolvePedidoDTO, listaAndamento);
        }
        verificaStatusDevolucaoParte2(pedido, devolvePedidoDTO);
    }

    private void verificaStatusDevolucaoVerificacao(DevolvePedidoDTO devolvePedidoDTO, List<Andamento> listaAndamento){
        for (Andamento andamento : listaAndamento) {
            if (andamento.getStatusSolicitacao().getId().equals(StatusSolicitacao.TRIAGEM_SIC)) {
                devolvePedidoDTO.setNomeStatusSolicitacao(DevolvePedidoDTO.TRIAGEM_SIC);
                break;
            } else if (andamento.getStatusSolicitacao().getId().equals(StatusSolicitacao.DISTRIBUICAO_PF)) {
                devolvePedidoDTO.setNomeStatusSolicitacao(DevolvePedidoDTO.DISTRIBUICAO_PF);
                break;
            } else if (andamento.getStatusSolicitacao().getId().equals(StatusSolicitacao.PRODUCAO_RESPOSTA)) {
                devolvePedidoDTO.setNomeStatusSolicitacao(DevolvePedidoDTO.RESPOSTA_ASSINADA);
                break;
            }
        }
    }

    private void verificaStatusDevolucaoParte2(Pedido pedido, DevolvePedidoDTO devolvePedidoDTO) {
        if (pedido.getStatusSolicitacao().getId().equals(StatusSolicitacao.PRODUCAO_RESPOSTA)) {
            devolvePedidoDTO.setNomeStatusSolicitacao(DevolvePedidoDTO.DISTRIBUICAO_PF);
        } else if (pedido.getStatusSolicitacao().getId().equals(StatusSolicitacao.PARA_ENVIO)) {
            devolvePedidoDTO.setNomeStatusSolicitacao(DevolvePedidoDTO.REVISAO);
        } else if (pedido.getStatusSolicitacao().getId().equals(StatusSolicitacao.EDICAO_TECNICO)) {
            devolvePedidoDTO.setNomeStatusSolicitacao(DevolvePedidoDTO.PRODUCAO_RESPOSTA);
        }
    }

    public Boolean consultarStatusRespostaAssinada(Long idPedido) {
        Pedido pedido = pedidoRepository.findOne(idPedido);
        return pedido.getStatusRespostaAssinada();
    }

    public StatusSolicitacaoDTO buscarStatusSolicitacao(Long idPedido) {
        Pedido pedido = pedidoRepository.findOne(idPedido);
        StatusSolicitacaoDTO statusSolicitacaoDTO = new StatusSolicitacaoDTO();
        statusSolicitacaoDTO.setId(pedido.getId());
        statusSolicitacaoDTO.setNome(pedido.getStatusSolicitacao().getNome());
        return statusSolicitacaoDTO;
    }

    public Boolean verificaTema(Long idPedido) {
        Pedido pedido = pedidoRepository.findById(idPedido);
        return pedido.getTema() != null;
    }

    public PedidoTelaAdministrativaDTO buscarPeloProtocoloPedido(String protocolo) {
        Pedido pedido = pedidoRepository.findByProtocolo(protocolo);
        PedidoTelaAdministrativaDTO pedidoTelaAdministrativaDTO = new PedidoTelaAdministrativaDTO();
        StatusSolicitacaoDTO statusSolicitacaoDTO = new StatusSolicitacaoDTO();
        statusSolicitacaoDTO.setId(pedido.getStatusSolicitacao().getId());
        statusSolicitacaoDTO.setNome(pedido.getStatusSolicitacao().getNome());
        pedidoTelaAdministrativaDTO.setIdPedido(pedido.getId());
        pedidoTelaAdministrativaDTO.setStatusSolicitacaoDTO(statusSolicitacaoDTO);
        StatusTramitacaoDTO statusTramitacaoDTO = new StatusTramitacaoDTO();
        statusTramitacaoDTO.setNome(pedido.getStatusTramitacao().getNome());
        statusTramitacaoDTO.setId(pedido.getStatusTramitacao().getId());
        pedidoTelaAdministrativaDTO.setStatusTramitacaoDTO(statusTramitacaoDTO);
        buscarPeloProtocoloPedidoVerificacao(pedido, pedidoTelaAdministrativaDTO);
        return pedidoTelaAdministrativaDTO;
    }

    private void buscarPeloProtocoloPedidoVerificacao(Pedido pedido, PedidoTelaAdministrativaDTO pedidoTelaAdministrativaDTO){
        TemaDTO temaDTO = new TemaDTO();
        if (pedido.getTema() != null) {
            temaDTO.setId(pedido.getTema().getId());
            temaDTO.setNomeTema(pedido.getTema().getNomeTema());
        }
        pedidoTelaAdministrativaDTO.setTemaDTO(temaDTO);
        if (pedido.getSubtemaList() != null) {
            List<Subtema> subtemaList = pedido.getSubtemaList();
            pedidoTelaAdministrativaDTO.setSubtemas(subtemaList);
        }
    }

    public RecursoTelaAdministrativaDTO buscarPeloProtocoloRecurso(String protocolo) {
        List<Recurso> recursoList = recursoRepository.buscarProtocoloPedido(protocolo);
        if (recursoList.size() > 1) {
            Recurso recurso = recursoList.get(1);
            RecursoTelaAdministrativaDTO recursoTelaAdministrativaDTO = new RecursoTelaAdministrativaDTO();
            StatusSolicitacaoRecursoDTO statusSolicitacaoRecursoDTO = new StatusSolicitacaoRecursoDTO();
            statusSolicitacaoRecursoDTO.setNome(recurso.getStatusSolicitacao().getNome());
            statusSolicitacaoRecursoDTO.setId(recurso.getStatusSolicitacao().getId());
            recursoTelaAdministrativaDTO.setStatusSolicitacaoRecursoDTO(statusSolicitacaoRecursoDTO);
            StatusTramitacaoRecursoDTO statusTramitacaoRecursoDTO = new StatusTramitacaoRecursoDTO();
            statusTramitacaoRecursoDTO.setNome(recurso.getStatusTramitacao().getNome());
            statusTramitacaoRecursoDTO.setId(recurso.getStatusTramitacao().getId());
            recursoTelaAdministrativaDTO.setStatusTramitacaoRecursoDTO(statusTramitacaoRecursoDTO);
            recursoTelaAdministrativaDTO.setIdRecurso(recurso.getId());
            return recursoTelaAdministrativaDTO;
        } else {
            return buscarPeloRecurso(recursoList.get(0));
        }
    }

    public RecursoTelaAdministrativaDTO buscarPeloRecurso (Recurso recurso){
        RecursoTelaAdministrativaDTO recursoTelaAdministrativaDTO = new RecursoTelaAdministrativaDTO();
        StatusSolicitacaoRecursoDTO statusSolicitacaoRecursoDTO = new StatusSolicitacaoRecursoDTO();
        statusSolicitacaoRecursoDTO.setNome(recurso.getStatusSolicitacao().getNome());
        statusSolicitacaoRecursoDTO.setId(recurso.getStatusSolicitacao().getId());
        recursoTelaAdministrativaDTO.setStatusSolicitacaoRecursoDTO(statusSolicitacaoRecursoDTO);
        StatusTramitacaoRecursoDTO statusTramitacaoRecursoDTO = new StatusTramitacaoRecursoDTO();
        statusTramitacaoRecursoDTO.setNome(recurso.getStatusTramitacao().getNome());
        statusTramitacaoRecursoDTO.setId(recurso.getStatusTramitacao().getId());
        recursoTelaAdministrativaDTO.setStatusTramitacaoRecursoDTO(statusTramitacaoRecursoDTO);
        recursoTelaAdministrativaDTO.setIdRecurso(recurso.getId());
        return recursoTelaAdministrativaDTO;
    }

    public List<StatusSolicitacao> definirStatusPedido(String status) {
        List<StatusSolicitacao> statusSolicitacaoList = new ArrayList<>();
        StatusSolicitacao statusSolicitacao = new StatusSolicitacao();
        statusSolicitacao.setNome("Triagem SIC");
        statusSolicitacao.setId(1L);
        statusSolicitacaoList.add(statusSolicitacao);
        if (status.equals(PRODUCAO_DE_RESPOSTA)) {
            StatusSolicitacao statusSolicitacao2 = new StatusSolicitacao();
            statusSolicitacao2.setNome(DISTRIBUICAO_PF);
            statusSolicitacao2.setId(3L);
            statusSolicitacaoList.add(statusSolicitacao2);
        } else if (status.equals("Técnico")) {
            StatusSolicitacao statusSolicitacao3 = new StatusSolicitacao();
            statusSolicitacao3.setNome(PRODUCAO_DE_RESPOSTA);
            statusSolicitacao3.setId(7L);
            statusSolicitacaoList.add(statusSolicitacao3);
        }
        return statusSolicitacaoList;
    }

    public List<StatusSolicitacaoRecurso> definirStatusRecurso(String status, Long id) {
        List<StatusSolicitacaoRecurso> statusSolicitacaoRecursoList = new ArrayList<>();
        StatusSolicitacaoRecurso statusSolicitacaoRecurso = new StatusSolicitacaoRecurso();
        statusSolicitacaoRecurso.setNome(StatusSolicitacaoRecurso.RECURSO_PRIMEIRA_DISTRIBUICAO_PF);
        statusSolicitacaoRecurso.setId(2L);
        statusSolicitacaoRecursoList.add(statusSolicitacaoRecurso);
        definirStatusRecursoVerificacao(status, id, statusSolicitacaoRecursoList);
        return statusSolicitacaoRecursoList;
    }

    private void definirStatusRecursoVerificacao(String status, Long id, List<StatusSolicitacaoRecurso> statusSolicitacaoRecursoList){
        if (status.equals("Recurso 1ª Produção")) {
            Recurso recurso = recursoRepository.findById(id);
            if (recurso.getStatusRespostaAssinada()) {
                StatusSolicitacaoRecurso statusSolicitacaoRecurso2 = new StatusSolicitacaoRecurso();
                statusSolicitacaoRecurso2.setNome("Resposta Assinada 1ª Instância");
                statusSolicitacaoRecurso2.setId(StatusSolicitacaoRecurso.RECURSO_1_ASSINADO);
                statusSolicitacaoRecursoList.add(statusSolicitacaoRecurso2);
            }
        } else if (status.equals("Recurso 2ª Produção")) {
            Recurso recurso = recursoRepository.findById(id);
            if (recurso.getStatusRespostaAssinada()) {
                StatusSolicitacaoRecurso statusSolicitacaoRecurso3 = new StatusSolicitacaoRecurso();
                statusSolicitacaoRecurso3.setNome("Resposta Assinada 2ª Instância");
                statusSolicitacaoRecurso3.setId(StatusSolicitacaoRecurso.RECURSO_2_ASSINADO);
                statusSolicitacaoRecursoList.add(statusSolicitacaoRecurso3);
            }
        }
    }

    public Page<ConsultaPedidoDulplicadoDTO> consultarPedidoSolicitante(Long idPedido, Integer offset, Integer limit) {
        Pageable pageable = new PageRequest(offset, limit);
        Pedido pedido = pedidoRepository.findById(idPedido);
        Long idSolicitante = pedido.getSolicitante().getId();
        return pedidoRepository.consultarPedidoSolicitante(solicitanteRepository.findOne(idSolicitante), pageable);
    }

    @Transactional
    public void alterarPedidoRecurso(AlteracaoPedidoRecursoDTO alteracaoPedidoRecursoDTO) {
        Pedido pedido;
        if (alteracaoPedidoRecursoDTO.getIsPedido()) {
            pedido = pedidoRepository.findById(alteracaoPedidoRecursoDTO.getIdPedido());
        } else {
            Recurso recurso = recursoRepository.buscarIdPedido(alteracaoPedidoRecursoDTO.getIdPedido());
            pedido = pedidoRepository.findById(recurso.getPedido().getId());
        }

        Recurso recurso = null;
        List<Recurso> listaRecurso = recursoRepository.buscarIdRecurso(pedido);

        if (!listaRecurso.isEmpty()) {
            for (Recurso recursos : listaRecurso) {
                recurso = recursos;
            }
        }
        alterarPedidoRecursoParte2(recurso, pedido, alteracaoPedidoRecursoDTO);
    }

    @Transactional
    public void alterarPedidoRecursoParte2(Recurso recurso, Pedido pedido, AlteracaoPedidoRecursoDTO alteracaoPedidoRecursoDTO){
        if (recurso != null) {
            StatusSolicitacaoRecurso statusSolicitacaoRecurso = statusSolicitacaoRecursoRepository.getOne(alteracaoPedidoRecursoDTO.getIdStatusSolicitacao());
            andamentoRecursoService.reverterAndamentoRecurso(recurso, null, alteracaoPedidoRecursoDTO.getJustificativa());
            recurso.setStatusSolicitacao(statusSolicitacaoRecurso);
            recursoRepository.save(recurso);
        } else {
            StatusSolicitacao statusSolicitacao = statusSolicitacaoRepository.getOne(alteracaoPedidoRecursoDTO.getIdStatusSolicitacao());
            andamentoService.reverterAndamento(pedido, null, alteracaoPedidoRecursoDTO.getJustificativa());
            pedido.setStatusSolicitacao(statusSolicitacao);
            pedidoRepository.save(pedido);
        }
    }

    public List<ConsultaHistoricoPedidoDTO> montarListaConsultaPedidoDTOPorHistorico(List<HistoricoTratamento> historicoTratamentos) {
        List<ConsultaHistoricoPedidoDTO> consultaPedidoDTOS = new ArrayList<>();
        for (HistoricoTratamento historicoTratamento : historicoTratamentos) {
            ConsultaHistoricoPedidoDTO consultaHistoricoPedidoDTO = new ConsultaHistoricoPedidoDTO();
            consultaHistoricoPedidoDTO.setId(historicoTratamento.getId());
            consultaHistoricoPedidoDTO.setData(historicoTratamento.getData());
            consultaHistoricoPedidoDTO.setNomeResponsavel(historicoTratamento.getNomeResponsavel());
            consultaHistoricoPedidoDTO.setTipoTratamento(historicoTratamento.getTipoTratamento().getTipoTratamento());
            consultaHistoricoPedidoDTO.setResposta(historicoTratamento.getRespostaPedido());
            consultaHistoricoPedidoDTO.setIdTipoTratamento(historicoTratamento.getTipoTratamento().getId());
            consultaPedidoDTOS.add(consultaHistoricoPedidoDTO);
        }
        Collections.sort(consultaPedidoDTOS, new Comparator<ConsultaHistoricoPedidoDTO>() {
            @Override
            public int compare(ConsultaHistoricoPedidoDTO o1, ConsultaHistoricoPedidoDTO o2) {
                return o2.getId().compareTo(o1.getId());
            }
        });
        return consultaPedidoDTOS;
    }

    private boolean verificaSeTemRespostaPerfil(Long id) {
        boolean bool = false;
        Pedido pedido = pedidoRepository.findById(id);
        List<HistoricoTratamento> consultaHistoricoPedidos = historicoTratamentoService.recuperarHistoricos(id);
        List<ConsultaHistoricoPedidoDTO> consultaHistoricoPedidoDTOS = montarListaConsultaPedidoDTOPorHistorico(consultaHistoricoPedidos);
        for (ConsultaHistoricoPedidoDTO ch : consultaHistoricoPedidoDTOS) {
            if (ch.getNomeResponsavel().equals(usuarioLogadoUtil.getNome()) && ch.getResposta().equals(pedido.getRespostaEsic())) {
                bool = true;
                break;
            }
        }
        return bool;
    }

    private String retornaStatusQueAssinou(Long id){
       List<Andamento> andamentoList = ordenaAndamentoDoPedido(id);
        for(int i =0; i < andamentoList.size() ; i++){
            if(andamentoList.get(i).getStatusRespostaAssinada()){
                return andamentoList.get(i -1).getStatusSolicitacao().getNome();
            }
        }
        return null;
    }

    public List<Andamento> ordenaAndamentoDoPedido(Long id){
        Pedido pedido = pedidoRepository.findById(id);
        List<Andamento> andamentoList = pedido.getAndamentos();
        Collections.sort(andamentoList, new Comparator<Andamento>() {
            @Override
            public int compare(Andamento a1, Andamento a2) {
                return a1.getId().compareTo(a2.getId());
            }
        });
        return andamentoList;
    }

    public TemaSubtemaPalavraChaveDTO buscarTodosTemasSubtemasPalavraChavePedido(Long id) {
        Pedido pedido = pedidoRepository.findById(id);
        TemaSubtemaPalavraChaveDTO temaSubtemaPalavraChaveDTO = new TemaSubtemaPalavraChaveDTO();
        if (pedido.getTema() != null) {
            temaSubtemaPalavraChaveDTO.setTema(montarTemaDTO(pedido.getTema()));
            temaSubtemaPalavraChaveDTO.setSubtema(montarSubtemaDTO(pedido));
            temaSubtemaPalavraChaveDTO.setPalavraChaveList(pedido.getPalavraChaveList());
        }
        return temaSubtemaPalavraChaveDTO;
    }

    private TemaDTO montarTemaDTO(Tema tema) {
        TemaDTO temaDTO = new TemaDTO();
        temaDTO.setId(tema.getId());
        temaDTO.setNomeTema(tema.getNomeTema());
        return temaDTO;
    }

    private List<SubtemaDTO> montarSubtemaDTO(Pedido pedido) {
        List<SubtemaDTO> subtemaDTOList = new ArrayList<>();
        for (Subtema subtema : pedido.getSubtemaList()) {
            SubtemaDTO subtemaDTO = new SubtemaDTO();
            subtemaDTO.setIdSubtemaDTO(subtema.getId());
            subtemaDTO.setNomeSubtema(subtema.getNomeSubtema());
            subtemaDTO.setPalavrasChaves(subtema.getPalavrasChaves());
            subtemaDTOList.add(subtemaDTO);
        }
        return subtemaDTOList;
    }

    public Unidade buscarUltimaUnidade(Long id) {
        List<Andamento> andamentoList = ordenaAndamentosDoPedido(id);

        for(int i =0; i < andamentoList.size() ; i++){
            if(andamentoList.get(i).getStatusRespostaAssinada()){
                return andamentoList.get(i - 1).getUnidade();
            }
        }
        return unidadeRepository.findByCodigoUnidade("0000");
    }

    public List<Andamento> ordenaAndamentosDoPedido(Long id){
        Pedido pedido = pedidoRepository.findById(id);
        List<Andamento> andamentoList = pedido.getAndamentos();
        Collections.sort(andamentoList, new Comparator<Andamento>() {
            @Override
            public int compare(Andamento a1, Andamento a2) {
                return a1.getId().compareTo(a2.getId());
            }
        });
        return andamentoList;
    }

    public void salvarPedidoVencimentoEouv(List<ConsultaPedidoDTO> consultaPedidoDTOS) {
        for (ConsultaPedidoDTO consultaPedidoDTO : consultaPedidoDTOS) {
            Pedido retorno = pedidoRepository.findById(consultaPedidoDTO.getIdPedido());
            retorno.setStatusSolicitacao(new StatusSolicitacao());
            if (consultaPedidoDTO.getNomeStatusSolicitacao().equals(RESPOSTA_ASSINADA)) {
                retorno.getStatusSolicitacao().setId(StatusSolicitacao.DISTRIBUICAO_PF);
            } else if (consultaPedidoDTO.getNomeStatusSolicitacao().equals(PRODUCAO_DE_RESPOSTA)) {
                retorno.getStatusSolicitacao().setId(StatusSolicitacao.PRODUCAO_RESPOSTA);
            } else if (consultaPedidoDTO.getNomeStatusSolicitacao().equals(RESPOSTA_SIC) || consultaPedidoDTO.getNomeStatusSolicitacao().equals("Revisão")) {
                retorno.getStatusSolicitacao().setId(StatusSolicitacao.TRIAGEM_SIC);
            }
            retorno.setIsEOuv(false);
            retorno.setStatusRespostaAssinada(false);
            retorno.setRespostaEsic(null);
            pedidoRepository.save(retorno);
            historicoTratamentoService.gerarHistoricoTratamento(retorno, TipoTratamento.RESPOSTA_CANCELADA, false);
        }

    }

    private void obterUnidadeSubunidadeDoPedido (Long idPedido, Long idStatusSolicitacao, PedidoDetalhadoDTO pedidoDetalhadoDTO) {
        Andamento andamento = andamentoRepository.findTopByPedidoIdAndStatusSolicitacaoId(idPedido, idStatusSolicitacao);
        if (andamento != null) {
            if (andamento.getUnidade() != null) {
                pedidoDetalhadoDTO.setCodigoUnidade(andamento.getUnidade().getCodigoUnidade());
            }
            else if (andamento.getUsuarioAcessosAssinatura() != null) {
                pedidoDetalhadoDTO.setCodigoUnidade(andamento.getUsuarioAcessosAssinatura().getUnidade().getCodigoUnidade());
            }
            pedidoDetalhadoDTO.setCodigoSubunidade(andamento.getSubunidade() != null ? andamento.getSubunidade().getCodigoSubunidade() : null);
        }
    }

    private void obterUnidadeSubunidade (Andamento andamento, ConsultaPedidoDTO consultaPedidoDTO) {
        String pUser = usuarioLogadoUtil.getPerfil();
        String pUAnd = consultaPedidoDTO.getNomeStatusSolicitacao();
        if (andamento != null) {
            if ((pUAnd.equals(EDICAO_TECNICO) && pUser.equals("FKS.RESPONDENTE")) || (pUAnd.equals(RESPOSTA_ASSINADA) && pUser.equals(FKS_PONTO_FOCAL))) {
                consultaPedidoDTO.setCodigoUnidade(andamento.getUsuarioAcessosAssinatura().getUnidade().getCodigoUnidade());
                consultaPedidoDTO.setCodigoSubunidade(unidadeService.getOneSubunidadePeloUsuarioCpf(andamento.getUsuarioAcessosAssinatura().getCpfUsuario()).getCodigoSubunidade());
            }
            else {
                consultaPedidoDTO.setCodigoUnidade(andamento.getUnidade() != null ? andamento.getUnidade().getCodigoUnidade() : null);
                consultaPedidoDTO.setCodigoSubunidade(andamento.getSubunidade() != null ? andamento.getSubunidade().getCodigoSubunidade() : null);
            }
        }
    }

    private void obterTecnicoResponsavel (Andamento andamento, ConsultaPedidoDTO consultaPedidoDTO) {
        if (consultaPedidoDTO.getNomeStatusSolicitacao().equals(EDICAO_TECNICO) && usuarioLogadoUtil.getPerfil().equals("FKS.TECNICO") && !andamento.getUsuarioAcessos().isEmpty()) {
            for (UsuarioAcessos usuarioAcessos : andamento.getUsuarioAcessos()) {
                if (usuarioAcessos.getCpfUsuario().equals(usuarioLogadoUtil.getCpf())) {
                    consultaPedidoDTO.setTecnicoResponsavel(true);
                    break;
                }
            }
        }
    }
}
