package br.com.company.fks.controller;


import br.com.company.fks.excecao.IntegracaoException;
import br.com.company.fks.modelo.EOuv;
import br.com.company.fks.modelo.Pedido;
import br.com.company.fks.modelo.dto.EouvDTO;
import br.com.company.fks.servico.EouvService;
import br.com.company.fks.servico.PedidoService;
import br.com.company.fks.utils.EntityConverter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class EouvControllerTest {

    @InjectMocks
    private  EouvController eouvController;

    @Mock
    private EouvService eouvService;

    @Mock
    private Pedido pedido;

    @Mock
    private PedidoService pedidoService;

    @Mock
    private EntityConverter entityConverter;
    
    @Mock
    private EouvDTO eouvDTO;


    @Test
    public void salvarComSucesso() {
        when(entityConverter.converterStrict(any(EOuv.class), eq(EouvDTO.class))).thenReturn(eouvDTO);
        ResponseEntity<?> response = eouvController.salvar(eouvDTO);
        assertNotNull(response);
    }
    @Test
    public  void finalizarEouvTry() throws Exception {
        when(pedidoService.alterarStatusFinalizarEouv(anyLong())).thenReturn(pedido);
        ResponseEntity<?> response = eouvController.finalizarEouv(5L);
        assertNotNull(response);

    }

    @Test
    public  void finalizarEouvCatch() throws Exception {
        Mockito.doThrow(IntegracaoException.class).when(pedidoService).alterarStatusFinalizarEouv(anyLong());
        ResponseEntity<?> response = eouvController.finalizarEouv(5L);
        assertNotNull(response);


    }

    @Test
    public void buscarPalavraChavePedido(){
        assertNotNull(eouvController.buscarPalavraChavePedido(1L));
    }

    @Test
    public void validarEouv(){
        assertNotNull(eouvController.validarEouv(1L));
    }
}
