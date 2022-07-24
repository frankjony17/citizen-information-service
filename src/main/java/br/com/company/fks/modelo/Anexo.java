package br.com.company.fks.modelo;

import lombok.Getter;
import lombok.Setter;

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

@Entity
@Getter
@Setter
@Table(name = "tb_anexo")
public class Anexo implements Serializable {
    @Id
    @Column(name = "id_anexo")
    @SequenceGenerator(allocationSize = 1, initialValue = 1, sequenceName = "fks.seq_tb_anexo", name = "seq_tb_anexo")
    @GeneratedValue(generator = "seq_tb_anexo", strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nm_nome")
    private String nome;

    @Column(name = "tp_extensao")
    private String extensao;

    @Column(name = "num_tamanho")
    private Long tamanho;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pedido")
    private Pedido pedido;
}
