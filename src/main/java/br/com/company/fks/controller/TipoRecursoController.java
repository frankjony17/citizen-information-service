package br.com.company.fks.controller;

import br.com.company.fks.modelo.dto.TipoRecursoDTO;
import br.com.company.fks.servico.TipoRecursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/tipoRecurso", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class TipoRecursoController {

    @Autowired
    private TipoRecursoService tipoRecursoService;

    @RequestMapping(method = RequestMethod.GET, value = "")
    public ResponseEntity<List<TipoRecursoDTO>> consultaTipoRecurso() {
        List<TipoRecursoDTO> listaTipoRecursoDTO = tipoRecursoService.consultaTipoRecurso();
        return new ResponseEntity<>(listaTipoRecursoDTO, HttpStatus.OK);
    }

}
