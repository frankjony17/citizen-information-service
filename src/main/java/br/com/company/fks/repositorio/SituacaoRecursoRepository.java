package br.com.company.fks.repositorio;

import br.com.company.fks.modelo.SituacaoRecurso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SituacaoRecursoRepository extends JpaRepository<SituacaoRecurso, Long> {
}
