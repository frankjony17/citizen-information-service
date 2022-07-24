package br.com.company.fks.repositorio;

import br.com.company.fks.modelo.AndamentoRecurso;
import br.com.company.fks.modelo.Recurso;
import br.com.company.fks.modelo.UsuarioAcessos;
import br.com.company.fks.modelo.dto.AndamentoRecursoDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AndamentoRecursoRepository extends JpaRepository<AndamentoRecurso, Long> {

    @Query("SELECT andamento FROM AndamentoRecurso andamento " +
            "WHERE recurso.id = :idRecurso " +
            "ORDER BY andamento.dataInicio DESC")
    List<AndamentoRecurso> recuperarAndamentoRecurso(@Param("idRecurso") Long idRecurso);

    @Query("SELECT new br.gov.mpog.fks.modelo.dto.AndamentoRecursoDTO(andamento.unidade, andamento.dataInicio, andamento.dataFim," +
            "andamento.responsavel, andamento.observacao, status.nome) from AndamentoRecurso andamento " +
            "JOIN andamento.statusTramitacaoRecurso status " +
            "WHERE andamento.recurso = :recurso " +
            "ORDER BY andamento.id DESC")
    Page<AndamentoRecursoDTO> recuperarAndamentoRecursoEStatusTramitacao(@Param("recurso") Recurso recurso, Pageable pageable);

    @Query("SELECT andamento FROM AndamentoRecurso andamento " +
            "WHERE recurso.id = :idRecurso " +
            "ORDER BY andamento.id ASC")
    List<AndamentoRecurso> findByPedido(@Param("idRecurso") Long idRecurso);

    @Query("SELECT usuario FROM  AndamentoRecurso  andamento " +
            "JOIN  andamento.usuarioAcessos usuario" +
            " WHERE andamento.recurso = :recurso" +
            " AND andamento.id = (SELECT max (andamento2.id) FROM AndamentoRecurso andamento2 join andamento2.usuarioAcessos )")
    UsuarioAcessos buscarUsuario(@Param("recurso") Recurso recurso);

    AndamentoRecurso findTopByRecursoIdAndStatusSolicitacaoRecursoId (Long idRecurso, Long idStatusSolicitacao);


}
