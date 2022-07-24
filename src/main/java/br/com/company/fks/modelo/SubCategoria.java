package br.com.company.fks.modelo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "tb_sub_categoria", schema = "fks")
public class SubCategoria implements Serializable {

    @Id
    @Column(name = "id_sub_categoria")
    private Integer id;

    @Column(name = "ds_sub_categoria")
    private String descricao;

    @OneToOne
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;

}
