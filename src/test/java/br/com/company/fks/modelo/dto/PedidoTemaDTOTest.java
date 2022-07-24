package br.com.company.fks.modelo.dto;

import br.com.company.fks.modelo.PalavraChave;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class PedidoTemaDTOTest {
    @InjectMocks
    private PedidoTemaDTO dto;

    @Test
    public void PedidoTemaDTO(){
        List<SubtemaDTO> subtemaDTO = new ArrayList<>();
        List<PalavraChave> palavrasChaves = new ArrayList<>();
        dto.getIdPedido();
        dto.setIdPedido(1L);
        dto.getIdTema();
        dto.setIdTema(1L);
        dto.getSubtemaDTO();
        dto.setSubtemaDTO(subtemaDTO);
        dto.getPalavrasChaves();
        dto.setPalavrasChaves(palavrasChaves);
    }
}