package br.com.company.fks.servico;


import br.com.company.fks.modelo.SubCategoria;
import br.com.company.fks.repositorio.SubCategoriaRepository;
import groovy.lang.DelegatesTo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SubCategoriaServiceTest {

    @InjectMocks
    private SubCategoriaService subCategoriaService;

    @Mock
    private SubCategoriaRepository subCategoriaRepository;

    @Mock
    private List<SubCategoria>  subCategoriaList;

    @Test
    public void buscarTodasSubCategoriaTest(){
        when(subCategoriaRepository.findAllByDescricao()).thenReturn(subCategoriaList);
        subCategoriaService.buscarTodasSubCategoria();
    }
    @Test
    public void buscarPorCategoria(){
        when(subCategoriaRepository.findAllByCategoria(anyLong())).thenReturn(subCategoriaList);
        subCategoriaService.buscarPorCategoria(1l);
    }




}
