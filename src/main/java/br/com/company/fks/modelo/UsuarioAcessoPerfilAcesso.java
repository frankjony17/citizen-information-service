package br.com.company.fks.modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.SequenceGenerator;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "tb_usuario_acesso_perfil_acesso",schema = "fks")
public class UsuarioAcessoPerfilAcesso implements Serializable {

    @Id
    @Column(name = "id_usuario_acesso_perfil_acesso")
    @SequenceGenerator(allocationSize = 1, initialValue = 1, sequenceName = "fks.seq_tb_usuario_acesso_perfil_acesso", name = "seq_tb_usuario_acesso_perfil_acesso")
    @GeneratedValue(generator = "seq_tb_usuario_acesso_perfil_acesso", strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "papel")
    private String papel;

    @Column(name = "is_ativo")
    private Boolean isAtivo;

    @Column(name = "ds_assinatura")
    private String assinaturaUsuario;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_perfil_acessos")
    private PerfilAcessos perfilAcessos;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_usuario_acessos")
    private UsuarioAcessos usuarioAcessos;
}
