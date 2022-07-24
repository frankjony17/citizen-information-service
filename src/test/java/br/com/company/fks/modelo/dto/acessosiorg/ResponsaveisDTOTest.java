package br.com.company.fks.modelo.dto.acessosiorg;

import org.apache.xpath.operations.String;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class ResponsaveisDTOTest {

    @InjectMocks
    private ResponsaveisDTO dto;

    @Test
    public void ResponsaveisDTO(){
        dto.getId();
        dto.setId(1L);
        dto.getResponsavelRecursoTerceiraInstancia();
        dto.setResponsavelRecursoTerceiraInstancia("responsavelRecursoTerceiraInstancia");
        dto.getResponsavelRecursoQuartaInstancia();
        dto.setResponsavelRecursoQuartaInstancia("responsavelRecursoQuartaInstancia");
        dto.getResponsavelRecursoAcao();
        dto.setResponsavelRecursoAcao("responsavelRecursoAcao");
    }
}