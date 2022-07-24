package br.com.company.fks.modelo.dto;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class EmailDTOTest {
    @InjectMocks
    private EmailDTO dto;

    @Test
    public void EmailDTO(){
        List<PerfilDTO> destinatarios = new ArrayList<>();
        dto.getId();
        dto.setId(1L);
        dto.getTipoSolicitacao();
        dto.setTipoSolicitacao(1);
        dto.getDescricaoTipoSolicitacao();
        dto.setDescricaoTipoSolicitacao("descricaoTipoSolicitacao");
        dto.getTipoAlerta();
        dto.setTipoAlerta(1);
        dto.getDescricaoTipoAlerta();
        dto.setDescricaoTipoAlerta("descricaoTipoAlerta");
        dto.getDataReferencia();
        dto.setDataReferencia(1);
        dto.getDataEnvioEmail();
        dto.setDataEnvioEmail(1);
        dto.getStatusDemanda();
        dto.setStatusDemanda(1);
        dto.getDiasAnteDataReferencia();
        dto.setDiasAnteDataReferencia(2);
        dto.getDiasAposDataReferencia();
        dto.setDiasAposDataReferencia(2);
        dto.getReenviarAteAlteracaoDoStatus();
        dto.setReenviarAteAlteracaoDoStatus(true);
        dto.getAcaoExecutada();
        dto.setAcaoExecutada(1);
        dto.getAssuntoEmail();
        dto.setAssuntoEmail("assuntoEmail");
        dto.getConteudoEmail();
        dto.setConteudoEmail("conteudoEmail");
        dto.getDestinatarios();
        dto.setDestinatarios(destinatarios);
    }

}