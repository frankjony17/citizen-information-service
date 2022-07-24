package br.com.company.fks.modelo.dto;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class GlossarioDeAssuntoDTOTest {
    @InjectMocks
    private GlossarioDeAssuntoDTO dto;

    @Test
    public void GlossarioDeAssuntoDTO(){
        List<SubtemaDTO> subtemas = new ArrayList<>();
        dto.getNomeTema();
        dto.setNomeTema("nomeTema");
        dto.getSubtemas();
        dto.setSubtemas(subtemas);
    }

}