package br.com.company.fks.modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "tb_pedido")
public class Pedido implements Serializable {

    private static final String ID_PEDIDO = "id_pedido";

    @Id
    @Column(name = ID_PEDIDO)
    @SequenceGenerator(allocationSize = 1, initialValue = 1, sequenceName = "fks.seq_tb_pedido", name = "seq_tb_pedido")
    @GeneratedValue(generator = "seq_tb_pedido", strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "cd_protocolo")
    private String protocolo;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dt_data_registro")
    private Calendar dataRegistro;

    @Column(name = "ds_descricao")
    private String descricaoPedido;

    @Column(name = "cd_codigo_siorg_orgao_superior")
    private String codigoSiorgOrgaoSuperior;

    @Column(name = "nm_orgao_superior")
    private String orgaoSuperior;

    @Column(name = "nm_orgao_vinculado")
    private String orgaoVinculado;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dt_prazo_atendimento")
    private Calendar prazoAtendimento;

    @Column(name = "ds_forma_recebimento")
    private String formaRecebimento;

    @Column(name = "st_situacao_status")
    private String situacaoStatus;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_status_situacao")
    private StatusSituacao statusSituacao;

    @Column(name = "st_em_atendimento")
    private String emAtendimento;

    @Column(name = "qt_quantidade_anexo")
    private int quantidadeAnexos;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dt_entrada_protocolo_fks")
    private Calendar dataEntradaProtocoloSistemaFKS;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dt_data_ultimo_reencaminham")
    private Calendar dataUltimoReencaminhamento;

    @Column(name = "ds_resumo_solicitacao")
    private String resumoSolicitacao;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dt_vencimento_unidade")
    private Calendar vencimentoUnidade;

    @Column(name = "ds_observacao")
    private String observacao;

    @Column(name = "ds_resposta_esic")
    private String respostaEsic;

    @Column(name = "st_vencimento_unidade_prorrog")
    private Boolean statusVencimentoUnidadeProrrogado;

    @Column(name = "st_prazo_atendimento_esic_pror")
    private Boolean statusPrazoAtendimentoEsicProrrogado;

    @Column(name = "is_devolver")
    private Boolean isDevolver;

    @Column(name = "st_status_resposta_assinada")
    private Boolean statusRespostaAssinada = false;

    @ManyToOne
    @JoinColumn(name = "id_pedido_duplicado")
    private Pedido pedidoDuplicado;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dt_resposta_esic")
    private Calendar dataRespostaEsic;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dt_prorrogacao_esic")
    private Calendar dataProrrogacaoESic;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_solicitante")
    private Solicitante solicitante;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_status_tramitacao")
    private StatusTramitacao statusTramitacao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_status_solicitacao")
    private StatusSolicitacao statusSolicitacao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_situacao_pedido")
    private SituacaoPedido situacaoPedido;

    @Column(name = "is_eouv")
    private Boolean isEOuv = false;

    @Column(name = "ds_proposta_resposta")
    private String propostaResposta;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "tb_pedido_classificacao_resp",
            joinColumns = @JoinColumn(name = ID_PEDIDO),
            inverseJoinColumns = @JoinColumn(name = "id_classificacao"))
    private List<ClassificacaoResposta> classificacaoResposta;

    @OneToOne
    @JoinColumn(name = "id_classificar_resposta_sic")
    private ClassificarRespostaSic classificarRespostaSic;

    @OneToOne
    @JoinColumn(name = "id_tema")
    private Tema tema;

    @JsonIgnore
    @OneToMany(mappedBy = "pedido", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Anexo> anexos = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "tb_pedido_subtema",
            joinColumns = @JoinColumn(name = ID_PEDIDO),
            inverseJoinColumns = @JoinColumn(name = "id_subtema"))
    private List<Subtema> subtemaList;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "tb_pedido_palavra_chave",
            joinColumns = @JoinColumn(name = ID_PEDIDO),
            inverseJoinColumns = @JoinColumn(name = "id_palavra_chave"))
    private List<PalavraChave> palavraChaveList;

    @JsonIgnore
    @OneToMany(mappedBy = "pedido", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Andamento> andamentos;

    public void addAnexo(Anexo anexo) {
        anexos.add(anexo);
        anexo.setPedido(this);
    }

    @Column(name = "is_classificacao_resposta")
    private Boolean isClassificacaoResposta = false;

    @Column(name = "is_classificacao_resposta_sic")
    private Boolean isClassificacaoRespostaSic = false;

}

