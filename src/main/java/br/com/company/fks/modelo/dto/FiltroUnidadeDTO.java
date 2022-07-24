package br.com.company.fks.modelo.dto;

import br.com.company.fks.modelo.dto.acessosiorg.SubunidadeDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class FiltroUnidadeDTO {
    private Integer offset;
    private Integer limit;
    private Long orgaoId;
    private Long unidadeId;
    private List<SubunidadeDTO> subunidade;
}
