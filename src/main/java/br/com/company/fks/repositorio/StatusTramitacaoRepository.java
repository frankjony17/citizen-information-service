package br.com.company.fks.repositorio;

import br.com.company.fks.modelo.StatusTramitacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusTramitacaoRepository extends JpaRepository<StatusTramitacao, Long> {
}
