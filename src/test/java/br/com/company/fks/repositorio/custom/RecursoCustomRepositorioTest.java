package br.com.company.fks.repositorio.custom;

import br.com.company.fks.modelo.Pedido;
import br.com.company.fks.modelo.Recurso;
import br.com.company.fks.modelo.SituacaoRecurso;
import br.com.company.fks.modelo.Solicitante;
import br.com.company.fks.modelo.TipoRecurso;
import br.com.company.fks.modelo.Unidade;
import br.com.company.fks.modelo.UsuarioAcessos;
import br.com.company.fks.modelo.dto.FiltroRecursoDTO;
import br.com.company.fks.modelo.dto.usuarioacesso.UsuarioLogadoDTO;
import br.com.company.fks.modelo.enums.PerfilAcessoEnum;
import br.com.company.fks.repositorio.base.RepositorioBase;
import br.com.company.fks.servico.usuario.UsuarioService;
import br.com.company.fks.utils.UsuarioLogadoUtil;
import io.jsonwebtoken.lang.Assert;
import lombok.SneakyThrows;
import org.hibernate.jpa.criteria.compile.CriteriaQueryTypeQueryAdapter;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyList;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.spy;

/**
 * Created by Maicon Godoy - FKSolutions Tecnologia on 15/08/18.
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(PerfilAcessoEnum.class)
public class RecursoCustomRepositorioTest {
    @InjectMocks
    private RecursoCustomRepositorio recursoCustomRepositorio;
    @Mock
    private RepositorioBase repositorioBase;

    @Mock
    private EntityManager entityManager;

    @Mock
    private Query query;

    @Mock
    private FiltroRecursoDTO filtroRecursoDTO;

    @Mock
    private UsuarioService usuarioService;

    @Mock
    private UsuarioLogadoUtil usuarioLogadoUtil;

    @Mock
    private Recurso recurso;

    @Mock
    private Pedido pedido;

    @Mock
    private TipoRecurso tipoRecurso;

    @Mock
    private Calendar calendar;

    @Mock
    private SituacaoRecurso situacaoRecurso;

    @Mock
    private Solicitante solicitante;

    @Mock
    private List list;

    @Mock
    private UsuarioLogadoDTO usuarioLogadoDTO;

    @Mock
    private UsuarioAcessos usuarioAcessos;

    @Mock
    private Unidade unidade;

    @Test
    @SneakyThrows
    public void getEntityClass() {
        Method objeto = RecursoCustomRepositorio.class.getDeclaredMethod(

                "getEntityClass"
        );
        objeto.setAccessible(true);
        RecursoCustomRepositorio objeto2 = new RecursoCustomRepositorio();
        Class result = (Class)objeto.invoke(objeto2);
        assertEquals(result,Recurso.class);
    }

    @Test
    public void efetuarConsultaPaginadaRecurso() {
        List<Recurso> recursoList = new ArrayList<>();
        recursoList.add(recurso);
        when(repositorioBase.getEntityManager()).thenReturn(entityManager);
        when(entityManager.createQuery(anyString())).thenReturn(query);
        when(query.getResultList()).thenReturn(recursoList);
        when(usuarioService.getUsuarioLogadoPerfis()).thenReturn(usuarioLogadoDTO);
        when(recurso.getPedido()).thenReturn(pedido);
        when(pedido.getId()).thenReturn(1L);
        when(recurso.getTipoRecurso()).thenReturn(tipoRecurso);
        when(tipoRecurso.getNome()).thenReturn("teste");
        when(recurso.getDataAbertura()).thenReturn(calendar);
        when(recurso.getDataPrazoAtendimento()).thenReturn(calendar);
        when(recurso.getSituacaoRecurso()).thenReturn(situacaoRecurso);
        when(situacaoRecurso.getNome()).thenReturn("teste");
        when(recurso.getPedido()).thenReturn(pedido);
        when(pedido.getSolicitante()).thenReturn(solicitante);
        when(solicitante.getNome()).thenReturn("teste");
        recursoCustomRepositorio.efetuarConsultaPaginadaRecurso(filtroRecursoDTO, true);
    }

    @Test
    public void detalharRecurso() {
        List<Recurso> recursoList = new ArrayList<>();
        recursoList.add(recurso);
        when(repositorioBase.getEntityManager()).thenReturn(entityManager);
        when(entityManager.createQuery(anyString())).thenReturn(query);
        when(query.getResultList()).thenReturn(recursoList);
        when(usuarioLogadoUtil.getPerfil()).thenReturn("FKS.PONTO.FOCAL");
        recursoCustomRepositorio.detalharRecurso(1L);
    }

    @Test
    public void efetuarConsultaRecurso() {
        List<Recurso> recursoList = new ArrayList<>();
        recursoList.add(recurso);
        when(repositorioBase.getEntityManager()).thenReturn(entityManager);
        when(entityManager.createQuery(anyString())).thenReturn(query);
        when(query.getResultList()).thenReturn(recursoList);
        when(usuarioLogadoUtil.getPerfil()).thenReturn("FKS.PONTO.FOCAL");
        recursoCustomRepositorio.efetuarConsultaRecurso(filtroRecursoDTO);

    }

    @Test
    public void verificaPerfilDoUsuario() {
        when(usuarioLogadoUtil.getPerfil()).thenReturn("FKS.PONTO.FOCAL");
        recursoCustomRepositorio.verificaPerfilDoUsuario(filtroRecursoDTO);
    }

    @Test
    public void verificaPerfilDoUsuario2() {
        when(usuarioLogadoUtil.getPerfil()).thenReturn("fks");
        recursoCustomRepositorio.verificaPerfilDoUsuario(filtroRecursoDTO);
    }

    @Test
    public void ignoreAllPerfil(){
        recursoCustomRepositorio.ignoreAllPerfil(query);
    }

    @Test
    public void efetuarConsultaPaginadaFiltroRecurso(){
        recursoCustomRepositorio.efetuarConsultaPaginadaFiltroRecurso(filtroRecursoDTO, true);
    }

    @Test
    public void montarListaConsultaRecursoDTO(){
        List<Recurso> recursoList = new ArrayList<>();
        recursoList.add(recurso);
        when(recurso.getPedido()).thenReturn(pedido);
        when(pedido.getId()).thenReturn(1L);
        when(recurso.getTipoRecurso()).thenReturn(tipoRecurso);
        when(tipoRecurso.getNome()).thenReturn("tipoRecurso");
        when(recurso.getSituacaoRecurso()).thenReturn(situacaoRecurso);
        when(situacaoRecurso.getNome()).thenReturn("situacaoRecurso");
        when(recurso.getPedido()).thenReturn(pedido);
        when(pedido.getSolicitante()).thenReturn(solicitante);
        when(solicitante.getNome()).thenReturn("nome");
        recursoCustomRepositorio.montarListaConsultaRecursoDTO(recursoList);
    }

    @Test
    public void adicionarParametrosParte3Verificacao1(){
        FiltroRecursoDTO filtroRecursoDTO = new FiltroRecursoDTO();
        recursoCustomRepositorio.adicionarParametrosParte3Verificacao1(filtroRecursoDTO,query,1);
    }

    @Test
    public void efetuarConsultaContadorTotalRecurso(){
        FiltroRecursoDTO filtroRecursoDTO = new FiltroRecursoDTO();
        recursoCustomRepositorio.efetuarConsultaContadorTotalRecurso(filtroRecursoDTO);
    }

    @Test
    public void montarQueryPrincipalHQL() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        Method method = RecursoCustomRepositorio.class.getDeclaredMethod("montarQueryPrincipalHQL", String.class);
        method.setAccessible(true);
        assertNotNull(method.invoke(recursoCustomRepositorio, "teste"));
    }

    @Test
    public void monatrCondicionaisNativeTest() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        Method method = RecursoCustomRepositorio.class.getDeclaredMethod("montarCondicionaisNative");
        method.setAccessible(true);
        assertNotNull(method.invoke(recursoCustomRepositorio));
    }

    @Test
    public void adicionarParametrosParte3Teste() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        RecursoCustomRepositorio spyRecursoRepository = spy(recursoCustomRepositorio);
        mockStatic(PerfilAcessoEnum.class);
        when(spyRecursoRepository.adicionarParametrosParte3Verificacao1(filtroRecursoDTO, query, 4)).thenReturn(false);
        when(usuarioLogadoUtil.getPerfil()).thenReturn("teste");
        when(PerfilAcessoEnum.getIdByPerfil("teste")).thenReturn(4);
        when(usuarioLogadoUtil.getUsuario()).thenReturn(usuarioAcessos);
        when(usuarioAcessos.getUnidade()).thenReturn(unidade);
        when(unidade.getId()).thenReturn(1L);
        when(usuarioAcessos.getId()).thenReturn(1L);
        when(query.setParameter(anyString(), any())).thenReturn(query);
        when(filtroRecursoDTO.getIdDemandasComigo()).thenReturn(2);
        Method method = RecursoCustomRepositorio.class.getDeclaredMethod("adicionarParametrosParte3", Query.class, FiltroRecursoDTO.class);
        method.setAccessible(true);
        method.invoke(spyRecursoRepository, query, filtroRecursoDTO);
        verify(query, times(9)).setParameter(anyString(), any(Object.class));
    }

    @Test
    public void adicionarParametrosParte3Verificacao1If(){
        when(filtroRecursoDTO.getIdDemandasComigo()).thenReturn(3);
        when(query.setParameter(anyString(), any(Object.class))).thenReturn(query);
        Assert.isTrue(recursoCustomRepositorio.adicionarParametrosParte3Verificacao1(filtroRecursoDTO, query, 1));
    }

    @Test
    public void adicionarParametrosParte3Verificacao1Else(){
        when(filtroRecursoDTO.getIdDemandasComigo()).thenReturn(2);
        when(query.setParameter(anyString(), any(Object.class))).thenReturn(query);
        Assert.isTrue(recursoCustomRepositorio.adicionarParametrosParte3Verificacao1(filtroRecursoDTO, query, 1));
    }

    @Test
    public void adicionarParametrosParte3Verificacao2If(){
        when(filtroRecursoDTO.getIdDemandasComigo()).thenReturn(2);
        when(query.setParameter(anyString(), any(Object.class))).thenReturn(query);
        Assert.isTrue(recursoCustomRepositorio.adicionarParametrosParte3Verificacao1(filtroRecursoDTO, query, 10));
    }

    @Test
    public void adicionarParametrosParte3Verificacao2Else(){
        when(filtroRecursoDTO.getIdDemandasComigo()).thenReturn(2);
        when(query.setParameter(anyString(), any(Object.class))).thenReturn(query);
        Assert.isTrue(recursoCustomRepositorio.adicionarParametrosParte3Verificacao1(filtroRecursoDTO, query, 5));
    }

    @Test
    public void adiconarParametrosparte3Verificacao3(){
        when(filtroRecursoDTO.getIdDemandasComigo()).thenReturn(2);
        when(query.setParameter(anyString(), any(Object.class))).thenReturn(query);
        Assert.isTrue(recursoCustomRepositorio.adiconarParametrosParte3Verificacao3(filtroRecursoDTO, query, 6));

    }




}
