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
public class SubtemaDTOTest {
    @InjectMocks
    private SubtemaDTO dto;

    @Test
    public void SubtemaDTO(){
        List<PalavraChave> palavrasChaves = new ArrayList<>();
        dto.getIdSubtemaDTO();
        dto.setIdSubtemaDTO(1L);
        dto.getNomeSubtema();
        dto.setNomeSubtema("nomeSubtema");
        dto.getPalavrasChaves();
        dto.setPalavrasChaves(palavrasChaves);
        dto.getNomeTema();
        dto.setNomeTema("nomeTema");
        dto.getClass();
    }



}