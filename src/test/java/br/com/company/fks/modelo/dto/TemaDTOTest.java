package br.com.company.fks.modelo.dto;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class TemaDTOTest {
    @InjectMocks
    private TemaDTO dto;

    @Test
    public void TemaDTO(){
        dto.getId();
        dto.setId(1L);
        dto.getNomeTema();
        dto.setNomeTema("nomeTema");
    }

}