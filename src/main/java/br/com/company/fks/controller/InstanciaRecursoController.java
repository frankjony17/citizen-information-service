package br.com.company.fks.controller;

import br.com.company.fks.modelo.dto.InstanciaRecursoDTO;
import br.com.company.fks.servico.InstanciaRecursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/instanciaRecurso", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class InstanciaRecursoController {

    @Autowired
    private InstanciaRecursoService instanciaRecursoService;

    @RequestMapping(method = RequestMethod.GET, value = "")
    public ResponseEntity<List<InstanciaRecursoDTO>> consultaInstanciaRecurso() {
        List<InstanciaRecursoDTO> listaInstanciaRecursoDTO = instanciaRecursoService.consultaInstanciaRecurso();
        return new ResponseEntity<>(listaInstanciaRecursoDTO, HttpStatus.OK);
    }

}
