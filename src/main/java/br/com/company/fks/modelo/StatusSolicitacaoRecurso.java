package br.com.company.fks.modelo;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Getter
@Setter
@Table(name = "tb_status_solicitacao_recurso")
public class StatusSolicitacaoRecurso implements Serializable {

    public static final String RECURSO_PRIMEIRA_DISTRIBUICAO_PF ="Recurso 1ª Distribuição PF";
    public static final Long RECURSO_1_TRIAGEM = 1L;
    public static final Long RECURSO_1_DISTRIBUICAO_PF = 2L;
    public static final Long RECURSO_1_PRODUCAO = 3L;
    public static final Long RECURSO_1_ASSINADO = 4L;
    public static final Long RECURSO_1_RESPONDIDO = 5L;
    public static final Long RECURSO_1_PARA_REVISAO = 6L;
    public static final Long RECURSO_1_PARA_ENVIO = 7L;
    public static final Long RECURSO_1_ENVIADO = 8L;
    public static final Long RECURSO_2_TRIAGEM = 9L;
    public static final Long RECURSO_2_DISTRIBUICAO_PF = 10L;
    public static final Long RECURSO_2_PRODUCAO = 11L;
    public static final Long RECURSO_2_ASSINADO = 12L;
    public static final Long RECURSO_2_RESPONDIDO = 13L;
    public static final Long RECURSO_2_PARA_REVISAO = 14L;
    public static final Long RECURSO_2_PARA_ENVIO = 15L;
    public static final Long RECURSO_2_ENVIADO = 16L;

    @Id
    @Column(name = "id_status_solicitacao_recurso")
    private Long id;

    @Column(name = "nm_nome")
    private String nome;
}
