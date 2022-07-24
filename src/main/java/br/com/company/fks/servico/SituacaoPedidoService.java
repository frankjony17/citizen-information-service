package br.com.company.fks.servico;

import br.com.company.fks.repositorio.SituacaoPedidoRepository;
import br.com.company.fks.modelo.SituacaoPedido;
import br.com.company.fks.modelo.dto.SituacaoPedidoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SituacaoPedidoService {

    @Autowired
    private SituacaoPedidoRepository situacaoPedidoRepository;

    public List<SituacaoPedidoDTO> consultarSituacaoPedido() {
        List<SituacaoPedido> listaSituacaoPedido = situacaoPedidoRepository.findAll();
        return converterParaSituacaoPedidoDTO(listaSituacaoPedido);
    }

    private List<SituacaoPedidoDTO> converterParaSituacaoPedidoDTO(List<SituacaoPedido> listaSituacaoPedido) {
        List<SituacaoPedidoDTO> listaSituacaoPedidoDTO = new ArrayList<>();
        for (SituacaoPedido situacaoPedido : listaSituacaoPedido) {
            SituacaoPedidoDTO situacaoPedidoDTO = new SituacaoPedidoDTO();
            situacaoPedidoDTO.setId(situacaoPedido.getId());
            situacaoPedidoDTO.setNome(situacaoPedido.getNome());
            listaSituacaoPedidoDTO.add(situacaoPedidoDTO);
        }
        return listaSituacaoPedidoDTO;
    }
}
