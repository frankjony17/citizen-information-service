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
@Table(name = "tb_status_situacao")
public class StatusSituacao implements Serializable {

    public static final Long ACESSO_CONCEDIDO = 1L;
    public static final Long ACESSO_NEGADO = 2L;
    public static final Long ACESSO_PARCIALMENTE_CONCEDIDO = 3L;
    public static final Long INFORMACAO_INEXISTENTE = 4L;
    public static final Long NAO_SE_TRATA_DE_SOLICITACAO_DE_INFORMACAO = 5L;
    public static final Long ORGAO_NAO_TEM_COMPETENCIA_PARA_RESPONDER_SOBRE_O_ASSUNTO= 6L;
    public static final Long PERGUNTA_DUPLICADA_OU_REPETIDA = 7L;
    public static final Long PEDIDO_EM_ANDAMENTO = 8L;
    public static final Long PEDIDO_PRORROGADO = 9L;
    public static final Long PEDIDO_REENCAMINHADO = 10L;
    public static final Long PEDIDO_REGISTRADO = 11L;



    @Id
    @Column(name = "id_status_situacao")
    @SequenceGenerator(allocationSize = 1, initialValue = 1, sequenceName = "fks.seq_tb_status_situacao", name = "seq_tb_status_situacao")
    @GeneratedValue(generator = "seq_tb_status_situacao", strategy = GenerationType.AUTO)
    private Long id;

    @Column(name ="nm_situacao" )
    private String nome;

}
