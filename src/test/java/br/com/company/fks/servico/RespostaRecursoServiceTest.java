package br.com.company.fks.servico;

import br.com.company.fks.modelo.AndamentoRecurso;
import br.com.company.fks.modelo.Recurso;
import br.com.company.fks.modelo.StatusSolicitacaoRecurso;
import br.com.company.fks.modelo.StatusTramitacaoRecurso;
import br.com.company.fks.modelo.dto.RespostaRecursoDTO;
import br.com.company.fks.repositorio.AndamentoRecursoRepository;
import br.com.company.fks.repositorio.RecursoRepository;
import lombok.SneakyThrows;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

/**
 * Created by Maicon Godoy - FKSolutions Tecnologia on 28/08/18.
 */
@RunWith(MockitoJUnitRunner.class)
public class RespostaRecursoServiceTest {
    @InjectMocks
    private RespostaRecursoService respostaRecursoService;
    @Mock
    private HistoricoTratamentoRecursoService historicoTratamentoRecursoService;
    @Mock
    private AndamentoRecursoService andamentoRecursoService;
    @Mock
    private RecursoRepository recursoRepository;
    @Mock
    private RespostaRecursoDTO respostaRecursoDTO;
    @Mock
    private Recurso recurso;
    @Mock
    private StatusSolicitacaoRecurso statusSolicitacao;
    @Mock
    private StatusTramitacaoRecurso statusTramitacao;
    @Mock
    private AndamentoRecursoRepository andamentoRecursoRepository;
    @Mock
    private AndamentoRecurso andamentoRecurso;
    @Mock
    private List<AndamentoRecurso> andamentoRecursoList;


    @Test
    @SneakyThrows
    public void enviarRECURSO_1_RESPONDIDO() {
        when(respostaRecursoDTO.getIdStatusSolicitacao()).thenReturn(1L);
        when(respostaRecursoDTO.getIdRecurso()).thenReturn(1L);
        when(recursoRepository.findById(1L)).thenReturn(recurso);
        when(respostaRecursoDTO.getObservacao()).thenReturn("Recurso de 1ª encaminhado como proposta de resposta de Recurso");
        when(respostaRecursoDTO.getIdStatusSolicitacao()).thenReturn(5L);
        when(recurso.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(recurso.getStatusTramitacao()).thenReturn(statusTramitacao);
        when(recurso.getRespostaEsic()).thenReturn("teste");
        Mockito.doNothing().when(historicoTratamentoRecursoService).gerarHistoricoTratamento(recurso,1L);
        Mockito.doNothing().when(andamentoRecursoService).gerarAndamentoRecurso(recurso,false,"Recurso de 1ª encaminhado como proposta de resposta de Recurso");
        respostaRecursoService.enviar(respostaRecursoDTO);
    }

    @Test
    @SneakyThrows
    public void enviarRECURSO_1_RESPONDIDONull() {
        when(respostaRecursoDTO.getIdStatusSolicitacao()).thenReturn(1L);
        when(respostaRecursoDTO.getIdRecurso()).thenReturn(1L);
        when(recursoRepository.findById(1L)).thenReturn(recurso);
        when(respostaRecursoDTO.getObservacao()).thenReturn(null);
        when(respostaRecursoDTO.getIdStatusSolicitacao()).thenReturn(5L);
        when(recurso.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(recurso.getStatusTramitacao()).thenReturn(statusTramitacao);
        when(recurso.getRespostaEsic()).thenReturn("teste");
        Mockito.doNothing().when(historicoTratamentoRecursoService).gerarHistoricoTratamento(recurso,1L);
        Mockito.doNothing().when(andamentoRecursoService).gerarAndamentoRecurso(recurso,false,"Recurso de 1ª encaminhado como proposta de resposta de Recurso");
        respostaRecursoService.enviar(respostaRecursoDTO);
    }

    @Test
    @SneakyThrows
    public void enviarRECURSO_1_ASSINADO() {
        when(respostaRecursoDTO.getIdStatusSolicitacao()).thenReturn(1L);
        when(respostaRecursoDTO.getIdRecurso()).thenReturn(1L);
        when(recursoRepository.findById(1L)).thenReturn(recurso);
        when(respostaRecursoDTO.getObservacao()).thenReturn("Recurso de 1ª encaminhado como proposta de resposta de Recurso");
        when(respostaRecursoDTO.getIdStatusSolicitacao()).thenReturn(4L);
        when(recurso.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(recurso.getStatusTramitacao()).thenReturn(statusTramitacao);
        when(recurso.getRespostaEsic()).thenReturn("teste");
        Mockito.doNothing().when(historicoTratamentoRecursoService).gerarHistoricoTratamento(recurso,1L);
        Mockito.doNothing().when(andamentoRecursoService).gerarAndamentoRecurso(recurso,false,"Recurso de 1ª encaminhado como proposta de resposta de Recurso");
        respostaRecursoService.enviar(respostaRecursoDTO);
    }

    @Test
    @SneakyThrows
    public void enviarRECURSO_1_PARA_REVISAO() {
        when(respostaRecursoDTO.getIdStatusSolicitacao()).thenReturn(1L);
        when(respostaRecursoDTO.getIdRecurso()).thenReturn(1L);
        when(recursoRepository.findById(1L)).thenReturn(recurso);
        when(respostaRecursoDTO.getObservacao()).thenReturn("Recurso de 1ª encaminhado como proposta de resposta de Recurso");
        when(respostaRecursoDTO.getIdStatusSolicitacao()).thenReturn(6L);
        when(recurso.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(recurso.getStatusTramitacao()).thenReturn(statusTramitacao);
        when(recurso.getRespostaEsic()).thenReturn("teste");
        Mockito.doNothing().when(historicoTratamentoRecursoService).gerarHistoricoTratamento(recurso,1L);
        Mockito.doNothing().when(andamentoRecursoService).gerarAndamentoRecurso(recurso,false,"Recurso de 1ª encaminhado como proposta de resposta de Recurso");
        respostaRecursoService.enviar(respostaRecursoDTO);
    }

    @Test
    @SneakyThrows
    public void enviarRECURSO_1_ENVIADO() {
        when(respostaRecursoDTO.getIdStatusSolicitacao()).thenReturn(1L);
        when(respostaRecursoDTO.getIdRecurso()).thenReturn(1L);
        when(recursoRepository.findById(1L)).thenReturn(recurso);
        when(respostaRecursoDTO.getObservacao()).thenReturn("Recurso de 1ª encaminhado como proposta de resposta de Recurso");
        when(respostaRecursoDTO.getIdStatusSolicitacao()).thenReturn(8L);
        when(recurso.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(recurso.getStatusTramitacao()).thenReturn(statusTramitacao);
        when(recurso.getRespostaEsic()).thenReturn("teste");
        Mockito.doNothing().when(historicoTratamentoRecursoService).gerarHistoricoTratamento(recurso,1L);
        Mockito.doNothing().when(andamentoRecursoService).gerarAndamentoRecurso(recurso,false,"Recurso de 1ª encaminhado como proposta de resposta de Recurso");
        respostaRecursoService.enviar(respostaRecursoDTO);
    }

    @Test
    @SneakyThrows
    public void enviarRECURSO_2_RESPONDIDO() {
        when(respostaRecursoDTO.getIdStatusSolicitacao()).thenReturn(1L);
        when(respostaRecursoDTO.getIdRecurso()).thenReturn(1L);
        when(recursoRepository.findById(1L)).thenReturn(recurso);
        when(respostaRecursoDTO.getObservacao()).thenReturn("Recurso de 1ª encaminhado como proposta de resposta de Recurso");
        when(respostaRecursoDTO.getIdStatusSolicitacao()).thenReturn(13L);
        when(recurso.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(recurso.getStatusTramitacao()).thenReturn(statusTramitacao);
        when(recurso.getRespostaEsic()).thenReturn("teste");
        Mockito.doNothing().when(historicoTratamentoRecursoService).gerarHistoricoTratamento(recurso,1L);
        Mockito.doNothing().when(andamentoRecursoService).gerarAndamentoRecurso(recurso,false,"Recurso de 1ª encaminhado como proposta de resposta de Recurso");
        respostaRecursoService.enviar(respostaRecursoDTO);
    }

    @Test
    @SneakyThrows
    public void enviarRECURSO_2_ASSINADO() {
        when(respostaRecursoDTO.getIdStatusSolicitacao()).thenReturn(1L);
        when(respostaRecursoDTO.getIdRecurso()).thenReturn(1L);
        when(recursoRepository.findById(1L)).thenReturn(recurso);
        when(respostaRecursoDTO.getObservacao()).thenReturn("Recurso de 1ª encaminhado como proposta de resposta de Recurso");
        when(respostaRecursoDTO.getIdStatusSolicitacao()).thenReturn(12L);
        when(recurso.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(recurso.getStatusTramitacao()).thenReturn(statusTramitacao);
        when(recurso.getRespostaEsic()).thenReturn("teste");
        Mockito.doNothing().when(historicoTratamentoRecursoService).gerarHistoricoTratamento(recurso,1L);
        Mockito.doNothing().when(andamentoRecursoService).gerarAndamentoRecurso(recurso,false,"Recurso de 1ª encaminhado como proposta de resposta de Recurso");
        respostaRecursoService.enviar(respostaRecursoDTO);
    }

    @Test
    @SneakyThrows
    public void enviarRECURSO_2_PARA_REVISAO() {
        when(respostaRecursoDTO.getIdStatusSolicitacao()).thenReturn(1L);
        when(respostaRecursoDTO.getIdRecurso()).thenReturn(1L);
        when(recursoRepository.findById(1L)).thenReturn(recurso);
        when(respostaRecursoDTO.getObservacao()).thenReturn("Recurso de 1ª encaminhado como proposta de resposta de Recurso");
        when(respostaRecursoDTO.getIdStatusSolicitacao()).thenReturn(14L);
        when(recurso.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(recurso.getStatusTramitacao()).thenReturn(statusTramitacao);
        when(recurso.getRespostaEsic()).thenReturn("teste");
        Mockito.doNothing().when(historicoTratamentoRecursoService).gerarHistoricoTratamento(recurso,1L);
        Mockito.doNothing().when(andamentoRecursoService).gerarAndamentoRecurso(recurso,false,"Recurso de 1ª encaminhado como proposta de resposta de Recurso");
        respostaRecursoService.enviar(respostaRecursoDTO);
    }

    @Test
    @SneakyThrows
    public void enviarRECURSO_2_ENVIADO() {
        when(respostaRecursoDTO.getIdStatusSolicitacao()).thenReturn(1L);
        when(respostaRecursoDTO.getIdRecurso()).thenReturn(1L);
        when(recursoRepository.findById(1L)).thenReturn(recurso);
        when(respostaRecursoDTO.getObservacao()).thenReturn("Recurso de 1ª encaminhado como proposta de resposta de Recurso");
        when(respostaRecursoDTO.getIdStatusSolicitacao()).thenReturn(16L);
        when(recurso.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(recurso.getStatusTramitacao()).thenReturn(statusTramitacao);
        when(recurso.getRespostaEsic()).thenReturn("teste");
        Mockito.doNothing().when(historicoTratamentoRecursoService).gerarHistoricoTratamento(recurso,1L);
        Mockito.doNothing().when(andamentoRecursoService).gerarAndamentoRecurso(recurso,false,"Recurso de 1ª encaminhado como proposta de resposta de Recurso");
        respostaRecursoService.enviar(respostaRecursoDTO);
    }

    @Test
    @SneakyThrows
    public void verificarAndamentoRecurso(){
        when(andamentoRecursoRepository.recuperarAndamentoRecurso(1L)).thenReturn(andamentoRecursoList);
        when(andamentoRecursoList.get(1)).thenReturn(andamentoRecurso);
        when(andamentoRecurso.getStatusSolicitacaoRecurso()).thenReturn(statusSolicitacao);
        when(statusSolicitacao.getId()).thenReturn(1L);
        respostaRecursoService.verificarAndamentoRecurso(1L);
    }

}