package br.com.company.fks.controller;

import br.com.company.fks.controller.builder.Resposta;
import br.com.company.fks.controller.builder.RespostaBuilder;
import br.com.company.fks.modelo.Orgao;
import br.com.company.fks.modelo.dto.CategoriaDTO;
import br.com.company.fks.modelo.dto.OrgaoDTO;
import br.com.company.fks.servico.OrgaoService;
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
@RequestMapping(value = "orgao", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class OrgaoController  {

    @Autowired
    private OrgaoService orgaoService;

    @Autowired
    private EntityConverter entityConverter;


    @RequestMapping(value = "", method = {RequestMethod.GET})
    public ResponseEntity<Resposta<List<CategoriaDTO>>> buscaTodasCategorias() {
        List<Orgao> listaOrgao = orgaoService.buscarTodasDescricaoOrgao();
        Resposta<List<CategoriaDTO>> resposta = RespostaBuilder.getBuilder().setResultado(converter(listaOrgao)).build();
        return new ResponseEntity<>(resposta, HttpStatus.OK);
    }

    private List<CategoriaDTO> converter(List<Orgao> orgao) {
        Type targetListType = new TypeToken<List<OrgaoDTO>>() {
        }.getType();
        return entityConverter.converterListaStrictLazyLoading(orgao, targetListType);
    }

}
