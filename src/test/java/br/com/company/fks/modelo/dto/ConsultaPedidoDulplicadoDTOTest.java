package br.com.company.fks.modelo.dto;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.*;

@RunWith(PowerMockRunner.class)
public class ConsultaPedidoDulplicadoDTOTest {

    @InjectMocks
    private ConsultaPedidoDulplicadoDTO consultaPedidoDulplicadoDTO;

    @Test
    public void getIdPedido() {
        consultaPedidoDulplicadoDTO.getIdPedido();
    }

    @Test
    public void getProtocolo() {
        consultaPedidoDulplicadoDTO.getProtocolo();
    }

    @Test
    public void getNomeStatusSolicitacao() {
        consultaPedidoDulplicadoDTO.getNomeStatusSolicitacao();
    }

    @Test
    public void getDataVencimentoESic() {
        consultaPedidoDulplicadoDTO.getDataVencimentoESic();
    }

    @Test
    public void setIdPedido() {
        consultaPedidoDulplicadoDTO.setIdPedido(1L);
    }

    @Test
    public void setProtocolo() {
        consultaPedidoDulplicadoDTO.setProtocolo("protocolo");
    }

    @Test
    public void setNomeStatusSolicitacao() {
        consultaPedidoDulplicadoDTO.setNomeStatusSolicitacao("nomeStatusSolicitacao");
    }
}