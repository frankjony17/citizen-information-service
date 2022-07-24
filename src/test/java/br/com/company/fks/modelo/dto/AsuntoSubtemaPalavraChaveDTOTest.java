package br.com.company.fks.modelo.dto;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class AsuntoSubtemaPalavraChaveDTOTest {

    @InjectMocks
    private AsuntoSubtemaPalavraChaveDTO dto;

    @Test
    public void AsuntoSubtemaPalavraChaveDTO(){
        TemaDTO tema = new TemaDTO();
        List<SubtemaDTO> subtema = new ArrayList<>();
        dto.getTema();
        dto.setTema(tema);
        dto.getSubtema();
        dto.setSubtema(subtema);
    }

}