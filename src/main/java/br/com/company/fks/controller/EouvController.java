package br.com.company.fks.controller;

import br.com.company.fks.excecao.IntegracaoException;
import br.com.company.fks.modelo.PalavraChave;
import br.com.company.fks.modelo.dto.EouvDTO;
import br.com.company.fks.servico.EouvService;
import br.com.company.fks.servico.PedidoService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(value = "eouv", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class EouvController {

    private static final Logger LOGGER = Logger.getLogger(PedidoService.class);

    @Autowired
    private EouvService eouvService;

    @Autowired
    private PedidoService pedidoService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<?> salvar(@RequestBody EouvDTO eouvDTO) {
        eouvService.salvar(eouvDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/finalizarEouv/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> finalizarEouv(@PathVariable Long id) {
        try {
            pedidoService.alterarStatusFinalizarEouv(id);
        } catch (IntegracaoException e) {
            LOGGER.error("ERRO AO FINALIZAR E-OUV", e);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/buscarPalavraChavePedido/{idPedido}", method = RequestMethod.GET)
    public ResponseEntity<List<PalavraChave>> buscarPalavraChavePedido(@PathVariable Long idPedido) {
        return new ResponseEntity<>(eouvService.buscarPalavraChavePedido(idPedido), HttpStatus.OK);
    }

    @RequestMapping(value = "/validarEouv/{idPedido}", method = RequestMethod.POST)
    public ResponseEntity<?> validarEouv(@PathVariable Long idPedido ){
        eouvService.validarEouv(idPedido);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
