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
@Table(name = "tb_tipo_recurso")
public class TipoRecurso implements Serializable {

    public static final String AUSENCIA_DE_JUSTIFICATIVA_LEGAL_PARA_CLASSIFICACAO = "Ausência de justificativa legal para classificação";
    public static final String AUTORIDADE_CLASSIFICADORA_NAO_INFORMADA = "Autoridade classificadora não informada";
    public static final String DATA_DA_CLASSIFICACAO_DE_INICIO_OU_FIM_NAO_INFORMADA = "Data da classificação (de inicio ou fim) não informada";
    public static final String DEFERIMENTO_DE_PEDIDO_DE_REVISAO_PARA_TRANSFORMAR_PEDIDO_EM_MANIFESTACAO = "Deferimento de pedido de revisão para transformar pedido em manifestação";
    public static final String GRAU_DE_CLASSIFICACAO_INEXISTENTE = "Grau de classificação inexistente";
    public static final String GRAU_DE_SIGILO_NAO_INFORMADO = "Grau de sigilo não informado";
    public static final String INFORMACAO_CLASSIFICADA_POR_AUTORIDADE_SEM_COMPETENCIA = "Informação classificada por autoridade sem competência";
    public static final String INFORMACAO_INCOMPLETA = "Informação incompleta";
    public static final String INFORMACAO_RECEBIDA_NAO_CORRESPONDE_A_SOLICITADA = "Informação recebida não corresponde à solicitada";
    public static final String INFORMACAO_RECEBIDA_POR_MEIO_DIFERENTE_DO_SOLICITADO = "Informação recebida por meio diferente do solicitado";
    public static final String JUSTIFICATIVA_PARA_O_SIGILO_INSATISFATORIA_NAO_INFORMADA = "Justificativa para o sigilo insatisfatória/não informada";
    public static final String OUTROS = "Outros";
    public static final String PRAZO_DE_CLASSIFICACAO_INADEQUADO_PARA_O_GRAU_DE_SIGILO = "Prazo de classificação inadequado para o grau de sigilo";
    public static final String RESPOSTA_NAO_FOI_DADA_NO_PRAZO = "Resposta não foi dada no prazo";

    @Id
    @Column(name = "id_tipo_recurso")
    private Long id;

    @Column(name = "nm_nome")
    private String nome;
}
