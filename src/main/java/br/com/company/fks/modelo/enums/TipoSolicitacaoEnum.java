package br.com.company.fks.modelo.enums;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

@Getter
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum TipoSolicitacaoEnum {

    TIPO_SOLICITACAO_PEDIDO(1, "Pedido"),
    TIPO_SOLICITACAO_RECURSO(2, "Recurso");

    private Integer id;
    private String valor;

    TipoSolicitacaoEnum(Integer id, String valor) {
        this.id = id;
        this.valor = valor;
    }

    public static String getValor(Integer id) {
        String valor = "";
        TipoSolicitacaoEnum[] enuns = TipoSolicitacaoEnum.values();
        for (TipoSolicitacaoEnum enumValor : enuns) {
            if (enumValor.getId().equals(id)) {
                valor = enumValor.getValor();
                break;
            }
        }
        return valor;
    }
}
