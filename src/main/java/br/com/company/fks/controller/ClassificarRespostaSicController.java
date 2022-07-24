package br.com.company.fks.controller;

import br.com.company.fks.controller.builder.Resposta;
import br.com.company.fks.controller.builder.RespostaBuilder;
import br.com.company.fks.excecao.IntegracaoException;
import br.com.company.fks.modelo.ClassificarRespostaSic;
import br.com.company.fks.modelo.dto.ClassificarRespostaSicDTO;
import br.com.company.fks.modelo.dto.RespostaDTO;
import br.com.company.fks.servico.ClassificarRespostaSicService;
import br.com.company.fks.servico.PedidoService;
import br.com.company.fks.utils.EntityConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/classificarRespostaSic", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class ClassificarRespostaSicController {

    private static final org.apache.log4j.Logger LOGGER = org.apache.log4j.Logger.getLogger(ClassificarRespostaSicService.class);

    @Autowired
    private ClassificarRespostaSicService classificarRespostaSicService;

    @Autowired
    private EntityConverter entityConverter;

    @Autowired
    private PedidoService pedidoService;

    @RequestMapping(value = "/salvar", method = RequestMethod.POST)
    public ResponseEntity<?> salvarClassificarRespostaSic(@RequestBody ClassificarRespostaSicDTO classificarRespostaSicDTO) {
        classificarRespostaSicService.salvar(classificarRespostaSicDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/buscarRespostaEsic/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> buscarResposta(@PathVariable Long id) {
        RespostaDTO respostaDTO = classificarRespostaSicService.buscarResposta(id);
        return new ResponseEntity(respostaDTO, HttpStatus.OK);
    }

    @RequestMapping(value = "buscarClassificacao/{id}", method = RequestMethod.GET)
    public ResponseEntity buscar(@PathVariable Long idPedido) {
        return new ResponseEntity<>(classificarRespostaSicService.buscarClassificacaoRespostaSic(idPedido), HttpStatus.OK);
    }

    @RequestMapping(value = "/editarClassificacaoRespostaSic", method = RequestMethod.POST)
    public ResponseEntity<?> editar(@RequestBody ClassificarRespostaSicDTO classificacaoRespostaDTO) {
        ResponseEntity responseEntity;
        try {
            ClassificarRespostaSic classificarRespostaSic = entityConverter.converterStrict(classificacaoRespostaDTO, ClassificarRespostaSic.class);
            classificarRespostaSicService.editarClassificacaoSic(classificarRespostaSic);
            responseEntity = new ResponseEntity<>(HttpStatus.OK);
        } catch (IntegracaoException ie) {
            Resposta resposta = RespostaBuilder.getBuilder().setErro(ie.getMessage()).build();
            responseEntity = new ResponseEntity<>(resposta, HttpStatus.INTERNAL_SERVER_ERROR);
            LOGGER.error("ERRO AO EDITAR CLASSIFICAÇÃO RESPOSTA SIC", ie);
        }
        return responseEntity;
    }

    @RequestMapping(value = "/verificaSePossuiClassificacaoRespostaESic/{id}", method = RequestMethod.GET)
    public ResponseEntity verificaSePossuiClassificacaoRespostaESic(@PathVariable Long id) {
        return new ResponseEntity<>(pedidoService.verificaSePossuiClassificacaoRespostaESic(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/buscarClassificacaoRespostaESic/{id}", method = RequestMethod.GET)
    public ResponseEntity<ClassificarRespostaSic> buscarClassificacaoRespostaESic(@PathVariable Long id) {
        return new ResponseEntity<>(classificarRespostaSicService.buscarClassificacaoRespostaESic(id), HttpStatus.OK);
    }
}
