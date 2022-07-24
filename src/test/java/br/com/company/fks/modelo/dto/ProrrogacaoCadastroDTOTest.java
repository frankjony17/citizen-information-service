package br.com.company.fks.modelo.dto;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Calendar;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class ProrrogacaoCadastroDTOTest {
    @InjectMocks
    private ProrrogacaoCadastroDTO dto;
    @Mock
    private Calendar novoVencimentoUnidade;
    @Mock
    private Calendar previsaoEsic;

    @Test
    public void ProrrogacaoCadastroDTO(){
        dto.getIdMotivoProrrogacao();
        dto.setIdMotivoProrrogacao(1L);
        dto.getJustificativaProrrogacao();
        dto.setJustificativaProrrogacao("justificativaProrrogacao");
        dto.getIdPedido();
        dto.setIdPedido(1L);
        dto.getNovoVencimentoUnidade();
        dto.setNovoVencimentoUnidade(novoVencimentoUnidade);
        dto.getPrevisaoEsic();
        dto.setPrevisaoEsic(previsaoEsic);
    }

}