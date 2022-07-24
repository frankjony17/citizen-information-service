package br.com.company.fks.modelo.dto.acessosiorg;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubunidadeDTO {
    private Long id;
    private String codigoUnidade;
    private String nomeUnidade;
    private String siglaUnidade;
    private Boolean statusUnidade;
}
