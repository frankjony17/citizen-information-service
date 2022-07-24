package br.com.company.fks.servico;

import br.com.company.fks.excecao.IntegracaoException;
import br.com.company.fks.modelo.Pedido;
import br.com.company.fks.modelo.StatusSolicitacao;
import br.com.company.fks.modelo.dto.ConsultaPedidoDulplicadoDTO;
import br.com.company.fks.repositorio.PedidoDuplicadoRepository;
import br.com.company.fks.repositorio.PedidoRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PedidoDuplicadoServiceTest {

    @InjectMocks
    private PedidoDuplicadoService service;

    @Mock
    private PedidoRepository repository;

    @Mock
    private PedidoDuplicadoRepository pedidoDuplicadoRepository;

    @Test
    public void buscarProtocoloPedidoPai(){
        Pedido pedido = new Pedido();
        pedido.setId(1L);
        service.buscarProtocoloPedidoPai(1L);
    }

    @Test
    public void buscarPedidoPaiPedidoDuplicado(){
        Pedido pedido = new Pedido();
        pedido.setId(2L);
        when(repository.findOne(anyLong())).thenReturn(pedido);
        service.buscarPedidoPaiPedidoDuplicado(2L);
    }

    @Test
    public void buscarPedidoPeloProtocolo(){
        ConsultaPedidoDulplicadoDTO consultaPedidoDulplicadoDTO = new ConsultaPedidoDulplicadoDTO();
        Pedido pedido = new Pedido();
        StatusSolicitacao statusSolicitacao = new StatusSolicitacao();
        pedido.getStatusSolicitacao();
        pedido.setStatusSolicitacao(statusSolicitacao);
        when(pedidoDuplicadoRepository.buscarPedidoPeloProtocolo(anyString())).thenReturn(pedido);
        service.buscarPedidoPeloProtocolo("protocolo");
    }

    @Test
    public void vincularPedidoDuplicado() throws IntegracaoException {
        Pedido pedidoPai = new Pedido();
        Pedido pedidoFilho = new Pedido();
        when(repository.findOne(anyLong())).thenReturn(pedidoPai);
        when(repository.findOne(anyLong())).thenReturn(pedidoFilho);
        service.vincularPedidoDuplicado(1L,2L);
    }

}