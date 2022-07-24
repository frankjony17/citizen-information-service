package br.com.company.fks.modelo.dto;

import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class EmailDTO {
    private Long id;
    private Integer tipoSolicitacao;
    private String descricaoTipoSolicitacao;
    private Integer tipoAlerta;
    private String descricaoTipoAlerta;
    private Integer dataReferencia;
    private Integer dataEnvioEmail;
    private Integer statusDemanda;
    private Integer diasAnteDataReferencia;
    private Integer diasAposDataReferencia;
    private Boolean reenviarAteAlteracaoDoStatus;
    private Integer acaoExecutada;
    private String assuntoEmail;
    private String conteudoEmail;
    private List<PerfilDTO> destinatarios;
}
