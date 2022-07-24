package br.com.company.fks.servico.unidade;

import br.com.company.fks.modelo.OrgaoSiorg;
import br.com.company.fks.modelo.Subunidade;
import br.com.company.fks.modelo.TempOrgaoSiorgAcesso;
import br.com.company.fks.modelo.TempUnidadeSiorgAcesso;
import br.com.company.fks.modelo.Unidade;
import br.com.company.fks.modelo.dto.acessosiorg.OrgaoSiorgDTO;
import br.com.company.fks.modelo.dto.acessosiorg.OrgaoUnidadeSubunidadeDTO;
import br.com.company.fks.modelo.dto.acessosiorg.SiorgAcessoDTO;
import br.com.company.fks.modelo.dto.acessosiorg.UnidadeDTO;
import br.com.company.fks.modelo.dto.acessosiorg.UnidadeSiorgDTO;
import br.com.company.fks.repositorio.OrgaoSiorgRepository;
import br.com.company.fks.repositorio.TempOrgaoSiorgAcessoRepository;
import br.com.company.fks.repositorio.TempUnidadeSiorgAcessoRepository;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

import static org.junit.Assert.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockingDetails;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class OrgaoSiorgServiceTest {
    @InjectMocks
    private OrgaoSiorgService orgaoSiorgService;
    @Mock
    private TempOrgaoSiorgAcessoRepository tempOrgaoSiorgAcessoRepository;
    @Mock
    private TempUnidadeSiorgAcessoRepository tempUnidadeSiorgAcessoRepository;
    @Mock
    private OrgaoSiorgRepository orgaoSiorgRepository;
    @Mock
    private UnidadeSiorgDTO unidadeSiorgDTO;
    @Mock
    private TempUnidadeSiorgAcesso tempUnidadeSiorgAcesso;
    @Mock
    private OrgaoSiorgDTO orgaoSiorgDTO;
    @Mock
    private TempOrgaoSiorgAcesso tempOrgaoSiorgAcesso;
    @Mock
    private OrgaoSiorg orgaoSiorg;
    @Mock
    private OrgaoUnidadeSubunidadeDTO orgaoUnidadeSubunidadeDTO;
    @Mock
    private UnidadeDTO unidadeDTO;
    @Mock
    private Subunidade subunidade;
    @Mock
    private Unidade unidade;
    @Mock
    private List<SiorgAcessoDTO> siorgUnidadesList;
    @Mock
    private List<SiorgAcessoDTO> siorgAcessoList;
    @Mock
    private SiorgAcessoDTO siorgAcessoDTO;

    @Test
    public void listarUnidadeSiorgPorOrgaoCodigoUg(){
        List<UnidadeSiorgDTO> unidadeSiorgDTOList = new ArrayList<>();
        unidadeSiorgDTOList.add(unidadeSiorgDTO);
        List<TempUnidadeSiorgAcesso> unidadeSiorgAcessoList = new ArrayList<>();
        unidadeSiorgAcessoList.add(tempUnidadeSiorgAcesso);
        when(tempUnidadeSiorgAcessoRepository.findAllByTempOrgaoSiorgAcessoCodigoUgAndAtivoTrue(anyString())).thenReturn(unidadeSiorgAcessoList);
        orgaoSiorgService.listarUnidadeSiorgPorOrgaoCodigoUg("codigoUg");
    }

    @Test
    public void existemOrgaosUnidades(){
        orgaoSiorgService.existemOrgaosUnidades();
    }

    @Test
    public void limparOrgaosUnidadesDoBancoDados(){
        orgaoSiorgService.limparOrgaosUnidadesDoBancoDados();
    }

    @Test
    public void listarOrgaoSiorg(){
        List<UnidadeSiorgDTO> orgaoList = new ArrayList<>();
        orgaoList.add(unidadeSiorgDTO);
        List<TempOrgaoSiorgAcesso> orgaoSiorgAcessosList = new ArrayList<>();
        orgaoSiorgAcessosList.add(tempOrgaoSiorgAcesso);
        when(tempOrgaoSiorgAcessoRepository.findAllByAtivoTrue()).thenReturn(orgaoSiorgAcessosList);
        UnidadeSiorgDTO dto = new UnidadeSiorgDTO();
        dto.setNomeUnidade("nomeUnidade");
        dto.setSiglaUnidade("siglaUnidade");
        dto.setCodigoUnidade("codigoUnidade");
        orgaoList.add(dto);
        orgaoSiorgService.listarOrgaoSiorg();
    }

    @Test
    public void encontrarOrgaoSiorg(){
        OrgaoSiorgDTO orgaoSiorgDTO = new OrgaoSiorgDTO();
        orgaoSiorgDTO.setCodigoUnidade("codigoUnidade");
        when(orgaoSiorgRepository.findByCodigoOrgao(anyString())).thenReturn(orgaoSiorg);
        OrgaoSiorg orgaoSiorg = new OrgaoSiorg();
        orgaoSiorg.setNomeOrgao("nomeOrgao");
        orgaoSiorg.setSiglaOrgao("siglaOrgao");
        orgaoSiorg.setCodigoOrgao("codigoOrgao");
        orgaoSiorg.setStatusOrgao(true);
        orgaoSiorgService.encontrarOrgaoSiorg(orgaoSiorgDTO);

    }

    @Test
    public void obterOrgaoSiorgDTO(){
        OrgaoSiorgDTO orgaoSiorgDTO = new OrgaoSiorgDTO();
        orgaoSiorgDTO.setId(1L);
        orgaoSiorgDTO.setNomeUnidade("nomeUnidade");
        orgaoSiorgDTO.setSiglaUnidade("siglaUnidade");
        orgaoSiorgDTO.setCodigoUnidade("codigoUnidade");
        orgaoSiorgDTO.setStatusUnidade(true);
        OrgaoSiorg orgaoSiorg = new OrgaoSiorg();
        orgaoSiorg.setId(1L);
        orgaoSiorg.setNomeOrgao("nomeOrgao");
        orgaoSiorg.setSiglaOrgao("siglaOrgao");
        orgaoSiorg.setCodigoOrgao("codigoOrgao");
        orgaoSiorg.setStatusOrgao(true);
        orgaoSiorgService.obterOrgaoSiorgDTO(orgaoSiorg);
    }

    @Test
    public void obterOrgaoDataBase(){
        OrgaoSiorg orgaoSiorg = new OrgaoSiorg();
        orgaoSiorg.setNomeOrgao("SIC");
        List<OrgaoSiorgDTO> orgaoSiorgDTOList = new ArrayList<>();
        orgaoSiorgDTOList.add(orgaoSiorgDTO);
        List<OrgaoSiorg> orgaoSiorgList = new ArrayList<>();
        orgaoSiorgList.add(orgaoSiorg);
        when(orgaoSiorgRepository.findAll()).thenReturn(orgaoSiorgList);
        orgaoSiorgService.obterOrgaoDataBase();
    }

    @Test
    public void obterTudoDataBase(){
        List<UnidadeDTO> unidades = new ArrayList<>();
        unidades.add(unidadeDTO);
        OrgaoUnidadeSubunidadeDTO orgaoUnidadeSubunidadeDTO = new OrgaoUnidadeSubunidadeDTO();
        orgaoUnidadeSubunidadeDTO.setId(1L);
        orgaoUnidadeSubunidadeDTO.setNomeOrgao("nomeOrgao");
        orgaoUnidadeSubunidadeDTO.setSiglaOrgao("siglaOrgao");
        orgaoUnidadeSubunidadeDTO.setUnidades(unidades);
        List<OrgaoUnidadeSubunidadeDTO> orgaoUnidadeSubunidadeDTOList = new ArrayList<>();
        orgaoUnidadeSubunidadeDTOList.add(orgaoUnidadeSubunidadeDTO);
        List<OrgaoSiorg> orgaoSiorgList = new ArrayList<>();
        orgaoSiorgList.add(orgaoSiorg);
        when(orgaoSiorgRepository.findAll()).thenReturn(orgaoSiorgList);
        orgaoSiorgService.obterTudoDataBase();
    }

    @Test
    public void obterSubunidadeTest() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        List<Subunidade> subunidadeList = new ArrayList<>();
        subunidadeList.add(subunidade);
        subunidadeList.add(subunidade);
        subunidadeList.add(subunidade);

        when(subunidade.getId()).thenReturn(1L);
        when(subunidade.getNomeSubunidade()).thenReturn("nomeSubunidade");
        when(subunidade.getCodigoSubunidade()).thenReturn("codigo");
        when(subunidade.getSiglaSubunidade()).thenReturn("nS");

        Method method = OrgaoSiorgService.class.getDeclaredMethod("obterSubunidades", List.class);
        method.setAccessible(true);
        method.invoke(orgaoSiorgService, subunidadeList);

        verify(subunidade, times(3)).getId();
    }

    @Test
    public void obterUnidadeTest() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        List<Unidade> unidadeList = new ArrayList<>();
        unidadeList.add(unidade);
        unidadeList.add(unidade);
        unidadeList.add(unidade);

        when(unidade.getId()).thenReturn(1L);

        Method method = OrgaoSiorgService.class.getDeclaredMethod("obterUnidade", List.class);
        method.setAccessible(true);
        method.invoke(orgaoSiorgService, unidadeList);

        verify(unidade, times(3)).getId();
    }

    @Test
    public void encontrarOrgaoSiorgTeste(){
        when(orgaoSiorgRepository.findByCodigoOrgao(anyString())).thenReturn(null);
        when(orgaoSiorgRepository.save(any(OrgaoSiorg.class))).thenReturn(orgaoSiorg);
        when(orgaoSiorgDTO.getNomeUnidade()).thenReturn("Nome");

        OrgaoSiorg orgaoReal = orgaoSiorgService.encontrarOrgaoSiorg(orgaoSiorgDTO);

        verify(orgaoSiorgDTO, times(1)).getNomeUnidade();
    }

    @Test
    public void criarUnidadesAllTeste() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        when(siorgUnidadesList.size()).thenReturn(3);
        when(siorgUnidadesList.get(anyInt())).thenReturn(siorgAcessoDTO);
        when(siorgAcessoDTO.getOrganizacaoSuperior()).thenReturn(siorgAcessoDTO);
        when(siorgAcessoDTO.getCodigoUg()).thenReturn("1");
        when(tempUnidadeSiorgAcessoRepository.findFirstByCodigoUg(anyString())).thenReturn(tempUnidadeSiorgAcesso);
        when(tempUnidadeSiorgAcessoRepository.save(any(TempUnidadeSiorgAcesso.class))).thenReturn(tempUnidadeSiorgAcesso);

        Method method = OrgaoSiorgService.class.getDeclaredMethod("criarUnidadesAll");
        method.setAccessible(true);
        method.invoke(orgaoSiorgService);

        verify(siorgAcessoDTO, times(3)).getSigla();
    }

    @Ignore
    @Test
    public void criarNoBancoDeDados() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        List<SiorgAcessoDTO> orgaoList = new ArrayList<>();
        Stream<SiorgAcessoDTO> stream = mock(Stream.class);
        orgaoList.add(siorgAcessoDTO);
        orgaoList.add(siorgAcessoDTO);
        orgaoList.add(siorgAcessoDTO);

        when(siorgAcessoDTO.getOrganizacaoSuperior()).thenReturn(siorgAcessoDTO);
        when(siorgAcessoDTO.getCodigoUg()).thenReturn("5");
        when(tempOrgaoSiorgAcesso.getCodigoUg()).thenReturn("5");
        when(siorgAcessoDTO.getAtivo()).thenReturn(true);
        when(siorgUnidadesList.stream()).thenReturn(stream);
        when(tempOrgaoSiorgAcessoRepository.save(any(TempOrgaoSiorgAcesso.class))).thenReturn(tempOrgaoSiorgAcesso);

        Method method = OrgaoSiorgService.class.getDeclaredMethod("criarNoBancoDeDados", List.class);
        method.setAccessible(true);
        method.invoke(orgaoSiorgService, orgaoList);
    }

    @Test
    public void obterOganizacaoSuperiorTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        when(siorgAcessoDTO.getOrganizacaoSuperior()).thenReturn(siorgAcessoDTO);

        Method method = OrgaoSiorgService.class.getDeclaredMethod("obterOganizacaoSuperior", SiorgAcessoDTO.class, boolean.class);
        method.setAccessible(true);
        method.invoke(orgaoSiorgService, siorgAcessoDTO, true);

        verify(siorgAcessoDTO, times(2)).setOrganizacaoSuperior(any(SiorgAcessoDTO.class));
    }

    @Test
    public void obterItem() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        siorgAcessoList.add(siorgAcessoDTO);
        siorgAcessoList.add(siorgAcessoDTO);

        when(siorgAcessoDTO.getOrganizacaoSuperior()).thenReturn(siorgAcessoDTO);
        when(siorgAcessoDTO.getCodigoUg()).thenReturn("codigo");
        when(siorgAcessoDTO.getAtivo()).thenReturn(true);

        Method method = OrgaoSiorgService.class.getDeclaredMethod("obterItem", String.class, boolean.class);
        method.setAccessible(true);
        method.invoke(orgaoSiorgService, "codigo", true);
    }

    @Test
    public void obterAll() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        List<SiorgAcessoDTO> lista = new ArrayList<>();
        lista.add(siorgAcessoDTO);
        lista.add(siorgAcessoDTO);
        lista.add(siorgAcessoDTO);

        when(siorgAcessoDTO.getCodigoUg()).thenReturn("teste");
        Method method = OrgaoSiorgService.class.getDeclaredMethod("obterAll", List.class);
        method.setAccessible(true);
        method.invoke(orgaoSiorgService, lista);
    }

}