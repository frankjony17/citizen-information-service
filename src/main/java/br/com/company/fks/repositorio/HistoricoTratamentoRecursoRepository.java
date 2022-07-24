package br.com.company.fks.repositorio;

import br.com.company.fks.modelo.HistoricoTratamentoRecurso;
import br.com.company.fks.modelo.Recurso;
import br.com.company.fks.modelo.dto.ConsultaHistoricoRecursoDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistoricoTratamentoRecursoRepository extends JpaRepository<HistoricoTratamentoRecurso, Long> {

    @Query("SELECT historicoTratamentoRecurso FROM HistoricoTratamentoRecurso historicoTratamentoRecurso " +
            "WHERE recurso.id = :idRecurso ")
    List<HistoricoTratamentoRecurso> recuperarRespostaHistoricoPorIdRecurso(@Param("idRecurso") Long idRecurso);

    @Query("SELECT new br.gov.mpog.fks.modelo.dto.ConsultaHistoricoRecursoDTO(historicoTratamento.id, historicoTratamento.data, historicoTratamento.nomeResponsavel, tratamento.tipoTratamentoRecurso) from HistoricoTratamentoRecurso historicoTratamento " +
            "JOIN historicoTratamento.tipoTratamentoRecurso tratamento " +
            "WHERE historicoTratamento.recurso = :recurso " +
            "ORDER BY historicoTratamento.id ASC")
    Page<ConsultaHistoricoRecursoDTO> recuperarHistoricoRecurso(@Param("recurso") Recurso recurso, Pageable pageable);

    @Query("SELECT historicoTratamento FROM HistoricoTratamentoRecurso historicoTratamento " +
            "WHERE recurso.id = :idRecurso ")
    List<HistoricoTratamentoRecurso> recuperarHistoricoPorIdPedido(@Param("idRecurso") Long idRecurso);
}
