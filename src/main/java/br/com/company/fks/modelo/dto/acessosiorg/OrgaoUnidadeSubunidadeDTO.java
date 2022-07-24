package br.com.company.fks.modelo.dto.acessosiorg;

import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class OrgaoUnidadeSubunidadeDTO {
    private Long id;
    private String nomeOrgao;
    private String siglaOrgao;
    private List<UnidadeDTO> unidades;
}
