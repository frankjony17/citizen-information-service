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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Calendar;

@Entity
@Getter
@Setter
@Table(name = "tb_historico_tratamento")
public class HistoricoTratamento implements Serializable {
    @Id
    @Column(name = "id_historico_tratamento")
    @SequenceGenerator(allocationSize = 1, initialValue = 1, sequenceName = "fks.seq_tb_historico_tratamento", name = "seq_tb_historico_tratamento")
    @GeneratedValue(generator = "seq_tb_historico_tratamento", strategy = GenerationType.AUTO)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dh_data")
    private Calendar data;

    @Column(name = "nm_responsavel")
    private String nomeResponsavel;

    @Column(name = "ds_resposta_pedido")
    private String respostaPedido;

    @Column(name = "st_status_resposta_assinada")
    private Boolean statusRespostaAssinada;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pedido")
    private Pedido pedido;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_tratamento")
    private TipoTratamento tipoTratamento;
}
