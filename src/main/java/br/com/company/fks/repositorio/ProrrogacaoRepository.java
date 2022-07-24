package br.com.company.fks.repositorio;

import br.com.company.fks.modelo.Pedido;
import br.com.company.fks.modelo.Prorrogacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProrrogacaoRepository extends JpaRepository<Prorrogacao, Long> {

    @Query("SELECT prorrogacao FROM Prorrogacao prorrogacao " +
            "WHERE prorrogacao.pedido = :pedido " +
            "AND prorrogacao.eSic = :isESic ")
    Prorrogacao consultarProrrogacaoPorIdPedido(@Param("pedido") Pedido pedido, @Param("isESic") boolean isESic);

}
