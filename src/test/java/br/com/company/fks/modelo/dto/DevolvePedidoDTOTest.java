package br.com.company.fks.modelo.dto;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class DevolvePedidoDTOTest {
    @InjectMocks
    private DevolvePedidoDTO dto;

    @Test
    public void DevolvePedidoDTO(){
        dto.getIdPedido();
        dto.setIdPedido(1L);
        dto.getJustificativa();
        dto.setJustificativa("justificativa");
        dto.getNomeStatusSolicitacao();
        dto.setNomeStatusSolicitacao("nomeStatusSolicitacao");
    }

}