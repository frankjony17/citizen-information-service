package br.com.company.fks.modelo.dto;

import br.com.company.fks.modelo.Subunidade;
import br.com.company.fks.modelo.Unidade;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class RespostaAssinadaDTOTest {
    @InjectMocks
    private RespostaAssinadaDTO dto;
    @Test
    public void RespostaAssinadaDTO(){
        Unidade unidade = new Unidade();
        Subunidade subunidade = new Subunidade();
        dto.getIdStatusSolicitacao();
        dto.setIdStatusSolicitacao(1L);
        dto.getObservacao();
        dto.setObservacao("observacao");
        dto.getNomeStatusSolicitacao();
        dto.setNomeStatusSolicitacao("nomeStatusSolicitacao");
        dto.getPropostaResposta();
        dto.setPropostaResposta("propostaResposta");
        dto.getIdPedido();
        dto.setIdPedido(1L);
        dto.getNomeStatusSolicitacaoPedido();
        dto.setNomeStatusSolicitacaoPedido("nomeStatusSolicitacaoPedido");
        dto.getUnidade();
        dto.setUnidade(unidade);
        dto.getSubunidade();
        dto.setSubunidade(subunidade);
    }

}