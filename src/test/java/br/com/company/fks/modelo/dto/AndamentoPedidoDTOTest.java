package br.com.company.fks.modelo.dto;

import br.com.company.fks.modelo.Unidade;
import org.junit.Test;
import org.mockito.Mock;

import java.util.Calendar;

import static org.junit.Assert.assertEquals;

public class AndamentoPedidoDTOTest {

    private Calendar calendar = Calendar.getInstance();

    @Mock
    private Unidade unidade;

    @Test
    public void AndamentoPedidoDTOTest() {
        AndamentoPedidoDTO andamentoPedidoDTO = new AndamentoPedidoDTO(calendar, calendar, "Teste", "Teste", "Teste", "Teste");
        assertEquals(calendar, andamentoPedidoDTO.getDataInicio());
        assertEquals(calendar, andamentoPedidoDTO.getDataFim());
        assertEquals("Teste", andamentoPedidoDTO.getResponsavel());
        assertEquals("Teste", andamentoPedidoDTO.getObservacao());
        assertEquals("Teste", andamentoPedidoDTO.getStatusTramitacao());
    }

}
