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
@Table(name = "tb_status_tramitacao_recurso")
public class StatusTramitacaoRecurso implements Serializable {

    public static final Long SIC = 1L;
    public static final Long ANDAMENTO = 2L;
    public static final Long RESPONDIDO = 3L;
    public static final Long ENVIADO = 4L;

    @Id
    @Column(name = "id_status_tramitacao_recurso")
    private Long id;

    @Column(name = "nm_nome")
    private String nome;
}
