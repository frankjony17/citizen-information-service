package br.com.company.fks.modelo.dto;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Calendar;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class ConsultaRecursoDTOTest {

    @InjectMocks
    private ConsultaRecursoDTO dto;

    @Mock
    private Calendar dataAbertura;

    @Mock
    private Calendar prazoAtendimento;

    @Mock
    private Calendar vencimentoUnidade;

    @Mock
    private Calendar dataResposta;

    @Test
    public void ConsultaRecursoDTO(){
        dto.getIdRecurso();
        dto.setIdRecurso(1L);
        dto.getIdPedido();
        dto.setIdPedido(1L);
        dto.getProtocolo();
        dto.setProtocolo("protocolo");
        dto.getNomeTipoRecurso();
        dto.setNomeTipoRecurso("nomeTipoRecurso");
        dto.getDataAbertura();
        dto.setDataAbertura(dataAbertura);
        dto.getPrazoAtendimento();
        dto.setPrazoAtendimento(prazoAtendimento);
        dto.getVencimentoUnidade();
        dto.setVencimentoUnidade(vencimentoUnidade);
        dto.getNomeSituacaoRecurso();
        dto.setNomeSituacaoRecurso("nomeSituacaoRecurso");
        dto.getDataResposta();
        dto.setDataResposta(dataResposta);
        dto.getNomeSolicitante();
        dto.setNomeSolicitante("nomeSolicitante");
    }

}