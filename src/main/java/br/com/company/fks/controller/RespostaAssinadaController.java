package br.com.company.fks.controller;

import br.com.company.fks.controller.builder.Resposta;
import br.com.company.fks.controller.builder.RespostaBuilder;
import br.com.company.fks.excecao.IntegracaoException;
import br.com.company.fks.modelo.Pedido;
import br.com.company.fks.modelo.dto.RespostaAssinadaDTO;
import br.com.company.fks.modelo.dto.RespostaDTO;
import br.com.company.fks.servico.RespostaAssinadaService;
import br.com.company.fks.utils.EntityConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/respostaAssinada")
public class RespostaAssinadaController {

    @Autowired
    private RespostaAssinadaService respostaAssinadaService;

    @Autowired
    private EntityConverter entityConverter;

    private static final org.apache.log4j.Logger LOGGER = org.apache.log4j.Logger.getLogger(RespostaAssinadaController.class);

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<Object> enviar(@RequestBody RespostaAssinadaDTO respostaAssinadaDTO) {
        respostaAssinadaService.enviar(respostaAssinadaDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/salvar", method = RequestMethod.POST)
    public ResponseEntity<Object> salvar(@RequestBody RespostaAssinadaDTO respostaAssinadaDTO){
        respostaAssinadaService.salvar(respostaAssinadaDTO);
        return new ResponseEntity <>(HttpStatus.OK);
    }

    @RequestMapping(value = "/buscarResposta/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> buscarResposta(@PathVariable Long id) {
        RespostaDTO respostaDTO = respostaAssinadaService.buscarResposta(id);
        return new ResponseEntity(respostaDTO, HttpStatus.OK);
    }

    @RequestMapping(value = "editarResposta", method = RequestMethod.POST)
    public ResponseEntity<Object> editarFeriadoFKS(@RequestBody RespostaAssinadaDTO respostaAssinadaDTO) {
        ResponseEntity responseEntity;
        try {
            entityConverter.converterStrict(respostaAssinadaDTO, Pedido.class);
            respostaAssinadaService.editarResposta(respostaAssinadaDTO);
            responseEntity = new ResponseEntity<>(HttpStatus.OK);
        } catch (IntegracaoException ie) {
            Resposta resposta = RespostaBuilder.getBuilder().setErro(ie.getMessage()).build();
            responseEntity = new ResponseEntity<>(resposta, HttpStatus.INTERNAL_SERVER_ERROR);
            LOGGER.error("ERRO AO EDITAR RESPOSTA", ie);
        }
        return responseEntity;
    }

    @RequestMapping(value = "/buscarDadosEncaminhamento/{idPedido}", method = RequestMethod.GET)
    public ResponseEntity<RespostaAssinadaDTO> buscarDadosEncaminhamento(@PathVariable Long idPedido) {
        RespostaAssinadaDTO respostaAssinadaDTO = respostaAssinadaService.buscarDadosEncaminhamento(idPedido);
        return new ResponseEntity(respostaAssinadaDTO, HttpStatus.OK);
    }
}
