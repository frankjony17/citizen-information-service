package br.com.company.fks.repositorio;

import br.com.company.fks.modelo.TempUnidadeSiorgAcesso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TempUnidadeSiorgAcessoRepository extends JpaRepository<TempUnidadeSiorgAcesso, Long>{

    TempUnidadeSiorgAcesso findFirstByCodigoUg(String codigoUg);

    List<TempUnidadeSiorgAcesso> findAllByUnidadePaiIdAndAtivoTrue(Long orgaoId);

    List<TempUnidadeSiorgAcesso> findAllByTempOrgaoSiorgAcessoCodigoUgAndAtivoTrue (String codigoUg);
}
