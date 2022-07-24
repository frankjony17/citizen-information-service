package br.com.company.fks.modelo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class ArquivoTest {
    @InjectMocks
    private Arquivo arquivo;

    @Test
    public void arquivoTest(){
        arquivo.getId();
        arquivo.setId(1L);
    }

}