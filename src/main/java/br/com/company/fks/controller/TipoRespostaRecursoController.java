package br.com.company.fks.controller;

import br.com.company.fks.modelo.dto.TipoRespostaRecursoDTO;
import br.com.company.fks.servico.TipoRespostaRecursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/tipoRespostaRecurso", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class TipoRespostaRecursoController {

    @Autowired
    private TipoRespostaRecursoService tipoRespostaRecursoService;

    @RequestMapping(method = RequestMethod.GET, value = "")
    public ResponseEntity<List<TipoRespostaRecursoDTO>> consultaTipoRespostaRecurso() {
        List<TipoRespostaRecursoDTO> listaTipoRespostaRecursoDTO = tipoRespostaRecursoService.consultaTipoRespostaRecurso();
        return new ResponseEntity<>(listaTipoRespostaRecursoDTO, HttpStatus.OK);
    }

}
