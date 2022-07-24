package br.com.company.fks.modelo;

import lombok.Getter;
import lombok.Setter;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.SequenceGenerator;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "tb_alertas",schema = "fks")
public class Alertas implements Serializable {

    @Id
    @Column(name = "id_alerta")
    @SequenceGenerator(allocationSize = 1, initialValue = 1, sequenceName = "fks.seq_tb_alerta", name = "seq_tb_alerta")
    @GeneratedValue(generator = "seq_tb_alerta", strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "ds_alerta")
    private String alerta;

}
