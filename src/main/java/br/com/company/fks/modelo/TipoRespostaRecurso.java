package br.com.company.fks.modelo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "tb_tipo_resposta_recurso", schema = "fks")
public class TipoRespostaRecurso implements Serializable {

    @Id
    @Column(name = "id_tipo_resposta_recurso")
    private Long id;

    @Column(name = "ds_tipo_resposta")
    private String descricao;
}
