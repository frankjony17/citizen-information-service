package br.com.company.fks.repositorio;

import br.com.company.fks.modelo.StatusSolicitacaoRecurso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusSolicitacaoRecursoRepository extends JpaRepository<StatusSolicitacaoRecurso, Long> {
}
