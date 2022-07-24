package br.com.company.fks.controller;

import br.com.company.fks.modelo.dto.ConsultaHistoricoRecursoDTO;
import br.com.company.fks.modelo.dto.RespostaDTO;
import br.com.company.fks.servico.HistoricoTratamentoRecursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;

@RestController
@RequestMapping(value = "/historicoTratamentoRecurso", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class HistoricoTratamentoRecursoController {

    @Autowired
    private HistoricoTratamentoRecursoService historicoTratamentoRecursoService;

    @RequestMapping(value = "/consultarHistoricoRecurso", method = RequestMethod.GET)
    public ResponseEntity<?> consultarHistoricoRecurso(@RequestParam(value = "id", required = true) Long id,
                                                       @RequestParam(value = "offset", required = true) Integer offset,
                                                       @RequestParam(value = "limit", required = true) Integer limit) {
        Page<ConsultaHistoricoRecursoDTO> listaConsultaHistoricoRecursoDTO = historicoTratamentoRecursoService.consultarHistoricoRecurso(id, offset, limit);
        return new ResponseEntity<>(listaConsultaHistoricoRecursoDTO, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = {RequestMethod.GET})
    public ResponseEntity<RespostaDTO> buscarRepostaHistorico(@PathVariable Long id) {
        RespostaDTO respostaDTO = historicoTratamentoRecursoService.buscarRespostaHistorico(id);
        return new ResponseEntity<>(respostaDTO, HttpStatus.OK);
    }

    @RequestMapping(value = "/consultarDataRespostaRecurso/{id}", method = {RequestMethod.GET})
    public ResponseEntity<?> consultarDataRespostaRecurso(@PathVariable Long id) {
        Calendar dataRespostaRecurso = historicoTratamentoRecursoService.consultarDataRespostaRecurso(id);
        return new ResponseEntity<>(dataRespostaRecurso, HttpStatus.OK);
    }
}
