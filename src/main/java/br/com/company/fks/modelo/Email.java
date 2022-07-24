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
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "tb_email", schema = "fks")
public class Email implements Serializable {
    @Id
    @Column(name = "id_email")
    @SequenceGenerator(allocationSize = 1, initialValue = 1, sequenceName = "fks.seq_tb_email", name = "seq_tb_email")
    @GeneratedValue(generator = "seq_tb_email", strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "tipo_solicitacao")
    private Integer tipoSolicitacao;

    @Column(name = "tipo_alerta")
    private Integer tipoAlerta;

    @Column(name = "data_referencia")
    private Integer dataReferencia;

    @Column(name = "data_envio_email")
    private Integer dataEnvioEmail;

    @Column(name = "status_demanda")
    private Integer statusDemanda;

    @Column(name = "dias_ante_data_referencia")
    private Integer diasAnteDataReferencia;

    @Column(name = "dias_apos_data_referencia")
    private Integer diasAposDataReferencia;

    @Column(name = "reenviar_ate_alteracao_do_status")
    private Boolean reenviarAteAlteracaoDoStatus;

    @Column(name = "acao_executada")
    private Integer acaoExecutada;

    @Column(name = "assunto_email")
    private String assuntoEmail;

    @Column(name = "conteudo_email")
    private String conteudoEmail;

    @JsonIgnore
    @OneToMany(mappedBy="email", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
    private List<EmailPerfilAcesso> perfis;
}
