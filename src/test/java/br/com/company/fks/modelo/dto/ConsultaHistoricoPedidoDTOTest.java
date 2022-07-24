package br.com.company.fks.modelo.dto;

import org.junit.Test;

import java.util.Calendar;

import static org.junit.Assert.assertEquals;

public class ConsultaHistoricoPedidoDTOTest {

    private Calendar calendar = Calendar.getInstance();

    @Test
    public void consultaHistoricoPedidoTest() {
        ConsultaHistoricoPedidoDTO consultaHistoricoPedidoDTO = new ConsultaHistoricoPedidoDTO(1L, calendar, "Teste", "Teste");
        assertEquals(calendar, consultaHistoricoPedidoDTO.getData());
        assertEquals("Teste", consultaHistoricoPedidoDTO.getNomeResponsavel());
        assertEquals("Teste", consultaHistoricoPedidoDTO.getTipoTratamento());
        consultaHistoricoPedidoDTO.getIdTipoTratamento();
        consultaHistoricoPedidoDTO.setIdTipoTratamento(1L);
        consultaHistoricoPedidoDTO.getResposta();
        consultaHistoricoPedidoDTO.setResposta("resposta");
    }

}
