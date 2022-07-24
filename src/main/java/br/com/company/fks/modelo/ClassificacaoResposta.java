package br.com.company.fks.modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "tb_classificacao_resposta", schema = "fks")
public class ClassificacaoResposta implements Serializable {
    @Id
    @SequenceGenerator(allocationSize = 1, initialValue = 1, sequenceName = "fks.seq_tb_tipo_classificacao_resposta", name = "seq_tb_classificacao_resposta")
    @GeneratedValue(generator = "seq_tb_classificacao_resposta", strategy = GenerationType.AUTO)
    @Column(name = "id_classificacao")
    private Long id;

    @Column(name = "ds_descricao")
    private String descricao;

    @Column(name = "st_status")
    private Boolean statusClassificacaoResposta = true;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="id_tipo_classificacao")
    private TipoClassificacaoResposta tipoClassificacaoResposta;
}
