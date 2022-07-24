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
import javax.persistence.OneToMany;
import javax.persistence.FetchType;
import javax.persistence.CascadeType;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "tb_unidade")
public class Unidade implements Serializable {
    @Id
    @Column(name = "id_unidade")
    @SequenceGenerator(allocationSize = 1, initialValue = 1, sequenceName = "fks.seq_tb_unidade", name = "seq_tb_unidade")
    @GeneratedValue(generator = "seq_tb_unidade", strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "cd_codigo_unidade")
    private String codigoUnidade;

    @Column(name = "nm_nome_unidade")
    private String nomeUnidade;

    @Column(name = "sg_sigla_unidade")
    private String siglaUnidade;

    @Column(name = "st_status_unidade")
    private Boolean statusUnidade = true;

    @OneToMany(mappedBy = "unidade", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Subunidade> subunidade;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_orgao_siorg")
    private OrgaoSiorg orgaoSiorg;
}
