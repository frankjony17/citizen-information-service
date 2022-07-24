package br.com.company.fks.modelo.dto;

import br.com.company.fks.modelo.Orgao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class ReencaminharSolicitacaoDTOTest {
    @InjectMocks
    private ReencaminharSolicitacaoDTO dto;

    @Test
    public void ReencaminharSolicitacaoDTO(){
        Orgao orgao = new Orgao();
        dto.getId();
        dto.setId(1L);
        dto.getOrgao();
        dto.setOrgao(orgao);
        dto.getNotificacaoEnviadaSolicitante();
        dto.setNotificacaoEnviadaSolicitante("notificacaoEnviadaSolicitante");
        dto.getNotificacaoEnviadaDestinatario();
        dto.setNotificacaoEnviadaDestinatario("notificacaoEnviadaDestinatario");
        dto.getIdPedido();
        dto.setIdPedido(1L);
    }

}