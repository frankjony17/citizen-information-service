package br.com.company.fks.repositorio;

import br.com.company.fks.modelo.HistoricoTratamento;
import br.com.company.fks.modelo.Pedido;
import br.com.company.fks.modelo.dto.ConsultaHistoricoPedidoDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistoricoTratamentoRepository extends JpaRepository<HistoricoTratamento, Long> {

    @Query("SELECT new br.gov.mpog.fks.modelo.dto.ConsultaHistoricoPedidoDTO(historicoTratamento.id, historicoTratamento.data, historicoTratamento.nomeResponsavel, tratamento.tipoTratamento) from HistoricoTratamento historicoTratamento " +
            "JOIN historicoTratamento.tipoTratamento tratamento " +
            "WHERE historicoTratamento.pedido = :pedido " +
            "ORDER BY historicoTratamento.id DESC")
    Page<ConsultaHistoricoPedidoDTO> recuperarHistoricoPedido(@Param("pedido") Pedido pedido, Pageable pageable);

    @Query("SELECT historicoTratamento FROM HistoricoTratamento historicoTratamento " +
            "WHERE pedido.id = :idPedido ")
    List<HistoricoTratamento> recuperarHistoricoPorIdPedido(@Param("idPedido") Long idPedido);


    @Query("SELECT historicoTratamento FROM HistoricoTratamento historicoTratamento " +
            "WHERE pedido.id = :idPedido " +
            "ORDER BY pedido.id DESC")
    List<HistoricoTratamento> recuperarHistoricos(@Param("idPedido") Long idPedido);

    @Query("SELECT count(historicoTratamento) FROM HistoricoTratamento historicoTratamento " +
            "WHERE historicoTratamento.pedido.id = :idPedido AND historicoTratamento.tipoTratamento.id IN (3, 4, 5) ")
    Long CountTratamentoFinalPedido(@Param("idPedido") Long idPedido);
}
