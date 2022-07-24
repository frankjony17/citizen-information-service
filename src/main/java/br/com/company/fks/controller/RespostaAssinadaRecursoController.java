package br.com.company.fks.controller;

import br.com.company.fks.excecao.IntegracaoException;
import br.com.company.fks.modelo.dto.RespostaDTO;
import br.com.company.fks.modelo.dto.RespostaAssinadaRecursoDTO;
import br.com.company.fks.servico.RespostaAssinadaRecursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/respostaAssinadaRecurso")
public class RespostaAssinadaRecursoController {

    private static final org.apache.log4j.Logger LOGGER = org.apache.log4j.Logger.getLogger(RespostaAssinadaRecursoService.class);

    @Autowired
    private RespostaAssinadaRecursoService respostaAssinadaRecursoService;

    @RequestMapping(value = "/buscarRespostaRecurso/{id}", method = RequestMethod.GET)
    public ResponseEntity<RespostaDTO> buscarRespostaRecurso(@PathVariable Long id) {
        RespostaDTO respostaDTO = respostaAssinadaRecursoService.buscarRespostaRecurso(id);
        return new ResponseEntity(respostaDTO, HttpStatus.OK);
    }

    @RequestMapping(value = "/salvarRespostaRecurso", method = RequestMethod.POST)
    public ResponseEntity<?> salvarRespostaRecurso(@RequestBody RespostaAssinadaRecursoDTO respostaAssinadaRecursoDTO) {
        try {
            respostaAssinadaRecursoService.salvarRespostaRecurso(respostaAssinadaRecursoDTO);
        } catch (IntegracaoException e) {
            LOGGER.error("ERRO AO SALVAR", e);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
