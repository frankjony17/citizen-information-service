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
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "tb_temp_perfis_acessos",schema = "fks")
public class TempPerfisAcessos implements Serializable {
    @Id
    @Column(name = "id_temp_perfis_acessos")
    @SequenceGenerator(allocationSize = 1, initialValue = 1, sequenceName = "fks.seq_temp_perfis_acessos", name = "seq_temp_perfis_acessos")
    @GeneratedValue(generator = "seq_temp_perfis_acessos", strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "perfil_id")
    private Long perfilId;

    @Column(name = "perfil_nome")
    private String perfilNome;

    @Column(name = "perfil_descricao")
    private String perfilDescricao;

    @Column(name = "perfil_unidade_id")
    private Long perfilUnidadeId;

    @Column(name = "perfil_subunidades_ids")
    private String perfilSubunidadesIds;

    @Column(name = "perfil_existe_acessos")
    private Boolean perfilExisteAcessos;

    @Column(name = "perfil_excluido")
    private Boolean perfilExcluido;

    @Column(name = "perfil_ativo")
    private Boolean perfilAtivo;

    @ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinColumn(name="temp_usuario_acessos_id", nullable = false)
    private TempUsuarioAcessos tempUsuarioAcessos;
}
