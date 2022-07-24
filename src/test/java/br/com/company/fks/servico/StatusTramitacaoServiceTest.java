package br.com.company.fks.servico;

import br.com.company.fks.modelo.StatusTramitacao;
import br.com.company.fks.modelo.dto.StatusTramitacaoDTO;
import br.com.company.fks.repositorio.StatusTramitacaoRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

/**
 * Created by christian-tavares on 21/03/18.
 */
@RunWith(MockitoJUnitRunner.class)
public class StatusTramitacaoServiceTest {

    @InjectMocks
    private StatusTramitacaoService statusTramitacaoService;

    @Mock
    private StatusTramitacaoRepository statusTramitacaoRepository;

    @Test
    public void consultarStatusTramitacaoTest() {
        List<StatusTramitacao> statusTramitacaoList = new ArrayList<>();
        statusTramitacaoList.add(new StatusTramitacao());

        when(statusTramitacaoRepository.findAll()).thenReturn(statusTramitacaoList);

        List<StatusTramitacaoDTO> retorno = statusTramitacaoService.consultarStatusTramitacao();

        assertEquals(1, retorno.size());
    }
}
