package br.com.company.fks.controller;

import br.com.company.fks.modelo.dto.SituacaoRecursoDTO;
import br.com.company.fks.servico.SituacaoRecursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/situacaoRecurso", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class SituacaoRecursoController {

    @Autowired
    private SituacaoRecursoService situacaoRecursoService;

    @RequestMapping(method = RequestMethod.GET, value = "")
    public ResponseEntity<List<SituacaoRecursoDTO>> consultaSituacaoRecurso() {
        return new ResponseEntity<>(situacaoRecursoService.consultaSituacaoRecurso(), HttpStatus.OK);
    }

}
