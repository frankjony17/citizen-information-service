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
@Table(name = "tb_recurso")
public class Recurso implements Serializable {

    @Id
    @Column(name = "id_recurso")
    @SequenceGenerator(allocationSize = 1, initialValue = 1, sequenceName = "fks.seq_tb_recurso", name = "seq_tb_recurso")
    @GeneratedValue(generator = "seq_tb_recurso", strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "cd_protocolo_pedido")
    private String protocoloPedido;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dt_data_abertura")
    private Calendar dataAbertura;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dt_data_prazo_atendimento")
    private Calendar dataPrazoAtendimento;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dt_data_vencimento_unidade")
    private Calendar vencimentoUnidade;

    @Column(name = "ds_descricao_justificativa")
    private String descricaoJustificativa;

    @Column(name = "qt_anexos")
    private int quantidadeAnexos;

    @Column(name = "ds_justificativa_devolver")
    private String descricaoJustificativaDevolver;

    @Column(name = "ds_observacao")
    private String observacao;

    @Column(name = "ds_proposta_resposta")
    private String propostaResposta;

    @Column(name = "ds_resposta_esic")
    private String respostaEsic;

    @Column(name = "ds_observacao_resposta_enviada")
    private String observacaoRespostaEnviada;

    @Column(name = "st_status_resposta_assinada")
    private Boolean statusRespostaAssinada = false;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pedido")
    private Pedido pedido;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_status_tramitacao_recurso")
    private StatusTramitacaoRecurso statusTramitacao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_status_solicitacao_recurso")
    private StatusSolicitacaoRecurso statusSolicitacao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_situacao_recurso")
    private SituacaoRecurso situacaoRecurso;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_instancia_recurso")
    private InstanciaRecurso instanciaRecurso;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_resposta_recurso")
    private TipoRespostaRecurso tipoRespostaRecurso;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_recurso")
    private TipoRecurso tipoRecurso;
}
