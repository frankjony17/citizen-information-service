package br.com.company.fks.repositorio;

import br.com.company.fks.modelo.TempOrgaoSiorgAcesso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TempOrgaoSiorgAcessoRepository extends JpaRepository<TempOrgaoSiorgAcesso, Long>{
    List<TempOrgaoSiorgAcesso> findAllByAtivoTrue();
}
