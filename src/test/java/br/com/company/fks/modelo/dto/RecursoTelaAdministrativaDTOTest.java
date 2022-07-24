package br.com.company.fks.modelo.dto;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class RecursoTelaAdministrativaDTOTest {
    @InjectMocks
    private RecursoTelaAdministrativaDTO dto;

    @Test
    public void RecursoTelaAdministrativaDTO(){
        StatusSolicitacaoRecursoDTO statusSolicitacaoRecursoDTO = new StatusSolicitacaoRecursoDTO();
        StatusTramitacaoRecursoDTO statusTramitacaoRecursoDTO = new StatusTramitacaoRecursoDTO();
        UnidadeDTO unidadeDTO = new UnidadeDTO();
        SubunidadeTelaAdministrativaDTO subunidadeTelaAdministrativaDTO = new SubunidadeTelaAdministrativaDTO();
        dto.getIdRecurso();
        dto.setIdRecurso(1L);
        dto.getStatusSolicitacaoRecursoDTO();
        dto.setStatusSolicitacaoRecursoDTO(statusSolicitacaoRecursoDTO);
        dto.getStatusTramitacaoRecursoDTO();
        dto.setStatusTramitacaoRecursoDTO(statusTramitacaoRecursoDTO);
        dto.getUnidadeDTO();
        dto.setUnidadeDTO(unidadeDTO);
        dto.getSubunidadeTelaAdministrativaDTO();
        dto.setSubunidadeTelaAdministrativaDTO(subunidadeTelaAdministrativaDTO);
        dto.getNomeUsuario();
        dto.setNomeUsuario("nomeUsuario");
    }

}