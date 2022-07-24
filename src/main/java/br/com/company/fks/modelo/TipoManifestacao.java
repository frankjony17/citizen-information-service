package br.com.company.fks.modelo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Getter
@Setter
@Table(name = "tb_tipo_manifestacao")
public class TipoManifestacao implements Serializable {

    @Id
    @Column(name = "id_tipo_manifestacao")
    @SequenceGenerator(allocationSize = 1, initialValue = 1, sequenceName = "fks.seq_tb_tipo_manifestacao", name = "seq_tb_tipo_manifestacao")
    @GeneratedValue(generator = "seq_tb_tipo_manifestacao", strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "tp_resposta")
    private String nome;

    @Column(name = "ds_resposta")
    private String descricao;
}
