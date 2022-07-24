package br.com.company.fks.modelo.dto;

import lombok.Getter;
import lombok.Setter;
import java.util.Calendar;

@Getter
@Setter
public class ConsultaRecursoDTO {
    private Long idRecurso;
    private Long idPedido;
    private String protocolo;
    private String nomeTipoRecurso;
    private Calendar dataAbertura;
    private Calendar prazoAtendimento;
    private Calendar vencimentoUnidade;
    private String nomeSituacaoRecurso;
    private Calendar dataResposta;
    private String nomeSolicitante;
}
