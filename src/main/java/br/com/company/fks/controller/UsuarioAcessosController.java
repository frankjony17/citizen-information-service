package br.com.company.fks.controller;

import br.com.company.fks.controller.builder.Resposta;
import br.com.company.fks.excecao.ObjectMapperException;
import br.com.company.fks.modelo.TempUsuarioAcessos;
import br.com.company.fks.modelo.UsuarioAcessos;
import br.com.company.fks.modelo.dto.FiltroUsuarioDTO;
import br.com.company.fks.modelo.dto.UsuarioDTO;
import br.com.company.fks.modelo.dto.UsuarioPerfilAcessoDTO;
import br.com.company.fks.modelo.dto.acessosiorg.AutoridadeResponsaveisDTO;
import br.com.company.fks.modelo.dto.usuarioacesso.UsuarioParametrosDTO;
import br.com.company.fks.servico.usuario.UsuarioAcessosListar;
import br.com.company.fks.servico.usuario.UsuarioAcessosService;
import br.com.company.fks.utils.ControllerUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@RestController
@RequestMapping(value = "/usuarioAcessos", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class UsuarioAcessosController {

    public static final String ERROR_MESSAGE = "errorMessage";
    private static final Logger LOGGER = Logger.getLogger(EmailController.class);

    @Autowired
    private UsuarioAcessosService usuarioAcessosService;

    @Autowired
    private UsuarioAcessosListar usuarioAcessosListar;

    @RequestMapping(value = "/buscarUsuarioPontoFocalPorSubunidade/{idSubunidade}", method = RequestMethod.GET)
    public ResponseEntity<List<UsuarioAcessos>> buscarUsuarioPontoFocalPorSubunidade(@PathVariable Long idSubunidade) {
        List<UsuarioAcessos> usuarioAcessosList = usuarioAcessosService.buscarUsuarioPontoFocalPorSubunidadeService(idSubunidade);
        return new ResponseEntity<>(usuarioAcessosList, HttpStatus.OK);
    }

    @RequestMapping(value = "/buscarUsuarioTecnicoPorSubunidade", method = RequestMethod.GET)
    public ResponseEntity<List<UsuarioAcessos>> buscarUsuarioTecnicoPorSubunidade() {
        List<UsuarioAcessos> usuarioAcessosList = usuarioAcessosService.buscarUsuarioTecnicoPorSubunidadeService();
        return new ResponseEntity<>(usuarioAcessosList, HttpStatus.OK);
    }

    @RequestMapping(value = "/obterTodosUsuarios", method = RequestMethod.GET)
    public ResponseEntity obterTodosUsuarios() {
        usuarioAcessosListar.obterTodosUsuarios();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<Resposta<List<TempUsuarioAcessos>>> consultarUsuario(@RequestParam(value = "filtro") String filtro) {
        ResponseEntity responseEntity;
        try {
            FiltroUsuarioDTO parms = ControllerUtil.montarFiltroDTO(filtro, FiltroUsuarioDTO.class);
            responseEntity = new ResponseEntity<>(usuarioAcessosService.consultarUsuarioService(parms), HttpStatus.OK);
        }
        catch (ObjectMapperException ome) {
            LOGGER.error("ERRO AO CONSULTAR USUARIO", ome);
            String errorMessage = ControllerUtil.criarObjetoJson(ERROR_MESSAGE, ome.getMessage());
            responseEntity = new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @RequestMapping(value = "/all-users", method = RequestMethod.GET)
    public ResponseEntity<List<UsuarioDTO>> todosUsuarios() {
        return new ResponseEntity<>(usuarioAcessosListar.listarTodosUsuarios(), HttpStatus.OK);
    }

    @RequestMapping(value = "/all-profiles", method = RequestMethod.GET)
    public ResponseEntity todosPerfils() {
        return new ResponseEntity<>(usuarioAcessosService.listarTodosPerfils(), HttpStatus.OK);
    }

    @RequestMapping(value = "/salvar", method = RequestMethod.POST)
    public ResponseEntity salvar(@RequestBody UsuarioParametrosDTO parametros) {
        return usuarioAcessosService.salvarUsuarioService(parametros);
    }

    @RequestMapping(value = "/detalhar", method = RequestMethod.GET)
    public ResponseEntity<UsuarioPerfilAcessoDTO> detalharUsuario(@RequestParam String cpf, @RequestParam String nomePerfil) {
        UsuarioPerfilAcessoDTO usuarioDetalhado = usuarioAcessosService.detalharUsuarioService(cpf, nomePerfil);
        return new ResponseEntity<>(usuarioDetalhado, HttpStatus.OK);
    }

    @RequestMapping(value="/getAutoridades", method = RequestMethod.GET)
    public ResponseEntity<AutoridadeResponsaveisDTO> getAutoridadesNresponsaveis(@RequestParam Long id) {
        AutoridadeResponsaveisDTO autoridadeResponsaveisDTO = usuarioAcessosService.getAutoridadesNResponsaveisService(id);
        return new ResponseEntity<>(autoridadeResponsaveisDTO, HttpStatus.OK);
    }

    @RequestMapping(value="/update/perfil/{cpf}", method= RequestMethod.PUT, produces=MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> atualizaPerfilUsuario(@PathVariable String cpf, @RequestBody String perfil){
        return usuarioAcessosService.atualizaPerfilUsuario(cpf, perfil);
    }

    @RequestMapping(value = "/buscaUsuarioPorUnidade/{idUnidade}", method = RequestMethod.GET)
    public ResponseEntity<List<UsuarioAcessos>> buscarUsuarioAutoridadeHierarquicaPorUnidade(@PathVariable Long idUnidade){
        return new ResponseEntity<>(usuarioAcessosService.buscarUsuarioAutoridade(idUnidade, "FKS.AUTORIDADE.HIERARQUICA"), HttpStatus.OK);
    }

    @RequestMapping(value = "/buscarUsuarioAutoridadeMaximaPorUnidade/{idUnidade}", method = RequestMethod.GET)
    public ResponseEntity<List<UsuarioAcessos>> buscarUsuarioAutoridadeMaximaPorUnidade(@PathVariable Long idUnidade){
        return new ResponseEntity<>(usuarioAcessosService.buscarUsuarioAutoridade(idUnidade, "FKS.AUTORIDADE.MAXIMA"), HttpStatus.OK);
    }
}

