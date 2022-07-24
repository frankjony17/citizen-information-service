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
public class RespostaClassificadaDTOTest {
    @InjectMocks
    private RespostaClassificadaDTO dto;

    @Test
    public void RespostaClassificadaDTO(){
        List<ClassificacaoResposta> listaClassificacaoResposta = new ArrayList<>();
        dto.getId();
        dto.setId(1L);
        dto.getListaClassificacaoResposta();
        dto.setListaClassificacaoResposta(listaClassificacaoResposta);
    }

}