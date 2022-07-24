package br.com.company.fks.controller;

import br.com.company.fks.excecao.IntegracaoException;
import br.com.company.fks.modelo.dto.ProrrogacaoCadastroDTO;
import br.com.company.fks.servico.ProrrogacaoService;
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


@RestController
@RequestMapping(value = "prorrogacao", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class ProrrogacaoController {

    private static final Logger LOGGER = Logger.getLogger(ProrrogacaoService.class);

    @Autowired
    private ProrrogacaoService prorrogacaoService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<?> salvar(@RequestBody ProrrogacaoCadastroDTO prorrogacaoCadastroDTO) {
        try {
            prorrogacaoService.criarProrrogacao(prorrogacaoCadastroDTO);
        } catch (IntegracaoException e) {
            LOGGER.error("ERRO AO SALVAR", e);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<ProrrogacaoCadastroDTO> consultarProrrogacao(@PathVariable Long id) {
        ProrrogacaoCadastroDTO prorrogacaoCadastroDTO = prorrogacaoService.consultarProrrogacao(id);
        return new ResponseEntity<>(prorrogacaoCadastroDTO, HttpStatus.OK);
    }

    @RequestMapping(value = "/consultarProrrogacaoEsic/{id}", method = RequestMethod.GET)
    public ResponseEntity<ProrrogacaoCadastroDTO> consultarProrrogacaoEsic(@PathVariable Long id) {
        ProrrogacaoCadastroDTO prorrogacaoCadastroDTO = prorrogacaoService.consultarProrrogacaoEsic(id);
        return new ResponseEntity<>(prorrogacaoCadastroDTO, HttpStatus.OK);
    }
}
