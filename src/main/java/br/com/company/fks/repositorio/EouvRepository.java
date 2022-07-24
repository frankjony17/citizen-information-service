package br.com.company.fks.repositorio;

import br.com.company.fks.modelo.EOuv;
import br.com.company.fks.modelo.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EouvRepository extends JpaRepository<EOuv, Long> {

    @Query("SELECT eOuv FROM EOuv eOuv " +
            "WHERE eOuv.pedido = :pedido ")
    EOuv findByEOuvPorIdPedido(@Param("pedido") Pedido pedido);
}
