package br.com.company.fks.modelo.dto;

import br.com.company.fks.modelo.TipoResposta;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class ClassificacaoTipoRespostaDTOTest {

    @InjectMocks
    private ClassificacaoTipoRespostaDTO dto;

    @Test
    public void ClassificacaoTipoRespostaDTO(){
        TipoResposta tipoResposta = new TipoResposta();
        dto.getId();
        dto.setId(1L);
        dto.getDescricao();
        dto.setDescricao("descricao");
        dto.getTipoResposta();
        dto.setTipoResposta(tipoResposta);
    }

}