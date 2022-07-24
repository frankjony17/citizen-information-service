package br.com.company.fks.modelo.dto;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class AlertaDTOTest {

    @InjectMocks
    private AlertaDTO dto;

    @Test
    public void AlertaDTO(){
        dto.getId();
        dto.setId(1L);
        dto.getAlerta();
        dto.setAlerta("alerta");
    }
}