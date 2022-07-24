package br.com.company.fks.modelo.dto;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class RespostaRecursoDTOTest {
    @InjectMocks
    private RespostaRecursoDTO dto;

    @Test
    public void RespostaRecursoDTO(){
        dto.getObservacao();
        dto.setObservacao("observacao");
        dto.getIdRecurso();
        dto.setIdRecurso(1L);
        dto.getNomeStatusSolicitacao();
        dto.setNomeStatusSolicitacao("nomeStatusSolicitacao");
        dto.getIdStatusSolicitacao();
        dto.setIdStatusSolicitacao(1L);
        dto.getPropostaResposta();
        dto.setPropostaResposta("propostaResposta");
    }

}