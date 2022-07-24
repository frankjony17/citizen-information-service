package br.com.company.fks.controller;

import br.com.company.fks.controller.builder.Resposta;
import br.com.company.fks.controller.builder.RespostaBuilder;
import br.com.company.fks.modelo.ClassificacaoTipoResposta;
import br.com.company.fks.modelo.dto.ClassificacaoTipoRespostaDTO;
import br.com.company.fks.servico.ClassificacaoTipoRespostaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/classificacaoTipoResposta", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class ClassificacaoTipoRespostaController {

    @Autowired
    private ClassificacaoTipoRespostaService classificacaoTipoRespostaService;

    @RequestMapping(value = "buscarTodasClassificacaoTipoResposta", method = {RequestMethod.GET})
    public ResponseEntity<Resposta<List<ClassificacaoTipoRespostaDTO>>> buscarTodasClassificacaoTipoResposta() {
        List<ClassificacaoTipoResposta> listaClassificacaoTipoResposta = classificacaoTipoRespostaService.buscarTodasClassificacaoTipoResposta();
        Resposta<List<ClassificacaoTipoRespostaDTO>> resposta = RespostaBuilder.getBuilder().setResultado(listaClassificacaoTipoResposta).build();
        return new ResponseEntity<>(resposta, HttpStatus.OK);
    }

    @RequestMapping(value = "buscarPorTipoResposta/{id}", method = {RequestMethod.GET})
    public ResponseEntity<Resposta<List<ClassificacaoTipoRespostaDTO>>> buscarPorTipoResposta(@PathVariable("id") Long idTipoResposta) {
        List<ClassificacaoTipoResposta> listaClassificacaoTipoResposta = classificacaoTipoRespostaService.buscarPorTipoResposta(idTipoResposta);
        Resposta<List<ClassificacaoTipoRespostaDTO>> resposta = RespostaBuilder.getBuilder().setResultado(listaClassificacaoTipoResposta).build();
        return new ResponseEntity<>(resposta, HttpStatus.OK);
    }

}
