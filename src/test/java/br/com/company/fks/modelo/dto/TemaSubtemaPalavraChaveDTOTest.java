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
public class TemaSubtemaPalavraChaveDTOTest {
    @InjectMocks
    private TemaSubtemaPalavraChaveDTO dto;

    @Test
    public void TemaSubtemaPalavraChaveDTO(){
        TemaDTO tema = new TemaDTO();
        List<SubtemaDTO> subtema = new ArrayList<>();
        List<PalavraChave> palavraChaveList = new ArrayList<>();
        dto.getTema();
        dto.setTema(tema);
        dto.getSubtema();
        dto.setSubtema(subtema);
        dto.getPalavraChaveList();
        dto.setPalavraChaveList(palavraChaveList);
    }

}