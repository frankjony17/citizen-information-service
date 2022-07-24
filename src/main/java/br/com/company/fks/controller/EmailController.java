package br.com.company.fks.controller;

import br.com.company.fks.excecao.ObjectMapperException;
import br.com.company.fks.modelo.StatusSolicitacao;
import br.com.company.fks.modelo.StatusSolicitacaoRecurso;
import br.com.company.fks.modelo.dto.EmailDTO;
import br.com.company.fks.modelo.dto.EmailFiltroDTO;
import br.com.company.fks.modelo.enums.PerfilAcessoEnum;
import br.com.company.fks.modelo.enums.TipoAcaoExecutadaPedidoEnum;
import br.com.company.fks.modelo.enums.TipoAcaoExecutadaRecursoEnum;
import br.com.company.fks.modelo.enums.TipoDataEnum;
import br.com.company.fks.servico.EmailService;
import br.com.company.fks.utils.ControllerUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/email", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class EmailController {

    public static final String ERROR_MESSAGE = "errorMessage";
    private static final Logger LOGGER = Logger.getLogger(EmailController.class);

    @Autowired
    private EmailService emailService;

    @RequestMapping(value = "/listaTipDataPorSolicitacao/{tipoSolicitacao}", method = RequestMethod.GET)
    public ResponseEntity listTipDataPorSolicitacao(@PathVariable Integer tipoSolicitacao) {
        List<TipoDataEnum> listaTipoData = emailService.listaTipoDataPorTipoSolicitacao(tipoSolicitacao);
        return new ResponseEntity<>(listaTipoData, HttpStatus.OK);
    }

    @RequestMapping(value = "/listaTipoDataEnvio", method = RequestMethod.GET)
    public ResponseEntity listaTipoDataEnvio() {
        List<TipoDataEnum> listaTipoData = emailService.listaTipoDataEnvio();
        return new ResponseEntity<>(listaTipoData, HttpStatus.OK);
    }

    @RequestMapping(value = "/listaStatusDemandaPedido", method = RequestMethod.GET)
    public ResponseEntity listaStatusDemandaPedido() {
        List<StatusSolicitacao> tipos = emailService.listaStatusDemandaPedido();
        return new ResponseEntity<>(tipos, HttpStatus.OK);
    }

    @RequestMapping(value = "/listaStatusDemandaRecurso", method = RequestMethod.GET)
    public ResponseEntity listaStatusDemandaRecurso() {
        List<StatusSolicitacaoRecurso> tipos = emailService.listaStatusDemandaRecurso();
        return new ResponseEntity<>(tipos, HttpStatus.OK);
    }

    @RequestMapping(value = "/listaAcoesExecutadasPedido", method = RequestMethod.GET)
    public ResponseEntity listaAcoesExecutadasPedido() {
        List<TipoAcaoExecutadaPedidoEnum> acoes = emailService.listaAcoesExecutadasPedido();
        return new ResponseEntity<>(acoes, HttpStatus.OK);
    }

    @RequestMapping(value = "/listaAcoesExecutadasRecurso", method = RequestMethod.GET)
    public ResponseEntity listaAcoesExecutadasRecurso() {
        List<TipoAcaoExecutadaRecursoEnum> acoes = emailService.listaAcoesExecutadasRecurso();
        return new ResponseEntity<>(acoes, HttpStatus.OK);
    }

    @RequestMapping(value = "/listaPerfilPorTipoSolicitacao/{tipoSolicitacao}", method = RequestMethod.GET)
    public ResponseEntity listaPerfilPorTipoSolicitacao(@PathVariable Integer tipoSolicitacao) {
        List<PerfilAcessoEnum> perfilAcessoEnums = emailService.listaPerfilPorTipoSolicitacao(tipoSolicitacao);
        return new ResponseEntity<>(perfilAcessoEnums, HttpStatus.OK);
    }

    @RequestMapping(value = "/deletarEmail/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deletarEmail(@PathVariable Long id) {
        emailService.deletarEmail(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value="/buscaPorId/{id}", method=RequestMethod.GET)
    public ResponseEntity buscaPorId(@PathVariable Long id) {
        EmailDTO emailDTO = emailService.buscaEmailPorId(id);
        return new ResponseEntity<>(emailDTO, HttpStatus.OK);
    }

    @RequestMapping(value="/listarAssunto", method=RequestMethod.GET)
    public ResponseEntity<List<String>> listarAssunto() {
        List<String> assuntoList = emailService.obterAssunto();
        return new ResponseEntity<>(assuntoList, HttpStatus.OK);
    }

    @RequestMapping(value="/listar", method=RequestMethod.GET)
    public ResponseEntity<List<EmailDTO>> listarEmail(@RequestParam(value="filtro") String filtro) {
        ResponseEntity responseEntity;
        try {
            EmailFiltroDTO emailFiltroDTO = ControllerUtil.montarFiltroDTO(filtro, EmailFiltroDTO.class);
            responseEntity = new ResponseEntity<>(emailService.obterEmailDataBase(emailFiltroDTO), HttpStatus.OK);
        }
        catch (ObjectMapperException e) {
            LOGGER.error("ERRO AO LISTAR EMAIL", e);
            String errorMessage = ControllerUtil.criarObjetoJson(ERROR_MESSAGE, e.getMessage());
            responseEntity = new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @RequestMapping(value="/salvar", method = RequestMethod.POST)
    public ResponseEntity salvar(@RequestBody EmailDTO emailDTO) {
        ResponseEntity responseEntity;
        try {
            emailService.salvar(emailDTO);
            responseEntity = new ResponseEntity<>(HttpStatus.OK);
        } catch (DataAccessException e) {
            LOGGER.error("ERRO AO SALVAR EMAIL", e);
            String errorMessage = ControllerUtil.criarObjetoJson(ERROR_MESSAGE, e.getMessage());
            responseEntity = new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }
}
