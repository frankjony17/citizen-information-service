package br.com.company.fks.servico;

import br.com.company.fks.repositorio.HistoricoTratamentoRepository;
import br.com.company.fks.repositorio.PedidoRepository;
import br.com.company.fks.modelo.HistoricoTratamento;
import br.com.company.fks.modelo.Pedido;
import br.com.company.fks.modelo.TipoTratamento;
import br.com.company.fks.modelo.dto.ConsultaHistoricoPedidoDTO;
import br.com.company.fks.utils.UsuarioLogadoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.List;

@Service
public class HistoricoTratamentoService {

    @Autowired
    private HistoricoTratamentoRepository historicoTratamentoRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private PedidoService pedidoService;

    @Autowired
    private UsuarioLogadoUtil usuarioLogadoUtil;

    @Transactional
    public void gerarHistoricoTratamento(Pedido pedido, Long idTipoTratamento, Boolean statusResposta) {
        HistoricoTratamento historicoTratamento = new HistoricoTratamento();
        historicoTratamento.setData(Calendar.getInstance());
        historicoTratamento.setPedido(pedido);
        historicoTratamento.setTipoTratamento(new TipoTratamento());
        historicoTratamento.getTipoTratamento().setId(idTipoTratamento);
        historicoTratamento.setRespostaPedido(pedido.getRespostaEsic());
        historicoTratamento.setNomeResponsavel(usuarioLogadoUtil.getNome());
        historicoTratamento.setStatusRespostaAssinada(statusResposta);
        historicoTratamentoRepository.save(historicoTratamento);
    }

    public String recuperarRespostaPedido(Long idPedido) {
        List<HistoricoTratamento> listaHistoricoTratamento;
        listaHistoricoTratamento = historicoTratamentoRepository.recuperarHistoricoPorIdPedido(idPedido);
        if (listaHistoricoTratamento.size() > 0) {
            HistoricoTratamento ultimoHistoricoTratamento = listaHistoricoTratamento.get(listaHistoricoTratamento.size() - 1);
            return ultimoHistoricoTratamento.getRespostaPedido();
        }
        return null;
    }

    public String recuperarRespostaPedidoPerfil(Long idPedido){
        String perfil = usuarioLogadoUtil.getNome();
        List<HistoricoTratamento> listaHistoricoTratamento;
        listaHistoricoTratamento = historicoTratamentoRepository.recuperarHistoricoPorIdPedido(idPedido);
        List<ConsultaHistoricoPedidoDTO>  historicoPedidoDTOList = pedidoService.montarListaConsultaPedidoDTOPorHistorico(listaHistoricoTratamento);
        if (historicoPedidoDTOList.size() > 0) {
            for(ConsultaHistoricoPedidoDTO historicoTratamento : historicoPedidoDTOList){
                if(!historicoTratamento.getNomeResponsavel().equals(perfil)){
                    return historicoTratamento.getResposta();
                }
            }
        }
        return null;
    }

    public Page<ConsultaHistoricoPedidoDTO> consultarHistoricoPedido(Long idPedido, Integer offset, Integer limit) {
        Pageable pageable = new PageRequest(offset, limit);

        return historicoTratamentoRepository.recuperarHistoricoPedido(pedidoRepository.findById(idPedido), pageable);
    }

    public HistoricoTratamento buscarRespostaHistorico(Long id) {
        return historicoTratamentoRepository.findOne(id);

    }

    public List<HistoricoTratamento> recuperarHistoricos(Long idPedido){
        return historicoTratamentoRepository.recuperarHistoricos(idPedido);
    }

}
