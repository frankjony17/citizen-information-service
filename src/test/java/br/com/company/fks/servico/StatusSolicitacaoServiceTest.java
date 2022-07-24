package br.com.company.fks.servico;

import br.com.company.fks.modelo.StatusSolicitacao;
import br.com.company.fks.modelo.dto.StatusSolicitacaoDTO;
import br.com.company.fks.repositorio.StatusSolicitacaoRepository;
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
public class StatusSolicitacaoServiceTest {

    @InjectMocks
    private StatusSolicitacaoService statusSolicitacaoService;

    @Mock
    private StatusSolicitacaoRepository statusSolicitacaoRepository;

    @Test
    public void consultarStatusSolicitacaoTest() {
        List<StatusSolicitacao> statusSolicitacaoList = new ArrayList<>();
        statusSolicitacaoList.add(new StatusSolicitacao());

        when(statusSolicitacaoRepository.findAll()).thenReturn(statusSolicitacaoList);

        List<StatusSolicitacaoDTO> retorno = statusSolicitacaoService.consultarStatusSolicitacao();

        assertEquals(1, retorno.size());
    }
}
