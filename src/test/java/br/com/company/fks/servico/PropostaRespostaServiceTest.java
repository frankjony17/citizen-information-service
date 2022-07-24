package br.com.company.fks.servico;

import br.com.company.fks.command.PropostaRespostaCommandImpl;
import br.com.company.fks.modelo.Andamento;
import br.com.company.fks.modelo.Pedido;
import br.com.company.fks.modelo.StatusSolicitacao;
import br.com.company.fks.modelo.StatusTramitacao;
import br.com.company.fks.modelo.Subunidade;
import br.com.company.fks.modelo.Unidade;
import br.com.company.fks.modelo.UsuarioAcessoPerfilAcesso;
import br.com.company.fks.modelo.UsuarioAcessos;
import br.com.company.fks.modelo.dto.PropostaRespostaDTO;
import br.com.company.fks.repositorio.AndamentoRepository;
import br.com.company.fks.repositorio.PedidoRepository;
import br.com.company.fks.repositorio.UsuarioAcessoPerfilAcessoRepository;
import br.com.company.fks.utils.UsuarioLogadoUtil;
import lombok.SneakyThrows;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyBoolean;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PropostaRespostaServiceTest {
    @InjectMocks
    private PropostaRespostaService propostaRespostaService;
    @Mock
    private HistoricoTratamentoService historicoTratamentoService;
    @Mock
    private AndamentoService andamentoService;
    @Mock
    private PedidoRepository pedidoRepository;
    @Mock
    private PropostaRespostaDTO propostaRespostaDTO;
    @Mock
    private Pedido pedido;
    @Mock
    private StatusSolicitacao statusSolicitacao;
    @Mock
    private AndamentoRepository andamentoRepository;

    @Mock
    private Andamento andamento;

    @Mock
    private UsuarioAcessos usuarioAcessos;

    @Mock
    private Unidade unidade;

    @Mock
    private UsuarioAcessoPerfilAcessoRepository usuarioAcessoPerfilAcessoRepository;

    @Mock
    private UsuarioAcessoPerfilAcesso usuarioAcessoPerfilAcesso;
    @Mock
    private UsuarioLogadoUtil usuarioLogadoUtil;

    @Mock
    private Subunidade subunidade;

    @Mock
    private PropostaRespostaCommandImpl command;

    @Mock
    private StatusTramitacao statusTramitacao;

    @Test
    public void enviar(){
        when(pedidoRepository.findById(1l)).thenReturn(pedido);
        when(propostaRespostaDTO.getIdPedido()).thenReturn(1L);
        when(propostaRespostaDTO.getObservacao()).thenReturn("observacao");
        when(propostaRespostaDTO.getIdStatusSolicitacao()).thenReturn(5L);
        when(pedido.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(statusSolicitacao.getId()).thenReturn(1L);
        when(pedido.getStatusTramitacao()).thenReturn(statusTramitacao);
        propostaRespostaService.enviar(propostaRespostaDTO);
    }

    @Test
    public void enviarNull(){
        when(pedidoRepository.findById(1l)).thenReturn(pedido);
        when(propostaRespostaDTO.getIdPedido()).thenReturn(1L);
        when(propostaRespostaDTO.getIdStatusSolicitacao()).thenReturn(5L);
        when(pedido.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(statusSolicitacao.getId()).thenReturn(1L);
        when(pedido.getStatusTramitacao()).thenReturn(statusTramitacao);

        when(pedido.getRespostaEsic()).thenReturn("respostaEsic");

        propostaRespostaService.enviar(propostaRespostaDTO);
    }

    @Test
    public void buscarDadosEncaminhamento(){
        when(pedidoRepository.buscarPedidoEStatusSolicitacao(1L)).thenReturn(pedido);
        when(pedido.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        propostaRespostaService.buscarDadosEncaminhamento(1L);
    }

    @Test
    public void buscarDadosEncaminhamentoTriagemSic(){
        when(pedidoRepository.buscarPedidoEStatusSolicitacao(1L)).thenReturn(pedido);
        when(pedido.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(statusSolicitacao.getId()).thenReturn(3L);
        propostaRespostaService.buscarDadosEncaminhamento(1L);
    }

    @Test
    public void buscarDadosEncaminhamentoDistribuicaoPf(){
        when(pedidoRepository.buscarPedidoEStatusSolicitacao(1L)).thenReturn(pedido);
        when(pedido.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(statusSolicitacao.getId()).thenReturn(1L);
        propostaRespostaService.buscarDadosEncaminhamento(1L);
    }
    @Test
    public void buscarDadosEncaminhamentoProducaoResposta(){
        when(pedidoRepository.buscarPedidoEStatusSolicitacao(7L)).thenReturn(pedido);
        when(pedido.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(statusSolicitacao.getId()).thenReturn(7L);
        propostaRespostaService.buscarDadosEncaminhamento(7L);
    }

    @Test
    public void buscarDadosEncaminhamentoRevisao(){
        when(pedidoRepository.buscarPedidoEStatusSolicitacao(1L)).thenReturn(pedido);
        when(pedido.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(statusSolicitacao.getId()).thenReturn(4L);
        propostaRespostaService.buscarDadosEncaminhamento(1L);
    }

    @Test
    public void buscarDadosEncaminhamentoResppostaAssinadaPf(){
        when(pedidoRepository.buscarPedidoEStatusSolicitacao(1L)).thenReturn(pedido);
        when(pedido.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(statusSolicitacao.getId()).thenReturn(6L);
        propostaRespostaService.buscarDadosEncaminhamento(1L);
    }

    @Test
    public void buscarDadosEncaminhamentoReencaminhamento(){
        when(pedidoRepository.buscarPedidoEStatusSolicitacao(1L)).thenReturn(pedido);
        when(pedido.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(statusSolicitacao.getId()).thenReturn(11L);
        List<Andamento> andamentoList = new ArrayList<>();
        andamentoList.add(andamento);
        andamentoList.add(andamento);
        andamentoList.add(andamento);
        when(andamentoRepository.recuperarAndamentosPedido(1L)).thenReturn(andamentoList);
        when(pedido.getId()).thenReturn(1L);
        propostaRespostaService.buscarDadosEncaminhamento(1L);
    }

    @Test
    public void buscarDadosEncaminhamentoReencaminhamentoAndamento(){
        when(pedidoRepository.buscarPedidoEStatusSolicitacao(1L)).thenReturn(pedido);
        when(pedido.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(statusSolicitacao.getId()).thenReturn(11L);
        List<Andamento> andamentoList = new ArrayList<>();
        andamentoList.add(andamento);
        andamentoList.add(andamento);
        andamentoList.add(andamento);
        when(andamentoRepository.recuperarAndamentosPedido(1L)).thenReturn(andamentoList);
        when(pedido.getId()).thenReturn(1L);

        List<Unidade> unidadeList = new ArrayList<>();
        unidadeList.add(unidade);
        when(andamento.getListaUnidade()).thenReturn(unidadeList);

        propostaRespostaService.buscarDadosEncaminhamento(1L);
    }

    @Test
    public void buscarDadosEncaminhamentoReencaminhamentoAndamentoElse(){
        when(pedidoRepository.buscarPedidoEStatusSolicitacao(1L)).thenReturn(pedido);
        when(pedido.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(statusSolicitacao.getId()).thenReturn(11L);
        List<Andamento> andamentoList = new ArrayList<>();
        andamentoList.add(andamento);
        andamentoList.add(andamento);
        andamentoList.add(andamento);
        when(andamentoRepository.recuperarAndamentosPedido(1L)).thenReturn(andamentoList);
        when(pedido.getId()).thenReturn(1L);

        List<Unidade> unidadeList = new ArrayList<>();
        unidadeList.add(unidade);
        when(unidade.getId()).thenReturn(1L);
        when(andamento.getListaUnidade()).thenReturn(unidadeList);

        propostaRespostaService.buscarDadosEncaminhamento(1L);
    }

    @Test
    public void excluirRespostaFKS(){
        when(pedidoRepository.findById(1L)).thenReturn(pedido);
        when(pedidoRepository.save(pedido)).thenReturn(pedido);
        propostaRespostaService.excluirRespostaFKS(1L);
    }

    @Test
    public void obterAssinatura(){
        when(andamentoRepository.findTopByPedidoId(anyLong())).thenReturn(andamento);
        when(andamento.getUsuarioAcessosAssinatura()).thenReturn(usuarioAcessos);
        when(usuarioAcessos.getUnidade()).thenReturn(unidade);
        when(usuarioAcessoPerfilAcessoRepository.findFirstByUsuarioAcessosUnidadeIdAndPerfilAcessosNomePerfil(anyLong(), anyString())).thenReturn(usuarioAcessoPerfilAcesso);
        when(unidade.getId()).thenReturn(6L);
        when(usuarioAcessoPerfilAcessoRepository.findFirstByUsuarioAcessosCpfUsuarioAndPerfilAcessosNomePerfil(anyString(), anyString())).thenReturn(usuarioAcessoPerfilAcesso);
        when(usuarioLogadoUtil.getUsuario()).thenReturn(usuarioAcessos);
        when(usuarioAcessos.getCpfUsuario()).thenReturn("0000000000");
        when(usuarioLogadoUtil.getPerfil()).thenReturn("perfil");
        propostaRespostaService.obterAssinatura(1L);
    }

    @Test
    public void obterAssinaturaAndamentoUnidade(){
        when(andamentoRepository.findTopByPedidoId(anyLong())).thenReturn(andamento);
        when(andamento.getUnidade()).thenReturn(unidade);
        when(andamento.getUsuarioAcessosAssinatura()).thenReturn(usuarioAcessos);
        when(usuarioAcessos.getUnidade()).thenReturn(unidade);
        when(usuarioAcessoPerfilAcessoRepository.findFirstByUsuarioAcessosUnidadeIdAndPerfilAcessosNomePerfil(anyLong(), anyString())).thenReturn(usuarioAcessoPerfilAcesso);
        when(unidade.getId()).thenReturn(6L);
        when(usuarioAcessoPerfilAcessoRepository.findFirstByUsuarioAcessosCpfUsuarioAndPerfilAcessosNomePerfil(anyString(), anyString())).thenReturn(usuarioAcessoPerfilAcesso);
        when(usuarioLogadoUtil.getUsuario()).thenReturn(usuarioAcessos);
        when(usuarioAcessos.getCpfUsuario()).thenReturn("0000000000");
        when(usuarioLogadoUtil.getPerfil()).thenReturn("perfil");
        propostaRespostaService.obterAssinatura(1L);
    }

    @Test
    public void obterAssinaturaAndamentoSuBnidade(){
        when(andamentoRepository.findTopByPedidoId(anyLong())).thenReturn(andamento);
        when(andamento.getSubunidade()).thenReturn(subunidade);
        when(subunidade.getUnidade()).thenReturn(unidade);

        when(usuarioAcessoPerfilAcessoRepository.findFirstByUsuarioAcessosUnidadeIdAndPerfilAcessosNomePerfil(1L, "nomePerfil")).thenReturn(usuarioAcessoPerfilAcesso);
        when(unidade.getId()).thenReturn(6L);
        when(usuarioAcessoPerfilAcessoRepository.findFirstByUsuarioAcessosCpfUsuarioAndPerfilAcessosNomePerfil("00000000000", "nomePerfil")).thenReturn(usuarioAcessoPerfilAcesso);
        when(usuarioLogadoUtil.getUsuario()).thenReturn(usuarioAcessos);
        when(usuarioAcessos.getCpfUsuario()).thenReturn("0000000000");
        when(usuarioLogadoUtil.getPerfil()).thenReturn("perfil");
        when(usuarioAcessoPerfilAcesso.getAssinaturaUsuario()).thenReturn("assinatura");
        propostaRespostaService.obterAssinatura(1L);
    }

}
