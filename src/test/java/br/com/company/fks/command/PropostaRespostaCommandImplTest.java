package br.com.company.fks.command;

import br.com.company.fks.modelo.Pedido;
import br.com.company.fks.modelo.StatusSolicitacao;
import br.com.company.fks.modelo.StatusTramitacao;
import br.com.company.fks.modelo.dto.PropostaRespostaDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.powermock.api.mockito.PowerMockito.when;

@RunWith(PowerMockRunner.class)
public class PropostaRespostaCommandImplTest {

    @InjectMocks
    private PropostaRespostaCommandImpl propostaRespostaCommand;

    @Mock
    private StatusSolicitacao statusSolicitacao;

    @Mock
    private Pedido pedido;

    @Mock
    private PropostaRespostaDTO propostaRespostaDTO;

    @Mock
    private StatusTramitacao statusTramitacao;

    @Test
    public void setarStatusSolicitacaoCase1(){
        when(pedido.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(statusSolicitacao.getId()).thenReturn(2L);
        when(pedido.getStatusTramitacao()).thenReturn(statusTramitacao);
        when(statusTramitacao.getId()).thenReturn(2L);
        propostaRespostaCommand.setarStatusSolicitacao(2L, pedido, propostaRespostaDTO);
    }

    @Test
    public void setarStatusSolicitacaoCase2(){
        when(pedido.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(statusSolicitacao.getId()).thenReturn(3L);
        when(pedido.getStatusTramitacao()).thenReturn(statusTramitacao);
        when(statusTramitacao.getId()).thenReturn(3L);
        propostaRespostaCommand.setarStatusSolicitacao(3L, pedido, propostaRespostaDTO);
    }@Test
    public void setarStatusSolicitacaoCase3(){
        when(pedido.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(statusSolicitacao.getId()).thenReturn(7L);
        when(pedido.getStatusTramitacao()).thenReturn(statusTramitacao);
        when(statusTramitacao.getId()).thenReturn(7L);
        propostaRespostaCommand.setarStatusSolicitacao(7L, pedido, propostaRespostaDTO);
    }

    @Test
    public void setarStatusSolicitacaoCase4(){
        when(pedido.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(statusSolicitacao.getId()).thenReturn(8L);
        when(pedido.getStatusTramitacao()).thenReturn(statusTramitacao);
        when(statusTramitacao.getId()).thenReturn(8L);
        propostaRespostaCommand.setarStatusSolicitacao(8L, pedido, propostaRespostaDTO);
    }

    @Test
    public void setarStatusSolicitacaoCase5(){
        when(pedido.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(statusSolicitacao.getId()).thenReturn(9L);
        when(pedido.getStatusTramitacao()).thenReturn(statusTramitacao);
        when(statusTramitacao.getId()).thenReturn(9L);
        propostaRespostaCommand.setarStatusSolicitacao(9L, pedido, propostaRespostaDTO);
    }

    @Test
    public void setarStatusSolicitacaoCase6(){
        when(pedido.getStatusSolicitacao()).thenReturn(statusSolicitacao);
        when(statusSolicitacao.getId()).thenReturn(5L);
        when(pedido.getStatusTramitacao()).thenReturn(statusTramitacao);
        when(statusTramitacao.getId()).thenReturn(5L);
        propostaRespostaCommand.setarStatusSolicitacao(5L, pedido, propostaRespostaDTO);
    }
}