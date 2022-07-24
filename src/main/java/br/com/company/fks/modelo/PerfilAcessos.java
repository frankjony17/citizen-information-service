package br.com.company.fks.modelo;

import lombok.Getter;
import lombok.Setter;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "tb_perfil_acessos",schema = "fks")
public class PerfilAcessos implements Serializable {

    @Id
    @Column(name = "id_perfil_acessos")
    @SequenceGenerator(allocationSize = 1, initialValue = 1, sequenceName = "fks.seq_tb_perfil_acessos", name = "seq_tb_perfil_acessos")
    @GeneratedValue(generator = "seq_tb_perfil_acessos", strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nm_nome_perfil")
    private String nomePerfil;

    @Column(name = "ds_descricao_perfil")
    private String descricaoPerfil;
}
