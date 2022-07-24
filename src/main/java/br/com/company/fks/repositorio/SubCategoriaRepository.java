package br.com.company.fks.repositorio;

import br.com.company.fks.modelo.SubCategoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubCategoriaRepository extends JpaRepository<SubCategoria, Long> {

    @Query("SELECT distinct s from SubCategoria s order by s.descricao ASC ")
    List<SubCategoria> findAllByDescricao();

    @Query("select distinct s from SubCategoria s where s.categoria.id = :categoria order by s.descricao asc")
    List<SubCategoria> findAllByCategoria(@Param("categoria") Long idCategoria);
}
