package br.com.company.fks.modelo.dto;

import br.com.company.fks.modelo.TipoClassificacaoResposta;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class ClassificacaoRespostaDTOTest {

    @InjectMocks
    private ClassificacaoRespostaDTO dto;

    @Test
    public void ClassificacaoRespostaDTO(){
        TipoClassificacaoResposta tipoClassificacaoResposta = new TipoClassificacaoResposta();
        dto.getId();
        dto.setId(1L);
        dto.getDescricao();
        dto.setDescricao("descricao");
        dto.getTipoClassificacaoResposta();
        dto.setTipoClassificacaoResposta(tipoClassificacaoResposta);
        dto.getStatusClassificacaoResposta();
        dto.setStatusClassificacaoResposta(true);
    }

}