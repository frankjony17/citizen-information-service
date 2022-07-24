package br.com.company.fks.repositorio;

import br.com.company.fks.modelo.TipoRespostaRecurso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoRespostaRecursoRepository extends JpaRepository<TipoRespostaRecurso, Long> {
}
