package br.com.company.fks.repositorio;

import br.com.company.fks.modelo.Alertas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlertasRepository extends JpaRepository<Alertas, Long>{

}
