package br.com.company.fks.controller;

import br.com.company.fks.modelo.dto.RespostaRecursoDTO;
import br.com.company.fks.servico.RespostaRecursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/respostaRecurso")
public class RespostaRecursoController {
    @Autowired
    private RespostaRecursoService respostaRecursoService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<HttpStatus> enviar(@RequestBody RespostaRecursoDTO respostaRecursoDTO) {
        respostaRecursoService.enviar(respostaRecursoDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/verificarAndamento/{idRecurso}", method = RequestMethod.GET)
    public ResponseEntity<?> verificarAndamentoRecurso(@PathVariable Long idRecurso){
       Long idSolicitacao =  respostaRecursoService.verificarAndamentoRecurso(idRecurso);
       return new ResponseEntity<>(idSolicitacao,HttpStatus.OK);
    }
}
