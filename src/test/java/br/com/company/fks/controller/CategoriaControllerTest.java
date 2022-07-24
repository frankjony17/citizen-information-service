package br.com.company.fks.controller;

import br.com.company.fks.controller.builder.Resposta;
import br.com.company.fks.modelo.Categoria;
import br.com.company.fks.modelo.dto.CategoriaDTO;
import br.com.company.fks.servico.CategoriaService;
import br.com.company.fks.utils.EntityConverter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.when;
import static org.junit.Assert.assertEquals;


import java.util.Collections;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class CategoriaControllerTest  {

    @InjectMocks
    private CategoriaController categoriaController;

    @Mock
    private EntityConverter entityConverter;

    @Mock
    private CategoriaDTO categoriaDTO;

    @Mock
    private CategoriaService categoriaService;

    @Test
    public void buscarTodasDescricaoCategoria() throws Exception {
        when(categoriaService.buscarTodasDescricaoCategoria()).thenReturn(Collections.emptyList());
        when(entityConverter.converterStrict(any(Categoria.class), eq(CategoriaDTO.class))).thenReturn(categoriaDTO);
        ResponseEntity<Resposta<List<CategoriaDTO>>> retorno = categoriaController.buscaTodasCategorias();

        assertEquals(HttpStatus.OK, retorno.getStatusCode());
    }







}
