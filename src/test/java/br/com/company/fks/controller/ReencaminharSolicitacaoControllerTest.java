package br.com.company.fks.controller;

import br.com.company.fks.modelo.ReencaminharSolicitacao;
import br.com.company.fks.modelo.dto.ReencaminharSolicitacaoDTO;
import br.com.company.fks.servico.ReencaminharSolicitacaoService;
import br.com.company.fks.utils.EntityConverter;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ReencaminharSolicitacaoControllerTest {
    @InjectMocks
    private ReencaminharSolicitacaoController reencaminharSolicitacaoController;
    @Mock
    private ReencaminharSolicitacaoService reencaminharSolicitacaoService;
    @Mock
    private EntityConverter entityConverter;
    @Mock
    private ReencaminharSolicitacao reencaminharSolicitacao;
    @Mock
    private ReencaminharSolicitacaoDTO reencaminharSolicitacaoDTO;


    @Test
    public void salvarTest(){
        when(entityConverter.converterStrict(reencaminharSolicitacaoDTO,ReencaminharSolicitacao.class)).thenReturn(reencaminharSolicitacao);
        Mockito.doNothing().when(reencaminharSolicitacaoService).salvar(any(ReencaminharSolicitacaoDTO.class));
        reencaminharSolicitacaoController.salvar(reencaminharSolicitacaoDTO);


    }
    @Test
    public void buscarReencaminhamentoParaOrgao(){
        when(reencaminharSolicitacaoService.buscarReencaminhamentoParaOrgao(anyLong())).thenReturn(reencaminharSolicitacaoDTO);
        ResponseEntity<ReencaminharSolicitacaoDTO> response = reencaminharSolicitacaoController.buscarReencaminhamentoParaOrgao(1L);
        Assert.assertNotNull(response);
    }
}
