package br.com.company.fks.controller;

import br.com.company.fks.modelo.dto.StatusSolicitacaoRecursoDTO;
import br.com.company.fks.servico.StatusSolicitacaoRecursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/statusSolicitacaoRecurso", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class StatusSolicitacaoRecursoController {

    @Autowired
    private StatusSolicitacaoRecursoService statusSolicitacaoRecursoService;

    @RequestMapping(method = RequestMethod.GET, value = "")
    public ResponseEntity<List<StatusSolicitacaoRecursoDTO>> consultaStatusSolicitacao() {
        List<StatusSolicitacaoRecursoDTO> listaStatusSolicitacaoRecursoDTO = statusSolicitacaoRecursoService.consultarStatusSolicitacao();
        return new ResponseEntity<>(listaStatusSolicitacaoRecursoDTO, HttpStatus.OK);
    }
}
