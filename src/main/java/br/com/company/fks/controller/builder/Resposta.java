package br.com.company.fks.controller.builder;


import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe de Respostas
 *
 * @param <T>
 */

public class Resposta<T> {

    @Getter
    @Setter
    private T resultado;

    @Getter
    @Setter
    private List<String> erros;

    @Getter
    @Setter
    private List<String> mensagens;

    @Getter
    @Setter
    private Long totalElementos;

    @Getter
    @Setter
    private Integer totalPaginas;

    /**
     * Método construtor da classe
     */
    public Resposta() {
        mensagens = new ArrayList<>();
        erros = new ArrayList<>();
    }
}