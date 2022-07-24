package br.com.company.fks.modelo.dto;

import br.com.company.fks.modelo.*;
import br.gov.mpog.fks.modelo.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class EouvDTOTest {

    @InjectMocks
    private EouvDTO dto;

    @Test
    public void EouvDTO(){
        TipoTratamento tipoTratamento = new TipoTratamento();
        TipoManifestacao tipoManifestacao = new TipoManifestacao();
        Categoria categoria = new Categoria();
        SubCategoria subCategoria = new SubCategoria();
        List<PalavraChave> palavraChave = new ArrayList<>();
        dto.getId();
        dto.setId(1L);
        dto.getIdPedido();
        dto.setIdPedido(1L);
        dto.getTipoTratamento();
        dto.setTipoTratamento(tipoTratamento);
        dto.getTipoManifestacao();
        dto.setTipoManifestacao(tipoManifestacao);
        dto.getCategoria();
        dto.setCategoria(categoria);
        dto.getSubcategoria();
        dto.setSubcategoria(subCategoria);
        dto.getPalavraChave();
        dto.setPalavraChave(palavraChave);
        dto.getAssinou();
        dto.setAssinou(true);
        dto.getRestricaoConteudo();
        dto.setRestricaoConteudo(true);
    }

}