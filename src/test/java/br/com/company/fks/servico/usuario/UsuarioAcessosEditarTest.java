package br.com.company.fks.servico.usuario;

import br.com.company.fks.modelo.Unidade;
import br.com.company.fks.modelo.UsuarioAcessoPerfilAcesso;
import br.com.company.fks.modelo.UsuarioAcessos;
import br.com.company.fks.modelo.dto.acessosiorg.UsuarioSiapeAcessoDTO;
import br.com.company.fks.modelo.dto.usuarioacesso.UsuarioParametrosDTO;
import br.com.company.fks.repositorio.UsuarioAcessoPerfilAcessoRepository;
import br.com.company.fks.repositorio.UsuarioAcessosRepository;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UsuarioAcessosEditarTest {

    @InjectMocks
    private UsuarioAcessosEditar usuarioAcessosEditar;

    @Mock
    private UsuarioParametrosDTO usuarioParametrosDTO;

    @Mock
    private UsuarioAcessosRepository usuarioAcessosRepository;

    @Mock
    private UsuarioAcessos usuarioAcessos;

    @Mock
    private Unidade unidade;

    @Mock
    private UsuarioAcessoPerfilAcessoRepository usuarioAcessoPerfilAcessoRepository;

    @Mock
    private UsuarioAcessoPerfilAcesso usuarioAcessoPerfilAcesso;

    @Mock
    private UsuarioSiapeAcessoDTO usuarioSiapeAcessoDTO;

    @Mock
    private UsuarioAcessosCriar usuarioAcessosCriar;


    @Test
    public void editarAutoridadeUsuario(){
        when(usuarioAcessosRepository.findFirstByCpfUsuario("00000000000")).thenReturn(usuarioAcessos);
        usuarioAcessosCriar.newAutoridadeUsuario(usuarioSiapeAcessoDTO, unidade, "papel");
        usuarioAcessosEditar.editarAutoridadeUsuario(usuarioSiapeAcessoDTO, unidade, "papel");
    }

    @Test
    public void editarAutoridadeUsuarioElseSimPapel(){
        when(usuarioAcessosRepository.findFirstByCpfUsuario("00000000000")).thenReturn(usuarioAcessos);
        when(usuarioSiapeAcessoDTO.getCpf()).thenReturn("00000000000");
        when(usuarioAcessoPerfilAcessoRepository.findFirstByUsuarioAcessosCpfUsuarioAndPerfilAcessosNomePerfil("00000000000", "perfil")).thenReturn(usuarioAcessoPerfilAcesso);
        when(usuarioAcessos.getCpfUsuario()).thenReturn("00000000000");
        when(usuarioSiapeAcessoDTO.getPerfil()).thenReturn("perfil");
        when(usuarioAcessos.getUnidade()).thenReturn(unidade);
        when(unidade.getCodigoUnidade()).thenReturn("1");
        when(unidade.getCodigoUnidade()).thenReturn("1");

        when(usuarioAcessoPerfilAcesso.getPapel()).thenReturn("papel");

        usuarioAcessosCriar.newAutoridadeUsuario(usuarioSiapeAcessoDTO, unidade, "papel");
        usuarioAcessosEditar.editarAutoridadeUsuario(usuarioSiapeAcessoDTO, unidade, "papel");
    }

    @Test
    public void editarAutoridadeUsuarioElseNaoPapel(){
        when(usuarioAcessosRepository.findFirstByCpfUsuario("00000000000")).thenReturn(usuarioAcessos);
        when(usuarioSiapeAcessoDTO.getCpf()).thenReturn("00000000000");
        when(usuarioAcessoPerfilAcessoRepository.findFirstByUsuarioAcessosCpfUsuarioAndPerfilAcessosNomePerfil("00000000000", "perfil")).thenReturn(usuarioAcessoPerfilAcesso);
        when(usuarioAcessos.getCpfUsuario()).thenReturn("00000000000");
        when(usuarioSiapeAcessoDTO.getPerfil()).thenReturn("perfil");
        when(usuarioAcessos.getUnidade()).thenReturn(unidade);
        when(unidade.getCodigoUnidade()).thenReturn("1");
        when(unidade.getCodigoUnidade()).thenReturn("1");

        when(usuarioAcessoPerfilAcesso.getPapel()).thenReturn("naoPapel");
        when(usuarioAcessoPerfilAcessoRepository.save(usuarioAcessoPerfilAcesso)).thenReturn(usuarioAcessoPerfilAcesso);
        when(usuarioAcessoPerfilAcesso.getUsuarioAcessos()).thenReturn(usuarioAcessos);
        when(usuarioSiapeAcessoDTO.getEmail()).thenReturn("email");
        when(usuarioSiapeAcessoDTO.getCargo()).thenReturn("cargo");
        when(usuarioSiapeAcessoDTO.getFuncao()).thenReturn("funcao");
        when(usuarioSiapeAcessoDTO.getTelefone()).thenReturn("telefone");

        usuarioAcessosCriar.newAutoridadeUsuario(usuarioSiapeAcessoDTO, unidade, "papel");
        usuarioAcessosEditar.editarAutoridadeUsuario(usuarioSiapeAcessoDTO, unidade, "papel");
    }

    @Test
    public void desvincularUsuarioDaUnidade(){
        when(usuarioAcessoPerfilAcessoRepository.findFirstByPerfilAcessosNomePerfilAndUsuarioAcessosUnidadeAndPapel("perfil", unidade, "papel")).thenReturn(usuarioAcessoPerfilAcesso);
        when(usuarioAcessoPerfilAcesso.getUsuarioAcessos()).thenReturn(usuarioAcessos);
        when(usuarioAcessoPerfilAcessoRepository.save(usuarioAcessoPerfilAcesso)).thenReturn(usuarioAcessoPerfilAcesso);
        usuarioAcessosEditar.desvincularUsuarioDaUnidade("perfil", unidade, "papel");
    }


    @Test
    public void editarAutoridadeUsuarioUsuarioAcessosDiferentedeNull(){
        when(usuarioAcessosRepository.findFirstByCpfUsuario("00000000000")).thenReturn(usuarioAcessos);
        when(usuarioSiapeAcessoDTO.getCpf()).thenReturn("00000000000");
        when(usuarioAcessoPerfilAcessoRepository.findFirstByUsuarioAcessosCpfUsuarioAndPerfilAcessosNomePerfil("00000000000", "nomePerfil")).thenReturn(usuarioAcessoPerfilAcesso);
        usuarioAcessosEditar.editarAutoridadeUsuario(usuarioSiapeAcessoDTO, unidade, "papel");
    }

    @Test
    public void desvincularUsuarioDaUnidadeNull(){
        when(usuarioAcessoPerfilAcessoRepository.findFirstByPerfilAcessosNomePerfilAndUsuarioAcessosUnidadeAndPapel("perfilNome", unidade, "papel")).thenReturn(usuarioAcessoPerfilAcesso);
        usuarioAcessosEditar.desvincularUsuarioDaUnidade("perfil", unidade, "papel");
    }

    @Test
    public void editarUsuarioPerfil(){
        when(usuarioAcessosRepository.findFirstByCpfUsuario(usuarioParametrosDTO.getCpf())).thenReturn(usuarioAcessos);
       usuarioAcessosEditar.editarUsuarioPerfil(usuarioParametrosDTO);
    }

    @Test
    public void upgradeUsuario(){
        UsuarioSiapeAcessoDTO usuario = new UsuarioSiapeAcessoDTO();
        usuario.setEmail("email");
        usuario.setCargo("cargo");
        usuario.setFuncao("funcao");
        usuario.setTelefoneCelular("telefone");
        usuario.setAssinatura("assinatura");
        UsuarioAcessos usuarioAcessos = new UsuarioAcessos();
        usuarioAcessos.setEmailUsuario("emaiilU");
        usuarioAcessos.setCargoUsuario("cargoU");
        usuarioAcessos.setFuncaoUsuario("funcaoU");
        usuarioAcessos.setTelefoneUsuario("telefoneU");
        usuarioAcessos.setUnidade(unidade);
        when(usuarioAcessosRepository.save(usuarioAcessos)).thenReturn(usuarioAcessos);
        usuarioAcessosEditar.editarAutoridadeUsuario(usuario,unidade,"papel");
        usuarioAcessosEditar.desvincularUsuarioDaUnidade("perfil",unidade,"papel");
    }

}