package br.com.company.fks.controller;


import br.com.company.fks.controller.builder.Resposta;
import br.com.company.fks.controller.builder.RespostaBuilder;
import br.com.company.fks.excecao.IntegracaoException;
import br.com.company.fks.excecao.ObjectMapperException;
import br.com.company.fks.modelo.Feriado;
import br.com.company.fks.modelo.dto.FeriadoDTO;
import br.com.company.fks.modelo.dto.ConsultaFeriadoDTO;
import br.com.company.fks.servico.FeriadoService;
import br.com.company.fks.utils.ControllerUtil;
import br.com.company.fks.utils.EntityConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "feriado", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class FeriadoController {


    private static final org.apache.log4j.Logger LOGGER = org.apache.log4j.Logger.getLogger(FeriadoService.class);
    @Autowired
    private FeriadoService feriadoService;
    @Autowired
    private EntityConverter entityConverter;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<?> salvar(@RequestBody FeriadoDTO feriadoDTO) {
        ResponseEntity responseEntity;
        try {
            Feriado feriado = entityConverter.converterStrict(feriadoDTO, Feriado.class);
            feriadoService.salvar(feriado);
            responseEntity = new ResponseEntity<>(HttpStatus.OK);
        } catch (IntegracaoException ie) {
            Resposta resposta = RespostaBuilder.getBuilder().setErro(ie.getMessage()).build();
            responseEntity = new ResponseEntity<>(resposta, HttpStatus.INTERNAL_SERVER_ERROR);
            LOGGER.error("ERRO AO SALVAR FERIADO", ie);
        }
        return responseEntity;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<FeriadoDTO>> consultarFeriado(@RequestParam(value = "consultar") String consultar) {
        ResponseEntity responseEntity;
        try {
            ConsultaFeriadoDTO consultaFeriadoDTO = ControllerUtil.montarFiltroDTO(consultar, ConsultaFeriadoDTO.class);
            responseEntity = new ResponseEntity<>(feriadoService.consultarFeriado(consultaFeriadoDTO), HttpStatus.OK);
        } catch (IntegracaoException ie) {
            Resposta<List<FeriadoDTO>> resposta = RespostaBuilder.getBuilder().setErro(ie.getMessage()).build();
            responseEntity = new ResponseEntity<>(resposta, HttpStatus.INTERNAL_SERVER_ERROR);
            LOGGER.error("ERRO AO CONSULTAR FERIADO", ie);
        } catch (ObjectMapperException ome) {
            Resposta<List<FeriadoDTO>> resposta = RespostaBuilder.getBuilder().setErro(ome.getMessage()).build();
            responseEntity = new ResponseEntity<>(resposta, HttpStatus.BAD_REQUEST);
            LOGGER.error("ERRO AO CONSULTAR FERIADO", ome);
        }
        return responseEntity;
    }

    @RequestMapping(value = "editarFeriado/{id}", method = RequestMethod.GET)
    public ResponseEntity<ConsultaFeriadoDTO> buscarFeriado(@PathVariable Long id) {
        FeriadoDTO feriadoDTO = feriadoService.buscarFeriado(id);
        return new ResponseEntity(feriadoDTO, HttpStatus.OK);
    }

    @RequestMapping(value = "deletarFeriado/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deletarFeriado(@PathVariable Long id) {
        feriadoService.deletarFeriado(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "editarFeriadoFKS", method = RequestMethod.POST)
    public ResponseEntity<?> editarFeriadoFKS(@RequestBody FeriadoDTO feriadoDTO) {
        ResponseEntity responseEntity;
        try {
            Feriado feriado = entityConverter.converterStrict(feriadoDTO, Feriado.class);
            feriadoService.editarFeriadoFKS(feriado);
            responseEntity = new ResponseEntity<>(HttpStatus.OK);
        } catch (IntegracaoException ie) {
            Resposta resposta = RespostaBuilder.getBuilder().setErro(ie.getMessage()).build();
            responseEntity = new ResponseEntity<>(resposta, HttpStatus.INTERNAL_SERVER_ERROR);
            LOGGER.error("ERRO AO EDITAR FERIADO", ie);
        }
        return responseEntity;
    }
}
