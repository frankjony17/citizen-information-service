package br.com.company.fks.repositorio;

import br.com.company.fks.modelo.StatusSolicitacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusSolicitacaoRepository extends JpaRepository<StatusSolicitacao, Long> {
}
