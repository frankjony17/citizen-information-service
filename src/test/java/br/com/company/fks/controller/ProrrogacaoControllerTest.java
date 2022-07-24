package br.com.company.fks.controller;

import br.com.company.fks.excecao.IntegracaoException;
import br.com.company.fks.modelo.dto.ProrrogacaoCadastroDTO;
import br.com.company.fks.servico.ProrrogacaoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class ProrrogacaoControllerTest {

    @InjectMocks
    private ProrrogacaoController prorrogacaoController;

    @Mock
    private ProrrogacaoService prorrogacaoService;

    @Mock
    private ProrrogacaoCadastroDTO prorrogacaoCadastroDTO;



    @Test
    public void salvar() throws IntegracaoException {
        Mockito.doNothing().when(prorrogacaoService).criarProrrogacao(any(ProrrogacaoCadastroDTO.class));
        prorrogacaoController.salvar(prorrogacaoCadastroDTO);

    }

    @Test
    public void salvarTestCatch() throws IntegracaoException {
        Mockito.doThrow(IntegracaoException.class).when(prorrogacaoService).criarProrrogacao(any(ProrrogacaoCadastroDTO.class));
        prorrogacaoController.salvar(prorrogacaoCadastroDTO);

    }

    @Test
    public void consultarProrrogaoTest(){
        when(prorrogacaoService.consultarProrrogacao(anyLong())).thenReturn(prorrogacaoCadastroDTO);
        prorrogacaoController.consultarProrrogacao(5L);
    }

    @Test
    public void consultarProrrogaoESicTest(){
        when(prorrogacaoService.consultarProrrogacaoEsic(anyLong())).thenReturn(prorrogacaoCadastroDTO);
        prorrogacaoController.consultarProrrogacaoEsic(5L);
    }

}
