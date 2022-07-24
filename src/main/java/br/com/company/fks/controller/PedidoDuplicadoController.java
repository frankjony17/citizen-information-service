package br.com.company.fks.controller;

import br.com.company.fks.excecao.IntegracaoException;
import br.com.company.fks.modelo.Pedido;
import br.com.company.fks.modelo.dto.ConsultaPedidoDulplicadoDTO;
import br.com.company.fks.servico.PedidoDuplicadoService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "pedidoDuplicado", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class PedidoDuplicadoController {

    private static final Logger LOGGER = Logger.getLogger(PedidoDuplicadoService.class);

    @Autowired
    private PedidoDuplicadoService pedidoDuplicadoService;

    @RequestMapping(value = "/buscarPedidoPeloProtocolo", method = RequestMethod.GET)
    public ResponseEntity<ConsultaPedidoDulplicadoDTO> buscarPedidoPeloProtocolo(@RequestParam(value = "protocolo") String protocolo) {
        return new ResponseEntity<>(pedidoDuplicadoService.buscarPedidoPeloProtocolo(protocolo), HttpStatus.OK);
    }

    @RequestMapping(value = "/vincularPedidoDuplicado", method = RequestMethod.GET)
    public ResponseEntity<Pedido> vincularPedidoDuplicado(@RequestParam(value = "idPedidoDuplicado") Long idPedidoDuplicado,
                                                          @RequestParam(value = "idPedido") Long idPedido) {
        ResponseEntity responseEntity;
        try {
            responseEntity = new ResponseEntity<>(pedidoDuplicadoService.vincularPedidoDuplicado(idPedidoDuplicado, idPedido), HttpStatus.OK);
        } catch (IntegracaoException ie) {
            responseEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            LOGGER.error("ERRO AO CANCELAR", ie);
        }

        return responseEntity;
    }

    @RequestMapping(value = "/buscarPedidoPaiPedidoDuplicado/{idPedido}", method = RequestMethod.GET)
    public ResponseEntity<Pedido> buscarPedidoPeloProtocolo(@PathVariable Long idPedido) {
        return new ResponseEntity<>(pedidoDuplicadoService.buscarPedidoPaiPedidoDuplicado(idPedido), HttpStatus.OK);
    }

    @RequestMapping(value = "/buscarProtocoloPedidoPai/{idPedido}", method = RequestMethod.GET)
    public ResponseEntity<Pedido> buscarProtocoloPedidoPai(@PathVariable Long idPedido) {
        return new ResponseEntity<>(pedidoDuplicadoService.buscarProtocoloPedidoPai(idPedido), HttpStatus.OK);
    }
}
