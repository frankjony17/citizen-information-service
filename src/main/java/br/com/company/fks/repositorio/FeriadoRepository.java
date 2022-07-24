package br.com.company.fks.repositorio;

import br.com.company.fks.modelo.Feriado;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Calendar;

@Repository
public interface FeriadoRepository extends JpaRepository<Feriado, Long> {

    Long countByDataFeriado (Calendar dataFeriado);

    @Query("SELECT feriado FROM Feriado feriado WHERE " +
            "(CAST(:periodoInicialFeriado AS date) IS NULL OR feriado.dataFeriado >= :periodoInicialFeriado) AND " +
            "(CAST(:periodoFinalFeriado AS date) IS NULL OR feriado.dataFeriado <= :periodoFinalFeriado)")
    Page<Feriado> findFeriados(
            @Param("periodoInicialFeriado") Calendar periodoInicialFeriado,
            @Param("periodoFinalFeriado") Calendar periodoFinalFeriado,
            Pageable pageable
    );

    @Query("SELECT COUNT(feriado) FROM Feriado feriado WHERE " +
            "(CAST(:periodoInicialFeriado AS date) IS NULL OR feriado.dataFeriado >= :periodoInicialFeriado) AND " +
            "(CAST(:periodoFinalFeriado AS date) IS NULL OR feriado.dataFeriado <= :periodoFinalFeriado)")
    Long countFeriados(@Param("periodoInicialFeriado") Calendar periodoInicialFeriado, @Param("periodoFinalFeriado") Calendar periodoFinalFeriado);
}
