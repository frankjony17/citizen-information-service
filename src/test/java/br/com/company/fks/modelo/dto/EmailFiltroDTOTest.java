package br.com.company.fks.modelo.dto;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class EmailFiltroDTOTest {
    @InjectMocks
    private EmailFiltroDTO dto;

    @Test
    public void EmailFiltroDTO(){
        List<PerfilDTO> destinatarios = new ArrayList<>();
        dto.getLimit();
        dto.setLimit(1);
        dto.getOffset();
        dto.setOffset(1);
        dto.getTipoSolicitacao();
        dto.setTipoSolicitacao(1);
        dto.getTipoAlerta();
        dto.setTipoAlerta(1);
        dto.getAssuntoEmail();
        dto.setAssuntoEmail("assuntoEmail");
        dto.getDestinatarios();
        dto.setDestinatarios(destinatarios);
    }

}