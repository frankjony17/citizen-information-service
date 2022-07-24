package br.com.company.fks.servico.usuario;

import br.com.company.fks.modelo.PerfilAcessos;
import br.com.company.fks.modelo.Unidade;
import br.com.company.fks.modelo.UsuarioAcessoPerfilAcesso;
import br.com.company.fks.modelo.UsuarioAcessos;
import br.com.company.fks.modelo.dto.UsuarioDetalhadoDTO;
import br.com.company.fks.modelo.dto.acessosiorg.UsuarioSiapeAcessoDTO;
import br.com.company.fks.modelo.dto.usuarioacesso.UsuarioParametrosDTO;
import br.com.company.fks.repositorio.UsuarioAcessoPerfilAcessoRepository;
import br.com.company.fks.repositorio.UsuarioAcessosRepository;
import br.com.company.fks.repositorio.UsuarioAcessosSubunidadeRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.spy;
import static org.powermock.api.mockito.PowerMockito.whenNew;

@RunWith(PowerMockRunner.class)
public class UsuarioAcessosCriarTest {

    @InjectMocks
    private UsuarioAcessosCriar usuarioAcessosCriar;

    @Mock
    private UsuarioDetalhadoDTO usuarioDetalhadoDTO;

    @Mock
    private UsuarioAcessosRepository usuarioAcessosRepository;

    @Mock
    private UsuarioAcessos usuarioAcessos;

    @Mock
    private UsuarioParametrosDTO parametros;

    @Mock
    private UsuarioAcessoPerfilAcessoRepository usuarioAcessoPerfilAcessoRepository;

    @Mock
    private UsuarioAcessoPerfilAcesso usuarioAcessoPerfilAcesso;

    @Mock
    private UsuarioParametrosDTO usuarioParametrosDTO;

    @Mock
    private UsuarioAcessosObter usuarioAcessosObter;

    @Mock
    private PerfilAcessos perfilAcessos;

    @Mock
    private UsuarioSiapeAcessoDTO usuarioSiapeAcessoDTO;

    @Mock
    private Unidade unidade;

    @Mock
    private UsuarioAcessosSubunidadeRepository usuarioAcessosSubunidadeRepository;

    @Test
    public void montaUsuarioAcessos(){
        usuarioAcessosCriar.montaUsuarioAcessos(usuarioDetalhadoDTO);
    }

    @Test
    public void montarUsuarioSiapeAcessoDTO(){
        UsuarioSiapeAcessoDTO usuarioSiapeAcessoDTO = new UsuarioSiapeAcessoDTO();
        UsuarioAcessos usuarioBandoDados = new UsuarioAcessos();
        usuarioAcessosCriar.montarUsuarioSiapeAcessoDTO(usuarioBandoDados,"nomePerfil","qwerty",true);
    }

    @Test
    public void newAutoridadeUsuario(){
        UsuarioSiapeAcessoDTO usuarioSiapeAcessoDTO = new UsuarioSiapeAcessoDTO();
        Unidade unidade = new Unidade();
        usuarioAcessosCriar.newAutoridadeUsuario(usuarioSiapeAcessoDTO, unidade,"papel");
    }

    @Test
    public void newAutoridadeUsuarioEntrandoNoIf() {
        when(usuarioSiapeAcessoDTO.getCpf()).thenReturn("00000000000");
        when(usuarioSiapeAcessoDTO.getPerfil()).thenReturn("Tetse");
        when(usuarioAcessosRepository.save(any(UsuarioAcessos.class))).thenReturn(usuarioAcessos);
        usuarioAcessosCriar.newAutoridadeUsuario(usuarioSiapeAcessoDTO, unidade, "papel");
        verify(usuarioAcessosRepository, times(1)).save(any(UsuarioAcessos.class));
    }

    @Test
    public void newPerfilUsuario() throws Exception {
        Method method = UsuarioAcessosCriar.class.getDeclaredMethod("newPerfilUsuario", UsuarioAcessos.class, String.class, String.class, String.class);
        method.setAccessible(true);
        method.invoke(usuarioAcessosCriar, usuarioAcessos, "nomePerfil", "papel", "assinatura");
        verify(usuarioAcessoPerfilAcessoRepository, times(1)).save(any(UsuarioAcessoPerfilAcesso.class));
    }

    @Test
    public void preencherUsuario(){
        when(parametros.getUsuario()).thenReturn(usuarioAcessos);
        when(usuarioAcessos.getNomeUsuario()).thenReturn("nomeUsuario");
        usuarioAcessosCriar.preencherUsuario(usuarioAcessos, parametros);
        verify(usuarioAcessosRepository, times(1)).save(any(UsuarioAcessos.class));
    }

    @Test
    public void editarAssinatura(){
        when(usuarioAcessoPerfilAcessoRepository.findFirstByUsuarioAcessosCpfUsuarioAndPerfilAcessosNomePerfil(anyString(), anyString())).thenReturn(usuarioAcessoPerfilAcesso);
        usuarioAcessosCriar.editarAssinatura("0000000000", "nomePerfil", "assinatura");
        verify(usuarioAcessoPerfilAcessoRepository, times(1)).findFirstByUsuarioAcessosCpfUsuarioAndPerfilAcessosNomePerfil("0000000000", "nomePerfil");
        verify(usuarioAcessoPerfilAcessoRepository, times(1)).save(any(UsuarioAcessoPerfilAcesso.class));
    }

    @Test
    public void editarAssinaturaNull(){
        when(usuarioAcessoPerfilAcessoRepository.findFirstByUsuarioAcessosCpfUsuarioAndPerfilAcessosNomePerfil(anyString(), anyString())).thenReturn(null);
        usuarioAcessosCriar.editarAssinatura("0000000000", "nomePerfil", "assinatura");
        verify(usuarioAcessoPerfilAcessoRepository, times(1)).findFirstByUsuarioAcessosCpfUsuarioAndPerfilAcessosNomePerfil("0000000000", "nomePerfil");
    }


}