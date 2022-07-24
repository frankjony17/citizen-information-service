package br.com.company.fks.repositorio;

import br.com.company.fks.modelo.Subtema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubtemaRepository extends JpaRepository<Subtema, Long> {

    Subtema findById(Long id);

    @Query("SELECT distinct st from Subtema st where st.tema.id = :tema")
    List<Subtema> findAllByTema(@Param("tema") Long idTema);

    @Query("SELECT subtema FROM Subtema subtema " +
            "JOIN FETCH subtema.tema " +
            "JOIN FETCH subtema.palavrasChaves " +
            "WHERE subtema.id = :id")
    Subtema buscarSubtemaPorId(@Param("id") Long id);

    Subtema findByNomeSubtema(String nomeSubtema);

    @Query("SELECT subtema FROM Subtema subtema " +
         "WHERE subtema.nomeSubtema = :nomeSubtema AND subtema.id <> :id")
    Subtema findByNomeSubtemaDiferenteId(@Param("nomeSubtema") String nomeSubtema, @Param("id") Long id);

}
