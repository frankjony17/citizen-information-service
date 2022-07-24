package br.com.company.fks.repositorio;

import br.com.company.fks.modelo.Andamento;
import br.com.company.fks.modelo.Pedido;
import br.com.company.fks.modelo.dto.AndamentoPedidoDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AndamentoRepository extends JpaRepository<Andamento, Long> {

    @Query("SELECT andamento FROM Andamento andamento " +
            "WHERE pedido.id = :idPedido " +
            "ORDER BY andamento.dataInicio DESC")
    List<Andamento> recuperarAndamentosPedido(@Param("idPedido") Long idPedido);

    @Query("SELECT new br.gov.mpog.fks.modelo.dto.AndamentoPedidoDTO(andamento.dataInicio, andamento.dataFim," +
            "andamento.responsavel, andamento.observacao, status.nome, statusSolicitacao.nome) from Andamento andamento " +
            "JOIN andamento.statusTramitacao status " +
            "JOIN andamento.statusSolicitacao statusSolicitacao " +
            "WHERE andamento.pedido = :pedido " +
            "ORDER BY andamento.id DESC")
    Page<AndamentoPedidoDTO> recuperarAndamentoPedidoEStatusTramitacao(@Param("pedido") Pedido pedido, Pageable pageable);

    @Query("SELECT andamento FROM Andamento andamento " +
            "WHERE pedido.id = :idPedido " +
            "ORDER BY andamento.id ASC")
    List<Andamento> findByPedido(@Param("idPedido") Long idPedido);

    Andamento findTopByPedidoIdAndStatusSolicitacaoId (Long idPedido, Long idStatusSolicitacao);

    Andamento findTopByPedidoId (Long idPedido);
}
