package br.com.company.fks.repositorio;

import br.com.company.fks.modelo.TipoTratamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoTratamentoRepository extends JpaRepository<TipoTratamento,Long> {

}
