package br.com.company.fks.servico.usuario;

import br.com.company.fks.modelo.*;
import br.gov.mpog.acessos.cliente.servico.AcessosClienteSistemaService;
import br.gov.mpog.fks.modelo.*;
import br.com.company.fks.modelo.dto.PerfilAcessosDTO;
import br.com.company.fks.modelo.dto.usuarioacesso.UsuarioDadosDTO;
import br.com.company.fks.repositorio.ResponsaveisRepository;
import br.com.company.fks.repositorio.UsuarioAcessoPerfilAcessoRepository;
import br.com.company.fks.repositorio.UsuarioAcessosRepository;
import br.com.company.fks.repositorio.custom.PedidoCustomRepositorio;
import br.com.company.fks.servico.UnidadeService;
import br.com.company.fks.utils.EntityConverter;
import br.com.company.fks.utils.UsuarioLogadoUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.List;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(PowerMockRunner.class)
public class UsuarioServiceTest {

    @InjectMocks
    private UsuarioService usuarioService;

    @Mock
    private UsuarioLogadoUtil usuarioLogadoUtil;

    @Mock
    private UsuarioAcessos usuarioAcessos;

    @Mock
    private ResponsaveisRepository responsaveisRepository;

    @Mock
    private Responsaveis responsaveis;

    @Mock
    private Unidade unidade;

    @Mock
    private UsuarioAcessoPerfilAcessoRepository usuarioAcessoPerfilAcessoRepository;

    @Mock
    private UsuarioAcessoPerfilAcesso usuarioAcessoPerfilAcesso;

    @Mock
    private Subunidade subunidade;

    @Mock
    private AcessosClienteSistemaService acessosClienteSistemaService;

    @Mock
    private List<Object> objectList;

    @Mock
    private PedidoCustomRepositorio pedidoCustomRepositorio;

    @Mock
    private UsuarioAcessosRepository usuarioAcessosRepository;

    @Mock
    private UsuarioDadosDTO usuarioDadosDTO;

    @Mock
    private EntityConverter entityConverter;

    @Mock
    private PerfilAcessosDTO perfilAcessosDTO;

    @Mock
    private UnidadeService unidadeService;

    @Test
    public void getUsuarioLogadoPerfis(){
        when(usuarioLogadoUtil.getUsuario()).thenReturn(usuarioAcessos);
        when(responsaveisRepository.findTopByOrderByIdDesc()).thenReturn(responsaveis);
        when(usuarioAcessos.getUnidade()).thenReturn(unidade);
        when(usuarioAcessoPerfilAcessoRepository.findFirstByPerfilAcessosNomePerfilAndUsuarioAcessosUnidadeAndPapel("perfilNome", unidade, "TITULAR")).thenReturn(usuarioAcessoPerfilAcesso);
        when(acessosClienteSistemaService.buscarPerfis("00000000000", null, null, null, null, null, null)).thenReturn(objectList);
        when(entityConverter.converter(Object.class, PerfilAcessosDTO.class)).thenReturn(perfilAcessosDTO);
        when(usuarioAcessoPerfilAcessoRepository.findFirstByUsuarioAcessosCpfUsuarioAndPerfilAcessosNomePerfil("11111111111", "teste")).thenReturn(usuarioAcessoPerfilAcesso);
        when(unidadeService.getOneSubunidadePeloUsuarioCpf(anyString())).thenReturn(subunidade);
        when(usuarioLogadoUtil.getCpf()).thenReturn("000");
        usuarioService.getUsuarioLogadoPerfis();
    }

    @Test
    public void editarDados(){
        when(usuarioAcessosRepository.findOne(1L)).thenReturn(usuarioAcessos);
        when(usuarioDadosDTO.getId()).thenReturn(1L);
        when(usuarioDadosDTO.getEmail()).thenReturn("teste");
        when(usuarioAcessosRepository.save(usuarioAcessos)).thenReturn(usuarioAcessos);
        usuarioService.editarDados(usuarioDadosDTO);
    }

}