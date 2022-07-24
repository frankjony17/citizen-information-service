package br.com.company.fks.controller;


import br.com.company.fks.controller.builder.Resposta;
import br.com.company.fks.controller.builder.RespostaBuilder;
import br.com.company.fks.excecao.IntegracaoException;
import br.com.company.fks.excecao.ObjectMapperException;
import br.com.company.fks.modelo.ClassificacaoResposta;
import br.com.company.fks.modelo.dto.ClassificacaoRespostaDTO;
import br.com.company.fks.modelo.dto.ConsultaClassificacaoRespostaDTO;
import br.com.company.fks.modelo.dto.RespostaClassificadaDTO;
import br.com.company.fks.modelo.dto.TipoClassificacaoRespostaAllDTO;
import br.com.company.fks.servico.ClassificacaoRespostaService;
import br.com.company.fks.servico.PedidoService;
import br.com.company.fks.utils.ControllerUtil;
import br.com.company.fks.utils.EntityConverter;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;


@RestController
@RequestMapping(value = "/classificacaoResposta", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class ClassificacaoRespostaController {

    private static final org.apache.log4j.Logger LOGGER = org.apache.log4j.Logger.getLogger(ClassificacaoRespostaService.class);

    private static final String CLASSIFICACAO_RESPOSTA_UNIQUE = "CLASSIFICACAO_RESPOSTA_UNIQUE";

    private static final String ERRO_EXPORTAR_CONSULTA_CLASSIFICACAO_RESPOSTA = "ERRO_EXPORTAR_CONSULTA_CLASSIFICACAO_RESPOSTA";

    @Autowired
    private ClassificacaoRespostaService classificacaoRespostaService;

    @Autowired
    private EntityConverter entityConverter;

    @Autowired
    private PedidoService pedidoService;

    @RequestMapping(value = "/salvar", method = RequestMethod.POST)
    public ResponseEntity<?> classificar(@RequestBody List<ClassificacaoRespostaDTO> classificacaoRespostaDTO) {
        ResponseEntity responseEntity;
        try {
            classificacaoRespostaService.salvar(classificacaoRespostaDTO);
            responseEntity = new ResponseEntity<>(HttpStatus.OK);
        } catch (DataIntegrityViolationException e) {
            LOGGER.error(CLASSIFICACAO_RESPOSTA_UNIQUE, e);
            String errorMessage = ControllerUtil.criarObjetoJson("errorMessage", CLASSIFICACAO_RESPOSTA_UNIQUE);
            responseEntity = new ResponseEntity<>(errorMessage, HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @RequestMapping(value = "/editar", method = RequestMethod.POST)
    public ResponseEntity<?> editar(@RequestBody ClassificacaoRespostaDTO classificacaoRespostaDTO) {
        ResponseEntity responseEntity;
        try {
            classificacaoRespostaService.editar(classificacaoRespostaDTO);
            responseEntity = new ResponseEntity<>(HttpStatus.OK);
        } catch (DataIntegrityViolationException e) {
            LOGGER.error(CLASSIFICACAO_RESPOSTA_UNIQUE, e);
            String errorMessage = ControllerUtil.criarObjetoJson("errorMessage", CLASSIFICACAO_RESPOSTA_UNIQUE);
            responseEntity = new ResponseEntity<>(errorMessage, HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @RequestMapping(value = "buscarClassificacao/{id}", method = RequestMethod.GET)
    public ResponseEntity buscar(@PathVariable Long id) {
        return new ResponseEntity<>(classificacaoRespostaService.buscarClassificacaoResposta(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/deletarClassificacaoResposta/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deletarClassificacaoResposta(@PathVariable Long id) {
        classificacaoRespostaService.excluirClassificacaoResposta(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/consultaClassificacaoResposta", method = RequestMethod.GET)
    public ResponseEntity<Resposta<List<TipoClassificacaoRespostaAllDTO>>> consultarClassificaoResposta(@RequestParam(value = "consultar") String consultar) {
        ResponseEntity responseEntity;
        try {
            ConsultaClassificacaoRespostaDTO consultaClassificacaoRespostaDTO = ControllerUtil.montarFiltroDTO(consultar, ConsultaClassificacaoRespostaDTO.class);
            responseEntity = new ResponseEntity<>(classificacaoRespostaService.consultaClassificacaoResposta(consultaClassificacaoRespostaDTO), HttpStatus.OK);
        } catch (IntegracaoException ie) {
            Resposta<List<ClassificacaoRespostaDTO>> resposta = RespostaBuilder.getBuilder().setErro(ie.getMessage()).build();
            responseEntity = new ResponseEntity<>(resposta, HttpStatus.INTERNAL_SERVER_ERROR);
            LOGGER.error("ERRO AO CONSULTA CLASSIFICACAO RESPOSTA", ie);
        } catch (ObjectMapperException ome) {
            Resposta<List<ClassificacaoRespostaDTO>> resposta = RespostaBuilder.getBuilder().setErro(ome.getMessage()).build();
            responseEntity = new ResponseEntity<>(resposta, HttpStatus.BAD_REQUEST);
            LOGGER.error("ERRO AO CONSULTA CLASSIFICACAO RESPOSTA", ome);
        }
        return responseEntity;
    }

    @RequestMapping(value = "/buscarTodasOrientacaoSolicitante", method = RequestMethod.GET)
    public ResponseEntity<List<ClassificacaoRespostaDTO>> buscarOrientacaoSolicitante() {
        List<ClassificacaoResposta> listaOrientacaoSolicitante = classificacaoRespostaService.buscarTodasOrientacaoSolicitacao();
        Resposta<List<ClassificacaoRespostaDTO>> resposta = RespostaBuilder.getBuilder().setResultado(listaOrientacaoSolicitante).build();
        return new ResponseEntity(resposta, HttpStatus.OK);
    }

    @RequestMapping(value = "/buscarTodasTransparenciaAtiva", method = RequestMethod.GET)
    public ResponseEntity<List<ClassificacaoRespostaDTO>> buscarTransparenciaAtiva() {
        List<ClassificacaoResposta> listaTransparenciaAtiva = classificacaoRespostaService.buscarTodasTransparenciaAtiva();
        Resposta<List<ClassificacaoRespostaDTO>> resposta = RespostaBuilder.getBuilder().setResultado(listaTransparenciaAtiva).build();
        return new ResponseEntity(resposta, HttpStatus.OK);
    }

    @RequestMapping(value = "/buscarTodasTransparenciaPassiva", method = RequestMethod.GET)
    public ResponseEntity<List<ClassificacaoRespostaDTO>> buscarTransparenciaPassiva() {
        List<ClassificacaoResposta> listaTransparenciaPassiva = classificacaoRespostaService.buscarTodasTransparenciaPassiva();
        Resposta<List<ClassificacaoRespostaDTO>> resposta = RespostaBuilder.getBuilder().setResultado(listaTransparenciaPassiva).build();
        return new ResponseEntity(resposta, HttpStatus.OK);
    }

    @RequestMapping(value = "/buscarTodosAcessoNegado", method = RequestMethod.GET)
    public ResponseEntity<List<ClassificacaoRespostaDTO>> buscarAcessoNegado() {
        List<ClassificacaoResposta> listaAcessoNegada = classificacaoRespostaService.buscarTodasAcessoNegado();
        Resposta<List<ClassificacaoRespostaDTO>> resposta = RespostaBuilder.getBuilder().setResultado(listaAcessoNegada).build();
        return new ResponseEntity(resposta, HttpStatus.OK);
    }

    @RequestMapping(value = "/salvarRespostaClassificada", method = RequestMethod.POST)
    public ResponseEntity<?> salvarRespostaClassificada(@RequestBody RespostaClassificadaDTO respostaClassificadaDTO) {
        pedidoService.salvarRespostaClassificada(respostaClassificadaDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "verificaSePossuiClassificacaoResposta/{id}", method = RequestMethod.GET)
    public ResponseEntity verificaSePossuiClassificacaoResposta(@PathVariable Long id) {
        return new ResponseEntity<>(pedidoService.verificaSeRespostaEClassificada(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/buscarClassificacaoResposta/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<ClassificacaoResposta>> buscarClassificacaoResposta(@PathVariable Long id) {
        return new ResponseEntity<>(classificacaoRespostaService.buscarRespostaClassificada(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/ativarDesativar/{id}/{status}", method = RequestMethod.PUT)
    public ResponseEntity<?> ativaDesativaStatusClassificacaoResposta(@PathVariable(value = "id") Long id, @PathVariable(value = "status") boolean status) {
        classificacaoRespostaService.alterarStatusClassificacaoResposta(id, status);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Exportação excel.
     * @param filtro critérios de pesquisa.
     * @return ResponseEntity.
     */
    @RequestMapping(value = "/exportar", method = RequestMethod.GET)
    public ResponseEntity<byte[]> exportarConsultaClassificacaoResposta(@RequestParam(value = "filtro") String filtro) {
        ResponseEntity responseEntity;
        try {
            ConsultaClassificacaoRespostaDTO consultaClassificacaoRespostaDTO = ControllerUtil.montarFiltroDTO(filtro, ConsultaClassificacaoRespostaDTO.class);

            byte[] bytes = classificacaoRespostaService.exportarClassificacaoResposta(consultaClassificacaoRespostaDTO);
            String arquivoBase64 = new Base64().encodeAsString(bytes);
            responseEntity = new ResponseEntity<>(ControllerUtil.criarObjetoJson("arquivoBase64", arquivoBase64), HttpStatus.OK);
        } catch (IntegracaoException ie) {
            LOGGER.error(ERRO_EXPORTAR_CONSULTA_CLASSIFICACAO_RESPOSTA, ie);
            Resposta<List<TipoClassificacaoRespostaAllDTO>> resposta = RespostaBuilder.getBuilder().setErro(ie.getMessage()).build();
            responseEntity = new ResponseEntity<>(resposta, HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (ObjectMapperException ome) {
            LOGGER.error(ERRO_EXPORTAR_CONSULTA_CLASSIFICACAO_RESPOSTA, ome);
            responseEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (IOException ioe) {
            LOGGER.error(ERRO_EXPORTAR_CONSULTA_CLASSIFICACAO_RESPOSTA, ioe);
            responseEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }
}
