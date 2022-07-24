package br.com.company.fks.controller;

import br.com.company.fks.modelo.dto.AndamentoRecursoDTO;
import br.com.company.fks.servico.AndamentoRecursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/andamentoRecurso", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class AndamentoRecursoController {

    @Autowired
    private AndamentoRecursoService andamentoRecursoService;

    @RequestMapping(value = "/consultarAndamentoRecurso", method = RequestMethod.GET)
    public ResponseEntity<?> consultarAndamentoRecurso(@RequestParam(value = "id", required = true) Long id,
                                                       @RequestParam(value = "offset", required = true) Integer offset,
                                                       @RequestParam(value = "limit", required = true) Integer limit) {
        Page<AndamentoRecursoDTO> listaAndamentoRecursoDTO = andamentoRecursoService.consultarAndamentoRecurso(id, offset, limit);
        return new ResponseEntity<>(listaAndamentoRecursoDTO, HttpStatus.OK);
    }

    @RequestMapping(value = "/buscarUsuario/{id}", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<?> buscarUsuario(@PathVariable Long id){
       String nomeUsuario = andamentoRecursoService.buscarUsuario(id);
        return new ResponseEntity<>(nomeUsuario,HttpStatus.OK);
    }
}
