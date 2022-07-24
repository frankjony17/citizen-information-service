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
@Table(name = "tb_status_solicitacao")
public class StatusSolicitacao implements Serializable {

    public static final Long TRIAGEM_SIC = 1L;
    public static final Long RESPOSTA_SIC = 2L;
    public static final Long DISTRIBUICAO_PF = 3L;
    public static final Long REVISAO = 4L;
    public static final Long PARA_ENVIO = 5L;
    public static final Long RESPOSTA_ASSINADA_PF = 6L;
    public static final Long PRODUCAO_RESPOSTA = 7L;
    public static final Long EDICAO_TECNICO = 8L;
    public static final Long ENVIADA = 9L;
    public static final Long REENCAMINHADA= 10L;
    public static final Long SUGESTAO_DE_REENCAMINHAMENTO = 11L;
    public static final Long IDENTIDADE_PRESERVADA = 12L;

    @Id
    @Column(name = "id_status_solicitacao")
    @SequenceGenerator(allocationSize = 1, initialValue = 1, sequenceName = "fks.seq_tb_status_solicitacao", name = "seq_tb_status_solicitacao")
    @GeneratedValue(generator = "seq_tb_status_solicitacao", strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nm_nome")
    private String nome;
}
