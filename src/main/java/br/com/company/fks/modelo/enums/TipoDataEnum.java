package br.com.company.fks.modelo.enums;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

@Getter
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum TipoDataEnum {

    DATA_FIM_PRAZO_ATENDIMIENTO_E_SIC(1, "Data de fim do prazo de atendimiento e-sic"),
    DATA_FIM_PRAZO_ATENDIMIENTO_UNIDADE(2, "Data de fim do prazo de atendimiento da Unidade"),
    DATA_FIM_PARA_SUGESTAO_ENCAMINHAMENTO_E_OUV(3, "Data de fim para sugestão de encaminhamento e-OUV"),
    DATA_FIM_ENVIO_PARA_E_OUV(4, "Data de fim de envio para e-OUV"),

    NA_DATA_REFERENCIA(5, "Na data de referência"),
    DIAS_ANTES_DATA_REFERENCIA(6, "Dias antes da data de referência"),
    DIAS_APOS_A_DATA_REFERENCIA(7, "Dias após a data de referência");

    private Integer id;
    private String valor;

    TipoDataEnum(Integer id, String valor) {
        this.id = id;
        this.valor = valor;
    }

    public static String getValor(Integer id) {
        String valor = "";
        TipoDataEnum[] enuns = TipoDataEnum.values();
        for (TipoDataEnum enumValor : enuns) {
            if (enumValor.getId().equals(id)) {
                valor = enumValor.getValor();
                break;
            }
        }
        return valor;
    }
}
