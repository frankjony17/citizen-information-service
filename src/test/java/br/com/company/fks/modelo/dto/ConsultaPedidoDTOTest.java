package br.com.company.fks.modelo.dto;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.Calendar;

import static org.junit.Assert.*;

@RunWith(PowerMockRunner.class)
public class ConsultaPedidoDTOTest {

    @InjectMocks
    private ConsultaPedidoDTO consultaPedidoDTO;

    @Mock
    private Calendar prazoVencimento;

    @Mock
    private Calendar dataAbertura;

    @Mock
    private Calendar prazoVencimentoESic;
    @Test
    public void getIdPedido() {
        consultaPedidoDTO.getIdPedido();
    }

    @Test
    public void getProtocolo() {
        consultaPedidoDTO.getProtocolo();
    }

    @Test
    public void getNomeSolicitante() {
        consultaPedidoDTO.getNomeSolicitante();
    }

    @Test
    public void getNomeTema() {
        consultaPedidoDTO.getNomeTema();
    }

    @Test
    public void getNomeStatusTramitacao() {
        consultaPedidoDTO.getNomeStatusTramitacao();
    }

    @Test
    public void getDataAbertura() {
        consultaPedidoDTO.getDataAbertura();
    }

    @Test
    public void getPrazoVencimento() {
        consultaPedidoDTO.getPrazoVencimento();
    }

    @Test
    public void getPrazoVencimentoESic() {
        consultaPedidoDTO.getPrazoVencimentoESic();
    }

    @Test
    public void getIsEouv() {
        consultaPedidoDTO.getIsEouv();
    }

    @Test
    public void getNomeStatusSolicitacao() {
        consultaPedidoDTO.getNomeStatusSolicitacao();
    }

    @Test
    public void getCodigoUnidade() {
        consultaPedidoDTO.getCodigoUnidade();
    }

    @Test
    public void getCodigoSubunidade() {
        consultaPedidoDTO.getCodigoSubunidade();
    }

    @Test
    public void isTecnicoResponsavel() {
        consultaPedidoDTO.isTecnicoResponsavel();
    }

    @Test
    public void setIdPedido() {
        consultaPedidoDTO.setIdPedido(1L);
    }

    @Test
    public void setProtocolo() {
        consultaPedidoDTO.setProtocolo("protocolo");
    }

    @Test
    public void setNomeSolicitante() {
        consultaPedidoDTO.setNomeSolicitante("nomeSolicitante");
    }

    @Test
    public void setNomeTema() {
        consultaPedidoDTO.setNomeTema("nomeTema");
    }

    @Test
    public void setNomeStatusTramitacao() {
        consultaPedidoDTO.setNomeStatusTramitacao("statusTramitacao");
    }

    @Test
    public void setDataAbertura() {
        consultaPedidoDTO.setDataAbertura(dataAbertura);
    }

    @Test
    public void setPrazoVencimento() {
        consultaPedidoDTO.setPrazoVencimento(prazoVencimento);
    }

    @Test
    public void setPrazoVencimentoESic() {
        consultaPedidoDTO.setPrazoVencimentoESic(prazoVencimentoESic);
    }

    @Test
    public void setIsEouv() {
        consultaPedidoDTO.setIsEouv(true);
    }

    @Test
    public void setNomeStatusSolicitacao() {
        consultaPedidoDTO.setNomeStatusTramitacao("nomeStatusTramitacao");
    }

    @Test
    public void setCodigoUnidade() {
        consultaPedidoDTO.setCodigoUnidade("codigoUnidade");
    }

    @Test
    public void setCodigoSubunidade() {
        consultaPedidoDTO.setCodigoSubunidade("subunidade");
    }

    @Test
    public void setTecnicoResponsavel() {
        consultaPedidoDTO.setTecnicoResponsavel(true);
    }
}