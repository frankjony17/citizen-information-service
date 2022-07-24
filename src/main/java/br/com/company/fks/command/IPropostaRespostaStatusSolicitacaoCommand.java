package br.com.company.fks.command;

import br.com.company.fks.modelo.Pedido;
import br.com.company.fks.modelo.dto.PropostaRespostaDTO;

public interface IPropostaRespostaStatusSolicitacaoCommand {
    public void setStatusSolicitacao(Pedido pedido, PropostaRespostaDTO propostaRespostaDTO);
}
