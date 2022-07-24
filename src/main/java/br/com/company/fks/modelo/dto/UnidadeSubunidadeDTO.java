package br.com.company.fks.modelo.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class UnidadeSubunidadeDTO  {
    private String nome;
    private String codigoUg;
    private String siglaUnidade;
    private List<SubunidadeDTO> subunidade = new ArrayList<>();
}
