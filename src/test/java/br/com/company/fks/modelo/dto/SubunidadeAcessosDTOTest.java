package br.com.company.fks.modelo.dto;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class SubunidadeAcessosDTOTest {
    @InjectMocks
    private SubunidadeAcessosDTO dto;

    @Test
    public void SubunidadeAcessosDTO(){
        dto.getCodigoSubunidade();
        dto.setCodigoSubunidade("codigoSubunidade");
        dto.getNomeSubunidade();
        dto.setNomeSubunidade("nomeSubunidade");
    }

}