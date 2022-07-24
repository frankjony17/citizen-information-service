package br.com.company.fks.modelo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DevolvePedidoDTO {
    public static final String TRIAGEM_SIC = "Triagem SIC";
    public static final String RESPOSTA_SIC = "Resposta SIC";
    public static final String PRODUCAO_RESPOSTA = "Produção de Resposta";
    public static final String RESPOSTA_ASSINADA = "Resposta Assinada";
    public static final String DISTRIBUICAO_PF = "Distribuição PF";
    public static final String REVISAO = "Revisão";
    public static final String EDICAO_TECNICO = "Técnico";

    private Long idPedido;
    private String justificativa;
    private String nomeStatusSolicitacao;
}
