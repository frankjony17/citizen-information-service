package br.com.company.fks.modelo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.SequenceGenerator;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.FetchType;
import javax.persistence.CascadeType;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "tb_orgao_siorg",schema = "fks")
public class OrgaoSiorg implements Serializable {

    @Id
    @Column(name = "id_orgao_siorg")
    @SequenceGenerator(allocationSize = 1, initialValue = 1, sequenceName = "fks.seq_tb_orgao_siorg", name = "seq_tb_orgao_siorg")
    @GeneratedValue(generator = "seq_tb_orgao_siorg", strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "co_codigo_orgao_siorg")
    private String codigoOrgao;

    @Column(name = "nm_nome_orgao_siorg")
    private String nomeOrgao;

    @Column(name = "sg_sigla_orgao_siorg")
    private String siglaOrgao;

    @Column(name = "st_status_orgao")
    private Boolean statusOrgao;

    @OneToMany(mappedBy = "orgaoSiorg", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Unidade> unidades;
}
