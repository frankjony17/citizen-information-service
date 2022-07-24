package br.com.company.fks.modelo.enums;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

@Getter
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum TipoAlertaEnum {

    TIPO_ALERTA_POR_DATA(1, "Data"),
    TIPO_ALERTA_POR_ACAO(2, "Acao");

    private Integer id;
    private String valor;

    TipoAlertaEnum(Integer id, String valor) {
        this.id = id;
        this.valor = valor;
    }

    public static String getValor(Integer id) {
        String valor = "";
        TipoAlertaEnum[] enuns = TipoAlertaEnum.values();
        for (TipoAlertaEnum enumValor : enuns) {
            if (enumValor.getId().equals(id)) {
                valor = enumValor.getValor();
                break;
            }
        }
        return valor;
    }
}
