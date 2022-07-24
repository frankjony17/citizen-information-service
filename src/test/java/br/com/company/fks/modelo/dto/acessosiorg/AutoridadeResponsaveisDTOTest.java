package br.com.company.fks.modelo.dto.acessosiorg;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class AutoridadeResponsaveisDTOTest {

    @InjectMocks
    private AutoridadeResponsaveisDTO dto;

    @Test
    public void AutoridadeResponsaveisDTO(){
        UsuarioSiapeAcessoDTO usuarioAutoridadeHierarquica = new UsuarioSiapeAcessoDTO();
        UsuarioSiapeAcessoDTO usuarioAutoridadeMaxima = new UsuarioSiapeAcessoDTO();
        ResponsaveisDTO responsavelRecurso = new ResponsaveisDTO();
        dto.getUsuarioAutoridadeHierarquica();
        dto.setUsuarioAutoridadeHierarquica(usuarioAutoridadeHierarquica);
        dto.getUsuarioAutoridadeMaxima();
        dto.setUsuarioAutoridadeMaxima(usuarioAutoridadeMaxima);
        dto.getResponsavelRecurso();
        dto.setResponsavelRecurso(responsavelRecurso);
    }

}