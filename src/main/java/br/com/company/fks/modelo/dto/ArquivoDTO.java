package br.com.company.fks.modelo.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ArquivoDTO {
    private String nome;
    private String caminho;
    private Long tamanho;
}
