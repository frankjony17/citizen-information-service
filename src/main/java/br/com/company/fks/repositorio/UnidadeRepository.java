package br.com.company.fks.repositorio;

import br.com.company.fks.modelo.Unidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UnidadeRepository extends JpaRepository<Unidade, Long> {

    @Query("SELECT unidade FROM Unidade unidade " +
            "WHERE unidade.nomeUnidade = :nomeUnidade")
    Unidade buscaUnidadePeloNome(@Param("nomeUnidade") String nomeUnidade);

    Unidade findByCodigoUnidade(String codigo);

    List<Unidade> findByOrgaoSiorgCodigoOrgao(String codigoOrgao);

    Unidade findById(Long id);
}
