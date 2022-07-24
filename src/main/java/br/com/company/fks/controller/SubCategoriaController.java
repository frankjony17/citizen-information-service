package br.com.company.fks.controller;

import br.com.company.fks.controller.builder.Resposta;
import br.com.company.fks.controller.builder.RespostaBuilder;
import br.com.company.fks.modelo.SubCategoria;
import br.com.company.fks.modelo.dto.SubCategoriaDTO;
import br.com.company.fks.servico.SubCategoriaService;
import br.com.company.fks.utils.EntityConverter;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Type;
import java.util.List;

@RestController
@RequestMapping(value = "/subCategoria", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class SubCategoriaController {

    @Autowired
    private EntityConverter entityConverter;
    @Autowired
    private SubCategoriaService subCategoriaService;

    @RequestMapping(value = "", method = {RequestMethod.GET})
    public ResponseEntity<Resposta<List<SubCategoriaDTO>>> buscarTodasSubCategoria() {
        List<SubCategoria> listaSubCategoria = subCategoriaService.buscarTodasSubCategoria();
        Resposta<List<SubCategoriaDTO>> resposta = RespostaBuilder.getBuilder().setResultado(converter(listaSubCategoria)).build();
        return new ResponseEntity<>(resposta, HttpStatus.OK);
    }


    @RequestMapping(value = "porCategoria/{id}", method = {RequestMethod.GET})
    public ResponseEntity<Resposta<List<SubCategoriaDTO>>> buscarPorCategoria(@PathVariable("id") Long idCategoria) {
        List<SubCategoria> listaSubCategoria = subCategoriaService.buscarPorCategoria(idCategoria);
        Resposta<List<SubCategoriaDTO>> resposta = RespostaBuilder.getBuilder().setResultado(converter(listaSubCategoria)).build();
        return new ResponseEntity<>(resposta, HttpStatus.OK);
    }



    private java.util.List<SubCategoriaDTO> converter(java.util.List<SubCategoria> subCategoria) {
        Type targetListType = new TypeToken<List<SubCategoriaDTO>>() {
        }.getType();
        return entityConverter.converterListaStrictLazyLoading(subCategoria, targetListType);
    }

}
