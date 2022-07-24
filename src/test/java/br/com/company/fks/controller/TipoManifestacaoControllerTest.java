package br.com.company.fks.controller;

import br.com.company.fks.controller.builder.Resposta;
import br.com.company.fks.modelo.TipoManifestacao;
import br.com.company.fks.modelo.dto.TipoManifestacaoDTO;
import br.com.company.fks.servico.TipoManifestacaoService;
import br.com.company.fks.utils.EntityConverter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TipoManifestacaoControllerTest {

    @InjectMocks
    private TipoManifestacaoController tipoManifestacaoController;

    @Mock
    private TipoManifestacaoService tipoManifestacaoService;

    @Mock
    private EntityConverter entityConverter;

    @Mock
    private TipoManifestacaoDTO tipoManifestacaoDTO;

    @Test
    public void buscarTodosTipoManifestacaoTest() throws Exception {
        when(tipoManifestacaoService.buscaTodosTipoManifestacao()).thenReturn(Collections.emptyList());
        when(entityConverter.converterStrict(any(TipoManifestacao.class), eq(TipoManifestacaoDTO.class))).thenReturn(tipoManifestacaoDTO);
        ResponseEntity<Resposta<List<TipoManifestacaoDTO>>> retorno = tipoManifestacaoController.buscarTodosTipoManifestacao();

        assertEquals(HttpStatus.OK, retorno.getStatusCode());
    }
}
