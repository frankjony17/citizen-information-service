package br.com.company.fks.repositorio;

import br.com.company.fks.modelo.ClassificarRespostaSic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassificarRespostaSicRepository extends JpaRepository<ClassificarRespostaSic, Long> {

    ClassificarRespostaSic findById(Long id);

}
