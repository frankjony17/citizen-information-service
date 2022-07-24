package br.com.company.fks.servico;

import br.com.company.fks.excecao.IntegracaoException;
import br.com.company.fks.modelo.Andamento;
import br.com.company.fks.modelo.ClassificacaoResposta;
import br.com.company.fks.modelo.ClassificarRespostaSic;
import br.com.company.fks.modelo.HistoricoTratamento;
import br.com.company.fks.modelo.PalavraChave;
import br.com.company.fks.modelo.Pedido;
import br.com.company.fks.modelo.Prorrogacao;
import br.com.company.fks.modelo.Recurso;
import br.com.company.fks.modelo.SituacaoPedido;
import br.com.company.fks.modelo.Solicitante;
import br.com.company.fks.modelo.StatusSolicitacao;
import br.com.company.fks.modelo.StatusSolicitacaoRecurso;
import br.com.company.fks.modelo.StatusTramitacao;
import br.com.company.fks.modelo.StatusTramitacaoRecurso;
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
import br.com.company.fks.modelo.dto.PedidoTemaDTO;
import br.com.company.fks.modelo.dto.RespostaClassificadaDTO;
import br.com.company.fks.modelo.dto.RespostaPedidoDTO;
import br.com.company.fks.modelo.dto.SolicitanteDTO;
import br.com.company.fks.modelo.dto.SubtemaDTO;
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
import br.com.company.fks.repositorio.custom.PedidoCustomRepositorio;
import br.com.company.fks.utils.DataUtil;
import br.com.company.fks.utils.UsuarioLogadoUtil;
import lombok.SneakyThrows;
import org.apache.poi.POIXMLDocument;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyList;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

/**
 * Created by christian-tavares on 21/03/18.
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({DataUtil.class, XSSFCell.class, POIXMLDocument.class, OPCPackage.class})
public class PedidoServiceTest {

    @InjectMocks
    private PedidoService pedidoService;

    @Mock
    private PedidoCustomRepositorio pedidoCustomRepositorio;
    @Mock
    private Pedido pedido;
    @Mock
    private PedidoDetalhadoDTO pedidoDetalhadoDTO;
    @Mock
    private ProrrogacaoRepository prorrogacaoRepository;
    @Mock
    private Prorrogacao prorrogacao;
    @Mock
    private EouvService eouvService;
    @Mock
    private StatusSolicitacao statusSolicitacao;
    @Mock
    private Solicitante solicitante;
    @Mock
    private SituacaoPedido situacaoPedido;
    @Mock
    private PedidoRepository pedidoRepository;
    @Mock
    private StatusTramitacaoRepository statusTramitacaoRepository;
    @Mock
    private StatusTramitacao statusTramitacao;
    @Mock
    private StatusSolicitacaoRepository statusSolicitacaoRepository;
    @Mock
    private AndamentoService andamentoService;
    @Mock
    private List<Pedido> pedidoList;
    @Mock
    private FiltroPedidoDTO filtroPedidoDTO;
    @Mock
    private List<PedidoRelatorioDTO> pedidoRelatorioDTOList;
    @Mock
    private XSSFWorkbook xssfWorkbook;
    @Mock
    private XSSFSheet xssfSheet;
    @Mock
    private XSSFRow xssfRow;
    @Mock
    private FeriadoService feriadoService;
    @Mock
    private List<Calendar> calendarList;
    @Mock
    private Calendar calendar;
    @Mock
    private PedidoRelatorioDTO pedidoRelatorioDTO;
    @Mock
    private AndamentoRepository andamentoRepository;
    @Mock
    private DevolvePedidoDTO devolvePedidoDTO;
    @Mock
    private Andamento andamento;
    @Mock
    private Tema tema;

    @Mock
    private Page<ConsultaPedidoDulplicadoDTO> consultaPedidoDulplicadoDTOPage;

    @Mock
    private HistoricoTratamentoService historicoTratamentoService;

    @Mock
    private ClassificarRespostaSic classificarRespostaSic;

    @Mock
    private RespostaClassificadaDTO respostaClassificadaDTO;

    @Mock
    private List<ClassificacaoResposta> classificacaoRespostaList;

    @Mock
    private ClassificacaoRespostaRepository classificacaoRespostaRepository;

    @Mock
    private HistoricoTratamento historicoTratamento;

    @Mock
    private HistoricoTratamentoRepository historicoTratamentoRepository;

    @Mock
    private RespostaPedidoDTO respostaPedidoDTO;

    @Mock
    private List<Andamento> andamentoList;

    @Mock
    private RecursoService recursoService;

    @Mock
    private PedidoTemaDTO pedidoTemaDTO;

    @Mock
    private TemaRepository temaRepository;

    @Mock
    private List<Subtema> subtemaList;

    @Mock
    private Pageable pageable;

    @Mock
    private List<SubtemaDTO> subtemaDTOList;

    @Mock
    private StatusTramitacaoRecurso statusTramitacaoRecurso;

    @Mock
    private SolicitanteRepository solicitanteRepository;

    @Mock
    private List<PalavraChave> palavraChaveList;

    @Mock
    private SubtemaDTO subtemaDTO;

    @Mock
    private ConsultaPedidoDTO consultaPedidoDTO;

    @Mock
    private XSSFCell xssfCell;

    @Mock
    private POIXMLDocument poixmlDocument;

    @Mock
    private OPCPackage opcPackage;

    @Mock
    private UsuarioLogadoUtil usuarioLogadoUtil;

    @Mock
    private TipoTratamento tipoTratamento;

    @Mock
    private ConsultaHistoricoPedidoDTO consultaHistoricoPedidoDTO;

    @Mock
    private EouvDTO eouvDTO;

    @Mock
    private UnidadeRepository unidadeRepository;

    @Mock
    private Unidade unidade;

    @Mock
    private SituacaoPedidoRepository situacaoPedidoRepository;

    @Mock
    private Subtema subtema;

    @Mock
    private Recurso recurso;

    @Mock
    private AlteracaoPedidoRecursoDTO alteracaoPedidoRecursoDTO;

    @Mock
    private StatusSolicitacaoRecursoRepository statusSolicitacaoRecursoRepository;

    @Mock
    private StatusSolicitacaoRecurso statusSolicitacaoRecurso;

    @Mock
    private AndamentoRecursoService andamentoRecursoService;

    @Mock
    private RecursoRepository recursoRepository;

    @Mock
    private Subunidade subunidade;

    @Mock
    private AnexoPedidoDetalhadoDTO anexoPedidoDetalhadoDTO;

    @Mock
    private UsuarioAcessos usuarioAcessos;

    @Mock
    private SubunidadeRepository subunidadeRepository;

    @Mock
    private UsuarioAcessosRepository usuarioAcessosRepository;

    @Mock
    private FeriadoRepository feriadoRepository;

    @Mock
    private Calendar dataInicial;

    @Mock
    private List<Andamento> andamentoList1;

    @Mock
    private List<Recurso> recursoList1;

    @Mock
    private PalavraChave palavraChave;

    @Mock
    private UnidadeService unidadeService;

    @Test
    public void consultarPedidoTest() throws IntegracaoException {
        when(andamentoRepository.findTopByPedidoIdAndStatusSolicitacaoId(1L, 1L)).thenReturn(andamento);
        when(pedido.getId()).thenReturn(1L);
        when(pedido.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(statusSolicitacao.getId()).thenReturn(1L);

        List<Pedido> pedidos = new ArrayList<>();
        pedidos.add(pedido);
        pedidos.add(pedido);
        pedidos.add(pedido);

        when(pedidoCustomRepositorio.efetuarConsultaPaginadaPedido(filtroPedidoDTO, false)).thenReturn(pedidos);
        when(pedidoCustomRepositorio.efetuarConsultaContadorTotalPedido(filtroPedidoDTO)).thenReturn(1L);
        when(filtroPedidoDTO.getIdPalavraChave()).thenReturn(null);
        when(filtroPedidoDTO.getIdSubTema()).thenReturn(null);
        when(pedido.getId()).thenReturn(1L);
        when(pedido.getSolicitante()).thenReturn(solicitante);
        when(pedido.getStatusTramitacao()).thenReturn(statusTramitacao);
        when(pedido.getStatusSolicitacao()).thenReturn(statusSolicitacao);

        when(pedido.getDataRegistro()).thenReturn(calendar);
        when(pedido.getVencimentoUnidade()).thenReturn(calendar);
        when(pedido.getPrazoAtendimento()).thenReturn(calendar);
        when(pedido.getIsEOuv()).thenReturn(true);
        when(pedido.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(statusSolicitacao.getNome()).thenReturn("Resposta Assinada");

        when(usuarioLogadoUtil.getPerfil()).thenReturn("FKS.PONTO.FOCAL");
        when(consultaPedidoDTO.getNomeStatusSolicitacao()).thenReturn("Resposta Assinada");

        when(andamento.getUsuarioAcessosAssinatura()).thenReturn(usuarioAcessos);
        when(usuarioAcessos.getUnidade()).thenReturn(unidade);
        when(unidade.getCodigoUnidade()).thenReturn("codigoUnidade");

        when(unidadeService.getOneSubunidadePeloUsuarioCpf(anyString())).thenReturn(subunidade);

        when(andamento.getUsuarioAcessosAssinatura()).thenReturn(usuarioAcessos);
        when(subunidade.getCodigoSubunidade()).thenReturn("codigoSubunidade");

        consultaPedidoDTO.setIdPedido(1L);
        pedidoService.consultarPedido(filtroPedidoDTO);
    }

    @Test
    public void consultarPedidoTestEdicaoTecnicoERespondente() throws IntegracaoException {
        when(andamentoRepository.findTopByPedidoIdAndStatusSolicitacaoId(1L, 1L)).thenReturn(andamento);
        when(pedido.getId()).thenReturn(1L);
        when(pedido.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(statusSolicitacao.getId()).thenReturn(1L);

        List<Pedido> pedidos = new ArrayList<>();
        pedidos.add(pedido);
        pedidos.add(pedido);
        pedidos.add(pedido);

        when(pedidoCustomRepositorio.efetuarConsultaPaginadaPedido(filtroPedidoDTO, false)).thenReturn(pedidos);
        when(pedidoCustomRepositorio.efetuarConsultaContadorTotalPedido(filtroPedidoDTO)).thenReturn(1L);
        when(filtroPedidoDTO.getIdPalavraChave()).thenReturn(null);
        when(filtroPedidoDTO.getIdSubTema()).thenReturn(null);
        when(pedido.getId()).thenReturn(1L);
        when(pedido.getSolicitante()).thenReturn(solicitante);
        when(pedido.getStatusTramitacao()).thenReturn(statusTramitacao);
        when(pedido.getStatusSolicitacao()).thenReturn(statusSolicitacao);

        when(pedido.getDataRegistro()).thenReturn(calendar);
        when(pedido.getVencimentoUnidade()).thenReturn(calendar);
        when(pedido.getPrazoAtendimento()).thenReturn(calendar);
        when(pedido.getIsEOuv()).thenReturn(true);
        when(pedido.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(statusSolicitacao.getNome()).thenReturn("Edição Técnico");

        when(usuarioLogadoUtil.getPerfil()).thenReturn("FKS.RESPONDENTE");
        when(consultaPedidoDTO.getNomeStatusSolicitacao()).thenReturn("Edição Técnico");


        when(andamento.getUsuarioAcessosAssinatura()).thenReturn(usuarioAcessos);
        when(usuarioAcessos.getUnidade()).thenReturn(unidade);
        when(unidade.getCodigoUnidade()).thenReturn("codigoUnidade");

        when(andamento.getUsuarioAcessosAssinatura()).thenReturn(usuarioAcessos);
        when(subunidade.getCodigoSubunidade()).thenReturn("codigoSubunidade");

        when(consultaPedidoDTO.getNomeStatusSolicitacao()).thenReturn("Edição Técnico");
        when(usuarioLogadoUtil.getPerfil()).thenReturn("FKS.TECNICO");

        List<UsuarioAcessos> usuarioAcessosList = new ArrayList<>();
        usuarioAcessosList.add(usuarioAcessos);
        usuarioAcessosList.add(usuarioAcessos);
        usuarioAcessosList.add(usuarioAcessos);
        usuarioAcessosList.add(usuarioAcessos);

        when(andamento.getUsuarioAcessos()).thenReturn(usuarioAcessosList);

        when(usuarioAcessos.getCpfUsuario()).thenReturn("00000000000");
        when(usuarioLogadoUtil.getCpf()).thenReturn("00000000000");

        consultaPedidoDTO.setIdPedido(1L);
        pedidoService.consultarPedido(filtroPedidoDTO);
    }

    @Test
    public void consultarPedidoTestEdicaoTecnicoERespondente2() throws IntegracaoException {
        when(andamentoRepository.findTopByPedidoIdAndStatusSolicitacaoId(1L, 1L)).thenReturn(andamento);
        when(pedido.getId()).thenReturn(1L);
        when(pedido.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(statusSolicitacao.getId()).thenReturn(1L);

        List<Pedido> pedidos = new ArrayList<>();
        pedidos.add(pedido);
        pedidos.add(pedido);
        pedidos.add(pedido);

        when(pedidoCustomRepositorio.efetuarConsultaPaginadaPedido(filtroPedidoDTO, false)).thenReturn(pedidos);
        when(pedidoCustomRepositorio.efetuarConsultaContadorTotalPedido(filtroPedidoDTO)).thenReturn(1L);
        when(filtroPedidoDTO.getIdPalavraChave()).thenReturn(null);
        when(filtroPedidoDTO.getIdSubTema()).thenReturn(null);
        when(pedido.getId()).thenReturn(1L);
        when(pedido.getSolicitante()).thenReturn(solicitante);
        when(pedido.getStatusTramitacao()).thenReturn(statusTramitacao);
        when(pedido.getStatusSolicitacao()).thenReturn(statusSolicitacao);

        when(pedido.getDataRegistro()).thenReturn(calendar);
        when(pedido.getVencimentoUnidade()).thenReturn(calendar);
        when(pedido.getPrazoAtendimento()).thenReturn(calendar);
        when(pedido.getIsEOuv()).thenReturn(true);
        when(pedido.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(statusSolicitacao.getNome()).thenReturn("Edição Técnico");

        when(usuarioLogadoUtil.getPerfil()).thenReturn("FKS.RESPONDENTE");
        when(consultaPedidoDTO.getNomeStatusSolicitacao()).thenReturn("Edição Técnico");


        when(andamento.getUsuarioAcessosAssinatura()).thenReturn(usuarioAcessos);
        when(usuarioAcessos.getUnidade()).thenReturn(unidade);
        when(unidade.getCodigoUnidade()).thenReturn("codigoUnidade");

        when(andamento.getUsuarioAcessosAssinatura()).thenReturn(usuarioAcessos);
        when(subunidade.getCodigoSubunidade()).thenReturn("codigoSubunidade");

        when(consultaPedidoDTO.getNomeStatusSolicitacao()).thenReturn("Edição Técnico");
        when(usuarioLogadoUtil.getPerfil()).thenReturn("FKS.TECNICO");

        List<UsuarioAcessos> usuarioAcessosList = new ArrayList<>();
        usuarioAcessosList.add(usuarioAcessos);
        usuarioAcessosList.add(usuarioAcessos);
        usuarioAcessosList.add(usuarioAcessos);
        usuarioAcessosList.add(usuarioAcessos);

        when(andamento.getUsuarioAcessos()).thenReturn(usuarioAcessosList);

        when(usuarioAcessos.getCpfUsuario()).thenReturn("00000000000");
        when(usuarioLogadoUtil.getCpf()).thenReturn("1111111111111");

        consultaPedidoDTO.setIdPedido(1L);
        pedidoService.consultarPedido(filtroPedidoDTO);
    }

    @Test
    public void consultarPedidoTest2() throws IntegracaoException {
        when(andamentoRepository.findTopByPedidoIdAndStatusSolicitacaoId(1L, 1L)).thenReturn(andamento);
        when(pedido.getId()).thenReturn(1L);
        when(pedido.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(statusSolicitacao.getId()).thenReturn(1L);

        List<ConsultaPedidoDTO> consultaPedidoDTOList = new ArrayList<>();
        consultaPedidoDTOList.add(consultaPedidoDTO);
        consultaPedidoDTOList.add(consultaPedidoDTO);
        consultaPedidoDTOList.add(consultaPedidoDTO);
        when(andamentoRepository.findTopByPedidoIdAndStatusSolicitacaoId(1L, 1L)).thenReturn(andamento);

        pedidoService.consultarPedido(filtroPedidoDTO);
    }

    @Test
    public void detalharPedidoTest() {
        when(pedidoCustomRepositorio.detalharPedido(1L)).thenReturn(pedido);
        when(recursoService.buscarIdPedido(1L)).thenReturn(1L);
        when(pedido.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(statusSolicitacao.getNome()).thenReturn("nome");
        when(solicitante.getId()).thenReturn(1L);
        when(pedido.getSolicitante()).thenReturn(solicitante);
        when(pedido.getSituacaoPedido()).thenReturn(situacaoPedido);
        when(situacaoPedido.getNome()).thenReturn("situacaoPedido");
        when(historicoTratamento.getTipoTratamento()).thenReturn(tipoTratamento);
        when(tipoTratamento.getTipoTratamento()).thenReturn("tipoTratamento");
        when(consultaHistoricoPedidoDTO.getNomeResponsavel()).thenReturn("nomeResponsavel");
        when(usuarioLogadoUtil.getNome()).thenReturn("nomeResponsavel");
        when(consultaHistoricoPedidoDTO.getResposta()).thenReturn("resposta");
        when(pedido.getRespostaEsic()).thenReturn("resposta");
        when(pedidoRepository.findById(0L)).thenReturn(pedido);

        when(pedido.getClassificacaoResposta()).thenReturn(classificacaoRespostaList);
        when(classificacaoRespostaList.size()).thenReturn(0);
        when(pedido.getId()).thenReturn(0L);

        List<Calendar> calendarList = new ArrayList<>();
        calendarList.add(calendar);
        calendar.set(1, 1);
        when(feriadoService.listaFeriadosFKS()).thenReturn(calendarList);
        when(pedido.getVencimentoUnidade()).thenReturn(calendar);
        when(pedido.getDataRegistro()).thenReturn(calendar);
        when(andamentoService.verificaAssinatura(1L)).thenReturn(true);

        List<Andamento> andamentoList = new ArrayList<>();
        andamentoList.add(andamento);

        when(pedidoRepository.findById(1L)).thenReturn(pedido);
        when(pedido.getAndamentos()).thenReturn(andamentoList);

        pedidoDetalhadoDTO.setDiasUteisMaior10(true);
        DataUtil.getDiasUteis(dataInicial, feriadoRepository, 10);

        when(andamentoRepository.findTopByPedidoIdAndStatusSolicitacaoId(anyLong(), anyLong())).thenReturn(andamento);
        when(andamento.getUnidade()).thenReturn(unidade);

        assertNotNull(pedidoService.detalharPedido(1l));
    }

    @Test
    public void detalharPedidoTestIf() {
        when(pedidoCustomRepositorio.detalharPedido(1L)).thenReturn(pedido);
        when(recursoService.buscarIdPedido(1L)).thenReturn(1L);
        when(pedido.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(statusSolicitacao.getNome()).thenReturn("nome");
        when(solicitante.getId()).thenReturn(1L);
        when(pedido.getSolicitante()).thenReturn(solicitante);
        when(pedido.getSituacaoPedido()).thenReturn(situacaoPedido);
        when(situacaoPedido.getNome()).thenReturn("situacaoPedido");
        when(historicoTratamento.getTipoTratamento()).thenReturn(tipoTratamento);
        when(tipoTratamento.getTipoTratamento()).thenReturn("tipoTratamento");
        when(consultaHistoricoPedidoDTO.getNomeResponsavel()).thenReturn("nomeResponsavel");
        when(usuarioLogadoUtil.getNome()).thenReturn("nomeResponsavel");
        when(consultaHistoricoPedidoDTO.getResposta()).thenReturn("resposta");
        when(pedido.getRespostaEsic()).thenReturn("resposta");
        when(pedidoRepository.findById(0L)).thenReturn(pedido);


        when(pedido.getClassificacaoResposta()).thenReturn(classificacaoRespostaList);
        when(classificacaoRespostaList.size()).thenReturn(0);
        when(pedido.getId()).thenReturn(0L);

        List<Calendar> calendarList = new ArrayList<>();
        calendarList.add(calendar);
        calendar.set(1, 1);
        when(feriadoService.listaFeriadosFKS()).thenReturn(calendarList);
        when(pedido.getVencimentoUnidade()).thenReturn(calendar);
        when(pedido.getDataRegistro()).thenReturn(calendar);
        when(andamentoService.verificaAssinatura(1L)).thenReturn(true);

        List<AnexoPedidoDetalhadoDTO> anexoPedidoDetalhadoDTOList = new ArrayList<>();
        anexoPedidoDetalhadoDTOList.add(anexoPedidoDetalhadoDTO);
        when(pedidoDetalhadoDTO.getAnexos()).thenReturn(anexoPedidoDetalhadoDTOList);

        List<Andamento> andamentoList = new ArrayList<>();
        andamentoList.add(andamento);

        when(pedidoRepository.findById(1L)).thenReturn(pedido);
        when(pedido.getAndamentos()).thenReturn(andamentoList);

        pedidoDetalhadoDTO.setDiasUteisMaior10(true);
        DataUtil.getDiasUteis(dataInicial, feriadoRepository, 10);

        when(andamentoRepository.findTopByPedidoIdAndStatusSolicitacaoId(anyLong(), anyLong())).thenReturn(andamento);
        when(andamento.getUnidade()).thenReturn(null);
        when(andamento.getUsuarioAcessosAssinatura()).thenReturn(usuarioAcessos);
        when(usuarioAcessos.getUnidade()).thenReturn(unidade);
        when(unidade.getCodigoUnidade()).thenReturn("codigoUsuairo");

        pedidoService.detalharPedido(1l);
    }

    @Test
    public void montarSolicitanteDTOTest() {
        SolicitanteDTO solicitanteDTO = pedidoService.montarSolicitanteDTO(solicitante);
        assertNotNull(solicitanteDTO);
    }


    @Test
    public void alterarStatusEouvTest() {
        when(pedidoRepository.findOne(anyLong())).thenReturn(pedido);
        when(statusTramitacaoRepository.findOne(anyLong())).thenReturn(statusTramitacao);
        when(statusSolicitacaoRepository.findOne(anyLong())).thenReturn(statusSolicitacao);
        when(pedidoRepository.save(any(Pedido.class))).thenReturn(pedido);
        when(pedidoRepository.findById(anyLong())).thenReturn(pedido);
        when(pedido.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(statusSolicitacao.getId()).thenReturn(1L);
        assertEquals(pedidoService.alterarStatusEouv(eouvDTO), pedido);
    }

    @Test
    public void alterarStatusEouvIfIgualASete(){
        when(pedidoRepository.findOne(anyLong())).thenReturn(pedido);
        when(pedido.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(statusSolicitacao.getId()).thenReturn(7L);
        when(statusTramitacaoRepository.findOne(2L)).thenReturn(statusTramitacao);
        when(statusSolicitacaoRepository.findOne(6L)).thenReturn(statusSolicitacao);
        pedidoService.alterarStatusEouv(eouvDTO);
    }

    @Test
    public void alterarStatusEouvIfIgualASeis(){
        when(pedidoRepository.findOne(anyLong())).thenReturn(pedido);
        when(pedido.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(statusSolicitacao.getId()).thenReturn(6L);
        when(statusTramitacaoRepository.findOne(2L)).thenReturn(statusTramitacao);
        when(statusSolicitacaoRepository.findOne(6L)).thenReturn(statusSolicitacao);
        pedidoService.alterarStatusEouv(eouvDTO);
    }

    @Test
    public void alterarStatusEouvEdicaoTecnico(){
        when(pedidoRepository.findOne(anyLong())).thenReturn(pedido);
        when(pedido.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(statusSolicitacao.getId()).thenReturn(8L);
        when(statusTramitacaoRepository.findOne(2L)).thenReturn(statusTramitacao);
        when(statusSolicitacaoRepository.findOne(6L)).thenReturn(statusSolicitacao);
        pedidoService.alterarStatusEouv(eouvDTO);
    }

    @Test
    public void alterarStatusEouvRespondidas(){
        when(pedidoRepository.findOne(anyLong())).thenReturn(pedido);
        when(pedido.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(statusSolicitacao.getId()).thenReturn(9L);
        when(statusTramitacaoRepository.findOne(3L)).thenReturn(statusTramitacao);
        when(statusSolicitacaoRepository.findOne(2L)).thenReturn(statusSolicitacao);
        pedidoService.alterarStatusEouv(eouvDTO);
    }

    @Test
    public void alterarStatusFinalizarEouvTest() throws IntegracaoException {
        when(pedidoRepository.findOne(anyLong())).thenReturn(pedido);
        when(statusTramitacaoRepository.findOne(anyLong())).thenReturn(statusTramitacao);
        when(statusSolicitacaoRepository.findOne(anyLong())).thenReturn(statusSolicitacao);
        when(pedidoRepository.save(any(Pedido.class))).thenReturn(pedido);
        assertEquals(pedidoService.alterarStatusFinalizarEouv(1l), pedido);
    }

    @Test
    public void enviarPedidoRevisaoTest() throws IntegracaoException {
        when(pedidoRepository.findById(anyLong())).thenReturn(pedido);
        when(statusTramitacaoRepository.findOne(4L)).thenReturn(statusTramitacao);
        when(statusSolicitacaoRepository.findOne(4L)).thenReturn(statusSolicitacao);
        when(unidadeRepository.findByCodigoUnidade("0000")).thenReturn(unidade);
        when(pedidoRepository.save(any(Pedido.class))).thenReturn(pedido);
        pedidoService.enviarPedidoRevisao(3L);
    }

    @Test
    @SneakyThrows
    public void reverterAndamentoPedidoTest() {
        when(pedidoRepository.buscarPedidoEStatusSolicitacao(1L)).thenReturn(pedido);
        when(devolvePedidoDTO.getIdPedido()).thenReturn(1L);
        when(pedido.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(statusSolicitacao.getId()).thenReturn(1L);
        when(subunidadeRepository.findOne(1L)).thenReturn(subunidade);
        List<Andamento> andamentoList = new ArrayList<>();
        andamentoList.add(andamento);
        when(andamentoRepository.recuperarAndamentosPedido(1L)).thenReturn(andamentoList);
        when(devolvePedidoDTO.getIdPedido()).thenReturn(1L);

        when(pedido.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(statusSolicitacao.getNome()).thenReturn("Distribuição PF");
        when(unidadeRepository.findByCodigoUnidade("0000")).thenReturn(unidade);

        when(usuarioLogadoUtil.getPerfil()).thenReturn("FKS.TECNICO");


        pedidoService.reverterAndamentoPedido(devolvePedidoDTO);
    }

    @Test
    @SneakyThrows
    public void reverterAndamentoPedidoTestRevisao() {
        when(pedidoRepository.buscarPedidoEStatusSolicitacao(1L)).thenReturn(pedido);
        when(devolvePedidoDTO.getIdPedido()).thenReturn(1L);
        when(pedido.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(statusSolicitacao.getId()).thenReturn(1L);
        when(subunidadeRepository.findOne(1L)).thenReturn(subunidade);
        List<Andamento> andamentoList = new ArrayList<>();
        andamentoList.add(andamento);
        when(andamentoRepository.recuperarAndamentosPedido(1L)).thenReturn(andamentoList);
        when(devolvePedidoDTO.getIdPedido()).thenReturn(1L);

        when(pedido.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(statusSolicitacao.getNome()).thenReturn("Revisão");
        when(unidadeRepository.findByCodigoUnidade("0000")).thenReturn(unidade);

        when(usuarioLogadoUtil.getPerfil()).thenReturn("FKS.TECNICO");


        pedidoService.reverterAndamentoPedido(devolvePedidoDTO);
    }

    @Test
    @SneakyThrows
    public void reverterAndamentoPedidoTestRespostaAssinada() {
        when(pedidoRepository.buscarPedidoEStatusSolicitacao(1L)).thenReturn(pedido);
        when(devolvePedidoDTO.getIdPedido()).thenReturn(1L);
        when(pedido.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(statusSolicitacao.getId()).thenReturn(1L);
        when(subunidadeRepository.findOne(1L)).thenReturn(subunidade);
        List<Andamento> andamentoList = new ArrayList<>();
        andamentoList.add(andamento);
        when(andamentoRepository.recuperarAndamentosPedido(1L)).thenReturn(andamentoList);
        when(devolvePedidoDTO.getIdPedido()).thenReturn(1L);

        when(pedido.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(statusSolicitacao.getNome()).thenReturn("Resposta Assinada");
        when(andamento.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(statusSolicitacao.getId()).thenReturn(7L);
        List<UsuarioAcessos> usuarioAcessosList = new ArrayList<>();
        usuarioAcessosList.add(usuarioAcessos);
        when(andamento.getUsuarioAcessos()).thenReturn(usuarioAcessosList);

        when(usuarioLogadoUtil.getPerfil()).thenReturn("FKS.TECNICO");

        pedidoService.reverterAndamentoPedido(devolvePedidoDTO);
    }

    @Test
    @SneakyThrows
    public void reverterAndamentoPedidoTestProducaoDeResposta() {
        when(pedidoRepository.buscarPedidoEStatusSolicitacao(1L)).thenReturn(pedido);
        when(devolvePedidoDTO.getIdPedido()).thenReturn(1L);
        when(pedido.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(statusSolicitacao.getId()).thenReturn(1L);
        when(subunidadeRepository.findOne(1L)).thenReturn(subunidade);
        List<Andamento> andamentoList = new ArrayList<>();
        andamentoList.add(andamento);
        when(andamentoRepository.recuperarAndamentosPedido(1L)).thenReturn(andamentoList);
        when(devolvePedidoDTO.getIdPedido()).thenReturn(1L);

        when(pedido.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(statusSolicitacao.getNome()).thenReturn("Produção de Resposta");
        when(usuarioLogadoUtil.getUsuario()).thenReturn(usuarioAcessos);
        when(usuarioAcessos.getUnidade()).thenReturn(unidade);

        when(usuarioLogadoUtil.getPerfil()).thenReturn("FKS.TECNICO");

        pedidoService.reverterAndamentoPedido(devolvePedidoDTO);
    }

    @Test
    @SneakyThrows
    public void reverterAndamentoPedidoTestParaRevisao() {
        when(pedidoRepository.buscarPedidoEStatusSolicitacao(1L)).thenReturn(pedido);
        when(devolvePedidoDTO.getIdPedido()).thenReturn(1L);
        when(pedido.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(statusSolicitacao.getId()).thenReturn(1L);
        when(subunidadeRepository.findOne(1L)).thenReturn(subunidade);
        List<Andamento> andamentoList = new ArrayList<>();
        andamentoList.add(andamento);
        when(andamentoRepository.recuperarAndamentosPedido(1L)).thenReturn(andamentoList);
        when(devolvePedidoDTO.getIdPedido()).thenReturn(1L);

        when(pedido.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(statusSolicitacao.getNome()).thenReturn("Para Envio");
        when(usuarioLogadoUtil.getUsuario()).thenReturn(usuarioAcessos);
        when(usuarioAcessos.getUnidade()).thenReturn(unidade);

        when(usuarioLogadoUtil.getPerfil()).thenReturn("FKS.TECNICO");

        pedidoService.reverterAndamentoPedido(devolvePedidoDTO);
    }

    @Test
    public void reverterAndamentoPedidoTestEdicaoTecnico() throws IntegracaoException {
        when(pedidoRepository.buscarPedidoEStatusSolicitacao(1L)).thenReturn(pedido);
        when(devolvePedidoDTO.getIdPedido()).thenReturn(1L);
        when(pedido.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(statusSolicitacao.getId()).thenReturn(1L);
        when(subunidadeRepository.findOne(1L)).thenReturn(subunidade);
        List<Andamento> andamentoList = new ArrayList<>();
        andamentoList.add(andamento);
        andamentoList.add(andamento);
        andamentoList.add(andamento);
        when(andamentoRepository.recuperarAndamentosPedido(1L)).thenReturn(andamentoList);
        when(devolvePedidoDTO.getIdPedido()).thenReturn(1L);

        when(pedido.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(statusSolicitacao.getNome()).thenReturn("Edição Técnico");
        when(usuarioAcessosRepository.findFirstByCpfUsuario(anyString())).thenReturn(usuarioAcessos);
        when(andamentoList1.get(10)).thenReturn(andamento);

        List<UsuarioAcessos> usuarioAcessosList = new ArrayList<>();
        usuarioAcessosList.add(usuarioAcessos);
        when(andamento.getUsuarioAcessos()).thenReturn(usuarioAcessosList);

        when(usuarioLogadoUtil.getPerfil()).thenReturn("FKS.TECNICO");

        pedidoService.reverterAndamentoPedido(devolvePedidoDTO);
    }

    @Test
    @SneakyThrows
    public void reverterAndamentoPedidoTestParaEnvio() {
        when(pedidoRepository.buscarPedidoEStatusSolicitacao(1L)).thenReturn(pedido);
        when(devolvePedidoDTO.getIdPedido()).thenReturn(1L);
        when(pedido.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(statusSolicitacao.getId()).thenReturn(1L);
        when(subunidadeRepository.findOne(1L)).thenReturn(subunidade);
        List<Andamento> andamentoList = new ArrayList<>();
        andamentoList.add(andamento);
        when(andamentoRepository.recuperarAndamentosPedido(1L)).thenReturn(andamentoList);
        when(devolvePedidoDTO.getIdPedido()).thenReturn(1L);

        when(pedido.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(statusSolicitacao.getNome()).thenReturn("Para Envio");
        when(usuarioAcessosRepository.findFirstByCpfUsuario(anyString())).thenReturn(usuarioAcessos);
        when(subunidade.getUnidade()).thenReturn(unidade);

        when(usuarioLogadoUtil.getPerfil()).thenReturn("FKS.TECNICO");

        pedidoService.reverterAndamentoPedido(devolvePedidoDTO);
    }

    @Test
    @SneakyThrows
    public void reverterAndamentoPedidoTestReverterAndamento4() {
        when(pedidoRepository.buscarPedidoEStatusSolicitacao(1L)).thenReturn(pedido);
        when(devolvePedidoDTO.getIdPedido()).thenReturn(1L);
        when(pedido.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(statusSolicitacao.getId()).thenReturn(1L);
        when(subunidadeRepository.findOne(1L)).thenReturn(subunidade);
        List<Andamento> andamentoList = new ArrayList<>();
        andamentoList.add(andamento);
        when(andamentoRepository.recuperarAndamentosPedido(1L)).thenReturn(andamentoList);
        when(devolvePedidoDTO.getIdPedido()).thenReturn(1L);

        when(pedido.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(statusSolicitacao.getNome()).thenReturn("teste");

        when(usuarioLogadoUtil.getPerfil()).thenReturn("FKS.TECNICO");

        pedidoService.reverterAndamentoPedido(devolvePedidoDTO);
    }

    @Test
    @SneakyThrows
    public void reverterAndamentoPedidoTestReverterAndamento4If() {
        when(pedidoRepository.buscarPedidoEStatusSolicitacao(1L)).thenReturn(pedido);
        when(devolvePedidoDTO.getIdPedido()).thenReturn(1L);
        when(pedido.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(statusSolicitacao.getId()).thenReturn(1L);
        when(subunidadeRepository.findOne(1L)).thenReturn(subunidade);
        List<Andamento> andamentoList = new ArrayList<>();
        andamentoList.add(andamento);
        when(andamentoRepository.recuperarAndamentosPedido(1L)).thenReturn(andamentoList);
        when(devolvePedidoDTO.getIdPedido()).thenReturn(1L);

        when(pedido.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(statusSolicitacao.getNome()).thenReturn("teste");
        when(pedido.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(statusSolicitacao.getNome()).thenReturn("Resposta SIC");
        when(devolvePedidoDTO.getNomeStatusSolicitacao()).thenReturn("Distribuição PF");
        when(andamento.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(statusSolicitacao.getId()).thenReturn(3L);
        when(andamento.getUnidade()).thenReturn(unidade);

        when(usuarioLogadoUtil.getPerfil()).thenReturn("FKS.TECNICO");

        pedidoService.reverterAndamentoPedido(devolvePedidoDTO);
    }

    @Test
    @SneakyThrows
    public void reverterAndamentoPedidoTestReverterAndamento4If2() {
        when(pedidoRepository.buscarPedidoEStatusSolicitacao(1L)).thenReturn(pedido);
        when(devolvePedidoDTO.getIdPedido()).thenReturn(1L);
        when(pedido.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(statusSolicitacao.getId()).thenReturn(1L);
        when(subunidadeRepository.findOne(1L)).thenReturn(subunidade);
        List<Andamento> andamentoList = new ArrayList<>();
        andamentoList.add(andamento);
        when(andamentoRepository.recuperarAndamentosPedido(1L)).thenReturn(andamentoList);
        when(devolvePedidoDTO.getIdPedido()).thenReturn(1L);

        when(pedido.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(statusSolicitacao.getNome()).thenReturn("teste");
        when(pedido.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(statusSolicitacao.getNome()).thenReturn("Resposta SIC");
        when(devolvePedidoDTO.getNomeStatusSolicitacao()).thenReturn("Distribuição PF");
        when(andamento.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(statusSolicitacao.getId()).thenReturn(1L);

        when(usuarioLogadoUtil.getPerfil()).thenReturn("FKS.TECNICO");

        pedidoService.reverterAndamentoPedido(devolvePedidoDTO);
    }

    @Test
    @SneakyThrows
    public void reverterAndamentoPedidoTestReverterAndamento4ElseIf() {
        when(pedidoRepository.buscarPedidoEStatusSolicitacao(1L)).thenReturn(pedido);
        when(devolvePedidoDTO.getIdPedido()).thenReturn(1L);
        when(pedido.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(statusSolicitacao.getId()).thenReturn(1L);
        when(subunidadeRepository.findOne(1L)).thenReturn(subunidade);
        List<Andamento> andamentoList = new ArrayList<>();
        andamentoList.add(andamento);
        when(andamentoRepository.recuperarAndamentosPedido(1L)).thenReturn(andamentoList);
        when(devolvePedidoDTO.getIdPedido()).thenReturn(1L);

        when(pedido.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(statusSolicitacao.getNome()).thenReturn("teste");
        when(pedido.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(statusSolicitacao.getNome()).thenReturn("Resposta SIC");
        when(devolvePedidoDTO.getNomeStatusSolicitacao()).thenReturn("Resposta Assinada");
        when(andamento.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(statusSolicitacao.getId()).thenReturn(6L);

        when(usuarioLogadoUtil.getPerfil()).thenReturn("FKS.TECNICO");

        pedidoService.reverterAndamentoPedido(devolvePedidoDTO);
    }

    @Test
    @SneakyThrows
    public void reverterAndamentoPedidoTestReverterAndamentoElseIfEdicaoTecnico() {
        when(pedidoRepository.buscarPedidoEStatusSolicitacao(1L)).thenReturn(pedido);
        when(devolvePedidoDTO.getIdPedido()).thenReturn(1L);
        when(pedido.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(statusSolicitacao.getId()).thenReturn(1L);
        when(subunidadeRepository.findOne(1L)).thenReturn(subunidade);
        List<Andamento> andamentoList = new ArrayList<>();
        andamentoList.add(andamento);
        when(andamentoRepository.recuperarAndamentosPedido(1L)).thenReturn(andamentoList);
        when(devolvePedidoDTO.getIdPedido()).thenReturn(1L);

        when(pedido.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(statusSolicitacao.getNome()).thenReturn("teste");
        when(pedido.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(statusSolicitacao.getNome()).thenReturn("Resposta SIC");
        when(devolvePedidoDTO.getNomeStatusSolicitacao()).thenReturn("Resposta Assinada");
        when(andamento.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(statusSolicitacao.getId()).thenReturn(8L);

        when(usuarioLogadoUtil.getPerfil()).thenReturn("FKS.TECNICO");

        pedidoService.reverterAndamentoPedido(devolvePedidoDTO);
    }

    @Test
    @SneakyThrows
    public void reverterAndamentoPedidoTestReverterAndamentoElseIfEnvio() {
        when(pedidoRepository.buscarPedidoEStatusSolicitacao(1L)).thenReturn(pedido);
        when(devolvePedidoDTO.getIdPedido()).thenReturn(1L);
        when(pedido.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(statusSolicitacao.getId()).thenReturn(1L);
        when(subunidadeRepository.findOne(1L)).thenReturn(subunidade);
        List<Andamento> andamentoList = new ArrayList<>();
        andamentoList.add(andamento);
        when(andamentoRepository.recuperarAndamentosPedido(1L)).thenReturn(andamentoList);
        when(devolvePedidoDTO.getIdPedido()).thenReturn(1L);

        when(pedido.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(statusSolicitacao.getNome()).thenReturn("teste");
        when(pedido.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(statusSolicitacao.getNome()).thenReturn("Resposta SIC");
        when(devolvePedidoDTO.getNomeStatusSolicitacao()).thenReturn("Resposta Assinada");
        when(andamento.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(statusSolicitacao.getId()).thenReturn(5L);

        when(usuarioLogadoUtil.getPerfil()).thenReturn("FKS.TECNICO");

        pedidoService.reverterAndamentoPedido(devolvePedidoDTO);
    }

    @Test
    @SneakyThrows
    public void reverterAndamentoPedidoTestReverterAndamento4ElseIf2() {
        when(pedidoRepository.buscarPedidoEStatusSolicitacao(1L)).thenReturn(pedido);
        when(devolvePedidoDTO.getIdPedido()).thenReturn(1L);
        when(pedido.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(statusSolicitacao.getId()).thenReturn(1L);
        when(subunidadeRepository.findOne(1L)).thenReturn(subunidade);
        List<Andamento> andamentoList = new ArrayList<>();
        andamentoList.add(andamento);
        when(andamentoRepository.recuperarAndamentosPedido(1L)).thenReturn(andamentoList);
        when(devolvePedidoDTO.getIdPedido()).thenReturn(1L);

        when(pedido.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(statusSolicitacao.getNome()).thenReturn("teste");
        when(pedido.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(statusSolicitacao.getNome()).thenReturn("Resposta SIC");
        when(devolvePedidoDTO.getNomeStatusSolicitacao()).thenReturn("Resposta Assinada");
        when(andamento.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(statusSolicitacao.getId()).thenReturn(1L);

        when(usuarioLogadoUtil.getPerfil()).thenReturn("FKS.TECNICO");

        pedidoService.reverterAndamentoPedido(devolvePedidoDTO);
    }

    @Test
    @SneakyThrows
    public void reverterAndamentoPedidoTestRespostaSic() {
        when(pedidoRepository.buscarPedidoEStatusSolicitacao(1L)).thenReturn(pedido);
        when(devolvePedidoDTO.getIdPedido()).thenReturn(1L);
        when(pedido.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(statusSolicitacao.getId()).thenReturn(1L);
        when(subunidadeRepository.findOne(1L)).thenReturn(subunidade);
        List<Andamento> andamentoList = new ArrayList<>();
        andamentoList.add(andamento);
        when(andamentoRepository.recuperarAndamentosPedido(1L)).thenReturn(andamentoList);
        when(devolvePedidoDTO.getIdPedido()).thenReturn(1L);

        when(pedido.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(statusSolicitacao.getNome()).thenReturn("Resposta SIC");
        when(devolvePedidoDTO.getNomeStatusSolicitacao()).thenReturn("Triagem SIC");
        when(usuarioAcessosRepository.findFirstByCpfUsuario(anyString())).thenReturn(usuarioAcessos);
        when(usuarioAcessos.getUnidade()).thenReturn(unidade);

        when(usuarioLogadoUtil.getPerfil()).thenReturn("teste");
        when(pedido.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(statusSolicitacao.getId()).thenReturn(7L);

        pedidoService.reverterAndamentoPedido(devolvePedidoDTO);
    }

    @Test
    @SneakyThrows
    public void reverterAndamentoPedidoTestRespostaSic1() {
        when(pedidoRepository.buscarPedidoEStatusSolicitacao(1L)).thenReturn(pedido);
        when(devolvePedidoDTO.getIdPedido()).thenReturn(1L);
        when(pedido.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(statusSolicitacao.getId()).thenReturn(1L);
        when(subunidadeRepository.findOne(1L)).thenReturn(subunidade);
        List<Andamento> andamentoList = new ArrayList<>();
        andamentoList.add(andamento);
        when(andamentoRepository.recuperarAndamentosPedido(1L)).thenReturn(andamentoList);
        when(devolvePedidoDTO.getIdPedido()).thenReturn(1L);

        when(pedido.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(statusSolicitacao.getNome()).thenReturn("Resposta SIC");
        when(devolvePedidoDTO.getNomeStatusSolicitacao()).thenReturn("Triagem SIC");
        when(usuarioAcessosRepository.findFirstByCpfUsuario(anyString())).thenReturn(usuarioAcessos);
        when(usuarioAcessos.getUnidade()).thenReturn(unidade);

        when(usuarioLogadoUtil.getPerfil()).thenReturn("FKS.PONTO.FOCAL");
        when(pedido.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(statusSolicitacao.getId()).thenReturn(7L);

        pedidoService.reverterAndamentoPedido(devolvePedidoDTO);
    }

    @Test
    @SneakyThrows
    public void reverterAndamentoPedidoTestRespostaSic2() {
        when(pedidoRepository.buscarPedidoEStatusSolicitacao(1L)).thenReturn(pedido);
        when(devolvePedidoDTO.getIdPedido()).thenReturn(1L);
        when(pedido.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(statusSolicitacao.getId()).thenReturn(1L);
        when(subunidadeRepository.findOne(1L)).thenReturn(subunidade);
        List<Andamento> andamentoList = new ArrayList<>();
        andamentoList.add(andamento);
        when(andamentoRepository.recuperarAndamentosPedido(1L)).thenReturn(andamentoList);
        when(devolvePedidoDTO.getIdPedido()).thenReturn(1L);

        when(pedido.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(statusSolicitacao.getNome()).thenReturn("Resposta SIC");
        when(devolvePedidoDTO.getNomeStatusSolicitacao()).thenReturn("Triagem SIC");
        when(usuarioAcessosRepository.findFirstByCpfUsuario(anyString())).thenReturn(usuarioAcessos);
        when(usuarioAcessos.getUnidade()).thenReturn(unidade);

        when(statusSolicitacao.getId()).thenReturn(4L);

        when(usuarioLogadoUtil.getPerfil()).thenReturn("teste");

        pedidoService.reverterAndamentoPedido(devolvePedidoDTO);
    }

    @Test
    @SneakyThrows
    public void reverterAndamentoPedidoTestRespostaSic3() {
        when(pedidoRepository.buscarPedidoEStatusSolicitacao(1L)).thenReturn(pedido);
        when(devolvePedidoDTO.getIdPedido()).thenReturn(1L);
        when(pedido.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(statusSolicitacao.getId()).thenReturn(1L);
        when(subunidadeRepository.findOne(1L)).thenReturn(subunidade);
        List<Andamento> andamentoList = new ArrayList<>();
        andamentoList.add(andamento);
        when(andamentoRepository.recuperarAndamentosPedido(1L)).thenReturn(andamentoList);
        when(devolvePedidoDTO.getIdPedido()).thenReturn(1L);

        when(pedido.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(statusSolicitacao.getNome()).thenReturn("Resposta SIC");
        when(devolvePedidoDTO.getNomeStatusSolicitacao()).thenReturn("Triagem SIC");
        when(usuarioAcessosRepository.findFirstByCpfUsuario(anyString())).thenReturn(usuarioAcessos);
        when(usuarioAcessos.getUnidade()).thenReturn(unidade);

        when(statusSolicitacao.getId()).thenReturn(2L);

        when(usuarioLogadoUtil.getPerfil()).thenReturn("teste");

        pedidoService.reverterAndamentoPedido(devolvePedidoDTO);
    }

    @Test
    @SneakyThrows
    public void reverterAndamentoPedidoTestRespostaSic4() {
        when(pedidoRepository.buscarPedidoEStatusSolicitacao(1L)).thenReturn(pedido);
        when(devolvePedidoDTO.getIdPedido()).thenReturn(1L);
        when(pedido.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(statusSolicitacao.getId()).thenReturn(1L);
        when(subunidadeRepository.findOne(1L)).thenReturn(subunidade);
        List<Andamento> andamentoList = new ArrayList<>();
        andamentoList.add(andamento);
        when(andamentoRepository.recuperarAndamentosPedido(1L)).thenReturn(andamentoList);
        when(devolvePedidoDTO.getIdPedido()).thenReturn(1L);

        when(pedido.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(statusSolicitacao.getNome()).thenReturn("Resposta SIC");
        when(devolvePedidoDTO.getNomeStatusSolicitacao()).thenReturn("Triagem SIC");
        when(usuarioAcessosRepository.findFirstByCpfUsuario(anyString())).thenReturn(usuarioAcessos);
        when(usuarioAcessos.getUnidade()).thenReturn(unidade);

        when(statusSolicitacao.getId()).thenReturn(2L);

        when(andamentoRepository.recuperarAndamentosPedido(1L)).thenReturn(andamentoList);
        when(pedido.getId()).thenReturn(1L);
        when(andamento.getStatusSolicitacao()).thenReturn(statusSolicitacao);

        when(usuarioLogadoUtil.getPerfil()).thenReturn("teste");

        pedidoService.reverterAndamentoPedido(devolvePedidoDTO);
    }

    @Test
    @SneakyThrows
    public void exportarConsultaPedidoTestTry() {
        PowerMockito.mockStatic(XSSFCell.class);
        List<Pedido> listaPedido = new ArrayList<>();
        listaPedido.add(pedido);
        when(pedidoCustomRepositorio.efetuarConsultaPaginadaPedido(filtroPedidoDTO, true)).thenReturn(listaPedido);

        when(pedido.getProtocolo()).thenReturn("protocolo");
        when(pedido.getStatusTramitacao()).thenReturn(statusTramitacao);
        when(statusTramitacao.getNome()).thenReturn("statusTramitacao");
        when(pedido.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(statusSolicitacao.getNome()).thenReturn("stautsSolicitacao");
        List<Andamento> andamentoList = new ArrayList<>();
        andamentoList.add(andamento);
        andamentoList.add(andamento);
        when(pedido.getAndamentos()).thenReturn(andamentoList);

        when(pedido.getSolicitante()).thenReturn(solicitante);
        when(solicitante.getNome()).thenReturn("nome");
        when(pedido.getResumoSolicitacao()).thenReturn("resumoSolicitacao");
        when(pedido.getDescricaoPedido()).thenReturn("descricaoPedido");
        when(pedido.getRespostaEsic()).thenReturn("respostaEsic");


        when(pedido.getSituacaoPedido()).thenReturn(situacaoPedido);
        when(pedido.getSolicitante()).thenReturn(solicitante);
        when(xssfWorkbook.createSheet()).thenReturn(xssfSheet);
        when(xssfSheet.createRow(5)).thenReturn(xssfRow);
        when(xssfRow.createCell(5)).thenReturn(xssfCell);
        pedidoService.exportarConsultaPedido(filtroPedidoDTO);
    }

    @Test
    @SneakyThrows
    public void exportarConsultaPedidoTestCatch() {
        PowerMockito.mockStatic(XSSFCell.class);
        List<Pedido> listaPedido = new ArrayList<>();
        listaPedido.add(pedido);
        when(pedido.getSituacaoPedido()).thenReturn(situacaoPedido);
        when(pedido.getSolicitante()).thenReturn(solicitante);
        when(xssfWorkbook.createSheet()).thenReturn(xssfSheet);
        when(xssfSheet.createRow(5)).thenReturn(xssfRow);
        when(xssfRow.createCell(5)).thenReturn(xssfCell);
        when(poixmlDocument.getPackage()).thenReturn(opcPackage);
        Mockito.doThrow(IOException.class).when(xssfWorkbook).write(null);
        Mockito.doThrow(IOException.class).when(xssfWorkbook).close();
        pedidoService.exportarConsultaPedido(filtroPedidoDTO);

    }

    @Test
    @SneakyThrows
    public void entregarRespostaTest() {
        when(pedidoRepository.findOne(anyLong())).thenReturn(pedido);
        when(statusTramitacaoRepository.findOne(5L)).thenReturn(statusTramitacao);
        when(statusSolicitacaoRepository.findOne(9L)).thenReturn(statusSolicitacao);
        when(situacaoPedidoRepository.findOne(1L)).thenReturn(situacaoPedido);
        when(pedidoRepository.save(any(Pedido.class))).thenReturn(pedido);
        pedidoService.entregarResposta(anyLong());
    }

    @Test
    public void buscarRespostaPedidoTestNull() {
        when(pedidoRepository.findById(1L)).thenReturn(pedido);
        pedidoService.buscarRespostaPedido(1L);
    }

    @Test
    public void buscarRespostaPedidoTest() {
        when(pedidoRepository.findById(1L)).thenReturn(pedido);
        when(historicoTratamentoService.recuperarRespostaPedidoPerfil(1L)).thenReturn("pedido");
        pedidoService.buscarRespostaPedido(1L);
    }

    @Test
    public void salvarRespostaClassificadaTest() {
        when(respostaClassificadaDTO.getId()).thenReturn(5L);
        when(pedidoRepository.findById(anyLong())).thenReturn(pedido);
        when(respostaClassificadaDTO.getListaClassificacaoResposta()).thenReturn(classificacaoRespostaList);
        when(classificacaoRespostaRepository.save(anyList())).thenReturn(classificacaoRespostaList);
        when(pedidoRepository.save(any(Pedido.class))).thenReturn(pedido);
        pedidoService.salvarRespostaClassificada(respostaClassificadaDTO);
    }

    @Test
    @SneakyThrows
    public void cancelarRespostaTest() {
        when(pedidoRepository.findById(1L)).thenReturn(pedido);
        List<HistoricoTratamento> listaHistoricoTratamento = new ArrayList<>();
        listaHistoricoTratamento.add(historicoTratamento);
        when(historicoTratamentoRepository.recuperarHistoricoPorIdPedido(anyLong())).thenReturn(listaHistoricoTratamento);
        Mockito.doNothing().when(historicoTratamentoRepository).delete(anyLong());
        pedidoService.cancelarResposta(1L);
    }

    @Test
    @SneakyThrows
    public void salvarRespostaTestIf() {
        when(pedidoRepository.findById(anyLong())).thenReturn(pedido);
        when(pedido.getRespostaEsic()).thenReturn(null);
        when(respostaPedidoDTO.getRespostaPedido()).thenReturn("Teste");
        Mockito.doNothing().when(historicoTratamentoService).gerarHistoricoTratamento(pedido, 2L, true);
        when(pedidoRepository.save(pedido)).thenReturn(pedido);
        pedidoService.salvarResposta(respostaPedidoDTO);
    }

    @Test
    @SneakyThrows
    public void salvarRespostaTestElse() {
        when(pedidoRepository.findById(anyLong())).thenReturn(pedido);
        when(pedido.getRespostaEsic()).thenReturn("teste");
        when(respostaPedidoDTO.getRespostaPedido()).thenReturn("Teste");
        Mockito.doNothing().when(historicoTratamentoService).gerarHistoricoTratamento(pedido, 2L, true);
        when(pedidoRepository.save(pedido)).thenReturn(pedido);
        pedidoService.salvarResposta(respostaPedidoDTO);
    }

    @Test
    public void verificaSeRespostaEClassificadaTest() {
        when(pedidoRepository.findById(1L)).thenReturn(pedido);
        pedidoService.verificaSeRespostaEClassificada(1L);
    }

    @Test
    public void verificaSePossuiClassificacaoRespostaESicTest() {
        when(pedidoRepository.findById(1L)).thenReturn(pedido);
        pedidoService.verificaSePossuiClassificacaoRespostaESic(1L);
    }

    @Test
    public void consultarStatusRecursoTest() {
        when(pedidoRepository.buscarPedidoEStatusSolicitacao(1L)).thenReturn(pedido);
        when(andamentoRepository.recuperarAndamentosPedido(1L)).thenReturn(andamentoList);
        when(andamentoList.get(1)).thenReturn(andamento);
        when(pedido.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(statusSolicitacao.getId()).thenReturn(4L);
        pedidoService.consultarStatusRecurso(1L);
    }

    @Test
    public void consultarStatusRecursoTest2() {
        when(pedidoRepository.buscarPedidoEStatusSolicitacao(1L)).thenReturn(pedido);
        when(andamentoRepository.recuperarAndamentosPedido(1L)).thenReturn(andamentoList);
        when(andamentoList.get(1)).thenReturn(andamento);
        when(pedido.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(statusSolicitacao.getId()).thenReturn(3L);
        pedidoService.consultarStatusRecurso(1L);
    }

    @Test
    public void consultarStatusRecursoTest3() {
        when(pedidoRepository.buscarPedidoEStatusSolicitacao(1L)).thenReturn(pedido);
        when(andamentoRepository.recuperarAndamentosPedido(1L)).thenReturn(andamentoList);
        when(andamentoList.get(1)).thenReturn(andamento);
        when(pedido.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(statusSolicitacao.getId()).thenReturn(6L);
        pedidoService.consultarStatusRecurso(1L);
    }

    @Test
    public void consultarStatusRecursoTest4() {
        when(pedidoRepository.buscarPedidoEStatusSolicitacao(1L)).thenReturn(pedido);
        when(andamentoRepository.recuperarAndamentosPedido(1L)).thenReturn(andamentoList);
        when(andamentoList.get(1)).thenReturn(andamento);
        when(pedido.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(andamento.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(statusSolicitacao.getId()).thenReturn(1L);
        when(statusSolicitacao.getId()).thenReturn(2L);
        pedidoService.consultarStatusRecurso(1L);
    }

    @Test
    public void consultarStatusRecursoTest5() {
        when(pedidoRepository.buscarPedidoEStatusSolicitacao(1L)).thenReturn(pedido);
        when(andamentoRepository.recuperarAndamentosPedido(1L)).thenReturn(andamentoList);
        when(andamentoList.get(1)).thenReturn(andamento);
        when(pedido.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(andamento.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(statusSolicitacao.getId()).thenReturn(6L);
        when(statusSolicitacao.getId()).thenReturn(2L);
        pedidoService.consultarStatusRecurso(1L);
    }

    @Test
    public void consultarStatusRecursoTest6() {
        when(pedidoRepository.buscarPedidoEStatusSolicitacao(1L)).thenReturn(pedido);
        when(andamentoRepository.recuperarAndamentosPedido(1L)).thenReturn(andamentoList);
        when(andamentoList.get(1)).thenReturn(andamento);
        when(pedido.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(andamento.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(statusSolicitacao.getId()).thenReturn(3L);
        when(statusSolicitacao.getId()).thenReturn(2L);
        pedidoService.consultarStatusRecurso(1L);
    }

    @Test
    public void consultarStatusRecursoTest7() {
        when(pedidoRepository.buscarPedidoEStatusSolicitacao(1L)).thenReturn(pedido);
        when(andamentoRepository.recuperarAndamentosPedido(1L)).thenReturn(andamentoList);
        when(andamentoList.get(1)).thenReturn(andamento);
        when(pedido.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(statusSolicitacao.getId()).thenReturn(5L);
        pedidoService.consultarStatusRecurso(1L);
    }

    @Test
    public void consultarStatusRecursoTestverificaStatusDevolucaoVerificacao() {
        when(pedidoRepository.buscarPedidoEStatusSolicitacao(1L)).thenReturn(pedido);
        when(andamentoRepository.recuperarAndamentosPedido(1L)).thenReturn(andamentoList);
        when(andamentoList.get(1)).thenReturn(andamento);
        when(pedido.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(andamento.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(statusSolicitacao.getId()).thenReturn(3L);
        when(statusSolicitacao.getId()).thenReturn(2L);

        List<Andamento> andamentoList = new ArrayList<>();
        andamentoList.add(andamento);
        andamentoList.add(andamento);
        andamentoList.add(andamento);
        when(andamentoRepository.recuperarAndamentosPedido(5L)).thenReturn(andamentoList);
        when(pedido.getId()).thenReturn(5L);

        pedidoService.consultarStatusRecurso(1L);
    }

    @Test
    public void consultarStatusRecursoTestVerificaStatusDevolucaoParte2ProducaoResposta() {
        when(pedidoRepository.buscarPedidoEStatusSolicitacao(1L)).thenReturn(pedido);
        when(andamentoRepository.recuperarAndamentosPedido(1L)).thenReturn(andamentoList);
        when(andamentoList.get(1)).thenReturn(andamento);
        when(pedido.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(andamento.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(statusSolicitacao.getId()).thenReturn(3L);
        when(statusSolicitacao.getId()).thenReturn(2L);

        List<Andamento> andamentoList = new ArrayList<>();
        andamentoList.add(andamento);
        andamentoList.add(andamento);
        andamentoList.add(andamento);
        when(andamentoRepository.recuperarAndamentosPedido(1L)).thenReturn(andamentoList);
        when(pedido.getId()).thenReturn(1L);

        when(pedido.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(statusSolicitacao.getId()).thenReturn(7L);

        pedidoService.consultarStatusRecurso(1L);
    }

    @Test
    public void consultarStatusRecursoTestVerificaStatusDevolucaoParte2ParaEnvio() {
        when(pedidoRepository.buscarPedidoEStatusSolicitacao(1L)).thenReturn(pedido);
        when(andamentoRepository.recuperarAndamentosPedido(1L)).thenReturn(andamentoList);
        when(andamentoList.get(1)).thenReturn(andamento);
        when(pedido.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(andamento.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(statusSolicitacao.getId()).thenReturn(3L);
        when(statusSolicitacao.getId()).thenReturn(2L);

        List<Andamento> andamentoList = new ArrayList<>();
        andamentoList.add(andamento);
        andamentoList.add(andamento);
        andamentoList.add(andamento);
        when(andamentoRepository.recuperarAndamentosPedido(1L)).thenReturn(andamentoList);
        when(pedido.getId()).thenReturn(1L);

        when(pedido.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(statusSolicitacao.getId()).thenReturn(5L);

        pedidoService.consultarStatusRecurso(1L);
    }

    @Test
    public void consultarStatusRecursoTestVerificaStatusDevolucaoParte2Edicao() {
        when(pedidoRepository.buscarPedidoEStatusSolicitacao(1L)).thenReturn(pedido);
        when(andamentoRepository.recuperarAndamentosPedido(1L)).thenReturn(andamentoList);
        when(andamentoList.get(1)).thenReturn(andamento);
        when(pedido.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(andamento.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(statusSolicitacao.getId()).thenReturn(3L);
        when(statusSolicitacao.getId()).thenReturn(2L);

        List<Andamento> andamentoList = new ArrayList<>();
        andamentoList.add(andamento);
        andamentoList.add(andamento);
        andamentoList.add(andamento);
        when(andamentoRepository.recuperarAndamentosPedido(1L)).thenReturn(andamentoList);
        when(pedido.getId()).thenReturn(1L);

        when(pedido.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(statusSolicitacao.getId()).thenReturn(8L);

        pedidoService.consultarStatusRecurso(1L);
    }

    @Test
    public void consultarStatusRespostaAssinadaTestTrue() {
        when(pedidoRepository.findOne(1L)).thenReturn(pedido);
        when(pedido.getStatusRespostaAssinada()).thenReturn(true);
        pedidoService.consultarStatusRespostaAssinada(1L);
    }

    @Test
    public void consultarStatusRespostaAssinadaTestFalse() {
        when(pedidoRepository.findOne(1L)).thenReturn(pedido);
        when(pedido.getStatusRespostaAssinada()).thenReturn(false);
        pedidoService.consultarStatusRespostaAssinada(1L);
    }

    @Test
    public void buscarStatusSolicitacaoTest() {
        when(pedidoRepository.findOne(1L)).thenReturn(pedido);
        when(pedido.getId()).thenReturn(1L);
        when(pedido.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(statusSolicitacao.getNome()).thenReturn("teste");
        pedidoService.buscarStatusSolicitacao(1L);
    }

    @Test
    public void verificaTemaTest() {
        when(pedidoRepository.findById(1L)).thenReturn(pedido);
        when(pedido.getTema()).thenReturn(tema);
        pedidoService.verificaTema(1L);
    }

    @Test
    public void verificaTemaTestTemaNulo() {
        when(pedidoRepository.findById(1L)).thenReturn(pedido);
        when(pedido.getTema()).thenReturn(null);
        pedidoService.verificaTema(1L);
    }

    @Test
    public void associarPedidoTemaTest() {
        List<SubtemaDTO> subtemaDTOs = new ArrayList<>();
        subtemaDTOs.add(subtemaDTO);
        subtemaDTOs.add(subtemaDTO);
        subtemaDTOs.add(subtemaDTO);
        when(pedidoTemaDTO.getIdPedido()).thenReturn(1L);
        when(pedidoRepository.findById(1L)).thenReturn(pedido);
        when(pedidoTemaDTO.getIdTema()).thenReturn(2L);
        when(temaRepository.findById(2L)).thenReturn(tema);
        when(pedidoTemaDTO.getSubtemaDTO()).thenReturn(subtemaDTOs);
        when(pedidoTemaDTO.getIdTema()).thenReturn(1L);
        when(temaRepository.findById(1L)).thenReturn(tema);
        when(pedidoTemaDTO.getPalavrasChaves()).thenReturn(palavraChaveList);
        pedidoService.associarPedidoTema(pedidoTemaDTO);
    }

    @Test
    public void ordenaAndamentosDoPedido() {
        when(pedidoRepository.findById(1L)).thenReturn(pedido);
        pedidoService.ordenaAndamentosDoPedido(1L);
    }

    @Test
    public void ordenaAndamentoDoPedido() {
        when(pedidoRepository.findById(1L)).thenReturn(pedido);
        pedidoService.ordenaAndamentoDoPedido(1L);
    }

    @Test
    public void buscarUltimaUnidade3() {
        when(pedidoRepository.findById(1L)).thenReturn(pedido);
        when(andamentoList.size()).thenReturn(1);
        when(pedido.getAndamentos()).thenReturn(andamentoList);
        when(andamentoList.get(0)).thenReturn(andamento);
        when(andamento.getStatusRespostaAssinada()).thenReturn(false);
        when(andamento.getUnidade()).thenReturn(unidade);
        pedidoService.buscarUltimaUnidade(1L);
    }

    @Test
    public void buscarUltimaUnidadeTrue() {
        when(pedidoRepository.findById(1L)).thenReturn(pedido);
        when(andamentoList.size()).thenReturn(1);
        when(pedido.getAndamentos()).thenReturn(andamentoList);
        when(andamentoList.get(anyInt())).thenReturn(andamento);
        when(andamento.getStatusRespostaAssinada()).thenReturn(true);
        when(andamentoList.get(90)).thenReturn(andamento);
        when(andamento.getUnidade()).thenReturn(unidade);
        pedidoService.buscarUltimaUnidade(1L);
    }

    @Test
    public void buscarUltimaUnidade2() {
        when(pedidoRepository.findById(1L)).thenReturn(pedido);
        pedidoService.buscarUltimaUnidade(1L);
    }

    @Test
    public void buscarTodosTemasSubtemasPalavraChavePedidoIfNull() {
        when(pedidoRepository.findById(1L)).thenReturn(pedido);
        pedidoService.buscarTodosTemasSubtemasPalavraChavePedido(1L);
    }

    @Test
    public void buscarTodosTemasSubtemasPalavraChavePedido() {
        when(pedidoRepository.findById(1L)).thenReturn(pedido);
        when(pedido.getTema()).thenReturn(tema);
        List<Subtema> subtemaList = new ArrayList<>();
        subtemaList.add(subtema);
        when(pedido.getSubtemaList()).thenReturn(subtemaList);
        when(subtema.getId()).thenReturn(1L);
        pedidoService.buscarTodosTemasSubtemasPalavraChavePedido(1L);
    }

    @Test
    public void buscarTodosTemasSubtemasPalavraChavePedido2() {
        when(pedidoRepository.findById(1L)).thenReturn(pedido);
        when(pedido.getTema()).thenReturn(tema);
        pedidoService.buscarTodosTemasSubtemasPalavraChavePedido(1L);
    }

    @Test
    public void montarListaConsultaPedidoDTOPorHistorico() {
        when(historicoTratamento.getTipoTratamento()).thenReturn(tipoTratamento);
        when(tipoTratamento.getTipoTratamento()).thenReturn("tipoTratamento");
        List<HistoricoTratamento> historicoTratamentoList = new ArrayList<>();
        historicoTratamentoList.add(historicoTratamento);
        pedidoService.montarListaConsultaPedidoDTOPorHistorico(historicoTratamentoList);
    }

    @Test
    public void alterarPedidoRecursoParte2() {
        when(statusSolicitacaoRecursoRepository.getOne(1L)).thenReturn(statusSolicitacaoRecurso);
        andamentoRecursoService.reverterAndamentoRecurso(recurso, "observacao", "justificativa");
        when(recursoRepository.save(recurso)).thenReturn(recurso);
        pedidoService.alterarPedidoRecursoParte2(recurso, pedido, alteracaoPedidoRecursoDTO);
    }

    @Test
    public void alterarPedidoRecursoParte2Else() {
        pedidoService.alterarPedidoRecursoParte2(null, pedido, alteracaoPedidoRecursoDTO);
    }

    @Test
    public void buscarPeloProtocoloPedido(){
        when(pedidoRepository.findByProtocolo("protocolo")).thenReturn(pedido);
        when(pedido.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(statusSolicitacao.getId()).thenReturn(1L);
        when(pedido.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(statusSolicitacao.getNome()).thenReturn("nome");
        when(pedido.getStatusTramitacao()).thenReturn(statusTramitacao);
        when(statusTramitacao.getId()).thenReturn(1L);
        when(statusTramitacao.getNome()).thenReturn("nome");
        pedidoService.buscarPeloProtocoloPedido("protocolo");
    }

    @Test
    public void buscarPeloProtocoloPedido2(){
        when(pedidoRepository.findByProtocolo("protocolo")).thenReturn(pedido);
        when(pedido.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(statusSolicitacao.getId()).thenReturn(1L);
        when(pedido.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(statusSolicitacao.getNome()).thenReturn("nome");
        when(pedido.getStatusTramitacao()).thenReturn(statusTramitacao);
        when(statusTramitacao.getId()).thenReturn(1L);
        when(statusTramitacao.getNome()).thenReturn("nome");
        when(pedido.getTema()).thenReturn(tema);
        when(pedido.getSubtemaList()).thenReturn(null);
        pedidoService.buscarPeloProtocoloPedido("protocolo");
    }

    @Test
    public void consultarPedidoSolicitante(){
        when(pedidoRepository.findById(1L)).thenReturn(pedido);
        when(pedido.getSolicitante()).thenReturn(solicitante);
        when(solicitante.getId()).thenReturn(1L);
        when(pedidoRepository.consultarPedidoSolicitante(solicitante, pageable)).thenReturn(consultaPedidoDulplicadoDTOPage);
        when(solicitanteRepository.findOne(1L)).thenReturn(solicitante);
        pedidoService.consultarPedidoSolicitante(1L, 1, 1);
    }

    @Test
    public void buscarPeloRecurso(){
        when(recurso.getStatusSolicitacao()).thenReturn(statusSolicitacaoRecurso);
        when(statusSolicitacaoRecurso.getId()).thenReturn(1L);
        when(statusSolicitacaoRecurso.getNome()).thenReturn("nome");
        when(recurso.getStatusTramitacao()).thenReturn(statusTramitacaoRecurso);
        when(statusTramitacaoRecurso.getId()).thenReturn(1L);
        when(statusTramitacaoRecurso.getNome()).thenReturn("nome");
        pedidoService.buscarPeloRecurso(recurso);
    }

    @Test
    public void definirStatusPedido(){
        pedidoService.definirStatusPedido("status");
    }

    @Test
    public void definirStatusPedidoIf(){
        pedidoService.definirStatusPedido("Produção de Resposta");
    }

    @Test
    public void definirStatusPedidoElse(){
        pedidoService.definirStatusPedido("Técnico");
    }

    @Test
    public void definirStatusRecurso(){
        pedidoService.definirStatusRecurso("status", 1L);
    }

    @Test
    public void definirStatusRecurso2(){
        when(statusSolicitacaoRecurso.getNome()).thenReturn("Recurso 1ª Produção");
        when(recursoRepository.findById(1L)).thenReturn(recurso);
        when(recurso.getStatusRespostaAssinada()).thenReturn(true);
        pedidoService.definirStatusRecurso("Recurso 1ª Produção", 1L);
    }

    @Test
    public void definirStatusRecurso3(){
        when(statusSolicitacaoRecurso.getNome()).thenReturn("Recurso 2ª Produção");
        when(recursoRepository.findById(1L)).thenReturn(recurso);
        when(recurso.getStatusRespostaAssinada()).thenReturn(true);
        pedidoService.definirStatusRecurso("Recurso 2ª Produção", 1L);
    }

    @Test
    public void statusSolicitacao(){
        when(pedidoRepository.findById(1L)).thenReturn(pedido);
        when(pedido.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(statusSolicitacao.getNome()).thenReturn("statusSolicitacao");
        pedidoService.statusSolicitacao(1L);
    }

    @Test
    public void alterarPedidoRecurso(){
        AlteracaoPedidoRecursoDTO alteracaoPedidoRecursoDTO = new AlteracaoPedidoRecursoDTO();
        alteracaoPedidoRecursoDTO.setIsPedido(true);
        alteracaoPedidoRecursoDTO.setIdPedido(1L);
        Pedido pedido = new Pedido();
        Recurso recurso = new Recurso();
        when(pedidoRepository.findById(anyLong())).thenReturn(pedido);
        when(recursoRepository.buscarIdPedido(anyLong())).thenReturn(recurso);
        pedidoService.alterarPedidoRecurso(alteracaoPedidoRecursoDTO);
    }

    @Test
    public void alterarPedidoRecursoElse(){
        List<Recurso> recursoList = new ArrayList<>();
        recursoList.add(recurso);
        when(recursoRepository.buscarIdRecurso(pedido)).thenReturn(recursoList);
        when(alteracaoPedidoRecursoDTO.getIdPedido()).thenReturn(1L);
        when(pedidoRepository.findById(1L)).thenReturn(pedido);
        when(recurso.getPedido()).thenReturn(pedido);
        when(pedido.getId()).thenReturn(1L);
        when(recursoRepository.buscarIdPedido(1L)).thenReturn(recurso);
        pedidoService.alterarPedidoRecurso(alteracaoPedidoRecursoDTO);
    }

    @Test
    public void salvarPedidoVencimentoEouvRespostaAssinada(){
        List<ConsultaPedidoDTO> consultaPedidoDTOList = new ArrayList<>();
        consultaPedidoDTOList.add(consultaPedidoDTO);
        when(pedidoRepository.findById(1L)).thenReturn(pedido);
        when(consultaPedidoDTO.getIdPedido()).thenReturn(1L);
        when(consultaPedidoDTO.getNomeStatusSolicitacao()).thenReturn("Resposta Assinada");
        when(pedido.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(statusSolicitacao.getId()).thenReturn(3L);
        pedidoService.salvarPedidoVencimentoEouv(consultaPedidoDTOList);
    }

    @Test
    public void salvarPedidoVencimentoEouvProducaoDeResposta(){
        List<ConsultaPedidoDTO> consultaPedidoDTOList = new ArrayList<>();
        consultaPedidoDTOList.add(consultaPedidoDTO);
        when(pedidoRepository.findById(1L)).thenReturn(pedido);
        when(consultaPedidoDTO.getIdPedido()).thenReturn(1L);
        when(consultaPedidoDTO.getNomeStatusSolicitacao()).thenReturn("Produção de Resposta");
        when(pedido.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(statusSolicitacao.getId()).thenReturn(7L);
        pedidoService.salvarPedidoVencimentoEouv(consultaPedidoDTOList);
    }

    @Test
    public void salvarPedidoVencimentoEouvRespostaSic(){
        List<ConsultaPedidoDTO> consultaPedidoDTOList = new ArrayList<>();
        consultaPedidoDTOList.add(consultaPedidoDTO);
        when(pedidoRepository.findById(1L)).thenReturn(pedido);
        when(consultaPedidoDTO.getIdPedido()).thenReturn(1L);
        when(consultaPedidoDTO.getNomeStatusSolicitacao()).thenReturn("Resposta SIC");
        when(pedido.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(statusSolicitacao.getId()).thenReturn(1L);
        pedidoService.salvarPedidoVencimentoEouv(consultaPedidoDTOList);
    }

    @Test
    public void salvarPedidoVencimentoEouvRevisao(){
        List<ConsultaPedidoDTO> consultaPedidoDTOList = new ArrayList<>();
        consultaPedidoDTOList.add(consultaPedidoDTO);
        when(pedidoRepository.findById(1L)).thenReturn(pedido);
        when(consultaPedidoDTO.getIdPedido()).thenReturn(1L);
        when(consultaPedidoDTO.getNomeStatusSolicitacao()).thenReturn("Revisao");
        when(pedido.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(statusSolicitacao.getId()).thenReturn(1L);
        pedidoService.salvarPedidoVencimentoEouv(consultaPedidoDTOList);
    }

    @Test
    public void buscarPeloProtocoloRecursoMaiorQue1(){
        List<Recurso> recursoList = new ArrayList<>();
        recursoList.add(recurso);
        when(recursoRepository.buscarProtocoloPedido("protocolo")).thenReturn(recursoList);
        when(recurso.getStatusSolicitacao()).thenReturn(statusSolicitacaoRecurso);
        when(statusSolicitacaoRecurso.getNome()).thenReturn("nome");
        when(recurso.getStatusTramitacao()).thenReturn(statusTramitacaoRecurso);
        when(statusTramitacaoRecurso.getNome()).thenReturn("nomeTramitacao");
        pedidoService.buscarPeloProtocoloRecurso("protocolo");
    }

    @Test
    public void buscarPeloProtocoloRecurso(){
        List<Recurso> recursoList = new ArrayList<>();
        recursoList.add(recurso);
        recursoList.add(recurso);
        recursoList.add(recurso);
        recursoList.add(recurso);
        recursoList.add(recurso);
        when(recursoRepository.buscarProtocoloPedido("protocolo")).thenReturn(recursoList);
        when(recurso.getStatusSolicitacao()).thenReturn(statusSolicitacaoRecurso);
        when(statusSolicitacaoRecurso.getNome()).thenReturn("statusSolicitacaoRecurso");
        when(recurso.getStatusTramitacao()).thenReturn(statusTramitacaoRecurso);
        when(statusSolicitacaoRecurso.getNome()).thenReturn("statusSolicitacaoRecurso");

        pedidoService.buscarPeloProtocoloRecurso("protocolo");
    }

    @Test
    public void cancelarRespostaVerificacao(){
        when(historicoTratamentoService.recuperarRespostaPedidoPerfil(1L)).thenReturn("recuperaerRespostaPedidoPerfil");
        pedidoService.cancelarRespostaVerificacao(pedido, 1L);
    }

    @Test
    public void montarPedidoRelatorioDTO(){
        when(pedido.getProtocolo()).thenReturn("protocolo");
        when(pedido.getStatusTramitacao()).thenReturn(statusTramitacao);
        when(statusTramitacao.getNome()).thenReturn("statusTramitacao");
        when(pedido.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(statusSolicitacao.getNome()).thenReturn("stautsSolicitacao");
        List<Andamento> andamentoList = new ArrayList<>();
        andamentoList.add(andamento);
        andamentoList.add(andamento);
        when(pedido.getAndamentos()).thenReturn(andamentoList);

        when(pedido.getSolicitante()).thenReturn(solicitante);
        when(solicitante.getNome()).thenReturn("nome");
        when(pedido.getResumoSolicitacao()).thenReturn("resumoSolicitacao");
        when(pedido.getDescricaoPedido()).thenReturn("descricaoPedido");
        when(pedido.getRespostaEsic()).thenReturn("respostaEsic");

        pedidoService.montarPedidoRelatorioDTO(pedido);
    }

    @Test
    public void montarPedidoRelatorioDTO2EntrandoNoIf(){
        when(pedido.getProtocolo()).thenReturn("protocolo");
        when(pedido.getStatusTramitacao()).thenReturn(statusTramitacao);
        when(statusTramitacao.getNome()).thenReturn("statusTramitacao");
        when(pedido.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(statusSolicitacao.getNome()).thenReturn("stautsSolicitacao");
        List<Andamento> andamentoList = new ArrayList<>();
        andamentoList.add(andamento);
        andamentoList.add(andamento);
        when(pedido.getAndamentos()).thenReturn(andamentoList);

        when(andamento.getUsuarioAcessosAssinatura()).thenReturn(usuarioAcessos);
        when(andamento.getUsuarioAcessosAssinatura()).thenReturn(usuarioAcessos);
        when(usuarioAcessos.getNomeUsuario()).thenReturn("nomeUsuario");

        List<Subtema> subtemaList = new ArrayList<>();
        subtemaList.add(subtema);
        subtemaList.add(subtema);
        subtemaList.add(subtema);
        subtemaList.add(subtema);
        when(pedido.getSubtemaList()).thenReturn(subtemaList);

        List<PalavraChave> palavraChaveList = new ArrayList<>();
        palavraChaveList.add(palavraChave);
        palavraChaveList.add(palavraChave);
        palavraChaveList.add(palavraChave);
        when(pedido.getPalavraChaveList()).thenReturn(palavraChaveList);

        when(pedido.getSolicitante()).thenReturn(solicitante);
        when(solicitante.getNome()).thenReturn("nome");
        when(pedido.getResumoSolicitacao()).thenReturn("resumoSolicitacao");
        when(pedido.getDescricaoPedido()).thenReturn("descricaoPedido");
        when(pedido.getRespostaEsic()).thenReturn("respostaEsic");

        List<Recurso> recursoList = new ArrayList<>();
        recursoList.add(recurso);

        when(recursoRepository.recuperarRecursoPeloProtocolo(anyString())).thenReturn(recursoList);

        pedidoService.montarPedidoRelatorioDTO(pedido);
    }
}