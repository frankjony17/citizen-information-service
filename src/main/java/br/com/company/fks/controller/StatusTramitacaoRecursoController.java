package br.com.company.fks.controller;

import br.com.company.fks.modelo.dto.StatusTramitacaoRecursoDTO;
import br.com.company.fks.servico.StatusTramitacaoRecursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/statusTramitacaoRecurso", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class StatusTramitacaoRecursoController {

    @Autowired
    private StatusTramitacaoRecursoService statusTramitacaoRecursoService;

    @RequestMapping(method = RequestMethod.GET, value = "")
    public ResponseEntity<List<StatusTramitacaoRecursoDTO>> consultaStatusTramitacao() {
        List<StatusTramitacaoRecursoDTO> listaStatusTramitacaoRecursoDTO = statusTramitacaoRecursoService.consultarStatusTramitacao();
        return new ResponseEntity<>(listaStatusTramitacaoRecursoDTO, HttpStatus.OK);
    }
}
