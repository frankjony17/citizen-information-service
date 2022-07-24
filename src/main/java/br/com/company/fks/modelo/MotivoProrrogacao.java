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
@Table(name = "tb_motivo_prorrogacao")
public class MotivoProrrogacao implements Serializable {

    @Id
    @Column(name = "id_motivo_prorrogacao")
    @SequenceGenerator(allocationSize = 1, initialValue = 1, sequenceName = "fks.seq_tb_motivo_prorrogacao", name = "seq_tb_motivo_prorrogacao")
    @GeneratedValue(generator = "seq_tb_motivo_prorrogacao", strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nm_nome")
    private String nome;
}
