package br.com.company.fks.modelo.dto;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class ConsultaGlossarioDeTemaDTOTest {

    @InjectMocks
    private ConsultaGlossarioDeTemaDTO dto;

    @Test
    public void ConsultaGlossarioDeTemaDTO(){
        dto.getId();
        dto.setId(1L);
        dto.getNomeSubtema();
        dto.setNomeSubtema("nomeSubtema");
        dto.getIdPalavraChave();
        dto.setIdPalavraChave(1L);
        dto.getIdTema();
        dto.setIdTema(1L);
        dto.getOffset();
        dto.setOffset(2);
        dto.getLimit();
        dto.setLimit(2);
    }

}