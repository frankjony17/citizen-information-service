package br.com.company.fks.modelo.dto;

import br.com.company.fks.modelo.Tema;
import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Getter
@Setter
public class PedidoDetalhadoDTO {
    private Long idPedido;
    private List<Long> idRecurso;
    private String protocolo;
    private String nomeStatusSolicitacao;
    private Calendar dataAbertura;
    private Calendar vencimentoUnidade;
    private SolicitanteDTO solicitanteDTO;
    private String nomeSituacaoPedido;
    private String resumoSolicitacao;
    private String detalhamentoSolicitacao;
    private String observacao;
    private String formaRecebimento;
    private Calendar vencimentoESic;
    private String respostaFKS;
    private Calendar dataRespostaEsic;
    private String orgaoVinculado;
    private Boolean possuiTratamentoFinal;
    private Calendar dataEntradaProtocoloSistemaFKS;
    private boolean isProrrogado;
    private boolean isProrrogadoESic;
    private boolean possuiEOuv;
    private Calendar vencimentoUnidadeProrrodadoFKS;
    private Boolean isDevolver;
    private Boolean isClassificacaoResposta;
    private Boolean isClassificacaoRespostaSic;
    private Calendar dataLimiteBotaoProrrogacao;
    private Calendar dataLimiteBotaoEouv;
    private List<AnexoPedidoDetalhadoDTO> anexos = new ArrayList<>();
    private String resposta;
    private String perfilUsuario;
    private String propostaResposta;
    private boolean possuiClassificacaoResposta;
    private boolean possuiClassificacaoRespostaSic;
    private Tema tema;
    private boolean respostaAssinada;
    private boolean isPossuiRespostaPerfil;
    private String statusQueAssinou;
    private String codigoUnidade;
    private String codigoSubunidade;
    private boolean diasUteisMaior10;
}
