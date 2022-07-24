package br.com.company.fks.repositorio;

import br.com.company.fks.modelo.Solicitante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface SolicitanteRepository extends JpaRepository<Solicitante, Long> {

    Solicitante findByCpfOuCnpj(@Param("cpfOuCnpj") String cpfOuCnpj);
}
