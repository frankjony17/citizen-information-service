package br.com.company.fks.repositorio;

import br.com.company.fks.modelo.StatusTramitacaoRecurso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusTramitacaoRecursoRepository extends JpaRepository<StatusTramitacaoRecurso, Long> {
}
