package br.com.company.fks.controller;

import br.com.company.fks.modelo.dto.StatusTramitacaoDTO;
import br.com.company.fks.servico.StatusTramitacaoService;
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
public class StatusTramitacaoControllerTest {

    @Mock
    private StatusTramitacaoService statusTramitacaoService;

    @InjectMocks
    private StatusTramitacaoController statusTramitacaoController;


    @Test
    public void consultaStatusTramitacaoTest() throws Exception {
        when(statusTramitacaoService.consultarStatusTramitacao()).thenReturn(Collections.emptyList());

        ResponseEntity<List<StatusTramitacaoDTO>> retorno = statusTramitacaoController.consultaStatusTramitacao();

        assertEquals(HttpStatus.OK, retorno.getStatusCode());
    }

}
