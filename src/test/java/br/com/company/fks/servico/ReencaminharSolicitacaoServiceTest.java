package br.com.company.fks.servico;

import br.com.company.fks.modelo.Andamento;
import br.com.company.fks.modelo.Orgao;
import br.com.company.fks.modelo.Pedido;
import br.com.company.fks.modelo.ReencaminharSolicitacao;
import br.com.company.fks.modelo.StatusSolicitacao;
import br.com.company.fks.modelo.StatusTramitacao;
import br.com.company.fks.modelo.UsuarioAcessos;
import br.com.company.fks.modelo.dto.ReencaminharSolicitacaoDTO;
import br.com.company.fks.repositorio.AndamentoRepository;
import br.com.company.fks.repositorio.PedidoRepository;
import br.com.company.fks.repositorio.ReencaminharSolicitacaoRepository;
import br.com.company.fks.repositorio.SituacaoPedidoRepository;
import br.com.company.fks.repositorio.StatusSolicitacaoRepository;
import br.com.company.fks.repositorio.StatusTramitacaoRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ReencaminharSolicitacaoServiceTest {
    @InjectMocks
    private ReencaminharSolicitacaoService reencaminharSolicitacaoService;
    @Mock
    private PedidoService pedidoService;
    @Mock
    private ReencaminharSolicitacaoRepository reencaminharSolicitacaoRepository;
    @Mock
    private AndamentoService andamentoService;
    @Mock
    private ReencaminharSolicitacaoDTO reencaminharSolicitacaoDTO;
    @Mock
    private ReencaminharSolicitacao reencaminharSolicitacao;
    @Mock
    private Pedido pedido;
    @Mock
    private Orgao orgao;
    @Mock
    private PedidoRepository pedidoRepository;
    @Mock
    private AndamentoRepository andamentoRepository;
    @Mock
    private StatusSolicitacao statusSolicitacao;
    @Mock
    private StatusSolicitacaoRepository statusSolicitacaoRepository;
    @Mock
    private StatusTramitacaoRepository statusTramitacaoRepository;
    @Mock
    private StatusTramitacao statusTramitacao;
    @Mock
    private SituacaoPedidoRepository situacaoPedidoRepository;
    @Mock
    private UsuarioAcessos usuarioAcessos;
    @Mock
    private Andamento andamento;
    @Mock
    private List<Andamento> listaAndamento;
    @Mock
    private List<UsuarioAcessos> usuarioAcessosList;

   @Test
    public void alterarStatusReencaminhar(){
        when(pedidoRepository.findOne(1L)).thenReturn(pedido);
        when(pedido.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(statusSolicitacao.getId()).thenReturn(1L);
        when(pedido.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(statusSolicitacao.getId()).thenReturn(11L);
        when(listaAndamento.get(1)).thenReturn(andamento);
        when(andamento.getUsuarioAcessos()).thenReturn(usuarioAcessosList);
        when(statusSolicitacao.getId()).thenReturn(1L);
        when(statusSolicitacaoRepository.findOne(1L)).thenReturn(statusSolicitacao);
        when(statusTramitacaoRepository.findOne(1L)).thenReturn(statusTramitacao);
        reencaminharSolicitacaoService.alterarStatusReencaminhar(1L);
   }

   @Test
    public void alterarStatusReencaminharDistribuicaoPf(){
        when(pedidoRepository.findOne(1L)).thenReturn(pedido);
        when(pedido.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(statusSolicitacao.getId()).thenReturn(3L);
        reencaminharSolicitacaoService.alterarStatusReencaminhar(1L);
   }

   @Test
    public void alterarStatusReencaminharProducaoReposta(){
        when(pedidoRepository.findOne(1L)).thenReturn(pedido);
        when(pedido.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(statusSolicitacao.getId()).thenReturn(7L);
        reencaminharSolicitacaoService.alterarStatusReencaminhar(1L);
   }

   @Test
    public void buscarReencaminhamentoParaOrgao(){
       reencaminharSolicitacaoService.buscarReencaminhamentoParaOrgao(1L);
   }

   @Test
    public void buscarReencaminhamentoParaOrgao2(){
       when(pedidoRepository.findById(1L)).thenReturn(pedido);
       List<ReencaminharSolicitacao> reencaminharSolicitacaoList = new ArrayList<>();
       reencaminharSolicitacaoList.add(reencaminharSolicitacao);
       when(reencaminharSolicitacaoRepository.findByPedido(pedido)).thenReturn(reencaminharSolicitacaoList);
       reencaminharSolicitacaoService.buscarReencaminhamentoParaOrgao(1L);
   }

}