package br.com.company.fks.servico;

import br.com.company.fks.modelo.Andamento;
import br.com.company.fks.modelo.Pedido;
import br.com.company.fks.modelo.StatusSolicitacao;
import br.com.company.fks.modelo.Subunidade;
import br.com.company.fks.modelo.Unidade;
import br.com.company.fks.modelo.UsuarioAcessos;
import br.com.company.fks.modelo.dto.AndamentoPedidoDTO;
import br.com.company.fks.modelo.dto.PropostaRespostaDTO;
import br.com.company.fks.modelo.dto.RespostaAssinadaDTO;
import br.com.company.fks.repositorio.AndamentoRepository;
import br.com.company.fks.repositorio.PedidoRepository;
import br.com.company.fks.repositorio.UnidadeRepository;
import br.com.company.fks.repositorio.UsuarioAcessosRepository;
import br.com.company.fks.utils.UsuarioLogadoUtil;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class AndamentoServiceTest {

    @InjectMocks
    private AndamentoService andamentoService;

    @Mock
    private AndamentoRepository andamentoRepository;
    @Mock
    private PedidoRepository pedidoRepository;
    @Mock
    private Pedido pedido;
    @Mock
    private  Andamento andamento;
    @Mock
    private Page<AndamentoPedidoDTO> andamentoPedidoDTOPage;

    @Mock
    private UnidadeRepository unidadeRepository;

    @Mock
    private Unidade unidade;
    @Mock
    private UsuarioLogadoUtil usuarioLogadoUtil;

    @Mock
    private UsuarioAcessosRepository usuarioAcessosRepository;

    @Mock
    private UsuarioAcessos usuarioAcessos;

    @Mock
    private Subunidade subunidade;

    @Mock
    private StatusSolicitacao statusSolicitacao;

    @Mock
    private PropostaRespostaDTO propostaRespostaDTO;

    @Mock
    private RespostaAssinadaDTO respostaAssinadaDTO;

    @Mock
    private List<Andamento> andamentoList1;

    @Mock
    private UnidadeService unidadeService;

    @Test
    public void criarAndamentoTest() {
        when(andamentoRepository.save(any(Andamento.class))).thenReturn(andamento);
        andamentoService.criarAndamento(andamento);
    }

    @Test
    public void gerarAndamentoSolicitacao(){
        when(unidadeRepository.findOne(1L)).thenReturn(unidade);
        when(andamentoRepository.save(any(Andamento.class))).thenReturn(andamento);
        andamentoService.gerarAndamentoSolicitacao(pedido,true,"abc");
    }

    @Test
    public void gerarAndamentoSolicitacaoFalse(){
        List<Andamento> andamentoList = new ArrayList<>();
        andamentoList.add(andamento);
        when(andamentoRepository.recuperarAndamentosPedido(1L)).thenReturn(andamentoList);
        when(pedido.getId()).thenReturn(1L);
        when(usuarioLogadoUtil.getNome()).thenReturn("nome");
        when(andamentoRepository.save(andamento)).thenReturn(andamento);
        andamentoService.gerarAndamentoSolicitacao(pedido, false, "abc");
    }

    @Test
    public void reverterAndamento(){
        List<Andamento> andamentoList = new ArrayList<>();
        andamentoList.add(andamento);
        when(usuarioAcessosRepository.findFirstByCpfUsuario("codigoUsuario")).thenReturn(usuarioAcessos);
        when(usuarioLogadoUtil.getCpf()).thenReturn("cpf");
        when(andamentoRepository.recuperarAndamentosPedido(1L)).thenReturn(andamentoList);
        when(pedido.getId()).thenReturn(1L);
        andamentoService.reverterAndamento(pedido, "observacao", unidade);
    }

    @Test
    public void reverterAndamento1(){
        List<Andamento> andamentoList = new ArrayList<>();
        andamentoList.add(andamento);
        when(usuarioAcessosRepository.findFirstByCpfUsuario("codigoUsuario")).thenReturn(usuarioAcessos);
        when(usuarioLogadoUtil.getCpf()).thenReturn("cpf");
        when(andamentoRepository.recuperarAndamentosPedido(1L)).thenReturn(andamentoList);
        when(pedido.getId()).thenReturn(1L);
        andamentoService.reverterAndamento(pedido, "observacao", subunidade);
    }

    @Test
    public void reverterAndamento2(){
        List<Andamento> andamentoList = new ArrayList<>();
        andamentoList.add(andamento);
        when(usuarioAcessosRepository.findFirstByCpfUsuario("codigoUsuario")).thenReturn(usuarioAcessos);
        when(usuarioLogadoUtil.getCpf()).thenReturn("cpf");
        when(andamentoRepository.recuperarAndamentosPedido(1L)).thenReturn(andamentoList);
        when(pedido.getId()).thenReturn(1L);
        andamentoService.reverterAndamento(pedido, "observacao", unidade, subunidade);
    }

    @Test
    public void reverterAndamento3(){
        List<Andamento> andamentoList = new ArrayList<>();
        andamentoList.add(andamento);
        when(andamentoRepository.recuperarAndamentosPedido(1L)).thenReturn(andamentoList);
        when(pedido.getId()).thenReturn(1L);
        andamentoService.reverterAndamento(pedido, "observacao", subunidade, usuarioAcessos);
    }

    @Test
    public void reverterAndamento4(){
        List<Andamento> andamentoList = new ArrayList<>();
        andamentoList.add(andamento);
        when(andamentoRepository.recuperarAndamentosPedido(1L)).thenReturn(andamentoList);
        when(pedido.getId()).thenReturn(1L);
        andamentoService.reverterAndamento(pedido, "observacao", unidade, subunidade, usuarioAcessos);
    }

    @Test
    public void reverterAndamento5(){
        when(usuarioAcessosRepository.findFirstByCpfUsuario("codigoUsuario")).thenReturn(usuarioAcessos);
        List<Andamento> andamentoList = new ArrayList<>();
        andamentoList.add(andamento);
        when(andamentoRepository.recuperarAndamentosPedido(1L)).thenReturn(andamentoList);
        when(pedido.getId()).thenReturn(1L);
        andamentoService.reverterAndamento(pedido, "observacao", "justificava");
    }


    @Test
    public void consultarAndamentoPedidoTest(){
        when(pedidoRepository.findById(anyLong())).thenReturn(pedido);
        when(andamentoRepository.recuperarAndamentoPedidoEStatusTramitacao(any(Pedido.class), any(Pageable.class))).thenReturn(andamentoPedidoDTOPage);
        assertEquals(andamentoService.consultarAndamentoPedido(1L,1,1),andamentoPedidoDTOPage);
    }

    @Test
    public void buscarObservacaoAndamento(){
        List<Andamento> listaAndamento = new ArrayList<>();
        listaAndamento.add(andamento);
        when(andamentoRepository.findByPedido(1L)).thenReturn(listaAndamento);
        andamentoService.buscarObservacaoAndamento(1L);
    }

    @Test
    public void verificaAssinatura(){
        List<Andamento> listaAndamento = new ArrayList<>();
        listaAndamento.add(andamento);
        when(andamentoRepository.recuperarAndamentosPedido(1L)).thenReturn(listaAndamento);
        when(usuarioLogadoUtil.getPerfil()).thenReturn("FKS.RESPONDENTE");
        when(andamento.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(statusSolicitacao.getId()).thenReturn(3L);
        when(andamento.getStatusRespostaAssinada()).thenReturn(true);
        andamentoService.verificaAssinatura(1L);
    }

    @Test
    public void verificaAssinaturaIf(){
        List<Andamento> listaAndamento = new ArrayList<>();
        listaAndamento.add(andamento);
        when(andamentoRepository.recuperarAndamentosPedido(1L)).thenReturn(listaAndamento);
        when(usuarioLogadoUtil.getPerfil()).thenReturn("FKS.RESPONDENTE");
        when(andamento.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(statusSolicitacao.getId()).thenReturn(10L);
        andamentoService.verificaAssinatura(1L);
    }

    @Test
    public void verificarAssinaturaElse(){
        List<Andamento> listaAndamento = new ArrayList<>();
        listaAndamento.add(andamento);
        when(andamentoRepository.recuperarAndamentosPedido(1L)).thenReturn(listaAndamento);
        when(usuarioLogadoUtil.getPerfil()).thenReturn("FKS.TECNICO");
        when(andamento.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(statusSolicitacao.getId()).thenReturn(7L);
        when(andamento.getStatusRespostaAssinada()).thenReturn(true);
        andamentoService.verificaAssinatura(1L);
    }

    @Test
    public void verificarAssinaturaElseFalse(){
        List<Andamento> listaAndamento = new ArrayList<>();
        listaAndamento.add(andamento);
        when(andamentoRepository.recuperarAndamentosPedido(1L)).thenReturn(listaAndamento);
        when(usuarioLogadoUtil.getPerfil()).thenReturn("FKS.TECNICO");
        when(andamento.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(statusSolicitacao.getId()).thenReturn(7L);
        when(andamento.getStatusRespostaAssinada()).thenReturn(true);
        andamentoService.verificaAssinatura(1L);
    }

    @Test
    public void verificarAssinaturaElseIfFalse2(){
        List<Andamento> listaAndamento = new ArrayList<>();
        when(andamentoRepository.recuperarAndamentosPedido(1L)).thenReturn(listaAndamento);
        when(usuarioLogadoUtil.getPerfil()).thenReturn("FKS.TECNICO");
        when(andamento.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(statusSolicitacao.getId()).thenReturn(7L);
        when(andamento.getStatusRespostaAssinada()).thenReturn(true);
        andamentoService.verificaAssinatura(1L);
    }

    @Test
    public void verificaAssinatura3(){
        List<Andamento> andamentoList = new ArrayList<>();
        andamentoList.add(andamento);
        when(andamentoRepository.recuperarAndamentosPedido(anyLong())).thenReturn(andamentoList);
        when(usuarioLogadoUtil.getPerfil()).thenReturn("FKS.PONTO.FOCAL");
        andamentoService.verificaAssinatura(1L);
    }

    @Test
    public void verificaAssinatura3Tecnico(){
        List<Andamento> andamentoList = new ArrayList<>();
        when(andamentoRepository.recuperarAndamentosPedido(anyLong())).thenReturn(andamentoList);
        when(usuarioLogadoUtil.getPerfil()).thenReturn("FKS.TECNICO");
        andamentoService.verificaAssinatura(1L);
    }

    @Test
    public void reverterAndamento6(){
        when(usuarioAcessosRepository.findFirstByCpfUsuario(anyString())).thenReturn(usuarioAcessos);
        when(usuarioLogadoUtil.getCpf()).thenReturn("000000000");
        List<Andamento> listaAndamento = new ArrayList<>();
        listaAndamento.add(andamento);
        when(andamentoRepository.recuperarAndamentosPedido(anyLong())).thenReturn(listaAndamento);

        List<Unidade> unidadeList = new ArrayList<>();
        unidadeList.add(unidade);
        when(propostaRespostaDTO.getListaUnidade()).thenReturn(unidadeList);
        when(unidade.getCodigoUnidade()).thenReturn("1");

        when(usuarioLogadoUtil.getPerfil()).thenReturn("FKS.ATENDENTE.SIC");
        when(pedido.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(statusSolicitacao.getId()).thenReturn(3L);

        andamentoService.reverterAndamento(pedido, "observacao", propostaRespostaDTO);

    }

    @Test
    public void reverterAndamento6Admin(){
        when(usuarioAcessosRepository.findFirstByCpfUsuario(anyString())).thenReturn(usuarioAcessos);
        when(usuarioLogadoUtil.getCpf()).thenReturn("000000000");
        List<Andamento> listaAndamento = new ArrayList<>();
        listaAndamento.add(andamento);
        when(andamentoRepository.recuperarAndamentosPedido(anyLong())).thenReturn(listaAndamento);

        List<Unidade> unidadeList = new ArrayList<>();
        unidadeList.add(unidade);
        when(propostaRespostaDTO.getListaUnidade()).thenReturn(unidadeList);
        when(unidade.getCodigoUnidade()).thenReturn("1");

        when(usuarioLogadoUtil.getPerfil()).thenReturn("FKS.ADMIN");
        when(pedido.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(statusSolicitacao.getId()).thenReturn(3L);

        andamentoService.reverterAndamento(pedido, "observacao", propostaRespostaDTO);

    }

    @Test
    public void reverterAndamento6AdminElseAtendenteSic(){
        when(usuarioAcessosRepository.findFirstByCpfUsuario(anyString())).thenReturn(usuarioAcessos);
        when(usuarioLogadoUtil.getCpf()).thenReturn("000000000");
        List<Andamento> listaAndamento = new ArrayList<>();
        listaAndamento.add(andamento);
        when(andamentoRepository.recuperarAndamentosPedido(anyLong())).thenReturn(listaAndamento);

        List<Unidade> unidadeList = new ArrayList<>();
        unidadeList.add(unidade);
        when(propostaRespostaDTO.getListaUnidade()).thenReturn(unidadeList);
        when(unidade.getCodigoUnidade()).thenReturn("1");

        when(usuarioLogadoUtil.getPerfil()).thenReturn("FKS.ADMIN");
        when(pedido.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(statusSolicitacao.getId()).thenReturn(2L);

        andamentoService.reverterAndamento(pedido, "observacao", propostaRespostaDTO);

    }

    @Test
    public void reverterAndamento6AdminElseAdmin(){
        when(usuarioAcessosRepository.findFirstByCpfUsuario(anyString())).thenReturn(usuarioAcessos);
        when(usuarioLogadoUtil.getCpf()).thenReturn("000000000");
        List<Andamento> listaAndamento = new ArrayList<>();
        listaAndamento.add(andamento);
        when(andamentoRepository.recuperarAndamentosPedido(anyLong())).thenReturn(listaAndamento);

        List<Unidade> unidadeList = new ArrayList<>();
        unidadeList.add(unidade);
        when(propostaRespostaDTO.getListaUnidade()).thenReturn(unidadeList);
        when(unidade.getCodigoUnidade()).thenReturn("1");

        when(usuarioLogadoUtil.getPerfil()).thenReturn("FKS.ATENDENTE.SIC");
        when(pedido.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(statusSolicitacao.getId()).thenReturn(2L);

        when(usuarioLogadoUtil.getPerfil()).thenReturn("FKS.ATENDENTE.SIC");

        andamentoService.reverterAndamento(pedido, "observacao", propostaRespostaDTO);

    }

    @Test
    public void reverterAndamento6AdminElsePontoFocal(){
        when(usuarioAcessosRepository.findFirstByCpfUsuario(anyString())).thenReturn(usuarioAcessos);
        when(usuarioLogadoUtil.getCpf()).thenReturn("000000000");
        List<Andamento> listaAndamento = new ArrayList<>();
        listaAndamento.add(andamento);
        when(andamentoRepository.recuperarAndamentosPedido(anyLong())).thenReturn(listaAndamento);

        List<Unidade> unidadeList = new ArrayList<>();
        unidadeList.add(unidade);
        when(propostaRespostaDTO.getListaUnidade()).thenReturn(unidadeList);
        when(unidade.getCodigoUnidade()).thenReturn("1");

        when(usuarioLogadoUtil.getPerfil()).thenReturn("FKS.PONTO.FOCAL");
        when(pedido.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(statusSolicitacao.getId()).thenReturn(2L);

        andamentoService.reverterAndamento(pedido, "observacao", propostaRespostaDTO);

    }

    @Test
    public void reverterAndamento6AdminElseParaEnvio(){
        when(usuarioAcessosRepository.findFirstByCpfUsuario(anyString())).thenReturn(usuarioAcessos);
        when(usuarioLogadoUtil.getCpf()).thenReturn("000000000");
        List<Andamento> listaAndamento = new ArrayList<>();
        listaAndamento.add(andamento);
        when(andamentoRepository.recuperarAndamentosPedido(anyLong())).thenReturn(listaAndamento);

        List<Unidade> unidadeList = new ArrayList<>();
        unidadeList.add(unidade);
        when(propostaRespostaDTO.getListaUnidade()).thenReturn(unidadeList);
        when(unidade.getCodigoUnidade()).thenReturn("1");

        when(usuarioLogadoUtil.getPerfil()).thenReturn("FKS.PONTO.FOCAL");
        when(pedido.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(statusSolicitacao.getId()).thenReturn(5L);

        andamentoService.reverterAndamento(pedido, "observacao", propostaRespostaDTO);

    }

    @Test
    public void reverterAndamento6Verificacao2(){
        when(usuarioAcessosRepository.findFirstByCpfUsuario(anyString())).thenReturn(usuarioAcessos);
        when(usuarioLogadoUtil.getCpf()).thenReturn("000000000");
        List<Andamento> listaAndamento = new ArrayList<>();
        listaAndamento.add(andamento);
        when(andamentoRepository.recuperarAndamentosPedido(anyLong())).thenReturn(listaAndamento);

        List<Unidade> unidadeList = new ArrayList<>();
        unidadeList.add(unidade);
        when(propostaRespostaDTO.getListaUnidade()).thenReturn(unidadeList);
        when(unidade.getCodigoUnidade()).thenReturn("1");

        when(usuarioLogadoUtil.getPerfil()).thenReturn("teste");
        when(pedido.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(statusSolicitacao.getId()).thenReturn(9L);

        andamentoService.reverterAndamento(pedido, "observacao", propostaRespostaDTO);

    }

    @Test
    public void reverterAndamento6Verificacao2PontoFocal(){
        when(usuarioAcessosRepository.findFirstByCpfUsuario(anyString())).thenReturn(usuarioAcessos);
        when(usuarioLogadoUtil.getCpf()).thenReturn("000000000");
        List<Andamento> listaAndamento = new ArrayList<>();
        listaAndamento.add(andamento);
        when(andamentoRepository.recuperarAndamentosPedido(anyLong())).thenReturn(listaAndamento);

        List<Unidade> unidadeList = new ArrayList<>();
        unidadeList.add(unidade);
        when(propostaRespostaDTO.getListaUnidade()).thenReturn(unidadeList);
        when(unidade.getCodigoUnidade()).thenReturn("1");

        when(usuarioLogadoUtil.getPerfil()).thenReturn("teste");
        when(pedido.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(statusSolicitacao.getId()).thenReturn(9L);

        when(usuarioLogadoUtil.getPerfil()).thenReturn("FKS.PONTO.FOCAL");
        when(pedido.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(statusSolicitacao.getId()).thenReturn(7L);

        List<Subunidade> subunidadeList = new ArrayList<>();
        subunidadeList.add(subunidade);
        when(propostaRespostaDTO.getListaSubunidade()).thenReturn(subunidadeList);

        andamentoService.reverterAndamento(pedido, "observacao", propostaRespostaDTO);

    }

    @Test
    public void reverterAndamento6Verificacao2Respondente(){
        when(usuarioAcessosRepository.findFirstByCpfUsuario(anyString())).thenReturn(usuarioAcessos);
        when(usuarioLogadoUtil.getCpf()).thenReturn("000000000");
        List<Andamento> listaAndamento = new ArrayList<>();
        listaAndamento.add(andamento);
        when(andamentoRepository.recuperarAndamentosPedido(anyLong())).thenReturn(listaAndamento);

        List<Unidade> unidadeList = new ArrayList<>();
        unidadeList.add(unidade);
        when(propostaRespostaDTO.getListaUnidade()).thenReturn(unidadeList);
        when(unidade.getCodigoUnidade()).thenReturn("1");

        when(usuarioLogadoUtil.getPerfil()).thenReturn("teste");
        when(pedido.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(statusSolicitacao.getId()).thenReturn(9L);

        when(usuarioLogadoUtil.getPerfil()).thenReturn("FKS.RESPONDENTE");
        when(pedido.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(statusSolicitacao.getId()).thenReturn(8L);
        when(unidadeService.getOneSubunidadePeloUsuarioCpf("0000000000")).thenReturn(subunidade);

        when(usuarioAcessosRepository.findFirstByCpfUsuario(anyString())).thenReturn(usuarioAcessos);
        List<UsuarioAcessos> usuarioAcessosList = new ArrayList<>();
        usuarioAcessosList.add(usuarioAcessos);
        when(propostaRespostaDTO.getListaUsuarioAcessos()).thenReturn(usuarioAcessosList);

        andamentoService.reverterAndamento(pedido, "observacao", propostaRespostaDTO);

    }

    @Test
    public void reverterAndamento6Verificacao2Tecnico(){
        when(usuarioAcessosRepository.findFirstByCpfUsuario(anyString())).thenReturn(usuarioAcessos);
        when(usuarioLogadoUtil.getCpf()).thenReturn("000000000");
        List<Andamento> listaAndamento = new ArrayList<>();
        listaAndamento.add(andamento);
        when(andamentoRepository.recuperarAndamentosPedido(anyLong())).thenReturn(listaAndamento);

        List<Unidade> unidadeList = new ArrayList<>();
        unidadeList.add(unidade);
        when(propostaRespostaDTO.getListaUnidade()).thenReturn(unidadeList);
        when(unidade.getCodigoUnidade()).thenReturn("1");

        when(usuarioLogadoUtil.getPerfil()).thenReturn("teste");
        when(pedido.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(statusSolicitacao.getId()).thenReturn(9L);

        when(usuarioLogadoUtil.getPerfil()).thenReturn("FKS.TECNICO");
        when(subunidade.getUnidade()).thenReturn(unidade);
        List<UsuarioAcessos> usuarioAcessosList = new ArrayList<>();
        usuarioAcessosList.add(usuarioAcessos);
        when(andamento.getUsuarioAcessos()).thenReturn(usuarioAcessosList);

        when(usuarioLogadoUtil.getUsuario()).thenReturn(usuarioAcessos);
        when(usuarioAcessos.getUnidade()).thenReturn(unidade);

        andamentoService.reverterAndamento(pedido, "observacao", propostaRespostaDTO);

    }

    @Test
    public void reverterAndamento7Respondente(){
        List<Andamento> andamentoList = new ArrayList<>();
        andamentoList.add(andamento);
        when(andamentoRepository.recuperarAndamentosPedido(anyLong())).thenReturn(andamentoList);

        when(usuarioLogadoUtil.getPerfil()).thenReturn("FKS.RESPONDENTE");
        when(pedido.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(statusSolicitacao.getId()).thenReturn(6L);

        andamentoService.reverterAndamento(pedido, "observacao", respostaAssinadaDTO);
    }

    @Test
    public void reverterAndamento7PontoFocal(){
        List<Andamento> andamentoList = new ArrayList<>();
        andamentoList.add(andamento);
        when(andamentoRepository.recuperarAndamentosPedido(anyLong())).thenReturn(andamentoList);

        when(usuarioLogadoUtil.getPerfil()).thenReturn("FKS.PONTO.FOCAL");
        when(pedido.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(statusSolicitacao.getId()).thenReturn(2L);

        andamentoService.reverterAndamento(pedido, "observacao", respostaAssinadaDTO);
    }

    @Test
    public void reverterAndamento7Tecnico(){
        List<Andamento> andamentoList = new ArrayList<>();
        andamentoList.add(andamento);
        andamentoList.add(andamento);
        andamentoList.add(andamento);
        andamentoList.add(andamento);
        when(andamentoRepository.recuperarAndamentosPedido(anyLong())).thenReturn(andamentoList);
        when(usuarioLogadoUtil.getNome()).thenReturn("nome");


        when(usuarioLogadoUtil.getPerfil()).thenReturn("FKS.TECNICO");
        when(pedido.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(statusSolicitacao.getId()).thenReturn(7L);

        when(respostaAssinadaDTO.getSubunidade()).thenReturn(subunidade);
        List<UsuarioAcessos> usuarioAcessosList = new ArrayList<>();
        usuarioAcessosList.add(usuarioAcessos);
        usuarioAcessosList.add(usuarioAcessos);
        usuarioAcessosList.add(usuarioAcessos);
        when(andamento.getUsuarioAcessos()).thenReturn(usuarioAcessosList);

        andamentoService.reverterAndamento(pedido, "observacao", respostaAssinadaDTO);
    }

    @Test
    public void reverterAndamentoAdmin(){
        List<Andamento> andamentoList = new ArrayList<>();
        andamentoList.add(andamento);
        when(andamentoRepository.recuperarAndamentosPedido(anyLong())).thenReturn(andamentoList);

        when(usuarioLogadoUtil.getPerfil()).thenReturn("FKS.ADMIN");

        andamentoService.reverterAndamento(pedido, "observacao", respostaAssinadaDTO);
    }

    @Test
    public void reverterAndamentoSic(){
        List<Andamento> andamentoList = new ArrayList<>();
        andamentoList.add(andamento);
        when(andamentoRepository.recuperarAndamentosPedido(anyLong())).thenReturn(andamentoList);

        when(usuarioLogadoUtil.getPerfil()).thenReturn("FKS.SIC");
        when(pedido.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(statusSolicitacao.getId()).thenReturn(1L);

        andamentoService.reverterAndamento(pedido, "observacao", respostaAssinadaDTO);
    }

    @Test
    public void reverterAndamentoEnvio(){
        List<Andamento> andamentoList = new ArrayList<>();
        andamentoList.add(andamento);
        when(andamentoRepository.recuperarAndamentosPedido(anyLong())).thenReturn(andamentoList);

        when(usuarioLogadoUtil.getPerfil()).thenReturn("FKS.SIC");
        when(pedido.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(statusSolicitacao.getId()).thenReturn(5L);

        andamentoService.reverterAndamento(pedido, "observacao", respostaAssinadaDTO);
    }

    @Test
    public void reverterAndamentoDistribuicao(){
        List<Andamento> andamentoList = new ArrayList<>();
        andamentoList.add(andamento);
        when(andamentoRepository.recuperarAndamentosPedido(anyLong())).thenReturn(andamentoList);

        when(usuarioLogadoUtil.getPerfil()).thenReturn("FKS.SIC");
        when(pedido.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(statusSolicitacao.getId()).thenReturn(3L);

        andamentoService.reverterAndamento(pedido, "observacao", respostaAssinadaDTO);
    }

    @Test
    public void reverterAndamentoRespostaSic(){
        List<Andamento> andamentoList = new ArrayList<>();
        andamentoList.add(andamento);
        when(andamentoRepository.recuperarAndamentosPedido(anyLong())).thenReturn(andamentoList);

        when(usuarioLogadoUtil.getPerfil()).thenReturn("FKS.SIC");
        when(pedido.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(statusSolicitacao.getId()).thenReturn(2L);

        andamentoService.reverterAndamento(pedido, "observacao", respostaAssinadaDTO);
    }


}
