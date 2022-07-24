package br.com.company.fks.repositorio;

import br.com.company.fks.modelo.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    @Query("select distinct c from Categoria c order by c.descricao asc")
    List<Categoria> findAllOrderByDescricao();


}
