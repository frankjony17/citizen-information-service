package br.com.company.fks.repositorio;

import br.com.company.fks.modelo.TipoResposta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TipoRespostaRepository extends JpaRepository<TipoResposta, Long> {

    @Query("select distinct tr from TipoResposta tr order by tr.descricao asc")
    List<TipoResposta> findAllOrderByDescricao();
}
