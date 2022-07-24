package br.com.company.fks.modelo.dto;

import br.com.company.fks.modelo.ClassificacaoResposta;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class TipoClassificacaoRespostaAllDTOTest {
    @InjectMocks
    private TipoClassificacaoRespostaAllDTO dto;

    @Test
    public void TipoClassificacaoRespostaAllDTO(){
        List<ClassificacaoResposta> classificacaoResposta = new ArrayList<>();
        dto.getId();
        dto.setId(1L);
        dto.getDescricao();
        dto.setDescricao("descricao");
        dto.getClassificacaoResposta();
        dto.setClassificacaoResposta(classificacaoResposta);
    }

}