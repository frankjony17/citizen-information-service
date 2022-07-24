package br.com.company.fks.modelo.dto;

import lombok.Getter;
import lombok.Setter;
import java.util.Calendar;

@Getter
@Setter
public class FiltroPedidoDTO {
    private Integer offset;
    private Integer limit;
    private Long idStatusTramitacao;
    private String protocolo;
    private Long idUnidade;
    private Long idSubUnidade;
    private Calendar periodoInicialDataAbertura;
    private Calendar periodoFinalDataAbertura;
    private Calendar periodoInicialPrazoAtendimento;
    private Calendar periodoFinalPrazoAtendimento;
    private Calendar prazoVencidoFKS;
    private Boolean prazoProrrogadoFKS;
    private String nomeSolicitante;
    private String tipoPessoa;
    private Long idStatusSolicitacao;
    private Long idStatusSituacao;
    private Long idOrigemSolicitacao;
    private Long idSituacaoPedido;
    private Long idComplementoSituacao;
    private Long idTema;
    private Long idSubTema;
    private Long idAtendente;
    private Long idClassificacaoConteudo;
    private String textoSolicitacao;
    private String textoResposta;
    private Calendar prazoVencidoEsic;
    private Boolean prazoProrrogadoEsic;
    private Calendar periodoInicialVencimentoEsic;
    private Calendar periodoFinalVencimentoEsic;
    private Long idPalavraChave;
    private int idDemandasComigo;
}
