package br.com.company.fks.modelo.dto;

import br.com.company.fks.modelo.Subunidade;
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
    private List<Subunidade> subunidade;
}
