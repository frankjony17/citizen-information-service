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
@Table(name = "tb_status_tramitacao")
public class StatusTramitacao implements Serializable {

    public static final Long SIC = 1L;
    public static final Long ANDAMENTO = 2L;
    public static final Long RESPONDIDAS = 3L;
    public static final Long PARA_REVISAO = 4L;
    public static final Long ENVIADAS = 5L;
    public static final Long REENCAMINHADA = 6L;
    public static final Long PARA_ENVIO = 7L;
    public static final Long E_OUV = 8L;

    @Id
    @Column(name = "id_status_tramitacao")
    @SequenceGenerator(allocationSize = 1, initialValue = 1, sequenceName = "fks.seq_tb_status_tramitacao", name = "seq_tb_status_tramitacao")
    @GeneratedValue(generator = "seq_tb_status_tramitacao", strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nm_nome")
    private String nome;
}
