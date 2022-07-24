package br.com.company.fks.servico;

import br.com.company.fks.modelo.AndamentoRecurso;
import br.com.company.fks.modelo.Pedido;
import br.com.company.fks.modelo.Recurso;
import br.com.company.fks.modelo.StatusSolicitacaoRecurso;
import br.com.company.fks.modelo.StatusTramitacaoRecurso;
import br.com.company.fks.modelo.Unidade;
import br.com.company.fks.modelo.UsuarioAcessos;
import br.com.company.fks.modelo.dto.AndamentoRecursoDTO;
import br.com.company.fks.repositorio.AndamentoRecursoRepository;
import br.com.company.fks.repositorio.PedidoRepository;
import br.com.company.fks.repositorio.RecursoRepository;
import br.com.company.fks.repositorio.UsuarioAcessosRepository;
import br.com.company.fks.servico.usuario.UsuarioService;
import br.com.company.fks.utils.UsuarioLogadoUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static org.mockito.Matchers.anyLong;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

/**
 * Created by Maicon Godoy - FKSolutions Tecnologia on 16/08/18.
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({Calendar.class})
public class AndamentoRecursoServiceTest {
    @InjectMocks
    private AndamentoRecursoService andamentoRecursoService;

    @Mock
    private UsuarioService usuarioService;

    @Mock
    private AndamentoRecursoRepository andamentoRecursoRepository;

    @Mock
    private RecursoRepository recursoRepository;

    @Mock
    private Recurso recurso;

    @Mock
    private StatusSolicitacaoRecurso statusSolicitacaoRecurso;

    @Mock
    private StatusTramitacaoRecurso statusTramitacaoRecurso;

    @Mock
    private AndamentoRecurso andamentoRecurso;

    @Mock
    private List<AndamentoRecurso> andamentoRecursoList;

    @Mock
    private Calendar calendar;

    @Mock
    private Page<AndamentoRecursoDTO> andamentoRecursoDTOPage;

    @Mock
    private Pageable pageable;

    @Mock
    private PedidoRepository pedidoRepository;

    @Mock
    private Pedido pedido;

    @Mock
    private PedidoService pedidoService;

    @Mock
    private Unidade unidade;

    @Mock
    private UsuarioAcessos usuarioAcessos;

    @Mock
    private UsuarioLogadoUtil usuarioLogadoUtil;

    @Mock
    private Calendar dataInicio;

    @Mock
    private Calendar dataFim;

    @Mock
    private Calendar dataNovoAndamento;

    @Mock
    private UsuarioAcessosRepository usuarioAcessosRepository;

    @Test
    public void consultarAndamentoRecurso() {
        when(recursoRepository.findById(anyLong())).thenReturn(recurso);
        when(andamentoRecursoRepository.recuperarAndamentoRecursoEStatusTramitacao(recurso,pageable)).thenReturn(andamentoRecursoDTOPage);
        andamentoRecursoService.consultarAndamentoRecurso(1L,1,2);
    }

    @Test
    public void buscarObservacaoAndamentoRecurso(){
        List<AndamentoRecurso> andamentoRecursoList = new ArrayList<>();
        andamentoRecursoList.add(andamentoRecurso);
        when(andamentoRecursoRepository.findByPedido(1L)).thenReturn(andamentoRecursoList);
        andamentoRecursoService.buscarObservacaoAndamentoRecurso(1L);
    }

    @Test
    public void buscarUsuario(){
        when(recursoRepository.findById(1L)).thenReturn(recurso);
        when(andamentoRecursoRepository.buscarUsuario(recurso)).thenReturn(usuarioAcessos);
        andamentoRecursoService.buscarUsuario(1L);
    }

    @Test
    public void gerarAndamentoRecurso(){
        List<AndamentoRecurso> andamentoRecursoList = new ArrayList<>();
        andamentoRecursoList.add(andamentoRecurso);
        Recurso recurso = new Recurso();
        recurso.setProtocoloPedido("protocoloPedido");
        recurso.setStatusTramitacao(statusTramitacaoRecurso);
        recurso.setStatusSolicitacao(statusSolicitacaoRecurso);
        AndamentoRecurso andamentoRecurso = new AndamentoRecurso();
        andamentoRecurso.setUnidade(1L);
        andamentoRecurso.setDataInicio(dataInicio);
        andamentoRecurso.setDataFim(null);
        andamentoRecurso.setResponsavel("responsavel");
        andamentoRecurso.setObservacao(null);
        andamentoRecurso.setRecurso(recurso);
        andamentoRecurso.setStatusTramitacaoRecurso(statusTramitacaoRecurso);
        StatusSolicitacaoRecurso statusSolicitacaoRecurso = new StatusSolicitacaoRecurso();
        statusSolicitacaoRecurso.setId(1L);
        Pedido pedido = new Pedido();
        pedido.setProtocolo("protocolo");
        Unidade unidade = new Unidade();
        unidade.setId(1L);
        when(pedidoService.buscarUltimaUnidade(anyLong())).thenReturn(unidade);
        when(pedidoRepository.findByProtocolo(anyString())).thenReturn(pedido);
        when(andamentoRecursoRepository.recuperarAndamentoRecurso(anyLong())).thenReturn(andamentoRecursoList);
        andamentoRecursoService.gerarAndamentoRecurso(recurso,true,"obs");

    }

    @Test
    public void gerarAndamentoRecursoIdNull(){
        when(pedidoRepository.findByProtocolo(anyString())).thenReturn(pedido);
        when(pedidoService.buscarUltimaUnidade(anyLong())).thenReturn(unidade);
        when(pedido.getId()).thenReturn(1L);
        when(unidade.getId()).thenReturn(1L);
        when(recurso.getProtocoloPedido()).thenReturn("recursoProtocolo");
        when(recurso.getStatusSolicitacao()).thenReturn(statusSolicitacaoRecurso);
        when(statusSolicitacaoRecurso.getId()).thenReturn(null);
        andamentoRecursoService.gerarAndamentoRecurso(recurso, true, "observacao");
    }

    @Test
    public void gerarAndamentoRecursoFalse(){
        List<AndamentoRecurso> andamentoRecursoList = new ArrayList<>();
        andamentoRecursoList.add(andamentoRecurso);
        Recurso recurso = new Recurso();
        recurso.setProtocoloPedido("protocoloPedido");
        recurso.setStatusTramitacao(statusTramitacaoRecurso);
        recurso.setStatusSolicitacao(statusSolicitacaoRecurso);
        AndamentoRecurso andamentoRecurso = new AndamentoRecurso();
        andamentoRecurso.setUnidade(1L);
        andamentoRecurso.setDataInicio(dataInicio);
        andamentoRecurso.setDataFim(null);
        andamentoRecurso.setResponsavel("responsavel");
        andamentoRecurso.setObservacao(null);
        andamentoRecurso.setRecurso(recurso);
        andamentoRecurso.setStatusTramitacaoRecurso(statusTramitacaoRecurso);
        StatusSolicitacaoRecurso statusSolicitacaoRecurso = new StatusSolicitacaoRecurso();
        statusSolicitacaoRecurso.setId(1L);
        Pedido pedido = new Pedido();
        pedido.setProtocolo("protocolo");
        Unidade unidade = new Unidade();
        unidade.setId(1L);
        when(pedidoService.buscarUltimaUnidade(anyLong())).thenReturn(unidade);
        when(pedidoRepository.findByProtocolo(anyString())).thenReturn(pedido);
        when(andamentoRecursoRepository.recuperarAndamentoRecurso(anyLong())).thenReturn(andamentoRecursoList);
        andamentoRecursoService.gerarAndamentoRecurso(recurso,false,"obs");

    }

    @Test
    public void reverterAndamentoRecurso(){
        List<AndamentoRecurso> listaAndamentoRecurso = new ArrayList<>();
        listaAndamentoRecurso.add(andamentoRecurso);
        Recurso recurso = new Recurso();
        Pedido pedido = new Pedido();
        UsuarioAcessos usuarioAcessosAssinatura = new UsuarioAcessos();
        recurso.setId(1L);
        recurso.setProtocoloPedido("protocoloPedido");
        recurso.setObservacao("observacao");
        recurso.setStatusTramitacao(statusTramitacaoRecurso);
        recurso.setStatusSolicitacao(statusSolicitacaoRecurso);
        AndamentoRecurso andamentoRecurso = new AndamentoRecurso();
        andamentoRecurso.setUsuarioAcessosAssinatura(usuarioAcessos);
        andamentoRecurso.setUnidade(1L);
        andamentoRecurso.setDataInicio(dataNovoAndamento);
        andamentoRecurso.setDataFim(null);
        andamentoRecurso.setResponsavel("responsavel");
        andamentoRecurso.setObservacao("obs");
        andamentoRecurso.setRecurso(recurso);
        andamentoRecurso.setStatusTramitacaoRecurso(statusTramitacaoRecurso);
        andamentoRecurso.setStatusSolicitacaoRecurso(statusSolicitacaoRecurso);
        Unidade unidade = new Unidade();
        unidade.setId(1L);
        when(andamentoRecursoRepository.recuperarAndamentoRecurso(anyLong())).thenReturn(listaAndamentoRecurso);
        when(andamentoRecursoRepository.save(andamentoRecurso)).thenReturn(andamentoRecurso);
        when(pedidoService.buscarUltimaUnidade(anyLong())).thenReturn(unidade);
        when(pedidoRepository.findByProtocolo(anyString())).thenReturn(pedido);
        when(usuarioAcessosRepository.findFirstByCpfUsuario(anyString())).thenReturn(usuarioAcessosAssinatura);
        andamentoRecursoService.reverterAndamentoRecurso(recurso,"obs");
        andamentoRecursoService.reverterAndamentoRecurso(recurso,"obs",usuarioAcessos);
        andamentoRecursoService.reverterAndamentoRecurso(recurso,"obs","justificativa");

    }

}
