package br.com.company.fks.controller;

import br.com.company.fks.controller.builder.Resposta;
import br.com.company.fks.controller.builder.RespostaBuilder;
import br.com.company.fks.modelo.TipoClassificacaoResposta;
import br.com.company.fks.modelo.dto.TipoClassificacaoRespostaDTO;
import br.com.company.fks.servico.TipoClassificacaoRespostaService;
import br.com.company.fks.utils.EntityConverter;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Type;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping(value = "/tipoClassificacaoResposta", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class TipoClassificacaoRespostaController {

    @Autowired
    private EntityConverter entityConverter;

    @Autowired
    private TipoClassificacaoRespostaService tipoClassificacaoRespostaService;

    @RequestMapping(value = "", method = {GET})
    public ResponseEntity<Resposta<List<TipoClassificacaoRespostaDTO>>> buscarTipoClassificacaoResposta() {
        List<TipoClassificacaoResposta> tipoClassificacaoRespostas = tipoClassificacaoRespostaService.buscarTodosTiposClassificacaoResposta();
        Resposta<List<TipoClassificacaoRespostaDTO>> resposta = RespostaBuilder.getBuilder().setResultado(converter(tipoClassificacaoRespostas)).build();
        return new ResponseEntity(resposta, HttpStatus.OK);
    }

    private List<TipoClassificacaoResposta> converter(List<TipoClassificacaoResposta> tipoManifestacao) {
        Type targetListType = new TypeToken<List<TipoClassificacaoResposta>>() {
        }.getType();
        return entityConverter.converterListaStrictLazyLoading(tipoManifestacao, targetListType);
    }


}
