package br.com.company.fks.servico;

import br.com.company.fks.modelo.*;
import br.gov.mpog.fks.modelo.*;
import br.com.company.fks.modelo.dto.EouvDTO;
import br.com.company.fks.repositorio.AndamentoRepository;
import br.com.company.fks.repositorio.EouvRepository;
import br.com.company.fks.repositorio.PedidoRepository;
import br.com.company.fks.repositorio.StatusSolicitacaoRepository;
import br.com.company.fks.repositorio.StatusTramitacaoRepository;
import br.com.company.fks.repositorio.UnidadeRepository;
import br.com.company.fks.utils.UsuarioLogadoUtil;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class EouvServiceTest {

    private static final String E_OUV = "Solicitação encaminhada para e-OUV";
    @InjectMocks
    private EouvService eouvService;

    @Mock
    private PedidoService pedidoService;
    @Mock
    private TipoTratamento tipoTratamento;
    @Mock
    private HistoricoTratamentoService historicoTratamentoService;
    @Mock
    private  AndamentoService andamentoService;
    @Mock
    private EOuv eOuv;
    @Mock
    private EouvDTO eouvDTO;
    @Mock
    private  EouvRepository eouvRepository;
    @Mock
    private TipoManifestacao tipoManifestacao;
    @Mock
    private Pedido pedido;
    @Mock
    private Categoria categoria;
    @Mock
    private SubCategoria subCategoria;

    @Mock
    private PedidoRepository pedidoRepository;

    @Mock
    private PalavraChave palavraChave;

    @Mock
    private StatusSolicitacao statusSolicitacao;

    @Mock
    private StatusTramitacao statusTramitacao;

    @Mock
    private UsuarioAcessos usuarioAcessos;

    @Mock
    private UsuarioLogadoUtil usuarioLogadoUtil;

    @Mock
    private Unidade unidade;

    @Mock
    private StatusSolicitacaoRepository statusSolicitacaoRepository;

    @Mock
    private StatusTramitacaoRepository statusTramitacaoRepository;

    @Mock
    private Subunidade subunidade;

    @Mock
    private AndamentoRepository andamentoRepository;

    @Mock
    private Andamento andamento;

    @Mock
    private UnidadeRepository unidadeRepository;

    @Mock
    private UnidadeService unidadeService;

    @Test
    public void salvarTestSave2() {
        when(tipoTratamento.getId()).thenReturn(5L);
        when(pedidoService.alterarStatusEouv(eouvDTO)).thenReturn(pedido);
        when(eouvDTO.getTipoManifestacao()).thenReturn(tipoManifestacao);
        when(tipoManifestacao.getDescricao()).thenReturn("descricao");
        when(eouvDTO.getCategoria()).thenReturn(categoria);
        when(eouvDTO.getSubcategoria()).thenReturn(subCategoria);
        when(eouvDTO.getTipoManifestacao()).thenReturn(tipoManifestacao);
        when(eouvDTO.getRestricaoConteudo()).thenReturn(true);
        when(eouvRepository.save(eOuv)).thenReturn(eOuv);
        when(pedido.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(statusSolicitacao.getId()).thenReturn(1L);
        when(usuarioLogadoUtil.getUsuario()).thenReturn(usuarioAcessos);
        when(usuarioAcessos.getUnidade()).thenReturn(unidade);
        eouvService.salvar(eouvDTO);
   }

   @Test
   public void salvarTestRespostaAssinada(){
        when(pedidoService.alterarStatusEouv(eouvDTO)).thenReturn(pedido);
        when(eouvDTO.getTipoManifestacao()).thenReturn(tipoManifestacao);
        when(tipoManifestacao.getDescricao()).thenReturn("descricao");
        when(eouvRepository.save(eOuv)).thenReturn(eOuv);

        when(pedido.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(statusSolicitacao.getId()).thenReturn(6L);

        when(usuarioLogadoUtil.getPerfil()).thenReturn("FKS.RESPONDENTE");

        when(usuarioLogadoUtil.getUsuario()).thenReturn(usuarioAcessos);

        when(usuarioLogadoUtil.getUsuario()).thenReturn(usuarioAcessos);
        when(usuarioAcessos.getUnidade()).thenReturn(unidade);

        eouvService.salvar(eouvDTO);
   }

   @Test
   public void salvarisValid(){
       when(pedidoService.alterarStatusEouv(eouvDTO)).thenReturn(pedido);
       when(eouvDTO.getTipoManifestacao()).thenReturn(tipoManifestacao);
       when(tipoManifestacao.getDescricao()).thenReturn("descricao");
       when(eouvRepository.save(eOuv)).thenReturn(eOuv);

       when(pedido.getStatusSolicitacao()).thenReturn(statusSolicitacao);
       when(statusSolicitacao.getId()).thenReturn(7L);
       when(usuarioLogadoUtil.getPerfil()).thenReturn("FKS.TECNICO");

       when(eouvDTO.getIdPedido()).thenReturn(1L);
       List<Andamento> andamentoList = new ArrayList<>();
       andamentoList.add(andamento);
       andamentoList.add(andamento);
       andamentoList.add(andamento);
       when(andamentoRepository.recuperarAndamentosPedido(1L)).thenReturn(andamentoList);
       List<UsuarioAcessos> usuarioAcessosList = new ArrayList<>();
       usuarioAcessosList.add(usuarioAcessos);
       usuarioAcessosList.add(usuarioAcessos);
       usuarioAcessosList.add(usuarioAcessos);
       when(andamento.getUsuarioAcessos()).thenReturn(usuarioAcessosList);

       when(usuarioLogadoUtil.getUsuario()).thenReturn(usuarioAcessos);

       eouvService.salvar(eouvDTO);
   }

   @Test
   public void salvarTestRespostaRespostaSic(){
        when(pedidoService.alterarStatusEouv(eouvDTO)).thenReturn(pedido);
        when(eouvDTO.getTipoManifestacao()).thenReturn(tipoManifestacao);
        when(tipoManifestacao.getDescricao()).thenReturn("descricao");
        when(eouvRepository.save(eOuv)).thenReturn(eOuv);

        when(pedido.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(statusSolicitacao.getId()).thenReturn(2L);

        when(usuarioLogadoUtil.getPerfil()).thenReturn("FKS.PONTO.FOCAL");

        when(unidadeRepository.findOne(1L)).thenReturn(unidade);
        eouvService.salvar(eouvDTO);
   }

   @Test
   public void validarEouv(){
        when(pedidoRepository.findOne(1L)).thenReturn(pedido);
        when(pedido.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(statusSolicitacao.getId()).thenReturn(7L);
        when(usuarioLogadoUtil.getPerfil()).thenReturn("FKS.RESPONDENTE");
        when(statusSolicitacao.getId()).thenReturn(6L);
        when(statusTramitacao.getId()).thenReturn(2L);
        when(usuarioLogadoUtil.getUsuario()).thenReturn(usuarioAcessos);
        eouvService.validarEouv(1L);
   }

   @Test
   public void validarEouvRespondente(){
       when(pedidoRepository.findOne(1L)).thenReturn(pedido);
       when(pedido.getStatusSolicitacao()).thenReturn(statusSolicitacao);
       when(statusSolicitacao.getId()).thenReturn(7L);
       when(usuarioLogadoUtil.getPerfil()).thenReturn("FKS.RESPONDENTE");
       when(statusSolicitacao.getId()).thenReturn(7L);

       when(statusSolicitacaoRepository.findOne(1L)).thenReturn(statusSolicitacao);
       when(statusTramitacaoRepository.findOne(1L)).thenReturn(statusTramitacao);

       when(usuarioLogadoUtil.getUsuario()).thenReturn(usuarioAcessos);

       eouvService.validarEouv(1L);
   }

   @Test
   public void validarEouvSic(){
       when(pedidoRepository.findOne(1L)).thenReturn(pedido);
       when(pedido.getStatusSolicitacao()).thenReturn(statusSolicitacao);
       when(statusSolicitacao.getId()).thenReturn(2L);
       when(usuarioLogadoUtil.getPerfil()).thenReturn("FKS.ATENDENTE.SIC");
       when(statusSolicitacao.getId()).thenReturn(2L);

       when(usuarioLogadoUtil.getUsuario()).thenReturn(usuarioAcessos);
       when(usuarioAcessos.getUnidade()).thenReturn(unidade);

       eouvService.validarEouv(1L);
   }

   @Test
   public void validarEouvSicAtendenteSic(){
       when(pedidoRepository.findOne(1L)).thenReturn(pedido);
       when(pedido.getStatusSolicitacao()).thenReturn(statusSolicitacao);
       when(statusSolicitacao.getId()).thenReturn(1L);
       when(usuarioLogadoUtil.getPerfil()).thenReturn("FKS.ATENDENTE.SIC");
       when(statusSolicitacao.getId()).thenReturn(1L);

       when(usuarioLogadoUtil.getUsuario()).thenReturn(usuarioAcessos);
       when(usuarioAcessos.getUnidade()).thenReturn(unidade);

       eouvService.validarEouv(1L);
   }

   @Test
   public void validarEouvSicPontoFocal(){
       when(pedidoRepository.findOne(1L)).thenReturn(pedido);
       when(pedido.getStatusSolicitacao()).thenReturn(statusSolicitacao);
       when(statusSolicitacao.getId()).thenReturn(2L);
       when(usuarioLogadoUtil.getPerfil()).thenReturn("FKS.ATENDENTE.SIC");
       when(statusSolicitacao.getId()).thenReturn(2L);

       when(usuarioLogadoUtil.getUsuario()).thenReturn(usuarioAcessos);
       when(usuarioAcessos.getUnidade()).thenReturn(unidade);

       when(pedido.getStatusSolicitacao()).thenReturn(statusSolicitacao);
       when(statusSolicitacao.getId()).thenReturn(3L);
       when(usuarioLogadoUtil.getPerfil()).thenReturn("FKS.PONTO.FOCAL");

       eouvService.validarEouv(1L);
   }

   @Test
   public void validarEouvSicRepostaAssinada(){
       when(pedidoRepository.findOne(1L)).thenReturn(pedido);
       when(pedido.getStatusSolicitacao()).thenReturn(statusSolicitacao);
       when(statusSolicitacao.getId()).thenReturn(2L);
       when(usuarioLogadoUtil.getPerfil()).thenReturn("FKS.ATENDENTE.SIC");
       when(statusSolicitacao.getId()).thenReturn(2L);

       when(unidadeService.getOneSubunidadePeloUsuarioCpf("00000000000")).thenReturn(subunidade);
       when(usuarioLogadoUtil.getCpf()).thenReturn("00000000000");

       when(pedido.getStatusSolicitacao()).thenReturn(statusSolicitacao);
       when(statusSolicitacao.getId()).thenReturn(8L);
       when(usuarioLogadoUtil.getPerfil()).thenReturn("FKS.TECNICO");

       eouvService.validarEouv(1L);
   }

    @Test
    public void  verificaSeExisteEOuvPedidoTest(){
        when(eouvRepository.findByEOuvPorIdPedido(any(Pedido.class))).thenReturn(eOuv);
        assertEquals(eouvService.verificaSeExisteEOuvPedido(pedido), eOuv != null);
    }

    @Test
    public void buscarPalavraChavePedido(){
        when(pedidoRepository.findOne(1L)).thenReturn(pedido);
        List<PalavraChave> palavraChaveList = new ArrayList<>();
        palavraChaveList.add(palavraChave);
        when(pedido.getPalavraChaveList()).thenReturn(palavraChaveList);
        eouvService.buscarPalavraChavePedido(1L);
    }
}
