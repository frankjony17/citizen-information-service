package br.com.company.fks.modelo.dto;

import br.com.company.fks.modelo.Subunidade;
import br.com.company.fks.modelo.Unidade;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class PerfilDTOTest {
    @InjectMocks
    private PerfilDTO dto;

    @Test
    public void PerfilDTO(){
        Unidade unidade = new Unidade();
        List<Subunidade> subunidades = new ArrayList<>();
        dto.getId();
        dto.setId(1L);
        dto.getNome();
        dto.setNome("nome");
        dto.getDescricao();
        dto.setDescricao("descricao");
        dto.getUnidade();
        dto.setUnidade(unidade);
        dto.getExcluido();
        dto.setExcluido(true);
        dto.getExisteAcessos();
        dto.setExisteAcessos(true);
        dto.getSubunidades();
        dto.setSubunidades(subunidades);
    }

}