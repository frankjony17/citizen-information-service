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
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "tb_temp_usuario_acessos",schema = "fks")
public class TempUsuarioAcessos implements Serializable {
    @Id
    @Column(name = "id_temp_usuario_acessos")
    @SequenceGenerator(allocationSize = 1, initialValue = 1, sequenceName = "fks.seq_temp_usuario_acessos", name = "seq_temp_usuario_acessos")
    @GeneratedValue(generator = "seq_temp_usuario_acessos", strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "usuario_id")
    private Long usuarioId;

    @Column(name = "usuario_cpf")
    private String usuarioCpf;

    @Column(name = "usuario_nome")
    private String usuarioNome;

    @Column(name = "usuario_email")
    private String usuarioEmail;

    @Column(name = "usuario_ativo")
    private Boolean usuarioAtivo;

    @Column(name = "usuario_telefone_trabalho")
    private String usuarioTelefoneTrabalho;

    @Column(name = "usuario_telefone_celular")
    private String usuarioTelefoneCelular;

    @Column(name = "usuario_existe_acessos")
    private Boolean usuarioExisteAcessos;

    @OneToMany(mappedBy="tempUsuarioAcessos", fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    private List<TempPerfisAcessos> tempPerfisAcessos;
}
