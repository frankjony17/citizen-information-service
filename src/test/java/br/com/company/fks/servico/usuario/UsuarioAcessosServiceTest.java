package br.com.company.fks.servico.usuario;

import br.gov.mpog.acessos.cliente.servico.impl.AcessosClienteSistemaServiceImpl;
import br.com.company.fks.modelo.Responsaveis;
import br.com.company.fks.modelo.Unidade;
import br.com.company.fks.modelo.UsuarioAcessoPerfilAcesso;
import br.com.company.fks.modelo.UsuarioAcessos;
import br.com.company.fks.modelo.dto.UsuarioAcessosDTO;
import br.com.company.fks.modelo.dto.UsuarioPerfilAcessoDTO;
import br.com.company.fks.modelo.dto.UsuariosAcessoDTO;
import br.com.company.fks.modelo.dto.acessosiorg.AutoridadeResponsaveisDTO;
import br.com.company.fks.modelo.dto.acessosiorg.ResponsaveisDTO;
import br.com.company.fks.modelo.dto.acessosiorg.UnidadePadraoDTO;
import br.com.company.fks.modelo.dto.acessosiorg.UsuarioSiapeAcessoDTO;
import br.com.company.fks.modelo.dto.usuarioacesso.UsuarioParametrosDTO;
import br.com.company.fks.repositorio.ResponsaveisRepository;
import br.com.company.fks.repositorio.UsuarioAcessoPerfilAcessoRepository;
import br.com.company.fks.repositorio.UsuarioAcessosRepository;
import br.com.company.fks.utils.EntityConverter;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Matchers.anyLong;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UsuarioAcessosServiceTest {

    @InjectMocks
    private UsuarioAcessosService usuarioAcessosService;

    @Mock
    private UsuarioAcessosCriar usuarioAcessosCriar;

    @Mock
    private UsuarioAcessosEditar usuarioAcessosEditar;

    @Mock
    private UsuarioAcessosBuscar usuarioAcessosBuscar;

    @Mock
    private UsuarioAcessosListar usuarioAcessosListar;

    @Mock
    private UsuarioAcessosObter usuarioAcessosObter;

    @Mock
    private UsuarioAcessoPerfilAcessoRepository usuarioAcessoPerfilAcessoRepository;

    @Mock
    private ResponsaveisRepository responsaveisRepository;

    @Mock
    private UsuarioParametrosDTO usuarioParametrosDTO;

    @Mock
    private UnidadePadraoDTO unidadePadraoDTO;

    @Mock
    private UsuarioSiapeAcessoDTO usuarioSiapeAcessoDTO;

    @Mock
    private Unidade unidade;

    @Mock
    private UsuarioAcessosDTO usuarioAcessosDTO;

    @Mock
    private UsuarioAcessos usuarioAcessos;

    @Mock
    private UsuarioAcessosRepository usuarioAcessosRepository;

    @Mock
    private UsuarioAcessoPerfilAcesso usuarioAcessoPerfilAcesso;

    @Mock
    private AcessosClienteSistemaServiceImpl acessosClienteSistemaServiceImpl;

    @Mock
    private EntityConverter entityConverter;

    @Mock
    private UsuariosAcessoDTO usuariosAcessoDTO;

    @Test
    public void listarTodosPerfils(){
        usuarioAcessosService.listarTodosPerfils();
    }

    @Test
    public void buscarUsuarioPontoFocalPorSubunidadeService(){
        usuarioAcessosService.buscarUsuarioPontoFocalPorSubunidadeService(1L);
    }

    @Test
    public void buscarUsuarioTecnicoPorSubunidadeService(){
        usuarioAcessosService.buscarUsuarioTecnicoPorSubunidadeService();
    }

    @Test
    public void editarUsuarioPerfilService(){
        usuarioAcessosService.editarUsuarioPerfilService(usuarioParametrosDTO);
    }

    @Test
    public void obterUsuariosPorPerfilServiceOptional(){
        usuarioAcessosService.obterUsuariosPorPerfilService("nomePerfil", Optional.of(1));
    }

    @Test
    public void obterUsuariosPorPerfilService(){
        usuarioAcessosService.obterUsuariosPorPerfilService("nomePerfil");
    }

    @Test
    public void obterUsuariosNoBancoDadosService(){
        usuarioAcessosService.obterUsuariosNoBancoDadosService(unidadePadraoDTO, 1L);
    }

    @Test
    public void editarAutoridadeUsuarioService(){
        usuarioAcessosService.editarAutoridadeUsuarioService(usuarioSiapeAcessoDTO, unidade, "papel");
    }

    @Test
    public void desvincularUsuarioDaUnidadeService(){
        usuarioAcessosService.desvincularUsuarioDaUnidadeService("perfil", unidade, "papel");
    }

    @Test
    public void newAutoridadeUsuarioService(){
        usuarioAcessosService.newAutoridadeUsuarioService(usuarioSiapeAcessoDTO, unidade, "papel");
    }

    @Test
    public void buscarUsuarioAutoridade(){
        UsuarioAcessoPerfilAcesso usuarioAcessoPerfilAcesso = new UsuarioAcessoPerfilAcesso();
        when(usuarioAcessoPerfilAcessoRepository.findFirstByUsuarioAcessosUnidadeIdAndPerfilAcessosNomePerfil(anyLong(),anyString())).thenReturn(usuarioAcessoPerfilAcesso);
        usuarioAcessosService.buscarUsuarioAutoridade(1L,"perfil");
    }

    @Test
    public void detalharUsuarioService(){
        UsuarioPerfilAcessoDTO usuarioPerfilAcessoDTO = new UsuarioPerfilAcessoDTO();
        usuarioPerfilAcessoDTO.setCpf("cpf");
        usuarioPerfilAcessoDTO.setNome("nome");
        usuarioAcessosService.detalharUsuarioService("cpf","nomePerfil");
    }

    @Test
    public void getAutoridadesNResponsaveisService(){
        Responsaveis responsaveis = new Responsaveis();
        responsaveis.setResponsavelRecursoTerceiraInstancia("responsaveisTerceira");
        responsaveis.setResponsavelRecursoQuartaInstancia("responsaveisQuarta");
        ResponsaveisDTO responsaveisDTO = new ResponsaveisDTO();
        responsaveisDTO.setResponsavelRecursoTerceiraInstancia("responsaveisTerceira");
        responsaveisDTO.setResponsavelRecursoQuartaInstancia("responsaveisQuarta");
        UnidadePadraoDTO unidadePadraoDTO = new UnidadePadraoDTO();
        UsuarioSiapeAcessoDTO titularH = new UsuarioSiapeAcessoDTO();
        UsuarioSiapeAcessoDTO titularM = new UsuarioSiapeAcessoDTO();
        unidadePadraoDTO.setUsuarioAutoridadeHierarquica(titularH);
        unidadePadraoDTO.setUsuarioAutoridadeMaxima(titularM);
        AutoridadeResponsaveisDTO autoridadeResponsaveisDTO = new AutoridadeResponsaveisDTO();
        autoridadeResponsaveisDTO.setResponsavelRecurso(responsaveisDTO);
        autoridadeResponsaveisDTO.setUsuarioAutoridadeHierarquica(titularH);
        autoridadeResponsaveisDTO.setUsuarioAutoridadeMaxima(titularM);
        usuarioAcessosObter.obterUsuariosNoBancoDados(unidadePadraoDTO,1L);
        when(responsaveisRepository.findByUnidadeId(anyLong())).thenReturn(responsaveis);
        usuarioAcessosService.getAutoridadesNResponsaveisService(1L);
    }

    @Test
    public void atualizarUsuarioService(){
        when(usuarioAcessoPerfilAcessoRepository.findFirstByUsuarioAcessosCpfUsuarioAndPerfilAcessosNomePerfil(anyString(), anyString())).thenReturn(usuarioAcessoPerfilAcesso);
        Assert.assertNotNull(usuarioAcessosService.atualizaPerfilUsuario("cpf", "FKS"));
    }

    @Test
    public void atualizarUsuarioServiceNu(){
        when(usuarioAcessosRepository.findFirstByCpfUsuario(anyString())).thenReturn(usuarioAcessos);
        usuarioAcessosService.atualizaPerfilUsuario("cpf", "FKS");
    }

    @Test
    public void getUsuarioTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        UsuarioAcessos usuarioAcessosEsperado = new UsuarioAcessos();
        usuarioAcessosEsperado.setCargoUsuario(null);
        usuarioAcessosEsperado.setNomeUsuario(null);
        usuarioAcessosEsperado.setEmailUsuario(null);
        usuarioAcessosEsperado.setCodigoUsuario(null);
        usuarioAcessosEsperado.setUnidade(null);

        UsuarioAcessos usuarioAcessosAgora = new UsuarioAcessos();

        Method method = UsuarioAcessosService.class.getDeclaredMethod("getUsuario", UsuariosAcessoDTO.class);
        method.setAccessible(true);
        UsuariosAcessoDTO usuariosAcessoDTO = new UsuariosAcessoDTO();
        method.invoke(usuarioAcessosService, usuariosAcessoDTO);

        Assert.assertEquals(usuarioAcessosEsperado.getCargoUsuario(), usuarioAcessosAgora.getCargoUsuario());
        Assert.assertEquals(usuarioAcessosEsperado.getNomeUsuario(), usuarioAcessosAgora.getNomeUsuario());
        Assert.assertEquals(usuarioAcessosEsperado.getEmailUsuario(), usuarioAcessosAgora.getEmailUsuario());
        Assert.assertEquals(usuarioAcessosEsperado.getCodigoUsuario(), usuarioAcessosAgora.getCodigoUsuario());
        Assert.assertEquals(usuarioAcessosEsperado.getUnidade(), usuarioAcessosAgora.getUnidade());
    }

    @Test
    public void salvarUsuarioService(){
        UsuarioParametrosDTO parametros = new UsuarioParametrosDTO();
        usuarioAcessosService.salvarUsuarioService(parametros);
    }


}