package br.com.company.fks.controller;

import br.com.company.fks.modelo.dto.StatusSituacaoDTO;
import br.com.company.fks.servico.StatusSituacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/statusSituacao", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class StatusSituacaoController {

    @Autowired
    private StatusSituacaoService statusSituacaoService;

    @RequestMapping(method = RequestMethod.GET, value = "")
    public ResponseEntity<List<StatusSituacaoDTO>> consultaStatusTramitacao() {
        return new ResponseEntity<>(statusSituacaoService.consultarStatusSituacao(), HttpStatus.OK);
    }
}
