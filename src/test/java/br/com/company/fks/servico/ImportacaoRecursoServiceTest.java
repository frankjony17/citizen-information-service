package br.com.company.fks.servico;

import br.gov.cgu.esic.recurso.ResponseRecurso;
import br.com.company.fks.modelo.InstanciaRecurso;
import br.com.company.fks.modelo.Pedido;
import br.com.company.fks.modelo.Recurso;

import br.com.company.fks.modelo.StatusSolicitacaoRecurso;

import br.com.company.fks.modelo.TipoRecurso;
import br.com.company.fks.repositorio.PedidoRepository;
import br.com.company.fks.repositorio.RecursoRepository;
import br.com.company.fks.wsdl.ConsultaAnexoPedido;
import lombok.SneakyThrows;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

/**
 * Created by Maicon Godoy - FKSolutions Tecnologia on 30/08/18.
 */
@RunWith(MockitoJUnitRunner.class)
public class ImportacaoRecursoServiceTest {
    @InjectMocks
    private ImportacaoRecursoService importacaoRecursoService;

    @Mock
    private RecursoRepository recursoRepository;

    @Mock
    private PedidoRepository pedidoRepository;

    @Mock
    private ImportacaoPedidoService importacaoPedidoService;

    @Mock
    private ConsultaAnexoPedido consultaAnexoPedido;

    @Mock
    private AndamentoRecursoService andamentoRecursoService;

    @Mock
    private ResponseRecurso responseRecurso;

    @Mock
    private Recurso recurso;

    @Mock
    private InstanciaRecurso instanciaRecurso;

    @Mock
    private Pedido pedido;

    @Mock
    private TipoRecurso tipoRecurso;

    @Mock
    private StatusSolicitacaoRecurso statusSolicitacaoRecurso;

    @Test
    @SneakyThrows
    public void sincronizarBaseDeDadosRecursos() {
        when(responseRecurso.getProtocoloPedido()).thenReturn("teste");
        List<Recurso> recursoList = new ArrayList<>();
        recursoList.add(recurso);
        recursoList.add(recurso);
        when(recursoRepository.recuperarRecursoPeloProtocolo("teste")).thenReturn(recursoList);
        when(responseRecurso.getCodInstancia()).thenReturn(1);
        when(recurso.getInstanciaRecurso()).thenReturn(instanciaRecurso);
        when(instanciaRecurso.getId()).thenReturn(1L);
        importacaoRecursoService.sincronizarBaseDeDadosRecursos(responseRecurso);

    }

    @Test
    @SneakyThrows
    public void sincronizarBaseDeDadosRecursos2() {
        List<Recurso> recursoList = new ArrayList<>();
        when(responseRecurso.getProtocoloPedido()).thenReturn("teste");
        when(recursoRepository.recuperarRecursoPeloProtocolo("teste")).thenReturn(recursoList);
        when(responseRecurso.getCodInstancia()).thenReturn(1);
        when(recurso.getInstanciaRecurso()).thenReturn(instanciaRecurso);
        when(instanciaRecurso.getId()).thenReturn(1L);
        when(responseRecurso.getSituacao()).thenReturn("teste");
        importacaoRecursoService.sincronizarBaseDeDadosRecursos(responseRecurso);

    }

    @Test
    @SneakyThrows
    public void sincronizarBaseDeDadosRecursos2Respondido() {
        List<Recurso> recursoList = new ArrayList<>();
        when(responseRecurso.getProtocoloPedido()).thenReturn("teste");
        when(recursoRepository.recuperarRecursoPeloProtocolo("teste")).thenReturn(recursoList);
        when(responseRecurso.getCodInstancia()).thenReturn(1);
        when(recurso.getInstanciaRecurso()).thenReturn(instanciaRecurso);
        when(instanciaRecurso.getId()).thenReturn(1L);
        when(responseRecurso.getSituacao()).thenReturn("Respondido");
        importacaoRecursoService.sincronizarBaseDeDadosRecursos(responseRecurso);

    }

    @Test
    @SneakyThrows
    public void sincronizarBaseDeDadosRecursos2EmTramitacao() {
        List<Recurso> recursoList = new ArrayList<>();
        when(responseRecurso.getProtocoloPedido()).thenReturn("teste");
        when(recursoRepository.recuperarRecursoPeloProtocolo("teste")).thenReturn(recursoList);
        when(responseRecurso.getCodInstancia()).thenReturn(1);
        when(recurso.getInstanciaRecurso()).thenReturn(instanciaRecurso);
        when(instanciaRecurso.getId()).thenReturn(1L);
        when(responseRecurso.getSituacao()).thenReturn("Em Tramitação");
        importacaoRecursoService.sincronizarBaseDeDadosRecursos(responseRecurso);

    }

    @Test
    @SneakyThrows
    public void sincronizarBaseDeDadosRecursos2Deferido() {
        List<Recurso> recursoList = new ArrayList<>();
        when(responseRecurso.getProtocoloPedido()).thenReturn("teste");
        when(recursoRepository.recuperarRecursoPeloProtocolo("teste")).thenReturn(recursoList);
        when(responseRecurso.getCodInstancia()).thenReturn(1);
        when(recurso.getInstanciaRecurso()).thenReturn(instanciaRecurso);
        when(instanciaRecurso.getId()).thenReturn(1L);
        when(responseRecurso.getSituacao()).thenReturn("Deferido");
        importacaoRecursoService.sincronizarBaseDeDadosRecursos(responseRecurso);

    }

    @Test
    @SneakyThrows
    public void sincronizarBaseDeDadosRecursos2NaoRespondido() {
        List<Recurso> recursoList = new ArrayList<>();
        when(responseRecurso.getProtocoloPedido()).thenReturn("teste");
        when(recursoRepository.recuperarRecursoPeloProtocolo("teste")).thenReturn(recursoList);
        when(responseRecurso.getCodInstancia()).thenReturn(1);
        when(recurso.getInstanciaRecurso()).thenReturn(instanciaRecurso);
        when(instanciaRecurso.getId()).thenReturn(1L);
        when(responseRecurso.getSituacao()).thenReturn("Não Respondido");
        importacaoRecursoService.sincronizarBaseDeDadosRecursos(responseRecurso);

    }

    @Test
    @SneakyThrows
    public void sincronizarBaseDeDadosRecursos3() {
        List<Recurso> recursoList = new ArrayList<>();
        recursoList.add(recurso);
        recursoList.add(recurso);
        when(responseRecurso.getProtocoloPedido()).thenReturn("teste");
        when(recursoRepository.recuperarRecursoPeloProtocolo("teste")).thenReturn(recursoList);
        when(responseRecurso.getCodInstancia()).thenReturn(2);
        when(recurso.getInstanciaRecurso()).thenReturn(instanciaRecurso);
        when(instanciaRecurso.getId()).thenReturn(2L);
        when(responseRecurso.getSituacao()).thenReturn("teste");
        importacaoRecursoService.sincronizarBaseDeDadosRecursos(responseRecurso);

    }

    @Test
    @SneakyThrows
    public void sincronizarBaseDeDadosRecursos4() {
        List<Recurso> recursoList = new ArrayList<>();
        recursoList.add(recurso);
        recursoList.add(recurso);
        when(responseRecurso.getProtocoloPedido()).thenReturn("teste");
        when(recursoRepository.recuperarRecursoPeloProtocolo("teste")).thenReturn(recursoList);
        when(responseRecurso.getCodInstancia()).thenReturn(2);
        when(recurso.getInstanciaRecurso()).thenReturn(instanciaRecurso);
        when(pedidoRepository.recuperarPedidoPeloProtocolo("protocolo")).thenReturn(pedido);
        when(responseRecurso.getProtocoloPedido()).thenReturn("protocolo");
        when(responseRecurso.getSituacao()).thenReturn("Respondido");
        importacaoRecursoService.sincronizarBaseDeDadosRecursos(responseRecurso);

    }

    @Test
    @SneakyThrows
    public void sincronizarBaseDeDadosRecursos5() {
        List<Recurso> recursoList = new ArrayList<>();
        recursoList.add(recurso);
        recursoList.add(recurso);
        when(responseRecurso.getProtocoloPedido()).thenReturn("teste");
        when(recursoRepository.recuperarRecursoPeloProtocolo("teste")).thenReturn(recursoList);
        when(responseRecurso.getCodInstancia()).thenReturn(2);
        when(recurso.getInstanciaRecurso()).thenReturn(instanciaRecurso);
        when(pedidoRepository.recuperarPedidoPeloProtocolo("protocolo")).thenReturn(pedido);
        when(responseRecurso.getProtocoloPedido()).thenReturn("protocolo");
        when(responseRecurso.getSituacao()).thenReturn("Deferido");

        when(responseRecurso.getTipoRecurso()).thenReturn("Resposta não foi dada no prazo");
        when(recursoRepository.buscarRecursoEStatusSolicitacao(1L)).thenReturn(recurso);
        when(statusSolicitacaoRecurso.getId()).thenReturn(14L);
        importacaoRecursoService.sincronizarBaseDeDadosRecursos(responseRecurso);

    }

}