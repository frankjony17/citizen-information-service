package br.com.company.fks.repositorio;

import br.com.company.fks.modelo.TipoClassificacaoResposta;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TipoClassificacaoRespostaRepository extends JpaRepository<TipoClassificacaoResposta, Long> {
    TipoClassificacaoResposta findById(Long id);

    @Query("SELECT distinct t from TipoClassificacaoResposta t order by t.descricao asc")
    List<TipoClassificacaoResposta> findAllOrderByNome();

    @Query("SELECT DISTINCT tipo from TipoClassificacaoResposta tipo LEFT JOIN tipo.classificacaoRespostas classificacaoResposta " +
            "WHERE (:idTipoClassificacaoResposta IS NULL OR tipo.id = :idTipoClassificacaoResposta) " +
            "AND (:nomeClassificacao IS NULL OR classificacaoResposta.descricao = :nomeClassificacao)")
    Page<TipoClassificacaoResposta> findTipoClassificacaoResposta(
            @Param("idTipoClassificacaoResposta") Long idTipoClassificacaoResposta,
            @Param("nomeClassificacao") String nomeClassificacao, Pageable pageable
    );

    @Query("SELECT COUNT(DISTINCT tipo) from TipoClassificacaoResposta tipo LEFT JOIN tipo.classificacaoRespostas classificacaoResposta " +
            "WHERE (:idTipoClassificacaoResposta IS NULL OR tipo.id = :idTipoClassificacaoResposta) " +
            "AND (:nomeClassificacao IS NULL OR classificacaoResposta.descricao = :nomeClassificacao)")
    Long countTipoClassificacaoResposta(
            @Param("idTipoClassificacaoResposta") Long idTipoClassificacaoResposta,
            @Param("nomeClassificacao") String nomeClassificacao
    );
}
