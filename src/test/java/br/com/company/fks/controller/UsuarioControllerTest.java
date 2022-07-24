package br.com.company.fks.controller;

import br.gov.mpog.acessos.cliente.servico.AcessosClienteSistemaService;
import br.com.company.fks.excecao.FKSException;
import br.com.company.fks.modelo.Alertas;
import br.com.company.fks.modelo.dto.AlertaDTO;
import br.com.company.fks.modelo.dto.usuarioacesso.UsuarioDadosDTO;
import br.com.company.fks.repositorio.AlertasRepository;
import br.com.company.fks.servico.usuario.UsuarioService;
import br.com.company.fks.utils.EntityConverter;
import br.com.company.fks.utils.UsuarioLogadoUtil;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

/**
 * Created by Maicon Godoy - FKSolutions Tecnologia on 26/07/18.
 */
@RunWith(MockitoJUnitRunner.class)
public class UsuarioControllerTest {
    @InjectMocks
    private UsuarioController usuarioController;

    @Mock
    private UsuarioService usuarioService;

    @Mock
    private AcessosClienteSistemaService acessosClienteSistemaService;

    @Mock
    List<Object> listaPerfilDTO;

    @Mock
    private UsuarioLogadoUtil usuarioLogadoUtil;

    @Mock
    private UsuarioDadosDTO usuarioDadosDTO;

    @Mock
    private AlertasRepository alertasRepository;

    @Mock
    private Alertas alertas;

    @Mock
    private EntityConverter entityConverter;

    @Mock
    private AlertaDTO alertaDTO;

    @Test
    public void obterUsuarioLogado(){
        usuarioController.obterUsuarioLogado();
    }

    @Test
    public void buscarTodosPerfis(){
        when(acessosClienteSistemaService.buscarPerfis(null, null, null, null, null, null, null)).thenReturn(listaPerfilDTO);
        ResponseEntity<List<Object>> response = usuarioController.buscarTodosPerfis();
        assertNotNull(response);
    }

    @Test
    public void obterAlerta(){
        List<Alertas> alertasList = new ArrayList<>();
        when(alertasRepository.findAll()).thenReturn(alertasList);
        usuarioController.obterAlerta();
    }

    @Test
    public void obterAlertaEntrandoNoIf(){
        List<Alertas> alertasList = new ArrayList<>();
        alertasList.add(alertas);
        when(alertasRepository.findAll()).thenReturn(alertasList);
        when(entityConverter.converter(alertasList, AlertaDTO.class)).thenReturn(alertaDTO);
        usuarioController.obterAlerta();
    }

    @Test
    public void buscarTodosUsuarios(){
        when(acessosClienteSistemaService.buscarUsuarios(null, 1L, null, null, null, null, null, null, null)).thenReturn(listaPerfilDTO);
        ResponseEntity<List<Object>> response = usuarioController.buscarTodosUsuarios(1L);
        assertNotNull(response);
    }

    @Test
    public void editarAlerta(){
        when(alertasRepository.findOne(1L)).thenReturn(alertas);
        when(alertaDTO.getId()).thenReturn(1L);
        when(alertaDTO.getAlerta()).thenReturn("alerta");
        when(alertasRepository.save(alertas)).thenReturn(alertas);
        usuarioController.editarAlerta(alertaDTO);
    }

    @Test
    public void editarAlertaNull(){
        when(alertasRepository.findOne(1L)).thenReturn(alertas);
        when(alertaDTO.getId()).thenReturn(null);
        usuarioController.editarAlerta(alertaDTO);
    }


    @Test
    public void editarDados(){
        usuarioController.editarDados(usuarioDadosDTO);
    }

    @Test
    public void editarDadosException(){
        Mockito.doThrow(FKSException.class).when(usuarioService).editarDados(usuarioDadosDTO);
        usuarioController.editarDados(usuarioDadosDTO);
    }

    @Test
    public void obterPerfilUsuarioLogadoPeloCpf(){
        when(usuarioLogadoUtil.getPerfil()).thenReturn("teste");
        usuarioController.obterPerfilUsuarioLogadoPeloCpf();
    }
}
