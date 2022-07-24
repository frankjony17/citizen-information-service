package br.com.company.fks.repositorio;

import br.com.company.fks.modelo.Tema;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TemaRepository extends JpaRepository<Tema, Long> {

     Tema findById(Long id);

     Tema findByNomeTema(String nomeTema);

     @Query("SELECT DISTINCT tema FROM Tema tema LEFT JOIN tema.subtemas sub " +
             "WHERE (:idTema IS NULL OR tema.id = :idTema) AND (:nomeSubtema IS NULL OR sub.nomeSubtema = :nomeSubtema) ORDER BY tema.nomeTema")
     Page<Tema> findGlossarioDeTemas (@Param("idTema") Long idTema, @Param("nomeSubtema") String nomeSubtema, Pageable pageable);

     @Query("SELECT COUNT(DISTINCT tema) FROM Tema tema LEFT JOIN tema.subtemas sub " +
             "WHERE (:idTema IS NULL OR tema.id = :idTema) AND (:nomeSubtema IS NULL OR sub.nomeSubtema = :nomeSubtema)")
     Long countGlossarioDeTemas (@Param("idTema") Long idTema, @Param("nomeSubtema") String nomeSubtema);
}