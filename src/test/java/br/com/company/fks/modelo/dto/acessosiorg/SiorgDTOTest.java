package br.com.company.fks.modelo.dto.acessosiorg;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class SiorgDTOTest {

    @InjectMocks
    private SiorgDTO dto;

    @Test
    public void SiorgDTO(){
        List<UnidadeSiorgDTO> unidades = new ArrayList<>();
        dto.getUnidades();
        dto.setUnidades(unidades);
    }

}