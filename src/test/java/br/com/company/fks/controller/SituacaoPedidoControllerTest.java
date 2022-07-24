package br.com.company.fks.controller;

import br.com.company.fks.modelo.dto.SituacaoPedidoDTO;
import br.com.company.fks.servico.SituacaoPedidoService;
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
public class SituacaoPedidoControllerTest {

    @InjectMocks
    private SituacaoPedidoController situacaoPedidoController;

    @Mock
    private SituacaoPedidoService situacaoPedidoService;


    @Test
    public void consultaSituacaoTest() throws Exception {
        when(situacaoPedidoService.consultarSituacaoPedido()).thenReturn(Collections.emptyList());

        ResponseEntity<List<SituacaoPedidoDTO>> retorno = situacaoPedidoController.consultaSituacaoPedido();

        assertEquals(HttpStatus.OK, retorno.getStatusCode());
    }

}
