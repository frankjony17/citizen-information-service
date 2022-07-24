package br.com.company.fks.modelo.dto;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Calendar;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class ProrrogacaoDTOTest {
    @InjectMocks
    private ProrrogacaoDTO dto;
    @Mock
    private Calendar novoVencimentoUnidade;

    @Test
    public void ProrrogacaoDTO(){
        dto.getJustificativaProrrogacao();
        dto.setJustificativaProrrogacao("justificativaProrrogacao");
        dto.getNomeMotivoProrrogacao();
        dto.setNomeMotivoProrrogacao("nomeMotivoProrrogacao");
        dto.getNovoVencimentoUnidade();
        dto.setNovoVencimentoUnidade(novoVencimentoUnidade);

    }

}