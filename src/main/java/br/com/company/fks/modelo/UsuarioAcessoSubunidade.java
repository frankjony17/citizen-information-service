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
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "tb_usuario_acessos_subunidade",schema = "fks")
public class UsuarioAcessoSubunidade implements Serializable {

    @Id
    @Column(name = "id_usuario_acessos_subunidade")
    @SequenceGenerator(allocationSize = 1, initialValue = 1, sequenceName = "fks.seq_tb_usuario_acessos_subunidade", name = "seq_tb_usuario_acessos_subunidade")
    @GeneratedValue(generator = "seq_tb_usuario_acessos_subunidade", strategy = GenerationType.AUTO)
    private Long id;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_subunidade")
    private Subunidade subunidade;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_usuario_acessos")
    private UsuarioAcessos usuarioAcessos;

    @Column(name = "st_status_subunidade")
    private Boolean statusSubunidade;
}
