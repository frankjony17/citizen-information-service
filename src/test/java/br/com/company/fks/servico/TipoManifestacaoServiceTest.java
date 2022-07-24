package br.com.company.fks.servico;

import br.com.company.fks.modelo.TipoManifestacao;
import br.com.company.fks.repositorio.TipoManifestacaoRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)

public class TipoManifestacaoServiceTest {
    @InjectMocks
    private TipoManifestacaoService tipoManifestacaoService;
    @Mock
    private TipoManifestacaoRepository tipoManifestacaoRepository;
    @Mock
    private List<TipoManifestacao> tipoManifestacaoList;

    @Test
    public void buscaTodosTipoManifestacaoTest(){
        when(tipoManifestacaoRepository.findAllOrderByNome()).thenReturn(tipoManifestacaoList);
        assertEquals(tipoManifestacaoService.buscaTodosTipoManifestacao(),tipoManifestacaoList);
    }


}
