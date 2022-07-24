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
@Table(name = "tb_andamento_recurso")
public class AndamentoRecurso implements Serializable {

    @Id
    @Column(name = "id_andamento_recurso")
    @SequenceGenerator(allocationSize = 1, initialValue = 1, sequenceName = "fks.seq_tb_andamento_recurso", name = "seq_tb_andamento_recurso")
    @GeneratedValue(generator = "seq_tb_andamento_recurso", strategy = GenerationType.AUTO)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dt_data_inicio")
    private Calendar dataInicio;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dt_data_fim")
    private Calendar dataFim;

    @Column(name = "id_unidade")
    private Long unidade;

    @Column(name = "ds_observacao")
    private String observacao;

    @Column(name = "nm_responsavel")
    private String responsavel;

    @Column(name = "ds_observacao_usuario")
    private String observacaoUsuario;

    @Column(name = "ds_justificativa")
    private String justificativa;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_status_solicitacao_recurso")
    private StatusSolicitacaoRecurso statusSolicitacaoRecurso;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_recurso")
    private Recurso recurso;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_status_tramitacao_recurso")
    private StatusTramitacaoRecurso statusTramitacaoRecurso;

    @JoinColumn(name="id_usuario_acessos")
    @OneToOne
    private UsuarioAcessos usuarioAcessosAssinatura;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "tb_andamento_recurso_usuario_acessos",
            joinColumns = @JoinColumn(name = "id_andamento_recurso"),
            inverseJoinColumns = @JoinColumn(name = "id_usuario_acessos"))
    private List<UsuarioAcessos> usuarioAcessos;

}
