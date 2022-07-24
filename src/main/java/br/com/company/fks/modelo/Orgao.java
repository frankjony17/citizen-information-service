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
@Table(name = "tb_orgao",schema = "fks")
public class Orgao implements Serializable {

    @Id
    @Column(name = "id_orgao")
    private Long id;

    @Column(name = "nm_orgao")
    private String descricao;

}
