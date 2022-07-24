package br.com.company.fks.repositorio;

import br.com.company.fks.modelo.Responsaveis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResponsaveisRepository extends JpaRepository<Responsaveis, Long>{

    Responsaveis findByUnidadeId(Long idUnidade);

    Responsaveis findTopByOrderByIdDesc();
}
