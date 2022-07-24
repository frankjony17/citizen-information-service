package br.com.company.fks.modelo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Getter
@Setter
@Table(name = "tb_instancia_recurso")
public class InstanciaRecurso implements Serializable {

    public static final String PRIMEIRA_INSTANCIA = "Primeira Instância";
    public static final String SEGUNDA_INSTANCIA = "Segunda Instância";
    public static final String CGU = "CGU";
    public static final String RECLAMACAO_POR_ATRASO = "Reclamação por atraso";

    @Id
    @Column(name = "id_instancia_recurso")
    private Long id;

    @Column(name = "nm_nome")
    private String nome;
}
