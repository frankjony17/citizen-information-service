package br.com.company.fks.repositorio;

import br.com.company.fks.modelo.MotivoProrrogacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MotivoProrrogacaoRepository extends JpaRepository<MotivoProrrogacao, Long> {
}
