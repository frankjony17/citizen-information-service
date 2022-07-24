package br.com.company.fks.repositorio.custom;

import br.com.company.fks.modelo.Pedido;
import br.com.company.fks.modelo.Solicitante;
import br.com.company.fks.modelo.StatusSolicitacao;
import br.com.company.fks.modelo.StatusTramitacao;
import br.com.company.fks.modelo.UsuarioAcessos;
import br.com.company.fks.modelo.dto.ConsultaPedidoDTO;
import br.com.company.fks.modelo.dto.FiltroPedidoDTO;
import br.com.company.fks.modelo.dto.usuarioacesso.UsuarioLogadoDTO;
import br.com.company.fks.modelo.enums.PerfilAcessoEnum;
import br.com.company.fks.servico.usuario.UsuarioService;
import br.com.company.fks.utils.UsuarioLogadoUtil;
import org.apache.poi.ss.formula.functions.T;
import org.junit.Assert;
import org.junit.Before;
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

import javax.persistence.EntityManager;
import javax.persistence.Query;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by christian-tavares on 21/03/18.
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(PerfilAcessoEnum.class)
public class PedidoCustomRepositorioTest {

    @InjectMocks
    private PedidoCustomRepositorio pedidoCustomRepositorio;

    @Mock
    private EntityManager entityManager;

    @Mock
    private Query query;
    @Mock
    private FiltroPedidoDTO filtroPedidoDTO;

    @Mock
    private UsuarioService usuarioService;

    @Mock
    private UsuarioLogadoDTO usuarioLogadoDTO;

    @Mock
    private StatusSolicitacao statusSolicitacao;

    @Mock
    private Pedido pedido;

    @Mock
    private ConsultaPedidoDTO consultaPedidoDTO;

    @Mock
    private Solicitante solicitante;

    @Mock
    private StatusTramitacao statusTramitacao;

    @Mock
    private UsuarioLogadoUtil usuarioLogadoUtil;

    @Test
    public void efetuarConsultaPaginadaPedido(){
        List<Pedido> listaPedido = new ArrayList<>();
        listaPedido.add(pedido);
        FiltroPedidoDTO filtroPedidoDTO = new FiltroPedidoDTO();
        pedidoCustomRepositorio.efetuarConsultaPaginadaPedido(filtroPedidoDTO,true);
    }

    @Test
    public void efetuarConsultaPaginaPedidoCasesParte2(){
        List<Pedido> listaPedido = new ArrayList<>();
        listaPedido.add(pedido);
        FiltroPedidoDTO filtroPedidoDTO = new FiltroPedidoDTO();
        pedidoCustomRepositorio.efetuarConsultaPaginaPedidoCasesParte2(filtroPedidoDTO,1,true);
    }

    @Test
    public void montarCondicionaisParte1Teste() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = PedidoCustomRepositorio.class.getDeclaredMethod("montarCondicionaisParte1");
        method.setAccessible(true);
        String result = (String) method.invoke(pedidoCustomRepositorio);
        Assert.assertEquals("AND ('ignoraClausula' = :igTextoSolicitacao OR UPPER(pedido.descricaoPedido) LIKE UPPER(:textoSolicitacao)) AND ('ignoraClausula' = :igTextoResposta OR UPPER(pedido.respostaEsic) LIKE UPPER(:textoResposta)) AND ('ignoraClausula' = :igPrazoVencidoFKS OR pedido.vencimentoUnidade < :prazoVencidoFKS) AND ('ignoraClausula' = :igPrazoVencidoEsic OR pedido.prazoAtendimento < :prazoVencidoEsic) AND ('ignoraClausula' = :igPeriodoInicialVencimentoEsic OR pedido.prazoAtendimento >= :periodoInicialVencimentoEsic) AND ('ignoraClausula' = :igPeriodoFinalVencimentoEsic OR pedido.prazoAtendimento <= :periodoFinalVencimentoEsic) AND ('ignoraClausula' = :igPrazoProrrogadoFKS OR pedido.statusVencimentoUnidadeProrrogado = :prazoProrrogadoFKS) AND ('ignoraClausula' = :igPrazoProrrogadoEsic OR pedido.statusPrazoAtendimentoEsicProrrogado = :prazoProrrogadoEsic) AND ('ignoraClausula' = :igPrazoProrrogadoEsic OR pedido.statusPrazoAtendimentoEsicProrrogado = :prazoProrrogadoEsic) ",
                result);
    }

    @Test
    public void montarCondicionaisParte2Teste() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = PedidoCustomRepositorio.class.getDeclaredMethod("montarCondicionaisParte2");
        method.setAccessible(true);
        String result = (String) method.invoke(pedidoCustomRepositorio);
        Assert.assertEquals("AND ('ignoraClausula' = :igIdStatusTramitacao OR pedido.statusTramitacao.id = :idStatusTramitacao) AND ('ignoraClausula' = :igIdStatusSituacao OR pedido.statusSituacao.id = :idStatusSituacao) AND ('ignoraClausula' = :igIdTema OR pedido.tema.id = :idTema) AND ('ignoraClausula' = :igProtocolo OR pedido.protocolo = :protocolo) AND ('ignoraClausula' = :igPeriodoInicialDataAbertura OR pedido.dataRegistro >= :periodoInicialDataAbertura) AND ('ignoraClausula' = :igPeriodoFinalDataAbertura OR pedido.dataRegistro <= :periodoFinalDataAbertura) AND ('ignoraClausula' = :igPeriodoInicialPrazoAtendimento OR pedido.vencimentoUnidade >= :periodoInicialPrazoAtendimento) AND ('ignoraClausula' = :igPeriodoFinalPrazoAtendimento OR pedido.vencimentoUnidade <= :periodoFinalPrazoAtendimento) AND ('ignoraClausula' = :igNomeSolicitante OR UPPER(pedido.solicitante.nome) LIKE UPPER(:nomeSolicitante)) AND ('ignoraClausula' = :igTipoPessoa OR pedido.solicitante.tipoPessoa = :tipoPessoa) AND ('ignoraClausula' = :igIdStatusSolicitacao OR pedido.statusSolicitacao.id = :idStatusSolicitacao) AND ('ignoraClausula' = :igIdSituacaoPedido OR pedido.situacaoPedido.id = :idSituacaoPedido) AND ('ignoraClausula' = :igDemandasComigo OR pedido.statusTramitacao.id = :idStatusTramitacao) AND ('ignoraClausula' = :igIdentidadePreservada OR substring(pedido.solicitante.nome,1,1) in ('0','1','2','3','4','5','6','7','8','9')) ",
                result);
    }

    @Test
    public void adicionarParametrosParte1Teste() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = PedidoCustomRepositorio.class.getDeclaredMethod("adicionarParametrosParte1", javax.persistence.Query.class, FiltroPedidoDTO.class);
        method.setAccessible(true);
        method.invoke(pedidoCustomRepositorio, query, filtroPedidoDTO);
        verify(query, times(14)).setParameter(anyString(), Mockito.any(Object.class));
    }

    @Test
    public void adicionarParametrosParte2Teste() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = PedidoCustomRepositorio.class.getDeclaredMethod("adicionarParametrosParte2", Query.class, FiltroPedidoDTO.class);
        method.setAccessible(true);
        method.invoke(pedidoCustomRepositorio, query, filtroPedidoDTO);
        verify(query, times(15)).setParameter(anyString(), Mockito.any(Object.class));
    }

    @Test
    public void adicionarParametrosParte3Teste() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = PedidoCustomRepositorio.class.getDeclaredMethod("adicionarParametrosParte3", Query.class, FiltroPedidoDTO.class);
        method.setAccessible(true);
        method.invoke(pedidoCustomRepositorio, query, filtroPedidoDTO);
        verify(query, times(12)).setParameter(anyString(), Mockito.any(Object.class));
    }

    @Test
    public void adicionarParametrosParte4TesteElse() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = PedidoCustomRepositorio.class.getDeclaredMethod("adicionarParametrosParte4Verificacao", Query.class, int.class);
        method.setAccessible(true);
        method.invoke(pedidoCustomRepositorio, query, 8);
        verify(query, times(3)).setParameter(anyString(), Mockito.any(Object.class));
    }

    @Test
    public void adicionarParametrosParte4TesteElseIf() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = PedidoCustomRepositorio.class.getDeclaredMethod("adicionarParametrosParte4Verificacao", Query.class, int.class);
        method.setAccessible(true);
        method.invoke(pedidoCustomRepositorio, query, 7);
        verify(query, times(4)).setParameter(anyString(), Mockito.any(Object.class));
    }

    @Test
    public void adicionarParametrosParte4TesteVerificacaoIf() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = PedidoCustomRepositorio.class.getDeclaredMethod("adicionarParametrosParte4Verificacao", Query.class, int.class);
        method.setAccessible(true);
        method.invoke(pedidoCustomRepositorio, query, 9);
        verify(query, times(3)).setParameter(anyString(), Mockito.any(Object.class));
    }

    @Test
    public void adicionarParametrosParte5TesteCase2() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        when(filtroPedidoDTO.getIdDemandasComigo()).thenReturn(2);

        Method method = PedidoCustomRepositorio.class.getDeclaredMethod("adicionarParametrosParte5", Query.class, int.class, FiltroPedidoDTO.class);
        method.setAccessible(true);
        method.invoke(pedidoCustomRepositorio, query, 1,filtroPedidoDTO);
        verify(query, times(2)).setParameter(anyString(), Mockito.any(Object.class));
    }

    @Test
    public void adicionarParametrosParte5TesteCase3() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        when(filtroPedidoDTO.getIdDemandasComigo()).thenReturn(3);

        Method method = PedidoCustomRepositorio.class.getDeclaredMethod("adicionarParametrosParte5", Query.class, int.class, FiltroPedidoDTO.class);
        method.setAccessible(true);
        method.invoke(pedidoCustomRepositorio, query, 1,filtroPedidoDTO);
        verify(query, times(4)).setParameter(anyString(), Mockito.any(Object.class));
    }

    @Test
    public void adicionarParametrosParte5TesteCaseDefault() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        when(filtroPedidoDTO.getIdDemandasComigo()).thenReturn(5);

        Method method = PedidoCustomRepositorio.class.getDeclaredMethod("adicionarParametrosParte5", Query.class, int.class, FiltroPedidoDTO.class);
        method.setAccessible(true);
        method.invoke(pedidoCustomRepositorio, query, 1,filtroPedidoDTO);
        verify(query, times(2)).setParameter(anyString(), Mockito.any(Object.class));
    }

    @Test
    public void getHQLCountConsultaPedidoTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = PedidoCustomRepositorio.class.getDeclaredMethod("getHqlCountConsultaPedido");
        method.setAccessible(true);
        Assert.assertNotNull(method.invoke(pedidoCustomRepositorio));
    }

    @Test
    public void efetuarConsultaContadorTotalPedidoCase78If() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        UsuarioAcessos usuarioAcessos = Mockito.mock(UsuarioAcessos.class);
        when(entityManager.createNativeQuery(anyString())).thenReturn(query);
        when(filtroPedidoDTO.getIdDemandasComigo()).thenReturn(2);
        when(usuarioLogadoUtil.getUsuario()).thenReturn(usuarioAcessos);
        when(usuarioAcessos.getId()).thenReturn(1L);
        Method method = PedidoCustomRepositorio.class.getDeclaredMethod("efetuarConsultaContadorTotalPedidoCase78", FiltroPedidoDTO.class);
        method.setAccessible(true);
        Assert.assertNotNull(method.invoke(pedidoCustomRepositorio, filtroPedidoDTO));
    }

    @Test
    public void efetuarConsultaContadorTotalPedidoCase78Else() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        UsuarioAcessos usuarioAcessos = Mockito.mock(UsuarioAcessos.class);
        when(entityManager.createNativeQuery(anyString())).thenReturn(query);
        when(filtroPedidoDTO.getIdDemandasComigo()).thenReturn(3);
        when(usuarioLogadoUtil.getUsuario()).thenReturn(usuarioAcessos);
        when(usuarioAcessos.getId()).thenReturn(1L);
        Method method = PedidoCustomRepositorio.class.getDeclaredMethod("efetuarConsultaContadorTotalPedidoCase78", FiltroPedidoDTO.class);
        method.setAccessible(true);
        Assert.assertNotNull(method.invoke(pedidoCustomRepositorio, filtroPedidoDTO));
    }

    @Test
    public void efetuarConsultaContadortotalPedidoCase5Test() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        when(entityManager.createNativeQuery(anyString())).thenReturn(query);
        Method method = PedidoCustomRepositorio.class.getDeclaredMethod("efetuarConsultaContadorTotalPedidoCase5", FiltroPedidoDTO.class, int.class);
        method.setAccessible(true);
        Assert.assertNotNull(method.invoke(pedidoCustomRepositorio, filtroPedidoDTO, 5));
    }

    @Test
    public void efetuarConsultaContadorTotalPedidoCase123TesteBase() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        when(entityManager.createNativeQuery(anyString())).thenReturn(query);
        when(entityManager.createQuery(anyString())).thenReturn(query);
        Method method = PedidoCustomRepositorio.class.getDeclaredMethod("efetuarConsultaContadorTotalPedidoCase123", FiltroPedidoDTO.class, int.class);
        method.setAccessible(true);
        Assert.assertNotNull(method.invoke(pedidoCustomRepositorio, filtroPedidoDTO, 5));
    }

    @Test
    public void efetuarConsultaContadorTotalPedidoCase123TestElseIf() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        when(entityManager.createNativeQuery(anyString())).thenReturn(query);
        when(entityManager.createQuery(anyString())).thenReturn(query);
        when(filtroPedidoDTO.getIdDemandasComigo()).thenReturn(2);
        Method method = PedidoCustomRepositorio.class.getDeclaredMethod("efetuarConsultaContadorTotalPedidoCase123", FiltroPedidoDTO.class, int.class);
        method.setAccessible(true);
        Assert.assertNotNull(method.invoke(pedidoCustomRepositorio, filtroPedidoDTO, 5));
    }

    @Test
    public void efetuarConsultaContadorTotalPedidoCase123TestIf() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        when(entityManager.createNativeQuery(anyString())).thenReturn(query);
        when(entityManager.createQuery(anyString())).thenReturn(query);
        when(filtroPedidoDTO.getIdDemandasComigo()).thenReturn(3);
        Method method = PedidoCustomRepositorio.class.getDeclaredMethod("efetuarConsultaContadorTotalPedidoCase123", FiltroPedidoDTO.class, int.class);
        method.setAccessible(true);
        Assert.assertNotNull(method.invoke(pedidoCustomRepositorio, filtroPedidoDTO, 5));
    }
    @Test
    public void efetuarconsultaContadorTotalPedidoCasesParte2Test() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        when(entityManager.createNativeQuery(anyString())).thenReturn(query);
        Method method = PedidoCustomRepositorio.class.getDeclaredMethod("efetuarConsultaContadorTotalPedidoCasesParte2", FiltroPedidoDTO.class, int.class);
        method.setAccessible(true);
        Assert.assertNotNull(method.invoke(pedidoCustomRepositorio, filtroPedidoDTO, 4));
    }

    @Test
    public void efetuarconsultaContadorTotalPedidoCasesParte2Test78() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        when(entityManager.createNativeQuery(anyString())).thenReturn(query);
        Method method = PedidoCustomRepositorio.class.getDeclaredMethod("efetuarConsultaContadorTotalPedidoCasesParte2", FiltroPedidoDTO.class, int.class);
        method.setAccessible(true);
        Assert.assertNotNull(method.invoke(pedidoCustomRepositorio, filtroPedidoDTO, 7));
    }

    @Test
    public void efetuarconsultaContadorTotalPedidoCasesTest123() throws Exception {
        when(entityManager.createNativeQuery(anyString())).thenReturn(query);
        when(filtroPedidoDTO.getIdDemandasComigo()).thenReturn(3);
        when(query.setParameter(anyString(), any())).thenReturn(query);
        PedidoCustomRepositorio spy = spy(pedidoCustomRepositorio);
        PowerMockito.when(spy, "efetuarConsultaContadorTotalPedidoCase123", filtroPedidoDTO, 1).thenReturn("Teste");
        Method method = PedidoCustomRepositorio.class.getDeclaredMethod("efetuarConsultaContadorTotalPedidoCases", FiltroPedidoDTO.class, int.class);
        method.setAccessible(true);
        Assert.assertNotNull(method.invoke(spy, filtroPedidoDTO, 1));
    }

    @Test
    public void efetuarconsultaContadorTotalPedidoCasesTest5() throws Exception {
        when(entityManager.createNativeQuery(anyString())).thenReturn(query);
        when(filtroPedidoDTO.getIdDemandasComigo()).thenReturn(3);
        when(query.setParameter(anyString(), any())).thenReturn(query);
        PedidoCustomRepositorio spy = spy(pedidoCustomRepositorio);
        PowerMockito.when(spy, "efetuarConsultaContadorTotalPedidoCase5", filtroPedidoDTO, 5).thenReturn(query);
        Method method = PedidoCustomRepositorio.class.getDeclaredMethod("efetuarConsultaContadorTotalPedidoCases", FiltroPedidoDTO.class, int.class);
        method.setAccessible(true);
        Assert.assertNotNull(method.invoke(spy, filtroPedidoDTO, 5));
    }

    @Test
    public void efetuarconsultaContadorTotalPedidoCasesTestDefault() throws Exception {
        when(entityManager.createNativeQuery(anyString())).thenReturn(query);
        when(filtroPedidoDTO.getIdDemandasComigo()).thenReturn(8);
        when(query.setParameter(anyString(), any())).thenReturn(query);
        PedidoCustomRepositorio spy = spy(pedidoCustomRepositorio);
        PowerMockito.when(spy, "efetuarConsultaContadorTotalPedidoCasesParte2", filtroPedidoDTO, 8).thenReturn(query);
        Method method = PedidoCustomRepositorio.class.getDeclaredMethod("efetuarConsultaContadorTotalPedidoCases", FiltroPedidoDTO.class, int.class);
        method.setAccessible(true);
        Assert.assertNotNull(method.invoke(spy, filtroPedidoDTO, 8));
    }

    @Test
    public void montarQueryPedido() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = PedidoCustomRepositorio.class.getDeclaredMethod("montarQueryPedido");
        method.setAccessible(true);
        Assert.assertNotNull(method.invoke(pedidoCustomRepositorio));
    }

}
