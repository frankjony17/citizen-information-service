package br.com.company.fks.controller;

import br.com.company.fks.controller.builder.Resposta;
import br.com.company.fks.modelo.SubCategoria;
import br.com.company.fks.modelo.dto.SubCategoriaDTO;
import br.com.company.fks.servico.SubCategoriaService;
import br.com.company.fks.utils.EntityConverter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SubCategoriaControllerTest {

    @InjectMocks
    private SubCategoriaController subCategoriaController;

    @Mock
    private SubCategoriaService subCategoriaService;

    @Mock
    private EntityConverter entityConverter;

    @Mock
    private SubCategoriaDTO subCategoriaDTO;

    @Test
    public void consultaMotivoProrrogacaoTest() throws Exception {
        when(subCategoriaService.buscarTodasSubCategoria()).thenReturn(Collections.emptyList());
        when(entityConverter.converterStrict(any(SubCategoria.class), eq(SubCategoriaDTO.class))).thenReturn(subCategoriaDTO);
        ResponseEntity<Resposta<List<SubCategoriaDTO>>> retorno = subCategoriaController.buscarTodasSubCategoria();

        assertEquals(HttpStatus.OK, retorno.getStatusCode());
    }

    @Test
    public void buscarPorCategoria() throws Exception {
        when(subCategoriaService.buscarPorCategoria(1L)).thenReturn(Collections.emptyList());
        when(entityConverter.converterStrict(any(SubCategoria.class), eq(SubCategoriaDTO.class))).thenReturn(subCategoriaDTO);
        ResponseEntity<Resposta<List<SubCategoriaDTO>>> retorno = subCategoriaController.buscarPorCategoria(1L);

        assertEquals(HttpStatus.OK, retorno.getStatusCode());
    }
}
