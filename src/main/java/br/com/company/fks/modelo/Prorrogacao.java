package br.com.company.fks.modelo;

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
@Table(name = "tb_prorrogacao")
public class Prorrogacao implements Serializable {

    @Id
    @Column(name = "id_prorrogacao")
    @SequenceGenerator(allocationSize = 1, initialValue = 1, sequenceName = "fks.seq_tb_prorrogacao", name = "seq_tb_prorrogacao")
    @GeneratedValue(generator = "seq_tb_prorrogacao", strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "ds_justificativa_prorrogacao")
    private String justificativaProrrogacao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pedido")
    private Pedido pedido;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_motivo_prorrogacao")
    private MotivoProrrogacao motivoProrrogacao;

    @Column(name = "st_esic")
    private boolean eSic;

}
