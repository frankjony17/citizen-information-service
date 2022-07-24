package br.com.company.fks.controller;

import br.com.company.fks.modelo.dto.StatusSolicitacaoDTO;
import br.com.company.fks.servico.StatusSolicitacaoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class StatusSolicitacaoControllerTest {

    @Mock
    private StatusSolicitacaoService statusSolicitacaoService;

    @InjectMocks
    private StatusSolicitacaoController statusSolicitacaoController;


    @Test
    public void consultaStatusSolicitacaoTest() throws Exception {

        when(statusSolicitacaoService.consultarStatusSolicitacao()).thenReturn(Collections.emptyList());
        ResponseEntity<List<StatusSolicitacaoDTO>> retorno = statusSolicitacaoController.consultaStatusSolicitacao();
        assertEquals(HttpStatus.OK, retorno.getStatusCode());
    }


}
