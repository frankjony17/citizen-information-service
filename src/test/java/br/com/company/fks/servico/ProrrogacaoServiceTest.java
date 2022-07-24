package br.com.company.fks.servico;

import br.com.company.fks.excecao.IntegracaoException;
import br.com.company.fks.modelo.Andamento;
import br.com.company.fks.modelo.MotivoProrrogacao;
import br.com.company.fks.modelo.Pedido;
import br.com.company.fks.modelo.Prorrogacao;
import br.com.company.fks.modelo.dto.ProrrogacaoCadastroDTO;
import br.com.company.fks.repositorio.MotivoProrrogacaoRepository;
import br.com.company.fks.repositorio.PedidoRepository;
import br.com.company.fks.repositorio.ProrrogacaoRepository;
import br.com.company.fks.utils.DataUtil;
import lombok.SneakyThrows;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.Calendar;
import java.util.List;

import static org.mockito.Matchers.*;
import static org.mockito.Mockito.when;

@RunWith(PowerMockRunner.class)
@PrepareForTest(DataUtil.class)
public class ProrrogacaoServiceTest {
    @InjectMocks
    private ProrrogacaoService prorrogacaoService;

    @Mock
    private PedidoRepository pedidoRepository;
    @Mock
    private  ProrrogacaoCadastroDTO prorrogacaoCadastroDTO;
    @Mock
    private Pedido pedido;

    @Mock
    private ProrrogacaoRepository prorrogacaoRepository;

    @Mock
    private Prorrogacao prorrogacao;

    @Mock
    private AndamentoService andamentoService;

    @Mock
    private Andamento andamento;
    @Mock
    private MotivoProrrogacaoRepository motivoProrrogacaoRepository;
    @Mock
    private MotivoProrrogacao motivoProrrogacao;
    @Mock
    private List<Calendar> calendarList;
    @Mock
    private FeriadoService feriadoService;
    @Mock
    private Calendar calendar;
    @Mock
    private Calendar vencimentoUnidade;


    @Test
    public void criarProrrogacaoTest() throws IntegracaoException {
        when(prorrogacaoCadastroDTO.getIdMotivoProrrogacao()).thenReturn(1l);
        when(prorrogacaoCadastroDTO.getJustificativaProrrogacao()).thenReturn("morum");
        PowerMockito.mockStatic(DataUtil.class);
        when(motivoProrrogacaoRepository.findOne(anyLong())).thenReturn(motivoProrrogacao);
        when(motivoProrrogacao.getNome()).thenReturn("teste");
        when(pedidoRepository.findById(anyLong())).thenReturn(pedido);
        when(pedidoRepository.save(any(Pedido.class))).thenReturn(pedido);
        when(prorrogacaoRepository.save(any(Prorrogacao.class))).thenReturn(prorrogacao);
        prorrogacaoService.criarProrrogacao(prorrogacaoCadastroDTO);
    }

    @Test
    public void verificaObservacaoDaProrrogacaoTest(){
        String teste = "teste";
        when(motivoProrrogacaoRepository.findOne(anyLong())).thenReturn(motivoProrrogacao);
        when(motivoProrrogacao.getNome()).thenReturn(teste);
        when(prorrogacao.isESic()).thenReturn(true);
        prorrogacaoService.verificaObservacaoDaProrrogacao(prorrogacao,prorrogacaoCadastroDTO);
    }
    @Test
    public void verificaObservacaoDaProrrogacaoTestFalse(){
        String teste = "teste";
        when(motivoProrrogacaoRepository.findOne(anyLong())).thenReturn(motivoProrrogacao);
        when(motivoProrrogacao.getNome()).thenReturn(teste);
        when(prorrogacao.isESic()).thenReturn(false);
        prorrogacaoService.verificaObservacaoDaProrrogacao(prorrogacao,prorrogacaoCadastroDTO);
    }
    @Test
    public void verificaTipoProrrogacaoTest()
    {
        prorrogacaoService.verificaTipoProrrogacao(prorrogacaoCadastroDTO);
    }

    @Test
    public void verificaDataProrrogacaoTest(){
        when(feriadoService.listaFeriadosFKS()).thenReturn(calendarList);
        when(prorrogacaoCadastroDTO.isESic()).thenReturn(true);
        prorrogacaoService.verificaDataProrrogacao(prorrogacaoCadastroDTO,pedido);
    }
    @Test
    public void verificaDataProrrogacaoTestF(){
        when(feriadoService.listaFeriadosFKS()).thenReturn(calendarList);
        when(prorrogacaoCadastroDTO.isESic()).thenReturn(false);
        PowerMockito.mockStatic(DataUtil.class);
        prorrogacaoService.verificaDataProrrogacao(prorrogacaoCadastroDTO,pedido);
    }
    @Test
    public void verificaPrazoProrrogadoEsicOuFKSTest(){
        prorrogacaoService.verificaPrazoProrrogadoEsicOuFKS(prorrogacaoCadastroDTO,pedido);
    }
    @Test
    public void verificaPrazoProrrogadoEsicOuFKSTest2(){
        when(prorrogacaoCadastroDTO.isESic()).thenReturn(true);
        prorrogacaoService.verificaTipoProrrogacao(prorrogacaoCadastroDTO);
        prorrogacaoService.verificaPrazoProrrogadoEsicOuFKS(prorrogacaoCadastroDTO,pedido);

    }

    @Test(expected = IntegracaoException.class)
    @SneakyThrows
    public void validarPeenchimentoCamposObrigatoriosTest() {

        when(prorrogacaoCadastroDTO.getIdMotivoProrrogacao()).thenReturn(null);
        prorrogacaoService.criarProrrogacao(prorrogacaoCadastroDTO);

    }
    @Test(expected = IntegracaoException.class)
    @SneakyThrows
    public void validarPeenchimentoCamposObrigatoriosTest2() {

        when(prorrogacaoCadastroDTO.getJustificativaProrrogacao()).thenReturn("");
        prorrogacaoService.criarProrrogacao(prorrogacaoCadastroDTO);

    }

    @Test
    public void consultarProrrogacaoTest(){
        when(pedidoRepository.findById(anyLong())).thenReturn(pedido);
        when(prorrogacaoRepository.consultarProrrogacaoPorIdPedido(any(Pedido.class),anyBoolean())).thenReturn(prorrogacao);
        when(prorrogacao.getMotivoProrrogacao()).thenReturn(motivoProrrogacao);
        when(prorrogacao.getPedido()).thenReturn(pedido);
        prorrogacaoService.consultarProrrogacao(5l);
    }

    @Test
    public void consultarProrrogacaoEsicTest(){
        when(pedidoRepository.findById(anyLong())).thenReturn(pedido);
        when(prorrogacaoRepository.consultarProrrogacaoPorIdPedido(any(Pedido.class),anyBoolean())).thenReturn(prorrogacao);
        when(prorrogacao.getMotivoProrrogacao()).thenReturn(motivoProrrogacao);
        when(prorrogacao.getPedido()).thenReturn(pedido);
        prorrogacaoService.consultarProrrogacaoEsic(5l);
    }

    @Test
    public void criarProrrogacao() throws IntegracaoException{
        Andamento andamento = new Andamento();
        ProrrogacaoCadastroDTO prorrogacaoCadastroDTO = new ProrrogacaoCadastroDTO();
        Prorrogacao prorrogacao = new Prorrogacao();
        MotivoProrrogacao motivoProrrogacao = new MotivoProrrogacao();
        Pedido pedido = new Pedido();
        pedido.setVencimentoUnidade(vencimentoUnidade);
        prorrogacaoCadastroDTO.setIdPedido(1L);
        prorrogacaoCadastroDTO.setJustificativaProrrogacao("justProrro");
        prorrogacaoCadastroDTO.setIdMotivoProrrogacao(1L);
        prorrogacao.setId(null);
        prorrogacao.setESic(true);
        prorrogacao.setPedido(pedido);
        prorrogacao.setJustificativaProrrogacao("jus");
        prorrogacao.setMotivoProrrogacao(motivoProrrogacao);
        motivoProrrogacao.setId(1L);
        motivoProrrogacao.setNome("nome");
        when(pedidoRepository.findById(anyLong())).thenReturn(pedido);
        when(motivoProrrogacaoRepository.findOne(anyLong())).thenReturn(motivoProrrogacao);
        when(andamentoService.gerarAndamentoSolicitacao(pedido,false,"obs")).thenReturn(andamento);
        prorrogacaoService.criarProrrogacao(prorrogacaoCadastroDTO);

    }





}
