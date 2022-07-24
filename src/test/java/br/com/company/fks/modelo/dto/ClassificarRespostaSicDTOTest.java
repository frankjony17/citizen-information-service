package br.com.company.fks.modelo.dto;

import br.com.company.fks.modelo.*;
import br.gov.mpog.fks.modelo.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class ClassificarRespostaSicDTOTest {

    @InjectMocks
    private ClassificarRespostaSicDTO dto;

    @Mock
    private Categoria categoria;

    @Test
    public void ClassificarRespostaSicDTO(){
        SubCategoria subCategoria = new SubCategoria();
        TipoResposta tipoResposta = new TipoResposta();
        ClassificacaoTipoResposta classificacaoTipoResposta = new ClassificacaoTipoResposta();
        List<PalavraChave> palavrasChaves = new ArrayList<>();
        dto.getSubcategoria();
        dto.setSubcategoria(subCategoria);
        dto.getTipoResposta();
        dto.setTipoResposta(tipoResposta);
        dto.getClassificacaoTipoResposta();
        dto.setClassificacaoTipoResposta(classificacaoTipoResposta);
        dto.getPalavrasChaves();
        dto.setPalavrasChaves(palavrasChaves);
        dto.getNumeroPagina();
        dto.setNumeroPagina(2L);
        dto.getRestricaoConteudo();
        dto.setRestricaoConteudo(true);
        dto.getId();
        dto.setId(1L);
        dto.getCategoria();
        dto.setCategoria(categoria);
    }

}