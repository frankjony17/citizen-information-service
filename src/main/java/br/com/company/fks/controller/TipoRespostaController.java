package br.com.company.fks.controller;

import br.com.company.fks.controller.builder.Resposta;
import br.com.company.fks.controller.builder.RespostaBuilder;
import br.com.company.fks.modelo.TipoResposta;
import br.com.company.fks.modelo.dto.TipoRespostaDTO;
import br.com.company.fks.servico.TipoRespostaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/tipoResposta", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class TipoRespostaController {

    @Autowired
    private TipoRespostaService tipoRespostaService;

    @RequestMapping(value = "", method = {RequestMethod.GET})
    public ResponseEntity<Resposta<List<TipoRespostaDTO>>> buscaTodosTipoResposta() {
        List<TipoResposta> listaTipoResposta = tipoRespostaService.buscarTodasDescricaoTipoResposta();
        Resposta<List<TipoRespostaDTO>> resposta = RespostaBuilder.getBuilder().setResultado(listaTipoResposta).build();
        return new ResponseEntity<>(resposta, HttpStatus.OK);
    }

}
