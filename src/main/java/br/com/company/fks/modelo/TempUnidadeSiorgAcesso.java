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
@Table(name = "tb_temp_unidade_siorg_acesso",schema = "fks")
public class TempUnidadeSiorgAcesso implements Serializable {
    @Id
    @Column(name = "id_temp_unidade_siorg_acesso")
    @SequenceGenerator(allocationSize = 1, initialValue = 1, sequenceName = "fks.seq_tb_temp_unidade_siorg_acesso", name = "seq_tb_temp_unidade_siorg_acesso")
    @GeneratedValue(generator = "seq_tb_temp_unidade_siorg_acesso", strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "co_codigo_ug")
    private String codigoUg;

    @Column(name = "nm_nome")
    private String nome;

    @Column(name = "sg_sigla")
    private String sigla;

    @Column(name = "at_ativo")
    private Boolean ativo;

    @Column(name = "temp_unidade_siorg_acesso_id")
    private Long unidadePaiId;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "temp_orgao_siorg_acesso_id", nullable = false)
    @JsonIgnore
    private TempOrgaoSiorgAcesso tempOrgaoSiorgAcesso;
}
