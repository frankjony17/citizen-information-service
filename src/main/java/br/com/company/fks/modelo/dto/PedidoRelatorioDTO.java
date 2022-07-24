package br.com.company.fks.modelo.dto;

import lombok.Getter;
import lombok.Setter;
import java.util.Calendar;

@Getter
@Setter
public class PedidoRelatorioDTO {
    private String protocolo;
    private String statusTramitacao;
    private String statusSolicitacao;
    private String unidade;
    private String subUnidade;
    private Calendar dataRegistro;
    private Calendar dataRespostaESic;
    private Calendar vencimentoUnidade;
    private Calendar vencimentoEsic;
    private String assunto;
    private String subAssunto;
    private String palavraChave;
    private String atendente;
    private String nomeSolicitante;
    private String classificacaoConteudo;
    private String resumoSolicitacao;
    private String descricaoPedido;
    private String resposta;
    private String recurso1Instancia;
    private String respostaRecurso1Instancia;
    private String recurso2Instancia;
    private String respostaRecurso2Instancia;
}
