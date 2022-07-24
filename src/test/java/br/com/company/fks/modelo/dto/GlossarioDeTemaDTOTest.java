package br.com.company.fks.modelo.dto;

import br.com.company.fks.modelo.PalavraChave;
import br.com.company.fks.modelo.Tema;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class GlossarioDeTemaDTOTest {

    @InjectMocks
    private GlossarioDeTemaDTO dto;

    @Test
    public void GlossarioDeTemaDTO(){
        List<PalavraChave> palavrasChaves = new ArrayList<>();
        Tema tema = new Tema();
        dto.getId();
        dto.setId(1L);
        dto.getNomeSubtema();
        dto.setNomeSubtema("nomeSubtema");
        dto.getPalavrasChaves();
        dto.setPalavrasChaves(palavrasChaves);
        dto.getTema();
        dto.setTema(tema);
    }


}