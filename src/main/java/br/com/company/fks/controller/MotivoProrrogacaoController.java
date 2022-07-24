package br.com.company.fks.controller;

import br.com.company.fks.modelo.dto.MotivoProrrogacaoDTO;
import br.com.company.fks.servico.MotivoProrrogacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/motivoProrrogacao", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class MotivoProrrogacaoController {

    @Autowired
    private MotivoProrrogacaoService motivoProrrogacaoService;

    @RequestMapping(method = RequestMethod.GET, value = "")
    public ResponseEntity<List<MotivoProrrogacaoDTO>> consultaMotivoProrrogacao() {
        List<MotivoProrrogacaoDTO> listaMotivoProrrogacaoDTO = motivoProrrogacaoService.consultarMotivoProrrogacao();
        return new ResponseEntity<>(listaMotivoProrrogacaoDTO, HttpStatus.OK);
    }
}
