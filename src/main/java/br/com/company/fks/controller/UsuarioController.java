package br.com.company.fks.controller;

import br.com.company.fks.repositorio.AlertasRepository;
import br.gov.mpog.acessos.cliente.servico.AcessosClienteSistemaService;
import br.com.company.fks.excecao.FKSException;
import br.com.company.fks.modelo.Alertas;
import br.com.company.fks.modelo.UsuarioAcessos;
import br.com.company.fks.modelo.dto.AlertaDTO;
import br.com.company.fks.modelo.dto.usuarioacesso.UsuarioDadosDTO;
import br.com.company.fks.modelo.dto.usuarioacesso.UsuarioLogadoDTO;
import br.com.company.fks.servico.usuario.UsuarioService;
import br.com.company.fks.utils.ControllerUtil;
import br.com.company.fks.utils.EntityConverter;
import br.com.company.fks.utils.UsuarioLogadoUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/usuario", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class UsuarioController {

    private static final Logger LOGGER = Logger.getLogger(UsuarioAcessos.class);

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private UsuarioLogadoUtil usuarioLogadoUtil;

    @Autowired
    private AlertasRepository alertasRepository;

    @Autowired
    private EntityConverter entityConverter;

    @Autowired
    private AcessosClienteSistemaService acessosClienteSistemaService;

    @RequestMapping(value = "/logado", method = RequestMethod.GET)
    public ResponseEntity<UsuarioLogadoDTO> obterUsuarioLogado() {
        UsuarioLogadoDTO usuarioLogadoDTO = usuarioService.getUsuarioLogadoPerfis();
        return new ResponseEntity<>(usuarioLogadoDTO, HttpStatus.OK);
    }

    @RequestMapping(value = "/buscarPerfil", method = RequestMethod.GET)
    public ResponseEntity<List<Object>> buscarTodosPerfis() {
        List<Object> listaPerfilDTO = acessosClienteSistemaService.buscarPerfis(null, null, null, null, null, null, null);
        return new ResponseEntity<>(listaPerfilDTO, HttpStatus.OK);
    }

    @RequestMapping(value = "/buscarUsuario/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<Object>> buscarTodosUsuarios(@PathVariable Long id) {
        List<Object> listaUsuarioDTO = acessosClienteSistemaService.buscarUsuarios(null, id, null, null, null, null, null, null, null);
        return new ResponseEntity<>(listaUsuarioDTO, HttpStatus.OK);
    }

    @RequestMapping(value = "/alerta/load", method = RequestMethod.GET)
    public ResponseEntity<AlertaDTO> obterAlerta() {
        AlertaDTO alerta = new AlertaDTO();
        List<Alertas> alertaList = alertasRepository.findAll();

        if (alertaList.size() > 0) {
            alerta = entityConverter.converter(alertaList.get(0), AlertaDTO.class);
        }
        return new ResponseEntity<>(alerta, HttpStatus.OK);
    }

    @RequestMapping(value = "/alerta/editar", method = RequestMethod.PUT)
    public void editarAlerta(@RequestBody AlertaDTO alertaDTO) throws DataAccessException {

        Alertas alertas = new Alertas();

        if (alertaDTO.getId() != null) {
            alertas = alertasRepository.findOne(alertaDTO.getId());
        }
        alertas.setAlerta(alertaDTO.getAlerta());
        alertasRepository.save(alertas);

    }

    @RequestMapping(value = "/editar/dados", method = RequestMethod.PUT)
    public ResponseEntity<UsuarioDadosDTO> editarDados(@RequestBody UsuarioDadosDTO usuarioDadosDTO) {
        ResponseEntity responseEntity;
        try {
            responseEntity = new ResponseEntity<>(usuarioService.editarDados(usuarioDadosDTO), HttpStatus.OK);
        } catch (FKSException e) {
            LOGGER.error("ERRO AO EDITAR A USUARIO", e);
            String errorMessage = ControllerUtil.criarObjetoJson("errorMessage", e.getMessage());
            responseEntity = new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @RequestMapping(value = "/obter/perfil", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> obterPerfilUsuarioLogadoPeloCpf() {
        String nomePerfil = usuarioLogadoUtil.getPerfil();
        return new ResponseEntity<>(nomePerfil, HttpStatus.OK);
    }
}


















