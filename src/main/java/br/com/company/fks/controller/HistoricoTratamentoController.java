package br.com.company.fks.controller;

import br.com.company.fks.modelo.HistoricoTratamento;
import br.com.company.fks.servico.HistoricoTratamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/historicoTratamento", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class HistoricoTratamentoController {

    @Autowired
    private HistoricoTratamentoService historicoTratamentoService;

    @RequestMapping(value = "/{id}", method = {RequestMethod.GET})
    public ResponseEntity<HistoricoTratamento> buscarRepostaHistorico(@PathVariable Long id) {
        HistoricoTratamento historicoTratamento = historicoTratamentoService.buscarRespostaHistorico(id);
        return new ResponseEntity<>(historicoTratamento, HttpStatus.OK);
    }

}
