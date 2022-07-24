package br.com.company.fks.modelo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "tb_classificacao_tipo_resposta", schema = "fks")
public class ClassificacaoTipoResposta implements Serializable {

    @Id
    @Column(name = "id_classificacao_tipo_resposta")
    private Long id;

    @Column(name = "ds_classificacao_tipo_resposta")
    private String descricao;

    @OneToOne
    @JoinColumn(name = "id_tipo_resposta")
    private TipoResposta tipoResposta;

}
