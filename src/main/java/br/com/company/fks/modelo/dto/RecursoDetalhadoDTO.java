package br.com.company.fks.modelo.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Calendar;

@Getter
@Setter
public class RecursoDetalhadoDTO {
    private Long idRecurso;
    private String protocolo;
    private String nomeStatusSolicitacao;
    private Calendar dataAbertura;
    private Calendar vencimentoUnidade;
    private SolicitanteDTO solicitanteDTO;
    private String nomeTipoRecurso;
    private String nomeSituacaoRecurso;
    private Calendar dataPrazoAtendimento;
    private String justificativa;
    private String propostaResposta;
    private String respostaESic;
    private Boolean statusRespostaAssinada;
    private String observacao;
}
