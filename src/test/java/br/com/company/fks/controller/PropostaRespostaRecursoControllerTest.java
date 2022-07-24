package br.com.company.fks.controller;

import br.com.company.fks.excecao.IntegracaoException;
import br.com.company.fks.modelo.dto.PropostaRespostaRecursoDTO;
import br.com.company.fks.modelo.dto.RespostaDTO;
import br.com.company.fks.servico.HistoricoTratamentoRecursoService;
import br.com.company.fks.servico.PropostaRespostaRecursoService;
import lombok.SneakyThrows;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.when;

/**
 * Created by Maicon Godoy - FKSolutions Tecnologia on 14/08/18.
 */
@RunWith(MockitoJUnitRunner.class)
public class PropostaRespostaRecursoControllerTest {
    @InjectMocks
    private PropostaRespostaRecursoController propostaRespostaRecursoController;
    @Mock
    private PropostaRespostaRecursoService propostaRespostaRecursoService;
    @Mock
    private PropostaRespostaRecursoDTO propostaRespostaRecursoDTO;
    @Mock
    private RespostaDTO respostaDTO;
    @Mock
    private HistoricoTratamentoRecursoService historicoTratamentoRecursoService;

    @Test
    @SneakyThrows
    public void enviar() {
        Mockito.doNothing().when(propostaRespostaRecursoService).enviar(propostaRespostaRecursoDTO);
        propostaRespostaRecursoController.enviar(propostaRespostaRecursoDTO);
    }

    @Test
    @SneakyThrows
    public void enviarCatch() {
        Mockito.doThrow(IntegracaoException.class).when(propostaRespostaRecursoService).enviar(propostaRespostaRecursoDTO);
        propostaRespostaRecursoController.enviar(propostaRespostaRecursoDTO);
    }

    @Test
    public void excluirRespostaFKS() {
        Mockito.doNothing().when(propostaRespostaRecursoService).excluirRespostaRecurso(anyLong());
        propostaRespostaRecursoController.excluirRespostaFKS(1L);
    }

    @Test
    @SneakyThrows
    public void salvar() {
        Mockito.doNothing().when(propostaRespostaRecursoService).salvar(propostaRespostaRecursoDTO);
        propostaRespostaRecursoController.salvar(propostaRespostaRecursoDTO);
    }

    @Test
    @SneakyThrows
    public void salvarCatch() {
        Mockito.doThrow(IntegracaoException.class).when(propostaRespostaRecursoService).salvar(propostaRespostaRecursoDTO);
        propostaRespostaRecursoController.salvar(propostaRespostaRecursoDTO);
    }

    @Test
    public void buscarResposta() {
        when(historicoTratamentoRecursoService.recuperarRespostaRecurso(1L)).thenReturn("teste");
        propostaRespostaRecursoController.buscarResposta(1L);
    }

    @Test
    public void buscainstancia() {
        when(propostaRespostaRecursoService.buscarinstancia(anyLong())).thenReturn(20L);
        ResponseEntity<?> response = propostaRespostaRecursoController.buscainstancia(1L);
        Assert.assertEquals(response.getBody(), 20L);
    }
}