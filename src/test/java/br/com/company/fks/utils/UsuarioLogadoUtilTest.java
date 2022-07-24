package br.com.company.fks.utils;

import br.gov.mpog.acessos.cliente.dto.UsuarioLogadoDTOV2;
import br.gov.mpog.acessos.cliente.servico.AcessosClienteService;
import br.com.company.fks.modelo.UsuarioAcessos;
import br.com.company.fks.repositorio.UsuarioAcessosRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.powermock.api.mockito.PowerMockito.when;

@RunWith(PowerMockRunner.class)
public class UsuarioLogadoUtilTest {

    @InjectMocks
    private UsuarioLogadoUtil usuarioLogadoUtil;

    @Mock
    private AcessosClienteService acessosClienteService;

    @Mock
    private UsuarioLogadoDTOV2 usuarioLogadoDTOV2;

    @Mock
    private UsuarioAcessos usuarioDataBase;

    @Mock
    private UsuarioAcessosRepository usuarioAcessosRepository;

    @Test
    public void init(){
        when(acessosClienteService.buscarUsuarioLogadoV2()).thenReturn(usuarioLogadoDTOV2);
        when(usuarioAcessosRepository.findFirstByCpfUsuario("00000000000")).thenReturn(usuarioDataBase);
        when(usuarioLogadoDTOV2.getCpf()).thenReturn("00000000000");
    }

    @Test
    public void getCpf(){
        init();
        usuarioLogadoUtil.getCpf();
    }

    @Test
    public void getNome(){
        init();
        usuarioLogadoUtil.getNome();
    }

    @Test
    public void getPerfil(){
        init();
        usuarioLogadoUtil.getPerfil();
    }

    @Test
    public void getPerfilIf(){
        when(acessosClienteService.buscarUsuarioLogadoV2()).thenReturn(usuarioLogadoDTOV2);
        when(usuarioAcessosRepository.findFirstByCpfUsuario(null)).thenReturn(null);
        when(usuarioLogadoDTOV2.getCpf()).thenReturn("00000000000");
        usuarioLogadoUtil.getPerfil();
    }

    @Test
    public void getUsuario(){
        init();
        usuarioLogadoUtil.getUsuario();
    }


}