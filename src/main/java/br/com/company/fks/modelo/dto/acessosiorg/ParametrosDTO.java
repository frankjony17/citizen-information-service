package br.com.company.fks.modelo.dto.acessosiorg;

import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class ParametrosDTO {
    private Long orgao;
    private Long unidade;
    private List<Long> subunidade;
}
