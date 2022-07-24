package br.com.company.fks.repositorio;

import br.com.company.fks.modelo.OrgaoSiorg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrgaoSiorgRepository extends JpaRepository<OrgaoSiorg, Long>{

    OrgaoSiorg findByCodigoOrgao(String codigoOrgao);

    @Query("SELECT orgao FROM OrgaoSiorg orgao LEFT JOIN orgao.unidades unidade LEFT JOIN unidade.subunidade subunidade " +
            "WHERE (:orgaoId IS NULL OR orgao.id = :orgaoId) " +
            "AND (:unidadeId IS NULL OR unidade.id = :unidadeId) " +
            "AND ((:subunidade) IS NULL OR subunidade.id IN (:subunidade))")
    List<OrgaoSiorg> findOrgaoUnidadeSubunidade(
            @Param("orgaoId") Long orgaoId,
            @Param("unidadeId") Long unidadeId,
            @Param("subunidade") List<Long> subunidade);
}
