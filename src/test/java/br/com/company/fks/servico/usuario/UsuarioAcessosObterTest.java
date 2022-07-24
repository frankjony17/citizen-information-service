package br.com.company.fks.servico.usuario;

import br.gov.mpog.acessos.cliente.servico.impl.AcessosClienteSistemaServiceImpl;
import br.com.company.fks.modelo.PerfilAcessos;
import br.com.company.fks.modelo.Unidade;
import br.com.company.fks.modelo.UsuarioAcessoPerfilAcesso;
import br.com.company.fks.modelo.UsuarioAcessos;
import br.com.company.fks.modelo.dto.acessosiorg.UnidadePadraoDTO;
import br.com.company.fks.modelo.dto.acessosiorg.UsuarioSiapeAcessoDTO;
import br.com.company.fks.repositorio.PerfilAcessosRepository;
import br.com.company.fks.repositorio.UsuarioAcessoPerfilAcessoRepository;
import br.com.company.fks.repositorio.UsuarioAcessosRepository;
import br.com.company.fks.utils.EntityConverter;
import lombok.SneakyThrows;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UsuarioAcessosObterTest {

    @InjectMocks
    private UsuarioAcessosObter usuarioAcessosObter;

    @Mock
    private UsuarioAcessosRepository usuarioAcessosRepository;

    @Mock
    private UsuarioAcessoPerfilAcessoRepository usuarioAcessoPerfilAcessoRepository;

    @Mock
    private PerfilAcessosRepository perfilAcessosRepository;

    @Mock
    private UsuarioAcessos usuarioAcessos;

    @Mock
    private UnidadePadraoDTO unidadePadraoDTO;

    @Mock
    private UsuarioAcessoPerfilAcesso usuarioAcessoPerfilAcesso;

    @Mock
    private UsuarioAcessosCriar usuarioAcessosCriar;

    @Mock
    private UsuarioSiapeAcessoDTO usuarioSiapeAcessoDTO;

    @Mock
    private AcessosClienteSistemaServiceImpl acessosClienteSistemaService;

    @Mock
    private EntityConverter entityConverter;

    @Mock
    private UsuarioAcessosBuscar usuarioAcessosBuscar;


    @Test
    public void salvarTelefonePerfil(){
        UsuarioSiapeAcessoDTO usuarioSiapeAcessoDTO = new UsuarioSiapeAcessoDTO();
        usuarioAcessosObter.salvarTelefonePerfil(usuarioSiapeAcessoDTO, "nomePerfil");
    }

    @Test
    public void salvarTelefonePerfilTelefoneTrabalho(){
        UsuarioSiapeAcessoDTO usuarioSiapeAcessoDTO = new UsuarioSiapeAcessoDTO();
        usuarioSiapeAcessoDTO.setTelefoneTrabalho("00000000");
        usuarioAcessosObter.salvarTelefonePerfil(usuarioSiapeAcessoDTO, "nomePerfil");
    }

    @Test
    public void salvarTelefoneCelular(){
        UsuarioSiapeAcessoDTO usuarioSiapeAcessoDTO = new UsuarioSiapeAcessoDTO();
        usuarioSiapeAcessoDTO.setTelefoneCelular("00000000");
        usuarioAcessosObter.salvarTelefonePerfil(usuarioSiapeAcessoDTO, "nomePerfil");
    }

    @Test
    public void obterUsuariosNoBancoDados(){
        UnidadePadraoDTO unidadePadraoDTO = new UnidadePadraoDTO();
        Unidade unidade = new Unidade();
        unidade.setId(1L);
        PerfilAcessos perfilAcessos = new PerfilAcessos();
        perfilAcessos.setNomePerfil("nomePerfil");
        perfilAcessos.setDescricaoPerfil("descricaoPerfil");
        UsuarioAcessos usuarioAcessos = new UsuarioAcessos();
        UsuarioAcessoPerfilAcesso usuarioAcessoPerfilAcesso = new UsuarioAcessoPerfilAcesso();
        usuarioAcessoPerfilAcesso.setPerfilAcessos(perfilAcessos);
        usuarioAcessoPerfilAcesso.setUsuarioAcessos(usuarioAcessos);
        usuarioAcessoPerfilAcesso.setIsAtivo(true);
        UsuarioSiapeAcessoDTO usuarioSiapeAcessoDTO = new UsuarioSiapeAcessoDTO();
        List<UsuarioAcessos> usuarioAcessosList = new ArrayList<>();
        usuarioAcessosList.add(usuarioAcessos);
        when(usuarioAcessosRepository.findByUnidadeId(anyLong())).thenReturn(usuarioAcessosList);
        when(usuarioAcessoPerfilAcessoRepository.findByUsuarioAcessosId(anyLong())).thenReturn(usuarioAcessoPerfilAcesso);
        when(usuarioAcessosCriar.montarUsuarioSiapeAcessoDTO(usuarioAcessos,"nomePerfil", "qwerty", true)).thenReturn(usuarioSiapeAcessoDTO);
        when(perfilAcessosRepository.findByNomePerfil(anyString())).thenReturn(perfilAcessos);
        when(perfilAcessosRepository.save(perfilAcessos)).thenReturn(perfilAcessos);
        usuarioAcessosObter.obterUsuariosNoBancoDados(unidadePadraoDTO, 1L);
        usuarioAcessosObter.obterPerfilAcesso("nomePerfil");
    }

    @Test
    public void obterUsuariosPorPerfil(){
        Assert.assertNotNull(usuarioAcessosObter.obterUsuariosPorPerfil("nomePerfil", Optional.of(1)));
    }

    @Test
    @SneakyThrows
    public void obterUsuariosPorPerfilNaoEstaNoAcessos(){
        List<UsuarioAcessoPerfilAcesso> usuarioPerfilBancoDadosList = new ArrayList<>();
        usuarioPerfilBancoDadosList.add(usuarioAcessoPerfilAcesso);
        when(usuarioAcessoPerfilAcessoRepository.findByPerfilAcessosNomePerfil(anyString())).thenReturn(usuarioPerfilBancoDadosList);
        List<Object> usuarioAcessoList = new ArrayList<>();
        usuarioAcessoList.add(Object.class);
        when(acessosClienteSistemaService.buscarUsuarios("0000000", 1L, "nomePerfil", "1", 1L, 1L, "1", 1L, "2")).thenReturn(usuarioAcessoList);

        when(usuarioAcessoPerfilAcesso.getUsuarioAcessos()).thenReturn(usuarioAcessos);
        when(usuarioAcessos.getCpfUsuario()).thenReturn("0000000");

        when(usuarioAcessosBuscar.existeUsuarioDeAcessosNoBancoDados("0000000", usuarioAcessoList)).thenReturn(true);

        when(usuarioAcessoPerfilAcesso.getUsuarioAcessos()).thenReturn(usuarioAcessos);
        when(usuarioAcessos.getNomeUsuario()).thenReturn("[Usuário inexistente no acessos]");


        Assert.assertNotNull(usuarioAcessosObter.obterUsuariosPorPerfil("nomePerfil", Optional.of(1)));
    }

    

}