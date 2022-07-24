package br.com.company.fks.servico.unidade;

import br.com.company.fks.integracao.ConsultaSIAPE.ConsultaSIAPE_PortType;
import br.com.company.fks.integracao.ConsultaSIAPE.ConsultaSIAPE_ServiceLocator;
import br.com.company.fks.modelo.OrgaoSiorg;
import br.com.company.fks.modelo.Responsaveis;
import br.com.company.fks.modelo.Unidade;
import br.com.company.fks.modelo.dto.acessosiorg.OrgaoSiorgDTO;
import br.com.company.fks.modelo.dto.acessosiorg.ResponsaveisDTO;
import br.com.company.fks.modelo.dto.acessosiorg.SubunidadeDTO;
import br.com.company.fks.modelo.dto.acessosiorg.UnidadeDTO;
import br.com.company.fks.modelo.dto.acessosiorg.UnidadePadraoDTO;
import br.com.company.fks.modelo.dto.acessosiorg.UsuarioSiapeAcessoDTO;
import br.com.company.fks.repositorio.ResponsaveisRepository;
import br.com.company.fks.repositorio.UnidadeRepository;
import br.com.company.fks.servico.usuario.UsuarioAcessosService;
import br.com.company.fks.utils.EntityConverter;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.modules.junit4.PowerMockRunner;

import javax.xml.rpc.ServiceException;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(PowerMockRunner.class)
public class PadraoServiceTest {

    @InjectMocks
    private PadraoService padraoService;

    @Mock
    private ResponsaveisRepository responsaveisRepository;

    @Mock
    private Unidade unidade;

    @Mock
    private Responsaveis responsaveis;

    @Mock
    private ResponsaveisDTO responsaveisDTO;

    @Mock
    private UnidadePadraoDTO unidadePadraoDTO;

    @Mock
    private UnidadeDTO unidadeDTO;

    @Mock
    private UsuarioSiapeAcessoDTO usuarioSiapeAcessoDTO;

    @Mock
    private EntityConverter entityConverter;

    @Mock
    private ConsultaSIAPE_ServiceLocator myServiceServiceLocator;

    @Mock
    private ConsultaSIAPE_PortType webservice;

    @Mock
    private UnidadeRepository unidadeRepository;

    @Mock
    private UnidadeSiorgService unidadeSiorgService;

    @Mock
    private OrgaoSiorgService orgaoSiorgService;

    @Mock
    private UsuarioAcessosService usuarioAcessosService;

    @Mock
    private OrgaoSiorgDTO orgaoSiorgDTO;

    @Mock
    private OrgaoSiorg orgaoSiorg;

    @Test
    public void obterCadastroNoBancoDados(){
        when(unidade.getCodigoUnidade()).thenReturn("1");
        padraoService.obterCadastroNoBancoDados(unidade);
    }

    @Test
    public void obterCadastroNoBancoDadosIgualAo0000(){
        when(unidade.getCodigoUnidade()).thenReturn("0000");
        padraoService.obterCadastroNoBancoDados(unidade);
    }

    @Test
    public void salvar(){
        when(unidadePadraoDTO.getUnidade()).thenReturn(unidadeDTO);
        List<SubunidadeDTO> subunidadeDTOList = new ArrayList<>();
        when(unidadeDTO.getSubunidade()).thenReturn(subunidadeDTOList);
        when(unidadePadraoDTO.getSubstitutoAutoridadeHierarquica()).thenReturn(usuarioSiapeAcessoDTO);
        when(unidadePadraoDTO.getSubstitutoAutoridadeMaxima()).thenReturn(usuarioSiapeAcessoDTO);
        when(unidadePadraoDTO.getResponsavelRecurso()).thenReturn(responsaveisDTO);
        when(responsaveisRepository.findTopByOrderByIdDesc()).thenReturn(responsaveis);
        when(responsaveisDTO.getResponsavelRecursoAcao()).thenReturn("ALTERAR");
        padraoService.salvar(unidadePadraoDTO);
    }

    @Test
    public void salvarEqualsNaoIgual(){
        when(orgaoSiorgService.encontrarOrgaoSiorg(orgaoSiorgDTO)).thenReturn(orgaoSiorg);
        when(unidadePadraoDTO.getUnidade()).thenReturn(unidadeDTO);
        List<SubunidadeDTO> subunidadeDTOList = new ArrayList<>();
        when(unidadeDTO.getSubunidade()).thenReturn(subunidadeDTOList);
        when(unidadePadraoDTO.getSubstitutoAutoridadeHierarquica()).thenReturn(usuarioSiapeAcessoDTO);
        when(unidadePadraoDTO.getSubstitutoAutoridadeMaxima()).thenReturn(usuarioSiapeAcessoDTO);
        when(unidadePadraoDTO.getResponsavelRecurso()).thenReturn(responsaveisDTO);
        when(responsaveisRepository.findTopByOrderByIdDesc()).thenReturn(responsaveis);
        when(responsaveisDTO.getResponsavelRecursoAcao()).thenReturn("teste");
        when(entityConverter.converter(responsaveis, ResponsaveisDTO.class)).thenReturn(responsaveisDTO);
        padraoService.salvar(unidadePadraoDTO);
    }

    @Test
    public void editar(){
        when(unidadeRepository.findByCodigoUnidade("codigo")).thenReturn(unidade);
        when(unidadePadraoDTO.getUnidade()).thenReturn(unidadeDTO);
        usuarioAcessosService.editarAutoridadeUsuarioService(usuarioSiapeAcessoDTO, unidade, "TITULAR");
        when(unidadeDTO.getCodigoUnidade()).thenReturn("codigo");
        when(unidadePadraoDTO.getUnidade()).thenReturn(unidadeDTO);
        when(unidadePadraoDTO.getUsuarioAutoridadeHierarquica()).thenReturn(usuarioSiapeAcessoDTO);
        when(unidadePadraoDTO.getSubstitutoAutoridadeMaxima()).thenReturn(usuarioSiapeAcessoDTO);
        when(unidadePadraoDTO.getResponsavelRecurso()).thenReturn(responsaveisDTO);
        padraoService.editar(unidadePadraoDTO);
    }

    @Test
    public void editarIf(){
        when(unidadeRepository.findByCodigoUnidade("codigo")).thenReturn(unidade);
        when(unidadePadraoDTO.getUnidade()).thenReturn(unidadeDTO);
        usuarioAcessosService.editarAutoridadeUsuarioService(usuarioSiapeAcessoDTO, unidade, "TITULAR");
        when(unidadeDTO.getCodigoUnidade()).thenReturn("codigo");
        when(unidadePadraoDTO.getUnidade()).thenReturn(unidadeDTO);
        when(unidadePadraoDTO.getUsuarioAutoridadeHierarquica()).thenReturn(usuarioSiapeAcessoDTO);
        when(unidadePadraoDTO.getSubstitutoAutoridadeHierarquica()).thenReturn(usuarioSiapeAcessoDTO);
        usuarioAcessosService.desvincularUsuarioDaUnidadeService("FKS_AUTORIDADE_MAXIMA", unidade, "SUBSTITO");
        when(unidadePadraoDTO.getResponsavelRecurso()).thenReturn(responsaveisDTO);
        padraoService.editar(unidadePadraoDTO);
    }

    @Test
    public void obterDadosFuncionaisCatch() throws ServiceException {
        when(myServiceServiceLocator.getConsultaSIAPEHttpPort()).thenReturn(webservice, webservice);
        padraoService.obterDadosFuncionais("cpf");
    }
}