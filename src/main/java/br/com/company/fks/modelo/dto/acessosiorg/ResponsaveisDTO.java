package br.com.company.fks.modelo.dto.acessosiorg;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponsaveisDTO {
    private Long id;
    private String responsavelRecursoTerceiraInstancia;
    private String responsavelRecursoQuartaInstancia;
    private String responsavelRecursoAcao;
}
