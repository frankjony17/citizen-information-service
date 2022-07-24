package br.com.company.fks.controller;

import br.com.company.fks.controller.builder.Resposta;
import br.com.company.fks.controller.builder.RespostaBuilder;
import br.com.company.fks.excecao.IntegracaoException;
import br.com.company.fks.excecao.ObjectMapperException;
import br.com.company.fks.modelo.dto.ConsultaPedidoDTO;
import br.com.company.fks.modelo.dto.ConsultaRecursoDTO;
import br.com.company.fks.modelo.dto.FiltroRecursoDTO;
import br.com.company.fks.modelo.dto.RecursoDetalhadoDTO;
import br.com.company.fks.modelo.dto.StatusSolicitacaoRecursoDTO;
import br.com.company.fks.servico.PedidoService;
import br.com.company.fks.servico.RecursoService;
import br.com.company.fks.utils.ControllerUtil;
import org.apache.commons.codec.binary.Base64;
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

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "/recurso", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class RecursoController {

    private static final String ERRO_EXPORTAR_CONSULTA_RECURSO = "ERRO EXPORTAR CONSULTA RECURSO";

    private static final Logger LOGGER = Logger.getLogger(PedidoService.class);

    @Autowired
    private RecursoService recursoService;

    @RequestMapping(value = "/{idPedido}/{instanciaRecurso}", method = RequestMethod.GET)
    public ResponseEntity<RecursoDetalhadoDTO> detalharRecurso(@PathVariable("idPedido") Long idPedido,
                                                               @PathVariable("instanciaRecurso") String instanciaRecurso) {
        RecursoDetalhadoDTO recursoDetalhadoDTO = recursoService.detalharRecurso(idPedido, instanciaRecurso);
        return new ResponseEntity<>(recursoDetalhadoDTO, HttpStatus.OK);
    }

    @RequestMapping(value = "buscarStatusSolicitacaoPorRecurso/{id}", method = RequestMethod.GET)
    public ResponseEntity<StatusSolicitacaoRecursoDTO> buscarStratusSolicitacao(@PathVariable Long id) {
        StatusSolicitacaoRecursoDTO statusSolicitacaoRecursoDTO = recursoService.buscarStatusSolicitacaoRecurso(id);
        return new ResponseEntity<>(statusSolicitacaoRecursoDTO, HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<Resposta<List<ConsultaRecursoDTO>>> consultarRecurso(@RequestParam(value = "filtro") String filtro) {
        ResponseEntity responseEntity;
        try {
            FiltroRecursoDTO filtroRecursoDTO = ControllerUtil.montarFiltroDTO(filtro, FiltroRecursoDTO.class);
            responseEntity = new ResponseEntity<>(recursoService.consultarRecurso(filtroRecursoDTO), HttpStatus.OK);
        } catch (IntegracaoException ie) {
            LOGGER.error("ERRO CONSULTA RECURSO", ie);
            Resposta<List<ConsultaPedidoDTO>> resposta = RespostaBuilder.getBuilder().setErro(ie.getMessage()).build();
            responseEntity = new ResponseEntity<>(resposta, HttpStatus.INTERNAL_SERVER_ERROR);

        } catch (ObjectMapperException ome) {
            LOGGER.error("ERRO CONSULTA RECURSO", ome);
            Resposta<List<ConsultaPedidoDTO>> resposta = RespostaBuilder.getBuilder().setErro(ome.getMessage()).build();
            responseEntity = new ResponseEntity<>(resposta, HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }

    @RequestMapping(value = "/exportar", method = RequestMethod.GET)
    public ResponseEntity<byte[]> exportarConsultaRecurso(@RequestParam(value = "filtro") String filtro) {
        ResponseEntity responseEntity;
        try {
            FiltroRecursoDTO filtroRecursoDTO = ControllerUtil.montarFiltroDTO(filtro, FiltroRecursoDTO.class);
            byte[] bytes = recursoService.exportarConsultaRecurso(filtroRecursoDTO);
            String arquivoBase64 = new Base64().encodeAsString(bytes);
            responseEntity = new ResponseEntity<>(ControllerUtil.criarObjetoJson("arquivoBase64", arquivoBase64), HttpStatus.OK);
        } catch (IntegracaoException ie) {
            LOGGER.error(ERRO_EXPORTAR_CONSULTA_RECURSO, ie);
            Resposta<List<ConsultaRecursoDTO>> resposta = RespostaBuilder.getBuilder().setErro(ie.getMessage()).build();
            responseEntity = new ResponseEntity<>(resposta, HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (ObjectMapperException ome) {
            LOGGER.error(ERRO_EXPORTAR_CONSULTA_RECURSO, ome);
            responseEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (IOException ioe) {
            LOGGER.error(ERRO_EXPORTAR_CONSULTA_RECURSO, ioe);
            responseEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }

    @RequestMapping(value = "buscarIdPedido/{idRecurso}", method = RequestMethod.GET)
    public ResponseEntity<?> buscarIdPedido(@PathVariable Long idRecurso) {
        Long idPedido = recursoService.buscarIdPedido(idRecurso);
        return new ResponseEntity<>(idPedido, HttpStatus.OK);
    }

    @RequestMapping(value = "consultarStatusRespostaAssinada/{idRecurso}", method = RequestMethod.GET)
    public ResponseEntity<Boolean> consultarStatusRespostaAssinada(@PathVariable Long idRecurso) {
        Boolean statusRespostaAssinada = recursoService.consultarStatusRespostaAssinada(idRecurso);
        return new ResponseEntity<>(statusRespostaAssinada, HttpStatus.OK);
    }


}
