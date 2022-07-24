package br.com.company.fks.controller;


import br.com.company.fks.controller.builder.Resposta;
import br.com.company.fks.modelo.Orgao;
import br.com.company.fks.modelo.dto.CategoriaDTO;
import br.com.company.fks.servico.OrgaoService;
import br.com.company.fks.utils.EntityConverter;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.modelmapper.TypeToken;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class
)

public class OrgaoControllerTest {
    @InjectMocks
    private OrgaoController orgaoController;
    @Mock
    private OrgaoService orgaoService;
    @Mock
    private EntityConverter entityConverter;
    @Mock
    private ResponseEntity<Resposta<List<CategoriaDTO>>> categoriaDTOListRespostaResponseEntity;
    @Mock
    private List<Orgao> orgaoList;
    @Mock
    private  Resposta<List<CategoriaDTO>> categoriaDTOListResposta;


    @Test
    public void buscaTodasCategoriasTest(){
        when(orgaoService.buscarTodasDescricaoOrgao()).thenReturn(orgaoList);
        ResponseEntity<Resposta<List<CategoriaDTO>>> teste = orgaoController.buscaTodasCategorias();
        assertNotNull(teste);



    }




}
