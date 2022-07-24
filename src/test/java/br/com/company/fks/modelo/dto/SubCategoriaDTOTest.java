package br.com.company.fks.modelo.dto;

import br.com.company.fks.modelo.Categoria;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class SubCategoriaDTOTest {
    @InjectMocks
    private SubCategoriaDTO dto;

    @Test
    public void SubCategoriaDTO(){
        Categoria categoria = new Categoria();
        dto.getId();
        dto.setId(1L);
        dto.getDescricao();
        dto.setDescricao("descricao");
        dto.getCategoria();
        dto.setCategoria(categoria);
    }

}