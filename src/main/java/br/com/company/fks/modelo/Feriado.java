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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Calendar;

@Entity
@Getter
@Setter
@Table(name = "tb_feriado")
public class Feriado implements Serializable {

    @Id
    @Column(name = "id_feriado")
    @SequenceGenerator(allocationSize = 1, initialValue = 1, sequenceName = "fks.seq_tb_feriado", name = "seq_tb_feriado")
    @GeneratedValue(generator = "seq_tb_feriado", strategy = GenerationType.AUTO)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dt_feriado")
    private Calendar dataFeriado;

    @Column(name = "nm_feriado")
    private String nome;

    @Column(name = "ds_feriado")
    private String descricao;

    @Column(name = "dt_ano")
    private Integer ano;

}