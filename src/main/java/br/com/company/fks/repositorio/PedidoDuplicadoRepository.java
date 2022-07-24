package br.com.company.fks.repositorio;

import br.com.company.fks.modelo.EOuv;
import br.com.company.fks.modelo.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoDuplicadoRepository extends JpaRepository<EOuv, Long> {

    @Query("SELECT pedido FROM Pedido pedido " +
            "JOIN FETCH pedido.statusTramitacao " +
            "WHERE pedido.protocolo = :protocolo ")
    Pedido buscarPedidoPeloProtocolo(@Param("protocolo") String protocolo);
}
