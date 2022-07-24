package br.com.company.fks.controller;

import br.com.company.fks.controller.builder.RespostaBuilder;
import br.com.company.fks.modelo.UsuarioAcessos;
import br.com.company.fks.modelo.dto.usuarioacesso.UsuarioParametrosDTO;
import br.com.company.fks.servico.usuario.UsuarioAcessosService;
import br.com.company.fks.utils.ControllerUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import java.util.List;

import static org.mockito.Mockito.when;

/**
 * Created by Maicon Godoy - FKSolutions Tecnologia on 26/07/18.
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({ControllerUtil.class,RespostaBuilder.class})
public class UsuarioAcessosControllerTest {

    @InjectMocks
    private UsuarioAcessosController usuarioAcessosController;

    @Mock
    private UsuarioAcessosService usuarioAcessosService;

    @Mock
    private List<UsuarioAcessos> usuarioAcessosList;

    @Mock
    private UsuarioParametrosDTO usuarioParametrosDTO;

    @Test
    public void buscarUsuarioPontoFocalPorSubunidade(){
        when(usuarioAcessosService.buscarUsuarioPontoFocalPorSubunidadeService(1L)).thenReturn(usuarioAcessosList);
        usuarioAcessosController.buscarUsuarioPontoFocalPorSubunidade(1L);
    }

    @Test
    public void buscarUsuarioTecnicoPorSubunidade(){
        usuarioAcessosController.buscarUsuarioTecnicoPorSubunidade();
    }

    @Test
    public void consultarUsuario(){
        usuarioAcessosController.consultarUsuario("filtro");
    }

    @Test
    public void todosUsuarios(){
        usuarioAcessosController.todosUsuarios();
    }

    @Test
    public void todosPerfils(){
        usuarioAcessosController.todosPerfils();
    }

    @Test
    public void salvar(){
        usuarioAcessosController.salvar(usuarioParametrosDTO);
    }

    @Test
    public void detalharUsuario(){
        usuarioAcessosController.detalharUsuario("cpf", "nomePerfil");
    }

    @Test
    public void getAutoridadesNresponsaveis(){
        usuarioAcessosController.getAutoridadesNresponsaveis(1L);
    }

    @Test
    public void atualizarUsuario(){
        usuarioAcessosController.atualizaPerfilUsuario("cpf", "FKS");
    }

    @Test
    public void buscarUsuarioAutoridadeHierarquicaPorUnidade(){
        usuarioAcessosController.buscarUsuarioAutoridadeHierarquicaPorUnidade(1L);
    }

    @Test
    public void buscarUsuarioAutoridadeMaximaPorUnidade(){
        usuarioAcessosController.buscarUsuarioAutoridadeMaximaPorUnidade(1L);
    }

}
