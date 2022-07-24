package br.com.company.fks.modelo.dto;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class DevolveRecursoDTOTest {
    @InjectMocks
    private DevolveRecursoDTO dto;

    @Test
    public void DevolveRecursoDTO(){
        dto.getIdRecurso();
        dto.setIdRecurso(1L);
        dto.getJustificativa();
        dto.setJustificativa("justificativa");
        dto.getNomeStatusSolicitacao();
        dto.setNomeStatusSolicitacao("nomeStatusSolicitacao");
    }

}