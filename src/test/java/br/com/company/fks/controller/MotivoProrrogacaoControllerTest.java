package br.com.company.fks.controller;

import br.com.company.fks.modelo.dto.MotivoProrrogacaoDTO;
import br.com.company.fks.servico.MotivoProrrogacaoService;
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
public class MotivoProrrogacaoControllerTest {

    @InjectMocks
    private MotivoProrrogacaoController motivoProrrogacaoController;

    @Mock
    private MotivoProrrogacaoService motivoProrrogacaoService;

    @Test
    public void consultaStatusSolicitacaoTest() throws Exception {

        when(motivoProrrogacaoService.consultarMotivoProrrogacao()).thenReturn(Collections.emptyList());
        ResponseEntity<List<MotivoProrrogacaoDTO>> retorno = motivoProrrogacaoController.consultaMotivoProrrogacao();
        assertEquals(HttpStatus.OK, retorno.getStatusCode());
    }


}
