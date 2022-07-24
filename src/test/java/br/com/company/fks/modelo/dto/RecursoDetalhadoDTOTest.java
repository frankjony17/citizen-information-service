package br.com.company.fks.modelo.dto;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Calendar;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class RecursoDetalhadoDTOTest {
    @InjectMocks
    private RecursoDetalhadoDTO dto;
    @Mock
    private Calendar dataAbertura;
    @Mock
    private Calendar vencimentoUnidade;
    @Mock
    private Calendar dataPrazoAtendimento;


    @Test
    public void RecursoDetalhadoDTO(){
        SolicitanteDTO solicitanteDTO = new SolicitanteDTO();
        dto.getIdRecurso();
        dto.setIdRecurso(1L);
        dto.getProtocolo();
        dto.setProtocolo("protocolo");
        dto.getNomeStatusSolicitacao();
        dto.setNomeStatusSolicitacao("nomeStatusSolicitacao");
        dto.getDataAbertura();
        dto.setDataAbertura(dataAbertura);
        dto.getVencimentoUnidade();
        dto.setVencimentoUnidade(vencimentoUnidade);
        dto.getSolicitanteDTO();
        dto.setSolicitanteDTO(solicitanteDTO);
        dto.getNomeTipoRecurso();
        dto.setNomeTipoRecurso("nomeTipoRecurso");
        dto.getNomeSituacaoRecurso();
        dto.setNomeSituacaoRecurso("nomeSituacaoRecurso");
        dto.getDataPrazoAtendimento();
        dto.setDataPrazoAtendimento(dataPrazoAtendimento);
        dto.getJustificativa();
        dto.setJustificativa("justificativa");
        dto.getPropostaResposta();
        dto.setPropostaResposta("propostaResposta");
        dto.getRespostaESic();
        dto.setRespostaESic("respostaESic");
        dto.getStatusRespostaAssinada();
        dto.setStatusRespostaAssinada(true);
        dto.getObservacao();
        dto.setObservacao("observacao");
    }

}