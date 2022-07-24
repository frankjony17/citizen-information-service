package br.com.company.fks.modelo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnexoPedidoDetalhadoDTO {
    private String nome;

    public AnexoPedidoDetalhadoDTO(String nome) {
        this.nome = nome;
    }
}
