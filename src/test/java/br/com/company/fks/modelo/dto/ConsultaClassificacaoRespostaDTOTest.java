package br.com.company.fks.modelo.dto;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class ConsultaClassificacaoRespostaDTOTest {

    @InjectMocks
    private ConsultaClassificacaoRespostaDTO dto;

    @Test
    public void ConsultaClassificacaoRespostaDTO(){
        dto.getId();
        dto.setId(1L);
        dto.getIdTipoClassificacaoResposta();
        dto.setIdTipoClassificacaoResposta(1L);
        dto.getOffset();
        dto.setOffset(1);
        dto.getNomeClassificacao();
        dto.setNomeClassificacao("nomeClassificacao");
        dto.getLimit();
        dto.setLimit(1);
    }

}