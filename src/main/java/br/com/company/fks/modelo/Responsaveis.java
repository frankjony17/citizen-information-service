package br.com.company.fks.modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.SequenceGenerator;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "tb_responsaveis",schema = "fks")
public class Responsaveis implements Serializable {

    @Id
    @Column(name = "id_responsaveis")
    @SequenceGenerator(allocationSize = 1, initialValue = 1, sequenceName = "fks.seq_tb_responsaveis", name = "seq_tb_responsaveis")
    @GeneratedValue(generator = "seq_tb_responsaveis", strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "responsavel_recurso_terceira_instancia")
    private String responsavelRecursoTerceiraInstancia;

    @Column(name = "responsavel_recurso_quarta_instancia")
    private String responsavelRecursoQuartaInstancia;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_unidade")
    private Unidade unidade;
}
