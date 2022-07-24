package br.com.company.fks.modelo.dto;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class AlteracaoPedidoRecursoDTOTest {
    @InjectMocks
    private AlteracaoPedidoRecursoDTO dto;

    @Test
    public void AlteracaoPedidoRecursoDTO(){
        dto.getIdPedido();
        dto.setIdPedido(1L);
        dto.getIdStatusSolicitacao();
        dto.setIdStatusSolicitacao(1L);
        dto.getJustificativa();
        dto.setJustificativa("justificativa");
        dto.getIsPedido();
        dto.setIsPedido(true);
    }

}