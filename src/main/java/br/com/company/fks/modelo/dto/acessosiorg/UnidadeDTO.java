package br.com.company.fks.modelo.dto.acessosiorg;

import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class UnidadeDTO {
    private Long id;
    private String codigoUnidade;
    private String nomeUnidade;
    private String siglaUnidade;
    private Boolean statusUnidade;
    private List<SubunidadeDTO> subunidade;
}
