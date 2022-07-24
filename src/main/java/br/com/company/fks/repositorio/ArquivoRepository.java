package br.com.company.fks.repositorio;

import br.com.company.fks.modelo.Arquivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArquivoRepository extends JpaRepository<Arquivo, Long> {

    @Query("SELECT a FROM Arquivo a WHERE a.id IN(:ids)")
    List<Arquivo> findByIds(@Param("ids") List<Long> ids);
}
