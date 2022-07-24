package br.com.company.fks.controller;

import br.com.company.fks.controller.builder.Resposta;
import br.com.company.fks.controller.builder.RespostaBuilder;
import br.com.company.fks.modelo.TipoManifestacao;
import br.com.company.fks.modelo.dto.TipoManifestacaoDTO;
import br.com.company.fks.servico.TipoManifestacaoService;
import br.com.company.fks.utils.EntityConverter;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Type;
import java.util.List;

@RestController
@RequestMapping(value = "/tipoManifestacao", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class TipoManifestacaoController {

    @Autowired
    private EntityConverter entityConverter;

    @Autowired
    private TipoManifestacaoService tipoManifestacaoService;


    @RequestMapping(value = "", method = {RequestMethod.GET})
    public ResponseEntity<Resposta<List<TipoManifestacaoDTO>>> buscarTodosTipoManifestacao() {
        List<TipoManifestacao> listaTipoManifestacao = tipoManifestacaoService.buscaTodosTipoManifestacao();
        Resposta<List<TipoManifestacaoDTO>> resposta = RespostaBuilder.getBuilder().setResultado(converter(listaTipoManifestacao)).build();
        return new ResponseEntity(resposta, HttpStatus.OK);
    }

    private java.util.List<TipoManifestacao> converter(java.util.List<TipoManifestacao> tipoManifestacao) {
        Type targetListType = new TypeToken<List<TipoManifestacao>>() {
        }.getType();
        return entityConverter.converterListaStrictLazyLoading(tipoManifestacao, targetListType);
    }


}
