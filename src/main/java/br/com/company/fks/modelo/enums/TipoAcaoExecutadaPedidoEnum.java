package br.com.company.fks.modelo.enums;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

@Getter
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum TipoAcaoExecutadaPedidoEnum {

    TRAMITACAO_SIC_E_SOLICITACAO_TRIAGEM_SIC(1, "Tramitação \"SIC\" e Solicitação \"Triagem SIC\""),
    TRAMITACAO_SIC_E_SOLICITACAO_SUGESTAO_REENCAMINHAMENTO(2, "Tramitação \"SIC\" e Solicitação \"Sugestão Reencaminhamento\""),
    TRAMITACAO_ANDAMENTO_E_SOLICITACAO_DISTRIBUICAO_PF(3, "Tramitação \"Andamento\" e Solicitação \"Distribuição PF\""),
    TRAMITACAO_ANDAMENTO_E_SOLICITACAO_RESPOSTA_ASSINADA(4, "Tramitação \"Andamento\" e Solicitação \"Resposta Assinada\""),
    TRAMITACAO_ANDAMENTO_E_SOLICITACAO_PRODUCAO_RESPOSTA(5, "Tramitação \"Andamento\" e Solicitação \"Produção de Resposta\""),
    TRAMITACAO_ANDAMENTO_E_SOLICITACAO_EDICAO_TECNICO(6, "Tramitação \"Andamento\" e Solicitação \"Edição Técnico\""),
    TRAMITACAO_ANDAMENTO_E_SOLICITACAO_SUGESTAO_REENCAMINHAMENTO(7, "Tramitação \"Andamento\" e Solicitação \"Sugestão Reencaminhamento\""),
    TRAMITACAO_RESPONDIDAS_E_SOLICITACAO_RESPOSTA_SIC(8, "Tramitação \"Respondidas\" e Solicitação \"Resposta SIC\""),
    TRAMITACAO_RESPONDIDAS_E_SOLICITACAO_REVISAO(9, "Tramitação \"Respondidas\" e Solicitação \"Revisão\""),
    TRAMITACAO_RESPONDIDAS_E_SOLICITACAO_PARA_ENVIO(10, "Tramitação \"Respondidas\" e Solicitação \"Para Envio\""),
    TRAMITACAO_ENVIADAS_E_SOLICITACAO_ENVIADAS(11, "Tramitação \"Enviadas\" e Solicitação \"Enviadas\""),
    TRAMITACAO_E_OUV_E_SOLICITACAO_ENVIADAS(12, "Tramitação \"E-OUV\" e Solicitação \"Enviadas\""),
    TRAMITACAO_REENCAMINHADAS_E_SOLICITACAO_REENCAMINHADAS(13, "Tramitação \"Reencaminhadas\" e Solicitação \"Reencaminhadas\""),
    PORROGAR_PRAZO(14, "Porrogar Prazo"),
    PORROGAR_PRAZO_E_SIC(15, "Porrogar Prazo e-sic");

    private Integer id;
    private String valor;

    TipoAcaoExecutadaPedidoEnum(Integer id, String valor) {
        this.id = id;
        this.valor = valor;
    }

    public static String getValor(Integer id) {
        String valor = "";
        TipoAcaoExecutadaPedidoEnum[] enuns = TipoAcaoExecutadaPedidoEnum.values();
        for (TipoAcaoExecutadaPedidoEnum enumValor : enuns) {
            if (enumValor.getId().equals(id)) {
                valor = enumValor.getValor();
                break;
            }
        }
        return valor;
    }
}
