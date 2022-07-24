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

@Entity
@Getter
@Setter
@Table(name = "tb_subunidade")
public class Subunidade implements Serializable {

    @Id
    @Column(name = "id_subunidade")
    @SequenceGenerator(allocationSize = 1, initialValue = 1, sequenceName = "fks.seq_tb_subunidade", name = "seq_tb_subunidade")
    @GeneratedValue(generator = "seq_tb_subunidade", strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "cd_codigo_subunidade")
    private String codigoSubunidade;

    @Column(name = "nm_nome_subunidade")
    private String nomeSubunidade;

    @Column(name = "sg_sigla_subunidade")
    private String siglaSubunidade;

    @Column(name = "st_status_subunidade")
    private boolean statusSubunidade = true;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_unidade")
    private Unidade unidade;
}
