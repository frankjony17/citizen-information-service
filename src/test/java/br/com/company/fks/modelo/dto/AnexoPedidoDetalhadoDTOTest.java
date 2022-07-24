package br.com.company.fks.modelo.dto;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class AnexoPedidoDetalhadoDTOTest {

    @InjectMocks
    private AnexoPedidoDetalhadoDTO dto;

    @Test
    public void AnexoPedidoDetalhadoDTO(){
        dto.getNome();
        dto.setNome("nome");
    }
}