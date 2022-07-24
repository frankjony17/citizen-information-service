package br.com.company.fks.controller;

import br.com.company.fks.modelo.dto.StatusTramitacaoDTO;
import br.com.company.fks.servico.StatusTramitacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/statusTramitacao", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class StatusTramitacaoController {

    @Autowired
    private StatusTramitacaoService statusTramitacaoService;

    @RequestMapping(method = RequestMethod.GET, value = "")
    public ResponseEntity<List<StatusTramitacaoDTO>> consultaStatusTramitacao() {
        List<StatusTramitacaoDTO> listaStatusTramitacaoDTO = statusTramitacaoService.consultarStatusTramitacao();
        return new ResponseEntity<>(listaStatusTramitacaoDTO, HttpStatus.OK);
    }
}
