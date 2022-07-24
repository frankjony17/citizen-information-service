package br.com.company.fks.repositorio;

import br.com.company.fks.modelo.Pedido;
import br.com.company.fks.modelo.Solicitante;
import br.com.company.fks.modelo.dto.ConsultaPedidoDulplicadoDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    @Query("SELECT pedido FROM Pedido pedido " +
            "JOIN FETCH pedido.solicitante " +
            "WHERE pedido.protocolo = :protocolo")
    Pedido recuperarPedidoPeloProtocolo(@Param("protocolo") String protocolo);

    @Query("SELECT pedido FROM Pedido pedido " +
            "JOIN FETCH pedido.statusTramitacao " +
            "WHERE pedido.id = :id")
    Pedido findById(@Param("id") Long id);

    @Query("SELECT pedido FROM Pedido pedido " +
            "JOIN FETCH pedido.statusSolicitacao " +
            "WHERE pedido.id = :id")
    Pedido buscarPedidoEStatusSolicitacao(@Param("id") Long id);

    Pedido findByProtocolo(@Param("protocolo") String protocolo);

    @Query("SELECT new br.gov.mpog.fks.modelo.dto.ConsultaPedidoDulplicadoDTO(pedido.id, pedido.protocolo, statusSolicitacao.nome, pedido.vencimentoUnidade) from Pedido pedido " +
            "JOIN pedido.statusSolicitacao statusSolicitacao " +
            "WHERE pedido.solicitante = :solicitante")
    Page<ConsultaPedidoDulplicadoDTO> consultarPedidoSolicitante(@Param("solicitante") Solicitante solicitante, Pageable pageable);

    List<Pedido> findAllByStatusSolicitacaoId (Long idPedido);
}
