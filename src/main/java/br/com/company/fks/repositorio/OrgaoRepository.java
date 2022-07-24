package br.com.company.fks.repositorio;

import br.com.company.fks.modelo.Orgao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrgaoRepository extends JpaRepository<Orgao, Long>{

    @Query("select distinct o from Orgao o order by o.descricao asc")
    List<Orgao> findAllOrderByDescricao();
}
