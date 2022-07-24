package br.com.company.fks.repositorio;

import br.com.company.fks.modelo.StatusSituacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusSituacaoRepository extends JpaRepository<StatusSituacao, Long> {
}
