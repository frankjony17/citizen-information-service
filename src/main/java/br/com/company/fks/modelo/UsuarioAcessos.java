package br.com.company.fks.modelo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;


@Entity
@Getter
@Setter
@Table(name = "tb_usuario_acessos")
public class UsuarioAcessos implements Serializable {

    @Id
    @Column(name = "id_usuario_acessos")
    @SequenceGenerator(allocationSize = 1, initialValue = 1, sequenceName = "fks.seq_tb_usuario_acessos", name = "seq_tb_usuario_acessos")
    @GeneratedValue(generator = "seq_tb_usuario_acessos", strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nm_nome_usuario")
    private String nomeUsuario;

    @Column(name = "cd_cpf")
    private String cpfUsuario;

    @Column(name = "cd_codigo_usuario")
    private String codigoUsuario;

    @Column(name = "ds_cargo")
    private String cargoUsuario;

    @Column(name = "ds_funcao")
    private String funcaoUsuario;

    @Column(name = "ds_email_usuario")
    private String emailUsuario;

    @Column(name = "num_telefone_usuario")
    private String telefoneUsuario;

    @Column(name = "ds_perfil_usuario")
    private String perfilUsuario;

    @OneToOne
    @JoinColumn(name = "id_unidade")
    private Unidade unidade;
}

