package br.com.company.fks.servico;

import br.com.company.fks.integracao.ConsultaSIAPE.DadosFuncionais;
import br.com.company.fks.modelo.OrgaoSiorg;
import br.com.company.fks.modelo.Subunidade;
import br.com.company.fks.modelo.Unidade;
import br.com.company.fks.modelo.UsuarioAcessoSubunidade;
import br.com.company.fks.modelo.UsuarioAcessos;
import br.com.company.fks.modelo.dto.FiltroUnidadeDTO;
import br.com.company.fks.modelo.dto.SubunidadeDTO;
import br.com.company.fks.modelo.dto.UnidadeDTO;
import br.com.company.fks.modelo.dto.UnidadeSubunidadeDTO;
import br.com.company.fks.modelo.dto.UsuarioAcessosDTO;
import br.com.company.fks.repositorio.OrgaoSiorgRepository;
import br.com.company.fks.repositorio.SubunidadeRepository;
import br.com.company.fks.repositorio.UnidadeRepository;
import br.com.company.fks.repositorio.UsuarioAcessosRepository;
import br.com.company.fks.repositorio.UsuarioAcessosSubunidadeRepository;
import br.com.company.fks.servico.unidade.PadraoService;
import br.com.company.fks.utils.UsuarioLogadoUtil;
import lombok.SneakyThrows;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.when;

/**
 * Created by Maicon Godoy - FKSolutions Tecnologia on 03/09/18.
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({XSSFCell.class})
public class UnidadeServiceTest {
    @InjectMocks
    private UnidadeService unidadeService;

    @Mock
    private UnidadeRepository unidadeRepository;

    @Mock
    private SubunidadeRepository subunidadeRepository;

    @Mock
    private OrgaoSiorgRepository orgaoSiorgRepository;

    @Mock
    private UsuarioAcessosRepository usuarioAcessosRepository;

    @Mock
    private UnidadeSubunidadeDTO unidadeSubunidadeDTO;

    @Mock
    private Unidade unidade;

    @Mock
    private Subunidade subunidade;

    @Mock
    private OrgaoSiorg orgaoSiorg;

    @Mock
    private FiltroUnidadeDTO filtroUnidadeDTO;

    @Mock
    private UnidadeDTO unidadeDTO;

    @Mock
    private UsuarioAcessos usuarioAcessos;

    @Mock
    private UsuarioAcessosDTO usuarioAcessosDTO;

    @Mock
    private XSSFWorkbook xssfWorkbook;

    @Mock
    private XSSFCell xssfCell;

    @Mock
    private XSSFSheet xssfSheet;

    @Mock
    private List<Subunidade> subunidades;

    @Mock
    private SubunidadeDTO subunidadeDTO;

    @Mock
    private UsuarioLogadoUtil usuarioLogadoUtil;

    @Mock
    private PadraoService padraoService;

    @Mock
    private DadosFuncionais dadosFuncionais;

    @Mock
    private UsuarioAcessosSubunidadeRepository usuarioAcessosSubunidadeRepository;

    @Mock
    private UsuarioAcessoSubunidade usuarioAcessoSubunidade;

    @Mock
    private List<Long> longList;
    
    @Mock
    private List<SubunidadeDTO> subunidadeDTOList1;

    @Test
    @SneakyThrows
    public void salvar() {
        when(unidade.getNomeUnidade()).thenReturn("teste");
        when(unidade.getCodigoUnidade()).thenReturn("123456");
        when(unidade.getSiglaUnidade()).thenReturn("UF");
        when(unidadeRepository.save(unidade)).thenReturn(unidade);
        List<SubunidadeDTO> listaSubunidadesDTO = new ArrayList<>();
        listaSubunidadesDTO.add(subunidadeDTO);
        when(unidadeSubunidadeDTO.getSubunidade()).thenReturn(listaSubunidadesDTO);
        when(subunidade.getCodigoSubunidade()).thenReturn("123");
        when(subunidade.getNomeSubunidade()).thenReturn("tese");
        when(subunidade.getSiglaSubunidade()).thenReturn("w3");
        when(subunidadeRepository.save(subunidade)).thenReturn(subunidade);
        unidadeService.salvar(unidadeSubunidadeDTO);


    }

    @Test
    public void buscarUnidade() {
        when(unidadeRepository.findOne(1L)).thenReturn(unidade);
        unidadeService.buscarUnidade(1L);
    }

    @Test
    @SneakyThrows
    public void editar() {
        List<Subunidade> subunidadeList = new ArrayList<>();
        subunidadeList.add(subunidade);
        when(unidade.getId()).thenReturn(1L);
        when(unidadeRepository.findOne(1L)).thenReturn(unidade);
        when(unidade.getSubunidade()).thenReturn(subunidadeList);
        when(subunidade.getId()).thenReturn(1L);
        Mockito.doNothing().when(subunidadeRepository).delete(1L);
        when(unidadeRepository.save(unidade)).thenReturn(unidade);
        unidadeService.editar(unidade);
    }

    @Test
    public void detalharUnidade() {
        when(subunidadeRepository.buscarUnidadeSubunidadePorId(1L)).thenReturn(subunidade);
        unidadeService.detalharUnidade(1L);
    }

    @Test
    public void buscarListaUnidade() {
        List<Unidade> listaUnidade = new ArrayList<>();
        listaUnidade.add(unidade);
        List<Subunidade> subunidadeList = new ArrayList<>();
        subunidadeList.add(subunidade);
        when(unidadeRepository.findAll()).thenReturn(listaUnidade);
        when(unidade.getId()).thenReturn(1L);
        when(unidade.getCodigoUnidade()).thenReturn("teste");
        when(unidade.getNomeUnidade()).thenReturn("123");
        when(unidadeDTO.getSubunidade()).thenReturn(subunidadeList);
        unidadeService.buscarListaUnidade();
    }

    @Test
    public void buscarListaSubunidade() {
        when(unidadeRepository.findOne(1L)).thenReturn(unidade);
        List<Subunidade> subunidadeList = new ArrayList<>();
        subunidadeList.add(subunidade);
        when(unidade.getSubunidade()).thenReturn(subunidadeList);
        unidadeService.buscarListaSubunidade(1L);
    }

    @Test
    @SneakyThrows
    public void atribuirUnidadeUsuario() {
        when(usuarioAcessosRepository.findFirstByCpfUsuario("codigoUsuario")).thenReturn(usuarioAcessos);
        when(usuarioAcessosDTO.getUsuario()).thenReturn(usuarioAcessos);
        when(usuarioAcessos.getCodigoUsuario()).thenReturn("123");
        when(usuarioAcessosDTO.getUsuario()).thenReturn(usuarioAcessos);
        when(usuarioAcessosSubunidadeRepository.findFirstByUsuarioAcessosCpfUsuario(anyString())).thenReturn(usuarioAcessoSubunidade);
        when(usuarioAcessos.getPerfilUsuario()).thenReturn("FKS.RESPONDENTE");
        when(usuarioLogadoUtil.getCpf()).thenReturn(null);
        unidadeService.atribuirUnidadeUsuario(usuarioAcessosDTO);
    }
    @Test
    @SneakyThrows
    public void atribuirUnidadeUsuarioUsuarioFKSTecnico() {
        when(usuarioAcessosRepository.findFirstByCpfUsuario("codigoUsuario")).thenReturn(usuarioAcessos);
        when(usuarioAcessosDTO.getUsuario()).thenReturn(usuarioAcessos);
        when(usuarioAcessos.getCodigoUsuario()).thenReturn("123");
        when(usuarioAcessosDTO.getUsuario()).thenReturn(usuarioAcessos);
        when(usuarioAcessosSubunidadeRepository.findFirstByUsuarioAcessosCpfUsuario(anyString())).thenReturn(usuarioAcessoSubunidade);
        when(usuarioAcessos.getPerfilUsuario()).thenReturn("FKS.TECNICO");
        when(usuarioLogadoUtil.getCpf()).thenReturn("cpf");
        when(usuarioLogadoUtil.getUsuario()).thenReturn(usuarioAcessos);
        unidadeService.atribuirUnidadeUsuario(usuarioAcessosDTO);
    }

    @Test
    @SneakyThrows
    public void atribuirUnidadeUsuarioUsuarioFKSTecnicoNaoNulo() {
        when(usuarioAcessosRepository.findFirstByCpfUsuario("codigoUsuario")).thenReturn(usuarioAcessos);
        when(usuarioAcessosDTO.getUsuario()).thenReturn(usuarioAcessos);
        when(usuarioAcessos.getCodigoUsuario()).thenReturn("123");
        when(usuarioAcessosDTO.getUsuario()).thenReturn(usuarioAcessos);
        when(usuarioAcessos.getPerfilUsuario()).thenReturn("teste");

        unidadeService.atribuirUnidadeUsuario(usuarioAcessosDTO);
    }

    @Test
    public void montarListaSubunidade(){
        when(unidadeRepository.findOne(1L)).thenReturn(unidade);
        List<Subunidade> subunidadeList = new ArrayList<>();
        subunidadeList.add(subunidade);
        when(unidade.getSubunidade()).thenReturn(subunidadeList);
        unidadeService.montarListaSubunidade(1L);
    }

    @Test
    @SneakyThrows
    public void exportarConsultaUnidade() {
        PowerMockito.mock(XSSFCell.class);
        List<Long> ids = new ArrayList<>();
        ids.add(1L);
        ids.add(2L);
        when(subunidade.getUnidade()).thenReturn(unidade);
        when(unidade.getNomeUnidade()).thenReturn("teste");
        when(xssfWorkbook.createSheet("Consulta de Unidades")).thenReturn(xssfSheet);
        unidadeService.exportarConsultaUnidade(filtroUnidadeDTO);
    }

    @Test
    public void buscarListaSubunidadePorUsuarioLogadoIf(){
        when(usuarioLogadoUtil.getPerfil()).thenReturn("FKS.PONTO.FOCAL");
        when(usuarioLogadoUtil.getUsuario()).thenReturn(usuarioAcessos);
        when(usuarioAcessos.getUnidade()).thenReturn(unidade);
        when(unidade.getId()).thenReturn(1L);
        when(unidadeRepository.findOne(1L)).thenReturn(unidade);
        unidadeService.buscarListaSubunidadePorUsuarioLogado();
    }

    @Test
    public void buscarListaSubunidadePorUsuarioLogado(){
        when(usuarioLogadoUtil.getPerfil()).thenReturn("perfil");
        unidadeService.buscarListaSubunidadePorUsuarioLogado();
    }

    @Test
    public void alterarStatusSubUnidade() {
        when(subunidadeRepository.findOne(1L)).thenReturn(subunidade);
        when(subunidadeRepository.save(subunidade)).thenReturn(subunidade);
        unidadeService.alterarStatusSubUnidade(1L,true);
    }

    @Test
    public void buscarUnidadeSic(){
        when(unidadeRepository.findByCodigoUnidade("0000")).thenReturn(unidade);
        when(unidade.getId()).thenReturn(1L);
        unidadeService.buscarUnidadeSic();
    }

    @Test
    public void buscarUnidadeVinculadaASubunidade(){
        when(usuarioLogadoUtil.getUsuario()).thenReturn(usuarioAcessos);
        when(usuarioAcessos.getUnidade()).thenReturn(unidade);
        unidadeService.buscarUnidadeVinculadaASubunidade(1L);
    }


    @Test
    public void buscarSubunidadeRespondente(){
        when(usuarioLogadoUtil.getUsuario()).thenReturn(usuarioAcessos);
        unidadeService.buscarSubunidadeRespondente();
    }

    @Test
    public void buscaUnidadePeloNome(){
        when(unidadeRepository.buscaUnidadePeloNome("nomeUnidade")).thenReturn(unidade);
        unidadeService.buscaUnidadePeloNome("nome");
    }

    @Test
    public void buscaCargoFuncaoSiapPorCpf(){
        when(padraoService.obterDadosFuncionais("00000000000")).thenReturn(dadosFuncionais);
        unidadeService.buscaCargoFuncaoSiapPorCpf("00000000000");
    }

    @Test
    public void buscaCargoFuncaoSiapPorCpfNulo(){
        when(padraoService.obterDadosFuncionais("00000000000")).thenReturn(null);
        unidadeService.buscaCargoFuncaoSiapPorCpf("00000000000");
    }

    @Test
    public void montarListaUnidadeDTO(){
        when(unidade.getId()).thenReturn(1L);
        when(unidade.getCodigoUnidade()).thenReturn("codigoUnidade");
        when(unidade.getNomeUnidade()).thenReturn("nomeUnidade");
        when(unidade.getSiglaUnidade()).thenReturn("siglaUnidade");
        when(unidade.getStatusUnidade()).thenReturn(true);
        List<Subunidade> subunidadeList = new ArrayList<>();
        subunidadeList.add(subunidade);
        subunidadeList.add(subunidade);
        subunidadeList.add(subunidade);
        subunidadeList.add(subunidade);
        when(unidade.getSubunidade()).thenReturn(subunidadeList);
        when(unidadeDTO.getSubunidade()).thenReturn(subunidadeList);
        unidadeService.montarListaUnidadeDTO(unidade);
    }
}
