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
@Table(name = "tb_historico_tratamento_recur")
public class HistoricoTratamentoRecurso implements Serializable {

    @Column(name = "id_historico_tratamento_recur")
    @SequenceGenerator(allocationSize = 1, initialValue = 1, sequenceName = "fks.seq_tb_historico_tratamento_recurso", name = "seq_tb_historico_tratamento_recurso")
    @Id
    @GeneratedValue(generator = "seq_tb_historico_tratamento_recurso", strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "ds_resposta_recurso")
    private String respostaRecurso;

    @Column(name = "nm_responsavel")
    private String nomeResponsavel;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dh_data")
    private Calendar data;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_recurso")
    private Recurso recurso;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_tratamento_recurso")
    private TipoTratamentoRecurso tipoTratamentoRecurso;
}
