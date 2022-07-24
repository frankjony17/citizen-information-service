package br.com.company.fks.modelo.dto;

import br.com.company.fks.modelo.Subtema;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class PedidoTelaAdministrativaDTOTest {
    @InjectMocks
    private PedidoTelaAdministrativaDTO dto;

    @Test
    public void PedidoTelaAdministrativaDTO(){
        TemaDTO temaDTO = new TemaDTO();
        List<Subtema> subtemas = new ArrayList<>();
        StatusSolicitacaoDTO statusSolicitacaoDTO = new StatusSolicitacaoDTO();
        StatusTramitacaoDTO statusTramitacaoDTO = new StatusTramitacaoDTO();
        UnidadeDTO unidadeDTO = new UnidadeDTO();
        SubunidadeTelaAdministrativaDTO subunidadeTelaAdministrativaDTO = new SubunidadeTelaAdministrativaDTO();
        dto.getTemaDTO();
        dto.setTemaDTO(temaDTO);
        dto.getSubtemas();
        dto.setSubtemas(subtemas);
        dto.getStatusSolicitacaoDTO();
        dto.setStatusSolicitacaoDTO(statusSolicitacaoDTO);
        dto.getStatusTramitacaoDTO();
        dto.setStatusTramitacaoDTO(statusTramitacaoDTO);
        dto.getUnidadeDTO();
        dto.setUnidadeDTO(unidadeDTO);
        dto.getSubunidadeTelaAdministrativaDTO();
        dto.setSubunidadeTelaAdministrativaDTO(subunidadeTelaAdministrativaDTO);
        dto.getNomeUsuario();
        dto.setNomeUsuario("nomeUsuario");
        dto.getIdPedido();
        dto.setIdPedido(1L);
    }

}