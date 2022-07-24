package br.com.company.fks.repositorio;

import br.com.company.fks.modelo.Subunidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubunidadeRepository extends JpaRepository<Subunidade, Long> {

    @Query("SELECT subunidade FROM Subunidade subunidade " +
            "JOIN FETCH subunidade.unidade " +
            "WHERE subunidade.id = :id")
    Subunidade buscarUnidadeSubunidadePorId(@Param("id") Long id);

    @Query("SELECT subunidade FROM Subunidade subunidade JOIN FETCH subunidade.unidade " +
            "WHERE (:nomeSubunidade IS NULL OR UPPER(subunidade.nomeSubunidade) LIKE UPPER(:nomeSubunidade)) " +
            "AND (:nomeUnidade IS NULL OR UPPER(subunidade.unidade.nomeUnidade) LIKE UPPER(:nomeUnidade))")
    List<Subunidade> findSubunidades(@Param("nomeSubunidade") String nomeSubunidade, @Param("nomeUnidade") String nomeUnidade);

    Subunidade findFirstByCodigoSubunidade(String codigoSubunidade);

    Long countSubunidadeByCodigoSubunidade(String codigoSubunidade);

    Subunidade findById (Long id);
}