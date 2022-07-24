package br.com.company.fks.modelo.enums;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

@Getter
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum TipoAcaoExecutadaRecursoEnum {

    TRAMITACAO_SIC_E_SOLICITACAO_RECURSO_1_TRIAGEM(1, "Tramitação \"SIC\" e Solicitação \"Recurso 1ª Triagem\""),
    TRAMITACAO_ANDAMENTO_E_SOLICITACAO_RECURSO_1_PRODUCAO(2, "Tramitação \"Andamento\" e Solicitação \"Recurso 1ª Produção\""),
    TRAMITACAO_ANDAMENTO_E_SOLICITACAO_RECURSO_1_DISTRIBUICAO(3, "Tramitação \"Andamento\" e Solicitação \"Recurso 1ª Distribuição\""),
    TRAMITACAO_ANDAMENTO_E_SOLICITACAO_RECURSO_1_ASSINADO(4, "Tramitação \"Andamento\" e Solicitação \"Recurso 1ª Assinado\""),
    TRAMITACAO_RESPONDIDOS_E_SOLICITACAO_RECURSO_1_RESPONDIDO(5, "Tramitação \"Respondidos\" e Solicitação \"Recurso 1ª Respondido\""),
    TRAMITACAO_RESPONDIDOS_E_SOLICITACAO_RECURSO_1_PARA_REVISAO(6, "Tramitação \"Respondidos\" e Solicitação \"Recurso 1ª Para Revisão\""),
    TRAMITACAO_RESPONDIDOS_E_SOLICITACAO_RECURSO_1_PARA_ENVIO(7, "Tramitação \"Respondidos\" e Solicitação \"Recurso 1ª Para Envio\""),
    TRAMITACAO_ENVIADOS_E_SOLICITACAO_RECURSO_1_ENVIADO(8, "Tramitação \"Enviados\" e Solicitação \"Recurso 1ª Enviado\""),
    TRAMITACAO_SIC_E_SOLICITACAO_RECURSO_2_TRIAGEM(9, "Tramitação \"SIC\" e Solicitação \"Recurso 2ª Triagem\""),
    TRAMITACAO_ANDAMENTO_E_SOLICITACAO_RECURSO_2_PRODUCAO(10, "Tramitação \"Andamento\" e Solicitação \"Recurso 2ª Produção\""),
    TRAMITACAO_ANDAMENTO_E_SOLICITACAO_RECURSO_2_DISTRIBUICAO(11, "Tramitação \"Andamento\" e Solicitação \"Recurso 2ª Distribuição\""),
    TRAMITACAO_ANDAMENTO_E_SOLICITACAO_RECURSO_2_ASSINADO(12, "Tramitação \"Andamento\" e Solicitação \"Recurso 2ª Assinado\""),
    TRAMITACAO_RESPONDIDOS_E_SOLICITACAO_RECURSO_2_RESPONDIDO(13, "Tramitação \"Respondidos\" e Solicitação \"Recurso 2ª Respondido\""),
    TRAMITACAO_RESPONDIDOS_E_SOLICITACAO_RECURSO_2_PARA_REVISAO(14, "Tramitação \"Respondidos\" e Solicitação \"Recurso 2ª Para Revisão\""),
    TRAMITACAO_RESPONDIDOS_E_SOLICITACAO_RECURSO_2_PARA_ENVIO(15, "Tramitação \"Respondidos\" e Solicitação \"Recurso 2ª Para Envio\""),
    TRAMITACAO_ENVIADOS_E_SOLICITACAO_RECURSO_2_ENVIADO(16, "Tramitação \"Enviados\" e Solicitação \"Recurso 2ª Enviado\"");

    private Integer id;
    private String valor;

    TipoAcaoExecutadaRecursoEnum(Integer id, String valor) {
        this.id = id;
        this.valor = valor;
    }

    public static String getValor(Integer id) {
        String valor = "";
        TipoAcaoExecutadaRecursoEnum[] enuns = TipoAcaoExecutadaRecursoEnum.values();
        for (TipoAcaoExecutadaRecursoEnum enumValor : enuns) {
            if (enumValor.getId().equals(id)) {
                valor = enumValor.getValor();
                break;
            }
        }
        return valor;
    }
}
