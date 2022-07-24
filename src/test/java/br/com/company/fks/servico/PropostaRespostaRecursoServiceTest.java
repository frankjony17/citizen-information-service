package br.com.company.fks.servico;

import br.com.company.fks.excecao.IntegracaoException;
import br.com.company.fks.modelo.*;
import br.gov.mpog.fks.modelo.*;
import br.com.company.fks.modelo.dto.PropostaRespostaRecursoDTO;
import br.com.company.fks.repositorio.RecursoRepository;
import jdk.nashorn.internal.objects.annotations.Setter;
import lombok.SneakyThrows;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.when;

/**
 * Created by Maicon Godoy - FKSolutions Tecnologia on 28/08/18.
 */
@RunWith(MockitoJUnitRunner.class)
public class PropostaRespostaRecursoServiceTest {
    @InjectMocks
    private PropostaRespostaRecursoService propostaRespostaRecursoService;
    @Mock
    private HistoricoTratamentoRecursoService historicoTratamentoRecursoService;
    @Mock
    private AndamentoRecursoService andamentoRecursoService;
    @Mock
    private RecursoRepository recursoRepository;
    @Mock
    private PropostaRespostaRecursoDTO propostaRespostaRecursoDTO;
    @Mock
    private Recurso recurso;
    @Mock
    private StatusSolicitacaoRecurso statusSolicitacao;
    @Mock
    private StatusTramitacaoRecurso statusTramitacao;
    @Mock
    private UsuarioAcessos usuarioAcessos;


    @Test
    @SneakyThrows
    public void enviarRECURSO_1_DISTRIBUICAO_PF() {
        when(propostaRespostaRecursoDTO.getIdStatusSolicitacaoRecurso()).thenReturn(1L);
        when(propostaRespostaRecursoDTO.getIdRecurso()).thenReturn(1L);
        when(recursoRepository.findById(1L)).thenReturn(recurso);
        when(propostaRespostaRecursoDTO.getObservacao()).thenReturn("Recurso de 1ª encaminhado como proposta de resposta de Recurso");
        when(propostaRespostaRecursoDTO.getIdStatusSolicitacaoRecurso()).thenReturn(2L);
        when(recurso.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(recurso.getStatusTramitacao()).thenReturn(statusTramitacao);
        when(recurso.getPropostaResposta()).thenReturn("teste");
        when(recurso.getRespostaEsic()).thenReturn("teste");
        Mockito.doNothing().when(historicoTratamentoRecursoService).gerarHistoricoTratamento(recurso,1L);
        Mockito.doNothing().when(andamentoRecursoService).gerarAndamentoRecurso(recurso,false,"Recurso de 1ª encaminhado como proposta de resposta de Recurso");
        propostaRespostaRecursoService.enviar(propostaRespostaRecursoDTO);
    }

    @Test
    @SneakyThrows
    public void enviarRECURSO_1_DISTRIBUICAO_PFNull() {
        when(propostaRespostaRecursoDTO.getIdStatusSolicitacaoRecurso()).thenReturn(1L);
        when(propostaRespostaRecursoDTO.getIdRecurso()).thenReturn(1L);
        when(recursoRepository.findById(1L)).thenReturn(recurso);
        when(propostaRespostaRecursoDTO.getObservacao()).thenReturn(null);
        when(propostaRespostaRecursoDTO.getIdStatusSolicitacaoRecurso()).thenReturn(2L);
        when(recurso.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(recurso.getStatusTramitacao()).thenReturn(statusTramitacao);
        when(recurso.getPropostaResposta()).thenReturn("teste");
        when(recurso.getRespostaEsic()).thenReturn("teste");
        Mockito.doNothing().when(historicoTratamentoRecursoService).gerarHistoricoTratamento(recurso,1L);
        Mockito.doNothing().when(andamentoRecursoService).gerarAndamentoRecurso(recurso,false,"Recurso de 1ª encaminhado como proposta de resposta de Recurso");
        propostaRespostaRecursoService.enviar(propostaRespostaRecursoDTO);
    }

    @Test
    @SneakyThrows
    public void enviarRECURSO_1_PRODUCAO() {
        when(propostaRespostaRecursoDTO.getIdStatusSolicitacaoRecurso()).thenReturn(1L);
        when(propostaRespostaRecursoDTO.getIdRecurso()).thenReturn(1L);
        when(recursoRepository.findById(1L)).thenReturn(recurso);
        when(propostaRespostaRecursoDTO.getObservacao()).thenReturn("Recurso de 1ª encaminhado como proposta de resposta de Recurso");
        when(propostaRespostaRecursoDTO.getIdStatusSolicitacaoRecurso()).thenReturn(3L);
        when(recurso.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(recurso.getStatusTramitacao()).thenReturn(statusTramitacao);
        when(recurso.getPropostaResposta()).thenReturn("teste");
        when(recurso.getRespostaEsic()).thenReturn("teste");
        Mockito.doNothing().when(historicoTratamentoRecursoService).gerarHistoricoTratamento(recurso,1L);
        Mockito.doNothing().when(andamentoRecursoService).gerarAndamentoRecurso(recurso,false,"Recurso de 1ª encaminhado como proposta de resposta de Recurso");
        propostaRespostaRecursoService.enviar(propostaRespostaRecursoDTO);
    }

    @Test
    @SneakyThrows
    public void enviarRECURSO_1_PRODUCAOIsEmpty() {
        when(propostaRespostaRecursoDTO.getIdStatusSolicitacaoRecurso()).thenReturn(1L);
        when(propostaRespostaRecursoDTO.getIdRecurso()).thenReturn(1L);
        when(recursoRepository.findById(1L)).thenReturn(recurso);
        when(propostaRespostaRecursoDTO.getObservacao()).thenReturn("Recurso de 1ª encaminhado como proposta de resposta de Recurso");
        when(propostaRespostaRecursoDTO.getIdStatusSolicitacaoRecurso()).thenReturn(3L);
        when(recurso.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(recurso.getStatusTramitacao()).thenReturn(statusTramitacao);
        when(recurso.getPropostaResposta()).thenReturn(null);

        List<UsuarioAcessos> usuarioAcessosList = new ArrayList<>();
        usuarioAcessosList.add(usuarioAcessos);
        usuarioAcessosList.add(usuarioAcessos);
        usuarioAcessosList.add(usuarioAcessos);
        when(propostaRespostaRecursoDTO.getUsuarioAcessosList()).thenReturn(usuarioAcessosList);
        when(recurso.getRespostaEsic()).thenReturn("teste");
        Mockito.doNothing().when(historicoTratamentoRecursoService).gerarHistoricoTratamento(recurso,1L);
        Mockito.doNothing().when(andamentoRecursoService).gerarAndamentoRecurso(recurso,false,"Recurso de 1ª encaminhado como proposta de resposta de Recurso");
        propostaRespostaRecursoService.enviar(propostaRespostaRecursoDTO);
    }

    @Test
    @SneakyThrows
    public void enviarRECURSO_1_PRODUCAONull() {
        when(propostaRespostaRecursoDTO.getIdStatusSolicitacaoRecurso()).thenReturn(1L);
        when(propostaRespostaRecursoDTO.getIdRecurso()).thenReturn(1L);
        when(recursoRepository.findById(1L)).thenReturn(recurso);
        when(propostaRespostaRecursoDTO.getObservacao()).thenReturn("Recurso de 1ª encaminhado como proposta de resposta de Recurso");
        when(propostaRespostaRecursoDTO.getIdStatusSolicitacaoRecurso()).thenReturn(3L);
        when(recurso.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(recurso.getStatusTramitacao()).thenReturn(statusTramitacao);
        when(recurso.getPropostaResposta()).thenReturn(null);
        when(propostaRespostaRecursoDTO.getUsuarioAcessosList()).thenReturn(null);
        when(recurso.getRespostaEsic()).thenReturn("teste");
        Mockito.doNothing().when(historicoTratamentoRecursoService).gerarHistoricoTratamento(recurso,1L);
        Mockito.doNothing().when(andamentoRecursoService).gerarAndamentoRecurso(recurso,false,"Recurso de 1ª encaminhado como proposta de resposta de Recurso");
        propostaRespostaRecursoService.enviar(propostaRespostaRecursoDTO);
    }

    @Test
    @SneakyThrows
    public void enviarRECURSO_1_PARA_ENVIO() {
        when(propostaRespostaRecursoDTO.getIdStatusSolicitacaoRecurso()).thenReturn(1L);
        when(propostaRespostaRecursoDTO.getIdRecurso()).thenReturn(1L);
        when(recursoRepository.findById(1L)).thenReturn(recurso);
        when(propostaRespostaRecursoDTO.getObservacao()).thenReturn("Recurso de 1ª encaminhado como proposta de resposta de Recurso");
        when(propostaRespostaRecursoDTO.getIdStatusSolicitacaoRecurso()).thenReturn(7L);
        when(recurso.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(recurso.getStatusTramitacao()).thenReturn(statusTramitacao);
        when(recurso.getPropostaResposta()).thenReturn("teste");
        when(recurso.getRespostaEsic()).thenReturn("teste");
        Mockito.doNothing().when(historicoTratamentoRecursoService).gerarHistoricoTratamento(recurso,1L);
        Mockito.doNothing().when(andamentoRecursoService).gerarAndamentoRecurso(recurso,false,"Recurso de 1ª encaminhado como proposta de resposta de Recurso");
        propostaRespostaRecursoService.enviar(propostaRespostaRecursoDTO);
    }

    @Test
    @SneakyThrows
    public void enviarRECURSO_2_DISTRIBUICAO_PF() {
        when(propostaRespostaRecursoDTO.getIdStatusSolicitacaoRecurso()).thenReturn(1L);
        when(propostaRespostaRecursoDTO.getIdRecurso()).thenReturn(1L);
        when(recursoRepository.findById(1L)).thenReturn(recurso);
        when(propostaRespostaRecursoDTO.getObservacao()).thenReturn("Recurso de 1ª encaminhado como proposta de resposta de Recurso");
        when(propostaRespostaRecursoDTO.getIdStatusSolicitacaoRecurso()).thenReturn(10L);
        when(recurso.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(recurso.getStatusTramitacao()).thenReturn(statusTramitacao);
        when(recurso.getPropostaResposta()).thenReturn("teste");
        when(recurso.getRespostaEsic()).thenReturn("teste");
        Mockito.doNothing().when(historicoTratamentoRecursoService).gerarHistoricoTratamento(recurso,1L);
        Mockito.doNothing().when(andamentoRecursoService).gerarAndamentoRecurso(recurso,false,"Recurso de 1ª encaminhado como proposta de resposta de Recurso");
        propostaRespostaRecursoService.enviar(propostaRespostaRecursoDTO);
    }

    @Test
    @SneakyThrows
    public void enviarRECURSO_2_PRODUCAO() {
        when(propostaRespostaRecursoDTO.getIdStatusSolicitacaoRecurso()).thenReturn(1L);
        when(propostaRespostaRecursoDTO.getIdRecurso()).thenReturn(1L);
        when(recursoRepository.findById(1L)).thenReturn(recurso);
        when(propostaRespostaRecursoDTO.getObservacao()).thenReturn("Recurso de 1ª encaminhado como proposta de resposta de Recurso");
        when(propostaRespostaRecursoDTO.getIdStatusSolicitacaoRecurso()).thenReturn(11L);
        when(recurso.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(recurso.getStatusTramitacao()).thenReturn(statusTramitacao);
        when(recurso.getPropostaResposta()).thenReturn("teste");
        when(recurso.getRespostaEsic()).thenReturn("teste");
        Mockito.doNothing().when(historicoTratamentoRecursoService).gerarHistoricoTratamento(recurso,1L);
        Mockito.doNothing().when(andamentoRecursoService).gerarAndamentoRecurso(recurso,false,"Recurso de 1ª encaminhado como proposta de resposta de Recurso");
        propostaRespostaRecursoService.enviar(propostaRespostaRecursoDTO);
    }

    @Test
    @SneakyThrows
    public void enviarRECURSO_2_PARA_ENVIO() {
        when(propostaRespostaRecursoDTO.getIdStatusSolicitacaoRecurso()).thenReturn(1L);
        when(propostaRespostaRecursoDTO.getIdRecurso()).thenReturn(1L);
        when(recursoRepository.findById(1L)).thenReturn(recurso);
        when(propostaRespostaRecursoDTO.getObservacao()).thenReturn("Recurso de 1ª encaminhado como proposta de resposta de Recurso");
        when(propostaRespostaRecursoDTO.getIdStatusSolicitacaoRecurso()).thenReturn(15L);
        when(recurso.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(recurso.getStatusTramitacao()).thenReturn(statusTramitacao);
        when(recurso.getPropostaResposta()).thenReturn("teste");
        when(recurso.getRespostaEsic()).thenReturn("teste");
        Mockito.doNothing().when(historicoTratamentoRecursoService).gerarHistoricoTratamento(recurso,1L);
        Mockito.doNothing().when(andamentoRecursoService).gerarAndamentoRecurso(recurso,false,"Recurso de 1ª encaminhado como proposta de resposta de Recurso");
        propostaRespostaRecursoService.enviar(propostaRespostaRecursoDTO);
    }

    @Test(expected = IntegracaoException.class)
    @SneakyThrows
    public void enviarIntegracaoException(){
        when(propostaRespostaRecursoDTO.getIdStatusSolicitacaoRecurso()).thenReturn(null);
        propostaRespostaRecursoService.enviar(propostaRespostaRecursoDTO);
    }

    @Test
    public void excluirRespostaRecurso() {
        when(recursoRepository.findById(1L)).thenReturn(recurso);
        when(recursoRepository.save(recurso)).thenReturn(recurso);
        propostaRespostaRecursoService.excluirRespostaRecurso(1L);
    }

    @Test
    @SneakyThrows
    public void salvarIF() {
        when(propostaRespostaRecursoDTO.getIdRecurso()).thenReturn(1L);
        when(recursoRepository.findById(1L)).thenReturn(recurso);
        when(propostaRespostaRecursoDTO.getPropostaResposta()).thenReturn("teste");
        when(recurso.getRespostaEsic()).thenReturn("teste");
        when(propostaRespostaRecursoDTO.getPropostaResposta()).thenReturn("teste");
        Mockito.doNothing().when(historicoTratamentoRecursoService).gerarHistoricoTratamento(recurso,2L);
        when(recursoRepository.save(recurso)).thenReturn(recurso);
        propostaRespostaRecursoService.salvar(propostaRespostaRecursoDTO);
    }

    @Test
    @SneakyThrows
    public void salvarELSE() {
        when(propostaRespostaRecursoDTO.getIdRecurso()).thenReturn(1L);
        when(recursoRepository.findById(1L)).thenReturn(recurso);
        when(propostaRespostaRecursoDTO.getPropostaResposta()).thenReturn("teste");
        when(recurso.getRespostaEsic()).thenReturn(null);
        when(propostaRespostaRecursoDTO.getPropostaResposta()).thenReturn("teste");
        Mockito.doNothing().when(historicoTratamentoRecursoService).gerarHistoricoTratamento(recurso,1L);
        when(recursoRepository.save(recurso)).thenReturn(recurso);
        propostaRespostaRecursoService.salvar(propostaRespostaRecursoDTO);
    }

    @Test
    public void buscarResposta() {
        when(recursoRepository.findById(1L)).thenReturn(recurso);
        when(recurso.getPropostaResposta()).thenReturn("teste");
        propostaRespostaRecursoService.buscarResposta(1L);
    }

    @Test
    public void buscarinstancia(){
        InstanciaRecurso instanciaRecurso = new InstanciaRecurso();
        Recurso recurso = new Recurso();
        recurso.getInstanciaRecurso();
        recurso.setInstanciaRecurso(instanciaRecurso);
        recurso.getId();
        recurso.setId(1L);
        when(recursoRepository.findById(anyLong())).thenReturn(recurso);
        propostaRespostaRecursoService.buscarinstancia(1L);

    }
}