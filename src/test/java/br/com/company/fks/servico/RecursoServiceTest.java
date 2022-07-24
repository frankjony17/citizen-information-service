package br.com.company.fks.servico;

import br.com.company.fks.excecao.IntegracaoException;
import br.com.company.fks.modelo.InstanciaRecurso;
import br.com.company.fks.modelo.Pedido;
import br.com.company.fks.modelo.Recurso;
import br.com.company.fks.modelo.SituacaoRecurso;
import br.com.company.fks.modelo.Solicitante;
import br.com.company.fks.modelo.StatusSolicitacaoRecurso;
import br.com.company.fks.modelo.StatusTramitacaoRecurso;
import br.com.company.fks.modelo.TipoRecurso;
import br.com.company.fks.modelo.dto.FiltroRecursoDTO;
import br.com.company.fks.repositorio.PedidoRepository;
import br.com.company.fks.repositorio.RecursoRepository;
import br.com.company.fks.repositorio.custom.RecursoCustomRepositorio;
import lombok.SneakyThrows;
import org.apache.poi.POIXMLDocument;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

/**
 * Created by Maicon Godoy - FKSolutions Tecnologia on 31/08/18.
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({XSSFCell.class,POIXMLDocument.class,OPCPackage.class})
public class RecursoServiceTest {
    @InjectMocks
    private RecursoService recursoService;

    @Mock
    private RecursoCustomRepositorio recursoCustomRepositorio;

    @Mock
    private RecursoRepository recursoRepository;

    @Mock
    private PedidoRepository pedidoRepository;

    @Mock
    private FiltroRecursoDTO filtroRecursoDTO;

    @Mock
    private Pedido pedido;

    @Mock
    private Recurso recurso;

    @Mock
    private InstanciaRecurso instanciaRecurso;

    @Mock
    private StatusSolicitacaoRecurso statusSolicitacao;

    @Mock
    private Solicitante solicitante;

    @Mock
    private TipoRecurso tipoRecurso;

    @Mock
    private SituacaoRecurso situacaoRecurso;

    @Mock
    private StatusTramitacaoRecurso statusTramitacao;

    @Mock
    private AndamentoRecursoService andamentoRecursoService;

    @Mock
    private HistoricoTratamentoRecursoService historicoTratamentoRecursoService;

    @Test
    @SneakyThrows
    public void consultarRecurso() {
        List<Recurso> recursoList = new ArrayList<>();
        when(recursoCustomRepositorio.efetuarConsultaPaginadaRecurso(filtroRecursoDTO, false)).thenReturn(recursoList);
        when(recursoCustomRepositorio.efetuarConsultaContadorTotalRecurso(filtroRecursoDTO)).thenReturn(2L);
        recursoService.consultarRecurso(filtroRecursoDTO);
    }

    @Test
    public void detalharRecursoPrimeira() {
        List<Recurso> recursos = new ArrayList<>();
        recursos.add(recurso);
        recursos.add(recurso);
        recursos.add(recurso);
        when(pedidoRepository.findOne(1L)).thenReturn(pedido);
        when(recursoRepository.buscarIdRecurso(pedido)).thenReturn(recursos);
        when(recurso.getInstanciaRecurso()).thenReturn(instanciaRecurso);
        when(instanciaRecurso.getId()).thenReturn(1L);
        when(recurso.getId()).thenReturn(2L);
        when(recursoCustomRepositorio.detalharRecurso(2L)).thenReturn(recurso);
        when(recurso.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(recurso.getPedido()).thenReturn(pedido);
        when(pedido.getSolicitante()).thenReturn(solicitante);
        when(recurso.getTipoRecurso()).thenReturn(tipoRecurso);
        when(recurso.getSituacaoRecurso()).thenReturn(situacaoRecurso);
        when(historicoTratamentoRecursoService.recuperarRespostaRecurso(1L)).thenReturn("teste");
        when(andamentoRecursoService.buscarObservacaoAndamentoRecurso(1L)).thenReturn("teste");
        recursoService.detalharRecurso(1L, "primeiraInstancia");
    }

    @Test
    public void detalharRecursoPrimeiraSemEntrarNoIf() {
        List<Recurso> recursos = new ArrayList<>();
        recursos.add(recurso);
        recursos.add(recurso);
        recursos.add(recurso);
        when(pedidoRepository.findOne(1L)).thenReturn(pedido);
        when(recursoRepository.buscarIdRecurso(pedido)).thenReturn(recursos);
        when(recurso.getInstanciaRecurso()).thenReturn(instanciaRecurso);
        when(instanciaRecurso.getId()).thenReturn(3L);
        when(recurso.getId()).thenReturn(2L);
        when(recursoCustomRepositorio.detalharRecurso(2L)).thenReturn(recurso);
        when(recurso.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(recurso.getPedido()).thenReturn(pedido);
        when(pedido.getSolicitante()).thenReturn(solicitante);
        when(recurso.getTipoRecurso()).thenReturn(tipoRecurso);
        when(recurso.getSituacaoRecurso()).thenReturn(situacaoRecurso);
        when(historicoTratamentoRecursoService.recuperarRespostaRecurso(1L)).thenReturn("teste");
        when(andamentoRecursoService.buscarObservacaoAndamentoRecurso(1L)).thenReturn("teste");
        recursoService.detalharRecurso(1L, "primeiraInstancia");
    }

    @Test
    public void detalharRecursoSegunda() {
        List<Recurso> recursos = new ArrayList<>();
        recursos.add(recurso);
        recursos.add(recurso);
        recursos.add(recurso);
        when(pedidoRepository.findOne(2L)).thenReturn(pedido);
        when(recursoRepository.buscarIdRecurso(pedido)).thenReturn(recursos);
        when(recurso.getInstanciaRecurso()).thenReturn(instanciaRecurso);
        when(instanciaRecurso.getId()).thenReturn(2L);
        when(recurso.getId()).thenReturn(2L);
        when(recursoCustomRepositorio.detalharRecurso(2L)).thenReturn(recurso);
        when(recurso.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(recurso.getPedido()).thenReturn(pedido);
        when(pedido.getSolicitante()).thenReturn(solicitante);
        when(recurso.getTipoRecurso()).thenReturn(tipoRecurso);
        when(recurso.getSituacaoRecurso()).thenReturn(situacaoRecurso);
        recursoService.detalharRecurso(2L, "segundaInstancia");
    }

    @Test
    public void detalharRecursoSegundaSemEntrarNoIf() {
        List<Recurso> recursos = new ArrayList<>();
        recursos.add(recurso);
        recursos.add(recurso);
        recursos.add(recurso);
        when(pedidoRepository.findOne(2L)).thenReturn(pedido);
        when(recursoRepository.buscarIdRecurso(pedido)).thenReturn(recursos);
        when(recurso.getInstanciaRecurso()).thenReturn(instanciaRecurso);
        when(instanciaRecurso.getId()).thenReturn(4L);
        when(recurso.getId()).thenReturn(2L);
        when(recursoCustomRepositorio.detalharRecurso(2L)).thenReturn(recurso);
        when(recurso.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(recurso.getPedido()).thenReturn(pedido);
        when(pedido.getSolicitante()).thenReturn(solicitante);
        when(recurso.getTipoRecurso()).thenReturn(tipoRecurso);
        when(recurso.getSituacaoRecurso()).thenReturn(situacaoRecurso);
        recursoService.detalharRecurso(2L, "segundaInstancia");
    }

    @Test
    public void detalharRecursoNull(){
        recursoService.detalharRecurso(0L, "teste");
    }

    @Test
    public void buscarStatusSolicitacaoRecurso() {
    when(recursoCustomRepositorio.detalharRecurso(1L)).thenReturn(recurso);
    when(recurso.getId()).thenReturn(2L);
    when(recurso.getStatusSolicitacao()).thenReturn(statusSolicitacao);
    when(statusSolicitacao.getNome()).thenReturn("teste");
    recursoService.buscarStatusSolicitacaoRecurso(1L);
    }

    @Test
    public void exportarConsultaRecurso() throws IOException, IntegracaoException {
        List<Recurso> listaRecurso = new ArrayList<>();
        listaRecurso.add(recurso);
        when(recursoCustomRepositorio.efetuarConsultaPaginadaRecurso(filtroRecursoDTO, true)).thenReturn(listaRecurso);
        when(recurso.getStatusTramitacao()).thenReturn(statusTramitacao);
        when(statusTramitacao.getNome()).thenReturn("statusTramitacao");
        when(recurso.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(statusSolicitacao.getNome()).thenReturn("statusSolicitacao");
        when(recurso.getSituacaoRecurso()).thenReturn(situacaoRecurso);
        when(situacaoRecurso.getNome()).thenReturn("situacaoRecurso");
        when(recurso.getPedido()).thenReturn(pedido);
        when(pedido.getSolicitante()).thenReturn(solicitante);
        when(solicitante.getNome()).thenReturn("solicitante");
        when(recurso.getInstanciaRecurso()).thenReturn(instanciaRecurso);
        when(instanciaRecurso.getNome()).thenReturn("instanciaRecurso");
        when(recurso.getTipoRecurso()).thenReturn(tipoRecurso);
        when(tipoRecurso.getNome()).thenReturn("tipoRecurso");
        recursoService.exportarConsultaRecurso(filtroRecursoDTO);
    }

    @Test
    public void buscarIdRecurso() {
        List<Recurso> recursoList = new ArrayList<>();
        recursoList.add(recurso);
        recursoList.add(recurso);
        recursoList.add(recurso);
        when(pedidoRepository.findOne(1L)).thenReturn(pedido);
        when(recursoRepository.buscarIdRecurso(pedido)).thenReturn(recursoList);
        recursoService.buscarIdRecurso(1L);
    }
    @Test
    public void buscarIdRecursoListavazia() {
        List<Recurso> recursoList = new ArrayList<>();
        when(pedidoRepository.findOne(1L)).thenReturn(pedido);
        when(recursoRepository.buscarIdRecurso(pedido)).thenReturn(recursoList);
        when(recurso.getId()).thenReturn(1L);
        recursoService.buscarIdRecurso(1L);
    }

    @Test
    @SneakyThrows
    public void buscarIdPedido() {
        when(recursoRepository.buscarIdPedido(1L)).thenReturn(recurso);
        when(recurso.getPedido()).thenReturn(pedido);
        when(pedido.getId()).thenReturn(1L);
        recursoService.buscarIdPedido(1L);
    }

    @Test
    public void consultarStatusRespostaAssinada(){
        when(recursoRepository.findOne(1L)).thenReturn(recurso);
        recursoService.consultarStatusRespostaAssinada(1L);
    }


}