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
@Table(name = "tb_situacao_recurso")
public class SituacaoRecurso implements Serializable {

    public static final String EM_TRAMITACAO = "Em Tramitação";
    public static final String RESPONDIDO = "Respondido";
    public static final String DEFERIDO = "Deferido";
    public static final String NAO_RESPONDIDO = "Não Respondido";

    @Id
    @Column(name = "id_situacao_recurso")
    private Long id;

    @Column(name = "nm_nome")
    private String nome;
}
