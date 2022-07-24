package br.com.company.fks.servico;

import br.com.company.fks.modelo.Categoria;
import br.com.company.fks.repositorio.CategoriaRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class
)
public class CategoriaServiceTest {
    @InjectMocks
    private CategoriaService categoriaService;
    @Mock
    private CategoriaRepository categoriaRepository;
    @Mock
    private List<Categoria> categoriaList;

    @Test
    public void buscarTodasDescricaoCategoriaTest(){
        when(categoriaRepository.findAllOrderByDescricao()).thenReturn(categoriaList);
        assertEquals(categoriaService.buscarTodasDescricaoCategoria(),categoriaList);

    }


}
