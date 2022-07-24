package br.com.company.fks.servico.usuario;

import br.gov.mpog.acessos.cliente.servico.impl.AcessosClienteSistemaServiceImpl;
import br.com.company.fks.modelo.PerfilAcessos;
import br.com.company.fks.modelo.UsuarioAcessoPerfilAcesso;
import br.com.company.fks.modelo.UsuarioAcessos;
import br.com.company.fks.modelo.dto.PerfilAcessosDTO;
import br.com.company.fks.modelo.dto.PerfilDTO;
import br.com.company.fks.modelo.dto.UsuariosAcessoDTO;
import br.com.company.fks.repositorio.PerfilAcessosRepository;
import br.com.company.fks.repositorio.UsuarioAcessoPerfilAcessoRepository;
import br.com.company.fks.repositorio.UsuarioAcessosRepository;
import br.com.company.fks.utils.EntityConverter;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@PrepareForTest(UsuarioAcessosListar.class)
public class UsuarioAcessosListarTest {

    @InjectMocks
    private UsuarioAcessosListar usuarioAcessosListar;

    @Mock
    private UsuarioAcessoPerfilAcessoRepository usuarioAcessoPerfilAcessoRepository;

    @Mock
    private PerfilAcessosRepository perfilAcessosRepository;

    @Mock
    private AcessosClienteSistemaServiceImpl acessosClienteSistemaServiceImpl;

    @Mock
    private UsuariosAcessoDTO usuariosAcessoDTO;

    @Mock
    private PerfilAcessosDTO perfilAcessosDTO;

    @Mock
    private EntityConverter entityConverter;

    @Mock
    private PerfilDTO perfilDTO;

    @Mock
    private PerfilAcessos perfilAcessos;

    @Mock
    private UsuarioAcessosRepository usuarioAcessosRepository;

    @Mock
    private UsuarioAcessos usuarioAcessos;

    @Test
    public void listarTodosUsuarios(){
        List<UsuariosAcessoDTO> usuariosAcessoDtolist = new ArrayList<>();
        usuariosAcessoDtolist.add(usuariosAcessoDTO);
        List<Object> usuarioAcessoList = new ArrayList<>();
        when(acessosClienteSistemaServiceImpl.buscarUsuarios(anyString(),anyLong(),anyString(),anyString(),anyLong(),anyLong(),anyString(),anyLong(),anyString())).thenReturn(usuarioAcessoList);
    }

    @Test
    public void listarUsuariosPorCpf(){
        List<UsuariosAcessoDTO> usuariosAcessoDtolist = new ArrayList<>();
        usuariosAcessoDtolist.add(usuariosAcessoDTO);
        List<Object> usuarioAcessoList = new ArrayList<>();
        when(acessosClienteSistemaServiceImpl.buscarUsuarios(anyString(),anyLong(),anyString(),anyString(),anyLong(),anyLong(),anyString(),anyLong(),anyString())).thenReturn(usuarioAcessoList);
    }

    @Test
    public void listarUsuariosPorUnidade(){
        List<UsuarioAcessoPerfilAcesso> usuariosPerfilsAcessosDTO = new ArrayList<>();;
        when(usuarioAcessoPerfilAcessoRepository.findUsuarioAcessoPerfilAcessoByUsuarioAcessosUnidadeNomeUnidade(anyString())).thenReturn(usuariosPerfilsAcessosDTO);
        List<UsuariosAcessoDTO> usuariosAcessoDTOList = new ArrayList<>();
        usuariosAcessoDTOList.add(usuariosAcessoDTO);
    }

    @Test
    public void getPerfisTest() throws Exception {
        ArrayList<PerfilAcessosDTO> perfisUsuarioList = new ArrayList<>();
        ArrayList perfisUsuarioSpy = spy(perfisUsuarioList);
        List<Object> listaOMock = new ArrayList<Object>();
        Object o = mock(Object.class);
        listaOMock.add(o);
        listaOMock.add(o);
        Set<String> cpfList = new HashSet<>();

        UsuarioAcessosListar usuarioAcessosListarSpy = spy(usuarioAcessosListar);

        when(entityConverter.converter(any(Object.class), eq(PerfilDTO.class))).thenReturn(perfilDTO);
        when(usuarioAcessosRepository.findFirstByCpfUsuario(anyString())).thenReturn(usuarioAcessos);
        PowerMockito.whenNew(ArrayList.class).withAnyArguments().thenReturn(perfisUsuarioSpy);
        when(acessosClienteSistemaServiceImpl.buscarPerfis(anyString(), anyString(), anyLong(), anyLong(), anyString(), anyLong(), anyString())).thenReturn(listaOMock);

        Method method = UsuarioAcessosListar.class.getDeclaredMethod("getPerfis", UsuariosAcessoDTO.class, Set.class);
        method.setAccessible(true);
        method.invoke(usuarioAcessosListarSpy, usuariosAcessoDTO, cpfList);

        Assert.assertNotNull(perfisUsuarioSpy.size());


    }

}