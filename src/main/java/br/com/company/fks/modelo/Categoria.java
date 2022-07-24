package br.com.company.fks.modelo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "tb_categoria", schema = "fks")
public class Categoria implements Serializable {

    @Id
    @Column(name = "id_categoria")
    private Long id;

    @Column(name = "num_categoria")
    private String numeroCategoria;

    @Column(name = "ds_categoria")
    private String descricao;

}
