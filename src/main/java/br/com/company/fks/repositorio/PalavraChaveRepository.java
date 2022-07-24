package br.com.company.fks.repositorio;

import br.com.company.fks.modelo.PalavraChave;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PalavraChaveRepository extends JpaRepository<PalavraChave, Long> {

    @Query("select distinct pc from PalavraChave pc order by pc.descricao asc")
    List<PalavraChave> findAllOrderByDescricao();

}
