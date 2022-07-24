package br.com.company.fks.command;

import br.com.company.fks.modelo.Pedido;
import br.com.company.fks.modelo.StatusSolicitacao;
import br.com.company.fks.modelo.StatusTramitacao;
import br.com.company.fks.modelo.dto.PropostaRespostaDTO;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class PropostaRespostaCommandImpl {
    private static final Map<Long, IPropostaRespostaStatusSolicitacaoCommand> STATUS_SOLICITACAO;

    static{
        final Map<Long, IPropostaRespostaStatusSolicitacaoCommand> status = new HashMap<>();

        status.put(StatusSolicitacao.RESPOSTA_SIC, new IPropostaRespostaStatusSolicitacaoCommand(){
            @Override
            public void setStatusSolicitacao(Pedido pedido, PropostaRespostaDTO propostaRespostaDTO){
                set(pedido, StatusSolicitacao.RESPOSTA_SIC, StatusTramitacao.RESPONDIDAS);
            }
        });

        status.put(StatusSolicitacao.DISTRIBUICAO_PF, new IPropostaRespostaStatusSolicitacaoCommand(){
            @Override
            public void setStatusSolicitacao(Pedido pedido, PropostaRespostaDTO propostaRespostaDTO){
                set(pedido, StatusSolicitacao.DISTRIBUICAO_PF, StatusTramitacao.ANDAMENTO);
            }
        });

        status.put(StatusSolicitacao.PRODUCAO_RESPOSTA, new IPropostaRespostaStatusSolicitacaoCommand(){
            @Override
            public void setStatusSolicitacao(Pedido pedido, PropostaRespostaDTO propostaRespostaDTO){
                set(pedido, StatusSolicitacao.PRODUCAO_RESPOSTA, StatusTramitacao.ANDAMENTO);
            }
        });

        status.put(StatusSolicitacao.EDICAO_TECNICO, new IPropostaRespostaStatusSolicitacaoCommand(){
            @Override
            public void setStatusSolicitacao(Pedido pedido, PropostaRespostaDTO propostaRespostaDTO){
                set(pedido, StatusSolicitacao.EDICAO_TECNICO, StatusTramitacao.ANDAMENTO);
            }
        });

        status.put(StatusSolicitacao.ENVIADA, new IPropostaRespostaStatusSolicitacaoCommand(){
            @Override
            public void setStatusSolicitacao(Pedido pedido, PropostaRespostaDTO propostaRespostaDTO){
                set(pedido, StatusSolicitacao.ENVIADA, StatusTramitacao.PARA_ENVIO);
            }
        });

        status.put(StatusSolicitacao.PARA_ENVIO, new IPropostaRespostaStatusSolicitacaoCommand(){
            @Override
            public void setStatusSolicitacao(Pedido pedido, PropostaRespostaDTO propostaRespostaDTO){
                set(pedido, StatusSolicitacao.PARA_ENVIO, StatusTramitacao.RESPONDIDAS);
            }
        });

        STATUS_SOLICITACAO = Collections.unmodifiableMap(status);
    }

    public void setarStatusSolicitacao(Long statusSolicitacao, Pedido pedido, PropostaRespostaDTO propostaRespostaDTO) {
        IPropostaRespostaStatusSolicitacaoCommand command = STATUS_SOLICITACAO.get(statusSolicitacao);

        if (command == null) {
            throw new IllegalArgumentException("Perfil inválido");
        }

        command.setStatusSolicitacao(pedido, propostaRespostaDTO);
    }

    private static void set (Pedido pedido, Long statusUm, Long statusDois) {
        pedido.getStatusSolicitacao().setId(statusUm);
        pedido.getStatusTramitacao().setId(statusDois);
    }

}
