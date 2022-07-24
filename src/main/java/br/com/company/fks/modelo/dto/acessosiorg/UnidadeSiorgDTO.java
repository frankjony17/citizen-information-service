package br.com.company.fks.modelo.dto.acessosiorg;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UnidadeSiorgDTO {
    private String id;
    private String nomeUnidade;
    private String codigoUnidade;
    private String siglaUnidade;
    private String codigoUnidadePai;
    private String codigoTipoUnidade;
}
