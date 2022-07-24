package br.com.company.fks.modelo.dto;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class SubtemaFiltroDTOTest {
    @InjectMocks
    private SubtemaFiltroDTO dto;

    @Test
    public void SubtemaFiltroDTO(){
        dto.getIdFiltroSubtemaDTO();
        dto.setIdFiltroSubtemaDTO(1L);
        dto.getNomeSubtema();
        dto.setNomeSubtema("nomeSubtema");
    }

}