package br.com.company.fks.servico.usuario;

import br.gov.mpog.acessos.cliente.servico.impl.AcessosClienteSistemaServiceImpl;
import br.com.company.fks.integracao.ConsultaSIAPE.DadosFuncionais;
import br.com.company.fks.modelo.OrgaoSiorg;
import br.com.company.fks.modelo.Responsaveis;
import br.com.company.fks.modelo.Subunidade;
import br.com.company.fks.modelo.Unidade;
import br.com.company.fks.modelo.UsuarioAcessoPerfilAcesso;
import br.com.company.fks.modelo.UsuarioAcessoSubunidade;
import br.com.company.fks.modelo.UsuarioAcessos;
import br.com.company.fks.modelo.dto.UsuarioPerfilAcessoDTO;
import br.com.company.fks.modelo.dto.acessosiorg.OrgaoSiorgDTO;
import br.com.company.fks.modelo.dto.acessosiorg.SubunidadeDTO;
import br.com.company.fks.modelo.dto.acessosiorg.UnidadeDTO;
import br.com.company.fks.modelo.dto.acessosiorg.UsuarioSiapeAcessoDTO;
import br.com.company.fks.repositorio.ResponsaveisRepository;
import br.com.company.fks.repositorio.UnidadeRepository;
import br.com.company.fks.repositorio.UsuarioAcessoPerfilAcessoRepository;
import br.com.company.fks.repositorio.UsuarioAcessosRepository;
import br.com.company.fks.repositorio.UsuarioAcessosSubunidadeRepository;
import br.com.company.fks.servico.UnidadeService;
import br.com.company.fks.servico.unidade.PadraoService;
import br.com.company.fks.utils.EntityConverter;
import br.com.company.fks.utils.UsuarioLogadoUtil;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UsuarioAcessosBuscarServiceTest {

    @InjectMocks
    private UsuarioAcessosBuscar usuarioAcessosBuscar;

    @Mock
    private UsuarioLogadoUtil usuarioLogadoUtil;

    @Mock
    private UsuarioAcessos usuarioAcessos;

    @Mock
    private Subunidade subunidade;

    @Mock
    private UsuarioAcessoPerfilAcessoRepository usuarioAcessoPerfilAcessoRepository;

    @Mock
    private UsuarioAcessoPerfilAcesso usuarioAcessoPerfilAcesso;

    @Mock
    private SubunidadeDTO subunidadeDTO;

    @Mock
    private UsuarioAcessosSubunidadeRepository usuarioAcessosSubunidadeRepository;

    @Mock
    private AcessosClienteSistemaServiceImpl acessosClienteSistemaServiceImpl;

    @Mock
    private List<Object> objectList;

    @Mock
    private EntityConverter entityConverter;

    @Mock
    private UsuarioSiapeAcessoDTO usuarioSiapeAcessoDTO;

    @Mock
    private ResponsaveisRepository responsaveisRepository;

    @Mock
    private PadraoService padraoService;

    @Mock
    private Unidade unidade;

    @Mock
    private UsuarioAcessosRepository usuarioAcessosRepository;

    @Mock
    private UnidadeService unidadeService;

    @Mock
    private UsuarioPerfilAcessoDTO usuarioPerfilAcessoDTO;

    @Mock
    private UnidadeRepository unidadeRepository;

    @Test
    public void buscarUsuarioPontoFocalPorSubunidade(){
        List<UsuarioAcessos> usuarioAcessosList = new ArrayList<>();
        usuarioAcessosList.add(usuarioAcessos);
        when(usuarioAcessosRepository.findUsuarioBySubunidadeIdAndAndPerfil("FKS.RESPONDENTE", "", 1L)).thenReturn(usuarioAcessosList);
        usuarioAcessosBuscar.buscarUsuarioPontoFocalPorSubunidade(1L);
    }

    @Test
    public void buscarUsuarioTecnicoPorSubunidade(){
        List<UsuarioAcessos> usuarioAcessosList = new ArrayList<>();
        usuarioAcessosList.add(usuarioAcessos);
        when(usuarioAcessosRepository.findUsuarioBySubunidadeIdAndAndPerfil("FKS.TECNICO","FKS.EDICAO.TECNICO", 1L)).thenReturn(usuarioAcessosList);
        when(unidadeService.getOneSubunidadePeloUsuarioCpf("000")).thenReturn(subunidade);
        when(usuarioLogadoUtil.getCpf()).thenReturn("000");
        usuarioAcessosBuscar.buscarUsuarioTecnicoPorSubunidade();
    }


    @Test
    public void getSubunidades(){
        List<SubunidadeDTO> subunidadeDTOList = new ArrayList<>();
        subunidadeDTOList.add(subunidadeDTO);
        usuarioAcessosBuscar.getSubunidades("00000000000", subunidadeDTOList);
    }

    @Test
    public void getDadosUsuarioAcesso(){
        when(acessosClienteSistemaServiceImpl.buscarUsuarios("00000000000", null, null, null,
                null,null, null, null, null)).thenReturn(objectList);
        when(entityConverter.converter(objectList, UsuarioSiapeAcessoDTO.class)).thenReturn(usuarioSiapeAcessoDTO);
        usuarioAcessosBuscar.getDadosUsuarioAcesso("00000000000");
    }

    @Test
    public void getResponsavelsTest() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Responsaveis responsaveisEsperado = new Responsaveis();
        responsaveisEsperado.setResponsavelRecursoQuartaInstancia("3");
        responsaveisEsperado.setResponsavelRecursoQuartaInstancia("4");


        when(responsaveisRepository.findTopByOrderByIdDesc()).thenReturn(responsaveisEsperado);

        Method method = UsuarioAcessosBuscar.class.getDeclaredMethod("getResponsavels", UsuarioPerfilAcessoDTO.class);
        method.setAccessible(true);
        UsuarioPerfilAcessoDTO usuarioDetalhadoDTO = new UsuarioPerfilAcessoDTO();
        method.invoke(usuarioAcessosBuscar, usuarioDetalhadoDTO);

        Assert.assertEquals(responsaveisEsperado.getResponsavelRecursoTerceiraInstancia(), usuarioDetalhadoDTO.getResponsavelRecurso3());
        Assert.assertEquals(responsaveisEsperado.getResponsavelRecursoQuartaInstancia(), usuarioDetalhadoDTO.getResponsavelRecurso4());
    }

    @Test
    public void getDadosFuncionaisTest() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        DadosFuncionais dadosFuncionais = new DadosFuncionais();
        dadosFuncionais.setNomeCargo("MeuCargo");
        dadosFuncionais.setNomeFuncao("MinhaFuncao");
        UsuarioPerfilAcessoDTO usuarioDetalhadoDTO = new UsuarioPerfilAcessoDTO();

        when(padraoService.obterDadosFuncionais(usuarioDetalhadoDTO.getCpf())).thenReturn(dadosFuncionais);

        Method method = UsuarioAcessosBuscar.class.getDeclaredMethod("getDadosFuncionais", UsuarioPerfilAcessoDTO.class);
        method.setAccessible(true);
        method.invoke(usuarioAcessosBuscar, usuarioDetalhadoDTO);
        Assert.assertEquals(dadosFuncionais.getNomeCargo(), usuarioDetalhadoDTO.getCargo());
        Assert.assertEquals(dadosFuncionais.getNomeFuncao(), usuarioDetalhadoDTO.getFuncao());
    }

    @Test
    public void getOrgaoTest() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        OrgaoSiorg orgaoEsperado = new OrgaoSiorg();
        orgaoEsperado.setId(1l);
        orgaoEsperado.setNomeOrgao("unidade-Teste");
        orgaoEsperado.setCodigoOrgao("codigo-Teste");
        orgaoEsperado.setSiglaOrgao("sigla-Teste");

        OrgaoSiorgDTO orgaoReal = new OrgaoSiorgDTO();

        when(usuarioAcessos.getUnidade()).thenReturn(unidade);
        when(unidade.getOrgaoSiorg()).thenReturn(orgaoEsperado);

        Method method = UsuarioAcessosBuscar.class.getDeclaredMethod("getOrgao", UsuarioAcessos.class, OrgaoSiorgDTO.class);
        method.setAccessible(true);
        method.invoke(usuarioAcessosBuscar, usuarioAcessos, orgaoReal);

        Assert.assertEquals(orgaoEsperado.getId(), orgaoReal.getId());
        Assert.assertEquals(orgaoEsperado.getSiglaOrgao(), orgaoReal.getSiglaUnidade());
        Assert.assertEquals(orgaoEsperado.getNomeOrgao(), orgaoReal.getNomeUnidade());
        Assert.assertEquals(orgaoEsperado.getCodigoOrgao(), orgaoReal.getCodigoUnidade());
    }

    @Test
    public void getUnidadeTest() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        List<Subunidade> listSub = new ArrayList<>();
        List<SubunidadeDTO> listDTO = new ArrayList<>();
        listSub.add(subunidade);
        Unidade unidadeEsperada = new Unidade();
        unidadeEsperada.setId(1l);
        unidadeEsperada.setNomeUnidade("nome-teste");
        unidadeEsperada.setCodigoUnidade("codigo-Teste");
        unidadeEsperada.setSiglaUnidade("sigla-Teste");

        Unidade spyUnit = Mockito.spy(unidadeEsperada);

        when(usuarioAcessos.getUnidade()).thenReturn(spyUnit);
        when(spyUnit.getSubunidade()).thenReturn(listSub);

        UnidadeDTO unidadeDTO = new UnidadeDTO();

        Method method = UsuarioAcessosBuscar.class.getDeclaredMethod("getUnidade", UsuarioAcessos.class, UnidadeDTO.class, List.class);
        method.setAccessible(true);
        method.invoke(usuarioAcessosBuscar, usuarioAcessos, unidadeDTO, listDTO);

        Assert.assertEquals(spyUnit.getId(), unidadeDTO.getId());
        Assert.assertEquals(spyUnit.getNomeUnidade(), unidadeDTO.getNomeUnidade());
        Assert.assertEquals(spyUnit.getSiglaUnidade(), unidadeDTO.getSiglaUnidade());
        Assert.assertEquals(spyUnit.getCodigoUnidade(), unidadeDTO.getCodigoUnidade());
    }

    @Test
    public void getSubunidadesTest() {
        List<SubunidadeDTO> dtoList = new ArrayList<>();
        List<UsuarioAcessoSubunidade> listaMock = new ArrayList<>();

        UsuarioAcessoSubunidade item1 = new UsuarioAcessoSubunidade();
        item1.setSubunidade(subunidade);
        listaMock.add(item1);

        UsuarioAcessoSubunidade item2 = new UsuarioAcessoSubunidade();
        item2.setSubunidade(subunidade);
        listaMock.add(item2);

        UsuarioAcessoSubunidade item3 = new UsuarioAcessoSubunidade();
        item3.setSubunidade(subunidade);
        listaMock.add(item3);

        when(usuarioAcessosSubunidadeRepository.findAllByUsuarioAcessosCpfUsuario("123")).thenReturn(listaMock);
        usuarioAcessosBuscar.getSubunidades("123", dtoList);

        Assert.assertEquals(3, dtoList.size());
    }

    @Test
    public void getOrgaounidadeSubunidadeUsuarioAcessosNulo() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        UsuarioPerfilAcessoDTO usuarioPerfilAcessoDTO = new UsuarioPerfilAcessoDTO();

        Method method = UsuarioAcessosBuscar.class.getDeclaredMethod("getOrgaoUnidadeSubunidade", UsuarioAcessos.class, UsuarioPerfilAcessoDTO.class);
        method.setAccessible(true);
        method.invoke(usuarioAcessosBuscar, null, usuarioPerfilAcessoDTO);

        Assert.assertNotNull(usuarioPerfilAcessoDTO.getOrgao());
        Assert.assertNotNull(usuarioPerfilAcessoDTO.getUnidade());
        Assert.assertNotNull(usuarioPerfilAcessoDTO.getUnidade());
    }

    @Test
    public void getAutoridadeTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        UsuarioPerfilAcessoDTO usuarioPerfilAcessoDTO = new UsuarioPerfilAcessoDTO();

        when(usuarioAcessos.getUnidade()).thenReturn(unidade);
        when(unidade.getId()).thenReturn(1L);

        when(usuarioAcessoPerfilAcessoRepository.findFirstByUsuarioAcessosUnidadeIdAndPerfilAcessosNomePerfil(1L, "FKS.AUTORIDADE.HIERARQUICA")).thenReturn(usuarioAcessoPerfilAcesso);
        when(usuarioAcessoPerfilAcessoRepository.findFirstByUsuarioAcessosUnidadeIdAndPerfilAcessosNomePerfil(1L, "FKS.AUTORIDADE.MAXIMA")).thenReturn(usuarioAcessoPerfilAcesso);

        when(usuarioAcessoPerfilAcesso.getUsuarioAcessos()).thenReturn(usuarioAcessos);
        when(usuarioAcessos.getNomeUsuario()).thenReturn("Nome-Teste");

        Method method = UsuarioAcessosBuscar.class.getDeclaredMethod("getAutoridade", UsuarioAcessos.class, UsuarioPerfilAcessoDTO.class);
        method.setAccessible(true);
        method.invoke(usuarioAcessosBuscar, usuarioAcessos, usuarioPerfilAcessoDTO);

        Assert.assertEquals("Nome-Teste",usuarioPerfilAcessoDTO.getAutoridadeHier());
        Assert.assertEquals("Nome-Teste",usuarioPerfilAcessoDTO.getAutoridadeMaxi());
    }

    @Test
    public void detalharUsuario(){
        when(usuarioAcessosRepository.findFirstByCpfUsuario("0000000000")).thenReturn(usuarioAcessos);
        usuarioAcessosBuscar.detalharUsuario("00000000000", "nomePerfil");
    }

    @Test
    public void detalharUsuarioGetAutoridade(){
        when(usuarioAcessosRepository.findFirstByCpfUsuario("0000000000")).thenReturn(usuarioAcessos);
        when(usuarioPerfilAcessoDTO.getPerfil()).thenReturn("FKS.ADMIN");
        when(unidadeRepository.findByCodigoUnidade(anyString())).thenReturn(unidade);
        usuarioAcessosBuscar.detalharUsuario("00000000000", "FKS.ADMIN");
    }

}