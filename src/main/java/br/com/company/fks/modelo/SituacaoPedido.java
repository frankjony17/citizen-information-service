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

@Entity
@Getter
@Setter
@Table(name = "tb_situacao_pedido")
public class SituacaoPedido implements Serializable {

    public static final String EM_TRAMITACAO = "Em Tramitação";
    public static final String RESPONDIDO = "Respondido";
    public static final String REENCAMINHADO = "Reencaminhado ";
    public static final String ENCAMINHADA_PARA_EOUV = "Encaminhada para e-Ouv";

    @Id
    @Column(name = "id_situacao_pedido")
    @SequenceGenerator(allocationSize = 1, initialValue = 1, sequenceName = "fks.seq_tb_situacao_pedido", name = "seq_tb_situacao_pedido")
    @GeneratedValue(generator = "seq_tb_situacao_pedido", strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nm_nome")
    private String nome;
}
