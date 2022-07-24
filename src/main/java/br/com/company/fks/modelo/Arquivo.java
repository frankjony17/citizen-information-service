package br.com.company.fks.modelo;

import lombok.Getter;
import lombok.NoArgsConstructor;
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
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "tb_upload_arquivo")
@NoArgsConstructor
public class Arquivo implements Serializable {
    @Getter
    @Setter
    @Id
    @Column(name = "id_upload_arquivo")
    @SequenceGenerator(allocationSize = 1, initialValue = 1, sequenceName = "fks.seq_tb_upload_arquivo", name = "seq_tb_upload_arquivo")
    @GeneratedValue(generator = "seq_tb_upload_arquivo", strategy = GenerationType.AUTO)
    private Long id;

    @Getter
    @Setter
    @Column(name = "nm_nome")
    private String nome;

    @Getter
    @Setter
    @Column(name = "tp_extensao")
    private String extensao;

    @Getter
    @Setter
    @Column(name = "num_tamanho")
    private Long tamanho;

    @Getter
    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pedido")
    private Pedido pedido;

    @Getter
    @Setter
    @Column(name="dir_arquivo")
    private String diretorioArquivo;

    @Getter
    @Setter
    @NotNull
    @Column(name="nome_identificador")
    private String nomeIdentificador;

    @Getter
    @Setter
    @Column(name="ds_content_type")
    private String contentType;


    @Column(name="ar_binario")
    private byte [] binario;

    public Arquivo(Long id){
        this.id = id;
    }

}
