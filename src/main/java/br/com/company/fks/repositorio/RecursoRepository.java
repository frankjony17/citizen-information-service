package br.com.company.fks.repositorio;

import br.com.company.fks.modelo.Pedido;
import br.com.company.fks.modelo.Recurso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecursoRepository extends JpaRepository<Recurso, Long> {

    String SELECT_RECURSO_FROM_RECURSO_RECURSO = "SELECT recurso FROM Recurso recurso ";

    @Query(SELECT_RECURSO_FROM_RECURSO_RECURSO +
            "WHERE recurso.protocoloPedido = :protocolo")
    List<Recurso> recuperarRecursoPeloProtocolo(@Param("protocolo") String protocolo);

    @Query(SELECT_RECURSO_FROM_RECURSO_RECURSO +
            "JOIN FETCH recurso.statusTramitacao " +
            "WHERE recurso.id = :id")
    Recurso findById(@Param("id") Long id);

    @Query(SELECT_RECURSO_FROM_RECURSO_RECURSO +
            "WHERE recurso.pedido = :pedido ORDER BY recurso.instanciaRecurso.id asc " )
    List<Recurso> buscarIdRecurso(@Param("pedido") Pedido pedido);

    @Query(SELECT_RECURSO_FROM_RECURSO_RECURSO +
            "JOIN FETCH recurso.pedido " +
            "WHERE recurso.id = :idRecurso")
    Recurso buscarIdPedido(@Param("idRecurso") Long idRecurso);

    @Query(SELECT_RECURSO_FROM_RECURSO_RECURSO +
            "JOIN FETCH recurso.statusSolicitacao " +
            "WHERE recurso.id = :id")
    Recurso buscarRecursoEStatusSolicitacao(@Param("id") Long id);

    @Query("SELECT recurso FROM Recurso recurso where recurso.protocoloPedido = :protocolo ORDER BY recurso.instanciaRecurso.id ")
    List<Recurso> buscarProtocoloPedido(@Param("protocolo") String protocolo);

    List<Recurso> findAllByStatusSolicitacaoId (Long idRecurso);
}
