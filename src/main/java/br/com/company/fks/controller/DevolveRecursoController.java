package br.com.company.fks.controller;

import br.com.company.fks.excecao.IntegracaoException;
import br.com.company.fks.modelo.Recurso;
import br.com.company.fks.modelo.dto.DevolveRecursoDTO;
import br.com.company.fks.servico.DevolveRecursoService;
import br.com.company.fks.servico.RecursoService;
import br.com.company.fks.utils.ControllerUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/devolveRecurso")
public class DevolveRecursoController {

    private static final Logger LOGGER = Logger.getLogger(RecursoService.class);

    @Autowired
    private DevolveRecursoService devolveRecursoService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<Recurso> devolver(@RequestBody DevolveRecursoDTO devolveRecursoDTO) {
        ResponseEntity responseEntity;
        try {
            devolveRecursoService.reverterAndamentoRecurso(devolveRecursoDTO);
            responseEntity = new ResponseEntity<>(HttpStatus.OK);
        } catch (IntegracaoException ie) {
            LOGGER.error("ERRO DEVOLVER DEVOLVER RECURSO", ie);

            String errorMessage = ControllerUtil.criarObjetoJson("errorMessage", ie.getMessage());
            responseEntity = new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @RequestMapping(value = "/consultarStatusRecurso/{idRecurso}", method = RequestMethod.GET)
    public ResponseEntity<DevolveRecursoDTO> consultarStatusRecurso(@PathVariable Long idRecurso) {
        ResponseEntity responseEntity;
        DevolveRecursoDTO devolveRecursoDTO = devolveRecursoService.consultarStatusRecurso(idRecurso);
        responseEntity = new ResponseEntity<>(devolveRecursoDTO, HttpStatus.OK);
        return responseEntity;
    }
}
