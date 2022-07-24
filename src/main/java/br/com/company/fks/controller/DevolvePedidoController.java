package br.com.company.fks.controller;

import br.com.company.fks.controller.builder.Resposta;
import br.com.company.fks.excecao.IntegracaoException;
import br.com.company.fks.modelo.Pedido;
import br.com.company.fks.modelo.dto.DevolvePedidoDTO;
import br.com.company.fks.servico.PedidoService;
import br.com.company.fks.utils.ControllerUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/devolvePedido")
public class DevolvePedidoController {

    private static final Logger LOGGER = Logger.getLogger(PedidoService.class);

    @Autowired
    private PedidoService pedidoService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<Resposta<Pedido>> devolver(@RequestBody DevolvePedidoDTO devolvePedidoDTO) {
        ResponseEntity responseEntity;
        try {
            pedidoService.reverterAndamentoPedido(devolvePedidoDTO);
            responseEntity = new ResponseEntity<>(HttpStatus.OK);
        } catch (IntegracaoException ie) {
            LOGGER.error("ERRO DEVOLVER PEDIDO DE INFORMACAO", ie);

            String errorMessage = ControllerUtil.criarObjetoJson("errorMessage", ie.getMessage());
            responseEntity = new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @RequestMapping(value = "/consultarStatusRecurso/{idPedido}", method = RequestMethod.GET)
    public ResponseEntity<DevolvePedidoDTO> consultarStatusRecurso(@PathVariable Long idPedido) {
        ResponseEntity responseEntity;
        DevolvePedidoDTO devolvePedidoDTO = pedidoService.consultarStatusRecurso(idPedido);
        responseEntity = new ResponseEntity<>(devolvePedidoDTO, HttpStatus.OK);
        return responseEntity;
    }


}
