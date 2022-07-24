package br.com.company.fks.repositorio;

import br.com.company.fks.modelo.EmailPerfilAcesso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmailPerfisRepository extends JpaRepository<EmailPerfilAcesso, Long> {

    List<EmailPerfilAcesso> findAllByEmailId (Long idEmail);
}
