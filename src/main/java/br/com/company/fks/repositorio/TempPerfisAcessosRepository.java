package br.com.company.fks.repositorio;

import br.com.company.fks.modelo.TempPerfisAcessos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TempPerfisAcessosRepository extends JpaRepository<TempPerfisAcessos, Long>{

}
