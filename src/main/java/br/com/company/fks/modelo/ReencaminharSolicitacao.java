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

@Getter
@Setter
@Entity
@Table(name = "tb_reencaminhar_solicitacao")
public class ReencaminharSolicitacao implements Serializable {

    @Id
    @Column(name = "id_reencaminhar_solicitacao")
    @SequenceGenerator(allocationSize = 1, initialValue = 1, sequenceName = "fks.seq_tb_reencaminhar_solicitacao", name = "seq_tb_reencaminhar_solicitacao")
    @GeneratedValue(generator = "seq_tb_reencaminhar_solicitacao", strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_orgao")
    private Orgao orgao;

    @Column(name = "notificacao_enviada_solicitante")
    private String notificacaoEnviadaSolicitante;

    @Column(name = "notificacao_enviada_destinatario")
    private String notificacaoEnviadaDestinatario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pedido")
    private Pedido pedido;



}
