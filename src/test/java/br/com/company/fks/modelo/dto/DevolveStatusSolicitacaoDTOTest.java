package br.com.company.fks.modelo.dto;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class DevolveStatusSolicitacaoDTOTest {
    @InjectMocks
    private DevolveStatusSolicitacaoDTO dto;

    @Test
    public void DevolveStatusSolicitacaoDTO(){
        dto.getRespostaFKS();
        dto.setRespostaFKS("respostaFKS");
    }

}