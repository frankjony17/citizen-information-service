package br.com.company.fks.modelo.dto;

import lombok.Getter;
import lombok.Setter;
import java.util.Calendar;

@Getter
@Setter
public class FiltroRecursoDTO {
    private int idDemandasComigo;
    private Integer offset;
    private Integer limit;
    private Long idStatusTramitacao;
    private Long idStatusSolicitacao;
    private String protocolo;
    private Long idTipoResposta;
    private Long idUnidade;
    private Long idSubunidade;
    private Calendar periodoInicialDataAbertura;
    private Calendar periodoFinalDataAbertura;
    private Calendar periodoInicialPrazoAtendimento;
    private Calendar periodoFinalPrazoAtendimento;
    private String tipoPessoa;
    private Long idInstanciaRecurso;
    private Calendar periodoInicialDecisaoCgu;
    private Calendar periodoFinalDecisaoCgu;
    private Calendar periodoInicialDecisaoCmri;
    private Calendar periodoFinalDecisaoCmri;
    private Calendar periodoInicialVencimentoEsic;
    private Calendar periodoFinalVencimentoEsic;
    private Long idSituacaoRecurso;
    private Long idTipoRecurso;
    private String descricaoJustificativa;
    private String nomeSolicitante;
    private Calendar prazoVencidoFKS;
    private Calendar prazoVencidoEsic;
}
