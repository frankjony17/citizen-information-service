package br.com.company.fks.servico;

import br.com.company.fks.repositorio.PedidoDuplicadoRepository;
import br.com.company.fks.repositorio.PedidoRepository;
import br.com.company.fks.excecao.IntegracaoException;
import br.com.company.fks.modelo.Pedido;
import br.com.company.fks.modelo.dto.ConsultaPedidoDulplicadoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PedidoDuplicadoService {

    @Autowired
    private PedidoDuplicadoRepository pedidoDuplicadoRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    public ConsultaPedidoDulplicadoDTO buscarPedidoPeloProtocolo(String protocolo) {
        Pedido pedido = pedidoDuplicadoRepository.buscarPedidoPeloProtocolo(protocolo);
        ConsultaPedidoDulplicadoDTO consultaPedidoDulplicadoDTO = new ConsultaPedidoDulplicadoDTO();
        consultaPedidoDulplicadoDTO.setIdPedido(pedido.getId());
        consultaPedidoDulplicadoDTO.setProtocolo(pedido.getProtocolo());
        consultaPedidoDulplicadoDTO.setNomeStatusSolicitacao(pedido.getStatusSolicitacao().getNome());
        consultaPedidoDulplicadoDTO.setDataVencimentoESic(pedido.getVencimentoUnidade());

        return consultaPedidoDulplicadoDTO;
    }

    @Transactional
    public Pedido vincularPedidoDuplicado(Long pedidoFilhoId, Long pedidoPaiId) throws IntegracaoException {
        Pedido pedidoPai = pedidoRepository.findOne(pedidoPaiId);
        Pedido pedidoFilho = pedidoRepository.findOne(pedidoFilhoId);
        if (pedidoPai.getPedidoDuplicado() != null || pedidoPaiId.equals(pedidoFilhoId)) {
            throw new IntegracaoException("Pedido é filho");
        } else {
            pedidoFilho.setPedidoDuplicado(pedidoPai);
            pedidoRepository.save(pedidoFilho);
        }
        return pedidoFilho;
    }

    public Pedido buscarPedidoPaiPedidoDuplicado(Long idPedido) {
        Pedido pedido = pedidoRepository.findOne(idPedido);
        return pedido.getPedidoDuplicado();
    }

    public Pedido buscarProtocoloPedidoPai(Long idPedido) {
        Pedido pedido = pedidoRepository.findOne(idPedido);
        return pedido;
    }
}
