package br.com.company.fks.repositorio;

import br.com.company.fks.modelo.SituacaoPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SituacaoPedidoRepository extends JpaRepository<SituacaoPedido, Long> {

    SituacaoPedido findByNome(@Param("nomeSituacaoPedido") String nomeSituacaoPedido);
}
