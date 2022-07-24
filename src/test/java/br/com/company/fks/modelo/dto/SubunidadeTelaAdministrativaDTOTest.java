package br.com.company.fks.modelo.dto;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class SubunidadeTelaAdministrativaDTOTest {
    @InjectMocks
    private SubunidadeTelaAdministrativaDTO dto;

    @Test
    public void SubunidadeTelaAdministrativaDTO(){
        dto.getIdUnidade();
        dto.setIdUnidade(1L);
        dto.getNomeUnidade();
        dto.setNomeUnidade("nomeUnidade");
        dto.getIdSubunidade();
        dto.setIdSubunidade(1L);
        dto.getNomeSubunidade();
        dto.setNomeSubunidade("nomeSubunidade");
    }

}