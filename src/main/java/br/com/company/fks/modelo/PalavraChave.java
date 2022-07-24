package br.com.company.fks.modelo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "tb_palavra_chave")
public class PalavraChave implements Serializable {

    @Id
    @Column(name = "id_palavra_chave")
    @SequenceGenerator(allocationSize = 1, initialValue = 1, sequenceName = "fks.seq_tb_palavra_chave", name = "seq_tb_palavra_chave")
    @GeneratedValue(generator = "seq_tb_palavra_chave", strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "ds_palavra_chave")
    private String descricao;

}
