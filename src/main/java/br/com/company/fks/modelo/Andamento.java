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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "tb_andamento")
public class Andamento implements Serializable {

    private static final String ID_ANDAMENTO = "id_andamento";

    public Andamento(){}

    public Andamento(UsuarioAcessos usuarioAcessos, Unidade unidade, Calendar dataInicio, Calendar dataFim, Pedido pedido, String observacao){
        this.setUsuarioAcessosAssinatura(usuarioAcessos);
        this.setDataInicio(dataInicio);
        this.setDataFim(dataFim);
        this.setPedido(pedido);
        this.setObservacao(observacao);
        this.setUnidade(unidade);
    }

    public Andamento(UsuarioAcessos usuarioAcessos, Subunidade subunidade, Calendar dataInicio, Calendar dataFim, Pedido pedido, String observacao){
        this.setUsuarioAcessosAssinatura(usuarioAcessos);
        this.setSubunidade(subunidade);
        this.setDataInicio(dataInicio);
        this.setDataFim(dataFim);
        this.setPedido(pedido);
        this.setObservacao(observacao);
    }
    public Andamento(UsuarioAcessos usuarioAcessosAssinatura, Calendar dataInicio, Calendar dataFim, Pedido pedido, String observacao){
        this.setUsuarioAcessosAssinatura(usuarioAcessosAssinatura);
        this.setDataInicio(dataInicio);
        this.setDataFim(dataFim);
        this.setPedido(pedido);
        this.setObservacao(observacao);
    }

    public Andamento(Unidade unidade, Calendar dataInicio, Calendar dataFim, Pedido pedido, String observacao){
        this.setUnidade(unidade);
        this.setDataInicio(dataInicio);
        this.setDataFim(dataFim);
        this.setPedido(pedido);
        this.setObservacao(observacao);
    }

    @Id
    @Column(name = ID_ANDAMENTO)
    @SequenceGenerator(allocationSize = 1, initialValue = 1, sequenceName = "fks.seq_tb_andamento", name = "seq_tb_andamento")
    @GeneratedValue(generator = "seq_tb_andamento", strategy = GenerationType.AUTO)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dt_data_inicio")
    private Calendar dataInicio;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dt_data_fim")
    private Calendar dataFim;

    @Column(name = "nm_responsavel")
    private String responsavel;

    @Column(name = "ds_observacao")
    private String observacao;

    @Column(name = "ds_observacao_usuario")
    private String observacaoUsuario;

    @Column(name = "ds_justificativa")
    private String justificativa;

    @Column(name = "st_resposta_assinada")
    private Boolean statusRespostaAssinada = false;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pedido")
    private Pedido pedido;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_status_tramitacao")
    private StatusTramitacao statusTramitacao;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_unidade")
    private Unidade unidade;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_subunidade")
    private Subunidade subunidade;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_status_solicitacao")
    private StatusSolicitacao statusSolicitacao;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "tb_andamento_unidade",
            joinColumns = @JoinColumn(name = ID_ANDAMENTO),
            inverseJoinColumns = @JoinColumn(name = "id_unidade"))
    private List<Unidade> listaUnidade;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "tb_andamento_subunidade",
            joinColumns = @JoinColumn(name = ID_ANDAMENTO),
            inverseJoinColumns = @JoinColumn(name = "id_subunidade"))
    private List<Subunidade> listaSubunidade;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "tb_andamento_usuario_acessos",
            joinColumns = @JoinColumn(name = ID_ANDAMENTO),
            inverseJoinColumns = @JoinColumn(name = "id_usuario_acessos"))
    private List<UsuarioAcessos> usuarioAcessos;

    @JoinColumn(name="id_usuario_acessos")
    @OneToOne
    private UsuarioAcessos usuarioAcessosAssinatura;
}
