package br.com.company.fks.modelo.dto;

import lombok.Getter;
import lombok.Setter;
import java.util.Calendar;

@Getter
@Setter
public class RecursoRelatorioDTO {
    private String protocolo;
    private String nomeStatusTramitacao;
    private String nomeStatusSolicitacao;
    private String nomeTipoSituacaoRecurso;
    private Calendar dataAbertura;
    private String nomeSolicitante;
    private Calendar prazoAtendimento;
    private String nomeInstanciaRecurso;
    private Calendar vencimentoESic;
    private String nomeTipoRecurso;
    private String justificativa;
}
