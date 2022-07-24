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
@Table(name = "tb_tipo_tratamento")
public class TipoTratamento implements Serializable {

    public static final Long RESPOSTA = 1L;
    public static final Long RESPOSTA_EDITADA = 2L;
    public static final Long RESPOSTA_ASSINADA = 3L;
    public static final Long PROPOSTA_RESPOSTA = 4L;
    public static final Long ENCAMINHADA_EOUV = 5L;
    public static final Long RESPOSTA_CANCELADA = 6L;
    public static final Long SUGESTAO_DE_ENCAMINHAMENTO_EOUV_CANCELADA = 7L;

    @Id
    @Column(name = "id_tipo_tratamento")
    @SequenceGenerator(allocationSize = 1, initialValue = 1, sequenceName = "fks.seq_tb_tipo_tratamento", name = "seq_tb_tipo_tratamento")
    @GeneratedValue(generator = "seq_tb_tipo_tratamento", strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "tp_tipo_tratamento")
    private String tipoTratamento;
}
