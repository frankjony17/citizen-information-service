package br.com.company.fks.modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.SequenceGenerator;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "tb_email_perfil_acesso", schema = "fks")
public class EmailPerfilAcesso implements Serializable {

    @Id
    @Column(name = "id_email_perfil_acesso")
    @SequenceGenerator(allocationSize = 1, initialValue = 1, sequenceName = "fks.seq_tb_email_perfil_acesso", name = "seq_tb_email_perfil_acesso")
    @GeneratedValue(generator = "seq_tb_email_perfil_acesso", strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "tipo_solicitacao")
    private Integer tipoSolicitacao;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "id_email")
    private Email email;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_perfil_acessos")
    private PerfilAcessos perfilAcessos;
}
