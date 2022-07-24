package br.com.company.fks.controller;

import br.com.company.fks.modelo.dto.StatusSituacaoDTO;
import br.com.company.fks.servico.StatusSituacaoService;
import io.jsonwebtoken.lang.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class StatusSituacaoControllerTest {

    @InjectMocks
    private StatusSituacaoController statusSituacaoController;

    @Mock
    private StatusSituacaoService statusSituacaoService;

    @Mock
    private List<StatusSituacaoDTO> listaStatusSituacaoDTO;

    @Test
    public void consultaStatusTramitacao() {
        when(statusSituacaoService.consultarStatusSituacao()).thenReturn(listaStatusSituacaoDTO);
        Assert.notNull(statusSituacaoController.consultaStatusTramitacao());
    }
}
