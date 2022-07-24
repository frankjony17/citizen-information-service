package br.com.company.fks.repositorio;

import br.com.company.fks.modelo.Pedido;
import br.com.company.fks.modelo.ReencaminharSolicitacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReencaminharSolicitacaoRepository extends JpaRepository<ReencaminharSolicitacao, Long> {

    List<ReencaminharSolicitacao> findByPedido (@Param("pedido") Pedido pedido);

}
