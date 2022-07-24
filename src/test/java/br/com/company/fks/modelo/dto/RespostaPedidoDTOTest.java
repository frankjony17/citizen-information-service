package br.com.company.fks.modelo.dto;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class RespostaPedidoDTOTest {
    @InjectMocks
    private RespostaPedidoDTO dto;

    @Test
    public void RespostaPedidoDTO(){
        dto.getIdPedido();
        dto.setIdPedido(1L);
        dto.getRespostaPedido();
        dto.setRespostaPedido("respostaPedido");
    }

}