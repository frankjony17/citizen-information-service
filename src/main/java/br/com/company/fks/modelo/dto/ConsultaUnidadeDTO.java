package br.com.company.fks.modelo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConsultaUnidadeDTO {
    private Long idUnidade;
    private Long idSubunidade;
    private String nomeUnidade;
    private  String codigoSubunidade;
    private String nomeSubunidade;
    private boolean statusSubunidade;
    private boolean statusUnidade;
}
