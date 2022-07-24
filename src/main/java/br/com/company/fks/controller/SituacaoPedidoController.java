package br.com.company.fks.controller;

import br.com.company.fks.modelo.dto.SituacaoPedidoDTO;
import br.com.company.fks.servico.SituacaoPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/situacaoPedido", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class SituacaoPedidoController {

    @Autowired
    private SituacaoPedidoService situacaoPedidoService;

    @RequestMapping(method = RequestMethod.GET, value = "")
    public ResponseEntity<List<SituacaoPedidoDTO>> consultaSituacaoPedido() {
        return new ResponseEntity<>(situacaoPedidoService.consultarSituacaoPedido(), HttpStatus.OK);
    }
}
