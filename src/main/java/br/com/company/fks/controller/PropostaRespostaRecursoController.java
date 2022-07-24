package br.com.company.fks.controller;

import br.com.company.fks.excecao.IntegracaoException;
import br.com.company.fks.modelo.dto.PropostaRespostaRecursoDTO;
import br.com.company.fks.modelo.dto.RespostaDTO;
import br.com.company.fks.servico.HistoricoTratamentoRecursoService;
import br.com.company.fks.servico.PropostaRespostaRecursoService;
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
@RequestMapping(value = "/propostaRespostaRecurso")
public class PropostaRespostaRecursoController {

    private static final Logger LOGGER = Logger.getLogger(PropostaRespostaRecursoService.class);

    @Autowired
    private PropostaRespostaRecursoService propostaRespostaRecursoService;

    @Autowired
    private HistoricoTratamentoRecursoService historicoTratamentoRecursoService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<?> enviar(@RequestBody PropostaRespostaRecursoDTO propostaRespostaRecursoDTO) {
        ResponseEntity responseEntity;
        try {
            propostaRespostaRecursoService.enviar(propostaRespostaRecursoDTO);
            responseEntity = new ResponseEntity<>(HttpStatus.OK);
        } catch (IntegracaoException ie) {
            LOGGER.error("ERRO ENVIAR PROPOSTA RESPOSTA RECURSO", ie);
            String errorMessage = ControllerUtil.criarObjetoJson("errorMessage", ie.getMessage());
            responseEntity = new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @RequestMapping(value = "/excluirRespostaRecurso/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> excluirRespostaFKS(@PathVariable Long id) {
        propostaRespostaRecursoService.excluirRespostaRecurso(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/salvar", method = RequestMethod.POST)
    public ResponseEntity<?> salvar(@RequestBody PropostaRespostaRecursoDTO propostaRespostaRecursoDTO) {
        try {
            propostaRespostaRecursoService.salvar(propostaRespostaRecursoDTO);
        } catch (IntegracaoException e) {
            LOGGER.error("ERRO AO SALVAR", e);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/buscarRespostaRecurso/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> buscarResposta(@PathVariable Long id) {
        String resposta = historicoTratamentoRecursoService.recuperarRespostaRecurso(id);
        RespostaDTO respostaDTO = new RespostaDTO();
        respostaDTO.setResposta(resposta);
        return new ResponseEntity(respostaDTO, HttpStatus.OK);
    }
    @RequestMapping(value = "/buscarInstanciaRecurso/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> buscainstancia(@PathVariable Long id){
        Long instancia = propostaRespostaRecursoService.buscarinstancia(id);
        return new ResponseEntity<>(instancia, HttpStatus.OK);
    }


}
